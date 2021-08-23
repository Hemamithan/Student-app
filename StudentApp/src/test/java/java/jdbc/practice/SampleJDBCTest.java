package java.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCTest {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try{
		//step 1:register/load the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		
		//step 2:connect to database
		Connection conn1 = DriverManager.getConnection("jdbc:mysql://lcalhost:3306/students", "root", "root");
		
		
		//step 3:issue/create SQL statement
		Statement stat = conn1.createStatement();
		
		
		
		//step 4: execute query
		ResultSet resultset = stat.executeQuery("select * from students_info");
		
		//display
		while( resultset.next())
		{
			System.out.println( resultset.getInt(1)+"\t" +  resultset.getInt(2)+ "\t"+ resultset.getInt(3));
		}
   }	catch(Exception e) {
       }finally {
   }
		//step 5:close the connection
		
		System.out.println("....done....");
		conn.close();
	}

}
