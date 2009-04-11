/*
 * Main.java
 *
 * Created on 8 de abril de 2009, 08:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tp_v1;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author rocio
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {
        // TODO code application logic here
       Controlador controler;
       controler =new Controlador();
       System.out.println("Ingrese el test que desea:");
       System.out.println("1 para Validar que no haya mas de 15 jugadores");
       System.out.println("2 para Validar que no haya mas de 2 jugadores por posicion");
       char caracter = (char) System.in.read(); 
       int num=1;
      
       switch (caracter){
           case '1':controler.checkCantJugadoresPorEquipo();
           break;
           case '2':controler.validarPosicion();
           break;
           default: System.out.println("Eligio NADA!!!");
        }     
    }
    
}
