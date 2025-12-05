package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ApproveRejectBudgetRequestsController {
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, Double> amountTC;
    @javafx.fxml.FXML
    private TableView<BudgetRequest> budgetRequestsTV;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> purposeTC;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private ComboBox<String> actionCB;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, Integer> requestIDTC;
    @javafx.fxml.FXML
    private TableColumn<BudgetRequest, String> categoryTC;

    @javafx.fxml.FXML
    public void initialize(){
        actionCB.getItems().addAll("Accept", "Reject");
        ObservableList<BudgetRequest> budgetRequests = GeneralManager.loadBudgetRequests();
        amountTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, Double>("amount"));
        purposeTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, String>("purpose"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, Accountant>("category"));
        statusTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, String>("status"));
        requestIDTC.setCellValueFactory(new PropertyValueFactory<BudgetRequest, Integer>("id"));
        budgetRequestsTV.getItems().addAll(budgetRequests);
    }

    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<BudgetRequest> selectionModel = budgetRequestsTV.getSelectionModel();
        BudgetRequest selectedBudgetRequest = selectionModel.getSelectedItem();

        if (selectedBudgetRequest != null){
            if (actionCB.getValue() != null) {
                selectedBudgetRequest.setStatus(actionCB.getValue());
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #16BC00;");
                successLabel.setText("Action applied to Request ID: " + selectedBudgetRequest.getId() + " successfully!");
            } else {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("Select an action!");
            }
        } else {
            successLabel.setText(null);
            successLabel.setStyle("-fx-text-fill: #FF0000;");
            successLabel.setText("No budget request selected!");
        }
    }
}
