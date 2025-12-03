package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class mangoInventoryController {

    @FXML private TableView<MangoInventory> mangoInventoryTableView;

    @FXML private TableColumn<MangoInventory, String> batchIdColumn;
    @FXML private TableColumn<MangoInventory, String> mangoTypeColumn;
    @FXML private TableColumn<MangoInventory, String> harvestDateColumn;
    @FXML private TableColumn<MangoInventory, String> fieldnumberColumn;
    @FXML private TableColumn<MangoInventory, String> quantityColumn;

    @FXML private ComboBox<String> batchIDComboBox;
    @FXML private TextField mangoQuantityTextField;

    private ObservableList<MangoBatch> batchList;
    private ObservableList<MangoInventory> inventoryList;

    @FXML
    public void initialize() {

        batchList = WarehouseManager.getMangoBatch();
        inventoryList = WarehouseManager.getMangoInventory();

        // CONVERT BATCHES → INVENTORY ROWS (IF NOT ALREADY PRESENT)
        for (MangoBatch b : batchList) {
            boolean exists = false;
            for (MangoInventory inv : inventoryList) {
                if (inv.getBatchId().equals(b.getBatchId())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                inventoryList.add(new MangoInventory(
                        b.getBatchId(), "", "0", b   // quantity empty
                ));
            }
        }

        // Show all batch IDs in ComboBox
        for (MangoBatch b : batchList) {
            batchIDComboBox.getItems().add(b.getBatchId());
        }

        mangoInventoryTableView.setItems(inventoryList);

        // Column setup
        batchIdColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getBatchId()));

        mangoTypeColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getBatch().getMangoType()
                ));

        harvestDateColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getBatch().getHarvestDate().toString()
                ));

        fieldnumberColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getBatch().getFieldNumber()
                ));

        quantityColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getMangoQuantity()));
    }


    @FXML
    public void saveInventoryOnMouseClick(ActionEvent event) {

        String id = batchIDComboBox.getValue();
        String qty = mangoQuantityTextField.getText();

        if (id == null || qty.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Select batch and enter quantity!").show();
            return;
        }

        for (MangoInventory inv : inventoryList) {
            if (inv.getBatchId().equals(id)) {
                inv.setMangoQuantity(qty);
                break;
            }
        }

        WarehouseManager.mangoInventory(inventoryList);

        mangoInventoryTableView.refresh();

        batchIDComboBox.setValue(null);
        mangoQuantityTextField.clear();
    }
}
