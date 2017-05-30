import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CalculadoraAmortizacion extends JFrame {
  // Crea los campos de texto para tipo de interés
	// años, cantidad solicitada, pago mensual y toal
  private JTextField ctextoInteres = new JTextField();
  private JTextField ctextoNAnios = new JTextField();
  private JTextField ctextoCantidad = new JTextField();
  private JTextField ctextoCuotaMensual = new JTextField();
  private JTextField ctextoImporteTotal = new JTextField();

  // Crea un botón para calcular el préstamo 
  private JButton botonCalculaPrestamo = new JButton("Calcular");

  public CalculadoraAmortizacion() {
    // Panel p1 to hold labels and text fields
    JPanel p1 = new JPanel(new GridLayout(5, 2));
    p1.add(new JLabel("Tipo de interés (%)"));
    p1.add(ctextoInteres);
    p1.add(new JLabel("Número de años"));
    p1.add(ctextoNAnios);
    p1.add(new JLabel("Cuantía del Préstamo"));
    p1.add(ctextoCantidad);
    p1.add(new JLabel("Cuota mensual"));
    p1.add(ctextoCuotaMensual);
    p1.add(new JLabel("Total a pagar"));
    p1.add(ctextoImporteTotal);
    p1.setBorder(new TitledBorder("Introduzca Cuantía, tipo de interés y años"));

    // Panel p2 para almacenar el botón
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(botonCalculaPrestamo);

    // Añade los paneles a la ventana 
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Registra el oyente del evento
    botonCalculaPrestamo.addActionListener(new OyenteBoton());
  }

  /** Gestiona la pulsación del botón de cálculo del préstao */
  private class OyenteBoton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Obtiene los valores de los campos de texto 
      double interes         = Double.parseDouble(ctextoInteres.getText());
      int anios              = Integer.parseInt(ctextoNAnios.getText());
      double importePrestamo = Double.parseDouble(ctextoCantidad.getText());

      // Crea un objeto préstamo 
      Prestamo prestamo = new Prestamo(interes, anios, importePrestamo);

      // Muestra los pagos mensuales y total  
      ctextoCuotaMensual.setText(String.format("%.2f", prestamo.getCuotaMensual()));
      ctextoImporteTotal.setText(String.format("%.2f", prestamo.getImporteTotal()));
    }
  }
  
  public static void main(String[] args) {
    CalculadoraAmortizacion frame = new CalculadoraAmortizacion();
    frame.pack();
    frame.setTitle("Calculadora Amortizacion");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
