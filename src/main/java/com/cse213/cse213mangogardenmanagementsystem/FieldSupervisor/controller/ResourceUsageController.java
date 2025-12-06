package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.ResourceInventory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.stream.Collectors;

public class ResourceUsageController
{
    @FXML private TableView<ResourceInventory> inventoryTable;
    @FXML private TextField txtPurpose;
    @FXML private ComboBox<String> cmbItem;
    @FXML private TextField txtQuantityUsed;

    // FXML Columns - assuming these are manually defined in FXML
    @FXML private TableColumn itemNameColumn;
    @FXML private TableColumn levelColumn;
    @FXML private TableColumn lastLogColumn;


    @FXML
    public void initialize() {
        // Bind columns
        // itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

        // Populate ComboBox
        cmbItem.setItems(FieldSupervisor.getInventory().stream()
                .map(ResourceInventory::getName)
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));

        handleRefresh(null); // Load inventory on startup
    }

    @FXML
    public void handleSubmitUsage(ActionEvent actionEvent) {
        String itemName = cmbItem.getValue();
        String purpose = txtPurpose.getText().trim();
        String quantityStr = txtQuantityUsed.getText().trim();

        if (itemName == null || purpose.isEmpty() || quantityStr.isEmpty()) {
            System.err.println("Error: Must select item, quantity, and purpose.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) throw new NumberFormatException();

            boolean success = FieldSupervisor.logResourceUsage(itemName, quantity, purpose);

            if (success) {
                System.out.println("Resource usage logged and inventory updated.");
                handleRefresh(null); // Refresh table
                txtQuantityUsed.clear();
                txtPurpose.clear();
            } else {
                System.err.println("Error: Insufficient stock or item not found.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Input Error: Quantity must be a positive integer.");
        }
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {
        inventoryTable.setItems(FieldSupervisor.getInventory());
        inventoryTable.refresh();
        System.out.println("Inventory list refreshed.");
    }
}