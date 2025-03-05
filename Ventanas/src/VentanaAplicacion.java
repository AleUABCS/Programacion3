import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.IconUIResource;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import java.awt.Choice;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class VentanaAplicacion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAplicacion window = new VentanaAplicacion();
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
	public VentanaAplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 746, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		TitledBorder tituloPanel = new TitledBorder(null, "Registro de Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		tituloPanel.setTitleFont(new Font("Calibri", Font.BOLD, 28));
		panel.setBorder(tituloPanel);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_panel.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		TitledBorder tituloPanel_4 = new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 0 ,128));
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 0, 64)));
		panel_4.setBackground(new Color(255, 128, 192));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 8;
		gbc_panel_4.gridheight = 5;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(20, 20, 0, 80));
		panel_5.setOpaque(false);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(8, 2, 25, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre/s");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Primer apellido");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Segundo apellido");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de nacimiento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setOpaque(false);
		panel_5.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setVisible(false);
		panel_5.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Femenino");
		rdbtnNewRadioButton_1.setOpaque(false);
		panel_5.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Nacionalidad");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblNewLabel_6);
		
		JComboBox<String> ComboBoxNacionalidades = new JComboBox<String>();
		ComboBoxNacionalidades.addItem("Perrú");
		ComboBoxNacionalidades.addItem("México");
		ComboBoxNacionalidades.addItem("Canadá");
		ComboBoxNacionalidades.addItem("Japón");
		panel_5.add(ComboBoxNacionalidades);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 8;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Perfil de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_7.setOpaque(false);
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setSize(new Dimension(180, 180));
		panel_7.add(lblNewLabel_7, BorderLayout.NORTH);
		ImageIcon fotoPerfil = new ImageIcon("FotoPerfil.jpg");
		Icon fotoPerfilEscalada = new ImageIcon(fotoPerfil.getImage().getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_7.setIcon(fotoPerfilEscalada);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 30, 50, 20));
		panel_6.setOpaque(false);
		panel_7.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(2, 1, 0, 10));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar foto de perfi");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNewCheckBox.setOpaque(false);
		panel_6.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar fecha de nacimiento");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNewCheckBox_1.setOpaque(false);
		panel_6.add(chckbxNewCheckBox_1);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Opcionales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_3.setBackground(new Color(128, 128, 192));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 4;
		gbc_panel_3.gridwidth = 8;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(25, 25, 25, 25));
		panel_8.setOpaque(false);
		panel_3.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("Descripción");
		panel_8.add(lblNewLabel_8);
		
		JTextArea txtrHolaHolaHola = new JTextArea();
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(txtrHolaHolaHola);
		panel_8.add(scrollPanel);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(25, 25, 25, 25));
		panel_9.setOpaque(false);
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("Preferencias");
		panel_9.add(lblNewLabel_9);
		
		String preferencias[] = {"Cantar", "Jugar", "Video juegos", "Escuchar música", "Ninguna"};
		JList list = new JList(preferencias);
		
		JScrollPane scrollPreferencias = new JScrollPane(list);
		
		panel_9.add(scrollPreferencias);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(20, 100, 20, 100));
		panel_2.setBackground(new Color(255, 128, 255));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 4;
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 8;
		gbc_panel_2.gridy = 5;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 20));
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon iconoNuevo = new ImageIcon("Nuevo.png");
		Icon iconoNuevoEscalado = new ImageIcon(iconoNuevo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnNewButton.setIcon(iconoNuevoEscalado);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon iconoGuardar = new ImageIcon("Guardar.png");
		Icon iconoGuardarEscalado = new ImageIcon(iconoGuardar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnNewButton_1.setIcon(iconoGuardarEscalado);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon iconoSalir = new ImageIcon("Salir.png");
		Icon iconoSalirEscalado = new ImageIcon(iconoSalir.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnNewButton_2.setIcon(iconoSalirEscalado);
		panel_2.add(btnNewButton_2);
	}

}
