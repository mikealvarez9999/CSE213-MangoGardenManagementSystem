package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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

        inventoryList = WarehouseManager.getMangoInventory();

        batchIdColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("mangoQuantity"));
        spoilageColumn.setCellValueFactory(new PropertyValueFactory<>("spoiled"));

        inventorySummaryTableView.setItems(inventoryList);
        calculateTotals();
    }

    private void calculateTotals() {
        int totalQty = 0;
        int totalSpoilage = 0;

        for (MangoInventory inv : inventoryList) {
            try {
                totalQty += Integer.parseInt(inv.getMangoQuantity());
            } catch (NumberFormatException e) {
            }

            try {
                totalSpoilage += Integer.parseInt(inv.getSpoiled());
            } catch (NumberFormatException e) {
            }
        }

        totalQuantityTextArea.setText(String.valueOf(totalQty));
        totalSpoilageTextArea.setText(String.valueOf(totalSpoilage));
    }
}
