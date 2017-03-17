/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import static ferreteriaguifx.FerreteriaFX.ventasVacias;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class RegistroVentaFXController implements Initializable {
  Teclado tec;
  Producto pro;
  Inventario in = new Inventario();
  SerializacionProducto sp;
  SerializacionVenta sv;
  Venta v;
  Ventas ves;
  ProductoVenta prov;
  boolean aniadioProd = false;
  boolean registroVenta = false;

  
  

  @FXML
  private AnchorPane registroVentaPane;
  @FXML
  private Font x1;
  @FXML
  private Button aniadirCompraB;
  @FXML
  private TextField cantidad;
  @FXML
  private Button fianlizarVentaB;
  @FXML
  private TextField clave;
  @FXML
  private TextField total;
  @FXML
  private Button regresarB;
  @FXML
  private TextArea areaLista;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      // TODO
      sp = new SerializacionProducto();
    } catch (IOException ex) {
      Logger.getLogger(RegistroVentaFXController.class.getName()).log(Level.SEVERE, null, ex);
    }
    in = sp.deserializar();
    sv = new SerializacionVenta();
    v = new Venta();
    if (!ventasVacias) {
      ves = sv.deserializar();
    }else{
      ves = new Ventas();
    }
    total.setEditable(false);
  }  

  
  @FXML
  private void aniadirProd(ActionEvent event) throws IOException {   
    int claveProd = 0;
    int cantidad_ = 0;

    if(cantidad.getText().isEmpty() && cantidad.getText().isEmpty()){
      
      Stage stage; 
     Parent root = null;               
     stage = new Stage();
      try {
        root = FXMLLoader.load(getClass().getResource("PopUpLlenarTodosLosCampos.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      stage.setScene(new Scene(root));      
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(aniadirCompraB.getScene().getWindow());
      stage.showAndWait();
      
    }else{
      
    registroVenta = false;
    aniadioProd = true;
    claveProd = Integer.parseInt(clave.getText());
    cantidad_  = Integer.parseInt(cantidad.getText());
    in = v.realizarVenta(claveProd, cantidad_, ves, in);
    prov = v.listaProductos.get(v.tamanioListaProd()-1);
    areaLista.appendText("\n" + prov.toString());
    
    }
    
    
  }

  
  @FXML
  private void registrarVenta(ActionEvent event) throws IOException {
    if (aniadioProd){        
        ves.listaVentas.add(v); 
        v.setTotalVenta();
        total.setText("$ " + Double.toString(v.getTotalVenta()));
        v.setFecha();
        v.setFolio();
        sv.serializar(ves);
        sp.serializar(in);
        registroVenta = true;
        ventasVacias = false;        
  }else{
      System.out.println("Debe añadir al menos un producto al carrito de compras para poder registrar la venta.");
      registroVenta = false;
    }
  }

  @FXML
  private void cerrarRegistroVenta(ActionEvent event) throws IOException {
   // if (registroVenta){
     Stage stage; 
     Parent root = null;               
     stage =(Stage) regresarB.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
 // }else{
     /*v.setTotalVenta();
        v.setFecha();
        v.setFolio();
        sv.serializar(ves);
        sp.serializar(in);
      */  registroVenta = true;
   // }
  }
  
}
