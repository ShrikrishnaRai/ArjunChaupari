/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.BranchAdmin;

import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.View.Dashboard.DashFXMLController;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.Services.Admin.AdminService;
import archjunchaupari.Services.Darta.DartaServices;
import archjunchaupari.Services.Inventory.InventoryService;
import archjunchaupari.Services.PatraChalani.PatraChalaniService;
import archjunchaupari.Services.Staff.StaffService;
import com.sun.media.jfxmedia.Media;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
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
    private Button createStaff;

    @FXML
    private Button home;

    @FXML
    private TextField searchText;

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private BorderPane borderPane;

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
    private TableView chalaniTable;

    @FXML
    private TableView staffTable;

    @FXML
    private TableView dartaTable;

    //load Chalani table
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniId;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_date;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_number;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_quantity;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_date;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniSubject;
    @FXML
    private TableColumn<PatraChalaniDto, String> to_office;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniTicket;
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniRemarks;

    //Load Staff Table
    @FXML
    private TableColumn<StaffDto, String> staffTableId;
    @FXML
    private TableColumn<StaffDto, String> staffTableEmail;
    @FXML
    private TableColumn<StaffDto, String> staffTableName;
    @FXML
    private TableColumn<StaffDto, String> staffTableDOB;
    @FXML
    private TableColumn<StaffDto, String> staffTableGender;
    @FXML
    private TableColumn<StaffDto, String> staffTableSalary;
    @FXML
    private TableColumn<StaffDto, String> staffTableJoinedDate;
    @FXML
    private TableColumn<StaffDto, String> staffTableDesignation;

    @FXML
    private TableColumn<DartaDto, String> darta_id;
    @FXML
    private TableColumn<DartaDto, String> created_date;
    @FXML
    private TableColumn<DartaDto, String> darta_number;
    @FXML
    private TableColumn<DartaDto, String> darta_date;
    @FXML
    private TableColumn<DartaDto, String> letter_quantity;
    @FXML
    private TableColumn<DartaDto, String> to_officee;
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
    private TableColumn<DartaDto, String> is_deleted;

    DashFXMLController dashFXMLController = new DashFXMLController();
    InventoryService inventoryService = new InventoryService();
    PatraChalaniService patraChalaniService = new PatraChalaniService();
    InventoryBranchController inventoryBranchController = new InventoryBranchController();
    private ExInventoryDto inventoryDto1;
    private StaffService staffService = new StaffService();
    private DartaServices dartaService;
    private AdminService adminService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //   setPane();
        loadTable();
        loadChalaniTable();
        loadStaffTable();
        loadDartaTable();
        // dashFXMLController.loadTable();
        //  test.setEditable(false);
        // tableAction();
    }

    @FXML
    void tableAction() {
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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
                        allowButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                            dialog.close();
                            JOptionPane.showMessageDialog(null, inventoryDto1.getId());
                            inventoryDto1.setIs_approved("rejected");
                            allowInvenory(inventoryDto1);
                            JOptionPane.showMessageDialog(null, inventoryDto1.getIs_approved());
                        });
                    }
                }
            }
        });

    }

    //loads data to inventory table
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

    void loadStaffTable() {
        staffService = new StaffService();
        staffTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffTableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffTableDOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        staffTableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        staffTableSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        staffTableJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joined_date"));
        staffTableDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        staffTable.getItems().setAll(staffService.getStaffList());
    }

    //load data to chalani table
    void loadChalaniTable() {
        patraChalaniService = new PatraChalaniService();
        chalaniId.setCellValueFactory(new PropertyValueFactory<>("id"));
        chalani_date.setCellValueFactory(new PropertyValueFactory<>("chalani_date"));
        chalani_number.setCellValueFactory(new PropertyValueFactory<>("chalani_number"));
        chalaniLetter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        chalaniLetter_date.setCellValueFactory(new PropertyValueFactory<>("letter_date"));
        chalaniSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        to_office.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        chalaniTicket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        chalaniRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        chalaniTable.getItems().setAll(patraChalaniService.getPatraChalaniList());
    }

    void loadDartaTable() {
        dartaService = new DartaServices();
        darta_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        darta_number.setCellValueFactory(new PropertyValueFactory<>("darta_number"));
        darta_date.setCellValueFactory(new PropertyValueFactory<>("darta_date"));
        letter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        to_officee.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        // image.setCellValueFactory(new PropertyValueFactory<>("image"));
        responsible_person_full_name.setCellValueFactory(new PropertyValueFactory<>("responsible_person_full_name"));
        signed_date.setCellValueFactory(new PropertyValueFactory<>("signed_date"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
//        is_deleted.setCellValueFactory(new PropertyValueFactory<>("is_deleted"));
        dartaTable.getItems().setAll(dartaService.getDarta());
        dartaService.getDarta();
    }

    @FXML
    void loadSearchInventory() {
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
        tableView.getItems().setAll(inventoryService.getSearchInventory(searchText.getText()));
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

    //allows inventory when allow button is clicked
    void allowInvenory(ExInventoryDto inventoryDto) {
        adminService = new AdminService();
        adminService.allowInventory(inventoryDto);

    }

    @FXML
    void createStaff() {
        try {
            BorderPane borderPaneAddress;
            borderPaneAddress = FXMLLoader.load(getClass().getResource("/archjunchaupari/View/BranchAdmin/StaffBranch.fxml"));
            borderPane.getChildren().setAll(borderPaneAddress);
        } catch (IOException ex) {
            Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void home() {
        try {
            Stage primary_stage = (Stage) home.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/View/BranchAdmin/BranchAdminDash.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(BranchAdminDashController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
