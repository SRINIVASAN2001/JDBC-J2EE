package jdbc_PrepareStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Dynamic_query_Dml
{
	public static void main(String[] args)throws SQLException, IOException
	{
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		//method-1 of Get Connection
		//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
		
		//method-2
		//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root & password=1234");
		
		//method-3
		FileInputStream fis=new FileInputStream("C:\\Users\\ELCOT\\eclipse-workspace\\jdbc\\src\\abc.properties");
		Properties p=new Properties(); //class which is present in util package
		p.load(fis);
		
		String url=p.getProperty("url");//used to get the url using key name
		Connection conn =DriverManager.getConnection(url,p);
		
		//PreparedStatement pst=conn.prepareStatement("update employee_data set city=? where emp_id=12");
		PreparedStatement pst=conn.prepareStatement("delete from employee_data where emp_id=?");
		
		Scanner sc=new Scanner(System.in);
		
		//System.out.println("Enter the city ");
		//String city=sc.next();
		//pst.setString(1, city);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		pst.setInt(1, id);
		
		int res=pst.executeUpdate();
		System.out.println(res+"Rows affected");
		
		conn.close();
		
	}

}
