package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class TableModel extends AbstractTableModel {
	private String[] columnNames = {"ID", "Program", "Username", "Password"};
	private ArrayList<Program> list;
	
	public TableModel(){
		list = getList();
	}
	
	public String getColumnName( int col ) {
	    return columnNames[col];
	}
	
	public boolean isCellEditable(int row, int col){ 
		return true; 
	}
	
	public void setValueAt( Object value, int row, int col ) {
		Program p = list.get(row);
		
		if( col == 0 ){
			p.setId((Integer.parseInt((String)value)));
		}
		else if( col == 1 ){
			p.setProgramName((String) value);
		}
		else{
			p.setPassword((String) value);
		}
		
		for (Program pro : list) {
			System.out.println( pro.getId() + ", " + pro.getProgramName() + ", " + ", " + pro.getUsername() + ", " + pro.getPassword() + ", " + pro.getUserid() );
		}
		fireTableDataChanged();
	  }
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0){
			return list.get(rowIndex).getId();
		}
		else if( columnIndex == 1 ){
			return list.get(rowIndex).getProgramName();
		}
		else if( columnIndex == 2 ){
			return list.get(rowIndex).getUsername();
		}
		else if( columnIndex == 3 ) {
			return list.get(rowIndex).getPassword();
		}
		else{
			return list.get(rowIndex).getUserid();
		}
	}	
	
	public void insert( String programname, String username, String password ){
		try{
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
			PreparedStatement statement = con.prepareStatement("INSERT INTO program (programname, username, password, userid) VALUES (?, ?, ?, ?);");
			
			int userid = 1;
			
			statement.setString(1, programname );
			statement.setString(2, username);
			statement.setString(3, password);
			statement.setInt(4, userid );
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println( rowsAffected );
			
		    statement.close();
		    con.close();
		}
		catch( SQLException e ){
			
		}
		
		list = getList();
		fireTableDataChanged();
	}
	
	public void Update( int id, String username, String password ){
		try{
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
			PreparedStatement statement = con.prepareStatement("UPDATE PROGRAM SET NAME = ? , PASSWORD = ? WHERE ID = ?");
			
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setInt(3, id);
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println( rowsAffected );
			
		    statement.close();
		    con.close();
		}
		catch( SQLException e ){
			
		}
		
		list = getList();
		fireTableDataChanged();
		
	}
	
	private ArrayList<Program> getList(){
		ArrayList<Program> list = new ArrayList<Program>();
		
		try{
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM PROGRAM");
			
			while( rs.next() ){
				int id = rs.getInt("ID");
				String programname= rs.getString("PROGRAMNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int userid = rs.getInt("USERID");
				list.add(new Program( id, programname, username, password, userid ));
			}
			
			rs.close();
		    statement.close();
		    con.close();
			
		}
		catch( SQLException e ){
			
		}
		
		return list;
	}

}
