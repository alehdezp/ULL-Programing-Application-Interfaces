package T2GUIDevelopmentJava;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DemoBoton1 extends JPanel implements ActionListener {
  protected JButton b1, b2, b3;

  public DemoBoton1() {

    Icon middleButtonIcon = new SquareIcon();
 
    b1 = new JButton("Disable middle button");
    b1.setVerticalTextPosition(AbstractButton.CENTER);
    b1.setHorizontalTextPosition(AbstractButton.LEADING);
    b1.setMnemonic(KeyEvent.VK_D);
    b1.setActionCommand("disable");

    b2 = new JButton("Middle button", middleButtonIcon);
    b2.setVerticalTextPosition(AbstractButton.BOTTOM);
    b2.setHorizontalTextPosition(AbstractButton.CENTER);
    b2.setMnemonic(KeyEvent.VK_M);

    b3 = new JButton("Enable middle button");
    //Use the default text position of CENTER, TRAILING (RIGHT).
    b3.setMnemonic(KeyEvent.VK_E);
    b3.setActionCommand("enable");
    b3.setEnabled(false);

    //Listen for actions on buttons 1 and 3.
    b1.addActionListener(this);
    b3.addActionListener(this);

    b1.setToolTipText("Click this button to disable the middle button.");
    b2.setToolTipText("This middle button does nothing when you click it.");
    b3.setToolTipText("Click this button to enable the middle button.");

    //Add Components to this container, using the default FlowLayout.
    add(b1);
    add(b2);
    add(b3);
  }

  public void actionPerformed(ActionEvent e) {
    if ("disable".equals(e.getActionCommand())) {
      b2.setEnabled(false);
      b1.setEnabled(false);
      b3.setEnabled(true);
    } else {
      b2.setEnabled(true);
      b1.setEnabled(true);
      b3.setEnabled(false);
    }
  }

  private static void createAndShowGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame frame = new JFrame("DemoBoton1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DemoBoton1 newContentPane = new DemoBoton1();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    createAndShowGUI();
  }

  class SquareIcon implements Icon {
    private static final int SIZE = 10;

    public void paintIcon(Component c, Graphics g, int x, int y) {
      if (c.isEnabled()) {
        g.setColor(Color.RED);
      } else {
        g.setColor(Color.GRAY);
      }

      g.fillRect(x, y, SIZE, SIZE);
    }

    public int getIconWidth() {
      return SIZE;
    }

    public int getIconHeight() {
      return SIZE;
    }
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
