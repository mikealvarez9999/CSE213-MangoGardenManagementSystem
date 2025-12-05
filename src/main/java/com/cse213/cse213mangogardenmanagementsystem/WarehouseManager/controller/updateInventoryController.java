package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.collections.ObservableList;

public class updateInventoryController {

    @FXML private ComboBox<String> mangoAddAndRemoveComboBox;
    @FXML private ComboBox<String> batchIdComboBox;
    @FXML private TextField mangoQuantityTextField;
    @FXML private TextArea confirmMessageTextArea;

    private ObservableList<MangoBatch> batchList;
    private ObservableList<MangoInventory> inventoryList;

    @FXML
    public void initialize() {

        batchList = WarehouseManager.getMangoBatch();
        inventoryList = WarehouseManager.getMangoInventory();

        mangoAddAndRemoveComboBox.getItems().addAll("ADD", "REMOVE");

        if (batchList == null || batchList.isEmpty()) {
            confirmMessageTextArea.setText("⚠ No Batch data found!");
            return;
        }

        System.out.println("Loaded Batch Count: " + batchList.size());

        for (MangoBatch b : batchList) {
            if (b != null && b.getBatchId() != null) {
                batchIdComboBox.getItems().add(b.getBatchId());
            }
        }

        if (batchIdComboBox.getItems().isEmpty()) {
            confirmMessageTextArea.setText("⚠ Batch list is loaded but Batch IDs are null!");
        }
    }

    private MangoInventory getInventory(String batchId) {
        for (MangoInventory inv : inventoryList) {
            if (inv.getBatchId().equals(batchId))
                return inv;
        }
        return null;
    }

    @FXML
    public void updateInventoryOnMouseClick(ActionEvent actionEvent) {

        String actionType = mangoAddAndRemoveComboBox.getValue();
        String id = batchIdComboBox.getValue();
        String qtyText = mangoQuantityTextField.getText();

        if (actionType == null || id == null || qtyText.isEmpty()) {
            confirmMessageTextArea.setText("⚠ Select action, batch ID and enter quantity!");
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyText);
        } catch (Exception e) {
            confirmMessageTextArea.setText("⚠ Quantity must be numeric!");
            return;
        }

        MangoInventory inventory = getInventory(id);

        if (inventory == null) {
            confirmMessageTextArea.setText("⚠ No inventory found for batch " + id);
            return;
        }

        int existingQty = Integer.parseInt(inventory.getMangoQuantity());

        if (actionType.equals("ADD")) {
            existingQty += qty;
            confirmMessageTextArea.setText("✔ Added " + qty );

        } else if (actionType.equals("REMOVE")) {
            if (qty > existingQty) {
                confirmMessageTextArea.setText("Cannot remove more than existing quantity");
                return;
            }
            existingQty -= qty;
            confirmMessageTextArea.setText("✔ Removed " + qty);
        }

        inventory.setMangoQuantity(String.valueOf(existingQty));

        WarehouseManager.mangoInventory(inventoryList);

        mangoAddAndRemoveComboBox.setValue(null);
        batchIdComboBox.setValue(null);
        mangoQuantityTextField.clear();
    }
}
