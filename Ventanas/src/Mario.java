import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Mario extends JFrame {

	public Mario () {
		
		setSize(520, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#b3eefe"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
	}
	int x;
	int y;
	Random rand = new Random();
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(2));
		
		//Suelo
		g2.setColor(Color.decode("#fac9b1"));
		g2.fillRect(0, 350, getWidth(), 50);
		
		g2.setColor(Color.decode("#e88a6f"));
		g2.fillRect(0, 360, 520, 40);
		
		g2.setColor(Color.BLACK);
		g2.drawLine(0, 360, 520, 360);
		g2.drawLine(0, 350, 520, 350);
		
		g2.setStroke(new BasicStroke(3));
		for (int i = 0; i < 30; i++) {
			g2.setColor(Color.BLACK);
			g2.drawLine(0 + i*20, 370, 50+i*20, 400);
			g2.setColor(Color.decode("#f8c7b2"));
			g2.fillRect(0 + i*20, 361, 11, 6);
		}
		g2.setStroke(new BasicStroke(2));
		

		
		//Rectángulos plataformas
		
			//Rectángulo azul
				g2.setColor(Color.decode("#84c0fd"));
				g2.fillRect(170, 180, 100, 170);
			
				//Sombra atrás
				g2.setColor(Color.BLACK);
				g2.fillRect(270, 200, 20, 150);
			
				//Sombra alfrente
				g2.setColor(Color.decode("#1390e2"));
				g2.fillRect(265, 180, 5, 170);
				
				//Tornillos
					//Arriba izquierda
					x = 175;
					y = 185;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
					
					//Arriba derecha
					x = 255;
					y = 185;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);

					//Abajo derecha
					x = 255;
					y = 335;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
					
			g2.setColor(Color.BLACK);
			g2.drawRect(170, 180, 100, 170);
			
			//Rectangulo crema
				g2.setColor(Color.decode("#ffc3b8"));
				g2.fillRect(100, 250, 100, 100);
			
				//Sombra atrás
				g2.setColor(Color.BLACK);
				g2.fillRect(200, 270, 20, 80);
			
				//Sombra alfrente
				g2.setColor(Color.decode("#e89874"));
				g2.fillRect(195, 250, 5, 100);
				
				
				
				
				//Tornillos
					//Arriba izquierda
					x = 105;
					y = 255;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
					
					//Arriba derecha
					x = 185;
					y = 255;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);

					//Abajo izquierda
					x = 105;
					y = 335;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
					
					//Abajo derecha
					x = 185;
					y = 335;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
			
			g2.setColor(Color.BLACK);
			g2.drawRect(100, 250, 100, 100);
			
			//Rectángulo verde
				g2.setColor(Color.decode("#51d96b"));
				g2.fillRect(450, 250, 100, 100);
				g2.setColor(Color.BLACK);
				g2.drawRect(450, 250, 100, 100);
			
				//Tornillos
					//Arriba|
					x = 455;
					y = 255;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
					
					//Abajo
					x = 455;
					y = 335;
					g2.setColor(Color.decode("#e7e9eb"));
					g2.fillOval(x, y, 10, 10);
					g2.setColor(Color.BLACK);
					g2.drawOval(x, y, 10, 10);
					g2.drawLine(x+8, y+1, x+3, y+8);
				
			
		//Cajitas ?
			
			//Caja 1
			x = 20;
			y = 220;
			g2.setColor(Color.decode("#fd9164"));
			g2.fillRect(x, y, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 30, 30);
			//Puntos
			g2.fillRect(x+3, y+3, 2, 2);
			g2.fillRect(x+25, y+3, 2, 2);
			g2.fillRect(x+3, y+25, 2, 2);
			g2.fillRect(x+25, y+25, 2, 2);
			
			//Caja 2
			x = 80;
			y = 120;
			g2.setColor(Color.decode("#fd9164"));
			g2.fillRect(x, y, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 30, 30);
			//Puntos
			g2.fillRect(x+3, y+3, 2, 2);
			g2.fillRect(x+25, y+3, 2, 2);
			g2.fillRect(x+3, y+25, 2, 2);
			g2.fillRect(x+25, y+25, 2, 2);
			//Animacion
			g2.setColor(Color.BLACK);
			g2.fillOval(x+1, y+5, 12, 12);
			g2.fillOval(x+20, y+5, 10, 9);
			g2.setColor(Color.decode("#eebeb4"));
			g2.fillOval(x+1, y+5, 10, 9);
			g2.fillOval(x+20, y+5, 9, 7);
			
			//Caja 3 (junto a la 2)
			x = 110;
			y = 120;
			g2.setColor(Color.decode("#fd9164"));
			g2.fillRect(x, y, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 30, 30);
			//Puntos
			g2.fillRect(x+3, y+3, 2, 2);
			g2.fillRect(x+25, y+3, 2, 2);
			g2.fillRect(x+3, y+25, 2, 2);
			g2.fillRect(x+25, y+25, 2, 2);
			
			//Caja 4
			x = 460;
			y = 150;
			g2.setColor(Color.decode("#fd9164"));
			g2.fillRect(x, y, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 30, 30);
			//Puntos
			g2.fillRect(x+3, y+3, 2, 2);
			g2.fillRect(x+25, y+3, 2, 2);
			g2.fillRect(x+3, y+25, 2, 2);
			g2.fillRect(x+25, y+25, 2, 2);
			//Animacion
			g2.setColor(Color.BLACK);
			g2.fillOval(x+1, y+5, 12, 12);
			g2.fillOval(x+20, y+5, 10, 9);
			g2.setColor(Color.decode("#eebeb4"));
			g2.fillOval(x+1, y+5, 10, 9);
			g2.fillOval(x+20, y+5, 9, 7);
			
		//Tubería
			
			//Rectangulo inferior
			g2.setColor(Color.decode("#1e860e"));
			g2.fillRect(340, 250, 60, 100);
			g2.setColor(Color.BLACK);
			g2.drawRect(340, 280, 60, 70);
			
			//Rectángulo superior
			g2.setColor(Color.decode("#1e860e"));
			g2.fillRect(338, 250, 65, 30);
			g2.setColor(Color.BLACK);
			
			//Brillo superior
			g2.setColor(Color.decode("#58b356"));
			g2.fillRect(338, 250, 65, 3);
			
			//Brillos
			g2.setColor(Color.decode("#53d262"));
			x = 0;
			int d = 1;
			for (int i = 0; i < 15 && x < 50; i++) {
				int j = rand.nextInt(10);
				int j2 = rand.nextInt(5);
				x += j;
				
				if (x > 35)
					g2.setColor(Color.BLACK);
				g2.fillRect(341 + x, 281, 1 + j2, 68);
				
				if(x > 25)
					d = -1;
				g2.fillRect(341 + x - d, 251, 1 + j2, 30);
			}
			g2.drawRect(338, 250, 65, 30);
			
		//Arbusto
			g2.setColor(Color.decode("#5dd97b"));
			g2.fillOval(10, 315, 30, 37);
			g2.setColor(Color.BLACK);
			g2.drawOval(10, 315, 30, 37);
			
			g2.setColor(Color.decode("#5dd97b"));
			g2.fillOval(10, 323, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawOval(10, 323, 30, 30);
			
			g2.setColor(Color.decode("#8cfebc"));
			g2.fillOval(15, 340, 5, 5);
			g2.fillOval(30, 338, 5, 5);
			g2.fillOval(20, 330, 5, 5);
			g2.fillOval(22, 317, 5, 5);
			
		//Personaje
			
			BufferedImage imagen;
			
			try {
				imagen = ImageIO.read(new File("cuyofelisinfondo.png"));
				
				g2.drawImage(imagen, 190, 132, 50, 50, null, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	public static void main(String[] args) {
		Mario pantalla = new Mario();
	}
}