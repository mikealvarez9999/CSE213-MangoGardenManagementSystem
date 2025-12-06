package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RequestHarvestController {

    @FXML
    private TextField requestQuantityTextField;
    @FXML
    private TextArea currentTotalQuantityTextArea;
    @FXML
    private TextArea spoilageTotalQuantityTextArea;

    @FXML
    public void initialize() {

        var inventoryList = WarehouseManager.getMangoInventory();

        double totalQuantity = 0;
        double totalSpoilage = 0;

        for (MangoInventory inv : inventoryList) {

            try {
                totalQuantity += Double.parseDouble(inv.getMangoQuantity());
            } catch (Exception ignored) {}

            try {
                if (inv.getSpoiled() != null && !inv.getSpoiled().isEmpty()) {
                    totalSpoilage += Double.parseDouble(inv.getSpoiled());
                }
            } catch (Exception ignored) {}
        }

        currentTotalQuantityTextArea.setText(String.valueOf(totalQuantity));
        spoilageTotalQuantityTextArea.setText(String.valueOf(totalSpoilage));
    }

    @FXML
    public void requestHarvesttoFieldSupervisorOnMouseClick(ActionEvent actionEvent) {

        String requestQty = requestQuantityTextField.getText();

    }
}