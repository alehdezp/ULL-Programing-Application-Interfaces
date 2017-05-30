/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * @author: Alejandro Hernández Padrón
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JSuma extends JFrame {
	public JSuma(){
		
	setLayout(new GridLayout(3, 1, -5, 0));			//GridLayout con 4 filas

	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));	//JPanel
	JLabel welcome = new JLabel("Suma de dos números ");	//JLabel
	
	Font largeFont = new Font("Serif", Font.BOLD, 20);		//Fuente de welcome
	Border lineBorder = new LineBorder(Color.BLACK, 1);		//Borde
	welcome.setFont(largeFont);			
	welcome.setBorder(lineBorder);	
	p1.add(welcome);					//Añadimos al panel
	
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); //JPanel

	p2.add(new JLabel("Operando 1:"));
	p2.add(new JTextField(6));
	p2.add(new JLabel("Operando 2:"));
	p2.add(new JTextField(6));
	
	JButton button = new JButton();		//Botont creado a partir de una imagen
	try {
		Image img = ImageIO.read(getClass().getResource("examples/ok.png"));
		Image newimg = img.getScaledInstance( 27, 27,  java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(newimg));
	} catch (Exception ex) {
		System.out.println(ex);
	}
	
	button.setCursor(new Cursor(Cursor.HAND_CURSOR));		//Modificamos el cursor cuando pasa por encima de una imagen
	p2.add(button);
	
	add(p1);		//Añadimos los paneles a la ventana
	add(p2);


	setTitle("JSuma.java");		//titulo
	setSize(500, 400);			//tamaño ventana
	setLocationRelativeTo(null); // Center the frame
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	/**
	 * Actualiza la ventana para mostrar la suma
	 * @param sum
	 */
	public void muestraSuma(int sum){
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 10));
		add(p1.add(new JLabel("El resultado de la suma es: "+ sum)));
		setVisible(true);
	}
}
