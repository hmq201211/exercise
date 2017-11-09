package test;

import java.sql.*;

public class PlsqlDemo {

public static void main(String arg[]) throws Exception

{
	//load the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//get the connection object
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "HMQ123hmq");
	
	//create the statement object
	Statement stmt=conn.createStatement();
	
	//execute query
	stmt.execute("create or replace function RaiseSal(name CHAR, raise NUMBER) return NUMBER is begin "
			+ "return raise + 100000; end;");
	
	//close the statement
	stmt.close();
	
	
	//calling functions/procedures
	
	CallableStatement cstmt = conn.prepareCall("{? = call RaiseSal(?,?)}");
		
	// Declare that the first ? is a return value of type int
	cstmt.registerOutParameter(1, Types.INTEGER);
	cstmt.setString(2, "Alice"); // The name argument is the second ?
	cstmt.setInt(3, 5000); // The raise argument is the third ?
		
	// Do the raise
	cstmt.execute();
	
	int new_salary = cstmt.getInt(1);
	
	System.out.println("The new salary is: " + new_salary);
	
	//close the connection object
	cstmt.close();
	conn.close();
}
	
	
}