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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class JNoDuplicadas extends JFrame{
	public JNoDuplicadas(ArrayList<String> words) {

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));		//GridLayout con 4 columnas

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));	//JPanel
		JLabel welcome = new JLabel("Palabras no Duplicadas");				//jLabel

		Font largeFont = new Font("Serif", Font.BOLD, 18);	//Fuente y borde del mensaje
		Border lineBorder = new LineBorder(Color.BLUE, 2);	
		welcome.setFont(largeFont);
		welcome.setBorder(lineBorder);
		p1.add(welcome);
		add(p1);			//Añadimos al panel

		String[] arr =	(String[]) words.toArray(new String[words.size()]);
		add(new JList(arr));			//Creamos una lista a travez del array con la solución


		setTitle("JNoDuplicadas.java");	//titulo
		setSize(250,300);	//tamaño
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
