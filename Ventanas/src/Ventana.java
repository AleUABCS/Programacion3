import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	public Ventana () {
		setTitle("Título de la ventana");
		setVisible(true);
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#b0c2f2"));
		panel.setSize(getSize());
		add(panel);
		panel.setLayout(null);
		
		//Etiqueta
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Holaaa");
		panel.add(etiqueta);
		etiqueta.setBounds(200, 100, 150, 50);
		etiqueta.setFont(new Font("Consolas", Font.BOLD, 30));
		
		//Botón
		JButton boton = new JButton();
		boton.setText("Botón");
		panel.add(boton); 
		boton.setBounds(200, 150, 100, 30);
	}
	
}
