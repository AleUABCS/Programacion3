package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.ProductModel;
import views.ProductView;

public class ProductController {
	
	ProductView view;
	ProductModel model;
	
	public ProductController(ProductView view, ProductModel model) {
		this.view = view;
		this.model = model;
		fillTable();
		
		view.getBoton_ActualizarTabla().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getModel().setRowCount(0);
				fillTable();
			}
		});
	}

	public void fillTable () {
		for (int i = 0; i < model.get().size(); i++) {
				
			ArrayList<Object> array = model.toObjectArrayListIndex(i);
			Object obj1 = array.get(0);
			Object obj2 = array.get(1);
			Object obj3 = array.get(3);
			Object obj4 = array.get(2);
			
			System.out.println(obj1);
			view.getModel().addRow(new Object[] {obj1, obj2, obj3, obj4});
		}
	}
}
