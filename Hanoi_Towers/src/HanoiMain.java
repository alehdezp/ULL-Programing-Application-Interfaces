/**
 * 
 * @author Alejandor Hdez Padron
 * alu: alu0100891836
 * Programa principal de la resolución del juego las Torres de 
 * Hanoi, al cual se le pasan dos parametros, el primero el numero 
 * piezas y luego el mod debug que nos muestra el resultado en cada
 * uno de los pasos realizados por el algoritmo que lo resuelve
 *
 */

public class HanoiMain {
	
	
	public static void main(String[] args) {				//Main del programa
		
		HanoiTower puzzle = new HanoiTower(args[0], args[1]);	//Iniciamos el tablero de juego
		
	    long totalTiempo;		
	    long tiempoInicio;
	    
		tiempoInicio = System.currentTimeMillis();
		
		puzzle.start();										//Resolvemos el juego

	
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("Tiempo = " +totalTiempo);
		
		System.out.print("Numero de movimientos realizados con n = "+ args[0]
				+ " discos es igual a : " + puzzle.getContador() + "\n" + puzzle);	//Imprimimos los resultados

		
	}
}
