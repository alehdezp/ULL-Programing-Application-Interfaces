package T4_Events_java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlaCirculo2 extends JFrame {
  private JButton botonAlargar = new JButton("Alargar");
  private JButton botonReducir = new JButton("Reducir");
  private PanelCirculo areaDibujo = new PanelCirculo();
  
  public ControlaCirculo2() {
    JPanel panel = new JPanel();          // Use the panel to group buttons
    panel.add(botonAlargar);
    panel.add(botonReducir);
    
    this.add(areaDibujo, BorderLayout.CENTER);    // Add canvas to center
    this.add(panel, BorderLayout.SOUTH);          // Add buttons to the frame 
    
    botonAlargar.addActionListener(new Oyente());
    botonReducir.addActionListener(new Oyente());
  }
  
  public static void main(String[] args) {
    JFrame frame = new ControlaCirculo2();
    frame.setTitle("Controla Circulo (II)");
    frame.setLocationRelativeTo(null);        // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
  
  class Oyente implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(new java.util.Date(e.getWhen()));
      if (e.getSource() == botonAlargar)
        areaDibujo.alargar();
      else if (e.getSource() == botonReducir)
    	areaDibujo.reducir();
    }
  }
  
  class PanelCirculo extends JPanel {
    private int radio = 5; // Default circle radius
      
    /** Enlarge the circle */
    public void alargar() {
      radio++;
      repaint();
    }
    
    /** Shrink the circle */
    public void reducir() {
      radio--;
      repaint();
    }
    
    /** Repaint the circle */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawOval(getWidth() / 2 - radio, getHeight() / 2 - radio, 2 * radio, 2 * radio);
    }
  }   
}  
