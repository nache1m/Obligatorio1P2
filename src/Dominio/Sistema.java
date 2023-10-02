package Dominio;

import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class Sistema {
    
    
    private Tablero tablero;
    private ArrayList<Jugadas> jugadas;
    private LocalDateTime horaInicio = LocalDateTime.now();
    private String [] listaMovimientos;
    private String [] posibleSolucion;
    private boolean sigueJugando;
    
    public static void crearTablero() {};
    public static void crearTablero(int col, int fil) {};
    public static void crearTablero(String file) {}; //método que construyetablero con un archivo 
    public Sistema() {};
    public static void mensajeFinal() {};
    public static void sigueJugando() {};
    public static void retroceder() {};
    public static void terminaJuego() {};

    
    public Tablero getTablero() {
        return tablero;
    }

    
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    
    public ArrayList<Jugadas> getJugadas() {
        return jugadas;
    }

    
    public void setJugadas(ArrayList<Jugadas> jugadas) {
        this.jugadas = jugadas;
    }

   
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    
    public String[] getListaMovimientos() {
        return listaMovimientos;
    }

    
    public void setListaMovimientos(String[] listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

   
    public String[] getPosibleSolucion() {
        return posibleSolucion;
    }

    
    public void setPosibleSolucion(String[] posibleSolucion) {
        this.posibleSolucion = posibleSolucion;
    }

    
    public boolean isSigueJugando() {
        return sigueJugando;
    }

    
    public void setSigueJugando(boolean sigueJugando) {
        this.sigueJugando = sigueJugando;
    }
}
