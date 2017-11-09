package test;

import java.sql.*;

public class JdbcDemo {

public static void main(String arg[]) throws Exception

{
	//load the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//get the connection object
//	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","mhou5", "hmq123hmq");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "HMQ123hmq");
//	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","abc", "password");
	
	
	//create the statement object
	Statement st=conn.createStatement();
	
	
	//execute query
	String dept = "Music";
	
	ResultSet rs=st.executeQuery("select * from Instructor where dept_name='"+dept+"'");
	
	//using PreparedStatement for insert (prevent SQL injection attacks)
	Statement st2=conn.createStatement();
	st2.executeUpdate("insert into instructor values('11236', 'Kim', 'Physics', 98000)");
	
	while(rs.next()) {
		System.out.println(rs.getString(1)+ "  "+ rs.getString("Name")+ "  "+ rs.getString("dept_name")+ "  "+ rs.getFloat(4));
	}
	
	
	
	
	//result set Meta data
	
	ResultSetMetaData rsmd = rs.getMetaData();
	
	System.out.println("\nThis gives us the metadata for the resultset\n");
	
	for(int i=1; i<=rsmd.getColumnCount();i++) {
		System.out.println(rsmd.getColumnName(i));
		System.out.println(rsmd.getColumnTypeName(i));
	}
	
	
	
	//Database Meta data
	
	DatabaseMetaData dbmd= conn.getMetaData();
	//ResultSet rs2 = dbmd.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)
	ResultSet rs2 = dbmd.getColumns(null, "%", "INSTRUCTOR", "%");
	
	System.out.println("\nThis gives us the metadata for the database\n");
	
	while(rs2.next()) {
	       System.out.println(rs2.getString("COLUMN_NAME")); 
	       System.out.println(rs2.getString("TYPE_NAME"));
	    	   System.out.println(rs2.getString("COLUMN_SIZE"));
  }
	/*
	*/
	
	//con.commit();
	//con.rollback();
	//con.setAutoCommit(true);
	
	//close the connection object
	st.close();
	conn.close();
}
	
	
}