package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;
import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.ToolRequest;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class RequestToolsController {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TextField toolNameTextField;
    @FXML
    private Button submitReqButton;
    @FXML
    private TextField quantityTextField;
    @FXML
    private Label requestToolsLabel;

    private ObservableList<ToolRequest> requestList;

    @FXML
    public void initialize() {
        // Load existing requests
        requestList = GardenWorker.getToolRequests();
    }

    @FXML
    public void submitReqButtonOnAction(ActionEvent actionEvent) {
        String toolName = toolNameTextField.getText();
        String qtyText = quantityTextField.getText();
        LocalDate date = dateDatePicker.getValue();

        if (toolName.isEmpty() || qtyText.isEmpty() || date == null) {
            requestToolsLabel.setText("Please fill all fields!");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(qtyText);
        } catch (NumberFormatException e) {
            requestToolsLabel.setText("Quantity must be a number!");
            return;
        }

        ToolRequest req = new ToolRequest(toolName, quantity, date);
        requestList.add(req);

        GardenWorker.saveToolRequests(requestList);

        requestToolsLabel.setText("Tool request submitted successfully!");

        // Clear fields
        toolNameTextField.clear();
        quantityTextField.clear();
        dateDatePicker.setValue(null);
    }
}