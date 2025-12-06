package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FireEmployeesController {
    @javafx.fxml.FXML
    private TableColumn<Employee, String> roleTC;
    @javafx.fxml.FXML
    private TableView<Employee> employeeTV;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, LocalDate> joiningdateTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> phoneTC;
    @javafx.fxml.FXML
    private Label successLabel;

    private ObservableList<Employee> employees = Owner.loadAllEmployees();

    @FXML
    public void initialize(){
        idTC.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeID"));
        joiningdateTC.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("joiningDate"));
        phoneTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNo"));
        nameTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        roleTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));

        employeeTV.setItems(employees);

    }

    @FXML
    public void fireButtonOA(ActionEvent actionEvent) {
        Employee selectedEmployee = employeeTV.getSelectionModel().getSelectedItem();

        if (selectedEmployee != null){
            if (Owner.fireEmployee(selectedEmployee)){
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #51AB19;");
                successLabel.setText("Employee #" + selectedEmployee.getEmployeeID() + " has been fired successfully!");
            } else {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("There has been an error firing employee #" + selectedEmployee.getEmployeeID() + ".");
            }
        } else {
            successLabel.setText(null);
            successLabel.setStyle("-fx-text-fill: #FF0000;");
            successLabel.setText("No employee is clicked. Click on the employee you want to fire and try again.");
        }
    }
}
