import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Gato extends JFrame {
	
	public int turno = 1;
	public int[][] tablero = {  {0,-1,-2},
								{-2,-3,-1},
								{-1,-2,0}
									  };
	JButton boton1 = new JButton();
	JButton boton2 = new JButton();
	JButton boton3 = new JButton();
	JButton boton4 = new JButton();
	JButton boton5 = new JButton();
	JButton boton6 = new JButton();
	JButton boton7 = new JButton();
	JButton boton8 = new JButton();
	JButton boton9 = new JButton();
	
	int contadorX = 0;
	int contadorO = 0;
	int jugadas = 0;
	
	JPanel panelContador = new JPanel();
	JLabel labelContadorX = new JLabel("X: 0");
	JLabel labelContadorO = new JLabel("O: 0");
	
	//Definir imágenes de los íconos
	ImageIcon iconoX = new ImageIcon("XGato.png");
	ImageIcon iconoO = new ImageIcon("OGato.png");
	//Escalar los íconos
	Icon iconoXE = new ImageIcon(iconoX.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
	Icon iconoOE = new ImageIcon(iconoO.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
	
	Icon iconoXEDialog = new ImageIcon(iconoX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	Icon iconoOEDialog = new ImageIcon(iconoO.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	
	public Gato() {
		setSize(500,580);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#f7e4b4"));
		
		Font fuente = new Font("", Font.BOLD, 28);
		
		//Panel general
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		add(panel);
		
		//Panel del tablero
		JPanel panelTablero = new JPanel();
		panelTablero.setBorder(new EmptyBorder(10,10,10,10));
		panelTablero.setLayout(new GridLayout(3,3,5,5));
		panelTablero.setOpaque(false);
		panel.add(panelTablero, BorderLayout.CENTER);
		
		JPanel panelReiniciar = new JPanel();
		JButton botonReiniciar = new JButton ("Reiniciar");
		botonReiniciar.setFont(fuente);
		panelReiniciar.add(botonReiniciar);
		panel.add(botonReiniciar, BorderLayout.SOUTH);
		botonReiniciar.setBackground(Color.WHITE);
		
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciar();
			}
		});
		
		panelContador.setOpaque(false);
		labelContadorX.setFont(fuente);
		labelContadorO.setFont(fuente);
		labelContadorO.setBorder(new EmptyBorder(0, 200, 0, 0));
		panelContador.add(labelContadorX);
		panelContador.add(labelContadorO);
		
		
		panel.add(panelContador, BorderLayout.NORTH);
		
		panelTablero.add(boton1);
		boton1.setFont(fuente);
		boton1.setBackground(Color.WHITE);
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (tablero[0][0] != 1 && tablero[0][0] != 2){
					tablero[0][0] = turno;
					if (turno == 1) {
						boton1.setIcon(iconoXE);
						turno = 2;
					}else {
						boton1.setIcon(iconoOE);

						turno = 1;
					}
					evaluar();
				}
				System.out.println(impTablero());
			}
		});
		
		panelTablero.add(boton2);
		boton2.setFont(fuente);
		boton2.setBackground(Color.WHITE);
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[1][0] != 1 && tablero[1][0] != 2){
					tablero[1][0] = turno;
					if (turno == 1) {
						boton2.setIcon(iconoXE);
						turno = 2;
					}else {
						boton2.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		panelTablero.add(boton3);
		boton3.setFont(fuente);
		boton3.setBackground(Color.WHITE);
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[2][0] != 1 && tablero[2][0] != 2){
					tablero[2][0] = turno;
					if (turno == 1) {
						boton3.setIcon(iconoXE);
						turno = 2;
					}else {
						boton3.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		panelTablero.add(boton4);
		boton4.setFont(fuente);
		boton4.setBackground(Color.WHITE);
		boton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[0][1] != 1 && tablero[0][1] != 2){
					tablero[0][1] = turno;
					if (turno == 1) {
						boton4.setIcon(iconoXE);
						turno = 2;
					}else {
						boton4.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		
		panelTablero.add(boton5);
		boton5.setFont(fuente);
		boton5.setBackground(Color.WHITE);
		boton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[1][1] != 1 && tablero[1][1] != 2){
					tablero[1][1] = turno;
					if (turno == 1) {
						boton5.setIcon(iconoXE);
						turno = 2;
					}else {
						boton5.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		panelTablero.add(boton6);
		boton6.setFont(fuente);
		boton6.setBackground(Color.WHITE);
		boton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[2][1] != 1 && tablero[2][1] != 2){
					tablero[2][1] = turno;
					if (turno == 1) {
						boton6.setIcon(iconoXE);
						turno = 2;
					}else {
						boton6.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		panelTablero.add(boton7);
		boton7.setFont(fuente);
		boton7.setBackground(Color.WHITE);
		boton7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[0][2] != 1 && tablero[0][2] != 2){
					tablero[0][2] = turno;
					if (turno == 1) {
						boton7.setIcon(iconoXE);
						turno = 2;
					}else {
						boton7.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		panelTablero.add(boton8);
		boton8.setFont(fuente);
		boton8.setBackground(Color.WHITE);
		boton8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[1][2] != 1 && tablero[1][2] != 2){
					tablero[1][2] = turno;
					if (turno == 1) {
						boton8.setIcon(iconoXE);
						turno = 2;
					}else {
						boton8.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});

		panelTablero.add(boton9);
		boton9.setFont(fuente);
		boton9.setBackground(Color.WHITE);
		boton9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablero[2][2] != 1 && tablero[2][2] != 2){
					tablero[2][2] = turno;
					if (turno == 1) {
						boton9.setIcon(iconoXE);
						turno = 2;
					}else {
						boton9.setIcon(iconoOE);
						turno = 1;
					}
					evaluar();
				}
			}
		});
		revalidate();
	}
	
	public void evaluar() {
		jugadas++;
		if (jugadas > 4)
		if (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0] || tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1] || tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]
				|| tablero[0][0] == tablero[0][1] && tablero[0][2] == tablero[0][1] || tablero[1][0] == tablero[1][1] && tablero[1][2] == tablero[1][1] || tablero[2][0] == tablero[2][1] && tablero[2][2] == tablero[2][1]
						|| tablero[0][0] == tablero[1][1] && tablero[2][2] == tablero[1][1] || tablero[2][0] == tablero[1][1] && tablero[0][2] == tablero[1][1])
		{
			jugadas = 0;
			if (turno == 1) {
				contadorO++;
				labelContadorO.setText("O: " + contadorO);			
			}
			else {
				contadorX++;
				labelContadorX.setText("X: " + contadorX);			
			}
			
//			JOptionPane.showMessageDialog(null, (turno == 1? "O":"X") + " Gana!");
			JOptionPane.showMessageDialog(null, (turno == 1? "O":"X") + " Gana!", "", JOptionPane.INFORMATION_MESSAGE, (turno == 1? iconoOEDialog: iconoXEDialog));
		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                tablero[i][j] = 1;
		            }
		        }
		        
		        	
		}
		else if (jugadas > 8) {
			jugadas = 0;
			JOptionPane.showMessageDialog(null, "EMPATE");
		}
		
	}
	
	public void reiniciar() {
		boton1.setIcon(null);
		boton2.setIcon(null);
		boton3.setIcon(null);
		boton4.setIcon(null);
		boton5.setIcon(null);
		boton6.setIcon(null);
		boton7.setIcon(null);
		boton8.setIcon(null);
		boton9.setIcon(null);
		
	    int num = 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = num++;
            }
        }
		
		
	}
	
	public String impTablero() {
		String aux ="";
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				aux += tablero[j][i] + " ";				
			}
			aux += "\n";
		}
		return aux;
	}
	
	public static void main(String[] args) {
		new Gato();
	}

}
