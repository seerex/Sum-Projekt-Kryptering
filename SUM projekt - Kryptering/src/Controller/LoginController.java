package Controller;
import view.LoginView;
import model.Login;
import model.UserCreateDB;



public class LoginController {
	private LoginView view;
	
	public LoginController(String title) {
		view = new LoginView(title, this);
	}
	
	// Called by the view when a login should be processed
	public void login(String username, String password) {
		// Calls to the model, trying to log the user in.
		// The model needs to instantiate the Singleton User class, and set the username variable, but ONLY if it manages to log in.
		System.out.println("User logging in with: " + username + " - " + password);
		
		if (Login.getInstance().login(username, password)) {
			shutdownFrame();
		} else
			view.showOptionPaneWithMessage("Wrong username/password combination");
	}
	
	public void createUser(String username, String password, String passwordVerify) {
		if (sanitizeUserCredentials(username, password, passwordVerify)) {
			// Create the user in the DB
			UserCreateDB db = new UserCreateDB();
			db.InsertUser(username, password);
		} else
			view.showOptionPaneWithMessage("Couldn't create user! Make sure you entered something in all fields and that the password matches");
			
	}
	
	private boolean sanitizeUserCredentials(String username, String password, String passwordVerify) {
		// Make sure something was entered in all fields + password matches verify
		return (username.length() > 0 && password.length() > 0 && passwordVerify.length() > 0) && password.equals(passwordVerify);
	}
	
	// Closes the loginframe and presents the "main" frame if login was successfull
	public void shutdownFrame() {
		
	}
}
