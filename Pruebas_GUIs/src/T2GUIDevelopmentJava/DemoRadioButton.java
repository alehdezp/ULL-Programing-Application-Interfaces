package T2GUIDevelopmentJava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoRadioButton extends DemoCheckBox {
  // Declare radio buttons
  private JRadioButton botonRojo, botonVerde, botonAzul;

  public static void main(String[] args) {
    DemoRadioButton frame = new DemoRadioButton();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("DemoRadioButton");
    frame.setSize(500, 200);
    frame.setVisible(true);
  }

  public DemoRadioButton() {
    // Create a new panel to hold Radio Buttons
    JPanel panelBotones = new JPanel();
    panelBotones.setLayout(new GridLayout(3, 1));
    panelBotones.add(botonRojo = new JRadioButton("Rojo"));
    panelBotones.add(botonVerde = new JRadioButton("Verde"));
    panelBotones.add(botonAzul = new JRadioButton("Azul"));
    add(panelBotones, BorderLayout.WEST);

    // Create a radio button group to group three buttons
    ButtonGroup grupo = new ButtonGroup();
    grupo.add(botonRojo);
    grupo.add(botonVerde);
    grupo.add(botonAzul);

    // Set keyboard mnemonics
    botonRojo.setMnemonic('E');
    botonVerde.setMnemonic('G');
    botonAzul.setMnemonic('U');

    // Register listeners for check boxes
    botonRojo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panelTexto.setForeground(Color.RED);
      }
    });
    botonVerde.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panelTexto.setForeground(Color.GREEN);
      }
    });
    botonAzul.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panelTexto.setForeground(Color.BLUE);
      }
    });

    // Set initial message color to blue
    botonAzul.setSelected(true);
    panelTexto.setForeground(Color.BLUE);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
