/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;


import java.io.*;
import java.util.logging.*;
/**
 *
 * @author Mari
 */
public class SerializacionVenta {  
String filename = "Ventas.txt";

public void SerializacionVenta() throws IOException{
}

  public void serializar(Ventas ves) {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
      os.writeObject(ves);
      os.flush(); 
      os.close();
    } catch (Exception e) {
      System.out.println(e);
      System.exit(1);
    }
  }

  public Ventas deserializar() {
    Ventas ves = new Ventas();
    FileInputStream fi;
    try {
      fi = new FileInputStream(filename);
      ObjectInputStream si = new ObjectInputStream(fi);
      ves = (Ventas) si.readObject();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(SerializacionProducto.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(SerializacionProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ves;
  }
  
}
