package fjs.cs.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractCommon {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/customsystem";
			String USER = "root";
			String PASS = "";
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
