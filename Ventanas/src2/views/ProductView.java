package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Checkbox;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.ProductController;
import models.ProductModel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import javax.swing.ListSelectionModel;

public class ProductView {

	private JFrame frame = new JFrame();
	private JTable table = new JTable();
	private JScrollPane scrollPanel = new JScrollPane(table);
	private JButton boton_ActualizarTabla = new JButton("Actualizar");
	private JButton button_add = new JButton("+ Añadir producto");
	private JButton button_delete = new JButton(" - Eliminar");

	JTextField textfield_nombre = new JTextField();
	JTextField textfield_id = new JTextField();
	JTextField textfield_precio = new JTextField();
	JTextField textfield_stock = new JTextField();
	JButton button = new JButton("Aceptar");
	JFrame frame2 = new JFrame();
	
	DefaultTableModel tableModel = new DefaultTableModel();

	ProductController controller;
	ProductModel model;


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
		showTable();
		model = new ProductModel();
		controller = new ProductController(ProductView.this, model);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Productos");
		frame.setSize(650, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panelGeneral = new JPanel();
		frame.getContentPane().add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelGeneral.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(scrollPanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panelGeneral.add(panel_1, BorderLayout.SOUTH);
		
		boton_ActualizarTabla.setBackground(new Color(230, 230, 250));
		panel_1.add(boton_ActualizarTabla);
		button_add.setBackground(new Color(230, 230, 250));
		
		panel_1.add(button_add);
	}
	
	public void showFrameAdd () { 
		JPanel panel = new JPanel();
		textfield_id = new JTextField();
		textfield_nombre = new JTextField();
		textfield_precio = new JTextField();
		textfield_stock = new JTextField();
		
		frame2 = new JFrame();
		frame2.setLocationRelativeTo(null);
		
		panel.setBorder(new EmptyBorder(20,20,20,20));
		
		frame2.setSize(400,250);
		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.setLayout(new GridLayout(5,2, 10, 10));
		JLabel label_nombre = new JLabel("Nombre");
		
		JLabel label_id = new JLabel("ID");

		JLabel label_precio = new JLabel("Precio");
		
		JLabel label_stock = new JLabel("Stock");
		
		
		panel.add(label_nombre);
		panel.add(textfield_nombre);
		panel.add(label_id);
		panel.add(textfield_id);
		panel.add(label_precio);
		panel.add(textfield_precio);
		panel.add(label_stock);
		panel.add(textfield_stock);
		panel.add(new JLabel());
		panel.add(button);
		
		frame2.setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
	
	public void showTable () {
		
		tableModel.setColumnIdentifiers(new Object[] {"ID", "Nombre", "Precio", "Stock", "Eliminar"});
		table.setModel(tableModel);
	}
	
	public void repaintTable () {
		table.revalidate();
		table.repaint();
	}
	
	public void showProductAddSuccess () {
		JOptionPane.showMessageDialog(null, "Producto añadido");
	}
	
	public void showProductAddFail () {
		JOptionPane.showMessageDialog(null, "Datos inválidos");
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JButton getBoton_ActualizarTabla() {
		return boton_ActualizarTabla;
	}

	public JButton getButton_add() {
		return button_add;
	}

	public JTextField getTextfield_nombre() {
		return textfield_nombre;
	}

	public JTextField getTextfield_id() {
		return textfield_id;
	}

	public JTextField getTextfield_precio() {
		return textfield_precio;
	}

	public JTextField getTextfield_stock() {
		return textfield_stock;
	}

	public JButton getButton() {
		return button;
	}

	public JTable getTable() {
		return table;
	}
	
}
