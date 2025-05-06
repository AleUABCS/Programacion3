package aplication;

import views.AuthView;
import views.HomeView;
import controlers.AuthController;
import controlers.HomeController;
import models.AuthModel;
import models.HomeModel;

public class Main {

	public static void main(String[] args) {
		
		AuthView view = new AuthView();
		AuthModel model = new AuthModel();
		AuthController authController = new AuthController(view, model);
		
		HomeView homeView = new HomeView();
		HomeModel homeModel = new HomeModel();
		HomeController homeControler = new HomeController(homeView, homeModel);
		
	}

}
