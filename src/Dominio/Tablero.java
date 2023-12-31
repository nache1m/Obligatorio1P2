// Ignacio Parrado (303400) y Ezequiel Peña (224585).
package Dominio;

import static Interfaz.Menu.imprimirTablero;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tablero {
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;
    private int nivel;
    private String[][] matrizActual;
    private String[] solucion;
    private String rojoG = "\u001B[31m-\u001B[0m";
    private String azulG = "\u001B[34m-\u001B[0m";
    private String rojoB = "\u001B[31m/\u001B[0m";
    private String azulB = "\u001B[34m/\u001B[0m";
    private String rojoCB = "\u001B[31m\\\u001B[0m";
    private String azulCB = "\u001B[34m\\\u001B[0m";
    private String rojoL = "\u001B[31m|\u001B[0m";
    private String azulL = "\u001B[34m|\u001B[0m";

    // Gets y Sets.
    public String getRojoG() {
        return this.rojoG;
    }

    public String getAzulG() {
        return azulG;
    }

    public String getRojoB() {
        return rojoB;
    }

    public String getAzulB() {
        return azulB;
    }

    public String getRojoCB() {
        return rojoCB;
    }

    public String getAzulCB() {
        return azulCB;
    }

    public String getRojoL() {
        return rojoL;
    }

    public String getAzulL() {
        return azulL;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String[][] getMatrizActual() {
        return matrizActual;
    }

    public void setMatrizActual(String[][] matrizActual) {
        this.matrizActual = matrizActual;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String[] getSolucion() {

        return solucion;
    }

    public void setSolucion(String[] solucion) {
        this.solucion = solucion;
    }

    // Constructores.
    public Tablero() {
        matrizActual = new String[][]{
            {azulL, azulL, rojoG, azulB, rojoL, rojoG},
            {rojoG, azulB, azulB, azulL, rojoG, rojoG},
            {rojoG, rojoG, azulL, rojoG, rojoB, rojoG},
            {rojoCB, rojoG, rojoL, rojoCB, azulL, rojoL},
            {rojoCB, rojoB, rojoB, azulL, azulB, azulCB}
        };
        String sol[] = {"4,4", "5,6", "5,4"};
        this.solucion = sol;
    }

    public Tablero(String filCol, int nivel) {
        // Creo arrays con caracteres, rojo y azul y filas y columnas. 
        String[] rojo = {this.getRojoB(), this.getRojoCB(), this.getRojoG(), this.getRojoL()};
        String[] azul = {this.getAzulB(), this.getAzulCB(), this.getAzulG(), this.getAzulL()};
        String[] array = filCol.split(",");
        int fil = Integer.valueOf(array[0]);
        int col = Integer.valueOf(array[1]);

        // Elijo si la solución final va a ser roja o azul.
        if (Integer.valueOf(array[0]) % 2 == 0) {
            array = rojo;
        } else {
            array = azul;
        }
        Random random = new Random();
        // Creo matriz al azar.
        String[][] mat = new String[fil][col];

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {
                int randomNumber = random.nextInt(4);
                mat[i][j] = array[randomNumber];
            }
        }

        // Modifico matriz tantas veces cómo diga el nivel y la seteo a mi atributo. 
        // Crea array con las soluciones para el ejercicio.
        String[] solucion = new String[nivel];
        for (int i = 0; i < nivel; i++) {
            String movimiento = "";
            int j = random.nextInt(fil);
            if (j == 0) {
                j++;
            }
            movimiento = j + ",";
            int k = random.nextInt(col);
            if (k == 0) {
                k++;
            }

            movimiento += k;
            solucion[i] = movimiento;
            this.ejectuarMovimiento(mat, movimiento);

        }
        this.nivel = nivel;
        this.solucion = solucion;
        this.setMatrizActual(mat);
    }

    // Métodos.
    public static String cambiarColor(String objeto) {
        String res = "";
        res = switch (objeto) {
            case "\u001B[31m-\u001B[0m" ->
                "\u001B[34m-\u001B[0m";
            case "\u001B[34m-\u001B[0m" ->
                "\u001B[31m-\u001B[0m";
            case "\u001B[31m/\u001B[0m" ->
                "\u001B[34m/\u001B[0m";
            case "\u001B[34m/\u001B[0m" ->
                "\u001B[31m/\u001B[0m";
            case "\u001B[34m\\\u001B[0m" ->
                "\u001B[31m\\\u001B[0m";
            case "\u001B[31m\\\u001B[0m" ->
                "\u001B[34m\\\u001B[0m";
            case "\u001B[34m|\u001B[0m" ->
                "\u001B[31m|\u001B[0m";
            case "\u001B[31m|\u001B[0m" ->
                "\u001B[34m|\u001B[0m";
            default ->
                "";
        };
        return res;
    }

    public void ejectuarMovimiento(String[][] mat, String Movimiento) {
        boolean stop = false;
        String[] posiciones = Movimiento.split(",");
        int i = Integer.valueOf(posiciones[0]) - 1;
        int j = Integer.valueOf(posiciones[1]) - 1;

        String objeto = mat[i][j];
        if (i > -2 && j > -2) {
            // Guion.
            if (objeto.equals("\u001B[31m-\u001B[0m") || objeto.equals("\u001B[34m-\u001B[0m")) {
                for (int k = 0; k < mat[0].length; k++) {
                    mat[i][k] = Tablero.cambiarColor(mat[i][k]);
                }
            }

            if (objeto.equals("\u001B[31m/\u001B[0m") || objeto.equals("\u001B[34m/\u001B[0m")) {
                // Arriba a la derecha.
                int fIndice = i;
                int cIndice = j;

                while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                    mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                    fIndice -= 1;
                    cIndice += 1;
                }

                // Abajo a la izquierda.
                fIndice = i + 1;
                cIndice = j - 1;

                while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                    mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                    fIndice += 1;
                    cIndice -= 1;
                }

            }; // Barra.

            if (objeto.equals("\u001B[31m\\\u001B[0m") || objeto.equals("\u001B[34m\\\u001B[0m")) {

                // Arriba a la izquierda.
                int fIndice = i;
                int cIndice = j;

                while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                    mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                    fIndice -= 1;
                    cIndice -= 1;
                }

                // Abajo a la derecha.
                fIndice = i + 1;
                cIndice = j + 1;

                while (fIndice >= 0 && fIndice < mat.length && cIndice >= 0 && cIndice < mat[0].length && !stop) {
                    mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);

                    fIndice += 1;
                    cIndice += 1;
                }
            }; // ContraBarra.

            if (objeto.equals("\u001B[31m|\u001B[0m") || objeto.equals("\u001B[34m|\u001B[0m")) {

                for (int k = 0; k < mat.length; k++) {
                    mat[k][j] = Tablero.cambiarColor(mat[k][j]);
                }
            }
        }; // Linea.

    }

    public boolean delMismoColor() {
        boolean ret = true;
        String[] rojo = {this.getRojoB(), this.getRojoCB(), this.getRojoG(), this.getRojoL()};
        String[] azul = {this.getAzulB(), this.getAzulCB(), this.getAzulG(), this.getAzulL()};

        String color = this.matrizActual[0][0];
        String[] array = null;
        // Me fijo de que color es la matriz.
        for (int i = 0; i < rojo.length; i++) {
            if (color.equals(rojo[i])) {
                array = rojo;
            }
        }

        for (int i = 0; i < azul.length; i++) {
            if (color.equals(azul[i])) {
                array = azul;
            }
        }
        // Corroboro que toda la matriz sea del mismo color.

        for (int i = 0; i < this.matrizActual.length && ret; i++) {
            for (int j = 0; j < this.matrizActual[0].length && ret; j++) {
                boolean esta = false;
                for (int k = 0; k < array.length; k++) {
                    if (this.matrizActual[i][j].equals(array[k])) {
                        esta = true;
                    }
                }
                if (!esta) {
                    ret = false;
                }
            }
        }
        return ret;
    }

}
