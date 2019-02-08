
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari;

import archjunchaupari.Login.Services.LoginServices;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
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
public class FXMLDocumentController implements Initializable {

    LoginServices loginServices_Ic = new LoginServices();

    @FXML
    private ComboBox roleCombo;

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
        } else if ("Staff".equals(roleCombo.getSelectionModel().getSelectedItem().toString()) && loginServices_Ic.login(email.getText(), password.getText())) {
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
        ObservableList<String> roleType = roleCombo.getItems();
        roleType.add("Admin");
        roleType.add("Staff");
        roleType.add("Super Admin");
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com");
        imageView = ImageViewBuilder.create().image(new Image(path)).build();
    }

}
