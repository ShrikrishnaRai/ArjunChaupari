/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.BranchAdmin;

import archjunchaupari.Model.User.UserDto;
import archjunchaupari.Services.User.UserService;
import archjunchaupari.Utils.LangSts;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private DatePicker staffJoinedDate;

    @FXML
    private Label staffJoinedDate_Label;

    @FXML
    private TextField staffAddress;

    @FXML
    private Label staffAddress_Label;

    @FXML
    private TextField staffEmail;

    @FXML
    private Label staffEmail_Label;

    @FXML
    private ComboBox staffGender;

    @FXML
    private Label staffGender_Label;

    @FXML
    private DatePicker staffDateOfBirth;

    @FXML
    private Label staffDateOfBirth_Label;

    @FXML
    private TextField staffPassword;

    private ResourceBundle resourceBundle;
    private Locale locale;

    @FXML
    private ComboBox staffComboBox;

    UserService userService;
    UserDto userDto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // editable();
        LoadLang();
        loadStaffGender();

    }

    @FXML
    void createUser() {
        userService = new UserService();
        userDto = new UserDto();
        userDto.setName(staffName.getText());
        userDto.setDesignation(staffDesignation.getText());
        userDto.setDate_of_birth(staffDateOfBirth.getValue().toString());
        userDto.setEmail(staffEmail.getText());
        userDto.setJoined_date(staffJoinedDate.getValue().toString());
        userDto.setPassword(staffPassword.getText());
        userDto.setGender(staffComboBox.getSelectionModel().getSelectedItem().toString());
        userDto.setRole("Branch Admin");
        userDto.setAddress(staffAddress.getText());
        userService.saveUser(userDto);
    }

    void loadStaffGender() {
        ObservableList<String> roleType = staffComboBox.getItems();
        roleType.add("Male");
        roleType.add("Female");
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
        staffAddress.setEditable(false);
//        staffGender.setEditable(false);
    }

    //updates from table to textfield
//    void updateStaff(String staffName_text,
//            String staffDesignation_Text,
//            String staffDateOfBirth_text,
//            String staffEmail_text,
//            String staffJoinedDate_text,
//            String staffSalary_text,
//            String staffGender_text) {
//        staffName.setText(staffName_text);
//        staffDesignation.setText(staffDesignation_Text);
//        staffEmail.setText(staffDateOfBirth_text);
//        staffJoinedDate.setText(staffJoinedDate_text);
//        staffSalary.setText(staffSalary_text);
//    }
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
        staffName.setPromptText(resourceBundle.getString("Staff_Name"));
        staffDesignation.setPromptText(resourceBundle.getString("Staff_Designation"));
        staffEmail.setPromptText(resourceBundle.getString("Email"));
        staffJoinedDate.setPromptText(resourceBundle.getString("Staff_Joined_Date"));
        staffAddress.setPromptText(resourceBundle.getString("Address"));
    }

    private void loadLangLabel() {
        staffName_Label.setText(resourceBundle.getString("Staff_Name"));
        staffDesignation_Label.setText(resourceBundle.getString("Staff_Designation"));
        staffEmail_Label.setText(resourceBundle.getString("Email"));
        staffJoinedDate_Label.setText(resourceBundle.getString("Staff_Joined_Date"));
        staffAddress_Label.setText(resourceBundle.getString("Address"));

    }

}
