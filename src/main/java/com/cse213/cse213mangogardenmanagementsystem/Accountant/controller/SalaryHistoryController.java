package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Payroll;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SalaryHistoryController {

    @FXML
    private TableView<Payroll> salaryTable;

    @FXML private TableColumn<Payroll, Integer> idColumn;
    @FXML private TableColumn<Payroll, String> employeeIdColumn;
    @FXML private TableColumn<Payroll, LocalDate> startDateColumn;
    @FXML private TableColumn<Payroll, LocalDate> endDateColumn;
    @FXML private TableColumn<Payroll, Double> netWagesColumn;


    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        netWagesColumn.setCellValueFactory(new PropertyValueFactory<>("netWages"));

        salaryTable.setItems(Accountant.viewDisburseSalaryHistory());

        System.out.println("Salary History loaded successfully.");
    }
}