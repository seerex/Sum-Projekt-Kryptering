package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import model.TableModel;


public class PasswordFrame extends JFrame implements TableModelListener, ActionListener {
	private JTextField program, username, password;
	private JButton insert;
	private TableModel model;
	private JTable table;
	
	public PasswordFrame( String title ){
		super(title);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		program = new JTextField(8);
		username = new JTextField(8);
		password = new JTextField(8);
		insert = new JButton( "Insert" );
		
		insert.addActionListener(this);
		
		panel.add( new JLabel("Program:") );
		panel.add(program);
		panel.add( new JLabel("Username:") );
		panel.add(username);
		panel.add( new JLabel("Password:") );
		panel.add(password);
		panel.add(insert);
		
		model = new TableModel();
		model.addTableModelListener(this);
		table = new JTable( model );
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Test");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == insert ){
			model.insert(program.getText(), username.getText(), password.getText());;
			//table.clearSelection();
			//model.Update(Integer.parseInt(program.getText()), username.getText(), password.getText());
		}
		
	}
	
	

}
