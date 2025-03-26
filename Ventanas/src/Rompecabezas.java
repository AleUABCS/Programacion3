import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.JobImpressions;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Rompecabezas extends JFrame {
	
	JButton botones[][] = new JButton[4][4];
	Random rand = new Random();
	int matrizNum[][] = new int[4][4];
	int valor;
	int numeros[] = new int[16];
	Font fuente = new Font("", Font.BOLD, 28);


	
	int matrizOrigen[][] = {{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,0},	
							};

	public Rompecabezas () {

		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#a7ec21"));
		
		revalidate();
		repaint();
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		panelGeneral.setOpaque(false);
		
		JPanel panel = new JPanel();
		panelGeneral.add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(20,20,20,20));
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setOpaque(false);
		panelGeneral.add(panelOpciones, BorderLayout.EAST);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.setFont(fuente);
		panelOpciones.add(reiniciar);
		
		add(panelGeneral);
		
		//Generar arreglo de los números del 1 al 15
		 for (int i = 1; i <= 15; i++) {
			 numeros[i-1] = i;
		 }
		 numeros[15] = 0;
		 
		 //Aleatorizar el arreglo en numerosRand
		 aleatorizar();
		 
		 //Añadir los botones
		 int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
					JButton boton = new JButton(Integer.toString(numeros[k]));
					boton.setBackground(Color.decode("#bcff73"));
					boton.setBorder(null);
					boton.setFont(fuente);
					k++;
					botones[j][i] = boton;
					panel.add(botones[j][i]);
					
					//Añadir acciones a los botones
					boton.addActionListener(new ActionListener() {
						int posX, posY, aux;
						String auxStr;
						@Override
						public void actionPerformed(ActionEvent e) {
							valor = Integer.parseInt(boton.getText());
							for (int i = 0; i < 4; i++) {
								 for (int j = 0; j < 4; j++) {
									 if (matrizNum[j][i] == valor) {
										 posX = j;
										 posY = i;
										 break;
									 }
								 }
							 }
							
					
							//Imprimir el número para ver en consola si es correcto
							System.out.println(matrizNum[posX][posY]);
							revalidate();
							
							if (posX + 1 < 4 )
								if (matrizNum[posX+1][posY] == 0) {
									aux = matrizNum[posX][posY];
									matrizNum[posX][posY] = matrizNum[posX+1][posY];
									matrizNum[posX+1][posY] = aux;
									
									botones[posX][posY].setForeground(Color.decode("#bcff73"));
									botones[posX+1][posY].setForeground(Color.decode("#333333"));
									
									auxStr = botones[posX][posY].getText();
									botones[posX][posY].setText(botones[posX+1][posY].getText());
									botones[posX+1][posY].setText(auxStr);
								}
									
							if	(posX - 1 >= 0)
								if (matrizNum[posX-1][posY] == 0) {
									aux = matrizNum[posX][posY];
									matrizNum[posX][posY] = matrizNum[posX-1][posY];
									matrizNum[posX-1][posY] = aux;
									
									botones[posX][posY].setForeground(Color.decode("#bcff73"));
									botones[posX-1][posY].setForeground(Color.decode("#333333"));
									
									auxStr = botones[posX][posY].getText();
									botones[posX][posY].setText(botones[posX-1][posY].getText());
									botones[posX-1][posY].setText(auxStr);									
								}
							
							if	(posY + 1 < 4)
								if (matrizNum[posX][posY + 1] == 0) {
									aux = matrizNum[posX][posY];
									matrizNum[posX][posY] = matrizNum[posX][posY+1];
									matrizNum[posX][posY+1] = aux;
									
									botones[posX][posY].setForeground(Color.decode("#bcff73"));
									botones[posX][posY+1].setForeground(Color.decode("#333333"));
									
									auxStr = botones[posX][posY].getText();
									botones[posX][posY].setText(botones[posX][posY+1].getText());
									botones[posX][posY+1].setText(auxStr);									
								}
							
							if	(posY - 1 >= 0)
								if (matrizNum[posX][posY - 1] == 0) {
									aux = matrizNum[posX][posY];
									matrizNum[posX][posY] = matrizNum[posX][posY-1];
									matrizNum[posX][posY-1] = aux;
									
									botones[posX][posY].setForeground(Color.decode("#bcff73"));
									botones[posX][posY-1].setForeground(Color.decode("#333333"));
									
									auxStr = botones[posX][posY].getText();
									botones[posX][posY].setText(botones[posX][posY-1].getText());
									botones[posX][posY-1].setText(auxStr);									
								}
							imprimirMatriz();
							
							if (validarGanador()) {
								setEnabledBotones(false);
								
								JLabel texto = new JLabel("Ganates!");
								texto.setFont(new Font("", Font.PLAIN, 28));
								
								JOptionPane.showMessageDialog(null, texto);
							}
						}
					});
			}
		}
		
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aleatorizar();
				 int k = 0;
				 for (int i = 0; i < 4; i++) {
					 for (int j = 0; j < 4; j++) {
							 botones[j][i].setText(Integer.toString(numeros[k]));
						 k++;
					 }
				 }
				setEnabledBotones(true);
			}
		});
		botones[3][3].setForeground(Color.decode("#bcff73"));
		revalidate();
		
		imprimirMatriz();
	}
	
	public boolean validarGanador() {
		int cont = 0;
		for (int i = 0; i < 4 && cont < 16; i++) {
			 for (int j = 0; j < 4 && cont < 16; j++) {
				 System.out.println(cont);
				 System.out.println(matrizNum[j][i] + " ");
				 System.out.println(matrizOrigen[j][i]);
					 if (matrizNum[i][j] == matrizOrigen[j][i]) {
						 cont++;
					 } 
					 else
						 cont = 20;
			 }
		 }
		return (cont < 20)? true : false;
	}
	
	public void setEnabledBotones(boolean opc) {
		for (int i = 0; i < 4; i++) {
			 for (int j = 0; j < 4; j++) {
					 botones[j][i].setEnabled(opc);
			 }
		}
	}
	
	public void imprimirMatriz() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(matrizNum[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	public void aleatorizar() {
		 for (int e = 0; e < 100; e++) {
			 int indexR1 = rand.nextInt(0, 15);
			 int indexR2 = rand.nextInt(0, 15);
			 int num1, num2;

			 num1 = numeros[indexR1];
			 numeros[indexR1] = numeros[indexR2];
			 numeros[indexR2] = num1;
			 int k = 0;
			 for (int i = 0; i < 4; i++) {
				 for (int j = 0; j < 4; j++) {
						 matrizNum[j][i] = numeros[k];
					 k++;
				 }
			 }
		 }
	}
	
	public static void main(String[] args) {
		Rompecabezas hola = new Rompecabezas();
	}

}
