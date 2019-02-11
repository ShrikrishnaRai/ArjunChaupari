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
import javafx.scene.control.TextField;

/**
 *
 * @author cri
 */
public class DartaBranchController implements Initializable {

    @FXML
    private TextField dartaDate;
    @FXML
    private TextField dartaNumber;
    @FXML
    private TextField letterQuantity;
    @FXML
    private TextField reception;
    @FXML
    private TextField signedDate;
    @FXML
    private TextField responsiblePerson;
    @FXML
    private TextField subject;
    @FXML
    private TextField remarks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Editable();
    }

    //Avoid branch admin to overwrite textfield
    void Editable() {
        dartaDate.setEditable(false);
        dartaNumber.setEditable(false);
        letterQuantity.setEditable(false);
        reception.setEditable(false);
        signedDate.setEditable(false);
        responsiblePerson.setEditable(false);
        subject.setEditable(false);
        remarks.setEditable(false);
    }

    //updates from table to textfield
    void setDartaField(String dartaDate_text,
            String dartaNumber_text,
            String letterQuantity_text,
            String reception_text,
            String signedDate_text,
            String responsiblePerson_text,
            String subject_text,
            String remarks_text
    ) {
        dartaDate.setText(dartaDate_text);
        dartaNumber.setText(dartaNumber_text);
        letterQuantity.setText(letterQuantity_text);
        reception.setText(reception_text);
        signedDate.setText(remarks_text);
        responsiblePerson.setText(responsiblePerson_text);
        subject.setText(subject_text);
        remarks.setText(remarks_text);
    }

}
