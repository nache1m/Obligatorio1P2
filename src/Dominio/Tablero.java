
package Dominio;
import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Tablero {
    private LocalDateTime horaInicio;
    private int fila;
    private int nivel;
    private int [][] matrizActual;
    private LocalDateTime horaFinal;
    
    public static void ejecutarMovimiento(char caracter) {};
    public static void pedirCoord(int fila, int col) {};
    public static void crearMovimiento(int [] [] mat) {};
    
    public Tablero (int fil, int col) {};
    public Tablero (int [][] mat) {};
    public Tablero () {};

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int[][] getMatrizActual() {
        return matrizActual;
    }

    public void setMatrizActual(int[][] matrizActual) {
        this.matrizActual = matrizActual;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }
     
}
