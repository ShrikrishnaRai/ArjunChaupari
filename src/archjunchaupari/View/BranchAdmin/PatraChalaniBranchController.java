/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.BranchAdmin;

import archjunchaupari.Utils.LangSts;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author cri
 */
public class PatraChalaniBranchController extends LangSts implements Initializable {

    @FXML
    private TextField chalaniDate;
    @FXML
    private Label chalaniDate_Label;
    @FXML
    private TextField chalaniNumber;
    @FXML
    private Label chalaniNumber_Label;
    @FXML
    private TextField letterQuantity;
    @FXML
    private Label letterQuantity_Label;
    @FXML
    private TextField reception;
    @FXML
    private Label reception_Label;
    @FXML
    private TextField ticket;
    @FXML
    private Label ticket_Label;
    @FXML
    private TextField subject;
    @FXML
    private Label subject_Label;
    @FXML
    private TextField letterDate;
    @FXML
    private Label letterDate_Label;
    @FXML
    private TextField remarks;
    @FXML
    private Label remarks_Label;

    private Locale locale;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EditableField();
        LoadLang();
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

    private void loadLangTextField() {
        chalaniDate.setText(resourceBundle.getString("Chalani_Date"));
        chalaniNumber.setText(resourceBundle.getString("Chalani_Number"));
        letterQuantity.setText(resourceBundle.getString("Letter_Quantity"));
        reception.setText(resourceBundle.getString("Reception"));
        ticket.setText(resourceBundle.getString("Ticket"));
        subject.setText(resourceBundle.getString("Subject"));
        letterDate.setText(resourceBundle.getString("Letter_Date"));
        remarks.setText(resourceBundle.getString("Remarks"));
    }

    private void loadLangLabel() {
        chalaniDate_Label.setText(resourceBundle.getString("Chalani_Date"));
        chalaniNumber_Label.setText(resourceBundle.getString("Chalani_Number"));
        letterQuantity_Label.setText(resourceBundle.getString("Letter_Quantity"));
        reception_Label.setText(resourceBundle.getString("Reception"));
        ticket_Label.setText(resourceBundle.getString("Ticket"));
        subject_Label.setText(resourceBundle.getString("Subject"));
        letterDate_Label.setText(resourceBundle.getString("Letter_Date"));
        remarks_Label.setText(resourceBundle.getString("Remarks"));
    }

}
