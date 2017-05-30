
/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo usar BorderLayout
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MuestraBorderLayout extends JFrame {
  public MuestraBorderLayout() {
    // Set BorderLayout with horizontal gap 5 and vertical gap 10
    setLayout(new BorderLayout(10, 10));

    // Add buttons to the frame
    add(new JButton("Este"), BorderLayout.EAST);
    add(new JButton("Sur"), BorderLayout.SOUTH);
    add(new JButton("Oeste"), BorderLayout.WEST);
    add(new JButton("Norte"), BorderLayout.NORTH);
    add(new JButton("Centro"), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    MuestraBorderLayout frame = new MuestraBorderLayout();
    frame.setTitle("Prueba BorderLayout");
    frame.setSize(400, 400);
		frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
