package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewAttendanceReportController {

    @FXML
    private TableColumn<String, String> monthColumn;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TableColumn<String, String> statusColumn;
    @FXML
    private Button showAttendanceButton;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TableColumn<String, String> workerIdColumn;
    @FXML
    private TableColumn<String, String> dateColumn;
    @FXML
    private Label attendanceReportLabel;
    @FXML
    private TableView<AttendanceDemo> attendanceReportTableView;

    private ObservableList<AttendanceDemo> attendanceList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // setup ComboBox with months
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May");

        // setup TableColumns using PropertyValueFactory
        workerIdColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("workerId"));
        monthColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("month"));
        dateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));

        // demo data
        attendanceList.addAll(
                new AttendanceDemo("W001", "January", "2025-12-01", "Present"),
                new AttendanceDemo("W002", "January", "2025-12-01", "Absent"),
                new AttendanceDemo("W003", "January", "2025-12-01", "Present")
        );

        attendanceReportTableView.setItems(attendanceList);
    }

    @FXML
    public void showAttendanceButtonOnAction(ActionEvent actionEvent) {
        // For demo, just clear and re-add same data
        attendanceReportTableView.setItems(attendanceList);
    }

    // Inner class for demo
    public static class AttendanceDemo {
        private String workerId;
        private String month;
        private String date;
        private String status;

        public AttendanceDemo(String workerId, String month, String date, String status) {
            this.workerId = workerId;
            this.month = month;
            this.date = date;
            this.status = status;
        }

        public String getWorkerId() { return workerId; }
        public String getMonth() { return month; }
        public String getDate() { return date; }
        public String getStatus() { return status; }
    }
}