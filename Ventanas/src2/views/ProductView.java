package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlers.ProductController;
import models.ProductModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class ProductView {

	private JFrame frame = new JFrame();
	private DefaultTableModel model =  new DefaultTableModel();
	private JTable table = new JTable(model);
	private JScrollPane scrollPanel = new JScrollPane(table);
	private JButton boton_ActualizarTabla = new JButton("Actualizar");

	ProductController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView window = new ProductView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductView() {
		initialize();
		ProductModel model = new ProductModel();
		controller = new ProductController(ProductView.this, model);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setSize(650, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panelGeneral = new JPanel();
		frame.getContentPane().add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelGeneral.add(panel, BorderLayout.CENTER);
		
		model.setColumnIdentifiers(new String[] {"ID", "Nombre", "Precio", "Stock"});
		
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(scrollPanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panelGeneral.add(panel_1, BorderLayout.SOUTH);
		
		boton_ActualizarTabla.setBackground(new Color(230, 230, 250));
		panel_1.add(boton_ActualizarTabla);
	}
	
	public void repaintTable () {
		table.revalidate();
		table.repaint();
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JButton getBoton_ActualizarTabla() {
		return boton_ActualizarTabla;
	}
	
}
