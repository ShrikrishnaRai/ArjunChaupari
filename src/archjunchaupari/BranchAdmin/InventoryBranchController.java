/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class InventoryBranchController implements Initializable {

    @FXML
    private TextField inventoryName;

    @FXML
    private TextField inventorySection;

    @FXML
    private TextField inventoryRate;

    @FXML
    private TextField inventoryType;

    @FXML
    private TextField inventorySectionNumber;

    @FXML
    private TextField inventoryQuantity;

    @FXML
    private TextField inventorySpecification;

    @FXML
    private TextField inventoryRemarks;

    @FXML
    private Button saveButton;

    ExInventoryDto exInventoryDto = new ExInventoryDto();

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        //    Fieldeditable();
    }

    @FXML
    void check() {
        JOptionPane.showMessageDialog(null, "" + exInventoryDto.getName());
    }

    void Fieldeditable() {
        inventoryName.setEditable(false);
        inventoryQuantity.setEditable(false);
        inventoryType.setEditable(false);
        inventorySpecification.setEditable(false);
        inventoryRemarks.setEditable(false);
        inventoryRate.setEditable(false);
        inventorySectionNumber.setEditable(false);
        inventorySection.setEditable(false);
    }

    //updates from table to textfield
    @FXML
    void SetField(String inventoryName_text,
            int Quantity_text,
            String Type_text,
            String Specialization_text,
            String Remarks_text,
            String Rate_text,
            String SectionNumber_text,
            String Section_text) {
        inventoryName.setText(inventoryName_text);
        inventoryQuantity.setText(String.valueOf(Quantity_text));
        inventoryType.setText(Type_text);
        inventorySpecification.setText(Specialization_text);
        inventoryRemarks.setText(Remarks_text);
        inventoryRate.setText(Rate_text);
        inventorySectionNumber.setText(SectionNumber_text);
        inventorySection.setText(Section_text);

    }

}
