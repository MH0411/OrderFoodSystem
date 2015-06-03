package user.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public boolean validateLogin(String userName, String password) {
		try {
			conn = dbController.getConnection();
			
			String sql = "SELECT * FROM tb_user WHERE userName = '"
					 + userName + "' AND password = '" + password + "'";
			
			//Create statement object
			Statement stmt = conn.createStatement();

			//Create result set object
			ResultSet rsUser = stmt.executeQuery(sql);
	
			//display result set
			while(rsUser.next()){
				System.out.println(rsUser.getInt("userID") 
						+ " " + rsUser.getString("userName")
						+ " " + rsUser.getString("password"));
				System.out.println("Login Sucessfully");
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
		return true;
	}
	
	public Vector<User> selectAllUsers() throws SQLException, 
			ClassNotFoundException {
		
			conn = dbController.getConnection();
			
			String sql = "select * from tb_user";
			
			//Create statement object
			Statement stmt = conn.createStatement();

			//Create result set object
			ResultSet rsUser = stmt.executeQuery(sql);
	
			
			//display result set
			Vector<User> users = new Vector<User>();
			while(rsUser.next()){
				
				User tempUser = new User();
				tempUser.setUserID(rsUser.getString("userID"));
				tempUser.setUserName(rsUser.getString("userName"));
				
				users.add(tempUser);
			}
		
			
			
		
		conn.close();
		
		return users;
	}
}
