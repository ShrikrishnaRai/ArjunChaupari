/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextField inventoryItemSource;

    @FXML
    private TextField inventoryExpectedLife;

    @FXML
    private TextField inventorySpecialization;

    @FXML
    private TextField inventoryRemarks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inventoryName.setEditable(false);
        inventoryExpectedLife.setEditable(false);
        inventoryItemSource.setEditable(false);
        inventoryQuantity.setEditable(false);
        inventoryType.setEditable(false);
        inventorySpecialization.setEditable(false);
        inventoryRemarks.setEditable(false);
        inventoryRate.setEditable(false);
        inventorySectionNumber.setEditable(false);
        inventorySection.setEditable(false);
    }

    //updates from table to textfield
    void SetField(String inventoryName_text,
            String InventoryExpectedLife_text,
            String ItemSource_text,
            String Quantity_text,
            String Type_text,
            String Specialization_text,
            String Remarks_text,
            String Rate_text,
            String SectionNumber_text,
            String Section_text) {
        inventoryName.setText(inventoryName_text);
        inventoryExpectedLife.setText(InventoryExpectedLife_text);
        inventoryItemSource.setText(ItemSource_text);
        inventoryQuantity.setText(Rate_text);
        inventoryType.setText(Type_text);
        inventorySpecialization.setText(Specialization_text);
        inventoryRemarks.setText(Remarks_text);
        inventoryRate.setText(Rate_text);
        inventorySectionNumber.setText(SectionNumber_text);
        inventorySection.setText(Section_text);

    }

}
