import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class IzarBandera extends JFrame {
  public IzarBandera() {
    URL imageURL = this.getClass().getResource("European-Union.gif");
    Image image = new ImageIcon(imageURL).getImage();
    add(new FlagAnthemPanel(image));
  }

  public static class FlagAnthemPanel extends JPanel {
    private Image image;
    private Timer timer = new Timer(400, new Listener());
    int x = 20;
    int y = 150;

    public FlagAnthemPanel(Image image) {
      this.image = image;
      timer.start();

    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (y > 0) {
        y -= 1;
      }

      g.drawImage(image, x, y, 60, 40, this);
    }
    
    class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        repaint();
      }
    }
  }

  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new IzarBandera();
    frame.setTitle("IzarBandera");
    // Display the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
