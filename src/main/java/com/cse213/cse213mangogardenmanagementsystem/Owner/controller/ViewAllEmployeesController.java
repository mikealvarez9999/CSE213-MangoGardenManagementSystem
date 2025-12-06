package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Locale;

public class ViewAllEmployeesController {
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
    public void initialize(){
        idTC.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeID"));
        joiningdateTC.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("joiningDate"));
        phoneTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNo"));
        nameTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        roleTC.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));

        employeeTV.setItems(Owner.loadAllEmployees());
    }
}
