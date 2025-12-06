package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TrackAnOrderController {


    @FXML
    private ComboBox<String> orderIdComboBox;
    @FXML
    private Button trackOrderButton;
    @FXML
    private TextArea orderDataTextArea;

    @FXML
    private TableView<OrderTrackDemo> trackOrderTableView;
    @FXML
    private TableColumn<OrderTrackDemo, String> statusColumn;
    @FXML
    private TableColumn<OrderTrackDemo, String> locationColumn;
    @FXML
    private TableColumn<OrderTrackDemo, String> deliveryProgressColumn;

    @FXML
    private Label trackAnOrderLabel;

    private ObservableList<OrderTrackDemo> orderTrackingList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // ComboBox demo IDs
        orderIdComboBox.getItems().addAll("ORD001", "ORD002", "ORD003");

        // Map columns
        statusColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));
        locationColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("location"));
        deliveryProgressColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("deliveryProgress"));

        // Demo tracking data
        orderTrackingList.addAll(
                new OrderTrackDemo("Shipped", "Dhaka Warehouse", "40%"),
                new OrderTrackDemo("Out for Delivery", "Uttara Sector-10", "90%"),
                new OrderTrackDemo("Delivered", "Customer Address", "100%")
        );

        trackOrderTableView.setItems(orderTrackingList);
    }

    @FXML
    public void trackOrderButtonOnAction(ActionEvent event) {

        String selectedOrderID = orderIdComboBox.getValue();

        if (selectedOrderID == null) {
            orderDataTextArea.setText("Please select an Order ID.");
            return;
        }

        // Demo order details (you can later attach your real data here)
        orderDataTextArea.setText(
                "Order ID: " + selectedOrderID + "\n" +
                        "Product: Mango Box\n" +
                        "Quantity: 5 crates\n" +
                        "Estimated Delivery: 2 days"
        );

        // Table already shows demo progress, you can link real-time updates later
    }

    // Inner demo class
    public static class OrderTrackDemo {
        private String status;
        private String location;
        private String deliveryProgress;

        public OrderTrackDemo(String status, String location, String deliveryProgress) {
            this.status = status;
            this.location = location;
            this.deliveryProgress = deliveryProgress;
        }

        public String getStatus() { return status; }
        public String getLocation() { return location; }
        public String getDeliveryProgress() { return deliveryProgress; }
    }
}
