package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserDAO {

	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	 public void setDataSource(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	
	int userId;
	String name; 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addUser(String name){
		
		jdbcTemplate.execute("INSERT INTO `music`.`User` (`name`) VALUES ('"+name+"')");
	}
    public List<String> getUser(int id){
		List<String> names =jdbcTemplate.query("select name from music.USER where id='"+id+"'",
				new ResultSetExtractor<List<String>>(){  
		    @Override  
		     public List<String> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<String> list=new ArrayList<String>();  
		        while(rs.next()){
		        	System.out.println(rs.toString());
		        list.add(rs.getString(1));  
		        }  
		        return list;  
		        }  
		    });
		
		return names;
	}

  public void deleteUser(int id){
	  jdbcTemplate.execute("DELETE FROM `music`.`User` WHERE id="+id);
}
  public boolean updateUser(int id ,String name){
	  jdbcTemplate.execute("UPDATE `music`.`User` SET `name` = '"+name+"' WHERE `id` = "+id);
	return false;
}
}
