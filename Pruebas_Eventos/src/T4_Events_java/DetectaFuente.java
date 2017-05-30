import javax.swing.*;
import java.awt.event.*;

public class DetectaFuente extends JFrame {
  // Create four buttons
  private JButton botonNuevo = new JButton("Nuevo");
  private JButton botonAbrir = new JButton("Abrir");
  private JButton botonGrabar = new JButton("Grabar");
  private JButton botonImprimir = new JButton("Imprimir");

  public DetectaFuente() {
    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(botonNuevo);
    panel.add(botonAbrir);
    panel.add(botonGrabar);
    panel.add(botonImprimir);
    
    add(panel);

    // Create a listener 
    OyenteBoton oyente = new OyenteBoton(); 

    // Register listener with buttons 
    botonNuevo.addActionListener(oyente);
    botonAbrir.addActionListener(oyente);
    botonGrabar.addActionListener(oyente);
    botonImprimir.addActionListener(oyente);
  }

  class OyenteBoton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == botonNuevo)
        System.out.println("Ha pulsado Nuevo");
      else if (e.getSource() == botonAbrir)
        System.out.println("Ha pulsado Abrir");
      else if (e.getSource() == botonGrabar)
        System.out.println("Ha pulsado Grabar");
      else if (e.getSource() == botonImprimir)
        System.out.println("Ha pulsado Imprimir");
    }
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new DetectaFuente();
    frame.setTitle("DetectaFuente");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
