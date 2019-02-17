/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import archjunchaupari.Dashboard.DashFXMLController;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Services.Inventory.InventoryService;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private TableColumn<ExInventoryDto, Hyperlink> columnDelete;

    @FXML
    private TableColumn<ExInventoryDto, String> columnName;

    @FXML
    private TableColumn<ExInventoryDto, String> columnId;

    @FXML
    private TableColumn<ExInventoryDto, String> columnType;

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
    private TableView tableView;

    @FXML
    private TextArea textRemarks;

    DashFXMLController dashFXMLController = new DashFXMLController();
    InventoryService inventoryService = new InventoryService();
    InventoryBranchController inventoryBranchController = new InventoryBranchController();
    private ExInventoryDto exInventoryDto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPane();
        loadTable();
        // dashFXMLController.loadTable();
        //  test.setEditable(false);
        tableAction();
    }

    void tableAction() {
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                ExInventoryDto inventoryDto1 = (ExInventoryDto) tableView.getSelectionModel().getSelectedItem();
                exInventoryDto = new ExInventoryDto();
                exInventoryDto.setId(inventoryDto1.getId());
                exInventoryDto.setCreated_date(inventoryDto1.getCreated_date());
                exInventoryDto.setName(inventoryDto1.getName());
                exInventoryDto.setExpected_life(inventoryDto1.getExpected_life());
                exInventoryDto.setQuantity(inventoryDto1.getQuantity());
                exInventoryDto.setRate(inventoryDto1.getRate());
                exInventoryDto.setSpecification(inventoryDto1.getSpecification());
                exInventoryDto.setSection_number(inventoryDto1.getSection_number());
                exInventoryDto.setRemarks(inventoryDto1.getRemarks());
                exInventoryDto.setType(inventoryDto1.getType());
                exInventoryDto.setSection(inventoryDto1.getSection());
                
//                inventoryBranchController.SetField(inventoryDto1.getName(),
//                        inventoryDto1.getQuantity(),
//                        inventoryDto1.getType(),
//                        inventoryDto1.getSpecification(),
//                        inventoryDto1.getRemarks(),
//                        inventoryDto1.getRate(),
//                        inventoryDto1.getSection_number(),
//                        inventoryDto1.getSection());
//            }
            }
        });
    }

    public void loadTable() {
        inventoryService = new InventoryService();
        //load item on tableview from pojo class 
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registration_number"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        columnSpecification.setCellValueFactory(new PropertyValueFactory<>("specification"));
        columnSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        columnSection_number.setCellValueFactory(new PropertyValueFactory<>("section_number"));
        columnRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getItems().setAll(inventoryService.getInventory());
    }

    void setPane() {
        BorderPane borderPane;
        try {
            borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/InventoryBranch.fxml"));
            borderPaneMain.getChildren().setAll(borderPane);

        } catch (IOException ex) {
            Logger.getLogger(BranchAdminDashController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(BranchAdminDashController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == staffTab) {
                    try {
                        BorderPane borderPane;
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/StaffBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);

                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == dartaChalaniTab) {
                    BorderPane borderPane;
                    try {
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/DartaBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);

                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (newValue == patraChalaniTab) {
                    try {
                        BorderPane borderPane;
                        borderPane = FXMLLoader.load(getClass().getResource("/archjunchaupari/BranchAdmin/PatraChalaniBranch.fxml"));
                        borderPaneMain.getChildren().setAll(borderPane);

                    } catch (IOException ex) {
                        Logger.getLogger(BranchAdminDashController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

}
