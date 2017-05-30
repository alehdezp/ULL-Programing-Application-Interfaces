import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author Alejandro Hernandez Padrón
 * alu: alu0100891836
 * clase que contiene el funcionamiento del  algoritmo para la 
 * resolución del problema de las Torres de Hanoi
 */
public class HanoiTower {
	HashMap<String, ArrayList<Integer>> towers;		//HashMap que contiene la piezas de los tres palos
	private int nDiscos, contador, debug;			//nª de discos, contador de instrucciones
													//y modo debug
/**
 * Constructor de la clase, se le pasan dos parametros
 * @param nDiscos
 * @param debug
 */
	HanoiTower (String nDiscos, String debug){		
		
		this.debug = Integer.parseInt(debug);		//modo debug
		this.nDiscos =  Integer.parseInt(nDiscos);	//nº discos
		
		towers = new HashMap<String, ArrayList<Integer>>();		//iniciaizamos los palos
		towers.put("tower2", new ArrayList<Integer>());
		towers.put("tower3", new ArrayList<Integer>());
		
		ArrayList<Integer> torre1 = new ArrayList<Integer>();
		for (int i = 0; i < this.nDiscos; i++) 
			torre1.add(this.nDiscos - i);
		towers.put("tower1", torre1);
	}
	
	/**
	 * Función que incia el algoritmo
	 */
	public void start(){
		hanoi(nDiscos, "tower1", "tower2", "tower3");			
	}
	
	/**
	 * Metodo recursivo el cual hace la función principal del programa
	 * y halla la solción al problema
	 * @param n
	 * @param origen
	 * @param auxiliar
	 * @param destino
	 */
	public void hanoi (int n, String origen, String auxiliar, String destino){
		
		if (n == 1){									//si el tamaño es 1 mueve del palo origen
			mover(origen, destino);						//a destino

		}else{
			hanoi(n-1, origen, destino, auxiliar);		//si no llama a hanoi y le pasa el palo destino como
														//auxiliar y al reves
			mover(origen, destino);						//movemos origen a destino

			hanoi(n-1, auxiliar, origen, destino);		//volvemos a llamar hanoi una vez que hemos movido la pieza
		}												//mas grande posible a el destino para que calcule los niveles 
														//inferiores
	}
	
	/**
	 * Mueve un disco de origen a destino
	 * @param origen
	 * @param destino
	 */
	public void mover (String origen, String destino){

		ArrayList<Integer> ori = towers.get(origen);	//obtenemos los dos arrays del HashMap
		ArrayList<Integer> dest = towers.get(destino);
		
		
		int aux = ori.get(ori.size() - 1);				
		ori.remove(ori.size() - 1);						//pop del origen y pusheamos en destino
		dest.add(aux);
		
		towers.put(origen, ori);						//Guardamos los arrays en hash
		towers.put(destino, dest);
		
		contador++;										//contamos el movimiento
		if(debug == 1){									//imprimimos el resultado por pantalla con el modo debug
			System.out.println("Moviendo de" + origen + " to " + destino+ " : \n");
			System.out.println(this.toString());
		}
	}

	/**
	 * Metodo sobrescrito toString()
	 */
	public String toString(){
		ArrayList<Integer> tower1 = towers.get("tower1");
		ArrayList<Integer> tower2 = towers.get("tower2");
		ArrayList<Integer> tower3 = towers.get("tower3");
	
		String towerString = "";
		for(int i = nDiscos; i > 0; i--){

			if(tower1.size() >= i)
				towerString += "    " + tower1.get(i - 1) + "|		";
			else
				towerString += "     |		";	
			if(tower2.size() >= i)
				towerString += tower2.get(i - 1) + "|		";
			else
				towerString += " |		";	
			if(tower3.size() >= i)
				towerString += tower3.get(i - 1) + "|		";
			else
				towerString += " |		";	
			towerString += "\n";
		}
		
		towerString += "---------   -----------    -----------\n";
		towerString += " |tower1|     |tower2|       |tower3|\n";
		return towerString;
	}
	/**
	 * obtenemos el resultado del contador
	 * @return
	 */
	public int getContador(){
		return contador;
	}
}
