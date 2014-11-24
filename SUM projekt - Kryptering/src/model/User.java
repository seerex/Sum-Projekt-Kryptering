package model;

public class User {
	private static User instance;
	private String username, password;
	
	public static User getInstance(){
		if(instance == null)
			instance = new User();
		
		return instance;
	}
	
	private User(){}
	
	public void setUsername( String username ){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
}
