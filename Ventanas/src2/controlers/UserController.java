package controlers;

import java.util.ArrayList;

import models.User;
import models.UserModel;
import views.AuthView;
import views.UserView;

public class UserController {
	
	UserModel model;
	UserView view;
	AuthView authView;
	
	public UserController(UserView view, UserModel model, AuthView authView) {
		this.model = model;
		this.view = view;
		this.authView = authView;
		fillTable();
		
		view.getBtnVolver().addActionListener(e -> {
			authView.setVisible(true);
			view.setVisible(false);
        });
		
	}
	
	public void fillTable () {
		ArrayList<User> users = model.get();
		for (User user : users) {
			view.getTable_model_users().addRow(user.toArray());
			System.out.println("Llenar tabla");
		}
	}
	
}
