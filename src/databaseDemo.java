import java.sql.SQLException;

import user.db.UserController;


public class databaseDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserController userCtrl = new UserController();
		
		userCtrl.display();
	}

}
