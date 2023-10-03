package jdbc_PrepareStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Execute_method
{
	public static void main(String[] args) throws SQLException, IOException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ELCOT\\eclipse-workspace\\jdbc\\src\\abc.properties");
		Properties p=new Properties(); //class which is present in util package
		p.load(fis);
		
		String url=p.getProperty("url");//used to get the url using key name
		Connection conn =DriverManager.getConnection(url,p);
		
		Statement st=conn.createStatement();
		
		boolean res = st.execute("select * from employee_data");
		System.out.println(res);
		
		ResultSet rs=st.getResultSet();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(3));
		}
		conn.close();
	}

}
