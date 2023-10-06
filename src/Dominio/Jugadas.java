/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

public class Jugadas {
    private int indice = 1;
    private String [][] tablero;
    
    //Gets y Sets
    public int getIndice() {
        return indice;
    }

    
    public void setIndice(int indice) {
        this.indice = indice;
    }

    
    public String [][] getTablero() {
        return tablero;
    }

    
    public void setTablero(String [][] tablero) {
        this.tablero = tablero;
    }
    
    public Jugadas (String [] [] tablero) {
    this.tablero = tablero;
    indice++;
    }
    
    public void ejectuarMovimiento(String[][] mat, String Movimiento) {
        boolean stop = false;
        String[] posiciones = Movimiento.split(",");
        int i = Integer.valueOf(posiciones[0]) - 1;
        int j = Integer.valueOf(posiciones[1]) -1 ;
        String objeto = mat[i][j];
        if ( i != 0 && j != 0) {
        //Guion
        if (objeto.equals("\u001B[31m-\u001B[0m") || objeto.equals("\u001B[34m-\u001B[0m")) {
            for (int k = 0; k < mat[0].length; k++) {
                
                mat[i][k] = Tablero.cambiarColor(mat[i][k]);
            }
        }

        if (objeto.equals("\u001B[31m/\u001B[0m") || objeto.equals("\u001B[34m/\u001B[0m")) {
            //Arriba a la derecha
            int fIndice = i;
            int cIndice = j;

            while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                fIndice -= 1;
                cIndice += 1;
            }

            //Abajo a la izquierda
            fIndice = i + 1;
            cIndice = j - 1;

            while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                fIndice += 1;
                cIndice -= 1;
            }

        }; //Barra

        if (objeto.equals("\u001B[31m\\\u001B[0m") || objeto.equals("\u001B[34m\\\u001B[0m")) {

            //Arriba a la izquierda
            int fIndice = i;
            int cIndice = j;

            while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                fIndice -= 1;
                cIndice -= 1;
            }

            //Abajo a la derecha
            fIndice = i + 1;
            cIndice = j + 1;

            while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                fIndice += 1;
                cIndice += 1;
            }
        }; //ContraBarra

        if (objeto.equals("\u001B[31m|\u001B[0m") || objeto.equals("\u001B[34m|\u001B[0m")) {

            for (int k = 0; k < mat.length; k++) {
                mat[k][j] = Tablero.cambiarColor(mat[k][j]);
            }
        }}; //Linea

    }
}
