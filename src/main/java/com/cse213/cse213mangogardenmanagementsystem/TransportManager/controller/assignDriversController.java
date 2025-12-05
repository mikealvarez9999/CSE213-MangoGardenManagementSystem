package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Drivers;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.TransportManager;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Vehicles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class assignDriversController {

    @FXML private TableView<Drivers> driverDetailsTableView;
    @FXML private TableColumn<Drivers, String> driverIdColumn;
    @FXML private TableColumn<Drivers, String> nameColumn;
    @FXML private TableColumn<Drivers, String> licenseTypeColumn;
    @FXML private TableColumn<Drivers, String> availabilityforDriverColumn;

    @FXML private TableView<Vehicles> vehicledetailsTableView;
    @FXML private TableColumn<Vehicles, String> VehicleIdColumn;
    @FXML private TableColumn<Vehicles, String> typeColumn;
    @FXML private TableColumn<Vehicles, Number> capacityColumn;
    @FXML private TableColumn<Vehicles, String> availabilityColumn;

    @FXML private ComboBox<String> selectedDriverIdComboBox;
    @FXML private ComboBox<String> selectedVehicleIdComboBox;

    private ObservableList<Drivers> driverData;
    private ObservableList<Vehicles> vehicleData;

    private TransportManager manager = new TransportManager();

    @FXML
    public void initialize() {

        driverData = FXCollections.observableArrayList(manager.getDriverList());
        driverIdColumn.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getDriverID()));
        nameColumn.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getDriverName()));
        licenseTypeColumn.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getLicenseType()));
        availabilityforDriverColumn.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getAvailability()));
        driverDetailsTableView.setItems(driverData);

        for (Drivers d : driverData) {
            selectedDriverIdComboBox.getItems().add(d.getDriverID());
        }

        vehicleData = FXCollections.observableArrayList(manager.getVehicleList());
        VehicleIdColumn.setCellValueFactory(v -> new javafx.beans.property.SimpleStringProperty(v.getValue().getVehicleID()));
        typeColumn.setCellValueFactory(v -> new javafx.beans.property.SimpleStringProperty(v.getValue().getVehicleType()));
        capacityColumn.setCellValueFactory(v -> new javafx.beans.property.SimpleDoubleProperty(v.getValue().getCapacity()));
        availabilityColumn.setCellValueFactory(v -> new javafx.beans.property.SimpleStringProperty(v.getValue().getAvailability()));
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
            showAlert("Error", "Please select both Driver and Vehicle!");
            return;
        }

        manager.assignDriverToVehicle(driverID, vehicleID);

        // Update local table data
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

        showAlert("Success", "Driver assigned to Vehicle successfully!");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}