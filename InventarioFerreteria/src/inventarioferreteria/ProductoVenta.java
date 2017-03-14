/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioferreteria;

import java.io.*;
/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class ProductoVenta implements Serializable {

  public int getClave() {
    return clave;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecioUnitario() {
    return precioUnitario;
  }

  public void setPrecioUnitario(double precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }


  
  private int clave;
  private String nombre;
  private int cantidad;
  private double precioUnitario;
  private double subtotal;

  public ProductoVenta (){}
 
  public ProductoVenta(String nombre, int cantidad, double precioUnitario, double subtotal) throws IOException{
    ClaveProducto cp = new ClaveProducto();
    this.clave = Integer.valueOf(ClaveProducto.getC());
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.subtotal = subtotal;
    ClaveProducto.addCont(String.valueOf(this.clave));
  }
  
  @Override
  public String toString() {
	return( nombre + "    " + cantidad + "   $" + precioUnitario + "   $" + subtotal);
    }

}
