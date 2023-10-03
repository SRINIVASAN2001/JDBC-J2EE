package jdbc.insert;

import java.sql.*;

public class Jdbc_Select {

	public static void main(String[] args) throws SQLException
	{
		//step-1
				Driver driver=new com.mysql.cj.jdbc.Driver();
				DriverManager.registerDriver(driver);

				//step-2
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
				
				//step-3
				Statement st=conn.createStatement();
				String query="select emp_id,emp_name from employee_data";
				
				//step-4
				ResultSet rs=st.executeQuery(query);
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
				}
				
				//strp-5
				conn.close();
		

	}

}
