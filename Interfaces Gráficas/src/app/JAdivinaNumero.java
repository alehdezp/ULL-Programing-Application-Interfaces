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
import java.awt.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class JAdivinaNumero extends JFrame{
	
	/**
	 * Constructor por defecto de la clase.
	 * Crea toda la estructura de la ventan
	 */
	JAdivinaNumero(){

		setLayout(new GridLayout(4, 1, -5, 0));			//Asignamos un GridLayout con 4 filas
														//y una columna

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));	//JPanel

		JLabel welcome = new JLabel("Adivina el N�mero");		//Contiene el mensaje de bienvenida
		Font largeFont = new Font("Dialog", Font.BOLD, 24);		//de nuestra ventana
		welcome.setFont(largeFont);								
		p1.add(welcome);							//A�adimos al panel

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));	//JPanel

		JLabel incog = new JLabel("???");			
		incog.setFont(largeFont);
		p2.add(incog);								//A�adimos al panel

		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

		p3.add(new JLabel("Introduzca su n�mero: (max 3 digitos)"));
		p3.add(new JTextField(3));

		JButton button = new JButton();			//A�adimos un boton con una imagen
		try {
			Image img = ImageIO.read(getClass().getResource("examples/ok.png"));
			Image newimg = img.getScaledInstance( 27, 27,  java.awt.Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));	//Modificamos el cursor encima
		p3.add(button);										//del boton

		add(p1);			//A�adimos a JFrame
		add(p2);
		add(p3);


		setTitle("Adivina el n�mero");		//Titulo
		setSize(400, 400);			//Tama�os ventana
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * Funci�n que a�ade el resultado del programa a la ventana
	 * @param premio
	 */
	public void resultado(String premio){

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		JLabel winner = new JLabel(premio);						//JLabel con el premio
		Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
		winner.setForeground(Color.GREEN);
		winner.setFont(largeFont);
		p1.add(winner);			//A�adimos a la ventana el premio
		add(p1);
		setVisible(true);

	}
}
