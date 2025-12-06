package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Drivers;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.TransportManager;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Vehicles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class assignDriversController {

    @FXML private TableView<Drivers> driverDetailsTableView;
    @FXML private TableColumn<Drivers, String> driverIdColumn;
    @FXML private TableColumn<Drivers, String> nameColumn;
    @FXML private TableColumn<Drivers, String> licenseTypeColumn;
    @FXML private TableColumn<Drivers, String> availabilityforDriverColumn;

    @FXML private TableView<Vehicles> vehicledetailsTableView;
    @FXML private TableColumn<Vehicles, String> VehicleIdColumn;
    @FXML private TableColumn<Vehicles, String> typeColumn;
    @FXML private TableColumn<Vehicles, Double> capacityColumn;
    @FXML private TableColumn<Vehicles, String> availabilityColumn;

    @FXML private ComboBox<String> selectedDriverIdComboBox;
    @FXML private ComboBox<String> selectedVehicleIdComboBox;

    private ObservableList<Drivers> driverData;
    private ObservableList<Vehicles> vehicleData;

    private TransportManager manager = new TransportManager();

    @FXML
    public void initialize() {

        driverIdColumn.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        licenseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("licenseType"));
        availabilityforDriverColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        driverData = FXCollections.observableArrayList(manager.getDriverList());
        driverDetailsTableView.setItems(driverData);

        for (Drivers d : driverData) {
            selectedDriverIdComboBox.getItems().add(d.getDriverID());
        }

        VehicleIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        vehicleData = FXCollections.observableArrayList(manager.getVehicleList());
        vehicledetailsTableView.setItems(vehicleData);

        for (Vehicles v : vehicleData) {
            selectedVehicleIdComboBox.getItems().add(v.getVehicleID());
        }
    }

    @FXML
    public void assignDriverOnMouseClick(ActionEvent event) {

        String driverID = selectedDriverIdComboBox.getValue();
        String vehicleID = selectedVehicleIdComboBox.getValue();

        if (driverID == null || vehicleID == null) {
            return;
        }

        manager.assignDriverToVehicle(driverID, vehicleID);

        for (Drivers d : driverData) {
            if (d.getDriverID().equals(driverID)) {
                d.setAvailability("Unavailable");
                break;
            }
        }

        for (Vehicles v : vehicleData) {
            if (v.getVehicleID().equals(vehicleID)) {
                v.setAvailability("Unavailable");
                break;
            }
        }

        driverDetailsTableView.refresh();
        vehicledetailsTableView.refresh();
        selectedDriverIdComboBox.setValue(null);
        selectedVehicleIdComboBox.setValue(null);
    }
}
