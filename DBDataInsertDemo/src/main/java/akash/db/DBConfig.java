package akash.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/POS";
		String username = "root";
		String password = "akki@123";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;

	}

}
