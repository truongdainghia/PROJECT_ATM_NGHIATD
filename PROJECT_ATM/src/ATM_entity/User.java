package ATM_entity;

public class User {
	private String Username;
	private String password;
	
	public User(String Username,String password) {
		super();
		this.Username = Username;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

