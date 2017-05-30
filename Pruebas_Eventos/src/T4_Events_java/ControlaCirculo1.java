package T4_Events_java;

import javax.swing.*;
import java.awt.*;

public class ControlaCirculo1 extends JFrame {
  private JButton botonAlargar = new JButton("Alargar");
  private JButton botonReducir = new JButton("Reducir");
  private PanelCirculo areaDibujo = new PanelCirculo();
  
  public ControlaCirculo1() {
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(botonAlargar);
    panel.add(botonReducir);
    
    this.add(areaDibujo, BorderLayout.CENTER); // Add canvas to center
    this.add(panel, BorderLayout.SOUTH);       // Add buttons to the frame   
  }
  public static void main(String[] args) {
    JFrame frame = new ControlaCirculo1();
    frame.setTitle("Controla Circulo (I)");
    frame.setLocationRelativeTo(null);        // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
  
class PanelCirculo extends JPanel {
  private int radio = 5;           // Default circle radius
  protected void paintComponent(Graphics g) {  /** Repaint the circle */
    super.paintComponent(g);
    g.drawOval(getWidth() / 2 - radio, getHeight() / 2 - radio, 2 * radio, 2 * radio);
  }
}   
