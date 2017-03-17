/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class EditarProdFXController implements Initializable {
static int clave_;
  
  @FXML
  private TextField clave;
  @FXML
  private Button editarB;
  @FXML
  private Button cancelarB;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void irEdicionProd(ActionEvent event) {
    clave_ = Integer.parseInt(clave.getText());
    
    if (clave.getText().isEmpty()){
      System.out.println("No dejes la clave en blanco");
    }else{
    Stage stage; 
     Parent root = null;               
     stage =(Stage) editarB.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource("EditarProductoFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
  }

  @FXML
  private void cerrarEditarProd(ActionEvent event) {
    Stage stage; 
     Parent root = null;               
     stage =(Stage) editarB.getScene().getWindow();
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
