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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mari
 */
public class MainFXController implements Initializable {

  
  @FXML
  private AnchorPane mainPane;
  @FXML
  private Button salirB;
  @FXML
  private Button consultarInventarioB;
  @FXML
  private Button registrarProdB;
  @FXML
  private Button editarProdB;
  @FXML
  private Button eliminarProdB;
  @FXML
  private Button realizarVentaB;
  @FXML
  private Button mostrarVentasB;

  @FXML
  private void cerrarMain(ActionEvent event) {
    Stage stage = (Stage) salirB.getScene().getWindow();
    stage.close();
  }

  @FXML
  private void abrirInventario(ActionEvent event) {
    cambiarScene("ControlInventarioFX.fxml");
  }

  @FXML
  private void abrirRegistroProd(ActionEvent event) {
     cambiarScene("RegistroProductoFX.fxml");    
  }

  @FXML
  private void abrirEditarProd(ActionEvent event) {
    cambiarScene("EditarProdFX.fxml");    
  }

  @FXML
  private void abrirEliminarProd(ActionEvent event) {
    cambiarScene("EliminarProdFX.fxml");    
  }

  @FXML
  private void abrirRegistroVenta(ActionEvent event) {
    cambiarScene("RegistroVentaFX.fxml");
  }

  @FXML
  private void abrirIVentasRegistradas(ActionEvent event) {
    cambiarScene("ConsultaVentasFX.fxml");
  }
  
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }   

  public void cambiarScene(String nombreController){
     Stage stage; 
     Parent root = null;               
     stage =(Stage) registrarProdB.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource(nombreController));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
  }
 
}
