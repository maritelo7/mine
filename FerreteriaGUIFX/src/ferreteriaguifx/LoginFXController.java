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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Mari
 */
public class LoginFXController implements Initializable {
public static boolean admin = false;


  @FXML
  private Button login;
  @FXML
  private TextField user;
  @FXML
  private PasswordField password;
  @FXML
    
    
  void entrarSistema(ActionEvent event) {
    boolean entrar = false;
    if (user.getText().equals("Admin") && password.getText().equals("nomore")) { 
      admin = true;
      entrar = true;            
      Stage stage;
      Parent root = null;
      stage = (Stage) login.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();      
    }
    
    if (user.getText().equals("Empleado") && password.getText().equals("sadsongs")) {
      entrar = true;      
      Stage stage;
      Parent root = null;
      stage = (Stage) login.getScene().getWindow();
      try {
        root = FXMLLoader.load(getClass().getResource("ControlInventarioFX.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(LoginFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();     
      
    }
    if (!entrar) {
      System.out.println("Usuario o contraseña incorrectos. Por favor intente de nuevo.");
    }
  }

  
  @FXML
  void initialize() {
    assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
 }

  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

  
}
