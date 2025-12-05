package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Transaction;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class UpdateTransactionController {
    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private DatePicker dateEditDate;
    @FXML
    private TextArea txtEditDescription;
    @FXML
    private TextField txtEditAmount;

    private Transaction selectedTransaction;

    @FXML
    private TableColumn<Transaction, Double> colAmount;
    @FXML
    private TableColumn<Transaction, String> colType;
    @FXML
    private TableColumn<Transaction, String> colDescription;
    @FXML
    private TableColumn<Transaction, LocalDate> colDate;
    @FXML
    private TableColumn<Transaction, String> colCategory;
    @FXML
    private TableColumn<Transaction, Integer> colId;


    @FXML
    public void initialize() {

        ObservableList<Transaction> allTransaction = Accountant.getAllTransactions();

        if (colId != null) colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colDate != null) colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        if (colDescription != null) colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        if (colCategory != null) colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        if (colType != null) colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        if (colAmount != null) colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        transactionTable.setItems(allTransaction);

        transactionTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedTransaction = newSelection;
                txtEditAmount.setText(String.valueOf(selectedTransaction.getAmount()));
                dateEditDate.setValue(selectedTransaction.getDate());
                txtEditDescription.setText(selectedTransaction.getDescription());
            }
        });
    }

    @FXML
    public void handleSaveChanges(ActionEvent actionEvent) {
        if (selectedTransaction == null) {
            System.err.println("Error: No transaction selected for editing.");
            return;
        }

        try {
            double newAmount = Double.parseDouble(txtEditAmount.getText().trim());
            String newDescription = txtEditDescription.getText().trim();
            LocalDate newDate = dateEditDate.getValue();

            boolean success = Accountant.updateTransaction(
                    selectedTransaction,
                    newAmount,
                    selectedTransaction.getType(),
                    selectedTransaction.getCategory(),
                    newDate,
                    newDescription
            );

            if (success) {
                System.out.println("Transaction ID " + selectedTransaction.getId() + " updated successfully.");
                // Refresh the table view to show changes
                transactionTable.refresh();
            } else {
                System.err.println("Update failed at model level.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Input Error: Amount must be a valid number.");
        }
    }
}