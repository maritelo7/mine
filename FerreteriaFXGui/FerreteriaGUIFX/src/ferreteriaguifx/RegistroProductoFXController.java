/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import static ferreteriaguifx.FerreteriaFX.inventarioVacio;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class RegistroProductoFXController implements Initializable {
  Teclado tec;
  Producto pro;
  Inventario in = new Inventario();
  SerializacionProducto sp;
  SerializacionVenta sv;
  Venta v;
  Ventas ves;
  
  
  @FXML
  private AnchorPane registroProdPane;
  @FXML
  private TextField existencia;
  @FXML
  private TextField precioCompra;
  @FXML
  private TextField descripcion;
  @FXML
  private TextField nombre;
  @FXML
  private TextField unidadMedida;
  @FXML
  private Button cancelarB;
  @FXML
  private Button registrarB;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void cerrarRegistroProd(ActionEvent event) {
    Stage stage; 
     Parent root = null;               
     stage =(Stage) cancelarB.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
  }

  
  @FXML
  private void registrarProd(ActionEvent event) {
    
    try {
      tec = new Teclado();
      sp = new SerializacionProducto();
      if (!inventarioVacio) {
        in = sp.deserializar();
      }else{
        in = new Inventario();
      }
    } catch (IOException ex) {
      Logger.getLogger(RegistroProductoFXController.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(nombre.getText().isEmpty() && existencia.getText().isEmpty() && precioCompra.getText().isEmpty() && unidadMedida.getText().isEmpty() && descripcion.getText().isEmpty()){
      
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
      stage.initOwner(registrarB.getScene().getWindow());
      stage.showAndWait();

      
    }else{
      try {
          System.out.println("Escriba el nombre del producto");
          String nombre_ = nombre.getText();
          System.out.println("Ingrese cantidad de unidades");
          int cant =  Integer.parseInt(existencia.getText());
          System.out.println("Ingrese precio de compra unitario");
          double precio = Double.parseDouble(precioCompra.getText());
          System.out.println("Ingrese tipo unidad de medida: pza, docena, litros, metros, kilogramos");
          String unidadMedida_ = unidadMedida.getText();
          System.out.println("Añadir descripción");
          String des = descripcion.getText();
          pro = new Producto(nombre_, des, cant, precio, unidadMedida_); 
          inventarioVacio = false;
          in.lista.add(pro);
          sp.serializar(in);
          in.ordenarPorNombre();
          
          
          Stage stage; 
     Parent root = null;               
     stage = new Stage();
      try {
        root = FXMLLoader.load(getClass().getResource("AddArticuloFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      stage.setScene(new Scene(root));      
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(registrarB.getScene().getWindow());
      stage.showAndWait();
          
        } catch (IOException | ClassNotFoundException e) {
        }
    }
    
  }
  
 
  
  
}
