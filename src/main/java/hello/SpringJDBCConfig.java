package hello;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.UserDAO;

@Configuration
@ComponentScan("hello")
public class SpringJDBCConfig {

	@Bean
	public DataSource mySqlDataSource(){
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/music");
		dataSource.setUsername("root");
		dataSource.setPassword("1982Varun");
		
		return dataSource;
	}
	
		@Bean 
	    public UserDAO userBean(){
	    	
	    	return new UserDAO();
	    }
}
