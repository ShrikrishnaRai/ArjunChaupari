/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import archjunchaupari.Utils.LangSts;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
//Branch Controller for Staff
public class UpdateBranchController extends LangSts implements Initializable {

    //Inventory field
    //staff field
    @FXML
    private TextField staffName;

    @FXML
    private Label staffName_Label;

    @FXML
    private TextField staffDesignation;

    @FXML
    private Label staffDesignation_Label;

    @FXML
    private TextField staffJoinedDate;

    @FXML
    private Label staffJoinedDate_Label;

    @FXML
    private TextField staffSalary;

    @FXML
    private Label staffSalary_Label;

    @FXML
    private TextField staffEmail;

    @FXML
    private Label staffEmail_Label;

    @FXML
    private TextField staffGender;

    @FXML
    private Label staffGender_Label;

    @FXML
    private TextField staffDateOfBirth;

    @FXML
    private Label staffDateOfBirth_Label;

    private ResourceBundle resourceBundle;
    private Locale locale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editable();
        LoadLang();
    }

    @FXML
    public void test() {
        JOptionPane.showMessageDialog(null, "Hello World");
    }

    void editable() {
        staffName.setEditable(false);
        staffDesignation.setEditable(false);
        staffDateOfBirth.setEditable(false);
        staffEmail.setEditable(false);
        staffJoinedDate.setEditable(false);
        staffSalary.setEditable(false);
        staffGender.setEditable(false);
    }

    //updates from table to textfield
    void updateStaff(String staffName_text,
            String staffDesignation_Text,
            String staffDateOfBirth_text,
            String staffEmail_text,
            String staffJoinedDate_text,
            String staffSalary_text,
            String staffGender_text) {
        staffName.setText(staffName_text);
        staffDesignation.setText(staffDesignation_Text);
        staffEmail.setText(staffDateOfBirth_text);
        staffJoinedDate.setText(staffJoinedDate_text);
        staffSalary.setText(staffSalary_text);
        staffGender.setText(staffGender_text);
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

    @FXML
    void setNepali() {
        setStatus("Nepali");
        LoadLang();
    }

    @FXML
    void setEnglish() {
        setStatus("English");
        LoadLang();
    }

    private void loadLangTextField() {
        staffName.setText(resourceBundle.getString("Staff_Name"));
        staffDesignation.setText(resourceBundle.getString("Staff_Designation"));
        staffEmail.setText(resourceBundle.getString("Staff_Date_Of_Birth"));
        staffJoinedDate.setText(resourceBundle.getString("Staff_Joined_Date"));
        staffSalary.setText(resourceBundle.getString("Staff_Salary"));
        staffGender.setText(resourceBundle.getString("Staff_Gender"));
    }

    private void loadLangLabel() {
        staffName_Label.setText(resourceBundle.getString("Staff_Name"));
        staffDesignation.setText(resourceBundle.getString("Staff_Designation"));
        staffEmail.setText(resourceBundle.getString("Staff_Date_Of_Birth"));
        staffJoinedDate.setText(resourceBundle.getString("Staff_Joined_Date"));
        staffSalary.setText(resourceBundle.getString("Staff_Salary"));
        staffGender.setText(resourceBundle.getString("Staff_Gender"));

    }

}
