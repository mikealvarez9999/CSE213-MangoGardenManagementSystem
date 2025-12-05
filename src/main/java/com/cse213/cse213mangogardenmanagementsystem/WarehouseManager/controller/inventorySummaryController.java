package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class inventorySummaryController {

    @FXML
    private TableView<MangoInventory> inventorySummaryTableView;

    @FXML
    private TableColumn<MangoInventory, String> batchIdColumn;
    @FXML
    private TableColumn<MangoInventory, String> quantityColumn;
    @FXML
    private TableColumn<MangoInventory, String> spoilageColumn;

    @FXML
    private TextArea totalQuantityTextArea;
    @FXML
    private TextArea totalSpoilageTextArea;

    private ObservableList<MangoInventory> inventoryList;

    @FXML
    public void initialize() {
        // Load inventory from WarehouseManager
        inventoryList = WarehouseManager.getMangoInventory();

        // Bind TableView
        inventorySummaryTableView.setItems(inventoryList);

        batchIdColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getBatchId()));

        quantityColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getMangoQuantity()));

        spoilageColumn.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getSpoiled()));

        // Calculate total quantity and spoilage
        int totalQty = inventoryList.stream()
                .mapToInt(inv -> Integer.parseInt(inv.getMangoQuantity()))
                .sum();

        int totalSpoilage = inventoryList.stream()
                .mapToInt(inv -> Integer.parseInt(inv.getSpoiled()))
                .sum();

        totalQuantityTextArea.setText(String.valueOf(totalQty));
        totalSpoilageTextArea.setText(String.valueOf(totalSpoilage));
    }
}
