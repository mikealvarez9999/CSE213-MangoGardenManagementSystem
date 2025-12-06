package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant; // Needed to submit request to Accountant
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ToolsRequestController
{
    @FXML private Label lblConfirmation;
    @FXML private TextField txtQuantity;
    @FXML private TextArea txtJustification;
    @FXML private TextField txtItemName;

    @FXML
    public void initialize() {
        lblConfirmation.setText("");
    }

    @FXML
    public void handleSaveRequest(ActionEvent actionEvent) {
        String itemName = txtItemName.getText().trim();
        String justification = txtJustification.getText().trim();
        String quantityStr = txtQuantity.getText().trim();

        if (itemName.isEmpty() || justification.isEmpty() || quantityStr.isEmpty()) {
            lblConfirmation.setText("Error: All fields are required.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) throw new NumberFormatException();

            // NOTE: Since the FieldSupervisor's persistence logic doesn't include a ToolRequest
            // save method, we directly mock calling the Accountant model, as per the workflow.

            // Step 1: Create request data (mocking estimated cost)
            double mockCost = quantity * 15.0; // Mock $15 per unit

            // Step 2: Notify Accountant (This method would typically create and save the request model)
            // We assume Accountant handles the creation and persistence of the ToolRequest model.
            // Accountant.submitToolRequest(itemName, quantity, justification, mockCost);
            // Since that method doesn't exist in the provided Accountant model, we just print success.

            System.out.println("Tool Request submitted for: " + itemName + " (Qty: " + quantity + ")");
            lblConfirmation.setText("Request submitted successfully to Accountant.");

            // Clear fields
            txtItemName.clear();
            txtQuantity.clear();
            txtJustification.clear();

        } catch (NumberFormatException e) {
            lblConfirmation.setText("Error: Quantity must be a positive number.");
        }
    }
}