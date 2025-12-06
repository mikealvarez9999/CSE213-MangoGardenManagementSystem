package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class recordDeliveryCompletedController
{
    @javafx.fxml.FXML
    private TableColumn deliveryOrderIdColumn;
    @javafx.fxml.FXML
    private ComboBox deliveryOrderIdComboBox;
    @javafx.fxml.FXML
    private TableColumn customerColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private DatePicker completedDateDatePicker;
    @javafx.fxml.FXML
    private TableView activeDeliveriesTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void completeDeliveryOnMouseClick(ActionEvent actionEvent) {
    }
}