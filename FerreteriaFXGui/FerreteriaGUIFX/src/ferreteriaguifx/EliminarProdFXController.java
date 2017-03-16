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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class EliminarProdFXController implements Initializable {
Inventario in = new Inventario();
SerializacionProducto sp;
  
  
  @FXML
  private Button eliminarB;
  @FXML
  private Button salirB;
  @FXML
  private TextField eliminarTF;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
  try {
    // TODO
    sp = new SerializacionProducto();
  } catch (IOException ex) {
    Logger.getLogger(EliminarProdFXController.class.getName()).log(Level.SEVERE, null, ex);
  }
    if (!inventarioVacio) {
      in = sp.deserializar();
    }else{
      in = new Inventario();
    }

    
  }  

  @FXML
  private void irEliminarProd(ActionEvent event) {
    int clave = Integer.parseInt(eliminarTF.getText());
    int elim = in.eliminar(clave);
    sp.serializar(in);
    
    if (elim == 1){
    
            Stage stage; 
     Parent root = null;               
     stage = new Stage();
      try {
        root = FXMLLoader.load(getClass().getResource("PopUpNoEliminadoFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      stage.setScene(new Scene(root));      
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(salirB.getScene().getWindow());
      stage.showAndWait();
    }
    
    if (elim == 0){
    
            Stage stage; 
     Parent root = null;               
     stage = new Stage();
      try {
        root = FXMLLoader.load(getClass().getResource("PopUpEliminarFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      stage.setScene(new Scene(root));      
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(salirB.getScene().getWindow());
      stage.showAndWait();
    }
    
    
  }

  @FXML
  private void cerrarEliminarProd(ActionEvent event) {
    Stage stage; 
     Parent root = null;               
     stage =(Stage) salirB.getScene().getWindow();
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
