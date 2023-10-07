package Interfaz;

import Dominio.*;
import static Interfaz.Menu.*;
import java.util.Scanner;

public class Prueba {
    public static void main (String [] args) {
       Menu.imprimirMenu();
    }
    
    public static void realizarMovimiento(Tablero tablero, Sistema sistema){
        int cont = 0;
        int nivel = tablero.getNivel();
        imprimirTablero(tablero.getMatrizActual());
        System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
        while (cont < nivel) {
            Scanner lector = new Scanner(System.in);
            String fila = lector.nextLine();
            switch (fila){
                case "H":
                    // Mostrar historial.
                    break;
                case "S":
                    // Mostrar solucion.
                    break;
                case "X":
                    cont = 100;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    String col = lector.nextLine();
                    String mov = fila + "," + col;
                    String mat[][] = clonarMatriz(tablero.getMatrizActual());
                    Jugada j = new Jugada(mat);
                    sistema.agregarJugada(j);
                    tablero.ejectuarMovimiento(tablero.getMatrizActual(), mov);
                    mostrarMovimientoRealizado(mat, tablero.getMatrizActual());
                    j.setTablero(mat);
                    cont++;
                    System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
                    break;
            }
        }
        imprimirTablero(tablero.getMatrizActual());
    }
}