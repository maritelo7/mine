/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Teclado implements Serializable {
    private final Scanner sc;
     /**
     * Inicializa la clase Scanner con la entrada estándar que es la lectura desde el teclado
     */
    public Teclado(){
        sc = new Scanner(System.in);
    }
    /**
     * Este método lee un entero
     * @return Regresa un valor de tipo entero 
     */
    public int leerEntero(){
       return sc.nextInt();
    }
    /**
     * Este método lee un doble
     * @return Regresa un valor de tipo double
     */
    public double leerDouble(){
        return sc.nextDouble();
    }
    
    public String leerString(){
        return sc.nextLine();
    }
    
}
