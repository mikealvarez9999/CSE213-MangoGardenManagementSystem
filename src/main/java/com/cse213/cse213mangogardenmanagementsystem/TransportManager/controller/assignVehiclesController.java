package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.orders;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.TransportManager;
import com.cse213.cse213mangogardenmanagementsystem.TransportManager.model.Vehicles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class assignVehiclesController {

    @FXML private TableView<Vehicles> assignVehiclesTableView;
    @FXML private TableColumn<Vehicles, String> vehicleIdColumn;
    @FXML private TableColumn<Vehicles, String> typeColumn;
    @FXML private TableColumn<Vehicles, Number> capacityColumn;
    @FXML private TableColumn<Vehicles, String> availabilityColumn;
    @FXML private ComboBox<String> vehicleIdComboBox;

    @FXML private TableView<Order> orderListForVehiclesTableView;
    @FXML private TableColumn<orders, String> orderIdColumn;
    @FXML private TableColumn<orders, Number> mangoQuantityColumn;
    @FXML private TableColumn<orders, String> addressColumn;
    @FXML private ComboBox<String> orderIDComboBox;

    private ObservableList<Vehicles> vehicleData;
    private ObservableList<Order> orderData;

//    private TransportManager manager = new TransportManager();

    @FXML
    public void initialize() {

        vehicleIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        vehicleData = FXCollections.observableArrayList(TransportManager.getVehicleList());
        assignVehiclesTableView.setItems(vehicleData);

        for (Vehicles v : vehicleData) {
            vehicleIdComboBox.getItems().add(v.getVehicleID());
        }

        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        mangoQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        orderData = FXCollections.observableArrayList(TransportManager.getOrderList());
        orderListForVehiclesTableView.setItems(orderData);

        for (Order o : orderData) {
            orderIDComboBox.getItems().add(String.valueOf( o.getOrderID()));
        }
    }

    @FXML
    public void assignVehicleOnMouseClick(ActionEvent actionEvent) {
        String selectedVehicleID = vehicleIdComboBox.getValue();
        String selectedOrderID = orderIDComboBox.getValue();

        if (selectedVehicleID == null || selectedOrderID == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select both Vehicle and Order!");
            alert.show();
            return;
        }


        for (Vehicles v : vehicleData) {
            if (v.getVehicleID().equals(selectedVehicleID)) {
                v.setAvailability("Unavailable");
                break;
            }
        }

        assignVehiclesTableView.refresh();
        vehicleIdComboBox.setValue(null);
        orderIDComboBox.setValue(null);

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Vehicle " + selectedVehicleID + " assigned to Order " + selectedOrderID + " successfully!");
        alert.show();
    }
}
