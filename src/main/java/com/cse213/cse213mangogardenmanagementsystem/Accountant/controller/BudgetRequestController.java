package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.BudgetRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BudgetRequestController
{
    @FXML private TextArea txtPurpose;
    @FXML private TextField txtAmount;
    @FXML private Label lblValidationError;
    @FXML private ComboBox<String> cmbBudgetType;

    @FXML
    public void initialize() {
        cmbBudgetType.getItems().addAll("Tool Procurement", "Vehicle Maintenance", "Capital Investment", "Operational Funds");
    }

    @FXML
    public void handleAttachDocuments(ActionEvent actionEvent) {
        System.out.println("Simulating file dialog opening for document attachment...");
        lblValidationError.setText("Document attached successfully (Simulated).");
    }

    @FXML
    public void handleSubmitRequest(ActionEvent actionEvent) {
        try {
            double amount = Double.parseDouble(txtAmount.getText().trim());
            String purpose = txtPurpose.getText().trim();
            String category = cmbBudgetType.getValue();

            if (category == null || purpose.isEmpty() || amount <= 0) {
                lblValidationError.setText("Validation Error: All fields must be filled, and amount must be positive.");
                return;
            }

            BudgetRequest newRequest = Accountant.submitBudgetRequest(category, amount, purpose);

            lblValidationError.setText("Success! Request ID " + newRequest.getId() + " submitted to General Manager.");
            txtAmount.clear();
            txtPurpose.clear();
            cmbBudgetType.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            lblValidationError.setText("Input Error: Amount must be a valid number.");
        }
    }
}