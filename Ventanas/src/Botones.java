import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Botones extends JFrame {

	public Botones () {
		setSize(500, 550);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#006699"));
		
		Random rand = new Random();
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setSize(500, 550);
		
		JButton boton = new JButton ("Click me");
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton boton2 = new JButton();
				int r = rand.nextInt(255);
				int g = rand.nextInt(255);
				int b = rand.nextInt(255);

				boton2.setBounds(rand.nextInt(300), rand.nextInt(350), rand.nextInt(90, 200), rand.nextInt(10, 200));
				boton2.setBackground(new Color(r,g,b));
				boton2.setText(Integer.toString(r)+Integer.toString(g)+Integer.toString(b));
				
				boton2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane optionPane = new JOptionPane();
						optionPane.showConfirmDialog(boton2, boton2.getText());
						panel.remove(boton2);
						panel.repaint();
					}
				});
				panel.add(boton2);
				panel.repaint();
			}
		});
		
		boton.setBounds(190, 400, 100, 50);
		boton.setBackground(Color.WHITE);
		panel.add(boton);
		
		add(panel);
		repaint();
	}
	
	public static void main(String[] args) {
		
		Botones ventana = new Botones();
	}

}
