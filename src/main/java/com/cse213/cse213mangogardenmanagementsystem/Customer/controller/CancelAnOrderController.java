package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Customer;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CancelAnOrderController {
    @javafx.fxml.FXML
    private TextArea detailsTextArea;
    @javafx.fxml.FXML
    private Button checkOrderButton;
    @javafx.fxml.FXML
    private Button cancelOrderButton;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    @javafx.fxml.FXML
    private Label cancelOrderLabel;
    @javafx.fxml.FXML
    private ComboBox<String> orderIdComboBox;

    private ArrayList<Order> allOrders;
    @javafx.fxml.FXML
    public void initialize(){
        orderIdComboBox.getItems().addAll("Order1","Order2","Order3");

    }

    @javafx.fxml.FXML
    public void checkOrderButtonOnAction(ActionEvent actionEvent) {
        String OrderId = orderIdComboBox.getId();
        if (OrderId == null) {
            orderStatusLabel.setText("Please Select an Order ID");
            detailsTextArea.clear();
            return;
        }
        if (OrderId != null) {
            Order selectedOrder = findOrderById(OrderId); // helper method
            if (selectedOrder != null) {
                detailsTextArea.setText("Order ID Found");
                orderStatusLabel.setText("Order Status: ");
            } else {
                detailsTextArea.clear();
                orderStatusLabel.setText("Order not found.");
            }
        } else {
            detailsTextArea.clear();
            orderStatusLabel.setText("Please select an Order ID.");
        }



    }

    @javafx.fxml.FXML
    public void cancelOrderButtonOnAction(ActionEvent actionEvent) {
        String OrderID = orderIdComboBox.getId();
        if (OrderID == null) {
            cancelOrderLabel.setText("Please select an order ID to cancel.");
            return;
        }
        Order selectedOrder = findOrderById(OrderID);
        if (selectedOrder != null) {
            if (selectedOrder.getType().equalsIgnoreCase("Cancelled")) {
                cancelOrderLabel.setText("Order is already cancelled.");
                return;
            }
            cancelOrderLabel.setText("Order cancelled successfully.");
            orderStatusLabel.setText("Order Status: Cancelled");
            detailsTextArea.setText("Order Cancel");
        } else {
            cancelOrderLabel.setText("Order not found.");
        }
    }
    private Order findOrderById(String orderId) {
        int id = Integer.parseInt(orderId); // convert String to int
        for (Order order : allOrders) {
            if (order.getOrderID() == id) { // compare primitive ints
                return order;
            }
        }
        return null;
    }
}
