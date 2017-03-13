/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Ferreteria {
  public static boolean inventarioVacio = true;
  /**
   * Función principal
   *
   * @param args
   * @throws IOException
   * @throws FileNotFoundException
   * @throws ClassNotFoundException
   */
  public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
    Teclado tec = new Teclado();
    MensajesUsuario mu = new MensajesUsuario();
    File inventario = new File("Inventario.txt");
    if(inventario.exists()){
      BufferedReader br = new BufferedReader(new FileReader("Inventario.txt"));     
      if (br.readLine() != null) {   
        inventarioVacio = false;
    }
    }else{
      inventario.createNewFile();
    }
   
    
    int op = 0;
    int opc = 0;
    
    do {
      mu.menu();      
      try { op = mu.leerOpcion(); } catch (NumberFormatException e) {}      
      switch (op) {         
        case 1: 
          if (!inventarioVacio) {
            do {
              mu.menuInventario();
              try { opc = mu.leerOpcion(); } catch (NumberFormatException e) { }
              mu.realizarOpcionMenuInventario(opc);
            } while (opc != 0);
          } else {
            System.out.println("No se puede consultar inventario si está vacío");
          }
          break;          
        case 2:          
          do {
            mu.menuCompra();
            try { opc = mu.leerOpcion(); } catch (NumberFormatException e) {}
            if((inventarioVacio && opc == 1) || !inventarioVacio){
            mu.realizarOpcionMenuCompra(opc);
            }else{
              System.out.println("No se pueden editar o eliminar productos si el inventario está vacío");
            }
          } while (opc != 0);
          break;
        case 3:
          if(!inventarioVacio){
          do {
            mu.menuVenta();
            try { opc = mu.leerOpcion(); } catch (NumberFormatException e) {}
           mu.realizarOpcionMenuVenta(opc);
          } while (opc != 0);
          }else{
            System.out.println("No se puede realizar compra si el inventario está vacío");
          }
          break;          
        default:
          System.out.println("Introduzca un número válido: entre el 0 y el 3");
          break;          
      }
    } while (opc != 0);

  }

}
