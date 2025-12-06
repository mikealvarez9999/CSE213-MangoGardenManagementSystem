package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewSalaryHistoryController {

    @FXML
    private Label salaryHistoryLabel;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField amountTextField;
    @FXML
    private Button recordSalaryStatusButton;

    @FXML
    private TableView<SalaryHistoryDemo> salaryHistoryTableView;
    @FXML
    private TableColumn<SalaryHistoryDemo, String> monthColumn;
    @FXML
    private TableColumn<SalaryHistoryDemo, String> salaryColumn;
    @FXML
    private TableColumn<SalaryHistoryDemo, String> attendanceColumn;
    @FXML
    private TableColumn<SalaryHistoryDemo, String> evalutionColumn;

    private ObservableList<SalaryHistoryDemo> salaryHistoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Fill month dropdown
        monthComboBox.getItems().addAll(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );

        // Map TableColumns to object properties
        monthColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("month"));
        salaryColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("salary"));
        attendanceColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("attendance"));
        evalutionColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("evaluation"));

        // Demo data
        salaryHistoryList.addAll(
                new SalaryHistoryDemo("January", "15000", "Present: 26", "Good"),
                new SalaryHistoryDemo("February", "15000", "Present: 24", "Average"),
                new SalaryHistoryDemo("March", "15500", "Present: 28", "Excellent")
        );

        salaryHistoryTableView.setItems(salaryHistoryList);
    }

    @FXML
    public void recordSalaryStatusButtonOnAction(ActionEvent actionEvent) {

        String month = monthComboBox.getValue();
        String salary = amountTextField.getText();

        // Basic validation
        if (month == null || salary.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select month and enter salary amount.");
            alert.show();
            return;
        }

        // Demo attendance and evaluation values
        String attendance = "Present: 25";
        String evaluation = "Good";

        // Add record to TableView
        salaryHistoryList.add(
                new SalaryHistoryDemo(month, salary, attendance, evaluation)
        );

        salaryHistoryTableView.refresh();
    }

    // Inner demo class
    public static class SalaryHistoryDemo {
        private String month;
        private String salary;
        private String attendance;
        private String evaluation;

        public SalaryHistoryDemo(String month, String salary, String attendance, String evaluation) {
            this.month = month;
            this.salary = salary;
            this.attendance = attendance;
            this.evaluation = evaluation;
        }

        public String getMonth() { return month; }
        public String getSalary() { return salary; }
        public String getAttendance() { return attendance; }
        public String getEvaluation() { return evaluation; }
    }
}
