/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class BranchAdminDashController implements Initializable {

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inventoryTab;

    @FXML
    private Tab dartaChalaniTab;

    @FXML
    private Tab patraChalaniTab;

    @FXML
    private Tab staffTab;

    @FXML
    private TextField test;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPane();
        //  test.setEditable(false);
    }

    void setPane() {
        BorderPane borderPane;
        try {
            borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/InventoryBranch.fxml"));
            borderPaneMain.getChildren().setAll(borderPane);
        } catch (IOException ex) {
            Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (newValue == inventoryTab) {
                    BorderPane borderPane;
                    try {
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/InventoryBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == staffTab) {
                    try {
                        BorderPane borderPane;
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/StaffBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == dartaChalaniTab) {
                    BorderPane borderPane;
                    try {
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/DartaBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == patraChalaniTab) {
                    try {
                        BorderPane borderPane;
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/PatraChalaniBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

}
