/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Dashboard;

import archjunchaupari.Inventory.Services.InventoryDaoService;
import archjunchaupari.Inventory.Services.InventoryService;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class DashFXMLController implements Initializable {

    @FXML
    private TreeView treeViewDash;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<String, String> columnOne;

    @FXML
    private TableColumn<String, String> columnTwo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTreeItems("Initial 1", "Initial 2", "Initail 3");
        loadTable();

        /*   for (ExInventoryDto e : in.getInventory()) {
            columnOne.setCellValueFactory(c -> new SimpleStringProperty(new String(e.getName())));
            JOptionPane.showMessageDialog(null,"asdf::"+ e.getName());
            //   for (int i = 0; i < in.getInventory().size(); i++) {
            //JOptionPane.showMessageDialog(null, "" + e.getName());
            //   columnOne.setCellValueFactory(c -> new SimpleStringProperty(""+in.getInventory().get(i).getName().toString()));
            //    columnOne.setCellValueFactory(c -> new SimpleStringProperty(in.getInventory().get(i).getName()));
            //   columnTwo.setCellValueFactory(c -> new SimpleStringProperty(in.getInventory().get(i).getName()));

            // }
        }*/
        //  columnTwo.setCellValueFactory(c -> new SimpleStringProperty(new String()));
        columnTwo.setCellValueFactory(c -> new SimpleStringProperty(new String("456")));
        tableView.getItems().addAll("c1");
    }

    public void loadTable() {
        InventoryDaoService in = new InventoryService();
        for (int i = 0; i < in.getInventory().size(); i++) {
            JOptionPane.showMessageDialog(null, "Don" + in.getInventory().get(i).getName());
        }
        InventoryService inn = new InventoryService();
        inn.check();
    }

    public void loadTreeItems(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Today's Offerings");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }

        treeViewDash.setRoot(root);

    }

}
