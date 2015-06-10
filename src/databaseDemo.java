import java.sql.SQLException;

import user.db.UserController;


public class databaseDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		UserController userCtrl = new UserController();
		
		try {
			System.out.print(userCtrl.selectAllUsers().get(0).getUserName());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
