import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoScrollBar extends JFrame {
  // Create horizontal and vertical scroll bars
  private JScrollBar jscbHort = new JScrollBar(JScrollBar.HORIZONTAL);
  private JScrollBar jscbVert = new JScrollBar(JScrollBar.VERTICAL);

  // Create a PanelMensaje
  private PanelMensaje panelTexto = new PanelMensaje("Aplicaciones Interactivas");

  public static void main(String[] args) {
    DemoScrollBar frame = new DemoScrollBar();
    frame.setTitle("DemoScrollBar");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(600, 300);
    frame.setVisible(true);
  }

  public DemoScrollBar() {
    // Add scroll bars and message panel to the frame
    setLayout(new BorderLayout());
    add(panelTexto, BorderLayout.CENTER);
    add(jscbVert, BorderLayout.EAST);
    add(jscbHort, BorderLayout.SOUTH);

    // Register listener for the scroll bars
    jscbHort.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        // getValue() and getMaximumValue() return int, but for better
        // precision, use double
        double value = jscbHort.getValue();
        double maximumValue = jscbHort.getMaximum();
        double newX = (value * panelTexto.getWidth() / maximumValue);
        panelTexto.setCoordX((int)newX);
      }
    });
    jscbVert.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        // getValue() and getMaximumValue() return int, but for better
        // precision, use double
        double value = jscbVert.getValue();
        double maximumValue = jscbVert.getMaximum();
        double newY = (value * panelTexto.getHeight() / maximumValue);
        panelTexto.setCoordY((int)newY);
      }
    });
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
