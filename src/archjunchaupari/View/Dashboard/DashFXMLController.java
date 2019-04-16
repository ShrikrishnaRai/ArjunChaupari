/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.View.Dashboard;

import archjunchaupari.Services.Inventory.InventoryDaoService;
import archjunchaupari.Services.Inventory.InventoryService;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.Services.Darta.DartaServices;
import archjunchaupari.Services.PatraChalani.PatraChalaniService;
import archjunchaupari.Services.Staff.StaffService;
import archjunchaupari.Utils.LangSts;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class DashFXMLController extends LangSts implements Initializable {

    private TreeItem<String> root;
    TreeItem<String> spendable;
    TreeItem<String> unspendable;
    TreeItem<String> discardedSpendable;
    TreeItem<String> savedSpendable;
    TreeItem<String> discardedUnspendable;
    TreeItem<String> savedUnspendable;
    TreeItem<String> PendingSpendable;
    TreeItem<String> PendingUnspendable;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Menu File;

    @FXML
    private Menu Language;

    @FXML
    private Menu Help;

    //Staff label
    @FXML
    private Label Staff_Id;
    @FXML
    private Label Staff_Name;
    @FXML
    private Label Staff_Designation;
    @FXML
    private Label Salary;
    @FXML
    private Label Address;
    @FXML
    private Label Email;
    @FXML
    private Label Joined_Date;
    @FXML
    private Label Gender;
    @FXML
    private Label Password;
    @FXML
    private Label Confirm_Password;

    @FXML
    private Label EnterDetailsInventory;

    @FXML
    private Label EnterDetailsChalani;

    @FXML
    private Label EnterDetailsDarta;

    @FXML
    private Label EnterDetailsStaff;

    @FXML
    private Label id_Darta;

    @FXML
    private Label Darta_Date;

    @FXML
    private Label Darta_Number;

    @FXML
    private Label Letter_Quantity_Darta;

    @FXML
    private Label Reception_Darta;

    @FXML
    private Label Signed_Date_Darta;

    @FXML
    private Label Responsible_Person;

    @FXML
    private Label Subject_Darta;

    @FXML
    private Label Image;

    @FXML
    private Label Remarks_Darta;
    //Patra Chalani Tab label
    @FXML
    private Label Chalani_Date;
    @FXML
    private Label Chalani_NUmber;
    @FXML
    private Label Letter_Quantity;
    @FXML
    private Label Receiption;
    @FXML
    private Label Ticket;
    @FXML
    private Label Subject;
    @FXML
    private Label Remarks_Chalani;
    @FXML
    private Label Letter_Date;
    @FXML
    private Label id;

    //Inventory Tab Label
    @FXML
    private Label Id;

    @FXML
    private Label Name;

    @FXML
    private Label Registration_Number;

    @FXML
    private Label Quantity;

    @FXML
    private Label Rate;

    @FXML
    private Label Section_Number;

    @FXML
    private Label Section;

    @FXML
    private Label Specification;

    @FXML
    private Label Date;

    @FXML
    private Label Type;

    @FXML
    private Label Remarks;

    @FXML
    private ComboBox typeComboBox;

    //patra chalani table 
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniId;

    @FXML
    private TextField chalaniId_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_date;

    @FXML
    private DatePicker chalani_date_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_number;
    
    @FXML
    private TableColumn<PatraChalaniDto,String> chalani_created_by;

    @FXML
    private TextField chalani_number_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_quantity;

    @FXML
    private TextField chalaniLetter_quantity_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_date;

    @FXML
    private DatePicker chalaniLetter_date_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniSubject;

    @FXML
    private TextArea chalaniSubject_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> to_office;

    @FXML
    private TextField to_office_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniTicket;

    @FXML
    private TextField chalaniTicket_t;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniRemarks;

    @FXML
    private TextArea chalaniRemarks_t;
    //staff table
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

    //staff field
    @FXML
    private ComboBox staffGenderCombo;

    @FXML
    private TextField inventoryId;

    @FXML
    private TextField staffId;

    @FXML
    private TextField dartaId;

    @FXML
    private TextField dartaChalaniId;

    @FXML
    private Button updateInventory;

    @FXML
    private Button updateStaff;

    @FXML
    private Button updateDarta;

    @FXML
    private Button updateDartaChalani;

    @FXML
    private Button uploadImage;

    @FXML
    private TextField searchText;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inventoryTab;

    @FXML
    private Tab patraTab;

    @FXML
    private Tab dartaTab;

    @FXML
    private Tab staffTab;

    @FXML
    private Button searchButton;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Button home;

    @FXML
    private Button b;

    @FXML
    private TreeView treeViewDash;

    @FXML
    private TableView tableView;

    @FXML
    private TableView dartaTable;

    @FXML
    private TableView staffTable;

    @FXML
    private TableView chalaniTable;
    
    @FXML
    private TableColumn<ExInventoryDto,String> created_by;

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
    private TextArea textRemarks;

    @FXML
    private TableColumn<ExInventoryDto, String> columnIs_Approved;

    //staff Field
    @FXML
    private TextField staffName;

    @FXML
    private TextField staffDesignation;

    @FXML
    private TextField staffAddress;

    @FXML
    private TextField staffEmail;

    @FXML
    private TextField staffPassword;

    @FXML
    private DatePicker staffJoinedDate;

    @FXML
    private TextField staffGender;

    @FXML
    private TextField staffSalary;

    //Darta Field
    @FXML
    private TextField dartaNumber;

    @FXML
    private TextField letterQuantity;

    @FXML
    private TextField reception;

    @FXML
    private TextArea dartaSubject;

    @FXML
    private TextArea dartaRemarks;

    @FXML
    private TextField dartaImage;

    @FXML
    private DatePicker dartaDate;

    @FXML
    private DatePicker signedDate;

    //Darta TableView column
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

    @FXML
    private TextField textIsApproved;

    @FXML
    private Label imageLocation;

    private InventoryDaoService inventoryService;
    private DartaServices dartaService;
    private ExInventoryDto inventoryDto;
    private DartaDto dartaDto;
    private StaffDto staffDto;
    private PatraChalaniDto patraChalaniDto;
    private PatraChalaniService patraChalaniService;
    private StaffService staffService;
    private Locale locale;
    private ResourceBundle resourceBundle;
    int i = 0;

    @FXML
    private Button save_inventory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splitPane.setDividerPositions(-0.5);
        LoadLang();
        loadStaffGender();
        loadDarta(resourceBundle.getString("Darta"), resourceBundle.getString("Chalani"), resourceBundle.getString("Staff"));
        loadTable();
        loadPatraChalaniTable();
//        loadDartaTable();
        loadStaffTable();
        Editable();
        loadComboBox();
        progressBar.setProgress(0.0);
        searchText.textProperty().addListener((obs, oldText, newText) -> {
            if (newText == null) {
                loadTable();
            }
        });
        treeViewDash.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue != oldValue) {
                switch (newValue.toString()) {
                    case "TreeItem [ value: Approved Inventory ]":
                        loadInventoryTableType("approved");
                        break;
                    case "TreeItem [ value: Pending Inventory ]":
                        loadInventoryTableType("pending");
                        break;
                    case "TreeItem [ value: Rejected Inventory]":
                        loadInventoryTableType("rejected");
                        break;
                }
                if (treeViewDash.getSelectionModel().selectedItemProperty().getValue().equals("TreeItem [ value: Discarded Inventory ]")) {
                    switch (newValue.toString()) {
                        case "TreeItem [ value: Saved Inventory ]":
                            loadInventoryTableType("");
                            System.out.println("check:: " + treeViewDash.getSelectionModel().selectedItemProperty().getValue());
                            break;
                        case "TreeItem [ value: Discarded Inventory ]":
                            break;
                    }
                }

            }
        });
    }

    void loadComboBox() {
        ObservableList<String> Type = typeComboBox.getItems();
        Type.add("Expendable");
        Type.add("UnExpendable");
    }

    //Avoids users from overwriting on field | used for update
    void Editable() {
        updateInventory.setDisable(true);
        updateDarta.setDisable(true);
        updateDartaChalani.setDisable(true);
        updateStaff.setDisable(true);
        inventoryId.setEditable(false);
        staffId.setEditable(false);
        chalaniId_t.setEditable(false);
        dartaId.setEditable(false);
    }

    //loads data to staff table when program runs
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

    @FXML
    void searchStaff(String name) {
        staffService = new StaffService();
        staffTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffTableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffTableDOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        staffTableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        staffTableSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        staffTableJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joined_date"));
        staffTableDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        staffTable.getItems().setAll(staffService.getStaffSearchList(name));
    }

    //loads data to patrachalani table when program runs
    void loadPatraChalaniTable() {
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
        chalani_created_by.setCellValueFactory(new PropertyValueFactory<>("created_by"));
        chalaniTable.getItems().setAll(patraChalaniService.getPatraChalaniList());
    }

    //load data on inventory table when program runs
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
        columnIs_Approved.setCellValueFactory(new PropertyValueFactory<>("is_approved"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        created_by.setCellValueFactory(new PropertyValueFactory<>("created_by"));
        tableView.getItems().setAll(inventoryService.getInventory());
    }

    //load data on inventory table when program runs
    public void loadInventoryTableType(String type) {
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
        columnIs_Approved.setCellValueFactory(new PropertyValueFactory<>("is_approved"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getItems().setAll(inventoryService.getInventoryType(type));
    }

    //load searched Inventory on Table
    public void loadSearchTable(String inventory) {
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
        columnIs_Approved.setCellValueFactory(new PropertyValueFactory<>("is_approved"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getItems().setAll(inventoryService.getSearchInventory(inventory));
    }

    //load data on dartatable when program runs
    public void loadDartaTable() {
        dartaService = new DartaServices();
        darta_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        darta_number.setCellValueFactory(new PropertyValueFactory<>("darta_number"));
        darta_date.setCellValueFactory(new PropertyValueFactory<>("darta_date"));
        letter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        to_officee.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        //   image.setCellValueFactory(new PropertyValueFactory<>("image"));
        responsible_person_full_name.setCellValueFactory(new PropertyValueFactory<>("responsible_person_full_name"));
        signed_date.setCellValueFactory(new PropertyValueFactory<>("signed_date"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        is_deleted.setCellValueFactory(new PropertyValueFactory<>("is_deleted"));
        dartaTable.getItems().setAll(dartaService.getDarta());
        dartaService.getDarta();
    }

    //load item on treeView
    public void loadInventory(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Saved Inventory");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        treeViewDash.setRoot(root);

    }

    //load Darta treeView node
    public void loadDarta(String... rootItems) {
        root = new TreeItem<>(resourceBundle.getString("Functionality"));
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        //  TreeItem<String> inventory = new TreeItem<>("Inventory");

        spendable = new TreeItem<>(resourceBundle.getString("Inventory"));
        unspendable = new TreeItem<>(resourceBundle.getString("UnSpendable_Inventory"));

        //saved or discarded for unspendable
        discardedSpendable = new TreeItem(resourceBundle.getString("Rejected_Inventory"));
        savedSpendable = new TreeItem(resourceBundle.getString("Approved_Inventory"));

        PendingSpendable = new TreeItem(resourceBundle.getString("Pending_Inventory"));
        PendingUnspendable = new TreeItem(resourceBundle.getString("Pending_Unspendable_Inventory"));

        discardedUnspendable = new TreeItem(resourceBundle.getString("Discarded_Unspendable_Inventory"));
        savedUnspendable = new TreeItem(resourceBundle.getString("Saved_Unspendable_Inventory"));

        root.getChildren().add(spendable);
        //root.getChildren().add(unspendable);
        //   inventory.getChildren().add(spendable);
        spendable.getChildren().add(savedSpendable);
        spendable.getChildren().add(PendingSpendable);
        spendable.getChildren().add(discardedSpendable);

        unspendable.getChildren().add(savedUnspendable);
        unspendable.getChildren().add(PendingUnspendable);
        unspendable.getChildren().add(discardedUnspendable);
        //   inventory.getChildren().add(unspendable);
        treeViewDash.setRoot(root);
    }

    @FXML
    public void check() {
        JOptionPane.showMessageDialog(null, "hello");
    }

    @FXML
    public void saveStaff() {
        try {
            staffDto = new StaffDto();
            staffService = new StaffService();
            staffDto.setName(staffName.getText());
            staffDto.setDesignation(staffDesignation.getText());
            staffDto.setEmail(staffEmail.getText());
            staffDto.setJoined_date(staffJoinedDate.getValue().toString());
            staffDto.setGender(staffGenderCombo.getValue().toString());
            staffDto.setSalary(staffSalary.getText());
            //staffDto.setPassword(staffPassword.getText());
            staffService.saveStaff(staffDto);
            loadStaffTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    public void saveDarta() {
        dartaDto = new DartaDto();
        dartaService = new DartaServices();
        dartaDto.setDarta_number(dartaNumber.getText());
        dartaDto.setLetter_quantity(letterQuantity.getText());
        dartaDto.setRemarks(dartaRemarks.getText());
        dartaDto.setResponsible_person_full_name(reception.getText());
        dartaDto.setSubject(dartaSubject.getText());
        String jsonTxt = null;
        try {
            //        dartaDto.setImage(uploadImage());
            InputStream inputStream = new FileInputStream(uploadImage());
            jsonTxt = IOUtils.toString(inputStream, "UTF-8");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DashFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dartaDto.setImage(jsonTxt);
        /*    System.out.println(jsonTxt);
            JSONObject json = new JSONObject(jsonTxt);       
            String a = json.getString("1000");
            System.out.println(a); */
        String dateValue = dartaDate.getValue().format(DateTimeFormatter.ISO_DATE);
        dartaDto.setDarta_date(dateValue);
        String signedValue = signedDate.getValue().format(DateTimeFormatter.ISO_DATE);
        dartaDto.setSigned_date(signedValue);
        dartaService.saveDarta(dartaDto);
    }

    @FXML
    void exit() {
        Platform.exit();
    }

    void saveInventoryAction() {

    }

    @FXML
    public void saveInventory(ActionEvent event) {
        try {
            inventoryService = new InventoryService();
            inventoryDto = new ExInventoryDto();
            inventoryDto.setName(textName.getText());
            inventoryDto.setRegistration_number(Integer.parseInt(textRegistrationNumber.getText()));
            inventoryDto.setQuantity(Integer.parseInt(textQuantity.getText()));
            inventoryDto.setRate(textRate.getText());
            inventoryDto.setSpecification(textSpecification.getText());
            inventoryDto.setSection(textSection.getText());
            inventoryDto.setSection_number(textSection_number.getText());
            inventoryDto.setRemarks(textRemarks.getText());
            inventoryDto.setCreated_date(textDate.getValue().toString());
            inventoryDto.setType(typeComboBox.getValue().toString());
            inventoryService.saveInventory(inventoryDto);
            emptyInventoryField();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        loadTable();

    }

    public void emptyInventoryField() {
        textName.setText(null);
        textRegistrationNumber.setText(null);
        textQuantity.setText(null);
        textRate.setText(null);
        textSpecification.setText(null);
        textSection.setText(null);
        textSection_number.setText(null);
        textRemarks.setText(null);
        textDate.setValue(null);
        typeComboBox.setValue(null);
    }

    @FXML
    private void saveChalani() {
        patraChalaniService = new PatraChalaniService();
        patraChalaniDto = new PatraChalaniDto();

    }

    @FXML
    public void home() {
        switch (tabPane.getSelectionModel().getSelectedIndex()) {
            case 0:
                loadTable();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Please Enter Staff or Inventory Name");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Please Enter Staff or Inventory Name");
                break;
            case 3:
                loadStaffTable();
                break;
        }
    }

    @FXML
    public void logOut() {
        try {
            Stage primary_stage = (Stage) home.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(DashFXMLController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Delete Staff Record from tableView when double click
    @FXML
    private void deleteRowChalani() {
        chalaniTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    dialog.setTitle("Chalani Information");
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    PatraChalaniDto patraChalaniDto = (PatraChalaniDto) chalaniTable.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dialog.close();
                            patraChalaniService.deletePatraChalani(patraChalaniDto.getId());
                            loadPatraChalaniTable();
                        }
                    });
                    buttonUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        dialog.close();
                        updateDartaChalani.setDisable(false);
                        updateChalaniField(patraChalaniDto.getId(),
                                patraChalaniDto.getChalani_number(),
                                patraChalaniDto.getLetter_quantity(),
                                patraChalaniDto.getSubject(),
                                patraChalaniDto.getTo_office(),
                                patraChalaniDto.getTicket(),
                                patraChalaniDto.getRemarks());
                    });

                    HBox idHbox = new HBox();
                    Label label_id = new Label("Id:: ");
                    Label label_id_text = new Label("" + patraChalaniDto.getId());
                    idHbox.getChildren().add(label_id);
                    idHbox.getChildren().add(label_id_text);

                    Label label_name = new Label("Chalani Number:: ");
                    Label label_name_text = new Label("" + patraChalaniDto.getChalani_number());
                    HBox nameHbox = new HBox();
                    nameHbox.getChildren().add(label_name);
                    nameHbox.getChildren().add(label_name_text);

                    HBox buttonHbox = new HBox();
                    buttonHbox.getChildren().add(button);
                    buttonHbox.getChildren().add(buttonUpdate);

                    dialogVbox.getChildren().add(idHbox);
                    dialogVbox.getChildren().add(nameHbox);
                    dialogVbox.getChildren().add(buttonHbox);

                    dialogVbox.setPadding(new Insets(10, 10, 10, 10));
                    Scene dialogScene = new Scene(dialogVbox, 300, 120);
                    dialog.setScene(dialogScene);
                    dialog.show();

                }
            }
        });
    }

    //Delete Staff Record from tableView when double click
    @FXML
    private void deleteRowStaff() {
        staffTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    dialog.setTitle("Staff Information");
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    StaffDto staffDto = (StaffDto) staffTable.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dialog.close();
                            staffService.deleteStaff(staffDto.getId());
                            loadStaffTable();
                        }
                    });
                    buttonUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        updateStaffField(staffDto.getId(),
                                staffDto.getDate_of_birth(),
                                staffDto.getJoined_date(),
                                staffDto.getEmail(),
                                staffDto.getName(),
                                staffDto.getDate_of_birth(),
                                staffDto.getGender(),
                                staffDto.getDesignation(),
                                staffDto.getSalary());
                        dialog.close();
                        updateStaff.setDisable(false);
                    });
//                    dialogVbox.getChildren().add(button);
//                    dialogVbox.getChildren().add(buttonUpdate);
                    HBox idHbox = new HBox();
                    Label label_id = new Label("Id::");
                    Label label_id_text = new Label("" + staffDto.getId());
                    idHbox.getChildren().add(label_id);
                    idHbox.getChildren().add(label_id_text);

                    Label label_name = new Label("Name::");
                    Label label_name_text = new Label("" + staffDto.getName());
                    HBox nameHbox = new HBox();
                    nameHbox.getChildren().add(label_name);
                    nameHbox.getChildren().add(label_name_text);

                    HBox buttonHbox = new HBox();
                    buttonHbox.getChildren().add(button);
                    buttonHbox.getChildren().add(buttonUpdate);

                    dialogVbox.getChildren().add(idHbox);
                    dialogVbox.getChildren().add(nameHbox);
                    dialogVbox.getChildren().add(buttonHbox);

                    dialogVbox.setPadding(new Insets(10, 10, 10, 10));
                    Scene dialogScene = new Scene(dialogVbox, 300, 120);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
            }
        });
    }

    //Delete Darta information from tableview when double click on Table
    @FXML
    private void deleteRowDarta() {
        dartaTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    dialog.setTitle("Inventory Information");
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    DartaDto dartaDto = (DartaDto) dartaTable.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                        }
                    });

                    HBox idHbox = new HBox();
                    Label label_id = new Label("Id:: ");
                    Label label_id_text = new Label("" + dartaDto.getId());
                    idHbox.getChildren().add(label_id);
                    idHbox.getChildren().add(label_id_text);

                    Label label_name = new Label("Darta Date:: ");
                    Label label_name_text = new Label("" + dartaDto.getDarta_date());
                    HBox nameHbox = new HBox();
                    nameHbox.getChildren().add(label_name);
                    nameHbox.getChildren().add(label_name_text);

                    HBox buttonHbox = new HBox();
                    buttonHbox.getChildren().add(button);
                    buttonHbox.getChildren().add(buttonUpdate);

                    dialogVbox.getChildren().add(idHbox);
                    dialogVbox.getChildren().add(nameHbox);
                    dialogVbox.getChildren().add(buttonHbox);

                    dialogVbox.setPadding(new Insets(10, 10, 10, 10));
                    Scene dialogScene = new Scene(dialogVbox, 300, 120);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
            }
        });
    }

    //Delete Inventory Information from tableview when double click on table 
    @FXML
    public void deleteRow() {
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    //Dialog to display information and delete and update option
                    final Stage dialog = new Stage();
                    dialog.setTitle("Inventory Information");
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    ExInventoryDto inventoryDto1 = (ExInventoryDto) tableView.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);

                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    //Transfers to another update view
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dialog.close();
                            inventoryService.deleteInventory(inventoryDto1.getId());
                            loadTable();
                        }
                    });
                    buttonUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event2) -> {
                        updateInventoryField(
                                inventoryDto1.getId(),
                                inventoryDto1.getName(),
                                inventoryDto1.getRegistration_number(),
                                inventoryDto1.getCreated_date(),
                                inventoryDto1.getQuantity(),
                                inventoryDto1.getRate(),
                                inventoryDto1.getSpecification(),
                                inventoryDto1.getSection(),
                                inventoryDto1.getSection_number(),
                                inventoryDto1.getRemarks(),
                                inventoryDto1.getIs_approved(),
                                inventoryDto1.getType());
                        dialog.close();
                        updateInventory.setDisable(false);
                    });

                    HBox hbox = new HBox(2);
                    HBox idHbox = new HBox(2);
                    HBox buttonHbox = new HBox(2);
                    Label name_label = new Label("Name::");
                    Label id_label = new Label("Id::");
                    hbox.getChildren().add(name_label);
                    hbox.getChildren().add(new Text(inventoryDto1.getName()));
                    idHbox.getChildren().add(id_label);
                    idHbox.getChildren().add(new Text(inventoryDto1.getId() + ""));
                    dialogVbox.getChildren().add(idHbox);
                    dialogVbox.getChildren().add(hbox);
                    buttonHbox.getChildren().add(button);
                    buttonHbox.getChildren().add(buttonUpdate);
                    dialogVbox.getChildren().add(buttonHbox);
                    dialogVbox.setPadding(new Insets(10, 10, 10, 10));
                    Scene dialogScene = new Scene(dialogVbox, 300, 120);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
            }
        });
    }

    //Search when search button is clicked it first checks which tab currently is on
    public void searchButtonAction() {
        switch (tabPane.getSelectionModel().getSelectedIndex()) {
            case 0:
                loadSearchTable(searchText.getText());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Please Enter Staff or Inventory Name");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Please Enter Staff or Inventory Name");
                break;
            case 3:
                searchStaff(searchText.getText());
                break;
        }
    }

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public File uploadImage() {
        File file = null;
        Image image1 = null;
        try {
            FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
            FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.jpeg");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG);
            //Show open file dialog
            file = fileChooser.showOpenDialog(null);
            String fileName = file.getAbsolutePath();
            imageLocation.setText(fileName);
            BufferedImage bufferedImage = ImageIO.read(file);
            image1 = SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException | NullPointerException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "No Image Selected");
        }
        return file;
    }

    //method for staff Gender combobox
    void loadStaffGender() {
        ObservableList<String> roleType = staffGenderCombo.getItems();
        roleType.add("Male");
        roleType.add("Female");
    }

    //Update staff Detail when udpate button is clicked
    @FXML
    void updateStaffDetail() {
        updateStaff.setDisable(false);
        staffService = new StaffService();
        staffDto = new StaffDto(
                Integer.parseInt(staffId.getText()),
                staffDesignation.getText(),
                staffSalary.getText(),
                staffName.getText(),
                staffEmail.getText()
        );
        staffService.updateStaff(staffDto);
        loadStaffTable();
    }

    //Update inventory Detail when update button is clicked
    @FXML
    void updateInventoryDetail() {
        updateInventory.setDisable(false);
        inventoryService = new InventoryService();
        inventoryDto = new ExInventoryDto(Integer.parseInt(inventoryId.getText()),
                Integer.parseInt(textRegistrationNumber.getText()),
                textDate.getValue().toString(),
                textName.getText(),
                Integer.parseInt(textQuantity.getText()),
                textRate.getText(),
                textSpecification.getText(),
                textSection_number.getText(),
                textRemarks.getText(),
                typeComboBox.getSelectionModel().getSelectedItem().toString(),
                textSection.getText()
        );
        inventoryService.updateInventory(inventoryDto);
        updateInventory.setDisable(true);
        emptyInventoryField();
        loadTable();
    }

    //Puts Value to Staff TextField when desired column is clicked
    void updateStaffField(int id,
            String date,
            String created_date,
            String email,
            String name,
            String dob,
            String gender,
            String designation,
            String salary) {
        staffId.setText(String.valueOf(id));
        staffName.setText(name);
        staffDesignation.setText(designation);
        staffEmail.setText(email);
        staffSalary.setText(salary);
    }

    /**
     * Update chalani field when table is clicked It is called from chalani
     * table when upadate button is clicked
     *
     */
    void updateChalaniField(int id,
            String number,
            String letterQuantity,
            String subject,
            String toOffice,
            String ticket,
            String remarks
    ) {
        chalaniId_t.setText(String.valueOf(id));
        chalani_number_t.setText(number);
        chalaniLetter_quantity_t.setText(letterQuantity);
        chalaniSubject_t.setText(subject);
        to_office_t.setText(toOffice);
        chalaniTicket_t.setText(ticket);
        chalaniRemarks_t.setText(remarks);
    }

    //update inventory field when table is clicked
    void updateInventoryField(
            int id,
            String name,
            int registration_number,
            String created_date,
            int quantity,
            String rate,
            String specification,
            String section,
            String section_number,
            String remarks,
            String is_approved,
            String type) {
        inventoryId.setText(String.valueOf(id));
        textName.setText(name);
        textRegistrationNumber.setText(String.valueOf(registration_number));
        textQuantity.setText(String.valueOf(quantity));
        textRate.setText(rate);
        textSpecification.setText(specification);
        textSection.setText(section);
        textSection_number.setText(section_number);
        textRemarks.setText(remarks);
    }

    void LoadLangInventoryTable() {

    }

    void loadGeneric() {
        EnterDetailsInventory.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsChalani.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsDarta.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsStaff.setText(resourceBundle.getString("Enter_Detail’s_below"));

        updateInventory.setText(resourceBundle.getString("Update"));

        updateStaff.setText(resourceBundle.getString("Update"));

        updateDarta.setText(resourceBundle.getString("Update"));

        File.setText(resourceBundle.getString("File"));

        Help.setText(resourceBundle.getString("Help"));

        Language.setText(resourceBundle.getString("Language"));
        searchButton.setText(resourceBundle.getString("Search"));
    }

    void LoadTextField() {
        //inventoryId.setPromptText(resourceBundle.getString("Inventory_Id"));
        textName.setPromptText(resourceBundle.getString("Name"));
        textRegistrationNumber.setPromptText(resourceBundle.getString("Registration_Number"));
        textQuantity.setPromptText(resourceBundle.getString("Quantity"));
        textRate.setPromptText(resourceBundle.getString("Rate"));
        textSpecification.setPromptText(resourceBundle.getString("Specification"));
        textSection_number.setPromptText(resourceBundle.getString("Section_Number"));
        textSection.setPromptText(resourceBundle.getString("Section"));
        textRemarks.setPromptText(resourceBundle.getString("Remarks"));
        textDate.setPromptText(resourceBundle.getString("Signed_Date"));
    }

    void LoadLabel() {
        Name.setText(resourceBundle.getString("Name"));
        Registration_Number.setText(resourceBundle.getString("Registration_Number"));
        Quantity.setText(resourceBundle.getString("Quantity"));
        Rate.setText(resourceBundle.getString("Rate"));
        Specification.setText(resourceBundle.getString("Specification"));
        Section_Number.setText(resourceBundle.getString("Section_Number"));
        Section.setText(resourceBundle.getString("Section"));
        Remarks.setText(resourceBundle.getString("Remarks"));
        Type.setText(resourceBundle.getString("Type"));
        Date.setText(resourceBundle.getString("Date"));
    }

    void LoadLabelChalani() {
        Chalani_Date.setText(resourceBundle.getString("Chalani_Date"));
        Chalani_NUmber.setText(resourceBundle.getString("Chalani_Number"));
        Letter_Quantity.setText(resourceBundle.getString("Letter_Quantity"));
        Receiption.setText(resourceBundle.getString("Reception"));
        Ticket.setText(resourceBundle.getString("Ticket"));
        Subject.setText(resourceBundle.getString("Subject"));
        Remarks_Chalani.setText(resourceBundle.getString("Remarks"));
        Letter_Date.setText(resourceBundle.getString("Letter_Date"));
    }

    @FXML
    void setNepali() {
        setStatus("Nepali");
        LoadLang();
    }

    @FXML
    void setEnglish() {
        setStatus("English");
        LoadLang();
    }

    void LoadLang() {
        if (("English").equals(getStatus())) {
            locale = new Locale("en", "US");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);
        }
        if (("Nepali").equals(getStatus())) {
            locale = new Locale("ne", "NP");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);

        }
        loadGeneric();
        LoadTextField();
        LoadLabel();
        LoadLabelChalani();
        loadLangLabelDarta();
        loadLangLabelStaff();
        loadLangFieldStaff();
        loadLangFieldChalani();
        loadDarta(resourceBundle.getString("Darta"), resourceBundle.getString("Chalani"), resourceBundle.getString("Staff"));

    }

    //Loads language from resourceBundle on click either nepali or english
    void loadLangLabelDarta() {
        Darta_Date.setText(resourceBundle.getString("Darta_Date"));
        Darta_Number.setText(resourceBundle.getString("Darta_Number"));
        Letter_Quantity_Darta.setText(resourceBundle.getString("Letter_Quantity"));
        Reception_Darta.setText(resourceBundle.getString("Reception"));
        Signed_Date_Darta.setText(resourceBundle.getString("Signed_Date"));
        Responsible_Person.setText(resourceBundle.getString("Responsible_Person"));
        Subject_Darta.setText(resourceBundle.getString("Subject"));
        Image.setText(resourceBundle.getString("Select_Image"));
        Remarks_Darta.setText(resourceBundle.getString("Remarks"));
    }

    //Loads language from resourceBundle on click either nepali or english
    void loadLangLabelStaff() {
        Staff_Name.setText(resourceBundle.getString("Name"));
        Staff_Designation.setText(resourceBundle.getString("Designation"));
        Salary.setText(resourceBundle.getString("Salary"));
        Address.setText(resourceBundle.getString("Address"));
        Email.setText(resourceBundle.getString("Email"));
        Joined_Date.setText(resourceBundle.getString("Joined_Date"));
        Gender.setText(resourceBundle.getString("Gender"));
        Password.setText(resourceBundle.getString("Password"));
        Confirm_Password.setText(resourceBundle.getString("Confirm_Password"));
    }

    //Loads language from resourceBundle on click either nepali or english
    void loadLangFieldStaff() {
        staffName.setPromptText(resourceBundle.getString("Name"));
        staffDesignation.setPromptText(resourceBundle.getString("Designation"));
        staffAddress.setPromptText(resourceBundle.getString("Address"));
        staffEmail.setPromptText(resourceBundle.getString("Email"));
        staffPassword.setPromptText(resourceBundle.getString("Password"));
        staffSalary.setPromptText(resourceBundle.getString("Salary"));
        staffJoinedDate.setPromptText(resourceBundle.getString("Joined_Date"));
    }

    //Loads language from resourceBundle on click either nepali or english
    void loadLangFieldChalani() {
        chalaniId_t.setPromptText(resourceBundle.getString("Id"));
        chalani_number_t.setPromptText(resourceBundle.getString("Chalani_Number"));
        chalaniRemarks_t.setPromptText(resourceBundle.getString("Remarks"));
        chalaniTicket_t.setPromptText(resourceBundle.getString("Ticket"));
        chalaniSubject_t.setPromptText(resourceBundle.getString("Subject"));
        chalaniLetter_quantity_t.setPromptText(resourceBundle.getString("Letter_Quantity"));
        to_office_t.setPromptText(resourceBundle.getString("Reception"));
        chalani_date_t.setPromptText(resourceBundle.getString("Chalani_Date"));
        chalaniLetter_date_t.setPromptText(resourceBundle.getString("Chalani_Letter_Date"));
    }

    //Update chalani from textfield to database when update button is clicked
    @FXML
    void updateChalani() {
        patraChalaniDto = new PatraChalaniDto(Integer.parseInt(chalaniId_t.getText()),
                chalani_date_t.getValue().toString(),
                chalani_number_t.getText(),
                chalaniLetter_quantity_t.getText(),
                chalaniLetter_date_t.getValue().toString(),
                chalaniSubject_t.getText(),
                to_office_t.getText(),
                chalaniTicket_t.getText(),
                chalaniRemarks_t.getText());
        patraChalaniService.updatePatraChalani(patraChalaniDto);
        loadPatraChalaniTable();
    }

    //Saves patraChalani to database
    @FXML
    void savePatraChalani() {
        patraChalaniService = new PatraChalaniService();
        patraChalaniDto = new PatraChalaniDto();
        try {
            patraChalaniDto.setChalani_date(chalani_date_t.getValue().toString());
            patraChalaniDto.setChalani_number(chalani_number_t.getText());
            patraChalaniDto.setLetter_quantity(chalaniLetter_quantity_t.getText());
            patraChalaniDto.setLetter_date(chalaniLetter_date_t.getValue().toString());
            patraChalaniDto.setSubject(chalaniSubject_t.getText());
            patraChalaniDto.setTo_office(to_office_t.getText());
            patraChalaniDto.setTicket(chalaniTicket_t.getText());
            patraChalaniDto.setRemarks(chalaniRemarks_t.getText());
            patraChalaniService.savePatraChalani(patraChalaniDto);
            loadPatraChalaniTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
