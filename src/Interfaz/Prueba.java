package Interfaz;

import Dominio.*;
import static Interfaz.Menu.*;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Menu.imprimirMenu();
    }

    public static void realizarMovimiento(Tablero tablero, Sistema sistema) {
        int cont = 0;
        int nivel = tablero.getNivel();
        boolean salir = false;
        imprimirTablero(tablero.getMatrizActual());
        System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
        while (!tablero.delMismoColor() && !salir) {
            Scanner lector = new Scanner(System.in);
            String fila = lector.nextLine();
            switch (fila) {
                case "H":
                    System.out.print("Historial de movimientos:");
                    sistema.soluciónTablero();
                    System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
                    break;
                case "S":
                    sistema.soluciónTablero();
                    System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
                    break;
                case "X":
                    System.out.println("\n¿Esta seguro que desea abandonar y perder el progreso actual? (S/N)");
                    String conf = lector.nextLine();
                    if (conf.equalsIgnoreCase("S")) {
                        salir = true;
                        System.out.println("\n¡Gracias por jugar!");
                        Menu.limpiarConsola();
                        break;
                    } else {
                        System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
                        break;
                    }
                case "-1":
                    String ret = lector.nextLine();
                    tablero.setMatrizActual(sistema.getJugadas().get(sistema.getJugadas().size() - 1).getTablero());
                    sistema.getJugadas().remove(sistema.getJugadas().size() - 1);
                    Menu.imprimirTablero(tablero.getMatrizActual());
                    System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
                    break;
                default:
                    String col = lector.nextLine();
                    String mov = fila + "," + col;
                    String mat[][] = clonarMatriz(tablero.getMatrizActual());
                    Jugada j = new Jugada(mat);
                    sistema.agregarJugada(j);
                    sistema.agregarMovimiento(mov);
                    tablero.ejectuarMovimiento(tablero.getMatrizActual(), mov);
                    mostrarMovimientoRealizado(mat, tablero.getMatrizActual());
                    j.setTablero(mat);
                    cont++;
                    if (tablero.delMismoColor()) {
                        System.out.println("");
                        Menu.imprimirTablero(tablero.getMatrizActual());
                        System.out.println("\n¡Felicitaciones, has ganado!");
                        // Agregar metodo de imprimir tiempo.
                    } else {
                        System.out.println("\nIngrese fila (ENTER) y luego la columna (ENTER):");
                    }
                    break;
            }
        }
        if (salir || tablero.delMismoColor()) {
            Menu.limpiarConsola();
            Menu.imprimirMenu();
        }
    }
}
