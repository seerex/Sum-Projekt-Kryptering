package model;
public class Program {
	private int id;
	private String programname;
	private String username;
	private String password;
	private int userid;

	
	public Program( int id, String programname, String username, String password, int userid ){
		this.setId(id);
		this.setProgramName(programname);
		this.setUsername( username );
		this.setPassword(password);
		this.setUserid( userid );
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getProgramName() {
		return programname;
	}


	public void setProgramName(String name) {
		this.programname = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
}
