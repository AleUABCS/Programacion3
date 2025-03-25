import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Rompecabezas extends JFrame {
	
	JButton botones[][] = new JButton[4][4];
	Random rand = new Random();

	public Rompecabezas () {

		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#a7ec21"));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setBorder(new EmptyBorder(20,20,20,20));
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		//Generar arreglo de los números del 1 al 15
		 int numeros[] = new int[15];
		 for (int i = 1; i <= 15; i++) {
			 numeros[i-1] = i;
		 }
		 
		 //Aleatorizar el arreglo en numerosRand
		 for (int i = 0; i < 100; i++) {
			 int indexR1 = rand.nextInt(1, 15);
			 int indexR2 = rand.nextInt(1, 15);
			 int num1, num2;

			 num1 = numeros[indexR1];
			 numeros[indexR1] = numeros[indexR2];
			 numeros[indexR2] = num1;
		 }
		 int numAux;
		 
		 //Imprimir el arreglo de los números nomás pa saber jeje
		 for (int i = 0; i < 15; i++) {
			 System.out.println(Integer.toString(numeros[i]));
		 }
		
		 //Añadir los botones
		 Font fuente = new Font("", Font.BOLD, 28);
		 int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (k < 15) {					
					JButton boton = new JButton(Integer.toString(numeros[k]));
					boton.setBackground(Color.decode("#bcff73"));
					boton.setBorder(null);
					boton.setFont(fuente);
					k++;
					botones[j][i] = boton;
					panel.add(botones[j][i]);
				}
				else {
					botones[j][i] = new JButton();
					botones[j][i].setBackground(Color.decode("#bcff73"));
					botones[j][i].setBorder(null);
					botones[j][i].setFont(fuente);
					panel.add(botones[j][i]);
				}
			}
		}
		revalidate();
	}
	
	public static void main(String[] args) {
		new Rompecabezas();
	}

}
