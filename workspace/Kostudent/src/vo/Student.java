package vo;

public class Student {
	// Contants for Log-In
	public static final int DEFAULT = 100;
	public static final int LOGIN_SUCCESS = 0;
	public static final int INCORRECT_PASSWORD = -1;
	public static final int NO_SUCH_USER_FOUND = -2;
	
	// Constants for Sign-up
	public static final int VALUD_SIGN_UP = 0;
	public static final int DUPLICATED_USER_ID = -10;		// when input already exists in DB
	public static final int NOT_VALID_ID_FORMAT = -20;		// blank and/or incorrect format
	public static final int NOT_VALID_PASSWORD_FORMAT = 30; // blank and/or incorrect format
	
	private int userClass;
	private String name;
	private String password;
	private int match;
	
	public Student(int userClass, String name, String password) {
		super();
		this.userClass = userClass;
		this.name = name;
		this.password = password;
		this.match = DEFAULT;
	}
	
	public Student() { }

	public int getUserClass() {
		return userClass;
	}

	public void setUserClass(int userClass) {
		this.userClass = userClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public int getMatching() {
		return match;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMatch(int match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Student [userClass=" + userClass + ", name=" + name + ", password=" + password + ", match=" + match
				+ "]";
	}
	
	
}
