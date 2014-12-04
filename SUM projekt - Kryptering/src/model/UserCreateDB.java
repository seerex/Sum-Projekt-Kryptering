/* DB Statements
create table user(
id int GENERATED BY DEFAULT AS IDENTITY,
username nvarchar(100) not null,
password nvarchar(100) not null,
PRIMARY KEY (id))
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserCreateDB {
	private String createUserString = "INSERT INTO user (username, password) VALUES (?,?)";
	private PreparedStatement createUser; 
	Connection connection = null;
			
	public boolean InsertUser(String username, String password){

		try {
			connection = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "" );
			createUser = connection.prepareStatement( createUserString );
			createUser.setString(1, username);
			createUser.setString(2, Hasher.hashPassword(password));
			createUser.execute();
		} catch ( SQLException e ) {
			System.out.println( "Error opening connection to DB with statement: " + createUserString );
			return false;
		}
				
		return true;
	}
}
