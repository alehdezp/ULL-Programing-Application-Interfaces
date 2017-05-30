/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * @author: Alejandro Hern�ndez Padr�n
 *
 */

package app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class JSyntax extends JFrame{
	public JSyntax () {
		setLayout(new GridLayout(4, 1, -5, 0));			//GridLayout con 4 filas

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));	//JPanel
		JLabel welcome = new JLabel("Traductor de codigo java a html: ");	//Mensaje inicial
		
		Font largeFont = new Font("Serif", Font.BOLD, 18);			//Fuente del mensaje
		Border lineBorder = new LineBorder(Color.BLACK, 1);
		welcome.setFont(largeFont);
		welcome.setBorder(lineBorder);
		
		p1.add(welcome);			//A�adimos el mensaje al panel
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); 	//JPanel

		p2.add(new JLabel("Introduzca la ruta de su fichero .java: "));
		p2.add(new JTextField(10));

		p2.add(new JLabel("Introduzca el nombre del fichero html a generar:"));
		p2.add(new JTextField(10));
		
		JButton button = new JButton();			//Creamos un bot�n a partir de una imagen
		try {
			Image img = ImageIO.read(getClass().getResource("examples/ok.png"));
			 Image newimg = img.getScaledInstance( 27, 27,  java.awt.Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p2.add(button);				//A�adimos el bot�n
		
		add(p1);			//A�adimos los paneles a la ventana
		add(p2);
		add(p2);


		setTitle("Syntax.java");	//titulo
		setSize(500, 400);			//Tama�o
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Actualizamos la informaci�n de la ventana cuando se genere el html
	 */
	public void generado (){
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		JLabel exito = new JLabel("Su fichero ha sido generado con �xito");
		p1.add(exito);
		add(p1);
		setVisible(true);
	}
}
