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
    
    public Jugadas (Tablero tablero) {
    this.tablero = tablero.getMatrizActual();
    indice++;
            
    
    }
}
