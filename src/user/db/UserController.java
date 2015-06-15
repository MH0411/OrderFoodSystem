package user.db;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import db.DatabaseController;
import user.User;

public class UserController {
	User user;
	DatabaseController dbController;
	Connection conn;
	
	public UserController() {
		dbController = new DatabaseController();
	}
	
	public User getUserInfo() {
		return user;
	}

	/**
	 * validate username and password which user input to login
	 * @param userName
	 * @param password
	 * @return true if userName and password is correct
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public boolean validateLogin(String userName, String password) 
			throws SQLException, ClassNotFoundException, IOException {
		int count = 0;
		conn = dbController.getConnection();
		
		String sql = "SELECT * FROM tb_user WHERE userName = '"
				 + userName + "' AND password = '" + password + "'";
		
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
							rsUser.getString("address"),
							rsUser.getString("telNo"),
							rsUser.getString("email"));
			
			System.out.println("Login Sucessfully");
			count++;
		}
		
		if (count == 1) {
			// store login information to config.login
			Properties loginData = new Properties();
			FileOutputStream output = new FileOutputStream("./bin/config/config.properties");
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
	
	public boolean validateRegister(String userName, String password, 
			String fullName, String ic, String telNo, String email) 
					throws SQLException, ClassNotFoundException {
		conn = dbController.getConnection();
		
		String sql = "SELECT * FROM tb_user WHERE userName = '"
				+ userName + "'";
		
		//Create statement object
		Statement stmt = conn.createStatement();

		//Create result set object
		ResultSet rsUser = stmt.executeQuery(sql);
		
		// If this userName is not yet used
		if (!rsUser.next()) {
			sql = "INSERT INTO tb_user (userName, password, fullName, ic,"
					+ " telNo, email) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement psUser = conn.prepareStatement(sql);
			psUser.setString(1, userName);
			psUser.setString(2, password);
			psUser.setString(3, fullName);
			psUser.setString(4, ic);
			psUser.setString(5, telNo);
			psUser.setString(6, email);
			
			psUser.executeUpdate();
			conn.close();
			return true;
		} else {
			conn.close();
			return false;
		}
		
	}
	
//	public Vector<User> selectAllUsers() throws SQLException, 
//			ClassNotFoundException {
//		
//			conn = dbController.getConnection();
//			
//			String sql = "SELECT * FROM tb_user";
//			
//			//Create statement object
//			Statement stmt = conn.createStatement();
//
//			//Create result set object
//			ResultSet rsUser = stmt.executeQuery(sql);
//	
//			
//			//display result set
//			Vector<User> users = new Vector<User>();
//			while(rsUser.next()) {
//				
//				User tempUser = new User();
//				tempUser.setUserID(rsUser.getString("userID"));
//				tempUser.setUserName(rsUser.getString("userName"));
//				
//				users.add(tempUser);
//			}
//		
//		conn.close();
//		
//		return users;
//	}
}
