/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.BranchAdmin;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author cri
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private TextField inventoryName;

    private TextField inventorySection;

    private TextField inventoryRate;

    private TextField inventoryType;

    private TextField inventorySectionNumber;

    private TextField inventoryQuantity;

    private TextField inventorySpecification;

    private TextField inventoryRemarks;

    public TextField getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(TextField inventoryName) {
        this.inventoryName = inventoryName;
    }

    public TextField getInventorySection() {
        return inventorySection;
    }

    public void setInventorySection(TextField inventorySection) {
        this.inventorySection = inventorySection;
    }

    public TextField getInventoryRate() {
        return inventoryRate;
    }

    public void setInventoryRate(TextField inventoryRate) {
        this.inventoryRate = inventoryRate;
    }

    public TextField getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(TextField inventoryType) {
        this.inventoryType = inventoryType;
    }

    public TextField getInventorySectionNumber() {
        return inventorySectionNumber;
    }

    public void setInventorySectionNumber(TextField inventorySectionNumber) {
        this.inventorySectionNumber = inventorySectionNumber;
    }

    public TextField getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(TextField inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public TextField getInventorySpecification() {
        return inventorySpecification;
    }

    public void setInventorySpecification(TextField inventorySpecification) {
        this.inventorySpecification = inventorySpecification;
    }

    public TextField getInventoryRemarks() {
        return inventoryRemarks;
    }

    public void setInventoryRemarks(TextField inventoryRemarks) {
        this.inventoryRemarks = inventoryRemarks;
    }

}
