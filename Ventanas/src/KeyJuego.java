import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class KeyJuego implements KeyListener {

	PaintPanel panel_Centro;
	private JFrame frame;
	private int x = 200;
	private int y = 200;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyJuego window = new KeyJuego();
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
	public KeyJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 505, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_North = new JPanel();
		frame.getContentPane().add(panel_North, BorderLayout.NORTH);
		
		JLabel labelTimer = new JLabel("00:00");
		labelTimer.setFont(new Font("Consolas", Font.PLAIN, 16));
		panel_North.add(labelTimer);
		
		panel_Centro = new PaintPanel();
		frame.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.requestFocus();
		panel_Centro.setFocusable(true);
		panel_Centro.addKeyListener(this);

		
		JPanel panel_South = new JPanel();
		frame.getContentPane().add(panel_South, BorderLayout.SOUTH);
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setFont(new Font("Consolas", Font.PLAIN, 16));
		botonReiniciar.setBackground(Color.WHITE);
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Centro.requestFocus();
			}
		});
		panel_South.add(botonReiniciar);
	}
	
		class PaintPanel extends JPanel{
		 		
		 		Point p1;
		 		
		 		public PaintPanel()
		 		{
		 			this.setBackground(Color.decode("#48484c"));
		 		}
		 		
		 		@Override
		 		public void paintComponent(Graphics g) {
		 		    super.paintComponent(g);
		 		    
		 		    Graphics2D g2 = (Graphics2D) g;
		 		    
		 		    g2.setColor(Color.decode("#1ed760"));
		 		    g2.fillRect(x, y, 30, 30);
		 		    
		 		}
		 		
		}
		

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == 87) { // W
			System.out.println(e);
			y -= 5;
			if (y < -25)
				y = panel_Centro.getHeight() - 5;
		}
		else if (e.getKeyCode() == 65) { // A
			System.out.println(e);
			x -= 5;
			if (x < -25)
				x = panel_Centro.getWidth() - 5;
		}
		else if (e.getKeyCode() == 83) { // S
			System.out.println(e);
			y += 5;
			if (y > panel_Centro.getHeight() - 5)
				y = -25;
		}
		else if (e.getKeyCode() == 68) { // D
			System.out.println(e);
			x += 5;
			if (x > panel_Centro.getWidth() - 5)
				x = -25;
		}
		panel_Centro.repaint();
		// w 87, a 65, s 83, d 68
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
