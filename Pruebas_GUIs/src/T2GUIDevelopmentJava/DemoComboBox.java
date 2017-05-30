package T2GUIDevelopmentJava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoComboBox extends JFrame {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"European Union", "Spain",
    "CommonWealth", "UNICEF", "Uzbekistan", "India", "Norway", "United Kingdom",
    "United States of America"};

  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] flagImage = {
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

  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[9];

  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();

  // Create a combo box for selecting countries
  private JComboBox combo = new JComboBox(flagTitles);

  public static void main(String[] args) {
    DemoComboBox frame = new DemoComboBox();
    frame.pack();
    frame.setTitle("DemoComboBox");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 200);
    frame.setVisible(true);
  }

  public DemoComboBox() {
    // Set text description
      flagDescription[0]= "The European Union flag \n\n" +
      "The flag of Europe consists of a circle of 12 golden (yellow)" +
			"stars on an azure background. It is the flag and emblem of the" +
			"European Union (EU) and Council of Europe. It is also often" +
			"used to indicate eurozone countries, and, more loosely, to" +
			"represent the continent of Europe or the countries of Europe" +
			"independent of any of these institutions. The number of stars" +
			"does not vary according to the members of either organisation" +
			"as they are intended to represent all the peoples of Europe," +
			"even those outside European integration";
    flagDescription[1] = "Description for Spain ... ";
    flagDescription[2] = "Description for CommonWealth ... ";
    flagDescription[3] = "Description for UNICEF ... ";
    flagDescription[4] = "Description for Uzbekistan ... ";
    flagDescription[5] = "Description for India ... ";
    flagDescription[6] = "Description for Norway ... ";
    flagDescription[7] = "Description for UK ... ";
    flagDescription[8] = "Description for US ... ";

    // Set the first country (EU) for display
    setDisplay(0);

    // Add combo box and description panel to the list
    add(combo, BorderLayout.NORTH);
    add(descriptionPanel, BorderLayout.CENTER);

    // Register listener
    combo.addItemListener(new ItemListener() {
      /** Handle item selection */
      public void itemStateChanged(ItemEvent e) {
        setDisplay(combo.getSelectedIndex());
      }
    });
  }

  /** Set display information on the description panel */
  public void setDisplay(int index) {
    descriptionPanel.setTitle(flagTitles[index]);
    descriptionPanel.setImageIcon(flagImage[index]);
    descriptionPanel.setDescription(flagDescription[index]);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
