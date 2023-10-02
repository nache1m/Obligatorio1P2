
package Interfaz;

import Dominio.Tablero;
import java.util.*;

public class Menu {
    public static void imprimirTablero(String mat[][]){
        // Indices de columnas
        System.out.print("    ");
        for (int j = 0; j < mat[0].length;j++){
            System.out.print((j+1)+"   ");
        }
        System.out.println("");
        
        System.out.print("  +");
        for (int j = 0; j < mat[0].length;j++){
            System.out.print("---+");
        }
        System.out.println("");
        
        for (int i = 0; i < mat.length;i++){
            System.out.print((i+1) + " | ");
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " | ");
            }
            System.out.println("");
            System.out.print("  +");
            for (int k = 0; k < mat[0].length;k++){
                System.out.print("---+");
            }
            System.out.println("");
        }
    }
    
    public static void imprimirMenu(){
        Scanner lector = new Scanner(System.in);
        boolean salir = true;
        int opcion;
        System.out.println("¿Se desea comenzar una nueva partida? (S/N)");
        String deseaJugar = lector.nextLine();
        if (deseaJugar.equalsIgnoreCase("N")){
            System.out.println("¡Nos vemos pronto!");
        } else {
            salir = false;
            while(!salir){
                System.out.println("1. Tomar datos desde un archivo.");
                System.out.println("2. Usar tablero predefinido.");
                System.out.println("3. Usar tablero al azar.");
                System.out.println("4. Salir del menú.");
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = lector.nextInt();
 
                switch (opcion) {
                    case 1:
                        // Llamada del metodo.
                        break;
                    case 2:
                        Tablero tablero = new Tablero();
                        imprimirTablero(tablero.getMatrizActual());
                        tablero.ejectuarMovimiento(tablero.getMatrizActual(), "3,3");
                        imprimirTablero(tablero.getMatrizActual());
                        break;
                    case 3:
                        // Llamada del metodo.
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debe ingresar un número entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                lector.next();
                }
            }
        }
    }
}