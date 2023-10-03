package jdbc_PrepareStatement;
import java.sql.*;
import java.util.Scanner;

public class Dynamic_query {

	public static void main(String[] args) throws SQLException
	{
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
		
		PreparedStatement pst=conn.prepareStatement("insert into employee_data values(?,?,?,?)");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of data to be added");
		int entries=sc.nextInt();
		
		while(entries>0)
		{
			System.out.println("Enter the ID");
			int id=sc.nextInt();sc.nextLine();
			pst.setInt(1, id);
			
			System.out.println("Enter the Employee Name");
			String name=sc.nextLine();
			pst.setString(2, name);
			
			System.out.println("Enter the City");
			String city=sc.nextLine();
			pst.setString(3, city);
			
			System.out.println("Enter the contact");
			long contact=sc.nextLong();
			pst.setLong(4, contact);
			
			entries--;
			
			int result=pst.executeUpdate();
			System.out.println(result+"Rows Affected");
		}
		conn.close();
	}

}
