/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 18-04-2017
 * 	Modelo de nuestro programa, contiene el camino recorrido
 * 	sus dimensiones y movimiento.
 * @author: Alejandro Hernandez Padron
 *
 */

package camino_aleatorio;

import java.util.ArrayList;

public class Camino {


	//Matriz con los puntos recorridos y sus direcciones
	private ArrayList<ArrayList<String>> recorrido = new ArrayList<ArrayList<String>>();

	private int x, y;	 			//Posicion actual de nuestro recorrido
	private int desplazamiento;		//
	private int dimensionX;			//Numero de lineas verticales
	private int dimensionY;			//Numero de lineas horozontales

	/**
	 * Contructor por defecto que contruye la matriz de recorrido
	 * @param dimX
	 * @param dimY
	 */
	Camino(int dimX, int dimY){
		setRecorrido(dimX, dimY);		//Contruimos matriz

	}

	/**
	 * Construye el recorrido, el punto de inicio y sus dimenciones
	 * @param dimX
	 * @param dimY
	 */
	public void setRecorrido(int dimX, int dimY){

		recorrido = new ArrayList<ArrayList<String>>();
		setDimensionX(dimX);						
		setDimensionY(dimY);

		for (int i = 0; i < dimY; i++) {
			ArrayList<String> aux = new ArrayList<>();
			for (int j = 0; j < dimX; j++) {
				aux.add("");			
			}
			getRecorrido().add(aux);
		}

		setCenter();   //Seteamos el centro recorrido
	}

	/**
	 * Estrablecemos el centro del recorrido
	 */
	public void setCenter(){
		setX((int)(getDimensionX()/2));
		setY((int)(getDimensionY()/2));	
	}

	/**
	 * @return the recorrido
	 */
	public ArrayList<ArrayList<String>> getRecorrido() {
		return recorrido;
	}


	/**
	 * @param recorrido the recorrido to set
	 */
	public void setRecorrido(ArrayList<ArrayList<String>> recorrido) {
		this.recorrido = recorrido;
	}


	/**
	 * Mueve nuestro punto del recorrido en el eje de las x en funcion del valor pasado
	 * 
	 * @param x
	 */
	public void moverX(int x){
		if(x == 1){							//Movemos hacia la derecha y escribimos una O en el punto actual de la matriz
			String s = getRecorrido().get(getY()).get(getX()) + " O";
			getRecorrido().get(getY()).set(getX(), s);
		}else if (x == -1){					//Movemos hacia la izq y escribimos una E en el punto actual de la matriz
			String s = getRecorrido().get(getY()).get(getX()) + " E";
			getRecorrido().get(getY()).set(getX(), s);
		}
		setX(getX() + x);
	}

	/**
	 * Mueve nuestro punto del recorrido en el eje de las y en funcion del valor pasado
	 * @param x
	 */
	public void moverY(int y){

		if(y == 1){							//Movemos hacia abajo y escribimos una S en el punto actual de la matriz
			String s = getRecorrido().get(getY()).get(getX()) + " S";
			getRecorrido().get(getY()).set(getX(), s);
		}else if (y == -1){					//Movemos hacia arriba y escribimos una N en el punto actual de la matriz
			String s = getRecorrido().get(getY()).get(getX()) + " N";
			getRecorrido().get(getY()).set(getX(), s);
		}
		setY(getY() + y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the desplazamiento
	 */
	public int getDesplazamiento() {
		return desplazamiento;
	}

	/**
	 * @param desplazamiento the desplazamiento to set
	 */
	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	/**
	 * @return the dimensionX
	 */
	public int getDimensionX() {
		return dimensionX;
	}

	/**
	 * @param dimensionX the dimensionX to set
	 */
	public void setDimensionX(int dimensionX) {
		this.dimensionX = dimensionX;
	}

	/**
	 * @return the dimensionY
	 */
	public int getDimensionY() {
		return dimensionY;
	}

	/**
	 * @param dimensionY the dimensionY to set
	 */
	public void setDimensionY(int dimensionY) {
		this.dimensionY = dimensionY;
	}



}
