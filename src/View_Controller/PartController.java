/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InhousePart;
import Model.OutsourcedPart;
import Model.Part;
import Model.Inventory;
import static Model.Inventory.allParts;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PartController implements Initializable {

    // Controller
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
    MainScreenController msController = loader.getController();
    
    // Labels
    @FXML
    Label addorModifyPart;
    @FXML
    Label lastProperty;
    
    // TextFields
    @FXML
    TextField partID;
    @FXML
    TextField partName;
    @FXML
    TextField partInv;
    @FXML
    TextField partPrice;
    @FXML
    TextField partMin;
    @FXML
    TextField partMax;
    @FXML
    TextField lastPropertTF;
    
    // RadioButtons
    @FXML
    RadioButton inHouse = new RadioButton();
    @FXML
    RadioButton Outsourced = new RadioButton();
    @FXML
    ToggleGroup radioButtonGroup = new ToggleGroup(); 
    
    // Buttons
    @FXML
    Button save;
    @FXML
    Button cancel;
    
    @FXML
    Part part;
    
    @FXML
    public boolean edit = false;
    
    // Observable list to store information
    
    // Button press 
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
              
        // hide initial last property fields
        lastProperty.setVisible(false);
        lastPropertTF.setVisible(false);
        partID.setText("Automatically generates ID");
        partID.setDisable(true);
        
        // Buttons action handlers to save and cancel
        
        Outsourced.setToggleGroup(radioButtonGroup);
        inHouse.setToggleGroup(radioButtonGroup);
        
        radioButtonGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            // Has selection.
            if (radioButtonGroup.getSelectedToggle() != null) checkName{
                RadioButton button = (RadioButton) radioButtonGroup.getSelectedToggle();
                if (button == inHouse){
                    lastProperty.setVisible(true);
                    lastPropertTF.setVisible(true);
                    lastProperty.setText("Machine ID:");
                }
                else if (button == Outsourced){
                    lastProperty.setVisible(true);
                    lastPropertTF.setVisible(true);
                    lastProperty.setText("Company Name:");
                }
            }
        });  
        
        cancel.setOnAction((ActionEvent e) -> {
            try {
                btnCancelToMain(cancel);
            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
        save.setOnAction((ActionEvent e) -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
                Parent root = loader.load();
                MainScreenController msController = loader.getController();
                
                String testForUpdate = partID.getText();
                
                if(testForUpdate.equals("Automatically generates ID")){

                    // check to ensure all fields are filled out:
                    if (!partID.getText().isEmpty() &&
                            !partName.getText().isEmpty() &&
                            !partInv.getText().isEmpty() &&
                            !partPrice.getText().isEmpty() &&
                            !partMin.getText().isEmpty() &&
                            !partMax.getText().isEmpty() &&
                            !lastPropertTF.getText().isEmpty()){

                        if(Integer.parseInt(partMin.getText()) <= Integer.parseInt(partMax.getText())){

                            String inHouseorOutsourced = lastProperty.getText();                        

                            if (inHouseorOutsourced.equals("Machine ID:")){
                                int temp1 = msController.autoGenID();
                                String temp2 = partName.getText();
                                Double temp3 = Double.parseDouble(partPrice.getText());
                                int temp4 = Integer.parseInt(partInv.getText());
                                int temp5 = Integer.parseInt(partMin.getText());
                                int temp6 = Integer.parseInt(partMax.getText());
                                int temp7 = Integer.parseInt(lastPropertTF.getText());
                                InhousePart temp = new InhousePart(temp1, temp2, temp3, temp4, temp5, temp6, temp7);

                                msController.addPart(temp);
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("You've added an Inhouse Part to the list!");
                                alert.setContentText("Good job mate");
                                alert.showAndWait();
                                btnCancelToMain(save);
                            }
                            else if (inHouseorOutsourced.equals("Company Name:")){
                                int temp1 = msController.autoGenID();;
                                String temp2 = partName.getText();
                                Double temp3 = Double.parseDouble(partPrice.getText());
                                int temp4 = Integer.parseInt(partInv.getText());
                                int temp5 = Integer.parseInt(partMin.getText());
                                int temp6 = Integer.parseInt(partMax.getText());
                                String temp7 = lastPropertTF.getText();

                                OutsourcedPart temp = new OutsourcedPart(temp1, temp2, temp3, temp4, temp5, temp6, temp7);
                                allParts.add(temp);

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("You've added an Outsourced Part to the list!");
                                alert.setContentText("Good job mate");
                                alert.showAndWait();
                                btnCancelToMain(save);
                            }                      
                        }                    
                    }
                }
                else{
                    if (!partID.getText().isEmpty() &&
                            !partName.getText().isEmpty() &&
                            !partInv.getText().isEmpty() &&
                            !partPrice.getText().isEmpty() &&
                            !partMin.getText().isEmpty() &&
                            !partMax.getText().isEmpty() &&
                            !lastPropertTF.getText().isEmpty()){

                        if(Integer.parseInt(partMin.getText()) <= Integer.parseInt(partMax.getText())){

                            String inHouseorOutsourced = lastProperty.getText();
                            
                            if (inHouseorOutsourced.equals("Machine ID:")){
                                int temp1 = Integer.parseInt(partID.getText());
                                String temp2 = partName.getText();
                                Double temp3 = Double.parseDouble(partPrice.getText());
                                int temp4 = Integer.parseInt(partInv.getText());
                                int temp5 = Integer.parseInt(partMin.getText());
                                int temp6 = Integer.parseInt(partMax.getText());
                                int temp7 = Integer.parseInt(lastPropertTF.getText());
                                InhousePart temp = new InhousePart(temp1, temp2, temp3, temp4, temp5, temp6, temp7);

                                msController.updatePart(temp, temp1);
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Confirmation");
                                alert.setContentText("You've edited " + temp2);
                                alert.showAndWait();
                                btnCancelToMain(save);
                            }
                            else if (inHouseorOutsourced.equals("Company Name:")){
                                
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(PartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void setFieldsForUpdatePart(Part part){
        this.part = part;

        partID.setText(Integer.toString(part.getPartID()));
        partName.setText(part.getName());
        partPrice.setText(Double.toString(part.getPrice()));
        partInv.setText(Integer.toString(part.getInStock()));
        partMin.setText(Integer.toString(part.getMin()));
        partMax.setText(Integer.toString(part.getMax()));
        
        if (part instanceof InhousePart){
            InhousePart inhousePart = (InhousePart) part;
            lastPropertTF.setText(Integer.toString(inhousePart.getMachineID()));
            inHouse.setSelected(true);
        }
        else{
            OutsourcedPart outsourcedPart = (OutsourcedPart) part;
            lastPropertTF.setText(outsourcedPart.getCompanyName());
            Outsourced.setSelected(true);
        }
    }
}      
