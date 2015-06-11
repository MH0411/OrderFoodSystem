package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class represent the connection between application and database.
 * @author JKGan
 *
 */

public class DatabaseController {
	/**
	 * This method loads database driver and establish connection
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws SQLException, 
			ClassNotFoundException {
		// Initialize URL, USERNAME and PASSWORD
		final String URL = "jdbc:mysql://localhost:3306/order_food_system_db";
	    final String USERNAME = "root";
	    final String PASSWORD = "";
		
	    // Establish connection
		return DriverManager.
					getConnection(URL, USERNAME, PASSWORD);
	}
}
