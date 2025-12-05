package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewOrderHistoryController {

    @FXML
    private DatePicker orderDateDatePicker;
    @FXML
    private TextField orderIDTextField;
    @FXML
    private Button FilterButton;

    @FXML
    private TableView<OrderHistoryDemo> orderHistoryTableView;
    @FXML
    private TableColumn<OrderHistoryDemo, String> orderDateColumn;
    @FXML
    private TableColumn<OrderHistoryDemo, String> orderIDColumn;
    @FXML
    private TableColumn<OrderHistoryDemo, String> orderStatusColumn;
    @FXML
    private TableColumn<OrderHistoryDemo, String> totalAmountColumn;

    // List to store demo history
    private ObservableList<OrderHistoryDemo> orderHistoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Table column mappings
        orderDateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("orderDate"));
        orderIDColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("orderId"));
        orderStatusColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("orderStatus"));
        totalAmountColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("totalAmount"));

        // Demo data
        orderHistoryList.addAll(
                new OrderHistoryDemo("2025-01-10", "ORD001", "Delivered", "1500"),
                new OrderHistoryDemo("2025-01-12", "ORD002", "Pending", "1800"),
                new OrderHistoryDemo("2025-01-15", "ORD003", "Cancelled", "0")
        );

        orderHistoryTableView.setItems(orderHistoryList);
    }

    @FXML
    public void FilterButtonOnAction(ActionEvent actionEvent) {

        String enteredOrderID = orderIDTextField.getText();
        String selectedDate = (orderDateDatePicker.getValue() != null)
                ? orderDateDatePicker.getValue().toString()
                : null;

        ObservableList<OrderHistoryDemo> filteredList = FXCollections.observableArrayList();

        for (OrderHistoryDemo order : orderHistoryList) {

            boolean matchID = true;
            boolean matchDate = true;

            if (enteredOrderID != null && !enteredOrderID.isEmpty()) {
                matchID = order.getOrderId().equalsIgnoreCase(enteredOrderID);
            }

            if (selectedDate != null) {
                matchDate = order.getOrderDate().equals(selectedDate);
            }

            if (matchID && matchDate) {
                filteredList.add(order);
            }
        }

        orderHistoryTableView.setItems(filteredList);
    }

    // Inner demo class for table data
    public static class OrderHistoryDemo {
        private String orderDate;
        private String orderId;
        private String orderStatus;
        private String totalAmount;

        public OrderHistoryDemo(String orderDate, String orderId, String orderStatus, String totalAmount) {
            this.orderDate = orderDate;
            this.orderId = orderId;
            this.orderStatus = orderStatus;
            this.totalAmount = totalAmount;
        }

        public String getOrderDate() { return orderDate; }
        public String getOrderId() { return orderId; }
        public String getOrderStatus() { return orderStatus; }
        public String getTotalAmount() { return totalAmount; }
    }
}
