package jdbc.insert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Update {

	public static void main(String[] args) throws SQLException
	{
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);

		//step-2
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
		
		//step-3
		Statement st=conn.createStatement();
		
		String query="update employee_data set city='chennai' where emp_id=4";
		
		
		//step-4
		int result=st.executeUpdate(query);
		System.out.println(result+"rows affected");
		
		//strp-5
		conn.close();
		
	}

}
