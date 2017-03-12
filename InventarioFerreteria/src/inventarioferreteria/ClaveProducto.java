/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Mari
 */
public final class ClaveProducto {

  public static int contador=0;
    public static String cont;
    static File c = new File("Clave.txt");
    static BufferedReader in = null;
    
    public ClaveProducto() throws IOException{
      createFile();
    }
    
    public static void createFile() throws IOException{    
        if(!c.exists()){
        c.createNewFile();
        PrintWriter pw = new PrintWriter(new FileWriter(c));
        //cont = contador + "";
        pw.println(contador);
        pw.close();}
    }
    
    public static String getC() throws IOException {  
        Scanner s = new Scanner(c);
        cont = s.nextLine();
        s.close();        
        return cont;
    }
    
    public static void addCont(String cont) throws IOException{
        try{
        cont = getC();        
        contador = Integer.parseInt(cont);
        contador++;    
        cont=contador+"";
        FileWriter fw = new FileWriter(c);        
        fw.append(cont);
        fw.close();
        }catch(NumberFormatException e){}
    
}

}
