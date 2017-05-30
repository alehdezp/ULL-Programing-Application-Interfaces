

/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo crear un Frame
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import javax.swing.*;

public class MiFrame {
  public static void main(String[] args) {
	  final int ANCHO = 400;
	  final int ALTO= 300;
    JFrame frame = new JFrame("Mi Frame");    // Create a frame
	  frame.setSize(ANCHO, ALTO);               // Set the frame size
    frame.setLocationRelativeTo(null);        // New since JDK 1.4
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);                   // Display the frame
  }
}
