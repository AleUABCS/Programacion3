import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gato extends JFrame {
	
	public int turno = 1;
	public int[][] tablero = {  {0,-1,-2},
								{-2,-3,-1},
								{-1,-2,0}
									  };
	
	public Gato() {
		setSize(500,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font fuente = new Font("", Font.BOLD, 28);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3,5,5));
		add(panel);
		
		JButton boton1 = new JButton();
		panel.add(boton1);
		boton1.setFont(fuente);
		boton1.setBackground(Color.WHITE);
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton1.getText().equals("")){
					tablero[0][0] = turno;
					if (turno == 1) {
						boton1.setText("X");
						turno = 2;
					}else {
						boton1.setText("O");
						turno = 1;
					}
					evaluar();
				}
				System.out.println(impTablero());
			}
		});
		
		JButton boton2 = new JButton();
		panel.add(boton2);
		boton2.setFont(fuente);
		boton2.setBackground(Color.WHITE);
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton2.getText().equals("")){
					tablero[1][0] = turno;
					if (turno == 1) {
						boton2.setText("X");
						turno = 2;
					}else {
						boton2.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		JButton boton3 = new JButton();
		panel.add(boton3);
		boton3.setFont(fuente);
		boton3.setBackground(Color.WHITE);
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton3.getText().equals("")){
					tablero[2][0] = turno;
					if (turno == 1) {
						boton3.setText("X");
						turno = 2;
					}else {
						boton3.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		JButton boton4 = new JButton();
		panel.add(boton4);
		boton4.setFont(fuente);
		boton4.setBackground(Color.WHITE);
		boton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton4.getText().equals("")){
					tablero[0][1] = turno;
					if (turno == 1) {
						boton4.setText("X");
						turno = 2;
					}else {
						boton4.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		
		
		JButton boton5 = new JButton();
		panel.add(boton5);
		boton5.setFont(fuente);
		boton5.setBackground(Color.WHITE);
		boton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton5.getText().equals("")){
					tablero[1][1] = turno;
					if (turno == 1) {
						boton5.setText("X");
						turno = 2;
					}else {
						boton5.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		JButton boton6 = new JButton();
		panel.add(boton6);
		boton6.setFont(fuente);
		boton6.setBackground(Color.WHITE);
		boton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton6.getText().equals("")){
					tablero[2][1] = turno;
					if (turno == 1) {
						boton6.setText("X");
						turno = 2;
					}else {
						boton6.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		JButton boton7 = new JButton();
		panel.add(boton7);
		boton7.setFont(fuente);
		boton7.setBackground(Color.WHITE);
		boton7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton7.getText().equals("")){
					tablero[0][2] = turno;
					if (turno == 1) {
						boton7.setText("X");
						turno = 2;
					}else {
						boton7.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		

		JButton boton8 = new JButton();
		panel.add(boton8);
		boton8.setFont(fuente);
		boton8.setBackground(Color.WHITE);
		boton8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton8.getText().equals("")){
					tablero[1][2] = turno;
					if (turno == 1) {
						boton8.setText("X");
						turno = 2;
					}else {
						boton8.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});

		JButton boton9 = new JButton();
		panel.add(boton9);
		boton9.setFont(fuente);
		boton9.setBackground(Color.WHITE);
		boton9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boton9.getText().equals("")){
					tablero[2][2] = turno;
					if (turno == 1) {
						boton9.setText("X");
						turno = 2;
					}else {
						boton9.setText("O");
						turno = 1;
					}
					evaluar();
				}
			}
		});
		revalidate();
	}
	public void evaluar() {
		if (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0] || tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1] || tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]
				|| tablero[0][0] == tablero[0][1] && tablero[0][2] == tablero[0][1] || tablero[1][0] == tablero[1][1] && tablero[1][2] == tablero[1][1] || tablero[2][0] == tablero[2][1] && tablero[2][2] == tablero[2][1]
						|| tablero[0][0] == tablero[1][1] && tablero[2][2] == tablero[1][1] || tablero[2][0] == tablero[1][1] && tablero[0][2] == tablero[1][1]) {
			JOptionPane.showMessageDialog(null, (turno == 1? "O":"X") + " Gana!");
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
