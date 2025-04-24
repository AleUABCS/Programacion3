package aplication;

import views.AuthView;
import controlers.AuthController;
import models.AuthModel;

public class Main {

	public static void main(String[] args) {
		
		AuthView view = new AuthView();
		AuthModel model = new AuthModel();
		
		AuthController aplication = new AuthController(view, model);
		
	}

}
