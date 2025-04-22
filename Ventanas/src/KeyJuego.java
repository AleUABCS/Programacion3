import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class KeyJuego implements KeyListener {
	
	ImageIcon ciervoImagen = new ImageIcon("ciervoImagen.jpg");
	ImageIcon texturaHK = new ImageIcon("texturaHK.png");
	ImageIcon baile = new ImageIcon("baileHollowknight.gif");
	ImageIcon fondo = new ImageIcon("fondoTelarañas.png");
	ImageIcon nivel1 = new ImageIcon("Nivel1.png");
	ImageIcon nivel2 = new ImageIcon("Nivel2.png");
	JDialog dialogoFin;
	JLabel tiempo;
	
	PaintPanel panel_Centro;
	private JFrame frame;
	int segundos = 0;
	Timer timer;
	JLabel labelTimer;
	Player player;
	Player shadow;
	ArrayList<Player> paredes1 = new ArrayList<>();
	ArrayList<Player> paredes2 = new ArrayList<>();

	boolean move;
	int dir = 0;
	Timer timerMovement;
	Point posInicial = new Point();
	int nivel = 1;
	Player fin;
	boolean flag = true;
	Image imagen;

	int[][] laberinto1 = {
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
		    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
		    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
		    {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
		    {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
		    {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
		    {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
		    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
		    {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
		    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
		    {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
		    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};

	int laberinto2[][] = {
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
		    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
		    {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
		    {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
		    {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
		    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
		    {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
		    {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
		    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
		    {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
		    {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
		    {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
		    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
		    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};

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
		System.out.println("Hola");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JDialog dialogoSelNivel = new JDialog();
		dialogoSelNivel.setSize(400, 280);
		dialogoSelNivel.setLocationRelativeTo(null);
		
		JButton btnNivel1 = new JButton();
		ImageIcon nivel1Scaled = new ImageIcon();
		nivel1Scaled.setImage(nivel1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		btnNivel1.setIcon(nivel1Scaled);
		btnNivel1.setBackground(Color.WHITE);
		btnNivel1.setOpaque(false);
		btnNivel1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nivel = 1;
				dialogoSelNivel.setVisible(false);
			}
		});

		
		JButton btnNivel2 = new JButton();
		ImageIcon nivel2Scaled = new ImageIcon();
		nivel2Scaled.setImage(nivel2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		btnNivel2.setIcon(nivel2Scaled);
		btnNivel2.setBackground(Color.WHITE);
		btnNivel2.setOpaque(false);
		btnNivel2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nivel = 2;
				dialogoSelNivel.setVisible(false);
			}
		});
		
		JLabel texto = new JLabel("Selecciona el nivel");
		texto.setFont(new Font("Consolas", Font.BOLD, 26));
		texto.setBorder(new EmptyBorder(30,0,20,0));
		texto.setForeground(Color.BLACK);
		
		JPanel panelSelBtns = new JPanel();
		panelSelBtns.setBackground(Color.decode("#23336b"));
		
		panelSelBtns.add(texto);
		
		panelSelBtns.add(btnNivel1);
		panelSelBtns.add(btnNivel2);
		
		dialogoSelNivel.add(panelSelBtns);
		
		dialogoSelNivel.setModal(true);
		dialogoSelNivel.setVisible(true);
		
		dialogoFin = new JDialog();
		dialogoFin.setTitle("GANASTE!");
		dialogoFin.setSize(300,300);
		dialogoFin.setLocationRelativeTo(null);
		
		tiempo = new JLabel("Aquí va el tiempo");
		tiempo.setFont(new Font("Consolas", Font.PLAIN, 28));
		
		
		JLabel labelBaile = new JLabel();
		labelBaile.setIcon(baile);
		labelBaile.setSize(50,50);
		
		JPanel panelFin = new JPanel();
		panelFin.setBackground(Color.decode("#c07d56"));
		panelFin.add(labelBaile);
		panelFin.add(tiempo);
		
		dialogoFin.add(panelFin);
		
		int escala = 20;
		  for (int i = 0; i < 25; i++) {
		    for (int j = 0; j < 25; j++) {
		    	if (laberinto1[i][j] == 1) {
		    			paredes1.add(new Player(j*escala, i*escala, escala, escala, null));
		    		}
		    	}
		    }
		   
		  for (int i = 0; i < 25; i++) {
			   for (int j = 0; j < 25; j++) {
				   if (laberinto2[i][j] == 1) {
			    			paredes2.add(new Player(j*escala, i*escala, escala, escala, null));
				   }
			   }
		  }
		   
		   
		
		   if (nivel == 1)
			posInicial.setLocation(460, 20);
		else if (nivel == 2)
			posInicial.setLocation(20,20);
		
			
		player = new Player(posInicial.x, posInicial.y, 20, 20, Color.decode("#1ed760"));
		shadow = new Player(posInicial.x, posInicial.y, 30, 30, null);
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 514, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel_North = new JPanel();
		frame.getContentPane().add(panel_North, BorderLayout.NORTH);
		
		labelTimer = new JLabel("00:00");
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
		
		JButton botonCambiarNivel = new JButton("Cambiar");
		botonCambiarNivel.setFont(new Font("Consolas", Font.PLAIN, 24));
		botonCambiarNivel.setBackground(Color.WHITE);
		botonCambiarNivel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nivel == 1) {
					posInicial.setLocation(20,20);
					nivel = 2;
				}
				else {
					posInicial.setLocation(460, 20);
					nivel = 1;
				}
				reiniciar();
			}
		});
		panel_South.add(botonCambiarNivel);

		
		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setFont(new Font("Consolas", Font.PLAIN, 24));
		botonReiniciar.setBackground(Color.WHITE);
		botonReiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reiniciar();
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
		timerMovement = new Timer(15, refreshMovement);
		timerMovement.start();
		}
	
	public boolean canMove () {
		if (nivel == 1)
			for (Player pared : paredes1) {
				if (player.colision(pared))
					return false;
		}
		else 
			for (Player pared : paredes2) {
				if (player.colision(pared))
					return false;
		}
		return true;
	}
	
	public void reiniciar () {
		panel_Centro.requestFocus();
		segundos = 0;
		labelTimer.setText("00:00");
		player.x = posInicial.x;
		player.y = posInicial.y;
		panel_Centro.repaint();
		dir = 0;
		flag = true;
	}
	
	public boolean fin () {
		if (player.colision(fin)) {
			if (flag) {
				timer.stop();
				flag = false;
				tiempo.setText(labelTimer.getText() + " segundos");
				dialogoFin.setVisible(true);
				}
			return true;
		}
		
		return false;
	}
	
		class PaintPanel extends JPanel{
		 		
		 		Point p1;
		 		
		 		public PaintPanel()
		 		{
		 			this.setBackground(Color.decode("#486198"));
		 		}

		 		
		 		
		 		@Override
		 		public void paintComponent(Graphics g) {
		 		    super.paintComponent(g);
		 		    
		 		    Graphics2D g2 = (Graphics2D) g;
		 		    g2.drawImage(fondo.getImage(), 0, 0, panel_Centro.getWidth(), panel_Centro.getHeight(), null);
		 		    
		 		    g2.setColor(player.color);
		 		    g2.fillRect(player.x, player.y, player.w, player.h);
		 		    
		 		    if (nivel == 1)
		 		    for (Player pared : paredes1) {
		 		    	g2.setColor(pared.color);
			 		    g2.drawImage(texturaHK.getImage(), pared.x, pared.y, pared.w, pared.h, null);
					}
		 		    else
			 		   for (Player pared : paredes2) {
			 		    	g2.setColor(pared.color);
				 		    g2.drawImage(texturaHK.getImage(), pared.x, pared.y, pared.w, pared.h, null);
						}
		 		    
		 		    if (nivel == 1)
		 		    	fin = new Player(380, 480, 20, 20, Color.ORANGE);
		 		    else if (nivel == 2)
		 		    	fin = new Player(340, 20, 20, 20, Color.ORANGE);
		 		    
		 		    g2.setColor(fin.color);
		 		    g2.fillRect(fin.x, fin.y, fin.w, fin.h);
		 		    
		 	        g2.drawImage(ciervoImagen.getImage(), player.x, player.y, 20, 20, null);
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
			}
			else if (e.getKeyCode() == 65) { // A
				dir = 2;
			}
			else if (e.getKeyCode() == 83) { // S
				dir = 3;
			}
			else if (e.getKeyCode() == 68) { // D
				dir = 4;
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
		if (!fin()) {
		if (dir == 1)      // W
			player.y -= 5;
		else if (dir == 2) // A
			player.x -= 5;
		else if (dir == 3) // S
			player.y += 5;
		else if (dir == 4) // D
			player.x += 5;
		}
		
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
