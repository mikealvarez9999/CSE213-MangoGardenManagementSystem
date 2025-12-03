package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class trackSpoilageController
{
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn batchIDColumn;
    @javafx.fxml.FXML
    private ComboBox batchIdComboBox;
    @javafx.fxml.FXML
    private TextField spoilageQuantityTextField;
    @javafx.fxml.FXML
    private TableView trackSpoilageTableView;
    @javafx.fxml.FXML
    private TableColumn spoilageQuantityColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveSpoilageOnMouseClick(ActionEvent actionEvent) {
    }
}