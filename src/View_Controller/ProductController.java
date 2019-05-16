/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ProductController implements Initializable {

    // Labels
    @FXML
    Label AddorModifyTitle;
    
    // TextFields
    @FXML
    TextField prodID;
    @FXML
    TextField prodName;
    @FXML
    TextField prodInv;
    @FXML
    TextField prodPrice;
    @FXML
    TextField prodMax;
    @FXML
    TextField prodMin;
    @FXML
    TextField prodSearch;
    
    // TableVies
    @FXML
    TableView searchProductTable;
    @FXML
    TableView dataProductTable;
    
    // Table Columns
    @FXML
    TableColumn partID; 
    @FXML
    TableColumn partName;
    @FXML
    TableColumn partInv;
    @FXML
    TableColumn partPrice;
    
    // Buttons
    
    @FXML
    Button search;
    @FXML
    Button add;
    @FXML
    Button delete;
    @FXML
    Button save;
    @FXML
    Button cancel;
    
    public void btnCancelToMain (Button button) throws IOException{
    Stage stage;
    stage = (Stage) button.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cancel.setOnAction((ActionEvent e) -> {
            try {
                btnCancelToMain(cancel);
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
}    