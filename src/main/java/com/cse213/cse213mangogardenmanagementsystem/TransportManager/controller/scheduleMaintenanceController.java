package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.TransportManager;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Vehicles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class scheduleMaintenanceController {

    @FXML
    private TableView<Vehicles> scheduleMaintenanceTableView;
    @FXML
    private TableColumn<Vehicles, String> vehicleIDColumn;
    @FXML
    private TableColumn<Vehicles, String> typeColumn;
    @FXML
    private TableColumn<Vehicles, String> availabilityColumn;
    @FXML
    private TableColumn<Vehicles, Number> capacityColumn;
    @FXML
    private TableColumn<Vehicles, String> MaintenanceDateColumn;

    @FXML
    private ComboBox<String> selectedVehicleIdComboBox;
    @FXML
    private DatePicker MaintenanceDateDatePicker;

    private ObservableList<Vehicles> vehicleData;
    private TransportManager manager = new TransportManager();

    @FXML
    public void initialize() {

        vehicleData = FXCollections.observableArrayList(manager.getVehicleList());

        vehicleIDColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getVehicleID()));
        typeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getVehicleType()));
        availabilityColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAvailability()));
        capacityColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getCapacity()));
        MaintenanceDateColumn.setCellValueFactory(data -> {
            LocalDate date = data.getValue().getMaintenanceDate();
            return new javafx.beans.property.SimpleStringProperty(date == null ? "Not Set" : date.toString());
        });

        scheduleMaintenanceTableView.setItems(vehicleData);

        for (Vehicles v : vehicleData) {
            selectedVehicleIdComboBox.getItems().add(v.getVehicleID());
        }
    }

    @FXML
    public void saveMaintenanceOnMouseClick(ActionEvent event) {

        String selectedID = selectedVehicleIdComboBox.getValue();
        LocalDate selectedDate = MaintenanceDateDatePicker.getValue();

        if (selectedID == null || selectedDate == null) {
            showAlert("Error", "Please select Vehicle ID and Maintenance Date");
            return;
        }

        manager.updateMaintenanceDate(selectedID, selectedDate);

        for (Vehicles v : vehicleData) {
            if (v.getVehicleID().equals(selectedID)) {
                v.setMaintenanceDate(selectedDate);
                break;
            }
        }

        scheduleMaintenanceTableView.refresh();
        showAlert("Success", "Maintenance date updated successfully.");
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}