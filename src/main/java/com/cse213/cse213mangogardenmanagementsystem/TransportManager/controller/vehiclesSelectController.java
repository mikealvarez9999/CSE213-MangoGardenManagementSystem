package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class vehiclesSelectController
{
    @javafx.fxml.FXML
    private TableColumn capacityColumn;
    @javafx.fxml.FXML
    private TableView assignVehiclesTableView;
    @javafx.fxml.FXML
    private TableColumn availabilityColumn;
    @javafx.fxml.FXML
    private ComboBox vehicleIdComboBox;
    @javafx.fxml.FXML
    private TableColumn driverColumn;
    @javafx.fxml.FXML
    private Label mangoQuantityLabel;
    @javafx.fxml.FXML
    private TableColumn typeColumn;
    @javafx.fxml.FXML
    private TableColumn vehicleIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assignVehicleOnMouseClick(ActionEvent actionEvent) {
    }
}