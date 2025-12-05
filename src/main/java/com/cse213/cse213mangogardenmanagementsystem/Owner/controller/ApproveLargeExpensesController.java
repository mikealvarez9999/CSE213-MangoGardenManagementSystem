package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ApproveLargeExpensesController {
    @javafx.fxml.FXML
    private TableView<LargeExpenseRequest> largeExpensesTV;
    @javafx.fxml.FXML
    private TableColumn<LargeExpenseRequest, Double> amountTC;
    @javafx.fxml.FXML
    private TableColumn<LargeExpenseRequest, String> reasonTC;
    @javafx.fxml.FXML
    private TableColumn<LargeExpenseRequest, String> transactionIDTC;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private ComboBox<String> actionCB;
    @javafx.fxml.FXML
    private TableColumn<LargeExpenseRequest, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<LargeExpenseRequest, LocalDate> dateTC;

    @javafx.fxml.FXML
    public void initialize(){
        actionCB.getItems().addAll("Approve", "Reject");
        amountTC.setCellValueFactory(new PropertyValueFactory<LargeExpenseRequest, Double>("amount"));
        dateTC.setCellValueFactory(new PropertyValueFactory<LargeExpenseRequest, LocalDate>("date"));
        reasonTC.setCellValueFactory(new PropertyValueFactory<LargeExpenseRequest, String>("description"));
        statusTC.setCellValueFactory(new PropertyValueFactory<LargeExpenseRequest, String>("status"));
        transactionIDTC.setCellValueFactory(new PropertyValueFactory<LargeExpenseRequest, Integer>("id"));

        largeExpensesTV.setItems(Owner.loadAllLargeExpenseRequests());
    }

    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {
    }
}
