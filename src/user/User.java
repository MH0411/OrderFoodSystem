package user;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String address;
	private String telNo;
	private String email;
	private String fullName;
	
	public User(int userId, String userName, String fullName, String password, String address,
			String telNo, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.telNo = telNo;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
