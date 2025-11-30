package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ViewOrderHistoryController {
    @javafx.fxml.FXML
    private TableColumn orderStatusColumn;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TableView orderHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn orderDateColumn;
    @javafx.fxml.FXML
    private TableColumn totalAmountColumn;
    @javafx.fxml.FXML
    private Button FilterButton;
    @javafx.fxml.FXML
    private TableColumn orderIDColumn;
    @javafx.fxml.FXML
    private DatePicker orderDateDatePicker;

    @javafx.fxml.FXML
    public void FilterButtonOnAction(ActionEvent actionEvent) {
    }
}
