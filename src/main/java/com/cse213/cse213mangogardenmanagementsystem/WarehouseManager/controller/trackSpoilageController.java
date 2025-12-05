package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class trackSpoilageController {

    @FXML
    private TableView<MangoInventory> trackSpoilageTableView;

    @FXML
    private TableColumn<MangoInventory, String> batchIDColumn;
    @FXML
    private TableColumn<MangoInventory, String> quantityColumn;
    @FXML
    private TableColumn<MangoInventory, String> spoilageQuantityColumn;

    @FXML
    private ComboBox<String> batchIdComboBox;
    @FXML
    private TextField spoilageQuantityTextField;

    private ObservableList<MangoInventory> inventoryList;
    private ObservableList<MangoBatch> batchList;

    @FXML
    public void initialize() {
        // Load MangoBatch and MangoInventory from WarehouseManager
        batchList = WarehouseManager.getMangoBatch();
        inventoryList = WarehouseManager.getMangoInventory();

        // Ensure every batch has an inventory entry (even if quantity/spoilage is empty)
        for (MangoBatch batch : batchList) {
            boolean exists = inventoryList.stream()
                    .anyMatch(inv -> inv.getBatchId().equals(batch.getBatchId()));
            if (!exists) {
                inventoryList.add(new MangoInventory(batch.getBatchId(), "0", "0", batch));
            }
        }

        // Bind TableView
        trackSpoilageTableView.setItems(inventoryList);

        batchIDColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getBatchId()));

        quantityColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getMangoQuantity()));

        spoilageQuantityColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getSpoiled()));

        // Fill ComboBox with all batch IDs
        batchIdComboBox.setItems(FXCollections.observableArrayList(
                batchList.stream().map(MangoBatch::getBatchId).toList()
        ));
    }

    @FXML
    public void saveSpoilageOnMouseClick(ActionEvent actionEvent) {
        String selectedBatchId = batchIdComboBox.getValue();
        String spoilQty = spoilageQuantityTextField.getText();

        if (selectedBatchId == null || spoilQty.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please select a Batch ID and enter spoilage quantity.").show();
            return;
        }

        // Update the spoilage quantity
        for (MangoInventory inv : inventoryList) {
            if (inv.getBatchId().equals(selectedBatchId)) {
                inv.setSpoiled(spoilQty);
                break;
            }
        }

        // Save updated inventory
        WarehouseManager.mangoInventory(inventoryList);

        // Refresh TableView and clear inputs
        trackSpoilageTableView.refresh();
        batchIdComboBox.setValue(null);
        spoilageQuantityTextField.clear();

        new Alert(Alert.AlertType.INFORMATION, "Spoilage updated successfully!").show();
    }
}
