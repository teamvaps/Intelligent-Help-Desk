package edu.cpp.cs580.sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {

	public static Connection con;
	
	public DBConnect() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/helpdesk", "root", "1234");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}


}
