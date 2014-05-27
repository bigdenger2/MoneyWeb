<%@ page contentType="text/html; charset=UTF-8"
  import="java.sql.*, javax.naming.*, javax.sql.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ダウンロードフォーム</title>
</head>
<body>
<form method="POST" action="downloadresult.jsp">
<select name="table">
<%
Connection db = null;
ResultSet rs = null;
try{
	Context context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/MoneyWeb");
	db = ds.getConnection();
	DatabaseMetaData meta = db.getMetaData();
	rs =  meta.getTables("test", "%", "%", null);
	while(rs.next()){
	String table = rs.getString("TABLE_NAME");
	out.println("<option value='" + table + "'>" + table + "</option>");
	}
	} catch(Exception e){
		throw new ServletException(e);
	}finally{
		try{
			if(rs != null) {rs.close();}
			if(db != null) {db.close();}
		} catch(Exception e) {}
	}
%>
</select>
<input type="submit" value="ダウンロード" />
</form>
</body>
</html>