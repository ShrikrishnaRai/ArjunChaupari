/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari;

import archjunchaupari.Login.Services.LoginServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class FXMLDocumentController implements Initializable {

    LoginServices loginServices_Ic = new LoginServices();

    @FXML
    private WebView webView;

    @FXML
    private Button login;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    void login(ActionEvent event) throws IOException {
        if (loginServices_Ic.login(email.getText(), password.getText())) {
            JOptionPane.showMessageDialog(null, "Succeed");
            Stage primary_stage = (Stage) login.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/Dashboard/DashFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Credential");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com");
    }
}
