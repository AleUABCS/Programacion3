package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
	}
	
	
}
