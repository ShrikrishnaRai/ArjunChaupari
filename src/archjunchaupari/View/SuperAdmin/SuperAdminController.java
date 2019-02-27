/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.SuperAdmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class SuperAdminController implements Initializable {

    @FXML
    private WebView superAdminWeb;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine webEngine = superAdminWeb.getEngine();
        webEngine.load("http://aavash.pythonanywhere.com/admin/login/?next=/admin/");
    }

}
