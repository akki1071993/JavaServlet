package akash.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {
	public static Connection getConnection( Properties p) {
	
		Connection conn = null;
		try {
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("username"), 
					p.getProperty("password"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;

	}

}
