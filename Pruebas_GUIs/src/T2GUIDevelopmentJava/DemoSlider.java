import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class DemoSlider extends JFrame {
  // Create horizontal and vertical sliders
  private JSlider jsldHort = new JSlider(JSlider.HORIZONTAL);
  private JSlider jsldVert = new JSlider(JSlider.VERTICAL);

  // Create a PanelMensaje
  private PanelMensaje panelTexto =
    new PanelMensaje("Diseñando GUIs");

  public static void main(String[] args) {
    DemoSlider frame = new DemoSlider();
    frame.setTitle("DemoSlider");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public DemoSlider() {
    // Add sliders and message panel to the frame
    setLayout(new BorderLayout(5, 5));
    add(panelTexto, BorderLayout.CENTER);
    add(jsldVert, BorderLayout.EAST);
    add(jsldHort, BorderLayout.SOUTH);

    // Set properties for sliders
    jsldHort.setMaximum(50);
    jsldHort.setPaintLabels(true);
    jsldHort.setPaintTicks(true);
    jsldHort.setMajorTickSpacing(10);
    jsldHort.setMinorTickSpacing(1);
    jsldHort.setPaintTrack(false);
    jsldVert.setInverted(true);
    jsldVert.setMaximum(10);
    jsldVert.setPaintLabels(true);
    jsldVert.setPaintTicks(true);
    jsldVert.setMajorTickSpacing(10);
    jsldVert.setMinorTickSpacing(1);

    // Register listener for the sliders
    jsldHort.addChangeListener(new ChangeListener() {
      /** Handle scroll bar adjustment actions */
      public void stateChanged(ChangeEvent e) {
        // getValue() and getMaximumValue() return int, but for better
        // precision, use double
        double value = jsldHort.getValue();
        double maximumValue = jsldHort.getMaximum();
        double newX = (value * panelTexto.getWidth() / 
          maximumValue);
        panelTexto.setCoordX((int)newX);
      }
    });
    jsldVert.addChangeListener(new ChangeListener() {
      /** Handle scroll bar adjustment actions */
      public void stateChanged(ChangeEvent e) {
        // getValue() and getMaximumValue() return int, but for better
        // precision, use double
        double value = jsldVert.getValue();
        double maximumValue = jsldVert.getMaximum();
        double newY = (value * panelTexto.getHeight() / 
          maximumValue);
        panelTexto.setCoordY((int) newY);
      }
    });
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
