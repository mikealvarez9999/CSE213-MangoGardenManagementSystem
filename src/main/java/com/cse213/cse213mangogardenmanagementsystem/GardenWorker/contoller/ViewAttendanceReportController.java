package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.contoller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ViewAttendanceReportController {
    @javafx.fxml.FXML
    private TableColumn monthColumn;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button showAttendanceButton;
    @javafx.fxml.FXML
    private ComboBox monthComboBox;
    @javafx.fxml.FXML
    private TableColumn workerIdColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private Label attendanceReportLabel;
    @javafx.fxml.FXML
    private TableView attendanceReportTableView;

    @javafx.fxml.FXML
    public void showAttendanceButtonOnAction(ActionEvent actionEvent) {
    }
}
