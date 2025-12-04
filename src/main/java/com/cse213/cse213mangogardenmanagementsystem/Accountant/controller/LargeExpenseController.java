package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.LargeExpenseRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class LargeExpenseController
{
    @FXML private TextField txtExpenseAmount;
    @FXML private TextArea txtJustification;
    @FXML private TextField txtItemName;
    @FXML private Label lblValidationError;


    @FXML
    public void initialize() {
        lblValidationError.setText("");
    }

    @FXML
    public void handleSubmitForApproval(ActionEvent actionEvent) {
        try {
            double amount = Double.parseDouble(txtExpenseAmount.getText().trim());
            String itemName = txtItemName.getText().trim();
            String justification = txtJustification.getText().trim();
            LocalDate date = LocalDate.now();

            if (itemName.isEmpty() || justification.isEmpty() || amount <= 0) {
                lblValidationError.setText("Validation Error: Item name, justification, and positive amount are required.");
                return;
            }

            LargeExpenseRequest newRequest = Accountant.submitLargeExpenseRequest(date, amount, justification);

            lblValidationError.setText("Success! Large expense request ID " + newRequest.getId() + " submitted to Owner.");

            txtExpenseAmount.clear();
            txtItemName.clear();
            txtJustification.clear();

        } catch (NumberFormatException e) {
            lblValidationError.setText("Input Error: Expense amount must be a valid number.");
        }
    }
}