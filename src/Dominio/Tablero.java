
package Dominio;
import static Interfaz.Menu.imprimirTablero;
import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Tablero {
    private LocalDateTime horaInicio;
    private int fila;
    private int nivel;
    private String [][] matrizActual;
    private LocalDateTime horaFinal;
    
    private static String rojoG = "\u001B[31m-\u001B[0m";
    private static String azulG = "\u001B[34m-\u001B[0m";
    private static String rojoB = "\u001B[31m/\u001B[0m";
    private static String azulB = "\u001B[34m/\u001B[0m";
    private static String rojoCB = "\u001B[31m\\\u001B[0m";
    private static String azulCB = "\u001B[34m\\\u001B[0m";
    private static String rojoL = "\u001B[31m|\u001B[0m";
    private static String azulL = "\u001B[34m|\u001B[0m";
    
    public static void ejecutarMovimiento(char caracter) {};
    public static void pedirCoord(int fila, int col) {};
    public static void crearMovimiento(int [] [] mat) {};
    
    
    
    //Getters y Setters
    
    
    public static String getRojoG() {
        return rojoG;
    }

    public static String getAzulG() {
        return azulG;
    }

    public static String getRojoB() {
        return rojoB;
    }

    public static String getAzulB() {
        return azulB;
    }

    public static String getRojoCB() {
        return rojoCB;
    }

    public static String getAzulCB() {
        return azulCB;
    }

    public static String getRojoL() {
        return rojoL;
    }

    public static String getAzulL() {
        return azulL;
    }
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

    public String[][] getMatrizActual() {
        return matrizActual;
    }

    public void setMatrizActual(String [][] matrizActual) {
        this.matrizActual = matrizActual;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }
     
    //Métodos
    
    public Tablero (int fil, int col) {};
    public Tablero (int [][] mat) {};
    
    
    public Tablero () {
    
    matrizActual = new String[][] {
    {azulL,azulL,rojoG,azulB,rojoL,rojoG},
    {rojoG,azulB,azulB,azulL,rojoG,rojoG},
    {rojoG,rojoG,azulL,rojoG,rojoB,rojoG},
    {rojoCB,rojoG,rojoL,rojoCB,azulL,rojoL},
    {rojoCB,rojoB,rojoB,azulL,azulB,azulCB}
    }; 
    };
    
    
     public static String cambiarColor (String objeto) {
       String res = "";
       res = switch (objeto) {
            case "\u001B[31m-\u001B[0m" -> "\u001B[34m-\u001B[0m";
            case "\u001B[34m-\u001B[0m" -> "\u001B[31m-\u001B[0m";
            case "\u001B[31m/\u001B[0m" -> "\u001B[34m/\u001B[0m";
            case "\u001B[34m/\u001B[0m" -> "\u001B[31m/\u001B[0m";
            case "\u001B[34m\\\u001B[0m" -> "\u001B[31m\\\u001B[0m";
            case "\u001B[31m\\\u001B[0m" -> "\u001B[34m\\\u001B[0m";
            case "\u001B[34m|\u001B[0m" -> "\u001B[31m|\u001B[0m";
            case "\u001B[31m|\u001B[0m" -> "\u001B[34m|\u001B[0m";
            default -> "";
        };
       return res;
       
}
 
     public void ejectuarMovimiento (String [][] mat, String Movimiento) {
         boolean stop = false;
         String [] posiciones = Movimiento.split(",");
         int i = Integer.valueOf(posiciones[0]);
         int j = Integer.valueOf(posiciones[1]);
         String objeto = mat[i][j];
         
         //Guion
         if(objeto.equals("\u001B[31m-\u001B[0m") || objeto.equals("\u001B[34m-\u001B[0m")) {
             for(int k = 0; k < mat[0].length; k++) {
                 mat[i][k] = Tablero.cambiarColor(mat[i][k]);
             }
         }; 
         
         
         if(objeto.equals("\u001B[31m/\u001B[0m") || objeto.equals("\u001B[34m/\u001B[0m")) {
         //Arriba a la derecha
         int fIndice = i;
         int cIndice= j;
         
         while (fIndice >=0 && fIndice < mat.length && cIndice >= 0 && cIndice <mat[0].length && !stop) {
            mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);
            
            fIndice-=1;
            cIndice+=1;
         }
         
         
         //Abajo a la izquierda
        
         fIndice = i +1;
         cIndice= j -1;
         
         while (fIndice >=0 && fIndice < mat.length && cIndice >= 0 && cIndice <mat[0].length && !stop) {
            mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);
            
            fIndice+=1;
            cIndice-=1;
         }
         
         }; //Barra
         
         
         if(objeto.equals("\u001B[31m\\\u001B[0m") || objeto.equals("\u001B[34m\\\u001B[0m")) {
         
          //Arriba a la izquierda
         int fIndice = i;
         int cIndice= j;
         
         while (fIndice >=0 && fIndice < mat.length && cIndice >= 0 && cIndice <mat[0].length && !stop) {
            mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);
            
            fIndice-=1;
            cIndice-=1;
         }
         
         
         //Abajo a la derecha
         
         fIndice = i + 1;
         cIndice= j +1;
         
         while (fIndice >=0 && fIndice < mat.length && cIndice >= 0 && cIndice <mat[0].length && !stop) {
            mat[fIndice][cIndice] = Tablero.cambiarColor(mat[fIndice][cIndice]);
            
            fIndice+=1;
            cIndice+=1;
         }}; //ContraBarra
         
        
         
         if(objeto.equals("\u001B[31m|\u001B[0m") || objeto.equals("\u001B[34m|\u001B[0m")) {
         
          for(int k = 0; k < mat.length; k++) {
                 mat[k][j] = Tablero.cambiarColor(mat[k][j]);
             }}; //Linea
            
      
      
     
     }
     public static void modificarLinea(String movimiento) {
         
         //identifico que caracter está en el movimiento que me dicen
         //llamo al metodo que me dice que accion ejecutar
     
     
     }
}

  