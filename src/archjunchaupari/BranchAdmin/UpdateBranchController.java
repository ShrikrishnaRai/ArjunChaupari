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
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class UpdateBranchController implements Initializable {

    //Inventory field
    //staff field
    @FXML
    private TextField staffName;

    @FXML
    private TextField staffDesignation;

    @FXML
    private TextField staffJoinedDate;

    @FXML
    private TextField staffSalary;

    @FXML
    private TextField staffEmail;

    @FXML
    private TextField staffGender;

    @FXML
    private TextField staffDateOfBirth;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editable();
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

}
