package app;
/*
 * Main.java
 *
 * Created on 8 de abril de 2009, 08:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.IOException;


public class Main {
    
   public static void main(String[] args) throws IOException {
        // TODO code application logic here
       Controlador controller = new Controlador();
       System.out.println("Ingrese el test que desea:");
       System.out.println("1 para Validar que no haya mas de 15 jugadores");
       System.out.println("2 para Validar que no haya mas de 2 jugadores por posicion");
       char caracter = (char) System.in.read(); 
       int num=1;
      
       switch (caracter){
           case '1':
           break;
           case '2':
           break;
           default: System.out.println("Eligio NADA!!!");
        }     
    }
    
}
