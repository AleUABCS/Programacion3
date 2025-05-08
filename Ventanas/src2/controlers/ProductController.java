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
				resetTable();
			}
		});
		
		view.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = view.getTextfield_nombre().getText();
					long id = Long.parseLong(view.getTextfield_id().getText());
					long price = Long.parseLong(view.getTextfield_precio().getText());
					double stock = Double.parseDouble(view.getTextfield_stock().getText());
					model.addProduct(name, id, price, stock);
					resetTable();
					view.showProductAddSuccess();
					
				} catch (Exception e1) {
					view.showProductAddFail();
				}
				
				
			}
		});
		
		view.getButton_add().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.showFrameAdd();
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
	
	public void resetTable () {
		view.getModel().setRowCount(0);
		fillTable();
	}
	
}
