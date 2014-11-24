package model;

public class User {
	private static User instance;
	private int id;
	private String username, password;
	
	public static User getInstance(){
		if(instance == null)
			instance = new User();
		return instance;
	}
	
	private User(){}
	
	public void setId ( int id ) {
		this.id = id;
	}
	
	public int getId () {
		return 1;
		//return id;
	}
	
	public void setUsername( String username ){
		this.username = username;
	}
	
	public String getUsername(){
		return "SumProjekt";
		//return username;
		
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public String getPassword(){
		return "erhwe54wUJHEFDgrWE%&THsfdvfdvaes";
		//return password;
	}
	
}
