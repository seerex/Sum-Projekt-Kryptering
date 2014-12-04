package view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.LoginController;

public class LoginView extends JFrame implements ActionListener {
	private JTextField usernameText, passwordText, passwordVerifyText;
	private JButton loginButton, createUserButton;
	private JLabel passwordVerifyLabel;
	private LoginController controller;
	
	
	public LoginView(String title, LoginController controller) {
		super(title);
		this.controller = controller;
		
		getContentPane().setLayout(new FlowLayout());
		
		createView();
		
		setSize(250, 250);
		setVisible(true);
	}
	
	private void createView() {
		JLabel usernameLabel = new JLabel("Username: ");
		getContentPane().add(usernameLabel);
		
		usernameText = new JTextField(8);
		getContentPane().add(usernameText);
		
		JLabel passwordLabel = new JLabel("Password: ");
		getContentPane().add(passwordLabel);
		
		passwordText = new JTextField(8);
		getContentPane().add(passwordText);
		
		// Invisible unless user creates new password
		passwordVerifyLabel = new JLabel("Verify password: ");
		passwordVerifyLabel.setVisible(false);
		getContentPane().add(passwordVerifyLabel);
		
		passwordVerifyText = new JTextField(8);
		passwordVerifyText.setVisible(false);
		getContentPane().add(passwordVerifyText);
		
		loginButton = new JButton("Login");
		getContentPane().add(loginButton);
		loginButton.addActionListener(this);
		
		createUserButton = new JButton("Create user");
		getContentPane().add(createUserButton);
		createUserButton.addActionListener(this);
	}
	
	public void showOptionPaneWithMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	private void createUser() {
		// first button press shows extra password field
		// Second creates the user
		if (passwordVerifyText.isVisible())
				controller.createUser(usernameText.getText(), passwordText.getText(), passwordVerifyText.getText());
		else {
			passwordVerifyText.setVisible(true);
			passwordVerifyLabel.setVisible(true);
			revalidate();
		}
	}
	
	public void resetTextFields() {
		passwordText.setText("");
		passwordVerifyText.setText("");
		passwordVerifyLabel.setVisible(false);
		passwordVerifyText.setVisible(false);
		revalidate();
		usernameText.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == loginButton)
			controller.login(usernameText.getText(), passwordText.getText());
		else if (source == createUserButton)
			createUser();
	}
	
}
