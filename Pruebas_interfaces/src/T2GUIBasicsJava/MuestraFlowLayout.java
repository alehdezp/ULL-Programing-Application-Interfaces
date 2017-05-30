/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo usar un FlowLayout
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class MuestraFlowLayout extends JFrame {
  public MuestraFlowLayout() {
    // Set FlowLayout, aligned left with horizontal gap 10
    // and vertical gap 20 between components
    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

    // Add labels and text fields to the frame
    add(new JLabel("Nombre"));
    add(new JTextField(8));
    add(new JLabel("MI"));
    add(new JTextField(1));
    add(new JLabel("Apellido"));
    add(new JTextField(8));
  }

  public static void main(String[] args) {
    MuestraFlowLayout frame = new MuestraFlowLayout();
    frame.setTitle("Muestra FlowLayout");
    frame.setLocation(10, 10); // New since JDK 1.4
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
