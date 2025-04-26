package models;

import java.io.FileReader;
import javax.swing.JCheckBox;

public class AuthModel {

	public AuthModel () {
		
	}
	
	public boolean accesUser (String email, String password) {
        StringBuilder usersInfoSB = new StringBuilder();
		try { 
		 			
		 			String url = AuthModel.class.getResource("/files/users.txt").getPath();
		 			FileReader fileReader = new FileReader(url);
		 			
		 			int i;
		 
		             while ((i = fileReader.read()) != -1)
		            		 usersInfoSB.append((char)i);
		             fileReader.close();
		             
		             String usersInfoArray[] = usersInfoSB.toString().split(", |\r\n");
		             for (int j = 0; j < usersInfoArray.length; j+=2) {
		            	 
		            	 if(email.equals(usersInfoArray[j]))
		            		 if(password.equals(usersInfoArray[j+1]))
		            			 return true;
		            	 
					}
		             
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 			System.out.println("error"); 
		 		}
		             
		return false;
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
