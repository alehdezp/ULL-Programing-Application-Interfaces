package T2GUIDevelopmentJava;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class DemoList extends JFrame {
  final int NUMBER_OF_FLAGS = 9;

  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"European Union", "Spain",
    "CommonWealth", "UNICEF", "Uzbekistan", "India", "Norway", "United Kingdom",
    "United States of America"};

  // The list for selecting countries
  private JList lista = new JList(flagTitles);

  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] iconosBanderas = {
    new ImageIcon("image/European-Union.gif"),
    new ImageIcon("image/Spain.gif"),
    new ImageIcon("image/Commonwealth.gif"),
    new ImageIcon("image/UNICEF.gif"),
    new ImageIcon("image/Uzbekistan.gif"),
    new ImageIcon("image/india.gif"),
    new ImageIcon("image/norway.gif"),
    new ImageIcon("image/uk.gif"),
    new ImageIcon("image/us.gif")
  };

  // Arrays of labels for displaying images
  private JLabel[] etiquetasImagenes = new JLabel[NUMBER_OF_FLAGS];

  public static void main(String[] args) {
    DemoList frame = new DemoList();
    frame.setSize(550, 300);
    frame.setTitle("DemoList");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public DemoList() {
    // Create a panel to hold nine labels
    JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));

    for (int i = 0; i < NUMBER_OF_FLAGS; i++) {
      panel.add(etiquetasImagenes[i] = new JLabel());
      etiquetasImagenes[i].setHorizontalAlignment
        (SwingConstants.CENTER);
    }

    // Add panel and the list to the frame
    add(panel, BorderLayout.CENTER);
    add(new JScrollPane(lista), BorderLayout.WEST);

    // Register listeners
    lista.addListSelectionListener(new ListSelectionListener() {
      /** Handle list selection */
      public void valueChanged(ListSelectionEvent e) {
        // Get selected indices
        int[] indices = lista.getSelectedIndices();

        int i;
        // Set icons in the labels
        for (i = 0; i < indices.length; i++) {
          etiquetasImagenes[i].setIcon(iconosBanderas[indices[i]]);
        }

        // Remove icons from the rest of the labels
        for (; i < NUMBER_OF_FLAGS; i++) {
          etiquetasImagenes[i].setIcon(null);
        }
      }
    });
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
