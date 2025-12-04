package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Customer;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class PlaceAnOrderController {
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private Label stockUpdateLabel;
    @javafx.fxml.FXML
    private TextArea addressTextArea;
    @javafx.fxml.FXML
    private Button placeOrderButton;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private Label placeAnOrderLabel;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private Label successLabel;


    @javafx.fxml.FXML
    public void initialize(){
        typeComboBox.getItems().addAll("Mango1", "Mango2");
    }
    @javafx.fxml.FXML
    public void placeOrderButtonOnAction(ActionEvent actionEvent) {
        if ((typeComboBox.getValue() == null) || (quantityTextField.getText().isEmpty()) || (addressTextArea.getText().isEmpty())){
            Alert aa = new Alert(Alert.AlertType.ERROR);
            aa.setContentText("Invalid input!");
            aa.showAndWait();
            return;
        } else {

            Order newOrder = new Order(typeComboBox.getValue(), Integer.parseInt(quantityTextField.getText()), phoneNumberTF.getText());
            if (Customer.addOrderToFile(newOrder)){
                successLabel.setText("");
                successLabel.setText("Order number " + newOrder.getOrderID() + " created successfully!");
            } else {
                successLabel.setText("");
                successLabel.setText("Order not placed.");
            }
        }


    }
}
