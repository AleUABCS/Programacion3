import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

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
import java.awt.Rectangle;

public class KeyJuego implements KeyListener {

	PaintPanel panel_Centro;
	private JFrame frame;
	int segundos = 0;
	Timer timer;
	Player player;
	Player shadow;
	ArrayList<Player> paredes = new ArrayList<>();
	boolean move;
	int dir = 0;
	Timer timerMovement;

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
		player = new Player(200, 200, 30, 30, Color.decode("#1ed760"));
		shadow = new Player(200,200, 30, 30, null);
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 505, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel_North = new JPanel();
		frame.getContentPane().add(panel_North, BorderLayout.NORTH);
		
		JLabel labelTimer = new JLabel("00:00");
		labelTimer.setFont(new Font("Consolas", Font.PLAIN, 26));
		panel_North.add(labelTimer);
		
		ActionListener refresh = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int segundosLabel = segundos%60;
				int minutos = segundos/60;
				String tiempo = String.format("%02d:%02d", minutos, segundosLabel);
				segundos++;
				labelTimer.setText(tiempo);
			}
		};
		timer = new Timer (1000, refresh);
		
		panel_Centro = new PaintPanel();
		frame.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.requestFocus();
		panel_Centro.setFocusable(true);
		panel_Centro.addKeyListener(this);

		
		JPanel panel_South = new JPanel();
		frame.getContentPane().add(panel_South, BorderLayout.SOUTH);
		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setFont(new Font("Consolas", Font.PLAIN, 24));
		botonReiniciar.setBackground(Color.WHITE);
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Centro.requestFocus();
				segundos = 0;
				labelTimer.setText("00:00");
				player.x = 200;
				player.y = 200;
				panel_Centro.repaint();
			}
		});
		panel_South.add(botonReiniciar);
		
		ActionListener refreshMovement = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movement();
				frame.repaint();
			}
		};
		timerMovement = new Timer(5, refreshMovement);
		timerMovement.start();
		}
	
	public boolean canMove () {
		boolean canMove = true;
		for (Player pared : paredes) {
			if (player.colision(pared))
				canMove = false;
		}
		return canMove;
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
		 		    
		 		    g2.setColor(player.color);
		 		    g2.fillRect(player.x, player.y, player.w, player.h);
		 		    
		 		    paredes.add(new Player(150,150,100,25,Color.PINK));
		 		    paredes.add(new Player(150, 300, 50, 25, Color.CYAN));
		 		    
		 		    for (Player pared : paredes) {
		 		    	g2.setColor(pared.color);
			 		    g2.fillRect(pared.x, pared.y, pared.w, pared.h);
					}
		 		}
		 		
		}
		

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
			if (e.getKeyCode() == 87) { // W
				dir = 1;
				if (player.y < -25)
					player.y = panel_Centro.getHeight() - 5;
			}
			else if (e.getKeyCode() == 65) { // A
				dir = 2;
				if (player.x < -25)
					player.x = panel_Centro.getWidth() - 5;
			}
			else if (e.getKeyCode() == 83) { // S
				dir = 3;
				if (player.y > panel_Centro.getHeight() - 5)
					player.y = -25;
			}
			else if (e.getKeyCode() == 68) { // D
				dir = 4;
				if (player.x > panel_Centro.getWidth() - 5)
					player.x = -25;
			}
			else
				dir = 0;
			
			panel_Centro.repaint();
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void movement () {
		if (dir == 1)      // W
			player.y -= 5;
		else if (dir == 2) // A
			player.x -= 5;
		else if (dir == 3) // S
			player.y += 5;
		else if (dir == 4) // D
			player.x += 5;
		
		move = canMove();
		if (move) {
			shadow.x = player.x;
			shadow.y = player.y;
		}
		else {
			player.x = shadow.x;
			player.y = shadow.y;
		}
		
		if (player.y < -25)
			player.y = panel_Centro.getHeight() - 5;
		if (player.x < -25)
			player.x = panel_Centro.getWidth() - 5;
		if (player.y > panel_Centro.getHeight() - 5)
			player.y = -25;
		if (player.x > panel_Centro.getWidth() - 5)
			player.x = -25;
	}
}

class Player {
	int x, y, w, h;
	Color color;

	public Player(int x, int y, int w, int h, Color color) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}
	
	public boolean colision (Player body) {
		if (x < body.x + body.w &&
			x + w > body.x &&
			y < body.y + body.h &&
			y + h > body.y)
			return true; // Sí hay colisión
		else
			return false;
	}
	
}
