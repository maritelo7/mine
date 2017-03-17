/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Mari
 */
public class FerreteriaFX extends Application {
  public static boolean inventarioVacio = true;
  public static boolean ventasVacias = true;
  
  
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("LoginFX.fxml"));    
    Scene scene = new Scene(root);    
    stage.setScene(scene);
    stage.show();
    
  }
  
  
  public static void main(String[] args) throws FileNotFoundException, IOException {
    
    Teclado tec = new Teclado();
    File archivoInventario = new File("Inventario.txt");
    if(archivoInventario.exists()){
      BufferedReader br = new BufferedReader(new FileReader("Inventario.txt"));     
      if (br.readLine() != null) {   
        inventarioVacio = false;
    }}else{
      archivoInventario.createNewFile();
    }
    File archivoVentas = new File("Ventas.txt");
     if(archivoVentas.exists()){
      BufferedReader br = new BufferedReader(new FileReader("Inventario.txt"));     
      if (br.readLine() != null) {   
        ventasVacias = false;
    }}else{
      archivoInventario.createNewFile();
     } 
     
    launch(args);
  }

}
