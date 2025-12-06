package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewInventorySummaryController {
    @javafx.fxml.FXML
    private TableView<MangoInventory> inventoryTV;
    @javafx.fxml.FXML
    private TableColumn<MangoInventory, String> batchidTC;
    @javafx.fxml.FXML
    private TableColumn<MangoInventory, String> spoilageTC;
    @javafx.fxml.FXML
    private TableColumn<MangoInventory, String> quantityTC;

    @javafx.fxml.FXML
    public void initialize(){
        quantityTC.setCellValueFactory(new PropertyValueFactory<MangoInventory, String>("mangoQuantity"));
        spoilageTC.setCellValueFactory(new PropertyValueFactory<MangoInventory, String>("spoiled"));
        batchidTC.setCellValueFactory(new PropertyValueFactory<MangoInventory, String>("batchId"));

        inventoryTV.setItems(Owner.loadInventory());
    }
}
