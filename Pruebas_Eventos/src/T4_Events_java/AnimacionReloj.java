package T4_Events_java;

import java.awt.event.*;
import javax.swing.*;

public class AnimacionReloj extends Reloj {
  public AnimacionReloj() {
    // Create a timer with delay 1000 ms
    Timer timer = new Timer(1000, new TimerListener());
    timer.start();
  }

  private class TimerListener implements ActionListener {
    /** Handle the action event */
    public void actionPerformed(ActionEvent e) {
      // Set new time and repaint the clock to display current time
      setCurrentTime();
      repaint();
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("AnimacionReloj");
    AnimacionReloj clock = new AnimacionReloj();
    frame.add(clock);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
