import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginView extends JFrame implements ActionListener {
	private JTextField usernameText, passwordText;
	private JButton loginButton;
	private LoginController controller;
	
	
	public LoginView(String title, LoginController controller) {
		super(title);
		this.controller = controller;
		
		getContentPane().setLayout(new FlowLayout());
		
		createView();
		
		setSize(250, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		loginButton = new JButton("Login");
		getContentPane().add(loginButton);
		loginButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == loginButton)
			controller.login(usernameText.getText(), passwordText.getText());
	}
	
}
