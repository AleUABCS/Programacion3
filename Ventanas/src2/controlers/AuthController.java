package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import models.AuthModel;
import views.AuthView;

public class AuthController {
	
	public AuthController (AuthView view, AuthModel model) {
		
		view.getBoton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = view.getEmail().getText();
				String password = view.getPassword().getText();

				if (model.accesUser(email, password)) {
					view.setEmailGreen();
					view.setPasswordGreen();
					view.showAccessSuccess();
				} else {
					view.setEmailRed();
					view.setPasswordRed();
					view.showAccesDenied();
				}

			}
		});
		
		view.getBotonLogin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.cambiar(2); // Login
			}
		});
		
		view.getBotonRegistro().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.cambiar(1); // Login
			}
		});
		
		view.getBotonFinRegistro().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = view.getNombre().getText();
				String bio = view.getBio().getText();
				JCheckBox prefSalado = view.getSalado();
				JCheckBox prefDulce = view.getDulce();
				JCheckBox prefSaludable = view.getSaludable();
				String colonia = view.getComboBoxColonias().getSelectedItem().toString();
				model.register(user, bio, prefSalado, prefDulce, prefSaludable, colonia);
			}
		});
		
	}
	
}
