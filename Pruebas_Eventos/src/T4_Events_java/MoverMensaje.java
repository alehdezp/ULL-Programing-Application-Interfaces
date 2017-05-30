package T4_Events_java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoverMensaje extends JFrame {
  public MoverMensaje() {
    // Create a MovableMessagePanel instance for moving a message
    MovableMessagePanel p = new MovableMessagePanel
      ("Gestion de Eventos");

    // Place the message panel in the frame
    setLayout(new BorderLayout());
    add(p);
  }

  /** Main method */
  public static void main(String[] args) {
    MoverMensaje frame = new MoverMensaje();
    frame.setTitle("MoverMensaje");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 100);
    frame.setVisible(true);
  }

  // Inner class: MovableMessagePanel draws a message
  static class MovableMessagePanel extends JPanel {
    private String message = "Gestion de Eventos";
    private int x = 20;
    private int y = 20;

    /** Construct a panel to draw string s */
    public MovableMessagePanel(String s) {
      message = s;
      addMouseMotionListener(new MouseMotionAdapter() {
        /** Handle mouse dragged event */
        public void mouseDragged(MouseEvent e) {
          // Get the new location and repaint the screen
          x = e.getX();
          y = e.getY();
          repaint();
        }
      });
    }

    /** Paint the component */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString(message, x, y);
    }
  }
}
