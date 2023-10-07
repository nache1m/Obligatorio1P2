package Dominio;

import static Interfaz.Menu.clonarMatriz;
import static Interfaz.Menu.imprimirTablero;
import static Interfaz.Menu.mostrarMovimientoRealizado;
import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class Sistema {
    
    
    private static Tablero tablero;
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
    
    public static void soluciónTablero() {
        String [] array = tablero.getSolucion();
        System.out.print("La solución es los movimientos: ");
        for (int i = 0; i<array.length; i++) {
        System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    
      public static void realizarMovimiento(Tablero tablero, Sistema sistema){
        boolean salir = false;
        int nivel = tablero.getNivel();
        imprimirTablero(tablero.getMatrizActual());
        System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
        while (!salir) {
            Scanner lector = new Scanner(System.in);
            String fila = lector.nextLine();
            switch (fila){
                case "H":
                    // Mostrar historial.
                    break;
                case "S":
                    Sistema.soluciónTablero();
                    String col1 = lector.nextLine();
                    String mov1 = fila + "," + col1;
                    String mat1[][] = clonarMatriz(tablero.getMatrizActual());
                    Jugada j1 = new Jugada(mat1);
                    sistema.agregarJugada(j1);
                    tablero.ejectuarMovimiento(tablero.getMatrizActual(), mov1);
                    mostrarMovimientoRealizado(mat1, tablero.getMatrizActual());
                    j1.setTablero(mat1);
                    if (tablero.delMismoColor()) {
                    salir = true;}
                    System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
                    break;
                case "X":
                    salir = true;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    String col = lector.nextLine();
                    String mov = fila + "," + col;
                    String mat[][] = clonarMatriz(tablero.getMatrizActual());
                    Jugada j = new Jugada(mat);
                    sistema.agregarJugada(j);
                    tablero.ejectuarMovimiento(tablero.getMatrizActual(), mov);
                    mostrarMovimientoRealizado(mat, tablero.getMatrizActual());
                    j.setTablero(mat);
                    if (tablero.delMismoColor()) {
                    salir = true;}
                    System.out.println("Ingrese fila (ENTER) y luego la columna (ENTER):");
                    break;
            }
        }
        imprimirTablero(tablero.getMatrizActual());
    }
      
       public void sigoJugando () {
       
       };
}
