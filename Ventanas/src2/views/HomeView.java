package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlers.HomeController;
import models.HomeModel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

public class HomeView {

	private JFrame frame = new JFrame();
	private JButton boton_usuarios = new JButton("Usuarios");
	private JButton boton_registros = new JButton("Registros");
	private JButton boton_configuracion = new JButton("Configuración");
	
	HomeController homeController;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeView window = new HomeView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public HomeView() {
		HomeModel homeModel = new HomeModel();
		homeController = new HomeController(HomeView.this, homeModel);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 650, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Leelawadee UI", Font.PLAIN, 32));
		panel.add(lblHome, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 2, 60, 20));
		panel_1.setBorder(new EmptyBorder(10,60,20,60));
		
		JPanel panel_usuarios = new JPanel();
		panel_usuarios.setBackground(new Color(224, 224, 224));
		panel_1.add(panel_usuarios);
		panel_usuarios.setBorder(new LineBorder(Color.decode("#3d9ae2")));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(HomeView.class.getResource("/files/imgUsuarios.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		panel_usuarios.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Usuarios: 18");
		lblNewLabel_4.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		panel_usuarios.add(lblNewLabel_4);
		
		JPanel panel_notificaciones = new JPanel();
		panel_notificaciones.setBackground(new Color(224, 224, 224));
		panel_1.add(panel_notificaciones);
		panel_notificaciones.setBorder(new LineBorder(Color.decode("#3d9ae2")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(HomeView.class.getResource("/files/campana.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		panel_notificaciones.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Notificaciones: 3");
		lblNewLabel_6.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		panel_notificaciones.add(lblNewLabel_6);
		
		JPanel panel_hora = new JPanel();
		panel_hora.setBackground(new Color(224, 224, 224));
		panel_1.add(panel_hora);
		panel_hora.setBorder(new LineBorder(Color.decode("#3d9ae2")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(HomeView.class.getResource("/files/reloj.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		panel_hora.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Hora del sistema");
		lblNewLabel_5.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		panel_hora.add(lblNewLabel_5);
		
		JPanel panel_estadisticas = new JPanel();
		panel_estadisticas.setBackground(new Color(224, 224, 224));
		panel_1.add(panel_estadisticas);
		panel_estadisticas.setBorder(new LineBorder(Color.decode("#3d9ae2")));

		JLabel lblNewLabel_3 = new JLabel("");
		panel_estadisticas.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(new ImageIcon(HomeView.class.getResource("/files/estadisticas.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel_7 = new JLabel("Estadísticas");
		lblNewLabel_7.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		panel_estadisticas.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(52);
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setBorder(new EmptyBorder(0,0,20,0));
		
		boton_usuarios.setBackground(new Color(224, 224, 224));
		boton_usuarios.setFont(new Font("Leelawadee UI", Font.PLAIN, 22));
		panel_2.add(boton_usuarios);
		
		boton_registros.setBackground(new Color(224, 224, 224));
		boton_registros.setFont(new Font("Leelawadee UI", Font.PLAIN, 22));
		panel_2.add(boton_registros);
		
		boton_configuracion.setBackground(new Color(224, 224, 224));
		boton_configuracion.setFont(new Font("Leelawadee UI", Font.PLAIN, 22));
		panel_2.add(boton_configuracion);
	}
	
	public void ventanaOptionPane () {
		JOptionPane.showMessageDialog(null, "Nueva ventana");
	}

	public JButton getBoton_usuarios() {
		return boton_usuarios;
	}

	public JButton getBoton_registros() {
		return boton_registros;
	}

	public JButton getBoton_configuracion() {
		return boton_configuracion;
	}

	public JFrame getFrame() {
		return frame;
	}
	
}
