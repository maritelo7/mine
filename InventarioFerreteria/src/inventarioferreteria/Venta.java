/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;


import java.io.IOException;
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
  protected ArrayList<ProductoVenta> listaProductos = new ArrayList<>();
  private int folio = 0;
  private double totalVenta = 0.0;
  private String fecha;

  public Venta() {
  }

  public ArrayList<ProductoVenta> getArrayList() {
    return listaProductos;
  }

  public int getFolio() {
    return folio;
  }

  public double getTotalVenta() {
    return totalVenta;
  }

  public void setFecha() {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    this.fecha = date;
  }
  

  public String getFecha() {
    return fecha;
  }
  
  public void setTotalVenta(){
    double total = 0.0;
    ProductoVenta prodVenta = new ProductoVenta();
    for (int i = 0; i < listaProductos.size(); i++) {
      prodVenta = listaProductos.get(i);
      total = this.totalVenta + prodVenta.getSubtotal();
    }
    this.totalVenta = total;
  }
  
  public Inventario realizarVenta(int claveProd, int cantidad, Ventas ves, Inventario in) throws IOException {
    Producto prod = new Producto();
    ProductoVenta prodVenta = new ProductoVenta();
    Teclado t = new Teclado();
    SerializacionVenta sv;
    double precio = 0.0;
    boolean encontrado = false;
    boolean suficiente = false;
    double totalArticulo = 0;
      for (int i = 0; i < in.lista.size(); i++) {
        prod = in.lista.get(i);
        if(prod.getClave() == claveProd){
          encontrado=true;
          if (prod.getExistencia() >= cantidad) {
          suficiente = true;
          int existencia = prod.getExistencia() - cantidad;
          prod.setExistencia(existencia);
          prodVenta.setCantidad(cantidad);
          precio = (prod.getPrecioCompra() * .70) + prod.getPrecioCompra();
          prodVenta.setPrecioUnitario(precio);
          totalArticulo = precio * cantidad;
          prodVenta.setSubtotal(totalArticulo);
          prodVenta.setNombre(prod.getNombre());
          listaProductos.add(prodVenta);
          ves.listaVentas.add(this);         
      } 
    }
    } if (encontrado == false) {
      System.out.println("No se encontró producto con esa clave");
    } else { 
      if (suficiente == false){
      System.out.println("No hay suficiente cantidad de unidades de ese artículo");
    }}
    return in;
  }

  public void toStringVoid () {
    ProductoVenta prodVenta = new ProductoVenta();
    System.out.println("\nComprobante de venta num.: " + folio);
    System.out.println("Fecha de compra: " + fecha);
    System.out.println("Lista de productos: ");
    for (int i = 0; i < listaProductos.size(); i++) {
      prodVenta = listaProductos.get(i);
      System.out.println("Artículo: " + prodVenta.getNombre() + "  Cantidad: " + prodVenta.getCantidad()
          + "  Precio unitario: " + prodVenta.getPrecioUnitario() + " pesos   Total del artículo: "
          + prodVenta.getSubtotal() + " pesos");
    }
    System.out.println("Total de la compra: " + totalVenta);
  }

  public void setFolio() throws IOException{
    FolioVentas fv = new FolioVentas();
    this.folio = Integer.valueOf(FolioVentas.getC());         
    FolioVentas.addCont(String.valueOf(this.folio));
  }
  
}
