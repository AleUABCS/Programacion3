package models;

import javax.swing.JCheckBox;

public class AuthModel {

	public AuthModel () {
		
	}
	
	public boolean accesUser (String email, String password) {
		if (email.equals("admin") && password.equals("1234"))
			return true;
		else return false;
	}
	
	public void register (String user, String bio, JCheckBox pref1, JCheckBox pref2, JCheckBox pref3, String colonia) {
		System.out.println("Usuario: " + user);
		System.out.println("Biografía: " + bio);
		System.out.println("Preferencias: ");
		if (pref1.isSelected()) System.out.println("Salado");
		if (pref2.isSelected()) System.out.println("Dulce");
		if (pref3.isSelected()) System.out.println("Saludable");
		System.out.println("Colonia: " + colonia);
	}
	
}
