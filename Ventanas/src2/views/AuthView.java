package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthView extends JFrame {
	
	private JTextField email;
	private JButton boton;
	private JTextField password;
	private JPanel panel;
	private JLabel mensajeError = new JLabel("Contraseña o correo incorrectos");
	private JButton botonLogin = new JButton("Volver");
	private JButton botonRegistro = new JButton("Crear cuenta");
	private JTextField nombre = new JTextField("   Nombre de usuario");
	private JTextArea bio = new JTextArea("\n   Descripción / Bio");
	private JComboBox<String> ComboBoxColonias = new JComboBox<String>();
	private JButton botonFinRegistro = new JButton();
	private JCheckBox salado = new JCheckBox("Salado");
	private JCheckBox dulce = new JCheckBox("Dulce");
	private JCheckBox saludable = new JCheckBox("Saludable");
	private JButton boton_home= new JButton("Inicio");

	
	JTextField textFieldNombres;
	JTextField textFieldApellidos;
	JTextField textFieldEmpresa;
	JTextField textFieldCargo;
	JTextField textFieldNombreUsuario;
	JTextField textFieldContraseña;
	JTextField textFieldRepetirContraseña;
	JTextField textFieldCorreo;
	JButton registrar = new JButton ("Registrar");
	JComboBox ambitoEmpresa;


	public AuthView() {
		login();
	}
	
	public JFrame login() {

		setTitle("Iniciar Sesión");
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1000, 630);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#02a192"));

		// Panel
		panel = new JPanel();
		panel.setBackground(Color.decode("#ffd845"));
		panel.setBounds(492, 15, 450, 530);
		panel.setLayout(null);
		getContentPane().add(panel);

		// Etiqueta "Iniciar Sesión"
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Iniciar Sesión");
		panel.add(etiqueta);
		etiqueta.setBounds(60, 65, 400, 60);
		etiqueta.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 50));

		// TextField para email
		email = new JTextField("   Correo electrónico");
		email.setFont(new Font("Calibri", Font.BOLD, 22));
		email.setForeground(Color.GRAY.brighter());
//		email.setBackground(Color.decode("#ffe4f9"));
		email.setBounds(75, 170, 350, 60);
		email.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(email);
		email.repaint();

		// TextField para contraseña
		password = new JTextField("   Contraseña");
		password.setFont(new Font("Calibri", Font.BOLD, 22));
		password.setForeground(Color.GRAY.brighter());
		password.setBackground(Color.WHITE);
		password.setBounds(75, 237, 350, 60);
		password.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(password);
		password.repaint();

		// Botón acceder
		boton = new JButton();
		
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

		

		// CheckBox recordar usuario
		JCheckBox recordarme = new JCheckBox("Recordarme");
		recordarme.setBounds(71, 310, 150, 20);
		recordarme.setFont(new Font("Calibri", Font.BOLD, 18));
		recordarme.setForeground(Color.BLACK);
		recordarme.setOpaque(false);
		panel.add(recordarme);
		recordarme.repaint();

		// JLabel olvidé contraseña
		JLabel olvide = new JLabel("Olvidé mi contraseña");
		olvide.setFont(new Font("Calibri", Font.BOLD, 18));
		olvide.setForeground(Color.BLACK);
		olvide.setBounds(262, 310, 200, 20);
		panel.add(olvide);
		olvide.repaint();

		// Crear panel para la imagen
		JPanel panelImagen = new JPanel();
		panelImagen.setLayout(null);
		panelImagen.setBounds(42, 15, 450, 530);
		getContentPane().add(panelImagen);

		// Crear imagen
		ImageIcon imagen = new ImageIcon("GumLogin.jpeg");

		// Crear etiqueta para la imagen
		JLabel etiquetaImagen = new JLabel("", JLabel.CENTER);
		etiquetaImagen.setBounds(0, 0, panelImagen.getWidth(), panelImagen.getHeight());

		Icon escalar = new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImagen.getWidth(),
				etiquetaImagen.getHeight(), Image.SCALE_SMOOTH));
		etiquetaImagen.setIcon(escalar);

		panelImagen.add(etiquetaImagen);
		etiquetaImagen.repaint();

		// Crear imagenes de los iconos de los TextFields

		// Imagen del TextField del correo
		JLabel eCorreo = new JLabel("", JLabel.CENTER);
		eCorreo.setBounds(15, 175, 50, 53);
		ImageIcon iCorreo = new ImageIcon("IconoCorreo.png");

		Icon escalarCorreo = new ImageIcon(
				iCorreo.getImage().getScaledInstance(eCorreo.getWidth(), eCorreo.getHeight(), Image.SCALE_SMOOTH));
		eCorreo.setIcon(escalarCorreo);
		panel.add(eCorreo);
		eCorreo.repaint();

		// Imagen del TextField de la contraseña

		JLabel eContra = new JLabel("", JLabel.CENTER);
		eContra.setBounds(15, 242, 50, 53);
		ImageIcon IContraseña = new ImageIcon("Candado.png");

		Icon escalarContra = new ImageIcon(
				IContraseña.getImage().getScaledInstance(eContra.getWidth(), eContra.getHeight(), Image.SCALE_SMOOTH));
		eContra.setIcon(escalarContra);
		panel.add(eContra);
		eContra.repaint();

		// Crear MenuBar
		JMenuBar barra = new JMenuBar();
		barra.setBorder(new LineBorder(Color.decode("#01544c")));
		barra.setBackground(Color.decode("#01544c"));

		// Crear Categorías del Menu
		JMenu archivo = new JMenu("Archivo");
		archivo.setForeground(Color.WHITE);
		JMenu editar = new JMenu("Editar");
		editar.setForeground(Color.WHITE);
		JMenu cuenta = new JMenu("Cuenta");
		cuenta.setForeground(Color.WHITE);
		JMenu usuarios = new JMenu("Usuarios");
		usuarios.setForeground(Color.WHITE);
		JMenu ayuda = new JMenu("Aiuda");
		ayuda.setForeground(Color.WHITE);

		barra.add(archivo);
		barra.add(editar);
		barra.add(cuenta);
		barra.add(usuarios);
		barra.add(ayuda);

		setJMenuBar(barra);

		barra.repaint();
		barra.revalidate();

		// Crear elementos de la categoría Archivo

		JMenuItem archivo_nuevo = new JMenuItem("Nuevo");
		JMenuItem archivo_abrir = new JMenuItem("Abrir");
		JMenuItem archivo_guardar = new JMenuItem("Guardar");
		JMenuItem archivo_guardarComo = new JMenuItem("Guardar como");
		archivo.add(archivo_nuevo);
		archivo.add(archivo_abrir);
		archivo.add(archivo_guardar);
		archivo.add(archivo_guardarComo);

		// Crear elementos de la categoría Editar
		JMenuItem editar_deshacer = new JMenuItem("Deshacer");
		JMenuItem editar_rehacer = new JMenuItem("Rehacer");
		editar.add(editar_deshacer);
		editar.add(editar_rehacer);

		// Elementos de categoría Cuenta
		JMenuItem cuenta_registro = new JMenuItem("Registro");
		JMenuItem cuenta_login = new JMenuItem("Login");
		JMenuItem cuenta_recuperar = new JMenuItem("Recuperar cuenta");
		cuenta.add(cuenta_registro);
		cuenta.add(cuenta_login);
		cuenta.add(cuenta_recuperar);

		// Elementos de categoría Usuarios
		JMenuItem usuarios_alta = new JMenuItem("Alta");
		JMenuItem usuarios_baja = new JMenuItem("Baja");
		JMenuItem usuarios_consultar = new JMenuItem("Consultar");
		usuarios.add(usuarios_alta);
		usuarios.add(usuarios_baja);
		usuarios.add(usuarios_consultar);

		// Elementos de categoría Ayuda
		JMenuItem ayuda_crear = new JMenuItem("¿Cómo crear un usuario?");
		JMenuItem ayuda_acceder = new JMenuItem("Cómo acceder al sistema?");
		JMenuItem ayuda_olvideContra = new JMenuItem("¿Cómo crear un usuario?");
		ayuda.add(ayuda_crear);
		ayuda.add(ayuda_acceder);
		ayuda.add(ayuda_olvideContra);

		// Aciones del menú

		ImageIcon iconoVentana = new ImageIcon("IconoVentana.png");
		setIconImage(iconoVentana.getImage());
		botonRegistro.setBackground(new Color(224, 224, 224));

		panel.add(botonRegistro);
		botonRegistro.setBounds(305, 440, 120, 30);
		
		boton_home.setBackground(new Color(224, 224, 224));
		boton_home.setBounds(25, 441, 120, 30);
		panel.add(boton_home);
		boton_home.repaint();

		return this;
	}

	public JFrame registro() {

		setTitle("Registrarse");
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 30, 30, 30));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(9, 2, 0, 5));
		
		JLabel labelNombres = new JLabel("Nombres");
		panel.add(labelNombres);
		
		textFieldNombres = new JTextField();
		panel.add(textFieldNombres);
		textFieldNombres.setColumns(10);
		
		JLabel labelApellidos = new JLabel("Apellidos");
		panel.add(labelApellidos);
		
		textFieldApellidos = new JTextField();
		panel.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel labelEmpresa = new JLabel("Empresa");
		panel.add(labelEmpresa);
		
		textFieldEmpresa = new JTextField();
		panel.add(textFieldEmpresa);
		textFieldEmpresa.setColumns(10);
		
		JLabel labelAmbitoEmpresa = new JLabel("Ambito de la empresa");
		panel.add(labelAmbitoEmpresa);
		
		ambitoEmpresa = new JComboBox();
		ambitoEmpresa.setBackground(Color.WHITE);
		ambitoEmpresa.addItem("Tecnología");
		ambitoEmpresa.addItem("Salud");
		ambitoEmpresa.addItem("Educación");
		ambitoEmpresa.addItem("Comercio");
		ambitoEmpresa.addItem("Otro");

		panel.add(ambitoEmpresa);
		
		JLabel labelCargo = new JLabel("Cargo");
		panel.add(labelCargo);
		
		textFieldCargo = new JTextField();
		panel.add(textFieldCargo);
		textFieldCargo.setColumns(10);
		
		JLabel labelNombreUsuario = new JLabel("Nombre de usuario");
		panel.add(labelNombreUsuario);
		
		textFieldNombreUsuario = new JTextField();
		panel.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		panel.add(labelContraseña);
		
		textFieldContraseña = new JTextField();
		panel.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel labelRepetirContraseña = new JLabel("Repetir contraseña");
		panel.add(labelRepetirContraseña);
		
		textFieldRepetirContraseña = new JTextField();
		panel.add(textFieldRepetirContraseña);
		textFieldRepetirContraseña.setColumns(10);
		
		JLabel labelCorreo = new JLabel("Coreo electrónico");
		panel.add(labelCorreo);
		
		textFieldCorreo = new JTextField();
		panel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new GridLayout(1, 3));
		panelBoton.setBorder(new EmptyBorder(0,20,20,20));
		
		panelBoton.add(new JLabel());
		
		registrar.setBackground(Color.WHITE);
		panelBoton.add(registrar);
		
		panelBoton.add(new JLabel());
		
		getContentPane().add(panelBoton, BorderLayout.SOUTH);
		
		repaint();
		revalidate();

		return this;
	}

	public JFrame recuperar() {

		setTitle("Registrarse");
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));

		JLabel tituloRecuperar = new JLabel("Recuperar cuenta");
		tituloRecuperar.setFont(new Font("", Font.PLAIN, 34));
		tituloRecuperar.setBounds(100, 50, 300, 50);
		getContentPane().add(tituloRecuperar);

		repaint();

		return this;
	}

	public JFrame alta() {
		setTitle("Registrarse");
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));

		JLabel titulo = new JLabel("Alta");
		titulo.setFont(new Font("", Font.BOLD, 30));
		titulo.setSize(200, 50);
		getContentPane().add(titulo);

		repaint();
		return this;
	}

	public void cambiar(int target) {
		this.getContentPane().removeAll();

		switch (target) {
		// Cuenta
		case 1: // Registro
			this.registro();
			break;

		case 2: // Login
			this.login();
			break;

		case 3: // Recuperar cuenta
			this.recuperar();
			break;

		// Usuarios
		case 4: // Alta
			this.alta();
			break;
		}
	}
	
	public void setEmailGreen () {
		email.setBorder(new LineBorder(Color.GREEN, 3));
	}
	
	public void setEmailRed () {
		email.setBorder(new LineBorder(Color.RED, 3));
	}
	
	public void setPasswordGreen () {
		password.setBorder(new LineBorder(Color.GREEN, 3));
	}
	
	public void setPasswordRed () {
		password.setBorder(new LineBorder(Color.RED, 3));
	}
	
	public void showAccessSuccess () {
		JFrame frameInicioSesion = new JFrame();
		frameInicioSesion.setTitle("Información");
		frameInicioSesion.setSize(400, 300);
		frameInicioSesion.setLocationRelativeTo(null);
		frameInicioSesion.getContentPane().setLayout(null);
		frameInicioSesion.getContentPane().setBackground(Color.decode("#a4d6fe"));
		JLabel mensaje = new JLabel("Inicio de sesión exitoso");
		mensaje.setFont(new Font("Calibri", Font.PLAIN, 34));
		frameInicioSesion.getContentPane().add(mensaje);
		mensaje.setBounds(30, 100, 340, 50);
		frameInicioSesion.setVisible(true);
		mensajeError.setVisible(false);
	}
	
	public void showAccesDenied () {
		panel.add(mensajeError);
		mensajeError.setVisible(true);
		mensajeError.setBounds(235, 125, 250, 50);
		mensajeError.setForeground(Color.RED);
	}

	public JTextField getEmail() {
		return email;
	}

	public JButton getBoton() {
		return boton;
	}

	public JTextField getPassword() {
		return password;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getMensajeError() {
		return mensajeError;
	}

	public JButton getBotonLogin() {
		return botonLogin;
	}

	public JButton getBotonRegistro() {
		return botonRegistro;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextArea getBio() {
		return bio;
	}

	public JComboBox<String> getComboBoxColonias() {
		return ComboBoxColonias;
	}

	public JButton getBotonFinRegistro() {
		return botonFinRegistro;
	}

	public JCheckBox getSalado() {
		return salado;
	}

	public JCheckBox getDulce() {
		return dulce;
	}

	public JCheckBox getSaludable() {
		return saludable;
	}

	public JTextField getTextFieldNombres() {
		return textFieldNombres;
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public JTextField getTextFieldEmpresa() {
		return textFieldEmpresa;
	}

	public JTextField getTextFieldCargo() {
		return textFieldCargo;
	}

	public JTextField getTextFieldNombreUsuario() {
		return textFieldNombreUsuario;
	}

	public JTextField getTextFieldContraseña() {
		return textFieldContraseña;
	}

	public JTextField getTextFieldRepetirContraseña() {
		return textFieldRepetirContraseña;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public JComboBox getAmbitoEmpresa() {
		return ambitoEmpresa;
	}

	public JButton getBoton_home() {
		return boton_home;
	}
	
}
