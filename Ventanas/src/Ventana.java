import java.awt.Color; 
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	
	/*
	public Ventana () {
		setTitle("Iniciar Sesión");
		setLayout(null);
		setVisible(true);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#e8d8fd"));
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(17, 15, 450, 530);
		panel.setLayout(null);
		add(panel);
		
		//Etiqueta "Iniciar Sesión"
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Iniciar Sesión");
		panel.add(etiqueta);
		etiqueta.setBounds(115, 65, 300, 50);
		etiqueta.setFont(new Font("Calibri", Font.PLAIN, 40));
		
		//TextField para email
		JTextField email = new JTextField ("   Correo electrónico");
		email.setFont(new Font ("Calibri", Font.BOLD, 22));
		email.setForeground(Color.GRAY.brighter());
		email.setBounds(25, 170, 400, 60);
		email.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(email);
		email.repaint();
		
		//TextField para contraseña
		JTextField password = new JTextField("   Contraseña");
		password.setFont(new Font ("Calibri", Font.BOLD, 22));
		password.setForeground(Color.GRAY.brighter());
		password.setBounds(25, 237, 400, 60);
		password.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(password);
		password.repaint();

		
		
		//Botón
		JButton boton = new JButton();
		boton.setText("Acceder");
		boton.setFont(new Font("Calibri", Font.PLAIN, 28));
		boton.setBounds(25, 380, 400, 50);
		boton.setBackground(Color.decode("#e8d8ff"));
		boton.setBorderPainted(false);
		JLabel profBoton = new JLabel();
		profBoton.setBounds(27, 383, 400, 50);
		profBoton.setBackground(Color.decode("#cfb1ff"));
		profBoton.setOpaque(true);
		panel.add(boton); 
		panel.add(profBoton);
		profBoton.repaint();
		boton.repaint();
		
		//CheckBox recordar usuario
		JCheckBox recordarme = new JCheckBox("Recordarme");
		recordarme.setBounds(23, 310, 150, 20);
		recordarme.setFont(new Font("Calibri", Font.BOLD, 18));
		recordarme.setForeground(Color.GRAY);
		recordarme.setOpaque(false);
		panel.add(recordarme);
		recordarme.repaint();
		
		//JLabel olvidé contraseña
		JLabel olvide = new JLabel ("Olvidé mi contraseña");
		olvide.setFont(new Font("Calibri", Font.BOLD, 18));
		olvide.setForeground(Color.GRAY);
		olvide.setBounds(262, 310, 200, 20);
		panel.add(olvide);
		olvide.repaint();
		
	}
	*/
	
	public Ventana () {
		
		setTitle("Registrarse");
		setLayout(null);
		setVisible(true);
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#e8d8fd"));
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(17, 15, 450, 530);
		panel.setLayout(null);
		add(panel);
		
		//Etiqueta "Registrarse"
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Registrarse");
		panel.add(etiqueta);
		etiqueta.setBounds(130, 45, 300, 50);
		etiqueta.setFont(new Font("Calibri", Font.PLAIN, 40));
		
		
		//TextField para nombre
		JTextField password = new JTextField("   Nombre de usuario");
		password.setFont(new Font ("Calibri", Font.BOLD, 22));
		password.setForeground(Color.GRAY.brighter());
		password.setBounds(25, 130, 400, 60);
		password.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(password);
		password.repaint();

		//TextArea para Biografía
		JTextArea bio = new JTextArea("\n   Descripción / Bio");
		bio.setFont(new Font ("Calibri", Font.BOLD, 22));
		bio.setForeground(Color.GRAY.brighter());
		bio.setBounds(25, 210, 400, 100);
		bio.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(bio);
		bio.repaint();
		
		//Botón
		JButton boton = new JButton();
		boton.setText("Crear cuenta");
		boton.setFont(new Font("Calibri", Font.PLAIN, 28));
		boton.setBounds(25, 440, 400, 50);
		boton.setBackground(Color.decode("#e8d8ff"));
		boton.setBorderPainted(false);
		JLabel profBoton = new JLabel();
		profBoton.setBounds(27, 443, 400, 50);
		profBoton.setBackground(Color.decode("#cfb1ff"));
		profBoton.setOpaque(true);
		panel.add(boton); 
		panel.add(profBoton);
		profBoton.repaint();
		boton.repaint();
		
		
		//RadioButtons términos
		JRadioButton acepto = new JRadioButton("Acepto");
		acepto.setBounds(230, 320, 100, 20);
		acepto.setFont(new Font("Calibri", Font.BOLD, 18));
		acepto.setForeground(Color.GRAY);
		acepto.setOpaque(false);
		panel.add(acepto);
		acepto.repaint();
		
		JRadioButton noAcepto = new JRadioButton("No acepto");
		noAcepto.setBounds(324, 320, 150, 20);
		noAcepto.setFont(new Font("Calibri", Font.BOLD, 18));
		noAcepto.setForeground(Color.GRAY);
		noAcepto.setOpaque(false);
		panel.add(noAcepto);
		noAcepto.repaint();
		
		//Crear grupo para los dos botones
		ButtonGroup terminos = new ButtonGroup();
		terminos.add(acepto);
		terminos.add(noAcepto);
		
		JLabel lTerminos = new JLabel("Aceptar términos: ");
		lTerminos.setFont(new Font("Calibri", Font.BOLD, 18));
		lTerminos.setBounds(30,320,200,20);
		lTerminos.setForeground(Color.GRAY);
		panel.add(lTerminos);
		lTerminos.repaint();
		
		//Preferencias
		JLabel pref = new JLabel("Preferencias: ");
		pref.setFont(new Font("Calibri", Font.BOLD, 18));
		pref.setForeground(Color.GRAY);
		pref.setBounds(30, 360, 150, 20);
		panel.add(pref);
		pref.repaint();
		
		JCheckBox salado = new JCheckBox("Salado");
		salado.setBounds(150, 360, 80, 20);
		salado.setFont(new Font("Calibri", Font.BOLD, 18));
		salado.setForeground(Color.GRAY);
		salado.setOpaque(false);
		panel.add(salado);
		salado.repaint();
		
		JCheckBox dulce = new JCheckBox("Dulce");
		dulce.setBounds(240, 360, 70, 20);
		dulce.setFont(new Font("Calibri", Font.BOLD, 18));
		dulce.setForeground(Color.GRAY);
		dulce.setOpaque(false);
		panel.add(dulce);
		dulce.repaint();
		
		JCheckBox saludable = new JCheckBox("Saludable");
		saludable.setBounds(324, 360, 100, 20);
		saludable.setFont(new Font("Calibri", Font.BOLD, 18));
		saludable.setForeground(Color.GRAY);
		saludable.setOpaque(false);
		panel.add(saludable);
		saludable.repaint();
		
		JComboBox<String> ComboBoxColonias = new JComboBox<String>();
		ComboBoxColonias.addItem("Miramar");
		ComboBoxColonias.addItem("Santa Fé");
		ComboBoxColonias.addItem("Camino real");
		ComboBoxColonias.addItem("Pedregal");
		ComboBoxColonias.setBounds(70, 400, 300, 20);
		ComboBoxColonias.setBackground(Color.WHITE);
		panel.add(ComboBoxColonias);
		ComboBoxColonias.repaint();
		
		
		
	}
	
}