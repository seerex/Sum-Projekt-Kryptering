package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
public class ViewCreateUser {

	private JFrame frmSad;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCreateUser window = new ViewCreateUser();
					window.frmSad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCreateUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSad = new JFrame();
		frmSad.setTitle("Create user");
		frmSad.setType(Type.UTILITY);
		frmSad.setResizable(false);
		frmSad.setBounds(100, 100, 180, 158);
		frmSad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSad.getContentPane().setLayout(null);
		
		userNameField = new JTextField();
		userNameField.setBounds(28, 27, 117, 20);
		userNameField.setColumns(10);
		frmSad.getContentPane().add(userNameField);
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(38, 101, 94, 20);
		frmSad.getContentPane().add(btnNewButton);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(28, 11, 105, 14);
		frmSad.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(28, 53, 105, 14);
		frmSad.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLUE);
		passwordField.setBounds(28, 71, 117, 20);
		frmSad.getContentPane().add(passwordField);
	}
}
