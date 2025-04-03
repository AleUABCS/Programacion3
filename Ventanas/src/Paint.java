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
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.dnd.DropTargetContext;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Constructor;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Paint implements MouseListener, MouseMotionListener {

	private List<Trazo> listaDeTrazos = new ArrayList<>();
 	private ArrayList<Point> puntos = new ArrayList<>();
 	private ArrayList<Linea> lineas = new ArrayList<>();
 	private ArrayList<Triangulo> triangulos = new ArrayList<>();
 	private ArrayList<Figura> figuras = new ArrayList<>(); // ArrayList para guardar todas las figuras y poder mantenerlas pintadas jeje
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
	int tool = 1;
	int contador = 0;
 	int lineaX, lineaY, lineaX2, lineaY2;
 	boolean borrador = false;
 	boolean relleno = false;

	
	JTextField fieldSize;
	
	int tamaño;
	int grosor;
	
	JComboBox<String> herramientas;
	private JTextField fieldSizeFiguras;
	
	// Clase para guardar el color del trazo
	class Trazo {
	    List<Point> puntos;
	    Color color;
	    int grosor;
	    
	    public Trazo(List<Point> puntos, Color color, int grosor) {
	        this.puntos = new ArrayList<>(puntos); // En este ArrayList se guardan los puntos xy de cada trazo
	        this.color = color;
	        this.grosor = grosor;
	    }
	}
	
	class Figura { // Clase para las figuras
		int x;
		int y;
		int grosor;
		Color color;
		int tipo;
		int tamaño;
		boolean relleno;
		
		public Figura(int x, int y, int grosor, Color color, int tipo, int tamaño, boolean relleno) {
			this.x = x;
			this.y = y;
			this.grosor = grosor;
			this.color = color;
			this.tipo = tipo;
			this.tamaño = tamaño;
			this.relleno = relleno;
			
		}
	}
	
	class Linea extends Figura {
		int x2;
		int y2;
		
		public Linea(int x, int y, int x2, int y2, int grosor, Color color, int tipo) {
			super(x, y, grosor, color, 1, 1, false);
			// TODO Auto-generated constructor stub
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	class Triangulo extends Linea {
		int x3;
		int y3;
		
		public Triangulo(int x, int y, int x2, int y2, int x3, int y3, int grosor, Color color, int tipo, boolean relleno) {
			super(x, y, x2, y2, grosor, color, tipo);
			// TODO Auto-generated constructor stub
			this.x3 = x3;
			this.y3 = y3;
			this.relleno = relleno;
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
		frame.setTitle("Paint Java");
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(20,20,20,20));
		frame.getContentPane().add(panelGeneral, BorderLayout.CENTER);
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		panelGeneral.setOpaque(false);
		panelGeneral.setLayout(null);
		
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBounds(20, 20, 250, 523);
		panelIzquierda.setBorder(new EmptyBorder(10,20,10,20));
		panelGeneral.add(panelIzquierda);
		
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
		botonRellenar.setBackground(new Color(255, 255, 255));
		panelBotones.add(botonRellenar);
		
		JPanel panel = new JPanel();
		panelBotones.add(panel);
		panel.setLayout(new GridLayout(0, 5, 2, 0));
		
		JLabel lblNewLabel = new JLabel("Size");
		panel.add(lblNewLabel);
		
		JButton botonMenosFiguras = new JButton("-");
		botonMenosFiguras.setFont(new Font("Tahoma", Font.PLAIN, 9));
		botonMenosFiguras.setBackground(new Color(255, 255, 255));
		botonMenosFiguras.setVisible(false);
		botonMenosFiguras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldSizeFiguras.setText(Integer.toString(Integer.parseInt(fieldSizeFiguras.getText())-1));
			}
		});
		panel.add(botonMenosFiguras);
		
		fieldSizeFiguras = new JTextField();
		fieldSizeFiguras.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSizeFiguras.setText("20");
		fieldSizeFiguras.setVisible(false);
		panel.add(fieldSizeFiguras);
		fieldSizeFiguras.setColumns(10);
		
		JButton botonMasFiguras = new JButton("+");
		botonMasFiguras.setFont(new Font("Tahoma", Font.PLAIN, 9));
		botonMasFiguras.setBackground(new Color(255, 255, 255));
		botonMasFiguras.setVisible(false);
		botonMasFiguras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldSizeFiguras.setText(Integer.toString(Integer.parseInt(fieldSizeFiguras.getText())+1));
			}
		});
		panel.add(botonMasFiguras);
		
		JButton botonRelleno = new JButton("R");
		botonRelleno.setFont(new Font("Tahoma", Font.BOLD, 9));
		botonRelleno.setBackground(new Color(255, 255, 255));
		botonRelleno.setVisible(false);
		botonRelleno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				relleno = !relleno;
				
				botonRelleno.setBackground(relleno == true? Color.LIGHT_GRAY : Color.WHITE);
			}
		});
		panel.add(botonRelleno);
		
		JPanel panel_5 = new JPanel();
		panelBotones.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3, 10, 0));
		
		
		fieldSize = new JTextField("5");
		fieldSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton botonMenos = new JButton("-");
		botonMenos.setBackground(new Color(255, 255, 255));
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
		botonMas.setBackground(new Color(255, 255, 255));
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
		
		herramientas = new JComboBox<String>();
		herramientas.setBackground(new Color(255, 255, 255));
		herramientas.addItem("Brocha");
		herramientas.addItem("Rectángulo");
		herramientas.addItem("Círculo");
		herramientas.addItem("Triángulo");
		herramientas.addItem("Línea");
		
		herramientas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (herramientas.getSelectedIndex() >= 1 && herramientas.getSelectedIndex() <= 3) {
					botonMasFiguras.setVisible(true);
					botonMenosFiguras.setVisible(true);
					fieldSizeFiguras.setVisible(true);
					botonRelleno.setVisible(true);
				}
				else {
					botonMasFiguras.setVisible(false);
					botonMenosFiguras.setVisible(false);
					fieldSizeFiguras.setVisible(false);
					botonRelleno.setVisible(false);
				}
			}
		});
		
		panel_6.add(herramientas);
		
		JButton botonErase = new JButton("ERASE");
		botonErase.setBackground(new Color(255, 255, 255));
		botonErase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				borrador = !borrador;
				if (borrador)
					botonErase.setBackground(Color.LIGHT_GRAY);
				else
					botonErase.setBackground(Color.WHITE);
			}
		});
		panel_6.add(botonErase);
		
		JButton botonClean = new JButton("CLEAN");
		botonClean.setBackground(new Color(255, 255, 255));
		botonClean.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(figuras.size());
				System.out.println(lineas.size());
				System.out.println(triangulos.size());
				System.out.println(listaDeTrazos.size());
				
				if (figuras.size() > 0)
					figuras.clear();
				
				if (lineas.size() > 0) {
					lineas.clear();
				}
				
				if (triangulos.size() > 0)
					triangulos.clear();
				
				if (listaDeTrazos.size() > 0)
					listaDeTrazos.clear();
				
				lienzo.repaint();
			}
		});
		
		panelBotones.add(botonClean);
		
		JButton botonSave = new JButton("SAVE");
		botonSave.setBackground(new Color(255, 255, 255));
		panelBotones.add(botonSave);
		
		panelDerecha = new JPanel();
		panelDerecha.setBounds(290, 20, 624, 523);
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
 		tamaño = Integer.parseInt(fieldSizeFiguras.getText());
 		grosor = Integer.parseInt(fieldSize.getText());
 		try {
 			colorSeleccionado = Color.decode("#"+fieldColor.getText());			
		} catch (Exception e2) {
			// TODO: handle exception
		}
 		
 		if (herramientas.getSelectedIndex() >= 1 && herramientas.getSelectedIndex() <= 3) { // Guarda la posición del mouse al dar click
 			puntos.add(e.getPoint());
 			lienzo.repaint();
 			System.out.println("Mouse presionado");
 		}
 		else if (herramientas.getSelectedIndex() == 4) {
 			System.out.println("Contador: " + contador);
 			System.out.println("X1: " + lineaX);
 			System.out.println("Y1: " + lineaY);
 			System.out.println("X2: " + lineaX2);
 			System.out.println("Y2: " + lineaY2);
 			if (contador == 0) {
 				lineaX = e.getX();
 				lineaY = e.getY();
 				contador = 1;		
 			} else if (contador == 1) {
 				lineaX2 = e.getX();
 				lineaY2 = e.getY();
 				contador = 2;
 			}
 			lienzo.repaint();
 		}
 	}
 
 	@Override
 	public void mouseReleased(MouseEvent e) {
 		
 		System.out.println("Released");
 		//crear una copia de los puntos
 		ArrayList ArrList2  = (ArrayList)puntos.clone();
 		
 	// Guardar el trazo con su color y grosor del textfield fieldSize
 		if (herramientas.getSelectedIndex() != 4)
 			contador = 0;
 		
 		if (borrador == true) {
 			listaDeTrazos.add(new Trazo(puntos, Color.WHITE, grosor));
 			puntos.clear();
 		}
 		else if (!puntos.isEmpty() && herramientas.getSelectedIndex() == 0) {
 	        listaDeTrazos.add(new Trazo(puntos, colorSeleccionado, grosor));
 	        puntos.clear(); // Limpiar los puntos actuales 
 	    }
 	    else if (herramientas.getSelectedIndex() == 1 || herramientas.getSelectedIndex() == 2) {
 	    	figuras.add(new Figura(e.getX(), e.getY(), grosor, colorSeleccionado, herramientas.getSelectedIndex(), Integer.parseInt(fieldSizeFiguras.getText()), relleno));
 	    	puntos.clear();
 	    }
 	    else if (herramientas.getSelectedIndex() == 3) {
		    	triangulos.add(new Triangulo(e.getX(), e.getY(), e.getX()+tamaño, e.getY()+tamaño*2, e.getX()-tamaño, e.getY()+tamaño*2,
		    			grosor, colorSeleccionado, 1, relleno));
		    	puntos.clear();
 		}
 	    else if (herramientas.getSelectedIndex() == 4) {
 	    	if (contador == 2) {
 	    		System.out.println("X: " + lineaX2 + "\n" + "Y: " + lineaY2);
 	    		lineas.add(new Linea(lineaX, lineaY, lineaX2, lineaY2, grosor, colorSeleccionado, 1)); 	  
 	    		contador = 0;
 	    	}
 	    	
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
 		
 		if (herramientas.getSelectedIndex() == 0 || borrador == true) {
 			puntos.add(e.getPoint());
 		}
 		lienzo.repaint();
 	}
 
 	@Override
 	public void mouseMoved(MouseEvent e) { 
 		
 	}
 	
 	class PaintPanel extends JPanel{
 		
 		Point p1;
 		
 		public PaintPanel()
 		{
 			this.setBackground(Color.white);
 		}
 		
 		@Override
 		public void paintComponent(Graphics g) {
 		    super.paintComponent(g);
 		    
 		    Graphics2D g2 = (Graphics2D) g;
 		    
	 		    for (Figura figura : figuras) {
	 		    	g2.setColor(figura.color);
	 		    	g2.setStroke(new BasicStroke(figura.grosor));
	 		    	System.out.println(figura.tipo);
	 		    	if (figuras.size() > 0) {
	 		    		if (figura.tipo == 1) {
	 		    			if (!figura.relleno)
	 		    				g2.drawRect(figura.x-(figura.tamaño/2), figura.y-(figura.tamaño/2), figura.tamaño, figura.tamaño);
	 		    			else
	 		    				g2.fillRect(figura.x-(figura.tamaño/2), figura.y-(figura.tamaño/2), figura.tamaño, figura.tamaño);
	 		    		}
	 		    		else if (figura.tipo == 2) {
	 		    			if (!figura.relleno)
	 		    				g2.drawOval(figura.x-(figura.tamaño/2), figura.y-(figura.tamaño/2), figura.tamaño, figura.tamaño);
	 		    			else
	 		    				g2.fillOval(figura.x-(figura.tamaño/2), figura.y-(figura.tamaño/2), figura.tamaño, figura.tamaño);
	 		    		}
	 		    	}
	 		    }
	 		    
	 		    for (Linea linea : lineas) {
	 		    	g2.setColor(linea.color);
	 		    	g2.setStroke(new BasicStroke(linea.grosor));
	 		    	if (lineas.size() > 0) {
	 		    		g2.drawLine(linea.x, linea.y, linea.x2, linea.y2);
	 		    	}
	 		    }
	 		    
	 		    for (Triangulo triangulo : triangulos) {
	 		    	g2.setColor(triangulo.color);
	 		    	g2.setStroke(new BasicStroke(triangulo.grosor));
	 		    	int xs[] = {triangulo.x, triangulo.x2+triangulo.tamaño, triangulo.x3-triangulo.tamaño};
	 		    	int ys[] = {triangulo.y, triangulo.y2+triangulo.tamaño*2, triangulo.y2+triangulo.tamaño*2};
	 		    	if (triangulos.size() > 0) {
	 		    		if (!triangulo.relleno)
	 		    			g2.drawPolygon(xs, ys, 3);
	 		    		else
	 		    			g2.fillPolygon(xs, ys, 3);
	 		    	}
	 		    }
	 		    
	 		    // Dibujar los trazos anteriores con su color original
	 		    for (Trazo trazo : listaDeTrazos) { // Este for recorre los trazos guardados en listaDePuntos
	 		        g2.setColor(trazo.color); // Le asigna el color que tiene guardado como clase
	 		        g2.setStroke(new BasicStroke(trazo.grosor)); // Lo mismo con el grosor
	 		        List<Point> puntos = trazo.puntos; // Crear una nueva lista tipo Point (la clase custom) para guardar el arreglo de puntos de la variable tipo Trazo
	 		        if (puntos.size() > 1) { // Evalúar si hay más de un punto para pintar en el arreglo de Point's creado anteriormente
	 		            for (int i = 1; i < puntos.size(); i++) {
	 		                Point p1 = puntos.get(i - 1);
	 		                Point p2 = puntos.get(i);
	 		                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	 		            }
	 		        }
	 		    }
	 		
	 		if (borrador == true) {
	 			if (puntos.size() > 0) {
	 				g2.setColor(Color.WHITE);
	 				g2.setStroke(new BasicStroke(grosor));
	 				for (int i = 1; i < puntos.size(); i++) {
 	 		            Point p1 = puntos.get(i - 1);
 	 		            Point p2 = puntos.get(i);
 	 		            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
 	 		        }
	 			}
	 		}
	 		else
	 		    switch (herramientas.getSelectedIndex()) {
	 	 		case 0: // Brocha
	 	 		    // Dibujar el trazo actual con el color seleccionado
	 	 		    g2.setColor(colorSeleccionado); // Le asigna al trazo el color de la variable global colorSeleccionado, para pintarlo con el color seleccionado en ese momento y no con los anteriores
	 	 		    g2.setStroke(new BasicStroke(grosor)); // Lo mismo con el grosor
	 	 		    if (puntos.size() > 1) {
	 	 		        for (int i = 1; i < puntos.size(); i++) {
	 	 		            Point p1 = puntos.get(i - 1);
	 	 		            Point p2 = puntos.get(i);
	 	 		            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	 	 		        }
	 	 		    }
	 	 		break;
	 	 		
	 	 		case 1: // Rectángulo
	 	 			if (puntos.size() > 0) {
		 	 			g2.setColor(colorSeleccionado);
		 	 		    g2.setStroke(new BasicStroke(grosor));
		 	 		    p1 = puntos.getLast();
		 	 		    if (!relleno)
		 	 		    	g2.drawRect(p1.x-tamaño/2, p1.y-tamaño/2, tamaño, tamaño);
		 	 		    else
		 	 		    	g2.fillRect(p1.x-tamaño/2, p1.y-tamaño/2, tamaño, tamaño);

	 	 			}
	 	 		        
	 	 		break;
	 	 		
	 	 		case 2: // Círculo
	 	 			if (puntos.size() > 0) {
		 	 			g2.setColor(colorSeleccionado);
		 	 		    g2.setStroke(new BasicStroke(grosor));
	 		           	p1 = puntos.getLast();
		 	 		    if (!relleno)
		 	 		    	g2.drawOval(p1.x-tamaño/2, p1.y-tamaño/2, tamaño, tamaño);
		 	 		    else
		 	 		    	g2.fillOval(p1.x-tamaño/2, p1.y-tamaño/2, tamaño, tamaño);

	 	 			}
	 	 		break;
	 	 		
	 	 		case 3: // Triángulo
	 	 			if (puntos.size() > 0) {
		 	 			g2.setColor(colorSeleccionado);
		 	 		    g2.setStroke(new BasicStroke(grosor)); 
		 	 		    		p1 = puntos.getLast();
		 	 		    		int xs[] = {p1.x, p1.x+tamaño, p1.x-tamaño};
		 		 		    	int ys[] = {p1.y, p1.y+tamaño*2, p1.y+tamaño*2};
				 	 		    if (!relleno)
				 	 		    	g2.drawPolygon(xs, ys, 3);
				 	 		    else
				 	 		    	g2.fillPolygon(xs, ys, 3);

	 	 			}
	 	 		break;
	 	 		
	 	 		case 4: // Línea
	 	 			if (contador == 2) {
	 	 				g2.setColor(colorSeleccionado);
	 	 				g2.setStroke(new BasicStroke(grosor));
	 	 				g2.drawLine(lineaX, lineaY, lineaX2, lineaY2); 	 				
	 	 			}
	 	 		break;
	 	 		}

 		   
 		}

 		
 	}
}