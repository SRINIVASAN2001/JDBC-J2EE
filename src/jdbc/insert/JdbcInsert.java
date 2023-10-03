package jdbc.insert;
import java.sql.*;

public class JdbcInsert
{
	public static void main(String[] args) throws SQLException
	{
		//step-1
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);

		//step-2
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
		
		//step-3
		Statement st=conn.createStatement();
		String query="insert into employee_data values(2,'FireFaayiz','ChepaukChikko',109474775)";
		//String query="update employee_data set city='chennai' where emp_id=1";
		//String query="delete from employee_data where emp_id=2";
		
		//step-4
		int result=st.executeUpdate(query);
		System.out.println(result+"rows affected");
		
		//strp-5
		conn.close();
	}
}
