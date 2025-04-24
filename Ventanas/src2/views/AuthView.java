package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

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


	public AuthView() {
		login();
	}
	
	public JFrame login() {

		setTitle("Iniciar Sesión");
		setLayout(null);
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
		add(panel);

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
		add(panelImagen);

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

		// Menú Cuenta
		// Acción opción Registro
		cuenta_registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(1);
			}
		});

		// Acción opción Login
		cuenta_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(2);
			}
		});

		// Ación opción Recuperar cuenta
		cuenta_recuperar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(3); // Recuperar cuenta
			}
		});

		// Menu Usuario

		// Acción Alta
		usuarios_alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(4);
			}
		});

		ImageIcon iconoVentana = new ImageIcon("IconoVentana.png");
		setIconImage(iconoVentana.getImage());

		// Botón Registro
		botonRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(1); // Registro
			}
		});

		panel.add(botonRegistro);
		botonRegistro.setBounds(305, 440, 120, 30);

		return this;
	}

	public JFrame registro() {

		setTitle("Registrarse");
		setLayout(null);
		setVisible(true);
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));

		// Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(17, 15, 450, 550);
		panel.setLayout(null);
		add(panel);

		// Etiqueta "Registrarse"
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Registrarse");
		panel.add(etiqueta);
		etiqueta.setBounds(130, 45, 300, 50);
		etiqueta.setFont(new Font("Calibri", Font.PLAIN, 40));

		// TextField para nombre
		nombre.setFont(new Font("Calibri", Font.BOLD, 22));
		nombre.setForeground(Color.GRAY.brighter());
		nombre.setBounds(25, 130, 400, 60);
		nombre.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(nombre);
		nombre.repaint();

		// TextArea para Biografía
		bio.setFont(new Font("Calibri", Font.BOLD, 22));
		bio.setForeground(Color.GRAY.brighter());
		bio.setBounds(25, 210, 400, 100);
		bio.setBorder(new LineBorder(Color.GRAY.brighter(), 1));
		panel.add(bio);
		bio.repaint();

		// Botón
		botonFinRegistro.setText("Crear cuenta");
		botonFinRegistro.setFont(new Font("Calibri", Font.PLAIN, 28));
		botonFinRegistro.setBounds(25, 440, 400, 50);
		botonFinRegistro.setBackground(Color.decode("#e8d8ff"));
		botonFinRegistro.setBorderPainted(false);
		JLabel profBoton = new JLabel();
		profBoton.setBounds(27, 443, 400, 50);
		profBoton.setBackground(Color.decode("#cfb1ff"));
		profBoton.setOpaque(true);
		panel.add(botonFinRegistro);
		panel.add(profBoton);
		profBoton.repaint();
		botonFinRegistro.repaint();

		// RadioButtons términos
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

		// Crear grupo para los dos botones
		ButtonGroup terminos = new ButtonGroup();
		terminos.add(acepto);
		terminos.add(noAcepto);

		JLabel lTerminos = new JLabel("Aceptar términos: ");
		lTerminos.setFont(new Font("Calibri", Font.BOLD, 18));
		lTerminos.setBounds(30, 320, 200, 20);
		lTerminos.setForeground(Color.GRAY);
		panel.add(lTerminos);
		lTerminos.repaint();

		// Preferencias
		JLabel pref = new JLabel("Preferencias: ");
		pref.setFont(new Font("Calibri", Font.BOLD, 18));
		pref.setForeground(Color.GRAY);
		pref.setBounds(30, 360, 150, 20);
		panel.add(pref);
		pref.repaint();

		salado.setBounds(150, 360, 80, 20);
		salado.setFont(new Font("Calibri", Font.BOLD, 18));
		salado.setForeground(Color.GRAY);
		salado.setOpaque(false);
		panel.add(salado);
		salado.repaint();

		dulce.setBounds(240, 360, 70, 20);
		dulce.setFont(new Font("Calibri", Font.BOLD, 18));
		dulce.setForeground(Color.GRAY);
		dulce.setOpaque(false);
		panel.add(dulce);
		dulce.repaint();
		
		saludable.setBounds(324, 360, 100, 20);
		saludable.setFont(new Font("Calibri", Font.BOLD, 18));
		saludable.setForeground(Color.GRAY);
		saludable.setOpaque(false);
		panel.add(saludable);
		saludable.repaint();

		ComboBoxColonias.addItem("Miramar");
		ComboBoxColonias.addItem("Santa Fé");
		ComboBoxColonias.addItem("Camino real");
		ComboBoxColonias.addItem("Pedregal");
		ComboBoxColonias.setBounds(70, 400, 300, 20);
		ComboBoxColonias.setBackground(Color.WHITE);
		panel.add(ComboBoxColonias);
		ComboBoxColonias.repaint();

		boton.addActionListener(new ActionListener() {

			LineBorder bordeRojo = new LineBorder(Color.RED, 2);
			LineBorder bordeVerde = new LineBorder(Color.GREEN, 2);

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!nombre.getText().equals(""))
					nombre.setBorder(bordeVerde);
				else
					nombre.setBorder(bordeRojo);

				if (!bio.getText().equals(""))
					bio.setBorder(bordeVerde);
				else
					bio.setBorder(bordeRojo);

				if (!nombre.getText().equals(""))
					nombre.setBorder(bordeVerde);
				else
					nombre.setBorder(bordeRojo);

				if (!acepto.isSelected()) {
					acepto.setBorder(bordeVerde);
				}

			}

		});

		botonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar(2); // Login

			}
		});
		botonLogin.setBounds(325, 500, 100, 30);
		panel.add(botonLogin);

		repaint();

		return this;
	}

	public JFrame recuperar() {

		setTitle("Registrarse");
		setLayout(null);
		setVisible(true);
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));

		JLabel tituloRecuperar = new JLabel("Recuperar cuenta");
		tituloRecuperar.setFont(new Font("", Font.PLAIN, 34));
		tituloRecuperar.setBounds(100, 50, 300, 50);
		add(tituloRecuperar);

		repaint();

		return this;
	}

	public JFrame alta() {
		setTitle("Registrarse");
		setLayout(null);
		setVisible(true);
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#e8d8fd"));

		JLabel titulo = new JLabel("Alta");
		titulo.setFont(new Font("", Font.BOLD, 30));
		titulo.setSize(200, 50);
		add(titulo);

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
		frameInicioSesion.setLayout(null);
		frameInicioSesion.getContentPane().setBackground(Color.decode("#a4d6fe"));
		JLabel mensaje = new JLabel("Inicio de sesión exitoso");
		mensaje.setFont(new Font("Calibri", Font.PLAIN, 34));
		frameInicioSesion.add(mensaje);
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
	
}
