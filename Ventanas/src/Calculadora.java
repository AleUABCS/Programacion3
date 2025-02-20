import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.Position;

public class Calculadora extends JFrame {

	public Calculadora () {
		
		Font fuente = new Font("Arial", Font.PLAIN, 30);
		
		setTitle("Calculadora");
		setLayout(null);
		setVisible(true);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBounds(17, 15, 450, 530);
		panel.setBackground(null);
		panel.setLayout(null);
		add(panel);
		
		//Pantalla
		JLabel pantalla = new JLabel("                  0");
		pantalla.setHorizontalTextPosition(SwingConstants.CENTER);;
		pantalla.setFont(new Font("Arial", Font.PLAIN, 50));
		pantalla.setBounds (20, 10, 290, 100);
		pantalla.setBackground(null);
		pantalla.setBorder(new LineBorder(Color.GRAY.brighter()));
		pantalla.setOpaque(true);
		panel.add(pantalla);
		
		//Crear botones
		
		String[][] matrizBotones = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
		};
                
		for (int i = 0; i < 4; i ++)
		{
			for (int j = 0; j < 4; j ++)
			{
				JButton boton = new JButton(matrizBotones[j][i]);
				boton.setBounds(20+i*100, 130+j*100, 90, 90);
				boton.setForeground(Color.GRAY);
				if (j == 0 || i == 3)
					boton.setBackground(Color.decode("#e5edff"));
				else if (boton.getText().equals("="))
				{
					boton.setBackground(Color.decode("#0b57d0"));
					boton.setForeground(Color.WHITE);
				}
				else
					boton.setBackground(Color.decode("#f3f5f6"));
				boton.setFont(fuente);
				boton.setBorder(null);
				panel.add(boton);
				boton.repaint();
			}
		}
		
		JButton boton = new JButton("CE");
		boton.setBounds(320, 10, 90, 100);
		panel.add(boton);
		boton.setBackground(Color.decode("#f3f5f6"));
		boton.setBorder(null);
		boton.setFont(fuente);
		
	}
	
}
