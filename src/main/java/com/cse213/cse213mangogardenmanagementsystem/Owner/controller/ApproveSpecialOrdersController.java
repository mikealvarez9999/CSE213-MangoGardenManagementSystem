package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.SpecialOrder;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ApproveSpecialOrdersController {
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, Double> amountTC;
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, String> isApprovedTC;
    @javafx.fxml.FXML
    private TableView<SpecialOrder> specialOrdersTV;
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, Integer> orderIDTC;
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, Integer> quantityTC;
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, String> customerIDTC;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private ComboBox<String> actionCB;
    @javafx.fxml.FXML
    private TableColumn<SpecialOrder, LocalDate> dateTC;

    @javafx.fxml.FXML
    public void initialize(){
        amountTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, Double>("orderAmount"));
        isApprovedTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, String>("status"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, Integer>("quantity"));
        dateTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, LocalDate>("date"));
        customerIDTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, String>("phoneNum"));
        orderIDTC.setCellValueFactory(new PropertyValueFactory<SpecialOrder, Integer>("orderID"));

        specialOrdersTV.setItems(Owner.loadAllSpecialOrders());
    }

    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {
        SpecialOrder selectedOrder = specialOrdersTV.getSelectionModel().getSelectedItem();
        if ((selectedOrder != null) && (actionCB.getValue() != null)){
            selectedOrder.setStatus(actionCB.getValue());
            if (Owner.approveRejectSpecialOrder(selectedOrder)){
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #51AB19;");
                successLabel.setText("Special Order #" + selectedOrder.getOrderID() + " has been " + actionCB.getValue() + " successfully");
            } else {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("There has been an error.");
            }
        } else {
            successLabel.setText(null);
            successLabel.setStyle("-fx-text-fill: #FF0000;");
            successLabel.setText("Select a request and an action.");
        }
    }
}
