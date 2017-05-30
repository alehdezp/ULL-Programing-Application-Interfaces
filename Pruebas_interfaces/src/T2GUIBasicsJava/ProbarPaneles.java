/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo crear una ventana con varios paneles.
	            El programa imita el panel de controles de un microondas.
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import java.awt.*;
import javax.swing.*;

public class ProbarPaneles extends JFrame {
  public ProbarPaneles() {
    // Create panel p1 for the buttons and set GridLayout
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(4, 3));

    // Add buttons to the panel
    for (int i = 1; i <= 9; i++) {
      p1.add(new JButton("" + i));
    }

    p1.add(new JButton("" + 0));
    p1.add(new JButton("Start"));
    p1.add(new JButton("Stop"));

    // Create panel p2 to hold a text field and p1
    JPanel p2 = new JPanel(new BorderLayout());
    p2.add(new JTextField("El tiempo se muestra aqui"),
      BorderLayout.NORTH);
    p2.add(p1, BorderLayout.CENTER);

    // add contents into the frame
    add(p2, BorderLayout.CENTER);
    add(new JButton("Poner la comida aquí"), BorderLayout.EAST);
  }

  public static void main(String[] args) {
    ProbarPaneles frame = new ProbarPaneles();
    frame.setTitle("Vista frontal de un microondas");
    frame.setSize(400, 250);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
