package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;

public class AddNewEmployeesController {
    @javafx.fxml.FXML
    private TextField usernameTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> roleCB;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private DatePicker joiningdateDP;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private TextField phoneTF;

    @FXML
    public void initialize(){
        roleCB.getItems().addAll("General Manager", "Accountant", "Field Supervisor", "Transport Manager", "Warehouse Manager", "Garden Worker", "Customer");
    }

    @javafx.fxml.FXML
    public void addButtonOA(ActionEvent actionEvent) {
        if (!((usernameTF.getText().isBlank()) || (passwordTF.getText().isBlank()) || (nameTF.getText().isBlank()) || (joiningdateDP.getValue() == null) || (phoneTF.getText().isBlank()))) {
            Employee chakor = new Employee(usernameTF.getText(), passwordTF.getText(), nameTF.getText(), roleCB.getValue(), joiningdateDP.getValue(), phoneTF.getText());
            if (Owner.addNewEmployee(chakor)) {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #51AB19;");
                successLabel.setText("New Employee #" + chakor.getEmployeeID() + " (" + chakor.getName() + ") added successfully.");
            } else {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("There was an error creating the employee.");
            }
        } else {
            successLabel.setText(null);
            successLabel.setStyle("-fx-text-fill: #FF0000;");
            successLabel.setText("No field should be left blank!");
        }
    }
}
