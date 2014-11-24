

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
		
		// TODO-> call model to login passing parameters, and calls shutdownframe() if the login was successfull
	}
	
	// Closes the loginframe and presents the "main" frame if login was successfull
	public void shutdownFrame() {
		
	}
}
