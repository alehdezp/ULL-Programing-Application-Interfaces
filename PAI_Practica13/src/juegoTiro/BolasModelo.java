/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Clase que contiene todas las bolas a 
 * eliminar de nuestra fila superior,
 * su color y si es hay que dibujarlas
 * El numero de bolas depende de nuestro ancho y diametro
 * de las bolas 
 *
 */
public class BolasModelo {

	private int ancho, alto;
	private ArrayList<Ellipse2D> bolas = new ArrayList<>();
	private ArrayList<Color> colorBola = new ArrayList<>();
	private ArrayList<Boolean> dibBolas = new ArrayList<>();
	private Color[] colores = new Color[]{Color.BLUE, Color.GREEN,
			Color.MAGENTA, Color.RED, Color.ORANGE};
	private int diametro = 40;
	private int nBolas;
	private int nFilas = 4;

	/**
	 * Constructo que seteam el diametro, el ancho
	 * el numero de bolas y todas las bolas a dibujar
	 * @param ancho
	 * @param diametro
	 */
	public BolasModelo(int ancho, int diametro, int nFilas){
		setDiametro(diametro);
		setNumeroDeBolas(ancho);
		setnFilas(nFilas);
		setAllBolas();
	}

	/**
	 * Setea el numero de bolas de nuestro
	 * programa
	 * @param ancho
	 */
	public void setNumeroDeBolas(int ancho){
		int r = ancho / (diametro + 8);
		setnBolas(r);
	}


	/**
	 * Setea los arrray con todas las bolas,
	 * sus colores y el array de dibujo
	 */
	public void setAllBolas(){
		int x = 4;
		int y = 10;
		int x2 = 8 + diametro / 2;
		System.out.println(nFilas);
		for (int i = 0; i < nFilas; i++) {
			int auxX, auxY;
			int resta = 0;
			if(i % 2 == 0){
				auxX = x;
				auxY = y;
			}else{
				auxX = x2;
				auxY = y;
				resta = 1;
			}
			for (int j = 0; j < nBolas - resta; j++) {
				dibBolas.add(true);
				bolas.add(new Ellipse2D.Double(auxX, auxY, diametro, diametro));
				colorBola.add(randomColor());
				auxX += 8 + diametro;
			}
			y += diametro;

		}
	}

	/**
	 * Genera un color aleatorio de nuestro
	 * array colores
	 * @return
	 */
	public Color randomColor(){
		Random rn = new Random();
		return colores[rn.nextInt(colores.length)];
	}

	/**
	 * Comprueba si la bolaTiro colision con 
	 * alugna de las  bolas en el intento n
	 * @param bolaTiro
	 * @param nIntento
	 * @return
	 */
	public int colisiona(Ellipse2D bolaTiro, Color color, int nIntento){
		int col = 0;
		int index = -1;

		int x1 = (int) (bolaTiro.getX() + diametro/2);
		int y1 = (int) (bolaTiro.getY() + diametro/2);
		for (int i = 0; i < bolas.size(); i++) {
			if(dibBolas.get(i)){		//Si la bola es dibujable
				int x2 = (int) (bolas.get(i).getX() + diametro/2);	//Calculamos los centros
				int y2 =  (int) (bolas.get(i).getY() + diametro/2);

				//La distancia de los centros
				double distancia = Math.sqrt((x1 - x2) * (x1 -x2) + (y1 - y2) * (y1 - y2));
				if(distancia < diametro){		//Si es menor que diametro, colisiona
					index= i;
					col ++;
				}
			}
		}
		//Si es el tecer intento y solo hay una colision, la eliminamos del dibujo
		if((nIntento == 2)&&(col == 1)&&(colorBola.get(index) == color)){
			dibBolas.set(index, false);
			
			eliminaVecinas(bolas.get(index), color);
		}
		else if((index > 0)&&(nIntento == 2) && (colorBola.get(index) != color)){
			int auxX = (int) (bolas.get(index).getX());
			if(auxX < (x1 -diametro / 2)){
				auxX += diametro/2 + 4;
			}else
				auxX -= diametro/2 + 4;
			
			int auxY = (int) (bolas.get(index).getY() + diametro);
			bolas.add(new Ellipse2D.Double(auxX, auxY, diametro, diametro));
			dibBolas.add(true);
			colorBola.add(color);

		}

		return col;		
	}

	public void eliminaVecinas(Ellipse2D bolaV, Color color){
		int x = (int) (bolaV.getX() - 4 - diametro/2);
		int y = (int) (bolaV.getY() - diametro);
		int x1 = (int) (bolaV.getX() + 4 + diametro/2);

		int x2 = (int) (bolaV.getX() + 8 + diametro);
		int x3 = (int) (bolaV.getX() - 8 - diametro);
		int y1 = (int) (bolaV.getY());

		int y2 = (int) (bolaV.getY() - diametro);

		for (int i = 0; i < bolas.size()-1; i++) {
			if((dibBolas.get(i)) &&(colorBola.get(i) == color)){
				if((bolas.get(i).getX() == x)&&(bolas.get(i).getY() == y))
					dibBolas.set(i, false);
				else if ((bolas.get(i).getX() == x1)&&(bolas.get(i).getY() == y))
					dibBolas.set(i, false);
				else if ((bolas.get(i).getX() == x)&&(bolas.get(i).getY() == y2))
					dibBolas.set(i, false);
				else if (((int)bolas.get(i).getX() == x2)&&((int)bolas.get(i).getY() == y1))
					dibBolas.set(i, false);
				else if (((int)bolas.get(i).getX() == x3)&&((int)bolas.get(i).getY() == y1)){
					dibBolas.set(i, false);
				}
			}
		}
	}

	/**
	 * @return the colorBola
	 */
	public ArrayList<Color> getColorBola() {
		return colorBola;
	}

	/**
	 * @param colorBola the colorBola to set
	 */
	public void setColorBola(ArrayList<Color> colorBola) {
		this.colorBola = colorBola;
	}

	/**
	 * @return the colores
	 */
	public Color[] getColores() {
		return colores;
	}

	/**
	 * @param colores the colores to set
	 */
	public void setColores(Color[] colores) {
		this.colores = colores;
	}

	/**
	 * @return the nFilas
	 */
	public int getnFilas() {
		return nFilas;
	}

	/**
	 * @param nFilas the nFilas to set
	 */
	public void setnFilas(int nFilas) {
		this.nFilas = nFilas;
	}

	/**
	 * @return the nBolas
	 */
	public int getnBolas() {
		return nBolas;
	}

	/**
	 * @param nBolas the nBolas to set
	 */
	public void setnBolas(int nBolas) {
		this.nBolas = nBolas;
	}

	/**
	 * @return the dibBolas
	 */
	public ArrayList<Boolean> getDibBolas() {
		return dibBolas;
	}


	/**
	 * @param dibBolas the dibBolas to set
	 */
	public void setDibBolas(ArrayList<Boolean> dibBolas) {
		this.dibBolas = dibBolas;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}



	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}



	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}



	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}


	/**
	 * @return the bolas
	 */
	public ArrayList<Ellipse2D> getBolas() {
		return bolas;
	}

	/**
	 * @param bolas the bolas to set
	 */
	public void setBolas(ArrayList<Ellipse2D> bolas) {
		this.bolas = bolas;
	}

	/**
	 * @return the diametro
	 */
	public int getDiametro() {
		return diametro;
	}

	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}




}
