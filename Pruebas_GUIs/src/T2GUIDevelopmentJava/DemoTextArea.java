import java.awt.*;
import javax.swing.*;

public class DemoTextArea extends JFrame {
  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();

  public static void main(String[] args) {
    DemoTextArea frame = new DemoTextArea();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Demo TextArea");
    frame.setVisible(true);
    frame.setSize(700, 400);
  }

  public DemoTextArea() {
    // Set title, text and image in the description panel
    descriptionPanel.setTitle("The European Union");
    String description = "The European Union flag \n\n" +
      "The flag of Europe consists of a circle of 12 golden (yellow)" +
			"stars on an azure background. It is the flag and emblem of the" +
			"European Union (EU) and Council of Europe. It is also often" +
			"used to indicate eurozone countries, and, more loosely, to" +
			"represent the continent of Europe or the countries of Europe" +
			"independent of any of these institutions. The number of stars" +
			"does not vary according to the members of either organisation" +
			"as they are intended to represent all the peoples of Europe," +
			"even those outside European integration";
    descriptionPanel.setDescription(description);
    descriptionPanel.setImageIcon(new ImageIcon("image/European-Union.gif"));

    // Add the description panel to the frame
    setLayout(new BorderLayout());
    add(descriptionPanel, BorderLayout.CENTER);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
