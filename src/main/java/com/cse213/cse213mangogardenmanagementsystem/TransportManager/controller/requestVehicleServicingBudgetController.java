package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.TransportManager;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Vehicles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class requestVehicleServicingBudgetController {

    @FXML private TableView<Vehicles> serviceBudgetTableView;
    @FXML private TableColumn<Vehicles, String> vehicleIdColumn;
    @FXML private TableColumn<Vehicles, String> typeColumn;
    @FXML private TableColumn<Vehicles, Number> capacityColumn;
    @FXML private TableColumn<Vehicles, String> MaintenanceDateColumn;

    @FXML private ComboBox<String> vehicleIdComboBox;
    @FXML private TextField costTextField;
    @FXML private Label notelabel;

    private ObservableList<Vehicles> vehicleData;
//    private TransportManager manager = new TransportManager();

    @FXML
    public void initialize() {

        vehicleIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        MaintenanceDateColumn.setCellValueFactory(v ->
                new javafx.beans.property.SimpleStringProperty(
                        v.getValue().getMaintenanceDate() == null ?
                                "Not Set" :
                                v.getValue().getMaintenanceDate().toString()
                )
        );

        // Load vehicle list
        vehicleData = FXCollections.observableArrayList(TransportManager.getVehicleList());
        serviceBudgetTableView.setItems(vehicleData);

        // Fill ComboBox
        for (Vehicles v : vehicleData) {
            vehicleIdComboBox.getItems().add(v.getVehicleID());
        }
    }

    @FXML
    public void submitRequestForAccountantOnMouseClick(ActionEvent event) {
        String selectedVehicleID = vehicleIdComboBox.getValue();
        String costText = costTextField.getText();

        if (selectedVehicleID == null || costText.isEmpty()) {
            showAlert("Error", "Please select Vehicle ID and enter the Cost!");
            return;
        }

        try {
            double cost = Double.parseDouble(costText);
            notelabel.setText("Request submitted for Vehicle ");
            costTextField.clear();
            vehicleIdComboBox.setValue(null);
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for cost!");
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
