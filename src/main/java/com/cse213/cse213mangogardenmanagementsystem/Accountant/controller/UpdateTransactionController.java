package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class UpdateTransactionController
{
    @FXML private TableView<Transaction> transactionTable;
    @FXML private DatePicker dateEditDate;
    @FXML private TextArea txtEditDescription;
    @FXML private TextField txtEditAmount;

    private Transaction selectedTransaction;

    @FXML
    public void initialize() {

        TableColumn<Transaction, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Transaction, Double> amountCol = new TableColumn<>("Amount");
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Transaction, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, Integer> fxmlIdCol = (TableColumn<Transaction, Integer>) transactionTable.getColumns().get(0);
        fxmlIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, LocalDate> fxmlDateCol = (TableColumn<Transaction, LocalDate>) transactionTable.getColumns().get(1);
        fxmlDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, String> fxmlDescriptionCol = (TableColumn<Transaction, String>) transactionTable.getColumns().get(2);
        fxmlDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, String> fxmlCategoryCol = (TableColumn<Transaction, String>) transactionTable.getColumns().get(3);
        fxmlCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, String> fxmlTypeCol = (TableColumn<Transaction, String>) transactionTable.getColumns().get(4);
        fxmlTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        @SuppressWarnings("unchecked")
        TableColumn<Transaction, Double> fxmlAmountCol = (TableColumn<Transaction, Double>) transactionTable.getColumns().get(5);
        fxmlAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Load data into TableView
        transactionTable.setItems(Accountant.getAllTransactions());

        // Listener to populate edit fields when a row is selected
        transactionTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedTransaction = newSelection;
                txtEditAmount.setText(String.valueOf(selectedTransaction.getAmount()));
                dateEditDate.setValue(selectedTransaction.getDate());
                // Ensure text fields are updated if FXML contains them
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
            LocalDate newDate = dateEditDate.getValue();

            boolean success = Accountant.updateTransaction(
                    selectedTransaction,
                    newAmount,
                    selectedTransaction.getType(),
                    selectedTransaction.getCategory(),
                    newDate
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