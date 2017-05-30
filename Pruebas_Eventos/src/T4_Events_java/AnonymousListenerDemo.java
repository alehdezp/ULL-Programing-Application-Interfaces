import javax.swing.*;
import java.awt.event.*;

public class AnonymousListenerDemo extends JFrame {
  public AnonymousListenerDemo() {
    // Create four buttons
    JButton botonNew = new JButton("New");
    JButton botonOpen = new JButton("Open");
    JButton botonSave = new JButton("Save");
    JButton botonPrint = new JButton("Print");

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(botonNew);
    panel.add(botonOpen);
    panel.add(botonSave);
    panel.add(botonPrint);
    
    add(panel);

    // Create and register anonymous inner class listener
    botonNew.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Process New");
        }
      }
    );

    botonOpen.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Process Open");
        }
      }
    );
    
    botonSave.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Process Save");
        }
      }
    );
    
    botonPrint.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Process Print");
        }
      }
    );    
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new AnonymousListenerDemo();
    frame.setTitle("AnonymousListenerDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
