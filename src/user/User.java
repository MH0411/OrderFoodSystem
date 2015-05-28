package user;

public class User {
	private String userID;
	private String userName;
	private String password;
	private String address;
	private String telNo;
	private String email;
	
	public User() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
