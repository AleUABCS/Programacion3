import java.awt.Color; 
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	
	public Ventana () {
		
		setTitle("Iniciar Sesión");
		setLayout(null);
		setVisible(true);
		setSize(1000, 630);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#02a192"));
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#ffd845"));
		panel.setBounds(492, 15, 450, 530);
		panel.setLayout(null);
		add(panel);
		
		//Etiqueta "Iniciar Sesión"
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Iniciar Sesión");
		panel.add(etiqueta);
		etiqueta.setBounds(60, 65, 400, 60);
		etiqueta.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 50));
		
		//TextField para email
		JTextField email = new JTextField ("   Correo electrónico");
		email.setFont(new Font ("Calibri", Font.BOLD, 22));
		email.setForeground(Color.GRAY.brighter());
//		email.setBackground(Color.decode("#ffe4f9"));
		email.setBounds(75, 170, 350, 60);
		email.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(email);
		email.repaint();
		
		//TextField para contraseña
		JTextField password = new JTextField("   Contraseña");
		password.setFont(new Font ("Calibri", Font.BOLD, 22));
		password.setForeground(Color.GRAY.brighter());
		password.setBackground(Color.WHITE);
		password.setBounds(75, 237, 350, 60);
		password.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(password);
		password.repaint();

		//Botón acceder
		JButton boton = new JButton();
		boton.setForeground(Color.BLACK);
		boton.setText("Acceder");
		boton.setFont(new Font("Calibri", Font.PLAIN, 28));
		boton.setBounds(25, 380, 400, 50);
		boton.setBackground(Color.decode("#f883e9"));
		boton.setBorderPainted(false);
		panel.add(boton); 
		boton.repaint();
		JLabel profBoton = new JLabel();
		profBoton.setBounds(27, 383, 400, 50);
		profBoton.setBackground(Color.decode("#a97feb"));
		profBoton.setOpaque(true);
		panel.add(profBoton);
		profBoton.repaint();
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!email.getText().equals(""))
					email.setBorder(new LineBorder(Color.GREEN, 3));
				else
					email.setBorder(new LineBorder(Color.RED, 3));
				
				if (!password.getText().equals(""))
					password.setBorder(new LineBorder(Color.GREEN, 3));
				else
					password.setBorder(new LineBorder(Color.RED, 3));
			}
		});
		
		//CheckBox recordar usuario
		JCheckBox recordarme = new JCheckBox("Recordarme");
		recordarme.setBounds(71, 310, 150, 20);
		recordarme.setFont(new Font("Calibri", Font.BOLD, 18));
		recordarme.setForeground(Color.BLACK);
		recordarme.setOpaque(false);
		panel.add(recordarme);
		recordarme.repaint();
		
		//JLabel olvidé contraseña
		JLabel olvide = new JLabel ("Olvidé mi contraseña");
		olvide.setFont(new Font("Calibri", Font.BOLD, 18));
		olvide.setForeground(Color.BLACK);
		olvide.setBounds(262, 310, 200, 20);
		panel.add(olvide);
		olvide.repaint();
		
		//Crear panel para la imagen
		JPanel panelImagen = new JPanel();
		panelImagen.setLayout(null);
		panelImagen.setBounds(42, 15, 450, 530);
		add(panelImagen);
		
		//Crear imagen
		ImageIcon imagen = new ImageIcon("GumLogin.jpeg");
		
		//Crear etiqueta para la imagen
		JLabel etiquetaImagen = new JLabel("", JLabel.CENTER);
		etiquetaImagen.setBounds(0, 0, panelImagen.getWidth(), panelImagen.getHeight());
		
		Icon escalar = new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH));
		etiquetaImagen.setIcon(escalar);
		
		panelImagen.add(etiquetaImagen);
		etiquetaImagen.repaint();
		
		//Crear imagenes de los iconos de los TextFields
		
		//Imagen del TextField del correo
		JLabel eCorreo = new JLabel ("", JLabel.CENTER);
		eCorreo.setBounds(15,175,50, 53);
		ImageIcon iCorreo = new ImageIcon("IconoCorreo.png");
		
		Icon escalarCorreo = new ImageIcon(iCorreo.getImage().getScaledInstance(eCorreo.getWidth(), eCorreo.getHeight(), Image.SCALE_SMOOTH));
		eCorreo.setIcon(escalarCorreo);
		panel.add(eCorreo);
		eCorreo.repaint();
		
		//Imagen del TextField de la contraseña
		
		JLabel eContra = new JLabel ("", JLabel.CENTER);
		eContra.setBounds(15,242, 50, 53);
		ImageIcon IContraseña = new ImageIcon("Candado.png");
		
		Icon escalarContra = new ImageIcon(IContraseña.getImage().getScaledInstance(eContra.getWidth(), eContra.getHeight(), Image.SCALE_SMOOTH));
		eContra.setIcon(escalarContra);
		panel.add(eContra);
		eContra.repaint();
		
		//Crear MenuBar
		
		JMenuBar barra = new JMenuBar();
		barra.setBorder(new LineBorder(Color.decode("#01544c")));
		barra.setBackground(Color.decode("#01544c"));
		
		//Crear Categorías del Menu
		JMenu archivo = new JMenu("Archivo");
		archivo.setForeground(Color.WHITE);
		JMenu editar = new JMenu("Editar");
		editar.setForeground(Color.WHITE);
		
		barra.add(archivo);
		barra.add(editar);
		
		setJMenuBar(barra);
		
		barra.repaint();
		barra.revalidate();
		
		//Crear elementos de la categoría Archivo
		
		JMenuItem archivo_nuevo = new JMenuItem("Nuevo");
		JMenuItem archivo_abrir = new JMenuItem("Abrir");
		JMenuItem archivo_guardar = new JMenuItem("Guardar");
		JMenuItem archivo_guardarComo = new JMenuItem("Guardar como");
		archivo.add(archivo_nuevo);
		archivo.add(archivo_abrir);
		archivo.add(archivo_guardar);
		archivo.add(archivo_guardarComo);

		
		//Crear elementos de la categoría Editar
		JMenuItem editar_deshacer = new JMenuItem("Deshacer");
		JMenuItem editar_rehacer = new JMenuItem("Rehacer");
		editar.add(editar_deshacer);
		editar.add(editar_rehacer);
		
		ImageIcon iconoVentana = new ImageIcon("IconoVentana.png");
		setIconImage(iconoVentana.getImage());
	
	/*
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

		//TextArea para Biografía
		JTextArea bio = new JTextArea("\n   Descripción / Bio");
		bio.setFont(new Font ("Calibri", Font.BOLD, 22));
		bio.setForeground(Color.GRAY.brighter());
		bio.setBounds(25, 210, 400, 100);
		bio.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(bio);
		bio.repaint();
		
		//Botón
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
		
		
		//RadioButtons términos
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
		
		JLabel lTerminos = new JLabel("Aceptar términos: ");
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
		ComboBoxColonias.addItem("Santa Fé");
		ComboBoxColonias.addItem("Camino real");
		ComboBoxColonias.addItem("Pedregal");
		ComboBoxColonias.setBounds(70, 400, 300, 20);
		ComboBoxColonias.setBackground(Color.WHITE);
		panel.add(ComboBoxColonias);
		ComboBoxColonias.repaint();
		*/
		
		/*
		setTitle("Tabla");
		setLayout(null);
		setSize(900,600);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.ORANGE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setSize(getSize());
		panel.setBackground(null);
		panel.setLayout(null);
		add(panel);
		
		
		JLabel textoUsuarios = new JLabel("USUARIOS");
		textoUsuarios.setFont(new Font("Calibri", Font.PLAIN, 64));
		textoUsuarios.setBounds(320, 30, 300, 80);
		panel.add(textoUsuarios);
		
		JLabel totalUsuarios = new JLabel("Total usuarios: 100");
		totalUsuarios.setFont(new Font("Calibri", Font.PLAIN, 28));
		totalUsuarios.setBounds(340, 100, 300, 80);
		panel.add(totalUsuarios);
		
		//Crear tabla
		String [] barraSup = {"Nombre", "Apellido", "Game", "Edad", "Vegetariano"};
		
		Object [][] datos = {
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				{"Angel", "Daniel", "Hollow Knight", 20, "No"},
				
				
				
		};
		
		JTable tabla = new JTable(datos, barraSup);
		
		JScrollPane scroll = new JScrollPane(tabla);
		
		scroll.setBounds(60,200,765,300);
		panel.add(scroll);
		scroll.repaint();
		*/
	}
	
	
}