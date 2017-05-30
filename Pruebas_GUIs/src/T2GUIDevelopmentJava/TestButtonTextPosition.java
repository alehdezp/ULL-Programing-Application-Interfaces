// TestButtonTextPosition.java: Test button text position
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestButtonTextPosition {
  public static void main(String[] args) {
// Create an image icon from image file
ImageIcon icon = new ImageIcon("image/grapes.gif");

// Create a label with text, an icon,
// with centered horizontal alignment
JLabel jlbl = new JLabel("Uvas", icon, SwingConstants.CENTER);

// Set label's text alignment and gap between text and icon
jlbl.setHorizontalTextPosition(SwingConstants.RIGHT);
jlbl.setVerticalTextPosition(SwingConstants.CENTER);
jlbl.setIconTextGap(5);
jlbl.setBorder(new LineBorder(Color.MAGENTA, 2));


    // Create a frame and set its properties
    JFrame frame = new JFrame("RIGHT");
    frame.getContentPane().add(jlbl, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
