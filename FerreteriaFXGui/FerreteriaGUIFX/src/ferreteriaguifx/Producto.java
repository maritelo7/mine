/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import java.io.*;
/**
 *
 * @author Maribel Tello Rodríguez
 * @version 1.0 feb 21 2017
 */
public class Producto implements Serializable {

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getExistencia() {
    return existencia;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public String getUnidadMedida() {
    return unidadMedida;
  }

  public void setUnidadMedida(String unidadMedida) {
    this.unidadMedida = unidadMedida;
  }
  
    public int getClave() {
    return clave;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }
  
  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
  
  private int clave;
  private String nombre;
  private String descripcion;
  private int existencia;
  private double precioCompra;
  private String unidadMedida;
  private double total;

  public Producto (){}
 
  public Producto(String nombre, String descripcion, int existencia, double precioCompra, String unidadMedida) throws IOException{
    ClaveProducto cp = new ClaveProducto();
    this.clave = Integer.valueOf(ClaveProducto.getC());
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.existencia = existencia;
    this.precioCompra = precioCompra;
    this.unidadMedida = unidadMedida;
    ClaveProducto.addCont(String.valueOf(this.clave));
  }
  
  @Override
  public String toString() {
	return("\nClave: " + clave + "    Nombre: " + nombre + "  " + "\nDescripción: " + descripcion + 
        "\nExistencia: " + existencia  + " " + unidadMedida +  "    Precio de compra: $" + precioCompra + " pesos");
    }

}
