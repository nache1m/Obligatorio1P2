package Interfaz;

import Dominio.*;
import static Interfaz.Menu.*;
import java.util.Scanner;

public class Prueba {
    public static void main (String [] args) {
       Menu.imprimirMenu();
    }
    
    public static void realizarMovimiento(){
        Scanner lector = new Scanner(System.in);
        Sistema sistema = new Sistema();
        Tablero tablero = new Tablero("5,6", 3);
        sistema.setTablero(tablero);
        imprimirTablero(tablero.getMatrizActual());
        int fila = lector.nextInt();
        int col = lector.nextInt();
        String mov = fila+","+col;
        String mat [][] = clonarMatriz(tablero.getMatrizActual());
        Tablero tablero1 = new Tablero (mat);
        tablero1.ejectuarMovimiento(mat, mov);
        mostrarMovimientoRealizado(tablero.getMatrizActual(), mat);
    }
}