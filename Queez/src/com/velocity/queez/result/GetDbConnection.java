package com.velocity.queez.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDbConnection {
	
	Connection con = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return con;
	}
}
