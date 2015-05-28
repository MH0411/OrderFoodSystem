package user.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String sql = "";
		return true;
	}
	
	public void display() throws SQLException {
		try {
			conn = dbController.getConnection();
			
			String sql = "select * from tb_user";
			
			//Create statement object
			Statement stmt = conn.createStatement();

			//Create result set object
			ResultSet rsUser = stmt.executeQuery(sql);
	
			
			//display result set
			while(rsUser.next()){
				System.out.println(rsUser.getInt("userID") 
						+ " " + rsUser.getString("userName"));
			}
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
		
		conn.close();
	}
}
