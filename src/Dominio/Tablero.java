
package Dominio;
import static Interfaz.Menu.imprimirTablero;
import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
import java.util.Random;

public class Tablero {
    private LocalDateTime horaInicio;
    private int fila;
    private int nivel;
    private String [][] matrizActual;
    private LocalDateTime horaFinal;
    private String [] solucion;
    private  String rojoG = "\u001B[31m-\u001B[0m";
    private  String azulG = "\u001B[34m-\u001B[0m";
    private String rojoB = "\u001B[31m/\u001B[0m";
    private  String azulB = "\u001B[34m/\u001B[0m";
    private  String rojoCB = "\u001B[31m\\\u001B[0m";
    private  String azulCB = "\u001B[34m\\\u001B[0m";
    private  String rojoL = "\u001B[31m|\u001B[0m";
    private  String azulL = "\u001B[34m|\u001B[0m";
    
    public static void pedirCoord(int fila, int col) {};
    public static void crearMovimiento(int [] [] mat) {};
    
    
    
    //Getters y Setters
    
    
    public String getRojoG() {
        return this.rojoG;
    }

    public  String getAzulG() {
        return azulG;
    }

    public  String getRojoB() {
        return rojoB;
    }

    public  String getAzulB() {
        return azulB;
    }

    public  String getRojoCB() {
        return rojoCB;
    }

    public  String getAzulCB() {
        return azulCB;
    }

    public  String getRojoL() {
        return rojoL;
    }

    public  String getAzulL() {
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
    
   public Tablero (String filCol, int nivel) {
   //Creo arrays con caracteres, rojo y azul y filas y columnas. 
   String[] rojo = { this.getRojoB(), this.getRojoCB(), this.getRojoG(), this.getRojoL()};
   String [] azul = {this.getAzulB(), this.getAzulCB(), this.getAzulG(), this.getAzulL()};
   String [] array = filCol.split(",");
   int fil = Integer.valueOf(array[0]);
   int col = Integer.valueOf(array[1]);
   
   //Elijo si la solución final va a ser roja o azul
   if (Integer.valueOf(array[0]) % 2 == 0) {
       array = rojo;
   } else {
       array = azul;
   }
    
   //Creo matriz al azar
   String [][] mat = new String [fil][col];
   
   for (int i =0; i<mat.length; i++) {
       for (int j =0; j<mat[i].length; j++) {
            Random random = new Random();
            int randomNumber = random.nextInt(4);
            mat[i][j] = array[randomNumber];
       }
   }
   
   //Modifico matriz tantas veces cómo diga el nivel y la seteo a mi atributo. 
   //Crea array con las soluciones para el ejercicio.
   solucion = new String [nivel];
   for(int i =0; i<nivel; i++) {
       String movimiento = "";
       Random random = new Random();
       int j = random.nextInt(mat.length);
       movimiento+= j + ",";
       int k = random.nextInt(mat[0].length);
       movimiento+=k;
       solucion[i] = movimiento;
       this.ejectuarMovimiento(mat, movimiento);
   }
   
  this.setMatrizActual(mat);
   
    };
    
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

    public String[] getSolucion() {
        
        return solucion;
    }

    public void setSolucion(String[] solucion) {
        this.solucion = solucion;
    }
  
}

  