package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.HomeModel;
import views.HomeView;

public class HomeController {

	public HomeController (HomeView view, HomeModel model) {
		view.getBoton_usuarios().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.ventanaOptionPane();
				System.out.println("Hola");
			}
		});
		
		view.getBoton_configuracion().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						view.ventanaOptionPane();
						System.out.println("Hola");
					}
		});
		
		view.getBoton_registros().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.ventanaOptionPane();
				System.out.println("Hola");
			}
		});
		
	}
	
}
