/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaguifx;

import static ferreteriaguifx.FerreteriaFX.ventasVacias;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mari
 */
public class ConsultaVentasFXController implements Initializable {
  Producto pro;
    Inventario in = new Inventario();
    SerializacionProducto sp;
    SerializacionVenta sv;
    Venta v;
    Ventas ves;
    
  @FXML
  private AnchorPane paneVentas;
  @FXML
  private Button regresarB;
  private TextField fechaTF;

  ObservableList<?> data;
  @FXML
  private TextArea infoArea;
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    
    try {
      sp = new SerializacionProducto();
      in = sp.deserializar();
      sv = new SerializacionVenta();
      if (!ventasVacias) {
        ves = sv.deserializar();
      }else{
        ves = new Ventas();
      }
    } catch (IOException ex) {
      Logger.getLogger(ConsultaVentasFXController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    infoArea.setEditable(false);
    
    try {
      ves.mostrarVentas();
    } catch (IOException ex) {
      Logger.getLogger(ConsultaVentasFXController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    ArrayList<Venta> arr = ves.getList();
    
    for (int i = 0; i < arr.size(); i++) {
      v = arr.get(i);
      infoArea.appendText(v.toStringVoid());
      for (int j = 0; j < v.tamanioListaProd(); j++) {
        infoArea.appendText(v.listaProd(j));
      }      
    }
    
   }    
  
  @FXML
  private void regresarConsultaVentas(ActionEvent event) {
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
  }
  
}
