import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CalcInt extends JFrame {
	
	public CalcInt() {
		JFrame ventana = new JFrame();
			setSize(400,600);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JPanel panelVentana = new JPanel();
			panelVentana.setLayout(new BorderLayout());
			add(panelVentana);
			
			
			
			JLabel titulo = new JLabel("HOlaa");
			titulo.setFont(new Font ("Arial", Font.PLAIN, 24));
			panelVentana.add(titulo, BorderLayout.NORTH);
			
			//Panel para colocar el panel de input y el de los botones
			JPanel panelInputPanel = new JPanel();
			panelInputPanel.setBackground(Color.decode("#99ff99"));
			
			//Crear y agregar borde con título
			TitledBorder tituloBorde = BorderFactory.createTitledBorder("Calcular interés");
			panelInputPanel.setBorder(tituloBorde);
			
				//Panel para los input (textfields)
				JPanel panelInput = new JPanel();
				panelInput.setBackground(Color.decode("#99ff99"));
				panelInput.setLayout(new GridLayout(3, 2, 0, 10));
				
					JLabel capital = new JLabel("Capital");
					capital.setHorizontalAlignment(JTextField.CENTER);
					panelInput.add(capital);
					JTextField tCapital = new JTextField();
//					tCapital.setHorizontalAlignment(JTextField.CENTER);
					panelInput.add(tCapital);
					
					JLabel tiempo = new JLabel("Tiempo");
					panelInput.add(tiempo);
					tiempo.setHorizontalAlignment(JTextField.CENTER);
					JTextField tTiempo = new JTextField();
//					tTiempo.setHorizontalAlignment(JTextField.CENTER);

					panelInput.add(tTiempo);
					
					JLabel tasaInteres = new JLabel("Tasa interés");
					panelInput.add(tasaInteres);
					tasaInteres.setHorizontalAlignment(JTextField.CENTER);
					JTextField tTasaInteres = new JTextField();
//					tTasaInteres.setHorizontalAlignment(JTextField.CENTER);
					panelInput.add(tTasaInteres);
					
			panelVentana.revalidate();
			panelVentana.repaint();
			
				//Panel para los botones (calcular y cancelar)
				JPanel panelBotones = new JPanel();
				panelBotones.setBackground(Color.decode("#99ff99"));
				panelBotones.setLayout(new GridLayout(1, 2, 50, 0));
					
					JButton calcular = new JButton("Calcular");
					calcular.setHorizontalAlignment(JButton.CENTER);
					panelBotones.add(calcular);
					
					
					JButton cancelar = new JButton("Cancelar");
					cancelar.setHorizontalAlignment(JButton.CENTER);
					panelBotones.add(cancelar);
					
				
				
			panelInputPanel.setLayout(new BorderLayout());
			panelInputPanel.add(panelInput, BorderLayout.CENTER);
			panelInputPanel.add(panelBotones, BorderLayout.SOUTH);
			
		panelVentana.add(panelInputPanel, BorderLayout.CENTER);
		
			//Crear panel inferior (SOUTH) para los resultados
			JPanel panelResultados = new JPanel();
			panelResultados.setBackground(Color.decode("#ff9999"));
			
			panelResultados.setLayout(new GridLayout(2, 2, 0, 50));
			
			JLabel interesTexto = new JLabel("Interés");
			panelResultados.add(interesTexto);
			interesTexto.setHorizontalAlignment(JTextField.CENTER);
			JLabel interesEtiqueta = new JLabel("315.0000000000002");
			interesEtiqueta.setOpaque(true);
			panelResultados.add(interesEtiqueta);
			
			JLabel montoTexto = new JLabel("Monto");
			panelResultados.add(montoTexto);
			montoTexto.setHorizontalAlignment(JTextField.CENTER);
			JLabel montoEtiqueta = new JLabel("1815.0000000000002");
			montoEtiqueta.setOpaque(true);
			panelResultados.add(montoEtiqueta);
			
		panelVentana.add(panelResultados, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		CalcInt ejecutar = new CalcInt();

	}

}
