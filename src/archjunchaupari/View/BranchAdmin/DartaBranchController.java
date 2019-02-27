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
public class DartaBranchController extends LangSts implements Initializable {

    @FXML
    private TextField dartaDate;
    @FXML
    private Label dartaDate_Label;
    @FXML
    private TextField dartaNumber;
    @FXML
    private Label dartaNumber_Label;
    @FXML
    private TextField letterQuantity;
    @FXML
    private Label letterQuantity_Label;
    @FXML
    private TextField reception;
    @FXML
    private Label reception_Label;
    @FXML
    private TextField signedDate;
    @FXML
    private Label signedDate_Label;
    @FXML
    private TextField responsiblePerson;
    @FXML
    private Label responsiblePerson_Label;
    @FXML
    private TextField subject;
    @FXML
    private Label subject_Label;
    @FXML
    private TextField remarks;
    @FXML
    private Label remarks_Label;

    private ResourceBundle resourceBundle;

    private Locale locale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Editable();
        LoadLang();
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
        dartaDate.setText(resourceBundle.getString("Darta_Date"));
        dartaNumber.setText(resourceBundle.getString("Darta_Number"));
        letterQuantity.setText(resourceBundle.getString("Letter_Quantity"));
        reception.setText(resourceBundle.getString("Reception"));
        signedDate.setText(resourceBundle.getString("Remarks"));
        responsiblePerson.setText(resourceBundle.getString("Responsible_Person"));
        subject.setText(resourceBundle.getString("Subject"));
        remarks.setText(resourceBundle.getString("Remarks"));
    }

    private void loadLangLabel() {
        dartaDate_Label.setText(resourceBundle.getString("Darta_Date"));
        dartaNumber_Label.setText(resourceBundle.getString("Darta_Number"));
        letterQuantity_Label.setText(resourceBundle.getString("Letter_Quantity"));
        reception_Label.setText(resourceBundle.getString("Reception"));
        signedDate_Label.setText(resourceBundle.getString("Remarks"));
        responsiblePerson_Label.setText(resourceBundle.getString("Responsible_Person"));
        subject_Label.setText(resourceBundle.getString("Subject"));
        remarks_Label.setText(resourceBundle.getString("Remarks"));
    }

}
