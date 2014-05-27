package MoneyWeb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import MoneyWeb.entity.MoneyWebValueObject;

public class MoneyWebDAO extends MoneyWebMySQL {

	public List<MoneyWebValueObject> MoneyWeb_List() throws Exception {
		
		List<MoneyWebValueObject> returnList = new ArrayList<MoneyWebValueObject>();

		String sql = " SELECT date, title, task, inputmoney, outputmoney, lastmoney "; 

		PreparedStatement statement = getPreparedStatement(sql);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			MoneyWebValueObject vo = new MoneyWebValueObject();

			vo.setDate(rs.getString("date"));
			vo.setTitle(rs.getString("title"));
			vo.setTask(rs.getString("task"));
			vo.setInputMoney(rs.getInt("inputmoney"));
			vo.setOutputMoney(rs.getInt("outputmoney"));
			vo.setLastMoney(rs.getInt("lastmoney"));
			
			returnList.add(vo);
		}

		return returnList;
	}

	public MoneyWebValueObject detail(int id) throws Exception {

		MoneyWebValueObject vo = new MoneyWebValueObject();

		String sql = " SELECT id, title, task, inputLimitdate, inputLastupdate, userid, td.status ,fileName, label "
				+ " FROM todo_list td LEFT JOIN status_list stts ON stts.status = td.status"
				+ " WHERE id  = ?"; 
				
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			vo.setId(rs.getInt("id"));
			vo.setTitle(rs.getString("title"));
			vo.setTask(rs.getString("task"));
			vo.setInputLimitdate(rs.getString("inputLimitdate"));
			vo.setInputLastupdate(rs.getString("inputLastupdate"));
			vo.setUserid(rs.getString("userid"));
			vo.setStatus(rs.getInt("status"));
			vo.setFileName(rs.getString("fileName"));
			vo.setLabel(rs.getString("label"));
		}
		return vo;
	}

	public int registerInsert(MoneyWebValueObject vo) throws Exception{

		String sql = "INSERT INTO todo_list (id, title, task, inputLimitdate, inputLastupdate, userid, status, fileName) "
				+ " VALUES(?,?,?,?,?,?,?,?)";

		int result = 0;

		try{
			PreparedStatement statement = getPreparedStatement(sql);

			statement.setInt(1, vo.getId());
			statement.setString(2, vo.getTitle());
			statement.setString(3, vo.getTask());
			statement.setString(4, vo.getInputLimitdate());
			statement.setString(5, vo.getInputLastupdate());
			statement.setString(6, vo.getUserid());
			statement.setInt(7, vo.getStatus());
			statement.setString(8, vo.getFileName());
			//statement.setString(9, vo.getLabel());
			
			
			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e){
			super.rollback();
			throw e;
		}

		return result;
	}

	public int registerUpdate(MoneyWebValueObject vo) throws Exception{
		String sql = "UPDATE todo_list SET title = ?, task = ? ,inputLimitdate = ?"
				+ ", inputLastupdate = ?, userid = ? , status = ?, fileName = ? where id = ?";

		int result = 0;

		try{
			PreparedStatement statement = getPreparedStatement(sql);

			statement.setString(1, vo.getTitle());
			statement.setString(2, vo.getTask());
			statement.setString(3, vo.getInputLimitdate());
			statement.setString(4, vo.getInputLastupdate());
			statement.setString(5, vo.getUserid());
			statement.setInt(6, vo.getStatus());
			statement.setString(7, vo.getFileName());
			//statement.setString(8, vo.getLabel());
			statement.setInt(8, vo.getId());
			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e){
			super.rollback();
			throw e;
		}

		return result;
	}

	public int delete(int id) throws Exception{
		String sql = "DELETE FROM todo_list where id = ?";

		int result = 0;

		try{
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, id);
			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e){
			super.rollback();
			throw e;
		}
		return result;
	}

	public int updateUploadInfo(MoneyWebValueObject vo) throws Exception{

		String sql = "UPDATE todo_list set fileName = ? WHERE id = ?";
		int result = 0;

		try{
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, vo.getFileName());
			statement.setInt(2, vo.getId());

			result = statement.executeUpdate();
			super.commit();
		}catch(Exception e){
			throw e;
		}
		return result;
	}
}
