/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class SerializacionProducto {  
public String filename = "Inventario.txt";

public SerializacionProducto() throws IOException{  
}

public void SerializacionProducto(){
}

//public boolean comprobarExistenciaFichero() throws IOException{}

  public void serializar(Inventario in) {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
      os.writeObject(in);
      os.flush(); 
      os.close();      
    } catch (Exception e) {
      System.out.println(e);
      System.exit(1);
    }
  }

  public Inventario deserializar() {
    Inventario in = new Inventario();
    FileInputStream fi;
    try {
      fi = new FileInputStream(filename);
      ObjectInputStream si = new ObjectInputStream(fi);
      in = (Inventario) si.readObject();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(SerializacionProducto.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(SerializacionProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
    return in;
  }
  
  

}
