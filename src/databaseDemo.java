import java.sql.SQLException;

import user.db.UserController;


public class databaseDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		UserController userCtrl = new UserController();
		
		try {
			userCtrl.selectAllUsers();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
