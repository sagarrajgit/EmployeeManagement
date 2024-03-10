package com.java.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static Connection connection;
	public static Connection getConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "Sagar@007");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
