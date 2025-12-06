package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class sendOrderToTransportController
{
    @javafx.fxml.FXML
    private DatePicker transportTimeDatePicker;
    @javafx.fxml.FXML
    private TextField quantityDisbatchTextField;
    @javafx.fxml.FXML
    private ComboBox orderIDComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendToTransportManagerOnMouseClick(ActionEvent actionEvent) {
    }
}