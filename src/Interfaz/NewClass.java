
package Interfaz;

public class NewClass {
    public static void main (String args[]){
        int mat[][] = {{1,2,3,4},{5,2,5,6},{3,6,9,7},{5,8,2,7}};
        imprimirTablero(mat);
    }
    public static void imprimirTablero(int mat[][]){
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
}
