package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class mangoInventoryController {
    @javafx.fxml.FXML
    private TableColumn mangoTypeColumn;
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn harvestDateColumn;
    @javafx.fxml.FXML
    private TableColumn batchIdColumn;
    @javafx.fxml.FXML
    private ComboBox batchIDComboBox;
    @javafx.fxml.FXML
    private TableColumn fieldnumberColumn;
    @javafx.fxml.FXML
    private TextField mangoQuantityTextField;

    @javafx.fxml.FXML
    public void saveInventoryOnMouseClick(ActionEvent actionEvent) {
    }
}
