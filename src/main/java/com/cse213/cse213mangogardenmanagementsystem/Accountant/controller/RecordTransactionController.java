package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class RecordTransactionController
{
    @FXML private ComboBox<String> cmbCategory;
    @FXML private ComboBox<String> cmbType;
    @FXML private TextArea txtDescription;
    @FXML private TextField txtAmount;
    @FXML private DatePicker dateDate;

    @FXML
    public void initialize() {
        cmbType.getItems().addAll("Income", "Expense");
        cmbCategory.getItems().addAll("Harvest Sales", "Payroll", "Tool Purchase", "Vehicle Maintenance", "Other");
        dateDate.setValue(LocalDate.now());
    }

    @FXML
    public void btnSave(ActionEvent actionEvent) {
        try {
            double amount = Double.parseDouble(txtAmount.getText().trim());
            String type = cmbType.getValue();
            String category = cmbCategory.getValue();
            LocalDate date = dateDate.getValue();

            if (type == null || category == null || date == null || amount <= 0) {
                System.err.println("Validation Error: Please select Type, Category, Date, and enter a positive Amount.");
                return;
            }

            Transaction newTransaction = Accountant.recordTransaction(amount, type, category, date);

            System.out.println("Controller: Transaction recorded successfully. ID: " + newTransaction.getId());

            txtAmount.clear();
            txtDescription.clear();
            dateDate.setValue(LocalDate.now());

        } catch (NumberFormatException e) {
            System.err.println("Input Error: Amount must be a valid number.");
        }
    }
}