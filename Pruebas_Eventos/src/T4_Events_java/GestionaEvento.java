import javax.swing.*;
import java.awt.event.*;

public class GestionaEvento extends JFrame {
  public GestionaEvento() {
    // Create two buttons 
    JButton botonOK = new JButton("OK");
    JButton botonCancel = new JButton("Cancelar");

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(botonOK);
    panel.add(botonCancel);

    add(panel); // Add panel to the frame

    // Register listeners 
    OKoyente oyente1 = new OKoyente();
    CancelarOyente oyente2 = new CancelarOyente();
    botonOK.addActionListener(oyente1);
    botonCancel.addActionListener(oyente2);
  }
  
  public static void main(String[] args) {
    JFrame frame = new GestionaEvento();
    frame.setTitle("Gestiona Evento");
    frame.setSize(200, 150);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class OKoyente implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    System.out.println("Ha clicado OK");
  }
}

class CancelarOyente implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    System.out.println("Ha clicado Cancelar");
  }
}
