package Dominio;

import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class Sistema {
    
    
    private Tablero tablero;
    private ArrayList<Jugada> listaJugadas;
    private LocalDateTime horaInicio = LocalDateTime.now();
    private String [] listaMovimientos= new String [100];
    private int nroMovimiento;
    private String [] posibleSolucion;
    private boolean sigueJugando;
    
    public static void crearTablero() {};
    public static void crearTablero(int col, int fil) {};
    public static void crearTablero(String file) {}; //método que construyetablero con un archivo 
    public static void mensajeFinal() {};
    public static void sigueJugando() {};
    public static void retroceder() {};
    public static void terminaJuego() {};
    
    public Sistema(){
        listaJugadas = new ArrayList();
    }
    public void ejecutarJugada(String movimiento) {
        this.tablero.ejectuarMovimiento(this.tablero.getMatrizActual(), movimiento);
        this.setListaMovimientos(movimiento);
    };
    public Tablero getTablero() {
        return tablero;
    }

    
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    
    public ArrayList<Jugada> getJugadas() {
        return listaJugadas;
    }
    public void agregarJugada(Jugada j){
        listaJugadas.add(j);
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

    
    public void setListaMovimientos(String movimientos) {
        this.listaMovimientos[this.nroMovimiento] = movimientos;
        this.nroMovimiento++;
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
    
    public void soluciónTablero() {
        String [] array = tablero.getSolucion();
        System.out.print("La solución es los movimientos: ");
        for (int i = 0; i<array.length; i++) {
        System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
