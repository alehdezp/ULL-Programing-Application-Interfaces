import javax.swing.*;
import java.awt.event.*;

public class FrameAsListenerDemo extends JFrame implements ActionListener {
  // Create four buttons
  private JButton botonNuevo = new JButton("Nuevo");
  private JButton botonAbrir = new JButton("Abrir");
  private JButton botonGrabar = new JButton("Grabar");
  private JButton botonImprimir = new JButton("Imprimir");

  public FrameAsListenerDemo() {
    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(botonNuevo);
    panel.add(botonAbrir);
    panel.add(botonGrabar);
    panel.add(botonImprimir);
    
    add(panel);

    // Register listener with buttons 
    botonNuevo.addActionListener(this);
    botonAbrir.addActionListener(this);
    botonGrabar.addActionListener(this);
    botonImprimir.addActionListener(this);
  }

  /** Implement actionPerformed */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botonNuevo)
      System.out.println("Procesar Nuevo");
    else if (e.getSource() == botonAbrir)
      System.out.println("Procesar Abrir");
    else if (e.getSource() == botonGrabar)
      System.out.println("Procesar Grabar");
    else if (e.getSource() == botonImprimir)
      System.out.println("Procesar Imprimir");
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new FrameAsListenerDemo();
    frame.setTitle("FrameAsListenerDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
