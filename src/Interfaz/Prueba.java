package Interfaz;

import Dominio.*;
import static Interfaz.Menu.*;
import java.util.Scanner;

public class Prueba {
    public static void main (String [] args) {
       Menu.imprimirMenu();
    }
    
    public static void realizarMovimiento(Tablero tablero){
        int cont = 0;
        int nivel = tablero.getNivel();
        imprimirTablero(tablero.getMatrizActual());
        System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
        System.out.println(tablero.delMismoColor());
        while (!tablero.delMismoColor()) {
            System.out.println("prueba");
            Scanner lector = new Scanner(System.in);
            String fila = lector.nextLine();
            String col = lector.nextLine();
            String mov = fila + "," + col;
            String mat[][] = clonarMatriz(tablero.getMatrizActual());
            Jugadas j = new Jugadas(mat);
            tablero.ejectuarMovimiento(tablero.getMatrizActual(), mov);
            mostrarMovimientoRealizado(mat,tablero.getMatrizActual());
            cont++;
        }
        imprimirTablero(tablero.getMatrizActual());
    }
}