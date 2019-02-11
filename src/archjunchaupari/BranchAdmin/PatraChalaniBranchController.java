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
public class PatraChalaniBranchController implements Initializable {

    @FXML
    private TextField chalaniDate;
    @FXML
    private TextField chalaniNumber;
    @FXML
    private TextField letterQuantity;
    @FXML
    private TextField reception;
    @FXML
    private TextField ticket;
    @FXML
    private TextField subject;
    @FXML
    private TextField letterDate;
    @FXML
    private TextField remarks;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EditableField();
    }

    //does not allow admin to overwrite
    void EditableField() {
        chalaniDate.setEditable(false);
        chalaniNumber.setEditable(false);
        letterQuantity.setEditable(false);
        reception.setEditable(false);
        ticket.setEditable(false);
        subject.setEditable(false);
        letterDate.setEditable(false);
        remarks.setEditable(false);
    }

    //updates from table to textfield
    void setPatraField(
            String chalaniDate_text,
            String chalaniNumber_text,
            String letterQuantity_text,
            String reception_text,
            String ticket_text,
            String subject_text,
            String letterDate_text,
            String remarks_text
    ) {
        chalaniDate.setText(chalaniDate_text);
        chalaniNumber.setText(chalaniNumber_text);
        letterQuantity.setText(letterQuantity_text);
        reception.setText(reception_text);
        ticket.setText(ticket_text);
        subject.setText(subject_text);
        letterDate.setText(letterDate_text);
        remarks.setText(remarks_text);
    }

}
