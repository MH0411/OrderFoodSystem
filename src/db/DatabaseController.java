package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseController {
	Connection conn;
	
	public Connection getConnection() throws SQLException, 
			ClassNotFoundException {
		final String URL = "jdbc:mysql://localhost:3306/orderfoodsystemdb";
	    final String USERNAME = "root";
	    final String PASSWORD = "gameover";
		
		return DriverManager.
					getConnection(URL, USERNAME, PASSWORD);
	}
}
