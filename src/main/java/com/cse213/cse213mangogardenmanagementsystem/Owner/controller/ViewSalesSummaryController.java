package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewSalesSummaryController {
    @javafx.fxml.FXML
    private TableColumn<Order, Double> amountTC;
    @javafx.fxml.FXML
    private TableView<Order> ordersTV;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> orderIDTC;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> quantityTC;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> customerIDTC;
    @javafx.fxml.FXML
    private TableColumn<Order, String> mangoTypeTC;

    @javafx.fxml.FXML
    public void initialize(){
        orderIDTC.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderId"));
        amountTC.setCellValueFactory(new PropertyValueFactory<Order, Double>("amount"));
        mangoTypeTC.setCellValueFactory(new PropertyValueFactory<Order, String>("mangoType"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
        statusTC.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        customerIDTC.setCellValueFactory(new PropertyValueFactory<Order, Integer>("customerId"));

        ordersTV.setItems(Owner.loadAllOrders());
    }
}
