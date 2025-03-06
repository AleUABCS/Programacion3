import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class CasaGraphics extends JFrame {

	public CasaGraphics () {
		
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Fondo de la cerca
		g2.setColor(Color.orange.darker());
		g2.fillRect(0, 200, 500, 50);
		
		//Cerca
		g2.setColor(Color.ORANGE);
		for (int i = 0; i < 20; i++)
		{
			g2.fillRect(28*i, 200, 20, 50);
			int x1[] = {i*28, i*28+10, i*28+20};
			int y1[] = {200, 190, 200};
			g2.fillPolygon(x1, y1, 3);
			
		}
		
		//Pared casa
		g2.setColor(Color.decode("#fc4d79"));
		g2.fillRect(180, 150, 150, 100);
		
		//Techo casa
		g2.setColor(Color.decode("#823a8c"));
		int aY = 50;
		int aX = 2;
		int x[] = {aX+150, aX+254, aX+350};
		int y[] = {aY+100, aY+50, aY+100};
		g2.fillPolygon(x, y, 3);
		
		//Puerta casa
		g2.setColor(Color.decode("#2881c7"));
		g2.fillRect(200, 170, 40, 80);
		
		//Ventana casa
		g2.setColor(Color.decode("#00eff7"));
		g2.fillRect(270, 170, 40, 40);
		
		//Lineas ventana casa
		g2.setColor(Color.decode("#514e42"));
		g2.setStroke(new BasicStroke(2));
		g2.drawLine(290, 210, 290, 170);
		g2.drawLine(270, 191, 310, 191);
		
		//Tierra
		g2.setColor(Color.decode("#d08924"));
		g2.fillRect(0, 250, 500, 50);
		//Pasto
		g2.setColor(Color.decode("#95c03b"));
		g2.fillRect(0, 250, 500, 10);
		
		
	}
	
	
	public static void main(String[] args) {

		CasaGraphics casa = new CasaGraphics();

	}
}
