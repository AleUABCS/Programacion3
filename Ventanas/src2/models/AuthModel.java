package models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AuthModel {

	public AuthModel () {
		
	}
	
	public void registerUser (String nombres, String apellidos, String empresa, String ambito, String cargo,
			String nombreUsuario, String contraseña, String repetirContraseña, String correo) throws IOException {
		
		FileWriter file = null;
		PrintWriter writer = null;
		boolean success = false;
		
		try {
			file = new FileWriter("src2/files/UsuariosRegistro.txt", true);
			writer = new PrintWriter(file);
			
			if (nombres.matches("[a-zA-Z ]+")) { // Nombres, solo letras y espacios
				if (apellidos.matches("[a-zA-Z ]+")) { // Apellidos, solo letras y espacios
					if (empresa.matches("^[a-zA-Z0-9 ]+$")) { // Empresa, letras, números y espacios
						if (cargo.matches("[a-zA-Z ]+")) { // Cargo, solo letras y espacios
							if (nombreUsuario.matches("^[a-zA-Z0-9 ]+$")) { // Nombre de usuario, letras, números y espacios
								if (contraseña.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).*$")) { // Contraseña, tiene una letra, un número y un caracter
									if (repetirContraseña.equals(contraseña)) { // Repetir contraseña, es igual que la contraseña
										if (!correo.matches(".*\\s+.*")) { // Correo, no tiene espacios en blanco
											
											writer.println(nombres + "/" + apellidos + "/" +  empresa + "/" +  
													ambito + "/" +  cargo + "/" +  nombreUsuario + "/" +  contraseña + "/" + 
													repetirContraseña + "/" +  correo);
											success = true;
											JOptionPane.showMessageDialog(null, "Registro exitoso");
										}
									}
								}
							}
						}
					}
				}
			}
			if (!success)
				JOptionPane.showMessageDialog(null, "Dato/s inválido/s");
			
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el registro");

		} finally {
			
			writer.flush();
			file.flush();
			file.close();
			writer.close();
			
		}
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
