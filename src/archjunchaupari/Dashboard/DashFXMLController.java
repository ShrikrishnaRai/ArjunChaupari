/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Dashboard;

import archjunchaupari.Inventory.InventoryDAO.InventoryDaoIMPL;
import archjunchaupari.Services.Inventory.InventoryDaoService;
import archjunchaupari.Services.Inventory.InventoryService;
import archjunchaupari.Login.LoginDAO.LoginDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Services.Darta.DartaServices;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class DashFXMLController implements Initializable {

    @FXML
    private Button b;

    @FXML
    private TreeView treeViewDash;

    @FXML
    private TableView tableView;

    @FXML
    private TableView dartaTable;

    @FXML
    private TableColumn<ExInventoryDto, String> columnName;

    @FXML
    private TextField textName;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRegistrationNumber;

    @FXML
    private TextField textRegistrationNumber;

    @FXML
    private TableColumn<ExInventoryDto, String> columnDate;

    @FXML
    private DatePicker textDate;

    @FXML
    private TableColumn<ExInventoryDto, String> columnQuantity;

    @FXML
    private TextField textQuantity;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRate;

    @FXML
    private TextField textRate;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSpecification;

    @FXML
    private TextArea textSpecification;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSection;

    @FXML
    private TextField textSection;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSection_number;

    @FXML
    private TextField textSection_number;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRemarks;

    @FXML
    private TextArea textRemarks;

    @FXML
    private TableColumn<ExInventoryDto, String> columnIs_Approved;

    //Data TableView column
    @FXML
    private TableColumn<DartaDto, String> created_date;

    @FXML
    private TableColumn<DartaDto, String> darta_number;

    @FXML
    private TableColumn<DartaDto, String> darta_date;

    @FXML
    private TableColumn<DartaDto, String> letter_quantity;

    @FXML
    private TableColumn<DartaDto, String> to_office;

    @FXML
    private TableColumn<DartaDto, String> subject;

    @FXML
    private TableColumn<DartaDto, String> image;

    @FXML
    private TableColumn<DartaDto, String> responsible_person_full_name;

    @FXML
    private TableColumn<DartaDto, String> signed_date;

    @FXML
    private TableColumn<DartaDto, String> remarks;

    @FXML
    private TextField textIsApproved;

    InventoryDaoService inventoryService;
    DartaServices dartaService;
    ExInventoryDto inventoryDto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadInventory("Spendable Item", "UnSpendable Item");
        loadDarta("Darta", "Chalani");
        loadTable();
        loadDartaTable();
    }

    //load Inventory on Table
    public void loadTable() {
        inventoryService = new InventoryService();
        //load item on tableview from pojo class 
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registration_number"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        columnSpecification.setCellValueFactory(new PropertyValueFactory<>("specification"));
        columnSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        columnSection_number.setCellValueFactory(new PropertyValueFactory<>("section_number"));
        columnRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        tableView.getItems().setAll(inventoryService.getInventory());
    }

    public void loadDartaTable() {
        dartaService = new DartaServices();
//        created_date.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        darta_number.setCellValueFactory(new PropertyValueFactory<>("darta_number"));
        darta_date.setCellValueFactory(new PropertyValueFactory<>("darta_date"));
        letter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        to_office.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        responsible_person_full_name.setCellValueFactory(new PropertyValueFactory<>("reponsible_person_full_name"));
        signed_date.setCellValueFactory(new PropertyValueFactory<>("signed_date"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        dartaTable.getItems().setAll(dartaService.getDarta());
    }

    //load item on treeView
    public void loadInventory(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Inventory");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        treeViewDash.setRoot(root);
    }

    //load Darta treeView node
    public void loadDarta(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Functionality");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        TreeItem<String> inventory = new TreeItem<>("Inventory");

        TreeItem<String> spendable = new TreeItem<>("Spendable Inventory");
        TreeItem<String> unspendable = new TreeItem<>("UnSpendable Inventory");
        /*
        spendable.addEventHandler(MouseEvent, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });*/
        root.getChildren().add(inventory);

        inventory.getChildren().add(spendable);
        inventory.getChildren().add(unspendable);
        treeViewDash.setRoot(root);
    }

    @FXML
    public void check() {
        JOptionPane.showMessageDialog(null, "hello");
    }

    @FXML
    public void saveInventory() {
        try {
            inventoryService = new InventoryService();
            inventoryDto = new ExInventoryDto();
            inventoryDto.setName(textName.getText());
            inventoryDto.setRegistration_number(textRegistrationNumber.getText());
            inventoryDto.setQuantity(textQuantity.getText());
            inventoryDto.setRate((textRate.getText()));
            inventoryDto.setSpecification(textSpecification.getText());
            inventoryDto.setSection(textSection.getText());
            inventoryDto.setSection_number(textSection_number.getText());
            inventoryDto.setRemarks(textRemarks.getText());
            inventoryService.saveInventory(inventoryDto);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

    }

}
