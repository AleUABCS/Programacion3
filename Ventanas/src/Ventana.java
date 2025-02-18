import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	
	public Ventana () {
		setTitle("Iniciar Sesión");
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
	
}
