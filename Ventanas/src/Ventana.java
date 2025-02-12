import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	public Ventana () {
		setLayout(null);
		setTitle("Título de la ventana");
		setVisible(true);
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Etiqueta
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Holaaa");
		etiqueta.setBounds(230, 100, 50, 50);
		add(etiqueta);
		
		//Botón
		JButton boton = new JButton();
		boton.setText("Botón");
		boton.setBounds(200, 150, 100, 30);
		add(boton);
	}
	
}
