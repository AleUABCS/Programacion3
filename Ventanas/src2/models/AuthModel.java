package models;

public class AuthModel {

	public AuthModel () {
		
	}
	
	public boolean accesUser (String email, String password) {
		if (email.equals("admin") && password.equals("1234"))
			return true;
		else return false;
	}
	
}
