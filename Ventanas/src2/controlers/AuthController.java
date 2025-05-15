package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import models.AuthModel;
import views.AuthView;
import views.HomeView;
import views.ProductView;
import views.UserView;

public class AuthController {
	
	
	public AuthController (AuthView view, AuthModel model) {
		
		view.getBoton_home().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				HomeView homeView = new HomeView();
			}
		});
		
		//Añadir acción al botón "Acceder" del login
		view.getBoton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = view.getEmail().getText();
				String password = view.getPassword().getText();

				if (model.accesUser(email, password)) {
					view.setEmailGreen();
					view.setPasswordGreen();
					
					view.setVisible(false);
//					ProductView productView = new ProductView();
					UserView userView = new UserView(view);
					
				} else {
					view.setEmailRed();
					view.setPasswordRed();
					view.showAccesDenied();
				}

			}
		});
		
		// Botón Registro
		view.getBotonRegistro().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.cambiar(1); // Registro
			}
		});
		
		// Botón registro: mandar información de los campos y verificar en el modelo para guardar en UsuariosRegistro.txt
		view.getRegistrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombres = view.getTextFieldNombres().getText();
				String apellidos = view.getTextFieldApellidos().getText();
				String empresa = view.getTextFieldEmpresa().getText();
				String ambito = view.getAmbitoEmpresa().getSelectedItem().toString();
				String cargo = view.getTextFieldCargo().getText();
				String nombreUsuario = view.getTextFieldNombreUsuario().getText();
				String contraseña = view.getTextFieldContraseña().getText();
				String repetirContraseña = view.getTextFieldRepetirContraseña().getText();
				String correo = view.getTextFieldCorreo().getText();
				
				try {
					model.registerUser(nombres, apellidos, empresa, ambito, cargo, nombreUsuario, contraseña, repetirContraseña, correo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
		
	}
	
	
}
