package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "akki@123");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
