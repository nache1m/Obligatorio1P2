package Interfaz;

import Dominio.*;
import static Interfaz.Menu.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) throws FileNotFoundException {
        Menu.imprimirMenu();
    }

    public static void realizarMovimiento(Tablero tablero, Sistema sistema) throws FileNotFoundException {
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
                        sistema.pararTiempo();
                        System.out.println("");
                        Menu.imprimirTablero(tablero.getMatrizActual());
                        System.out.println("\n¡Felicitaciones, has ganado!");
                        //System.out.println("Su tiempo fue de: "+sistema.tiempoFinal());
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
    
    public static Tablero leerArchivo(Sistema sistema) throws FileNotFoundException {
    Scanner input = new Scanner(new File(".\\test\\datos.txt"));
    Tablero tablero = new Tablero();
    while (input.hasNext()) {
        int fil = input.nextInt();
        int col = input.nextInt();
        String mat[][] = new String[fil][col];
        input.nextLine();
        for (int i = 0; i < fil; i++) {
            String[] linea = input.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                if (linea.length > j) {
                    String aux = linea[j];
                    char simb = aux.charAt(0);
                    char color = aux.charAt(1);
                    if (color == 'R') {
                        String def = "\u001B[31m"+simb+"\u001B[0m";
                        mat[i][j] = def;
                    } else {
                        String def = "\u001B[34m"+simb+"\u001B[0m";
                        mat[i][j] = def;
                    }
                }
            }
        }
        String nivel = input.nextLine().trim();
        int nivelInt = Integer.parseInt(nivel);
        String sol[] = new String[nivelInt];
        for (int k = 0; k < nivelInt; k++) {
            String aux = input.nextLine().replace(" ", ",");
            sol[k] = aux;
        }
        tablero.setSolucion(sol);
        tablero.setMatrizActual(mat);
        sistema.setTablero(tablero);
    }
    input.close();
    return tablero;
}

}
