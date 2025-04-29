import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class diseño {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					diseño window = new diseño();
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
	public diseño() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 30, 30, 30));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(18, 1, 0, 0));
		
		JLabel labelNombres = new JLabel("Nombres");
		panel.add(labelNombres);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel labelApellidos = new JLabel("Apellidos");
		panel.add(labelApellidos);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel labelEmpresa = new JLabel("Empresa");
		panel.add(labelEmpresa);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel labelAmbitoEmpresa = new JLabel("Ambito de la empresa");
		panel.add(labelAmbitoEmpresa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("Tecnología");
		comboBox.addItem("Salud");
		comboBox.addItem("Educación");
		comboBox.addItem("Comercio");
		comboBox.addItem("Otro");

		panel.add(comboBox);
		
		JLabel labelCargo = new JLabel("Cargo");
		panel.add(labelCargo);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel labelNombreUsuario = new JLabel("Nombre de usuario");
		panel.add(labelNombreUsuario);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		panel.add(labelContraseña);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel labelRepetirContraseña = new JLabel("Repetir contraseña");
		panel.add(labelRepetirContraseña);
		
		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel labelCorreo = new JLabel("Coreo electrónico");
		panel.add(labelCorreo);
		
		textField_7 = new JTextField();
		panel.add(textField_7);
		textField_7.setColumns(10);
	}

}
