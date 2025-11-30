package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class approveOrderAndPrepareController
{
    @javafx.fxml.FXML
    private TableColumn addressColumn;
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdCulumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableView orderAndPrepareTableView;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private ComboBox orderIDComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void packingProcessOnMouseClick(ActionEvent actionEvent) {
    }
}