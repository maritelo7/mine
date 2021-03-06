/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import static inventarioferreteria.Ferreteria.inventarioVacio;
import static inventarioferreteria.Ferreteria.ventasVacias;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class MensajesUsuario {
    Teclado tec;
    Producto pro;
    Inventario in = new Inventario();
    SerializacionProducto sp;
    SerializacionVenta sv;
    Venta v;
    Ventas ves;

  
  /**
   * Imprime las opciones en pantalla
   */
  public void menu(){
    System.out.println("SISTEMA COMPRA-VENTA DE LA FERRETERÍA");
    System.out.println("Escoga una opción:");
    System.out.println("1. Consulta de inventario");
    System.out.println("2. Control de productos");
    System.out.println("3. Control de ventas");
    System.out.println("0. SALIR");
  }
  
  public void menuInventario(){
    System.out.println("1. Mostrar inventario por orden alfabetico");
    System.out.println("2. Mostrar inventario por clave");
    System.out.println("3. Buscar producto por nombre");
    System.out.println("4. Buscar producto por clave");
    System.out.println("5. Buscar producto por descripción");
    System.out.println("6. Mostrar valor total del inventario");
    System.out.println("0. REGRESAR");
  }
  
  public void menuCompra() {
    System.out.println("1. Agregrar producto a inventario");
    System.out.println("2. Eliminar producto de inventario");
    System.out.println("3. Modificar características de un producto");
    System.out.println("0. REGRESAR");
  }

  public void menuVenta(){
    System.out.println("1. Realizar venta");
    System.out.println("2. Mostrar todas las ventas");
    System.out.println("3. Consultar ventas por fecha");
    System.out.println("0. REGRESAR");
  }

   public void realizarOpcionMenuInventario(int op) throws IOException, FileNotFoundException, ClassNotFoundException {
      tec = new Teclado();
      sp = new SerializacionProducto();
      in = sp.deserializar();
     switch (op){
      case 1:
        in.ordenarPorNombre();
        break;
      case 2:
        in.ordenarPorClave();
        break;
      case 3:
        System.out.println("Ingrese el nombre del producto que desea buscar ");
        in.buscarNombre(tec.leerString());
        break;
      case 4:
        System.out.println("Ingrese la clave del producto que desea buscar ");
        in.buscarClave(tec.leerEntero());
        break;
      case 5:
        System.out.println("Ingrese la descripción del producto que desea buscar ");
        in.buscarDescripcion(tec.leerString());
        break;
      case 6:
        System.out.println("El valor total del inventario es: " + in.mostrarValorInventario());
        break;
      case 0:
        break;
      default:
        System.out.println("Ingresa opción válida");
        break;
    }
  }
  
   public void realizarOpcionMenuCompra(int op) throws IOException{
    tec = new Teclado();
    sp = new SerializacionProducto();
    if (!inventarioVacio) {
      in = sp.deserializar();
    }else{
      in = new Inventario();
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
          tec.leerString();
          String unidadMedida = tec.leerString();
          System.out.println("Añadir descripción");
          String des = tec.leerString();
          pro = new Producto(nombre, des, cant, precio, unidadMedida); 
          inventarioVacio = false;
          in.lista.add(pro);
          sp.serializar(in);
          in.ordenarPorNombre();
        } catch (IOException | ClassNotFoundException e) {
        }
        break;
      case 2:
        System.out.println("Escriba la clave del producto a eliminar");
        int clave =  tec.leerEntero();
        in.eliminar(clave);
        sp.serializar(in);
        break;
      case 3:
        System.out.println("Escriba la clave del producto a editar");
        clave = tec.leerEntero();
        caracteristicas();
        int caracteristica = tec.leerEntero();
        in.cambiarCaracteristica(caracteristica, clave);
        sp.serializar(in);
        break;
      case 0:
        break;
      default:
        System.out.println("Ingrese opción válida");
        break;
    }
  }
  
  public void realizarOpcionMenuVenta(int op) throws IOException {
    sp = new SerializacionProducto();
    in = sp.deserializar();
    tec = new Teclado();
    sv = new SerializacionVenta();
    if (!ventasVacias) {
      ves = sv.deserializar();
    }else{
      ves = new Ventas();
    }
    switch (op) {
      case 1:
        int claveProd = 0;
        int cantidad = 0;
        v = new Venta();
        System.out.println("CUANDO TERMINE DE REGISTRAR VENTA PRESIONE 0 (CERO)");
        do{
          System.out.println("Clave producto:");
          claveProd = tec.leerEntero();
          if (claveProd != 0){
          System.out.println("Cantidad");
          cantidad = tec.leerEntero();
          in = v.realizarVenta(claveProd, cantidad, ves, in);
          ventasVacias = false;          
        }
        }while(claveProd != 0);
        v.setTotalVenta();
        v.setFecha();
        v.setFolio();
        sv.serializar(ves);
        sp.serializar(in);
        break;
      case 2:        
        ves.mostrarVentas();
        break;
      case 3:        
        ves.buscarVentaPorFecha();
      case 0:        
        break;
      default:
        System.out.println("Ingresa opción válida");
        break;
    }
  }

    /**
   * Para leer enteros de la entrada estándar
   *
   * @return
   */
  public int leerOpcion() {
    Teclado te = new Teclado();
    System.out.println("¿Cuál es tu opción?");
    return te.leerEntero();
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
