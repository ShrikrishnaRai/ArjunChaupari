/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.BranchAdmin;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Utils.LangSts;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class InventoryBranchController extends LangSts implements Initializable {

    @FXML
    private TextField inventoryName;

    @FXML
    private Label inventoryName_Label;

    @FXML
    private TextField inventorySection;

    @FXML
    private Label inventorySection_Label;

    @FXML
    private TextField inventoryRate;

    @FXML
    private Label inventoryRate_Label;

    @FXML
    private TextField inventoryType;

    @FXML
    private Label inventoryType_Label;

    @FXML
    private TextField inventorySectionNumber;
    @FXML
    private Label inventorySectionNumber_Label;

    @FXML
    private TextField inventoryQuantity;

    @FXML
    private Label inventoryQuantity_Label;

    @FXML
    private TextField inventorySpecification;

    @FXML
    private Label inventorySpecification_Label;

    @FXML
    private TextField inventoryRemarks;

    @FXML
    private Label inventoryRemarks_Label;

    @FXML
    private Button saveButton;

    ResourceBundle resourceBundle;
    Locale locale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fieldeditable();
        LoadLang();
    }

    /**
     * Does not allow branch Administrator to edit field Branch Administrator
     * only Accepts or Discard resources
     *
     */
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

    void NonFieldeditable() {
        inventoryName.setEditable(true);
        inventoryQuantity.setEditable(true);
        inventoryType.setEditable(true);
        inventorySpecification.setEditable(true);
        inventoryRemarks.setEditable(true);
        inventoryRate.setEditable(true);
        inventorySectionNumber.setEditable(true);
        inventorySection.setEditable(true);
    }

    void setFiledInv(String inventoryName_text) {
        inventoryName.setText(inventoryName_text);
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

    //Changed when MenuItem Changes the status
    @FXML
    void setNepali() {
        setStatus("Nepali");
        LoadLang();
    }

    //Changed when MenuItem Changes the status
    @FXML
    void setEnglish() {
        setStatus("English");
        LoadLang();
    }

    private void LoadLang() {
        if (("English").equals(getStatus())) {
            locale = new Locale("en", "US");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);
        }
        if (("Nepali").equals(getStatus())) {
            locale = new Locale("ne", "NP");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);

        }
        loadLangTextField();
        loadLangLabel();
    }

    //load multiple language on Pompt text field 
    private void loadLangTextField() {
        inventoryName.setText(resourceBundle.getString("Name"));
        inventoryQuantity.setText(resourceBundle.getString("Quantity"));
        inventoryType.setText(resourceBundle.getString("Type"));
        inventorySpecification.setText(resourceBundle.getString("Specification"));
        inventoryRemarks.setText(resourceBundle.getString("Remarks"));
        inventoryRate.setText(resourceBundle.getString("Rate"));
        inventorySectionNumber.setText(resourceBundle.getString("Section_Number"));
        inventorySection.setText(resourceBundle.getString("Section"));
    }

    private void loadLangLabel() {
        inventoryName_Label.setText(resourceBundle.getString("Name"));
        inventoryQuantity_Label.setText(resourceBundle.getString("Quantity"));
        inventoryType_Label.setText(resourceBundle.getString("Type"));
        inventorySpecification_Label.setText(resourceBundle.getString("Specification"));
        inventoryRemarks_Label.setText(resourceBundle.getString("Remarks"));
        inventoryRate_Label.setText(resourceBundle.getString("Rate"));
        inventorySectionNumber_Label.setText(resourceBundle.getString("Section_Number"));
        inventorySection_Label.setText(resourceBundle.getString("Section"));
    }

}
