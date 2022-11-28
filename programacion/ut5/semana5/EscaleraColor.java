package ut5.semana5;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class EscaleraColor {

	public static void main(String[] args) {
		/*
		 * Declaración de variables.
		 * carta: array de los números de cartas, se graba true si el número se ha introducido.
		 * numeroCarta: El número de la carta que introduce el usuario.
		 * menorCarta, mayorCarta: menor y mayor de las cartas introducidas por el usuario.
		 * palo: Inicial del palo de la carta introducida por el usuario.
		 * paloAnterior: Inicial del palo que se introdujo anteriormente por el usuario.
		 * cont: Contador que se va a usar en varios bucles.
		 * mismoPalo: Si todas las cartas son del mismo palo.
		 * palosCorrectos: Iniciales de los palos.
		 * nombresPalos: Nombres de los palos.
		 * nombrePalo: Se almacena el nombre del último palo introducido por el usuario. 
		 * salir: Lee la opción para salir del programa.
		 */
		boolean[] carta = new boolean[13];
	    int numeroCarta;
	    int menorCarta = 14;
	    int mayorCarta = 0;
	    char palo;
	    char paloAnterior = ' ';
	    int cont;
	    boolean mismoPalo = true;
	    String palosCorrectos = "PDTC";
	    String nombresPalos = "Picas-Diamantes-Tréboles-Corazones";
	    String nombrePalo = "";
	    boolean salir;

	    do {
	    	// Inicialización del array de cartas a false.
	    	Arrays.fill(carta,false);
	    	// Se piden las 4 cartas de la mano.
    		for (cont = 1; cont <= 4; cont++) {
    			// Bucle para asegurar que la carta está entre 1 y 13.
    			do {
    				numeroCarta = Integer.parseInt(JOptionPane.showInputDialog("Número de la carta " + cont + " (entre 1 y 13)"));
    			} while ((numeroCarta < 1) || (numeroCarta > 13));
    			carta[numeroCarta - 1] = true;
    			if (numeroCarta < menorCarta) {
    				menorCarta = numeroCarta;
    			}
    			if (numeroCarta > mayorCarta) {
    				mayorCarta = numeroCarta;
    			}
    			
    			// Bucle para asegurar que el palo es correcto.
    			do {
    				palo = JOptionPane.showInputDialog("Palo de la carta " + cont + " (P)icas, (D)iamantes, (T)réboles, (C)orazones").toUpperCase().charAt(0);
    			} while (palosCorrectos.indexOf(palo) == -1);
    			if (paloAnterior == ' ') {
    				paloAnterior = palo;
    			}
    			// Si mismoPalo es false no hay que asignar más la variable, ya que no se podrá hacer escalera.
    			if (mismoPalo) {
    				mismoPalo = paloAnterior == palo;
    			}
    			
    			System.out.println("Carta " + cont + ", número " + numeroCarta);
    			// Extraemos el nombre del palo según sea la inicial.
    			int posPalo = nombresPalos.indexOf(palo);
    			int posGuion = nombresPalos.indexOf('-',posPalo);
    			if (posGuion != -1) {
    				nombrePalo = nombresPalos.substring(posPalo,posGuion);
    			} else {
    				nombrePalo = nombresPalos.substring(posPalo);
    			}
    			System.out.println("Carta " + cont + ", palo " + nombrePalo);
    		}
    		
    		// Si no son todas del mismo palo no se podrá hacer escalera.
    		// La diferencia entre la mayor y menor carta para poder hacer escalera puede ser:
    		// 3 si las 4 cartas son consecutivas,
    		// 4 si la carta que falta está en medio de las 4.
    		// Si la diferencia es menor de 3 habrá alguna carta repetida y no se podrá hacer escalera,
    		// y si la diferencia es mayor de 4 no serán consecutivas las 5 cartas.
    		if (mismoPalo && (((mayorCarta - menorCarta) == 4) || ((mayorCarta - menorCarta) == 3))) {
    			// la diferencia es 3 así que las cartas son consecutivas. 
    			if ((mayorCarta - menorCarta) == 3) {
    				// Si la menor carta es mayor que 1 la escalera se podrá completar por abajo.
    				if (menorCarta > 1) {
    					System.out.println("Una posible carta para la escalera es el " + (menorCarta - 1) + " de " + nombrePalo);
    				}
    				// Si la mayor carta es menor que 13 la escalera se podrá completar por arriba.
    				if (mayorCarta < 13) {
    					System.out.println("Una posible carta para la escalera es el " + (mayorCarta + 1) + " de " + nombrePalo);
    				}
    			// La diferencia es 4 así que la carta que falta queda en medio de las 4, será la que tenga false en el array.
    			// Aquí solo hay una posibilidad de completar la escalera.
    			} else {
    				cont = menorCarta - 1;
    				do {
    					cont++;
    				} while (carta[cont]);
    				System.out.println("La carta para la escalera es el " + (cont + 1) + " de " + nombrePalo);
    			}
    		} else {
    			System.out.println("No se puede hacer escalera.");
    		}
    	// Se repite el programa hasta que el usuario elija salir introduciendo "S".
    	salir = !JOptionPane.showInputDialog("Introduce S para salir, cualquier otra cosa para otra mano...").toUpperCase().equals("S"); 
	    } while (!salir);
	}
}
