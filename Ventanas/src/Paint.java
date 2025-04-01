import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.dnd.DropTargetContext;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Paint implements MouseListener, MouseMotionListener {

 	private ArrayList<Point> puntos = new ArrayList<Point>();
 	List<Trazo> listaDePuntos = new ArrayList<>();
	private JFrame frame;
	private JTextField fieldColor;
//	ArrayList<JButton> colores = new ArrayList<>();
	Color selColores[] = {Color.BLACK, Color.WHITE, Color.GRAY, 
							Color.RED, Color.GREEN, Color.BLUE, 
							Color.YELLOW, Color.ORANGE, Color.MAGENTA,
							Color.PINK, Color.ORANGE.darker(), Color.PINK.darker()};
	JPanel panelDerecha;
	JPanel lienzo;
	Color colorSeleccionado;
	
	JTextField fieldSize;
	
	int grosor;
	
	// Clase para guardar el color del trazo
	class Trazo {
	    List<Point> puntos;
	    Color color;
	    int grosor;
	    
	    public Trazo(List<Point> puntos, Color color, int grosor) {
	        this.puntos = new ArrayList<>(puntos);
	        this.color = color;
	        this.grosor = grosor;
	    }
	}

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
		
		// Crear panel con los botones de selección de color
		JPanel panelColores = new JPanel();
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				JButton color = new JButton();
				color.setBackground(selColores[k++]);
//				colores.add(color);
				color.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						colorSeleccionado = color.getBackground();
						String hex = Integer. toHexString(colorSeleccionado. getRGB()). substring( 2 );
						fieldColor.setText(hex);
					}
				});
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
		fieldColor.setText("000000");
		
		panelBotones.add(fieldColor);
		fieldColor.setColumns(10);
		
		JButton botonRellenar = new JButton("RELLENAR");
		panelBotones.add(botonRellenar);
		
		JLabel labelSize = new JLabel("Size");
		panelBotones.add(labelSize);
		
		JPanel panel_5 = new JPanel();
		panelBotones.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3, 10, 0));
		
		
		fieldSize = new JTextField("5");
		
		JButton botonMenos = new JButton("-");
		botonMenos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldSize.setText(Integer.toString((Integer.parseInt(fieldSize.getText())-1)));
				grosor = Integer.parseInt(fieldSize.getText());
			}
		});
		
		panel_5.add(botonMenos);
		panel_5.add(fieldSize);
		JButton botonMas = new JButton("+");
		panel_5.add(botonMas);
		botonMas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldSize.setText(Integer.toString((Integer.parseInt(fieldSize.getText())+1)));
				grosor = Integer.parseInt(fieldSize.getText());
			}
		});
		
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
		
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new BorderLayout());
		panelGeneral.add(panelDerecha);
		
		lienzo = new PaintPanel();
		lienzo.addMouseListener(this);
		lienzo.addMouseMotionListener(this);
		panelDerecha.add(lienzo, BorderLayout.CENTER);
	}
	
	@Override
 	public void mouseClicked(MouseEvent e) {
 		// TODO Auto-generated method stub
 		
 	}
 
 	@Override
 	public void mousePressed(MouseEvent e) {
 		// TODO Auto-generated method stub
 		grosor = Integer.parseInt(fieldSize.getText());
 		try {
 			colorSeleccionado = Color.decode("#"+fieldColor.getText());			
		} catch (Exception e2) {
			// TODO: handle exception
		}

 		
 	}
 
 	@Override
 	public void mouseReleased(MouseEvent e) {
 		
 		//crear una copia de los puntos
 		ArrayList ArrList2  = (ArrayList)puntos.clone();
 		
 	// Guardar el trazo con su color y grosor del textfield fieldSize
 	    if (!puntos.isEmpty())
 	    {
 	        listaDePuntos.add(new Trazo(puntos, colorSeleccionado, grosor));
 	        puntos.clear(); // Limpiar los puntos actuales
 	    }
 		
 	}
 
 	@Override
 	public void mouseEntered(MouseEvent e) { 
 		
 	}
 
 	@Override
 	public void mouseExited(MouseEvent e) { 
 		
 	}
 
 	@Override
 	public void mouseDragged(MouseEvent e) {
 		lienzo.repaint();
 		puntos.add(e.getPoint());
 		
 		
 	}
 
 	@Override
 	public void mouseMoved(MouseEvent e) { 
 		
 	}
 	
 	class PaintPanel extends JPanel{
 		
 		public PaintPanel()
 		{
 			this.setBackground(Color.white);
 		}
 		
 		@Override
 		public void paintComponent(Graphics g) {
 		    super.paintComponent(g);
 		    
 		    Graphics2D g2 = (Graphics2D) g;

 		    // Dibujar los trazos anteriores con su color original
 		    for (Trazo trazo : listaDePuntos) {
 		        g2.setColor(trazo.color);
 		        g2.setStroke(new BasicStroke(trazo.grosor));
 		        List<Point> puntos = trazo.puntos;
 		        if (puntos.size() > 1) {
 		            for (int i = 1; i < puntos.size(); i++) {
 		                Point p1 = puntos.get(i - 1);
 		                Point p2 = puntos.get(i);
 		                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
 		            }
 		        }
 		    }

 		    // Dibujar el trazo actual con el color seleccionado
 		    g2.setColor(colorSeleccionado);
 		    g2.setStroke(new BasicStroke(grosor));
 		    if (puntos.size() > 1) {
 		        for (int i = 1; i < puntos.size(); i++) {
 		            Point p1 = puntos.get(i - 1);
 		            Point p2 = puntos.get(i);
 		            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
 		        }
 		    }
 		}

 		
 	}

}
