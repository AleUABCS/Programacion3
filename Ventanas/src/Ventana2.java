import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.ListFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ventana2 extends JFrame{
	
	public Ventana2 () {
		setSize(500, 550);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		getContentPane().setBackground(Color.decode("#006699"));
		
		JPanel panel = new JPanel();
		panel.setSize(500,450);
		panel.setLocation(0, 50);
		add(panel);
		panel.setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Factura en Java");
		titulo.setFont(new Font("", Font.PLAIN, 14));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(15, 0, 200, 50);
		add(titulo);
		
		JPanel datosCliente = new JPanel();
		datosCliente.setBorder(new TitledBorder("Datos del cliente"));
		datosCliente.setLayout(new GridLayout(2, 4, 10, 10));
		panel.add(datosCliente, BorderLayout.NORTH);	
		JLabel documento = new JLabel("Documento");
		datosCliente.add(documento);
		JTextField textFieldDocumento = new JTextField("123456");
		datosCliente.add(textFieldDocumento);
		JLabel direccion = new JLabel("Dirección");
		datosCliente.add(direccion);
		JTextField textFieldDireccion = new JTextField("Calle 13");
		datosCliente.add(textFieldDireccion);
		JLabel nombres = new JLabel("Nombres");
		datosCliente.add(nombres);
		JTextField textFieldNombres = new JTextField("Agustin Calderón");
		datosCliente.add(textFieldNombres);
		JLabel telefono = new JLabel("Teléfono");
		datosCliente.add(telefono);
		JTextField textFieldTelefono = new JTextField("613 100 7777");
		datosCliente.add(textFieldTelefono);
		
		datosCliente.repaint();
		datosCliente.revalidate();
		
		JPanel datosFactura = new JPanel();
		datosFactura.setBorder(new TitledBorder("Datos de factura"));
		datosFactura.setLayout(new GridLayout(1, 4));
		
		JLabel nFactura = new JLabel("N# Factura");
		datosFactura.add(nFactura);
		JLabel labelNFactura = new JLabel("1");
		datosFactura.add(labelNFactura);
		JLabel fecha = new JLabel("Fecha");
		datosFactura.add(fecha);
		JLabel labelFecha = new JLabel("2020/20/20");
		datosFactura.add(labelFecha);
		
		panel.add(datosFactura, BorderLayout.CENTER);
		datosFactura.revalidate();
		datosFactura.repaint();
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setLayout(new GridLayout(3, 1, 0, -30));
		
		JPanel listadoFacturas = new JPanel();
		listadoFacturas.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel verListado = new JLabel("Ver listado de facturas");
		listadoFacturas.add(verListado);
		verListado.setBorder(new EmptyBorder(0, 0, 0, 150));
		
		JLabel añadir = new JLabel("Añadir");
		listadoFacturas.add(añadir);
		
		JLabel eliminar = new JLabel("Eliminar");
		eliminar.setBorder(new EmptyBorder(0, 30, 0, 0));
		listadoFacturas.add(eliminar);
		
		
		String [] barraSup = {"Producto", "Cantidad", "Valor", "Sub total"};
		
		Object [][] datos = {
				{"Agua", 2, 500, 1000},
				{"Leche", 5, 1000, 5000},
				{"Agua", 2, 300, 600},

		};
		JTable facturas = new JTable(datos, barraSup);
		
		listadoFacturas.add(facturas);
		
		panelAbajo.add(listadoFacturas);
		panel.add(panelAbajo, BorderLayout.SOUTH);
		
		listadoFacturas.revalidate();
		listadoFacturas.repaint();
		
		JPanel etiquetasFacturas = new JPanel();
		etiquetasFacturas.setLayout(new GridLayout(1, 2));
		
		JPanel etiquetasFacturasIzquierda = new JPanel();
		etiquetasFacturasIzquierda.setBorder(new EmptyBorder(0, 50, 0, 20));
		etiquetasFacturasIzquierda.setLayout(new GridLayout(4, 2));
		
		JLabel subTotal = new JLabel("SubTotal:");
		etiquetasFacturasIzquierda.add(subTotal);
		JLabel textoSubTotal = new JLabel("6600");
		etiquetasFacturasIzquierda.add(textoSubTotal);
		JLabel descuento = new JLabel("% Descuento:");
		etiquetasFacturasIzquierda.add(descuento);
		JTextField textFieldDescuento = new JTextField("5");
		etiquetasFacturasIzquierda.add(textFieldDescuento);
		JLabel iva = new JLabel("IVA (19%):");
		etiquetasFacturasIzquierda.add(iva);
		JLabel textoIva = new JLabel("1254");
		etiquetasFacturasIzquierda.add(textoIva);
		JLabel total = new JLabel("Total Factura:");
		etiquetasFacturasIzquierda.add(total);
		JLabel textoTotal = new JLabel("7524");
		etiquetasFacturasIzquierda.add(textoTotal);
		
		etiquetasFacturas.add(etiquetasFacturasIzquierda);
		panelAbajo.add(etiquetasFacturas);
		
		panelAbajo.revalidate();
		panelAbajo.repaint();
		
		JPanel etiquetasFacturasDerecha = new JPanel();
		etiquetasFacturasDerecha.setLayout(new GridLayout(1, 2));
		
		JLabel valorDescontado = new JLabel("Valor descontado:");
		etiquetasFacturasDerecha.add(valorDescontado);
		JLabel textoValorDescontado = new JLabel("330");
		etiquetasFacturasDerecha.add(textoValorDescontado);
		
		etiquetasFacturas.add(etiquetasFacturasDerecha);
		
		etiquetasFacturas.revalidate();
		etiquetasFacturas.repaint();
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2, 10, 0));
		JButton finalizar = new JButton("Finalizar factura");
		panelBotones.add(finalizar);
		JButton limpiar = new JButton("Limpiar");
		panelBotones.add(limpiar);
		
		panelBotones.setBorder(new EmptyBorder(30, 30, 50, 30));
		
		panelAbajo.add(panelBotones);
		
		
		panelAbajo.revalidate();
		panelAbajo.repaint();
		
	}

	public static void main(String[] args) {
		Ventana2 ventana = new Ventana2();
		
	}

}
