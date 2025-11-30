package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MakePaymentsController {
    @javafx.fxml.FXML
    private TextField paymentIDTextField;
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox paymentMethodComboBox;
    @javafx.fxml.FXML
    private Button payNowButton;

    @javafx.fxml.FXML
    public void payNowButtonOnAction(ActionEvent actionEvent) {
    }
}
