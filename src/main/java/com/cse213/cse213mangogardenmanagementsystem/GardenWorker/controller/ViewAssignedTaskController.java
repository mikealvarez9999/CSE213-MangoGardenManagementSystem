package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ViewAssignedTaskController {

    @FXML
    private Label assignedTaskLabel;

    @FXML
    private TableView<Task> assignedTaskTableView;

    @FXML
    private TableColumn<Task, String> taskIDColumn;

    @FXML
    private TableColumn<Task, String> locationColumn;

    @FXML
    private TableColumn<Task, String> cropTypeColumn;

    @FXML
    private TableColumn<Task, String> deadLineColumn;

    @FXML
    private TableColumn<Task, String> statusColumn;

    @FXML
    private TextField searchTaskTextField;

    @FXML
    private Button filterButton;

    @FXML
    private Button refreshButton;

    private ObservableList<Task> taskList;

    @FXML
    public void initialize() {
        // Initialize TableView columns
        taskIDColumn.setCellValueFactory(new PropertyValueFactory<>("taskID"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        cropTypeColumn.setCellValueFactory(new PropertyValueFactory<>("cropType"));
        deadLineColumn.setCellValueFactory(new PropertyValueFactory<>("deadLine"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load tasks
        loadTasks();
    }

    private void loadTasks() {
        // Here you can load tasks from a database or file. For now, let's use dummy data
        taskList = FXCollections.observableArrayList(
                new Task("T001", "Field A", "Mango", "2025-12-10", "Pending"),
                new Task("T002", "Field B", "Banana", "2025-12-12", "Completed"),
                new Task("T003", "Field C", "Guava", "2025-12-15", "Pending")
        );

        assignedTaskTableView.setItems(taskList);
    }

    @FXML
    private void filterButtonOnAction() {
        String searchText = searchTaskTextField.getText().toLowerCase().trim();

        if (searchText.isEmpty()) {
            assignedTaskTableView.setItems(taskList);
            return;
        }

        List<Task> filteredTasks = taskList.stream()
                .filter(task -> task.getTaskID().toLowerCase().contains(searchText)
                        || task.getLocation().toLowerCase().contains(searchText)
                        || task.getCropType().toLowerCase().contains(searchText)
                        || task.getStatus().toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        assignedTaskTableView.setItems(FXCollections.observableArrayList(filteredTasks));
    }

    @FXML
    private void refreshButtonOnAction() {
        searchTaskTextField.clear();
        assignedTaskTableView.setItems(taskList);
    }
}
