package graficos;


import java.awt.*;
import javax.swing.*;

public class Dibuja extends JFrame{



  public Dibuja() {
	  setLayout(new GridLayout(1, 0, 5, 5));
    add(new Cara());
    add(new Escalera());
	  add(new Espiral());
  }

  public static void main(String[] args) {
    Dibuja frame = new Dibuja();
    frame.setSize(800, 350);
    frame.setTitle("Cuadro de dibujo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}