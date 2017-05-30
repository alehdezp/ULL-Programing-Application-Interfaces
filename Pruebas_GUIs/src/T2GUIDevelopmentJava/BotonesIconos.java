package T2GUIDevelopmentJava;

import javax.swing.*;

public class BotonesIconos extends JFrame  {
  public static void main(String[] args) {
    // Create a frame and set its properties
    JFrame frame = new BotonesIconos();
    frame.setTitle("Botones iconos");
    frame.pack();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public BotonesIconos() {
    ImageIcon unIcono = new ImageIcon("image/UNICEF.gif");
    ImageIcon euIcono = new ImageIcon("image/European-Union.gif");
    ImageIcon spIcono = new ImageIcon("image/Spain.gif");

    JButton boton = new JButton("Haz click", euIcono);
    boton.setPressedIcon(euIcono);
    boton.setRolloverIcon(spIcono);

    add(boton);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
