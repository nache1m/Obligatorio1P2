package Interfaz;

import Dominio.Tablero;
import static Interfaz.Menu.*;

public class Prueba {
    public static void main (String [] args) {
       // Menu.imprimirMenu();
       Tablero tablero1 = new Tablero();
       Tablero tablero2 = new Tablero();
       mostrarMovimientoRealizado(tablero1.getMatrizActual(), tablero2.getMatrizActual()); 
        
    }
}
