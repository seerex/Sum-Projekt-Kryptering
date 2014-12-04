package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	private final static Login theinstance = new Login();
	private final static String DB_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
	private final static String DB_USER = "SA";
	private final static String DB_PASSWORD = "";
	private String checkForUser = "select id from user where username = ? and password = ?";
	Connection connection = null;
	
	private Login () {
		
	}

	public static Login getInstance () {
		return theinstance;
	}
	
	public boolean login (String username, String password) {
		try {
		connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD );
		PreparedStatement statement = connection.prepareStatement( checkForUser );
		statement.setString(1, username);
		password = Hasher.hashPassword(password);
		statement.setString(2, password);
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next()) {
			User.getInstance().setId(resultset.getInt("id"));
			User.getInstance().setUsername(username);
			User.getInstance().setPassword(password);
			return true;
		}
		return false;
		
		} catch ( SQLException e ) {
			System.out.println( "Error opening connection to DB with statement: " + checkForUser );
			return false;
		}
	}
}
