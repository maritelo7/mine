/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Ferreteria {

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
    Producto pro = new Producto();
    Inventario in = new Inventario();
    MensajesUsuario mu = new MensajesUsuario();
    SerializacionProducto sp = new SerializacionProducto();
    SerializacionVenta sv = new SerializacionVenta();
    Venta v = new Venta();
    Ventas ves = new Ventas();

    int op = 0;
    int opc = 0;
    do {
      mu.menu();
      try {
        opc = mu.leerOpcion();
      } catch (NumberFormatException e) {
      }
      switch (opc) {
        case 1:
          do {
            mu.menuCompra();
            try {
              op = mu.leerOpcion();
            } catch (NumberFormatException e) {
            }
            mu.realizarOpcion(op, tec, pro, in, sp, sv);
          } while (op != 0);
          break;
        case 2:
          do {
            mu.menuVenta();
            try {
              op = mu.leerOpcion();
            } catch (NumberFormatException e) {
            }
            mu.escogerVentaCompra(op, v, ves);
          } while (op != 0);
          break;
        default:
          break;
      }

    } while (opc != 0);

  }

}
