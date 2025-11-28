package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class UpdateTransactionController
{
    @javafx.fxml.FXML
    private TableView transactionTable;
    @javafx.fxml.FXML
    private DatePicker dateEditDate;
    @javafx.fxml.FXML
    private TextArea txtEditDescription;
    @javafx.fxml.FXML
    private TextField txtEditAmount;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSaveChanges(ActionEvent actionEvent) {
    }
}