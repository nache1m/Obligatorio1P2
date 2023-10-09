package Interfaz;
import Dominio.Sistema;
import Dominio.Tablero;
import java.util.*;

public class Menu {
    
    public static void imprimirMenu(){
        Scanner lector = new Scanner(System.in);
        boolean salir = true;
        int opcion;
        String titulo = "¡Bienvenido a Soliflips!";
        int longitud = titulo.length();
        System.out.println("+" + "-".repeat(longitud + 2) + "+");
        System.out.println("| " + centrarTexto(titulo, longitud) + " |");
        System.out.println("+" + "-".repeat(longitud + 2) + "+");
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
                System.out.println("Escribe una de las opciones:");
                opcion = lector.nextInt();
                Sistema sistema = new Sistema();
                switch (opcion) {
                    case 1:
                        // Llamada del metodo.
                        break;
                    case 2:
                        Tablero tablero = new Tablero();
                        sistema.setTablero(tablero);
                        tablero.setNivel(3);
                        System.out.println("¡Que empiece el juego!");
                        Prueba.realizarMovimiento(tablero, sistema);
                        salir = true;
                        break;
                    case 3:
                        System.out.println("Ingrese tamaño de fila:");
                        String fila = lector.nextLine();
                        System.out.println("Ingrese tamaño de columna:");
                        String col = lector.nextLine();
                        System.out.println("Ingrese nivel");
                        int nivel = lector.nextInt();
                        String filCol = fila+","+col;
                        Tablero tableroAzar = new Tablero(filCol,nivel);
                        System.out.println("¡Que empiece el juego!");
                        Prueba.realizarMovimiento(tableroAzar, sistema);
                        salir = true;
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debe ingresar un número entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número.");
                lector.next();
                }
            }
        }
    }
    
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
    
    public static void mostrarMovimientoRealizado(String mat1[][], String mat2[][]){
        System.out.print("    ");
        for (int j = 0; j < mat1[0].length;j++){
            System.out.print((j+1)+"   ");
        }
        System.out.print("        ");
        for (int j = 0; j < mat2[0].length;j++){
            System.out.print((j+1)+"   ");
        }
        System.out.println("");
        System.out.print("  +");
        for (int j = 0; j < mat1[0].length;j++){
            System.out.print("---+");
        }
        System.out.print(" ==>");
        System.out.print("   +");
        for (int j = 0; j < mat2[0].length;j++){
            System.out.print("---+");
        }
        System.out.println("");
        // Recorro matrices.
        for (int i=0; i<mat1.length;i++){
            System.out.print((i+1) + " | ");
            for (int j=0; j<mat1[0].length;j++){
                System.out.print(mat1[i][j]+" | ");
            }
            System.out.print("==> ");
            System.out.print((i+1) + " | ");
            for (int j=0; j<mat2[0].length;j++){
                System.out.print(mat2[i][j]+" | ");
            }
            System.out.println("");
            System.out.print("  +");
            for (int k = 0; k < mat1[0].length;k++){
                System.out.print("---+");
            }
            System.out.print(" ==>");
            System.out.print("   +");
            for (int k = 0; k < mat2[0].length;k++){
                System.out.print("---+");
            }
            System.out.println("");
        }
    }
    public static String[][] clonarMatriz(String mat[][]){
        String clonada[][] = mat.clone();
        for (int i=0; i < mat.length;i++){
            clonada[i] = mat[i].clone();
        }
        return clonada;
    }
    public static String centrarTexto(String texto, int longitud) {
        int espacios = (longitud - texto.length()) / 2;
        return " ".repeat(espacios) + texto + " ".repeat(espacios + (longitud - texto.length()) % 2);
    }
    public static void limpiarConsola(){
        for (int i=0; i<10;i++) {
            System.out.println("");
        }
    }
}