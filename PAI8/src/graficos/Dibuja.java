package graficos;


import java.awt.*;
import javax.swing.*;

public class Dibuja extends JFrame{



  public Dibuja(String x, String y) {
	  //setLayout(new GridLayout(1, 0, 5, 5));
	  add(new CaraDibujable(x, y));

  }

  public static void main(String[] args) {
    Dibuja frame = new Dibuja(args[0], args[1]);
    
    frame.setSize(350, 350);
    frame.setTitle("Cuadro de dibujo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}