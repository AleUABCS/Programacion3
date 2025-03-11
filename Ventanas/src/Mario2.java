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

public class Mario2 extends JFrame {

		public Mario2 () {
			
			setSize(520, 400);
			setLocationRelativeTo(null);
			setVisible(true);
			getContentPane().setBackground(Color.decode("#0665c0"));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			repaint();
			
		
			
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			
			int x;
			int y;
			Random rand = new Random();
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			
			//Nubes atrás
			x = 350;
			y = 140;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			x = 130;
			y = 280;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			x = 70;
			y = 310;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			//Cerros claros
			x = 20;
			y = 150;
			g2.setColor(Color.decode("#c6e3e7"));
			g2.fillRect(x, y, 90 ,200);
			g2.fillOval(x, y-50, 90, 100);
			g2.setColor(Color.decode("#eef5ff"));
			g2.fillOval(x+10, y, 15, 25);
			g2.fillOval(x+10, y+30, 15, 25);
			g2.fillOval(x+50, y+120, 15, 25);
			
			x = 200;
			y = 150;
			g2.setColor(Color.decode("#c6e3e7"));
			g2.fillRect(x, y, 90 ,200);
			g2.fillOval(x, y-50, 90, 100);
			g2.setColor(Color.decode("#eef5ff"));
			g2.fillOval(x+10, y, 15, 25);
			g2.fillOval(x+10, y+65, 15, 25);
			g2.fillOval(x+50, y+10, 15, 25);
			
			x = 290;
			y = 100;
			g2.setColor(Color.decode("#c6e3e7"));
			g2.fillRect(x, y, 90 , 250);
			g2.fillOval(x, y-50, 90, 100);
			g2.setColor(Color.decode("#eef5ff"));
			g2.fillOval(x+50, y-20, 15, 25);
			g2.fillOval(x+10, y+30, 15, 25);
			
			//Nubes atras de cerros cercanos
			x = 250;
			y = 210;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			//Cerros cercanos
			x = -40;
			y = 300;
			g2.setColor(Color.decode("#165672"));
			g2.fillRect(x, y, 120, 50);
			g2.fillOval(x, y-50, 120, 100);
			g2.setColor(Color.decode("#225e7c"));
			g2.drawRect(x, y, 120, 50);
			g2.drawOval(x, y-50, 120, 100);
			g2.setColor(Color.decode("#76b2d7"));
			g2.fillRect(x, y, 120, 50);
			g2.fillOval(x, y-50, 120, 100);
			
			x = 200;
			y = 300;
			g2.setColor(Color.decode("#225e7c"));
			g2.drawRect(x, y, 120, 50);
			g2.drawOval(x, y-50, 120, 100);
			g2.setColor(Color.decode("#76b2d7"));
			g2.fillRect(x, y, 120, 50);
			g2.fillOval(x, y-50, 120, 100);
			
			x = 320;
			y = 200;
			g2.setColor(Color.decode("#225e7c"));
			g2.drawRect(x, y, 120, 150);
			g2.drawOval(x, y-50, 120, 100);
			g2.setColor(Color.decode("#76b2d7"));
			g2.fillRect(x, y, 120, 150);
			g2.fillOval(x, y-50, 120, 100);
			g2.setColor(Color.decode("#c3e4e2"));
			g2.fillOval(x+10, y, 15, 25);
			g2.fillOval(x+80, y+60, 15, 25);
			
			//Nubes
			x = -10;
			y = 150;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			x = 400;
			y = 110;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			x = 130;
			y = 180;
			g2.setColor(Color.decode("#b2d1d4"));
			g2.fillRect(x, y, 90, 30);
			g2.fillOval(x-15, y, 30, 30);
			g2.fillOval(x+75, y, 30, 30);
			g2.setColor(Color.decode("#d6f0f5"));
			g2.fillRect(x, y, 90, 28);
			g2.fillOval(x-15, y, 30, 28);
			g2.fillOval(x+75, y, 30, 28);
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 90, 26);
			g2.fillOval(x-15, y, 30, 26);
			g2.fillOval(x+75, y, 30, 26);
			
			//Tubería
			g2.setStroke(new BasicStroke(3));
			//Rectangulo inferior
			g2.setColor(Color.decode("#8685d1"));
			g2.fillRect(290, 250, 60, 100);
			g2.setColor(Color.BLACK);
			g2.drawRect(290, 280, 60, 70);
			
			//Rectángulo superior
			g2.setColor(Color.decode("#8685d1"));
			g2.fillRect(288, 250, 65, 30);
			g2.setColor(Color.BLACK);
			
			//Brillo superior
			g2.setColor(Color.decode("#eaf0fd"));
			g2.fillRect(288, 250, 65, 3);
			
			//Brillos
			g2.setColor(Color.decode("#eaf0fd"));
			x = -50;
			int d = 1;
			for (int i = 0; i < 15 && x < 0; i++) {
				int j = rand.nextInt(10);
				int j2 = rand.nextInt(5);
				x += j;
				
				if (x > -15)
					g2.setColor(Color.BLACK);
				g2.fillRect(341 + x, 281, 1 + j2, 68);
				
				if(x > 25)
					d = -1;
				g2.fillRect(341 + x - d, 251, 1 + j2, 30);
			}
			g2.drawRect(288, 250, 65, 30);
			
			//Suelo
			
			//Tierra
			g2.setColor(Color.decode("#cf9e5f"));
			g2.fillRect(0, 340, 520, 60);
			
			//Pasto
			g2.setColor(Color.decode("#00c800"));
			g2.fillRect(0, 340, 520, 10);
			
			g2.setColor(Color.decode("#eabc67"));
			x = 0;
			y = 350;
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 45; i++) {
					g2.fillOval(x + i*12 , y + j*10 + rand.nextInt(5), rand.nextInt(5, 6), rand.nextInt(5, 6));
				}
			}
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.decode("#846b3f"));
			g2.fillRect(0, 350, 520, 4);
			g2.setColor(Color.BLACK);
			g2.drawRect(0, 340, 520, 10);
			
			x = 450;
			y = 313;
			g2.setColor(Color.decode("#c5c4c7"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 450;
			y = 313;
			g2.setColor(Color.decode("#c5c4c7"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 450;
			y = 286;
			g2.setColor(Color.decode("#c5c4c7"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 450;
			y = 259;
			g2.setColor(Color.decode("#c5c4c7"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 450;
			y = 232;
			g2.setColor(Color.decode("#c5c4c7"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 477;
			y = 232;
			g2.setColor(Color.decode("#fbdf2d"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
			x = 504;
			y = 232;
			g2.setColor(Color.decode("#fbdf2d"));
			g2.fillRect(x, y, 27, 27);
			g2.setColor(Color.BLACK);
			g2.drawRect(x, y, 27, 27);
			
		}
			
		
		public static void main(String[] args) {
			Mario2 mario = new Mario2();
		}
	}