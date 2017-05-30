package T2GUIDevelopmentJava;

import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMensaje extends JPanel {
  private String mensaje = "Prog. de Apps. Interactivas";     /** The message to be displayed */
  private int coordX = 20;                        /** The x coordinate where the message is displayed */
  private int coordY = 20;                        /** The y coordinate where the message is displayed */
  private boolean centrado;                       /** Indicate whether the message is displayed in the center */
  private int intervalo = 10;                     /** Interval for moving message horizontally and vertically */
  public PanelMensaje() {                         /** Construct with default properties */
  }

  public PanelMensaje(String mensaje) {           /** Construct a message panel with a specified message */
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
    repaint();
  }

  public int getCoordX() {
    return coordX;
  }

  public void setCoordX(int x) {
    this.coordX = x;
    repaint();
  }

  public int getCoordY() {
    return coordY;
  }

  public void setCoordY(int y) {
    this.coordY = y;
    repaint();
  }

  public boolean estaCentrado() {
    return centrado;
  }

  /** Set a new centered */
  public void setCentrado(boolean centrado) {
    this.centrado = centrado;
    repaint();
  }

  /** Return interval */
  public int getIntervalo() {
    return intervalo;
  }

  /** Set a new interval */
  public void setIntervalo(int intervalo) {
    this.intervalo = intervalo;
    repaint();
  }

  /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (centrado) {
      // Get font metrics for the current font
      FontMetrics fm = g.getFontMetrics();

      // Find the center location to display
      int achuraCadena = fm.stringWidth(mensaje);
      int alturaCadena = fm.getAscent();
      // Get the position of the leftmost character in the baseline
      coordX = getWidth() / 2 - achuraCadena / 2;
      coordY = getHeight() / 2 + alturaCadena / 2;
    }

    g.drawString(mensaje, coordX, coordY);
  }

  /** Move the message left */
  public void moverIzq() {
    coordX -= intervalo;
    repaint();
  }

  /** Move the message right */
  public void moverDer() {
    coordX += intervalo;
    repaint();
  }

  /** Move the message up */
  public void moverArr() {
    coordY -= intervalo;
    repaint();
  }

  /** Move the message down */
  public void moverAba() {
    coordY += intervalo;
    repaint();
  }

  /** Override get method for preferredSize */
  public Dimension getPreferredSize() {
    return new Dimension(200, 30);
  }
}


/*
 * vim:ts=2:set nu:sw=2
 */
