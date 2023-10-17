// Ignacio Parrado (303400) y Ezequiel Peña (224585).
package Dominio;
public class Jugada {
    private String[][] tablero;

    // Gets y Sets.
    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public Jugada(String[][] tablero) {
        this.tablero = tablero;
    }
}
