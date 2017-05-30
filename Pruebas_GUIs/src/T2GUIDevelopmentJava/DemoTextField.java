import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoTextField extends DemoRadioButton {
  // private JTextField jtfMessage = new JTextField(10);
  private JTextField jtfMessage = new JTextField("iiiii");

  /** Main method */
  public static void main(String[] args) {
    DemoTextField frame = new DemoTextField();
    frame.pack();
    frame.setTitle("Demo TextField");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public DemoTextField() {
    // Create a new panel to hold label and text field
    JPanel jpTextField = new JPanel();
    jpTextField.setLayout(new BorderLayout(5, 0));
    jpTextField.add(
      new JLabel("Introduzca un nuevo mensaje"), BorderLayout.WEST);
    jpTextField.add(jtfMessage, BorderLayout.CENTER);
    add(jpTextField, BorderLayout.NORTH);

    jtfMessage.setHorizontalAlignment(JTextField.LEFT);

    // Register listener
    jtfMessage.addActionListener(new ActionListener() {
      /** Handle ActionEvent */
      public void actionPerformed(ActionEvent e) {
        panelTexto.setMensaje(jtfMessage.getText());
        jtfMessage.requestFocusInWindow();
      }
    });
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
