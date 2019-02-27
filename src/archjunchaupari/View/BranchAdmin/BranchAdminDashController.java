/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.BranchAdmin;

import archjunchaupari.View.Dashboard.DashFXMLController;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Services.Inventory.InventoryService;
import com.sun.media.jfxmedia.Media;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    //  private ExInventoryDto exInventoryDto;
    ExInventoryDto inventoryDto1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //   setPane();
        loadTable();
        // dashFXMLController.loadTable();
        //  test.setEditable(false);
        // tableAction();
    }

    @FXML
    void tableAction() {
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    BorderPane borderPane = new BorderPane();
                    final Scene scene = new Scene(borderPane, 500, 500);
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    inventoryDto1 = (ExInventoryDto) tableView.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(5);
                    HBox main = new HBox(2);
                    HBox hBox = new HBox(2);

                    Label inventory_label = new Label("Inventory Infromation");

                    Label label = new Label("Name");
                    TextField nameTextField = new TextField();
                    nameTextField.setEditable(false);
                    nameTextField.setText(inventoryDto1.getName());
                    HBox nameBox = new HBox(2);
                    nameBox.getChildren().add(label);
                    nameBox.getChildren().add(nameTextField);

                    Label registration_label = new Label("Registration Number");
                    TextField registrationTextField = new TextField();
                    registrationTextField.setEditable(false);
                    registrationTextField.setText(String.valueOf(inventoryDto1.getRegistration_number()));
                    HBox registrationBox = new HBox(2);
                    registrationBox.getChildren().add(registration_label);
                    registrationBox.getChildren().add(registrationTextField);

                    Label Quantity_label = new Label("Quantity");
                    TextField quantityTextField = new TextField();
                    quantityTextField.setEditable(false);
                    quantityTextField.setText(String.valueOf(inventoryDto1.getQuantity()));
                    HBox quantityBox = new HBox(2);
                    quantityBox.getChildren().add(Quantity_label);
                    quantityBox.getChildren().add(quantityTextField);

                    Label Rate_label = new Label("Rate");
                    TextField rateTextField = new TextField();
                    rateTextField.setEditable(false);
                    rateTextField.setText(inventoryDto1.getRate());
                    HBox rateBox = new HBox(2);
                    rateBox.getChildren().add(Rate_label);
                    rateBox.getChildren().add(rateTextField);

                    Label specification_label = new Label("Specification");
                    TextField specificationTextField = new TextField();
                    specificationTextField.setEditable(false);
                    specificationTextField.setText(inventoryDto1.getSpecification());
                    HBox specificationBox = new HBox(2);
                    specificationBox.getChildren().add(specification_label);
                    specificationBox.getChildren().add(specificationTextField);

                    Label section_label = new Label("Section");
                    TextField sectionTextField = new TextField();
                    sectionTextField.setEditable(false);
                    sectionTextField.setText(inventoryDto1.getSection());
                    HBox sectionBox = new HBox(2);
                    sectionBox.getChildren().add(section_label);
                    sectionBox.getChildren().add(sectionTextField);

                    Label section_number_label = new Label("Section Number");
                    TextField sectionNumberTextField = new TextField();
                    sectionNumberTextField.setEditable(false);
                    sectionNumberTextField.setText(inventoryDto1.getSection_number());
                    HBox sectionNumberBox = new HBox(2);
                    sectionNumberBox.getChildren().add(section_number_label);
                    sectionNumberBox.getChildren().add(sectionNumberTextField);

                    Label remarks_label = new Label("Remarks");
                    TextField remarksTextField = new TextField();
                    remarksTextField.setEditable(false);
                    remarksTextField.setText(inventoryDto1.getRemarks());
                    HBox remarksBox = new HBox(2);
                    remarksBox.getChildren().add(remarks_label);
                    remarksBox.getChildren().add(remarksTextField);

                    Label date_label = new Label("Date");
                    TextField dateTextField = new TextField();
                    dateTextField.setEditable(false);
                    dateTextField.setText(inventoryDto1.getCreated_date());
                    HBox dateBox = new HBox(2);
                    dateBox.getChildren().add(date_label);
                    dateBox.getChildren().add(dateTextField);

                    Label type_label = new Label("Type");
                    TextField typeTextField = new TextField();
                    typeTextField.setEditable(false);
                    typeTextField.setText(inventoryDto1.getType());
                    HBox typeBox = new HBox(2);
                    typeBox.getChildren().add(type_label);
                    typeBox.getChildren().add(typeTextField);

                    Button allowButton = new Button("Allow");
                    Button discardButton = new Button("Discard");
                    hBox.getChildren().add(allowButton);
                    hBox.getChildren().add(discardButton);
                    dialogVbox.getChildren().add(inventory_label);
                    dialogVbox.getChildren().add(nameBox);
                    dialogVbox.getChildren().add(registrationBox);
                    dialogVbox.getChildren().add(quantityBox);
                    dialogVbox.getChildren().add(rateBox);
                    dialogVbox.getChildren().add(specificationBox);
                    dialogVbox.getChildren().add(sectionBox);
                    dialogVbox.getChildren().add(sectionNumberBox);
                    dialogVbox.getChildren().add(remarksBox);
                    dialogVbox.getChildren().add(dateBox);
                    dialogVbox.getChildren().add(typeBox);
                    dialogVbox.getChildren().add(hBox);
                    dialogVbox.setPadding(new Insets(5, 5, 5, 5));
                    borderPane.setCenter(dialogVbox);
                    dialog.setScene(scene);
                    dialog.show();

                }
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
