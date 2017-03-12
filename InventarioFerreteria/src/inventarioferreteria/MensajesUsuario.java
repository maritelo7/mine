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
public class MensajesUsuario {

  /**
   * Imprime las opciones en pantalla
   */
  public void menu() {
    System.out.println("SISTEMA COMPRA-VENTA DE LA FERRETERÍA");
    System.out.println("Escoga una opción:");
    System.out.println("1. Registro de compra y consulta de productos");
    System.out.println("2. Registro venta");
    System.out.println("0. SALIR");
  }

  public void menuCompra() {
    System.out.println("1. Agregrar producto a inventario");
    System.out.println("2. Eliminar producto de inventario");
    System.out.println("3. Modificar características de un producto");
    System.out.println("4. Mostrar inventario por orden alfabetico");
    System.out.println("5. Mostrar inventario por clave");
    System.out.println("6. Buscar producto de inventario por nombre");
    System.out.println("7. Buscar producto de inventario por clave");
    System.out.println("8. Mostrar valor total del inventario");
    System.out.println("0. REGRESAR");
  }

  public void menuVenta() {
    System.out.println("1. Realizar venta");
    System.out.println("2. Mostrar ventas");
    System.out.println("0. REGRESAR");
  }

  /**
   * Para leer enteros de la entrada estándar
   *
   * @return
   */
  public int leerOpcion() {
    Teclado tec = new Teclado();
    System.out.println("¿Cuál es tu opción?");
    return tec.leerEntero();
  }

  public void escogerVentaCompra(int op, Venta v, Ventas ves) throws IOException {
    switch (op) {
      case 1:
        v.realizarVenta();
        break;
      case 2:
        ves.mostrarVentas();
        break;
      case 3:
        ves.buscarVentaPorFecha();
      default:
        break;

    }
  }

  public void realizarOpcion(int op, Teclado tec, Producto pro, Inventario in, SerializacionProducto sp, SerializacionVenta sv) throws IOException, FileNotFoundException, ClassNotFoundException {
    if (!sp.comprobarExistenciaFichero()) {
      in = sp.deserializar();      
    }
    switch (op) {
      case 1:
        try {
          System.out.println("Escriba el nombre del producto");
          String nombre = tec.leerString();
          System.out.println("Ingrese cantidad de unidades");
          int cant = tec.leerEntero();
          System.out.println("Ingrese precio de compra unitario");
          double precio = tec.leerDouble();
          System.out.println("Ingrese tipo unidad de medida: pza, docena, litros, metros, kilogramos");
          String unidadMedida = tec.leerString();
          System.out.println("Añadir descripción");
          String des = tec.leerString();
          pro = new Producto(nombre, des, cant, precio, unidadMedida); 
          in.lista.add(pro);
          sp.serializar(in);
        } catch (Exception e) {
        }
        break;
      case 2:
        System.out.println("Escriba la clave del producto a eliminar");
        in.eliminar(tec.leerEntero());
        break;
      case 3:
        System.out.println("Escriba la clave del producto a editar");
        int clave = tec.leerEntero();
        caracteristicas();
        int caracteristica = tec.leerEntero();
        in.cambiarCaracteristica(caracteristica, tec, clave);
        break;
      case 4:
        in.ordenarPorNombre();
        break;
      case 5:
        in.ordenarPorClave();
        break;
      case 6:
        System.out.println("Ingrese el nombre del producto que desea buscar ");
        in.buscarNombre(tec.leerString());
        break;
      case 7:
        System.out.println("Ingrese la clave del producto que desea buscar ");
        in.buscarClave(tec.leerEntero());
        break;
      case 8:
        System.out.println("El valor total del inventario es: " + in.mostrarValorInventario());
        break;
      case 0:
        sp.serializar(in);
        System.out.println("Saliendo del programa");
        break;
      default:
        break;
    }
  }

  public void caracteristicas() {
    System.out.println("Escriba el número de la característica que quiere editar:");
    System.out.println("1. Nombre");
    System.out.println("2. Descripción");
    System.out.println("3. Cantidad de productos en existencia");
    System.out.println("4. Unidad de medida");
    System.out.println("5. Precio de compra");
  }

}
