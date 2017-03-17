/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import java.io.FileNotFoundException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class ControlInventarioFXController implements Initializable {
    Producto pro;
    Inventario in = new Inventario();
    SerializacionProducto sp;
    SerializacionVenta sv;
    Venta v;
    Ventas ves;
    
  @FXML
  private Button ordenarNombreB;
  @FXML
  private Button buscarNombreB;
  @FXML
  private Button buscarClaveB;
  @FXML
  private Button buscarDescripcionB;
  @FXML
  private TextField nombreTF;
  @FXML
  private TextField claveTF;
  @FXML
  private TextField descripcionTF;
  @FXML
  private Button regresarB;
  @FXML
  private Font x1;
  @FXML
  private TextArea totalInventarioTF;
  @FXML
  private TextArea infoArea;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
      try {
        // TODO
        sp = new SerializacionProducto();
        in = sp.deserializar();
      } catch (IOException ex) {
        Logger.getLogger(ControlInventarioFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   totalInventarioTF.setEditable(false);
   totalInventarioTF.setText(Double.toString(in.mostrarValorInventario()));
   infoArea.setEditable(false);
   
   for (int i = 0; i < in.lista.size(); i++) {
     pro = in.lista.get(i);
     infoArea.appendText(pro.toString());
   }
   
  }  

  @FXML
  private void ordenarInventarioNombre(ActionEvent event)  {
      try {
         infoArea.setText("");
        String[] arrNombres = in.arreglo();
        
        for (int i = 0; i < arrNombres.length; i++) {

          infoArea.appendText(in.buscarNombreGUI(arrNombres[i])); 
        }        
      } catch (FileNotFoundException ex ) {
        Logger.getLogger(ControlInventarioFXController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(ControlInventarioFXController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(ControlInventarioFXController.class.getName()).log(Level.SEVERE, null, ex);
      }
   
  }

  @FXML
  private void desplegarProdNombre(ActionEvent event) {
     
     infoArea.setText("");    
     for (int i = 0; i < in.lista.size(); i++) {
     pro = in.lista.get(i);
     String nombre = pro.getNombre();
     nombre = nombre.toLowerCase();
     if (nombre.contains(nombreTF.getText().toLowerCase()))
     infoArea.appendText(pro.toString());
   }
     
  }

  @FXML
  private void desplegarProdClave(ActionEvent event) {
     infoArea.setText("");    
     for (int i = 0; i < in.lista.size(); i++) {
     pro = in.lista.get(i);
     if (pro.getClave() == Integer.valueOf(claveTF.getText()))
     infoArea.appendText(pro.toString());
   }
  }

  @FXML
  private void desplegarProdDescripcion(ActionEvent event) {
     
    infoArea.setText("");    
    for (int i = 0; i < in.lista.size(); i++) {
     pro = in.lista.get(i);
     String descripcion = pro.getDescripcion();
     descripcion = descripcion.toLowerCase();
     if (descripcion.contains(descripcionTF.getText().toLowerCase())){
     infoArea.appendText(pro.toString());
     }
   }
    
  }

  @FXML
  private void cerrarInventario(ActionEvent event) {
    if (LoginFXController.admin){
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
  }else{
      
    Stage stage = (Stage) regresarB.getScene().getWindow();
    stage.close();
    }
  
  }
  
}
