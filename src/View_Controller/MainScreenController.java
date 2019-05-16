/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InhousePart;
import Model.Part;
import Model.Product;
import static Model.Inventory.allParts;
import Model.OutsourcedPart;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainScreenController implements Initializable {

    // Buttons
    @FXML
    Button searchPartBtn;
    @FXML
    Button searchProductBtn;
    @FXML
    Button addPartBtn;
    @FXML
    Button modifyPartBtn;
    @FXML
    Button deletePartBtn;
    @FXML
    Button addProductBtn;
    @FXML
    Button modifyProductBtn;
    @FXML
    Button deleteProductBtn;
    @FXML
    Button exit;

    // TextFields
    @FXML
    TextField searchPartTF;
    @FXML
    TextField searchProductTF;
    
    // Lists
    @FXML
    ObservableList<Part> partList = FXCollections.observableArrayList(allParts);

    // Tableview
    @FXML
    TableView<Part> partTableView = new TableView<Part>(partList);
    @FXML
    TableView<Product> productTableView;
 
    // TableView Columns
    @FXML
    TableColumn partTableColID;
    @FXML
    TableColumn partTableColName;
    @FXML
    TableColumn partTableColInv;
    @FXML
    TableColumn partTableColPrice;
    @FXML
    TableColumn ProductTableColID;
    @FXML
    TableColumn ProductTableColName;
    @FXML
    TableColumn ProductTableColInv;
    @FXML
    TableColumn ProductTableColPrice;
    
    static boolean initialDataEntered = false;
 
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if(!initialDataEntered){
            initialData();
            initialDataEntered = true;
        }
        partTableView.setItems(partList);
        
        // Create Table Columns
        partTableColID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        partTableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partTableColInv.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        partTableColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ProductTableColID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        ProductTableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ProductTableColInv.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        ProductTableColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
       
        addProductBtn.setOnAction((ActionEvent e) -> {
            try {
                btnToProduct(addProductBtn);
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        addPartBtn.setOnAction((ActionEvent e) -> {
            try {
                btnToAddPart(addPartBtn);
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        modifyPartBtn.setOnAction((ActionEvent e) -> {
            try {
                modifyPart();
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        exit.setOnAction(actionEvent -> Platform.exit());
        
        // 
        

    }
    
    // Create all of the button handlers to navigate the application
    public void btnToProduct (Button button) throws IOException{
    Stage stage;
    stage = (Stage) button.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("Product.fxml"));
    
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    public void btnToAddPart (Button button) throws IOException{
    Stage stage;
    stage = (Stage) button.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("Part.fxml"));
    
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
    @FXML
    public void addPart(Part part){
        
        allParts.add(part);
        partTableView.getItems().clear();
        partTableView.getItems().setAll(partList);
        partTableView.refresh();
    }
    
    @FXML
    public void updatePart(Part part, int id){
        int index = id - 1;
        allParts.remove(index);
        allParts.add(part);
        partTableView.getItems().setAll(partList);
        partTableView.refresh();
    }
    
    @FXML
    public int autoGenID(){
        int number = allParts.size() + 1;
        return number;
    }
    
    @FXML
    public void modifyPart() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) modifyPartBtn.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Part.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        PartController controller = loader.getController();
        Part part = partTableView.getSelectionModel().getSelectedItem();
        controller.setFieldsForUpdatePart(part);
        controller.edit = true;
    }
    
    @FXML
    public void initialData(){
        allParts.add(new InhousePart(1, "Blue Goop", 4.99, 13, 3, 2, 19));
        allParts.add(new InhousePart(2, "Red Goop", 5.99, 9, 7, 4, 20));
        allParts.add(new OutsourcedPart(3, "Green Goop", 9.99, 22, 6, 2, "China Inc"));
        allParts.add(new InhousePart(4, "Orange Goop", 4.99, 3, 3, 1, 12));
        allParts.add(new OutsourcedPart(5, "Purple Goop", 9.99, 7, 4, 2, "China Inc"));
        allParts.add(new InhousePart(6, "Yellow Goop", 2.99, 11, 3, 1, 9));
    }
}

/*

            
*/
