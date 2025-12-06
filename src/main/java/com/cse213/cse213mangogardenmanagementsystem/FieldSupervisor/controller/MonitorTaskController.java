package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MonitorTaskController
{
    @FXML private ComboBox<String> cmbWorkerFilter;
    @FXML private TableView<Task> taskCompletionTable;

    // FXML Columns - assuming these are manually defined in FXML
    @FXML private TableColumn<Task, Integer> taskIdColumn;
    @FXML private TableColumn<Task,String> taskDescColumn;
//    @FXML private TableColumn<Task,String> assignedToColumn;
    @FXML private TableColumn<Task,String> statusColumn;


    @FXML
    public void initialize() {
        // Load task list
        taskCompletionTable.setItems(FieldSupervisor.getTasksForMonitoring());

        // Bind columns
        taskIdColumn.setCellValueFactory(new PropertyValueFactory<Task,Integer>("id"));
        taskDescColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("description"));
//        assignedToColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("assigned"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("status"));

        // Assigned To column needs custom CellFactory if binding to ObservableList<String>
        // assignedToColumn.setCellValueFactory(new PropertyValueFactory<>("assignedWorkers"));
    }

    @FXML
    public void handleViewReport(ActionEvent actionEvent) {
        Task selected = taskCompletionTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("Select a task to view its report.");
            return;
        }
        System.out.println("Viewing detailed report for Task ID: " + selected.getID());
    }

    @FXML
    public void handleMarkVerified(ActionEvent actionEvent) {
        Task selected = taskCompletionTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.err.println("Select a task to mark as verified.");
            return;
        }

        if (selected.getStatus().equals("Completed & Verified")) {
            System.out.println("Task already verified.");
            return;
        }

        FieldSupervisor.markTaskVerified(selected.getID());
        taskCompletionTable.refresh();
        System.out.println("Task ID " + selected.getID() + " marked as verified.");
    }

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {
        taskCompletionTable.setItems(FieldSupervisor.getTasksForMonitoring()); // Reload
        System.out.println("Task list refreshed.");
    }
}