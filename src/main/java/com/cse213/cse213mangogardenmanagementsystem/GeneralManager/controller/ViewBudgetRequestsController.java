package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.BudgetRequest;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewBudgetRequestsController {
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, Double> amountTC;
    @javafx.fxml.FXML
    private TableView<BudgetRequest> budgetRequestsTV;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> purposeTC;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, Integer> requestIDTC;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> categoryTC;

    @javafx.fxml.FXML
    public void initialize(){
        ObservableList<BudgetRequest> budgetRequests = GeneralManager.loadBudgetRequests();
        amountTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, Double>("amount"));
        purposeTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, String>("purpose"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, String>("category"));
        statusTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, String>("status"));
        requestIDTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, Integer>("id"));
        budgetRequestsTV.getItems().addAll(budgetRequests);
    }
}
