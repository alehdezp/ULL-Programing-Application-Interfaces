/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar cómo usar GridLayout
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class MuestraGridLayout extends JFrame {
  public MuestraGridLayout() {
    // Set GridLayout, 3 rows, 2 columns, and gaps 5 between
    // components horizontally and vertically
    setLayout(new GridLayout(3, 2, 0, 0));
    // Add labels and text fields to the frame
    add(new JLabel("Nombre"));
    add(new JTextField(8));
    add(new JLabel("MI"));
    add(new JTextField(1));
    add(new JLabel("Apellido"));
    add(new JTextField(8));

    // add(new JLabel("Prueba"));
    // add(new JTextField(7));
  }

  public static void main(String[] args) {
    MuestraGridLayout frame = new MuestraGridLayout();
    frame.setTitle("Muestra GridLayout");
    frame.setLocationRelativeTo(null); // New since JDK 1.4
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 125);
    frame.setVisible(true);
  }
}
