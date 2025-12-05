package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

        batchList = WarehouseManager.getMangoBatch();
        inventoryList = WarehouseManager.getMangoInventory();

        for (MangoBatch b : batchList) {
            boolean found = false;

            for (MangoInventory inv : inventoryList) {
                if (inv.getBatchId().equals(b.getBatchId())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                inventoryList.add(new MangoInventory(b.getBatchId(), "0", "0", b));
            }
        }

        trackSpoilageTableView.setItems(inventoryList);

        batchIDColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("mangoQuantity"));
        spoilageQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("spoiled"));

        ObservableList<String> batchIDs = FXCollections.observableArrayList();
        for (MangoBatch b : batchList) {
            batchIDs.add(b.getBatchId());
        }
        batchIdComboBox.setItems(batchIDs);
    }

    @FXML
    public void saveSpoilageOnMouseClick(ActionEvent actionEvent) {

        String selectedBatch = batchIdComboBox.getValue();
        String spoilQty = spoilageQuantityTextField.getText();

        if (selectedBatch == null || spoilQty.isEmpty()) {
            return;
        }

        // Update spoilage
        for (MangoInventory inv : inventoryList) {
            if (inv.getBatchId().equals(selectedBatch)) {
                inv.setSpoiled(spoilQty);
                break;
            }
        }

        WarehouseManager.mangoInventory(inventoryList);

        trackSpoilageTableView.refresh();
        batchIdComboBox.setValue(null);
        spoilageQuantityTextField.clear();
    }
}
