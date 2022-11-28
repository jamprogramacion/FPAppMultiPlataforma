package ut5.semana6;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Anagramas {

	public static void main(String[] args) {
		/*
		 * Declaración de variables.
		 * frase1, frase2: Se almacenan las frases del usuario.
		 * frase1Copia, frase2Copia: Se van copiando letras de las frases, quitando acentos y caracteres que no sean alfabéticos.
		 * acentos, sinAcentos: Vocales con acentos y sus equivalentes sin acentos para sustituirlas.
		 * letras: Letras que vamos a considerar válidas. Todo lo demás se elimina.
		 * letraActual: Se va almacenando el carácter que se va leyendo de frase1 y frase2.
		 * letrasFrase1, letrasFrase2: Contamos cuantas apariciones hay de cada letra.  
		 * cont: Contador que se va a usar en varios bucles.
		 * salir: Lee la opción para salir del programa.
		 */
		String frase1;
		String frase2;
		String frase1Copia;
		String frase2Copia;
		String acentos = "áéíóúü";
		String sinAcentos = "aeiouu";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		char letraActual;
		int[] letrasFrase1 = new int[26];
		int[] letrasFrase2 = new int[26];
		int cont;
	    boolean salir;

	    do {
	    	// Inicialización de los array a 0, y las copias de las frases a cadena vacía.
	    	Arrays.fill(letrasFrase1,0);
	    	Arrays.fill(letrasFrase2,0);
	    	frase1Copia = "";
	    	frase2Copia = "";
	    	// Bucles para asegurar que las frases no tienen más de 1000 caracteres.
			do {
				frase1 = JOptionPane.showInputDialog("Introduce la primera frase (máximo 1000 caracteres)");
			} while (frase1.length() > 1000);
			do {
				frase2 = JOptionPane.showInputDialog("Introduce la primera frase (máximo 1000 caracteres)");
			} while (frase2.length() > 1000);
			System.out.println("Frase 1: " + frase1);
			System.out.println("Frase 2: " + frase2);
			
			// Leemos los caracteres de frase1 y frase2 y vamos copiando en frase1Copia y frase2Copia:
			// de las vocales acentuadas sus equivalentes y
			// las letras que están en la variable letras.
			// Así eliminamos espacios y cualquier otro símbolo no alfabético.
			// Incrementamos el número de apariciones de cada letra.
			for (cont = 0; cont < frase1.length(); cont++) {
				letraActual = frase1.toLowerCase().charAt(cont);
				int posAcentos = acentos.indexOf(letraActual); 
				if (posAcentos != -1) {
					letraActual = sinAcentos.charAt(posAcentos);
				}
				int posLetra = letras.indexOf(letraActual);
				if (posLetra != -1) {
					frase1Copia += letraActual;
					letrasFrase1[posLetra]++;
				}
			}
			for (cont = 0; cont < frase2.length(); cont++) {
				letraActual = frase2.toLowerCase().charAt(cont);
				int posAcentos = acentos.indexOf(letraActual); 
				if (posAcentos != -1) {
					letraActual = sinAcentos.charAt(posAcentos);
				}
				int posLetra = letras.indexOf(letraActual);
				if (posLetra != -1) {
					frase2Copia += letraActual;
					letrasFrase2[posLetra]++;
				}
			}
			
			// Si ambas frases no tienen la misma longitud, no pueden ser anagramas.
			if (frase1Copia.length() == frase2Copia.length()) {
				cont = 0;
				// En el momento que haya una letra que aparece más veces en una frase que en otra
				// no pueden ser anagramas.
				while ((letrasFrase1[cont] == letrasFrase2[cont]) && (cont < frase1Copia.length())) {
					cont++;
				}
				if (cont == frase1Copia.length()) {
					System.out.println("Las dos frases SÍ son anagramas.");
				} else {
					System.out.println("Las dos frases NO son anagramas.");
				}
			} else {
				System.out.println("Las dos frases NO son anagramas.");
			}
	    	// Se repite el programa hasta que el usuario elija salir introduciendo "S".
	    	salir = JOptionPane.showInputDialog("Introduce S para salir, cualquier otra cosa para introducir dos nuevas frases...").toUpperCase().equals("S"); 
	    } while (!salir);
	}
}
