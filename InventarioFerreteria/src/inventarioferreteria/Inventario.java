/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Inventario implements Serializable  {
  public ArrayList<Producto> lista = new ArrayList<>();
  Producto prod;
  /**
   * Constructor de la clase inventario
   */
  public Inventario ()  {
  }
 /**
  * Método que elimina un producto dada su clave
  * @param clave 
  */
 public void eliminar(int clave) {
    for (int i = 0; i < lista.size(); i++) {
      prod = lista.get(i);
      if (prod.getClave() == clave) {
        lista.remove(i);
        System.out.println("El producto ha sido borrado");
      } else {
        System.out.println("El producto no puede ser borrado");
      }
    }
  }
/**
 * Método que permite cambiar un atributo de uno producto
 * @param car
 * @param tec
 * @param clave 
 */
  public void cambiarCaracteristica(int car, Teclado tec, int clave) {
      for (int i = 0; i < lista.size(); i++) {
        prod = lista.get(i);
        if (clave == prod.getClave()){     
      switch (car) {
        case 1:
          System.out.println("Escriba el nuevo nombre del producto");
          String nombre = tec.leerString();
          prod.setNombre(nombre);
          break;
        case 2:
          System.out.println("Añadir descripción");
          String des = tec.leerString();
          prod.setDescripcion(des);
          break;
        case 3:
          System.out.println("Ingrese cantidad de unidades");
          int cant = tec.leerEntero();
          prod.setExistencia(cant);
          break;
        case 4:
          System.out.println("Ingrese tipo unidad de medida: pza, docena, litros, metros, kilogramos");
          String unidadMedida = tec.leerString();
          prod.setUnidadMedida(unidadMedida);
          break;
        case 5:
          System.out.println("Ingrese precio de compra unitario");
          double precio = tec.leerDouble();
          prod.setPrecioCompra(precio);
          break;
      }
    }else{
          System.out.println("No existe un producto con esa clave");
        }
    }
  }

  public void ordenarPorClave() throws IOException, FileNotFoundException, ClassNotFoundException {
    int[] arr = bubbleClave();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < lista.size(); j++) {
        prod = lista.get(j);
        if (arr[i] == prod.getClave()){
        System.out.println(prod);
        }
      }
    }
  }
  
  public int[] bubbleClave() {
    boolean swapped = true;
    int j = 0;
    int tmp;
    int[] arr = new int[lista.size()];
    for (int i = 0; i < lista.size(); i++) {
      prod = lista.get(i);
      arr[i] = prod.getClave();
    }
    while (swapped) {
        swapped = false;
        j++;
        for (int i = 0; i < lista.size() - j; i++) {
            if (arr[i] > arr[i+1]) {
                tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                swapped = true;
            }
        }
    }
    return arr;
}
  
   public void ordenarPorNombre() throws IOException, FileNotFoundException, ClassNotFoundException {
   ArrayList<Producto> aux = lista;
   String[] arr = bubbleNombre();
    for(int i = 0; i < arr.length; i++) {
      for (int j = 0; j < lista.size(); j++) {
        prod = lista.get(j);
        if (arr[i].equals(prod.getNombre())){
        System.out.println(prod);
        }
      }
    }
  }
   
    public String[] bubbleNombre() {
    String[] arr = new String[lista.size()];
    for (int i = 0; i < lista.size(); i++) {
      prod = lista.get(i);
      arr[i] = prod.getNombre();
    }
    Arrays.sort(arr);
    return arr;
}
   
   public boolean buscarClave(int claveBuscada){
     boolean encontrado = false;
      for (int j = 0; j < lista.size(); j++) {
        prod = lista.get(j);
        if (claveBuscada == (prod.getClave())){
        System.out.println(prod);
        encontrado = true;
        }
      if (encontrado == false) {
        System.out.println("Producto no encontrado");
        }
      }
    return encontrado;      
   }
   
    public void buscarNombre(String nombreBuscado){
     boolean encontrado = false;
      for (int j = 0; j < lista.size(); j++) {
        prod = lista.get(j);
        if (nombreBuscado.equals(prod.getNombre())){
        System.out.println(prod);
        encontrado = true;
        }
        }
        if (encontrado == false){
          System.out.println("Producto no encontrado");
      }
   }
    
 public double mostrarValorInventario(){
   double suma = 0;
   for (int i = 0; i < lista.size(); i++) {
     prod = lista.get(i);
     suma = suma + (prod.getPrecioCompra() * prod.getExistencia());     
   }
   return suma;
 }   
   
    
  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
  }


}
