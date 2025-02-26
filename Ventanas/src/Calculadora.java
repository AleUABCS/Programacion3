import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

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
		setVisible(true);
		setSize(500, 620);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		
		JPanel panelFrame = new JPanel();
		panelFrame.setLayout(new BorderLayout());
		add(panelFrame);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panelFrame.add(panel, BorderLayout.NORTH);
		
		//Pantalla
		JLabel pantalla = new JLabel("                  0");
		pantalla.setHorizontalTextPosition(SwingConstants.CENTER);
		pantalla.setFont(new Font("Arial", Font.PLAIN, 50));
		pantalla.setBackground(null);
		pantalla.setBorder(new LineBorder(Color.GRAY.brighter()));
		pantalla.setOpaque(true);
		panel.add(pantalla);
		
		JButton botonCE = new JButton ("CE");
		botonCE.setFont(fuente);
		panel.add(botonCE);
		botonCE.setBackground(Color.WHITE);

		
		
		//Crear botones
		
		String[][] matrizBotones = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
		};
		
		//Panel para los botones
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(43, 115, 400, 450);
		panelFrame.add(panelBotones, BorderLayout.CENTER);
		
		//Crear LayOut
		
		panelBotones.setLayout(new GridLayout(4, 4));
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{	
				JButton boton = new JButton(matrizBotones[i][j]);
				boton.setBackground(Color.decode("#cbcbcb"));
				panelBotones.add(boton);
				
				if ((i == 3 || j == 3) && !boton.getText().equals("0"))
					boton.setBackground(Color.WHITE);
				
			}
		}
		panelBotones.revalidate();
		panelBotones.repaint();
		
		panelFrame.revalidate();
		panelFrame.repaint();
		/*
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
					boton.setBackground(Color.decode("#cbcbcb"));
				boton.setFont(fuente);
				boton.setBorder(null);
				panel.add(boton);
				boton.repaint();
			}
		}
		
		JButton boton = new JButton("CE");
		boton.setBounds(320, 10, 90, 100);
		panel.add(boton);
		boton.setBackground(Color.decode("#cbcbcb"));
		boton.setBorder(null);
		boton.setFont(fuente);
		
		*/
	}
	
}
