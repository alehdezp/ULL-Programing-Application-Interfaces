/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 18-04-2017
 * 	Controlador de nuestro programa
 * @author: Alejandro Hernandez Padron
 *
 */

package camino_aleatorio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 * Controlador de nuestro programa que extiende ActionListener
 *
 */
public class CaminoControl implements ActionListener{
	
	private CaminoView vistaCamino; 			//Vista de nuestro recorrido
	private PanelView vistaButtons;				//Vista de nuestros botones
	private Camino camino;						//Modelo del camino
	private Timer tm;							//Timer para el movimiento

	/**
	 * Constructor de nuestro Control
	 * @param vistaCamino
	 * @param vistaButtons
	 * @param camino
	 */
	CaminoControl(CaminoView vistaCamino, PanelView vistaButtons, Camino camino){
		
		setVistaCamino(vistaCamino);			//Seteamos vistas y modelo
		setVistaButtons(vistaButtons);
		setCamino(camino);
		paintMapa();							//Dibujamos el mapa a partir de nuestro modelo

	}
	
	/**
	 * Funcion implementada de ActionLIstener
	 * Gestiona los eventos al pulsar los botones
	 */
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getActionCommand().equals("empezar")) { //Inicia un timer el cual va moviendo nuestro camino
			tm = new Timer(500, new Randomize());
			tm.start();
		}
		if ( e.getActionCommand().equals("finalizar")) {	//Para el timer y detiene el movimiento
			tm.stop();
		}
		if ( e.getActionCommand().equals("color")) {		//Modifica el color de nuestro camino
			Random rn = new Random();
			int cl1 = (rn.nextInt(255) + 255) % 255;
			int cl2 = (rn.nextInt(255) + 255) % 255;
			int cl3 = (rn.nextInt(255) + 255) % 255;
			getVistaCamino().setColor(new Color(cl1, cl2, cl3));  //Seteamos el color
			paintRecorrido();
		}
		if ( e.getActionCommand().equals("densidad")) {		//Cambia la cantidad de puntos que mostramos en nuestro camino
			System.out.println("densidad");
			String s = getVistaButtons().getDensidad().getText();
			int d = Integer.parseInt(s) / 2;
			getCamino().setRecorrido(d, d);
			getVistaCamino().setRecorrido(getCamino().getRecorrido());
			paintMapa();
		}

	}

	/**
	 * Dibujamos nuestro camino y recorrido a travez de nuestra vista camino
	 */
	public void paintMapa(){
		getVistaCamino().setDensidad(getCamino().getDimensionX(), getCamino().getDimensionY());
		getVistaCamino().setLast(getCamino().getX(), getCamino().getY());
		paintRecorrido();
	}

	public void paintRecorrido(){

		getVistaCamino().repaint();
	}

	/**
	 * Clase Randomize que mueve de forma random nuestro recorrido cada vez que 
	 *se ejecuta un accion, en nuestro caso el timer
	 */
	class Randomize implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Random rn = new Random();
			int i = (rn.nextInt() % 4 + 4) % 4;		//Entero positivo menor que 4
			System.out.println("timer");
			switch(i){
			
			case 0: getCamino().moverX(1);break;		//Movemos izq
			case 1: getCamino().moverX(- 1);break;		//Movemos derecha
			case 2: getCamino().moverY(1);break;		//Movemos abajo
			case 3: getCamino().moverY(- 1);break;		//Movemos arriba
			default:;
			}
			
			//Si el camino ha llegado a algun borde de la pantalla, paramos el programa
			if(getCamino().getX() <= 0 || getCamino().getX() >= getCamino().getDimensionX() - 1 
					|| getCamino().getY() <= 0 ||getCamino().getY() >= getCamino().getDimensionY() - 1)
				tm.stop();		
			
			//Dibujamos el mapa y el recorrido
			getVistaCamino().setLast(getCamino().getX(), getCamino().getY());
			getVistaCamino().setRecorrido(getCamino().getRecorrido());
			getVistaCamino().repaint();

		}
	}

	/**
	 * @return the vistaCamino
	 */
	public CaminoView getVistaCamino() {
		return vistaCamino;
	}

	/**
	 * @param vistaCamino the vistaCamino to set
	 */
	public void setVistaCamino(CaminoView vistaCamino) {
		this.vistaCamino = vistaCamino;
	}

	/**
	 * @return the vistaButtons
	 */
	public PanelView getVistaButtons() {
		return vistaButtons;
	}

	/**
	 * @param vistaButtons the vistaButtons to set
	 */
	public void setVistaButtons(PanelView vistaButtons) {
		this.vistaButtons = vistaButtons;
	}

	/**
	 * @return the camino
	 */
	public Camino getCamino() {
		return camino;
	}

	/**
	 * @param camino the camino to set
	 */
	public void setCamino(Camino camino) {
		this.camino = camino;
	}




}
