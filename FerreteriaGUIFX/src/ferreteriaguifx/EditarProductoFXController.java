/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import static ferreteriaguifx.EditarProdFXController.clave_;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class EditarProductoFXController implements Initializable {
    Producto pro;
    Inventario in = new Inventario();
    SerializacionProducto sp;
    SerializacionVenta sv;
    Venta v;
    Ventas ves;
  
  

  @FXML
  private TextField nombre;
  @FXML
  private TextField descripcion;
  @FXML
  private TextField existencia;
  @FXML
  private TextField precioCompra;
  @FXML
  private TextField unidadMed;
  @FXML
  private Button guardarCambiosB;
  @FXML
  private Button cancelarB;
  @FXML
  private TextArea infoProd;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
      try {
        // TODO
        sp = new SerializacionProducto();
      } catch (IOException ex) {
        Logger.getLogger(EditarProductoFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
    if (!inventarioVacio) {
      in = sp.deserializar();
    }else{
      in = new Inventario();
    }

        
    infoProd.setEditable(false);
    infoProd.setText(in.buscarClaveS(clave_));
    
  }  

  @FXML
  private void guardarInfo(ActionEvent event) {
    int clave = EditarProdFXController.clave_; 
    int caracteristica;
    boolean cambio = false;
    if(!nombre.getText().isEmpty()){
      caracteristica = 1;      
      in.cambiarCaracteristicaGUI(caracteristica, clave, nombre.getText());
    }
    if(!descripcion.getText().isEmpty()){
      caracteristica = 2;    
       in.cambiarCaracteristicaGUI(caracteristica, clave, descripcion.getText());
    }
    if(!existencia.getText().isEmpty()){
      caracteristica = 3;
       in.cambiarCaracteristicaGUI(caracteristica, clave, existencia.getText());
    }
    if(!precioCompra.getText().isEmpty()){
      caracteristica = 5;
       in.cambiarCaracteristicaGUI(caracteristica, clave, precioCompra.getText());
    }
    if(!unidadMed.getText().isEmpty()){
      caracteristica = 4;
       in.cambiarCaracteristicaGUI(caracteristica, clave, unidadMed.getText());
    }    
 

    infoProd.setText("Nueva información:\n" + in.buscarClaveS(clave_));
    
    sp.serializar(in);
  }

  @FXML
  private void cerrarEditarProd(ActionEvent event) {
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
  
}
