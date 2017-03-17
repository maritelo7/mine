/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mari
 */
public class Ventas implements Serializable { 
  ArrayList<Venta> listaVentas = new ArrayList<>();
  Venta v;
  
  public Ventas(){    
  }
  
  public void mostrarVentas() throws IOException {
    v = new Venta();
    for (int i = 0; i < listaVentas.size(); i++) {
      v = listaVentas.get(i);
      v.toStringVoid();
    }
  }    
  
  public ArrayList getList(){
  return listaVentas;
  }
 
  public void buscarVentaPorFecha() {
    Teclado t = new Teclado();
    System.out.println("Ingrese la fecha de la que dese recuperar las ventas con el formato aaaa-mm-dd");
    String nuevaFecha = t.leerString();
    v = new Venta();
    for (int i = 0; i < listaVentas.size(); i++) {
      v = listaVentas.get(i);
      if (v.getFecha().contentEquals(nuevaFecha)) {
        v.toStringVoid();
      }
    }
  }
    
  
   private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
  }
  
}
