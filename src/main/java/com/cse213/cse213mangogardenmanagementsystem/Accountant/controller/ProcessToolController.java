package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.ToolRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProcessToolController
{
    @FXML private TableView<ToolRequest> requestTable;

    @FXML
    public void initialize() {
         requestTable.setItems(Accountant.getAllToolRequests());
    }

    @FXML
    public void handleRejectRequest(ActionEvent actionEvent) {
        ToolRequest selected = requestTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("No request selected.");
            return;
        }

        selected.setStatus("Rejected");
        System.out.println("Request ID " + selected.getId() + " rejected.");
        requestTable.refresh();
    }

    @FXML
    public void handleApproveRequest(ActionEvent actionEvent) {
        ToolRequest selected = requestTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("No request selected.");
            return;
        }

        if (Accountant.approveToolRequest(selected.getId())) {
            System.out.println("Request ID " + selected.getId() + " approved and budget submitted.");
            requestTable.refresh();
        } else {
            System.err.println("Approval failed.");
        }
    }
}