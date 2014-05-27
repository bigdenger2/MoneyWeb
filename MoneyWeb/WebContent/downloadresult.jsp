<%@ page contentType="application/octet-stream; charset=UTF-8"
  import="java.sql.*, javax.naming.*, javax.sql.*,java.text.*"%><%

  response.setHeader("Content-Disposition", "attachment; filename=dl.txt");
  String table = request.getParameter("table").replace("'","''");
  Connection db = null;
  PreparedStatement ps = null;
  ResultSet rs = null;

  	try{
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/MoneyWeb");
		db = ds.getConnection();
		ps = db.prepareStatement("SELECT * FROM " + table);
    	rs = ps.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
    	for(int i = 1;i <= meta.getColumnCount(); i++){
    		out.print(meta.getColumnName(i) + "\t");
   	 	}
    out.print("\r\n");
    while(rs.next()) {
    	for(int i = 1;i <= meta.getColumnCount(); i++){
        	out.print(rs.getString(i) + "\t");
        	}
        	out.print("\r\n");
        }
    }catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null){rs.close();}
			if(ps != null){ps.close();}
			if(db != null){db.close();}
		}catch(Exception e){}
	}
%>     	