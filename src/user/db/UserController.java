package user.db;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import user.User;
import db.DatabaseController;

/**
 * This class represent the controller to control the connection and process
 * between User and database.
 * @author JKGan
 *
 */
public class UserController {
	
	private User user;
	private DatabaseController dbController;
	private Connection conn;
	
	public UserController() {
		dbController = new DatabaseController();
	}
	
	public User getUserInfo() {
		return user;
	}

	/**
	 * validate userName and password which user input to login
	 * @param userName username
	 * @param password user's password
	 * @return true if userName and password is correct
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public boolean validateLogin(User currentUser) 
			throws SQLException, ClassNotFoundException, IOException {
		int count = 0;
		conn = dbController.getConnection();
		
		String sql = "SELECT * FROM tb_user WHERE userName = '"
				 + currentUser.getUserName() + "' AND password = '" 
				 + currentUser.getPassword() + "'";
		
		//Create statement object
		Statement stmt = conn.createStatement();

		//Create result set object
		ResultSet rsUser = stmt.executeQuery(sql);

		//display result set
		while (rsUser.next()) {
			user = new User(rsUser.getInt("userId"),
							rsUser.getString("userName"),
							rsUser.getString("fullName"),
							rsUser.getString("password"),
							rsUser.getString("ic"),
							rsUser.getString("telNo"),
							rsUser.getString("email"));

			count++;
		}
		
		if (count == 1) {
			// store login information to config.login
			Properties loginData = new Properties();
			FileOutputStream output = new FileOutputStream(
					"./bin/config/config.properties");
			loginData.setProperty("userId", user.getUserId() + "");
			loginData.setProperty("userName", user.getUserName());
			loginData.setProperty("fullName", user.getFullName());
			loginData.store(output, null);
			conn.close();
			return true;
		} else {
			conn.close();
			return false;
		}
		
	}
	
	/**
	 * validate whether if userName is used or not.
	 * @param userName username
	 * @param password user's password
	 * @param fullName user's full name
	 * @param ic user's ic no
	 * @param telNo user's telephone no
	 * @param email user's email address
	 * @return 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean validateRegister(User currentUser) 
					throws SQLException, ClassNotFoundException {
		
		//Open connection
		conn = dbController.getConnection();
		
		//Create query
		String sql = "SELECT * FROM tb_user WHERE userName = '"
				+ currentUser.getUserName() + "'";
		
		//Create statement object
		Statement stmt = conn.createStatement();

		//Create result set object
		ResultSet rsUser = stmt.executeQuery(sql);
		
		// If this userName is not yet used
		if (!rsUser.next()) {
			sql = "INSERT INTO tb_user (userName, password, fullName, ic,"
					+ " telNo, email) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement psUser = conn.prepareStatement(sql);
			psUser.setString(1, currentUser.getUserName());
			psUser.setString(2, currentUser.getPassword());
			psUser.setString(3, currentUser.getFullName());
			psUser.setString(4, currentUser.getIc());
			psUser.setString(5, currentUser.getTelNo());
			psUser.setString(6, currentUser.getEmail());
			
			psUser.executeUpdate();
			conn.close();
			return true;
		} else {
			conn.close();
			return false;
		}
		
	}

}
