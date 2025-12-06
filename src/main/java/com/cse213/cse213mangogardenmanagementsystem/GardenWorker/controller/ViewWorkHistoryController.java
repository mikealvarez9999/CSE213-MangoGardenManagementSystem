package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class
ViewWorkHistoryController {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> taskComboBox;
    @FXML
    private Button recordWorkStatusButton;
    @FXML
    private Label workHistoryLabel;

    @FXML
    private TableView<WorkHistoryDemo> workHistoryTableView;
    @FXML
    private TableColumn<WorkHistoryDemo, String> dateColumn;
    @FXML
    private TableColumn<WorkHistoryDemo, String> taskColumn;
    @FXML
    private TableColumn<WorkHistoryDemo, String> statusColumn;

    private ObservableList<WorkHistoryDemo> workHistoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Fill task dropdown
        taskComboBox.getItems().addAll(
                "Watering", "Weeding", "Fertilizing", "Harvesting", "Soil Preparation"
        );

        // Table column setup
        dateColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        taskColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("task"));
        statusColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));

        // Demo data
        workHistoryList.addAll(
                new WorkHistoryDemo("2025-12-01", "Watering", "Completed"),
                new WorkHistoryDemo("2025-12-01", "Weeding", "Completed"),
                new WorkHistoryDemo("2025-12-02", "Fertilizing", "Pending")
        );

        workHistoryTableView.setItems(workHistoryList);
    }

    @FXML
    public void recordWorkStatusOnAction(ActionEvent actionEvent) {

        String date = (dateDatePicker.getValue() != null)
                ? dateDatePicker.getValue().toString()
                : "No date";

        String task = (taskComboBox.getValue() != null)
                ? taskComboBox.getValue()
                : "No task";

        // Add new record (demo only)
        workHistoryList.add(new WorkHistoryDemo(date, task, "Completed"));
        workHistoryTableView.refresh();
    }

    // Inner demo class
    public static class WorkHistoryDemo {
        private String date;
        private String task;
        private String status;

        public WorkHistoryDemo(String date, String task, String status) {
            this.date = date;
            this.task = task;
            this.status = status;
        }

        public String getDate() { return date; }
        public String getTask() { return task; }
        public String getStatus() { return status; }
    }
}
