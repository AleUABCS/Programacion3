import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Paint {

	private JFrame frame;
	private JTextField fieldColor;
	ArrayList<JButton> colores = new ArrayList<>();
	Color selColores[] = {Color.BLACK, Color.WHITE, Color.GRAY, 
							Color.RED, Color.GREEN, Color.BLUE, 
							Color.YELLOW, Color.ORANGE, Color.MAGENTA,
							Color.PINK, Color.ORANGE.darker(), Color.PINK.darker()};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(20,20,20,20));
		frame.getContentPane().add(panelGeneral, BorderLayout.CENTER);
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		panelGeneral.setOpaque(false);
		panelGeneral.setLayout(new BorderLayout(20, 0));
		
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBorder(new EmptyBorder(10,20,10,20));
		panelGeneral.add(panelIzquierda, BorderLayout.WEST);
		
		JPanel panelColores = new JPanel();
		
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				JButton color = new JButton();
				color.setBackground(selColores[k++]);
				colores.add(color);
				panelColores.add(color);
			}
		}
		panelIzquierda.setLayout(new GridLayout(2, 1, 0, 0));
		
		panelIzquierda.add(panelColores);
		panelColores.setLayout(new GridLayout(4, 3, 20, 15));
		
		JPanel panelBotones = new JPanel();
		panelIzquierda.add(panelBotones);
		panelBotones.setLayout(new GridLayout(8, 1, 0, 5));
		
		JLabel labelColorPerzonalizado = new JLabel("Color personalizado");
		panelBotones.add(labelColorPerzonalizado);
		
		fieldColor = new JTextField();
		fieldColor.setText("#000000");
		panelBotones.add(fieldColor);
		fieldColor.setColumns(10);
		
		JButton botonRellenar = new JButton("RELLENAR");
		panelBotones.add(botonRellenar);
		
		JLabel labelSize = new JLabel("Size");
		panelBotones.add(labelSize);
		
		JPanel panel_5 = new JPanel();
		panelBotones.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3, 10, 0));
		
		JButton botonMenos = new JButton("-");
		panel_5.add(botonMenos);
		
		JTextField fieldSize = new JTextField("5");
		panel_5.add(fieldSize);
		
		JButton botonMas = new JButton("+");
		panel_5.add(botonMas);
		
		JPanel panel_6 = new JPanel();
		panelBotones.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 2, 25, 0));
		
		JButton botonBrush = new JButton("BRUSH");
		panel_6.add(botonBrush);
		
		JButton botonErase = new JButton("ERASE");
		panel_6.add(botonErase);
		
		JButton botonClean = new JButton("CLEAN");
		panelBotones.add(botonClean);
		
		JButton botonSave = new JButton("SAVE");
		panelBotones.add(botonSave);
		
		JPanel panelDerecha = new JPanel();
		panelGeneral.add(panelDerecha);
	}

}
