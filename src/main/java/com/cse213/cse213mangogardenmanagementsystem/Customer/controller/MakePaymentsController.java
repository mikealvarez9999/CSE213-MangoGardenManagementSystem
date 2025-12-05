package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Customer;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Payment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private Button payNowButton;
    @javafx.fxml.FXML
    private Label makePaymentLabel;
    @javafx.fxml.FXML
    private Label getConfirmationLabel;



    @javafx.fxml.FXML
    public void initialize(){
        paymentMethodComboBox.getItems().addAll("Cash", "Card","Bank");
    }

    @javafx.fxml.FXML
    public void payNowButtonOnAction(ActionEvent actionEvent) {
        if ((paymentMethodComboBox.getValue() == null) || (amountTextField.getText().isEmpty())){
            Alert aa = new Alert(Alert.AlertType.ERROR);
            aa.setContentText("Invalid input!");
            aa.showAndWait();
            return;
    }else {

            Payment newPayment = new Payment(paymentMethodComboBox.getValue(), Integer.parseInt(amountTextField.getText()));
            if (Customer.addPaymentToFile(newPayment)){
                getConfirmationLabel.setText("");
                getConfirmationLabel.setText("Payment " + newPayment.getPaymentID() + " Payment successful!");
            } else {
                getConfirmationLabel.setText("");
                getConfirmationLabel.setText("Payment not done.");
            }
        }


    }

        }

