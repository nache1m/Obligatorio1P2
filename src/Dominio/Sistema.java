package Dominio;

import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class Sistema {
    
    
    private Tablero tablero;
    private ArrayList<Jugada> listaJugadas;
    private LocalDateTime horaInicio = LocalDateTime.now();
    private String [] listaMovimientos = new String [1000];
    private int nroJugada = 0;
    private int nroMovimiento = 0;
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
        String [] solucionTablero = this.tablero.getSolucion();
        String [] movimientosTablero = this.listaMovimientos;
        int pasosCorrectos = 0;
        boolean noSigue = false;
        
        //Creo el indice que me indica la cantidad de pasos acertados que debo volver;
        for (int i =0; i<solucionTablero.length && !noSigue; i++){
            if(movimientosTablero[i] == null) {
                noSigue=true;
            }
            else if (movimientosTablero[i].equals(solucionTablero[i])) {
              pasosCorrectos++;
                    } else {
                        noSigue=true;
                        }
            }
        
        //Corroboro si tengo que volver algún paso o no
        
        if (pasosCorrectos == this.nroMovimiento) {
            System.out.println("Para solucion este nivel solo resta ingresar los pasos: ");
            for (int i = pasosCorrectos; i<solucionTablero.length; i++) {
                System.out.print(solucionTablero[i]+" ");
            }
          }   
        else{
            System.out.println("");
             System.out.println("Para solucionar este nivel debes volver sobre tus pasos con: ");      
             for (int i = movimientosTablero.length - 1; i >= pasosCorrectos; i--) {
                 if(movimientosTablero[i] != null) {
               System.out.print(movimientosTablero[i]+ " ");
            }
                 
             }
             
              System.out.println("");
             System.out.println("Luego ingresar los pasos: ");
              for (int i = pasosCorrectos; i<solucionTablero.length; i++) {
                     
               System.out.print(solucionTablero[i]+" ");
                
            }
                    }
    }
    
      public void agregarMovimiento(String move) {
          listaMovimientos[nroMovimiento] = move;
          this.nroMovimiento++;
          
    }

    ;
    
}
