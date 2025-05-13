package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import models.ProductModel;
import views.ButtonEditor;
import views.ProductView;
import views.TableRender;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellRenderer;


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
//					resetTable();
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
			JButton button_delete = new JButton("Eliminar");
			
			System.out.println(obj1);
			view.getTableModel().addRow(new Object[] {obj1, obj2, obj3, obj4, button_delete});
		}
		view.getTable().getColumn("Eliminar").setCellRenderer(new TableRender());
		ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox());
		buttonEditor.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getTable().getSelectedRow();
				buttonEditor.fireEditingStopped();
				model.deleteProductId(row);
				resetTable();
			}
		});
		view.getTable().getColumn("Eliminar").setCellEditor(buttonEditor);
		
	}
	
	public void resetTable () {
		view.getTableModel().setRowCount(0);
		fillTable();
	}


}
