package T2GUIBasicsJava;

/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo colocar componentes dentro de una ventana
	 ChangeLog: 
*/

import javax.swing.*;

public class FrameConComponentes {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Frame con componentes Swing");

    // Add a button into the frame
    JButton jbtOK = new JButton("OK");
    frame.add(jbtOK);

    frame.setSize(400, 300);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
