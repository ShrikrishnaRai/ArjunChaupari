
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari;

import archjunchaupari.Login.Services.LoginServices;
import archjunchaupari.Utils.LangSts;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class FXMLDocumentController extends LangSts implements Initializable {

    LoginServices loginServices_Ic = new LoginServices();
    private Locale locale;
    private ResourceBundle resourceBundle;

    @FXML
    private ComboBox roleCombo;

    @FXML
    private Menu file;

    @FXML
    private WebView webView;

    @FXML
    private Button login;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private MenuItem close;

    @FXML
    private ImageView imageView;

    String path = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Emblem_of_Nepal.svg/1200px-Emblem_of_Nepal.svg.png";
    Image image = new Image(path);

    @FXML
    void login(ActionEvent event) throws IOException {
        //  try {
        if ("Role".equals(roleCombo.getSelectionModel().getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(null, "Please Select Your Role");
        } else if ("Admin".equals(roleCombo.getSelectionModel().getSelectedItem().toString()) && loginServices_Ic.login(email.getText(), password.getText())) {
            Stage primary_stage = (Stage) login.getScene().getWindow();
            primary_stage.close();
            primary_stage.setResizable(false);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/Dashboard/DashFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        } else if ("Super Admin".equals(roleCombo.getSelectionModel().getSelectedItem().toString()) && loginServices_Ic.login(email.getText(), password.getText())) {
            Stage primary_stage = (Stage) login.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/SuperAdmin/SuperAdmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        } else if ("Branch Admin".equals(roleCombo.getSelectionModel().getSelectedItem().toString()) && loginServices_Ic.login(email.getText(), password.getText())) {
            Stage primary_stage = (Stage) login.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/BranchAdmin/BranchAdminDash.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        //  } catch (HeadlessException | IOException e) {
        //     JOptionPane.showMessageDialog(null, "Please Select Your Role/ " + e);
        // }
    }

    @FXML
    void close(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStatus("English");
        ObservableList<String> roleType = roleCombo.getItems();
        roleType.add("Super Admin");
        roleType.add("Admin");
        roleType.add("Branch Admin");
        WebEngine webEngine = webView.getEngine();
        //   webEngine.load("http://arjunchauparimun.gov.np/");
        imageView = ImageViewBuilder.create().image(new Image(path)).build();
    }

    private void loadLang(String lang) {
        if ("ne_NP".equals(lang)) {
            locale = new Locale("ne", "NP");
        }
        if ("en".equals(lang)) {
            locale = new Locale("en", "US");
        }
        resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);
        login.setText(resourceBundle.getString("Login"));
        email.setPromptText(resourceBundle.getString("Email"));
        password.setPromptText(resourceBundle.getString("Password"));
        file.setText(resourceBundle.getString("File"));

    }

    @FXML
    void setEnglish() {
        setStatus("English");
        if (("English").equals(getStatus())) {
            loadLang("en");
        }
    }

    @FXML
    void setNepali() {
        setStatus("Nepali");
        if (("Nepali").equals(getStatus())) {
            loadLang("ne_NP");
        }
    }

}
