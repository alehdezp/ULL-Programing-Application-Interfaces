/**
   Universidad de La Laguna
	 Escuela Técnica Superior de Ingeniería Informática
	 3r Curso de Grado en Informática
	 Programación de Aplicaciones Interactivas

	 Autor: F. de Sande (fsande@ull.es)
	 Fecha: Enero 2012
	 Finalidad: Ilustrar el uso de características comunes: colores,
	            tipografía, etc. a las clases de Swing
	 ChangeLog: -
*/
package T2GUIBasicsJava;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestCaracteristicasComunes extends JFrame {
  public TestCaracteristicasComunes() {
    // Create a panel to group three buttons
    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
    JButton jbtLeft = new JButton("Izquierda");
    JButton jbtCenter = new JButton("Centro");
    JButton jbtRight = new JButton("Derecha");
    jbtLeft.setBackground(Color.WHITE);
    jbtCenter.setForeground(Color.GREEN);
    jbtRight.setToolTipText("Boton derecho");
    p1.add(jbtLeft);
    p1.add(jbtCenter);
    p1.add(jbtRight);
    p1.setBorder(new TitledBorder("Tres Botones"));
    p1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

    // Create a font and a line border
    Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
    Border lineBorder = new LineBorder(Color.BLACK, 2);

    // Create a panel to group two labels
    JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));
    JLabel jlblRed = new JLabel("Rojo");
    JLabel jlblOrange = new JLabel("Naranja");
    jlblRed.setForeground(Color.RED);
    jlblOrange.setForeground(Color.ORANGE);
    jlblRed.setFont(largeFont);
    jlblOrange.setFont(largeFont);
    jlblRed.setBorder(lineBorder);
    jlblOrange.setBorder(lineBorder);
    p2.add(jlblRed);
    p2.add(jlblOrange);
    p2.setBorder(new TitledBorder("Dos Etiquetas"));

    // Add two panels to the frame
    setLayout(new GridLayout(2, 1, 5, 5));
    add(p1);
    add(p2);
  }

  public static void main(String[] args) {
    // Create a frame and set its properties
    JFrame frame = new TestCaracteristicasComunes();
    frame.setTitle("TestCaracteristicasComunes");
    frame.setSize(300, 150);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
