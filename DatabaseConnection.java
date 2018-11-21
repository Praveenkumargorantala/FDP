package com.epam.dbconnection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public DatabaseConnection(){
		super();
	}
	
	public static Connection getConnection() {
	
		try{
			System.out.println("before loading driver");
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("after loading driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		Connection connection;
			
		try {
			System.out.println("before connection");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/updateidproof","root","root");
			System.out.println("after connection");
			return connection;
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
