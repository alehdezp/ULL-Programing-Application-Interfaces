package T2GUIDevelopmentJava;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class DemoBoton extends JFrame {
  // Create a panel for displaying message
  protected PanelMensaje panelTexto = 
	  new PanelMensaje("Aplicaciones Interactivas");

  // Declare two buttons to move the message left and right
  private JButton botonIzq = new JButton("<=");
  private JButton botonDer = new JButton("=>");

  public static void main(String[] args) {
    DemoBoton frame = new DemoBoton();
    frame.setTitle("Ejemplo de uso de botones");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 100);
    frame.setVisible(true);
  }

  public DemoBoton() {
    // Set the background color of panelTexto
    panelTexto.setBackground(Color.YELLOW);

    // Create Panel panelBotones to hold two Buttons "<=" and "right =>"
    JPanel panelBotones = new JPanel();
    panelBotones.add(botonIzq);
    panelBotones.add(botonDer);

    // Set keyboard mnemonics
    botonIzq.setMnemonic('I');
    botonDer.setMnemonic('D');

    // Set icons and remove text
    // botonIzq.setIcon(new ImageIcon("image/left.gif"));
    // botonDer.setIcon(new ImageIcon("image/right.gif"));
    // botonIzq.setText(null);
    // botonDer.setText(null);

    // Set tool tip text on the buttons
    botonIzq.setToolTipText("Mover texto a la izquierda");
    botonDer.setToolTipText("Mover texto a la derecha");

    // Place panels in the frame
    setLayout(new BorderLayout());
    add(panelTexto, BorderLayout.CENTER);
    add(panelBotones, BorderLayout.SOUTH);

    // Register listeners with the buttons
    botonIzq.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panelTexto.moverIzq();
      }
    });

    botonDer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panelTexto.moverDer();
      }
    });
  }
}

/*
 * vim:ts=2:set nu:sw=2
 */
