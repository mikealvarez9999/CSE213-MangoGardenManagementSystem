package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class scheduleMaintenanceController
{
    @javafx.fxml.FXML
    private TableColumn capacityColumn;
    @javafx.fxml.FXML
    private ComboBox selectedVehicleIdConboBox;
    @javafx.fxml.FXML
    private DatePicker MaintenanceDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn vehicleIDColumn;
    @javafx.fxml.FXML
    private TableColumn availabilityColumn;
    @javafx.fxml.FXML
    private TableColumn lastMaintenanceColumn;
    @javafx.fxml.FXML
    private TableColumn typeColumn;
    @javafx.fxml.FXML
    private TableView scheduleMaintenanceTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveMaintenanceOnMouseClick(ActionEvent actionEvent) {
    }
}