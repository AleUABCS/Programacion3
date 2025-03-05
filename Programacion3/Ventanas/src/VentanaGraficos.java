import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class VentanaGraficos extends JFrame {

	public VentanaGraficos () {
		
		setSize(400, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.CYAN);
		
		g2.clearRect(50, 100, 50, 50);
		
		g2.drawRect(150, 100, 50, 50);
		
		g2.fillRect(250, 100, 50, 50);
		
		g2.fillRoundRect(50, 200, 50, 50, 20, 20);
		
		g2.drawLine(50, 300, 300, 200);
		
		g2.setStroke(new BasicStroke(20));
		g2.drawLine(65, 350, 300, 250);
		
		g2.setColor(Color.decode("#d4bbf6"));
		g2.setStroke(new BasicStroke(5));
		g2.drawOval(50, 400, 30, 30);
		
		g2.drawOval(100, 400, 50, 30);
		
		g2.fillOval(170,  400, 50, 30);
		
		g2.drawArc(230, 400, 30, 50, 0, 180);
		
		g2.fillArc(270, 400, 30, 50, 0, 180);

		g2.drawString("Holaaaa", 260, 340);
		
		BufferedImage imagen;
		
		try {
			imagen = ImageIO.read(new File("cuyofelisinfondo.png"));
			
			g2.drawImage(imagen, 50, 450, 200, 100, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
			
			VentanaGraficos ventana = new VentanaGraficos();
	}

}
