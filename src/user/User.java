package user;

/**
 * This class represent the user in this application.
 * It contains userId, userName, password, telNo, email and fullName.
 * @author JKGan
 *
 */
public class User {
	private int userId;
	private String userName;
	private String password;
	private String telNo;
	private String email;
	private String fullName;
	private String ic;
	
	/**
	 * Constructor of User.
	 * Used to initialize userId, userName, fullName, password, telNo and email
	 * @param userId
	 * @param userName
	 * @param fullName
	 * @param password
	 * @param address
	 * @param telNo
	 * @param email
	 */
	public User(int userId, String userName, String fullName, String password,
			String ic, String telNo, String email) {
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.telNo = telNo;
		this.email = email;
		this.ic = ic;
	}
	
	/**
	 * Constructor of user
	 * Used to initialize userName, fullName, password, ic, telNo, email.
	 * @param userName
	 * @param fullName
	 * @param password
	 * @param ic
	 * @param telNo
	 * @param email
	 */
	public User(String userName, String fullName, String password, String ic,
			String telNo, String email) {
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.telNo = telNo;
		this.email = email;
		this.ic = ic;
	}

	/**
	 * Getter to get user Ic
	 * @return ic
	 */
	public String getIc() {
		return ic;
	}

	/**
	 * Setter to set user Ic
	 * @param ic
	 */
	public void setIc(String ic) {
		this.ic = ic;
	}

	/**
	 * Constructor of User.
	 * Used to initialize userName and password
	 * @param userName
	 * @param password
	 */
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * getter of userId
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * setter of userId
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * getter of userName
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * setter userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * getter password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * setter password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter telNo
	 * @return telNo
	 */
	public String getTelNo() {
		return telNo;
	}
	
	/**
	 * setter telNo
	 * @param telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	/**
	 * getter of email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setter of email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter of fullName
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * setter of fullName
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
