package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.VehicleMaintRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProcessVehicleRequestController
{
    @FXML private TableView<VehicleMaintRequest> maintenanceTable;

    @FXML
    public void initialize() {
         maintenanceTable.setItems(Accountant.getAllVehicleMaintRequest());
    }

    @FXML
    public void handleRejectMaintenance(ActionEvent actionEvent) {
        VehicleMaintRequest selected = maintenanceTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("No maintenance request selected.");
            return;
        }

        selected.setStatus("Rejected");
        System.out.println("Maintenance Request ID " + selected.getId() + " rejected.");
        maintenanceTable.refresh();
    }

    @FXML
    public void handleApproveMaintenance(ActionEvent actionEvent) {
        VehicleMaintRequest selected = maintenanceTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("No maintenance request selected.");
            return;
        }

        if (Accountant.approveVehicleMaintRequest(selected.getId())) {
            System.out.println("Maintenance Request ID " + selected.getId() + " approved and budget submitted.");
            maintenanceTable.refresh();
        } else {
            System.err.println("Approval failed.");
        }
    }
}