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

public void SerializacionVenta(){
}

  public void serializar(Ventas ves) {
    try {
      FileOutputStream fo = new FileOutputStream(filename);
      ObjectOutputStream so = new ObjectOutputStream(fo);
      so.writeObject(ves);
      so.flush();
    } catch (Exception e) {
      System.out.println(e);
      System.exit(1);
    }
  }

  public Ventas deserializar() {
    //ArrayList<Producto> list = new ArrayList();
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
