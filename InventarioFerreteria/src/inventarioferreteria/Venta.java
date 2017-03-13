/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Venta implements Serializable {
  private ArrayList<Producto> listaProductos = new ArrayList<>();
  private int folio = 0;
  private double totalVenta = 0.0;
  private String fecha;

  public Venta() {
  }

  public ArrayList<Producto> getArrayList() {
    return listaProductos;
  }

  public int getFolio() {
    return folio;
  }

  public double getTotalVenta() {
    return totalVenta;
  }

  public String setFecha() {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    System.out.println(date);
    return date;
  }

  public String getFecha() {
    return fecha;
  }

  public Ventas realizarVenta(int claveProd, int cantidad, Ventas vs) throws IOException {
    FolioVentas fv = new FolioVentas();
    Inventario in = new Inventario();
    Producto prod = new Producto();
    Producto aux = new Producto();
    Teclado t = new Teclado();
    SerializacionVenta sv;
    Ventas ves;
    double precio = 0.0;
    boolean encontrado = false;
    double totalArticulo = 0;
    folio = Integer.valueOf(fv.getC());
    encontrado = in.buscarClave(claveProd);
    if (encontrado) {
      if (prod.getExistencia() >= cantidad) {
        prod.setExistencia(prod.getExistencia() - cantidad);
        aux = prod;
        precio = (prod.getPrecioCompra() * .70) + prod.getPrecioCompra();
        aux.setPrecioCompra(precio);
        totalArticulo = precio * cantidad;
        aux.setTotal(totalArticulo);
        aux.setExistencia(cantidad);
        totalVenta = totalVenta + totalArticulo;
        listaProductos.add(aux);
        fecha = setFecha();
        sv = new SerializacionVenta();
        vs.listaVentas.add(this);
       // sv.serializar(vs);
      } else {
        System.out.println("No hay suficientes artículos en existencia");
        encontrado = false;
      }
    } else {
      System.out.println("No se encontró producto con esa clave");
    }

    return vs;
  }

  public void toStringVoid() {
    Producto prod = new Producto();
    System.out.println("Comprobante de venta num.: " + folio);
    System.out.println("Fecha de compra: " + fecha);
    System.out.println("Lista de productos: ");
    for (int i = 0; i < listaProductos.size(); i++) {
      prod = listaProductos.get(i);
      System.out.println("Artículo: " + prod.getNombre() + "  Cantidad: " + prod.getExistencia()
          + "  Precio unitario: " + prod.getPrecioCompra() + " pesos   Total del artículo: "
          + prod.getTotal() + " pesos");
    }
    System.out.println("Total de la compra: " + totalVenta);
  }

}
