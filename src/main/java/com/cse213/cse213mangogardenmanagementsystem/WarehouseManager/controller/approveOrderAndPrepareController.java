package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class approveOrderAndPrepareController {

    @FXML private TableColumn orderIdCulumn;
    @FXML private TableColumn addressColumn;
    @FXML private TableColumn quantityColumn;
    @FXML private TableColumn amountColumn;
    @FXML private TableColumn statusColumn;

    @FXML private TableView orderAndPrepareTableView;
    @FXML private ComboBox orderIDComboBox;

    private ObservableList<?> orderList;

    @FXML
    public void initialize() {

        orderIdCulumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @FXML
    public void packingProcessOnMouseClick(ActionEvent actionEvent) {

    }
}