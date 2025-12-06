package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Optional;

public class MarkCompletedTaskController {

    @FXML
    private Button updateStatusButton;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private ComboBox<Integer> taskIDComboBox;

    @FXML
    private Label markCompletedTaskLabel;

    private ObservableList<Task> taskList;

    @FXML
    public void initialize() {
        // Sample tasks - in real app, load from database/file
        taskList = FXCollections.observableArrayList(
//                new Task("T001", "Field A", "Mango", "2025-12-10", "Pending"),
//                new Task("T002", "Field B", "Banana", "2025-12-12", "Pending"),
//                new Task("T003", "Field C", "Guava", "2025-12-15", "Pending"),
                new Task(
                        "Apply fertilizer to Sector A mango saplings.",
                        "Pending",
                        LocalDate.now(),
                        LocalDate.now().plusDays(3)
                ),
                new Task(
                        "2 fertilizer to Sector A mango saplings.",
                        "Pending",
                        LocalDate.now(),
                        LocalDate.now().plusDays(3)
                ),
                new Task(
                        "3 fertilizer to Sector A mango saplings.",
                        "Pending",
                        LocalDate.now(),
                        LocalDate.now().plusDays(3)
                )
        );

        // Populate taskIDComboBox with task IDs
        for (Task task : taskList) {
            taskIDComboBox.getItems().add(task.getTaskID());
        }

        // Populate statusComboBox with options
        statusComboBox.getItems().addAll("Pending", "Completed");
    }

    @FXML
    public void updateStatusButtonOnAction(ActionEvent actionEvent) {
        String selectedTaskID = String.valueOf(taskIDComboBox.getValue());
        String selectedStatus = statusComboBox.getValue();

        if (selectedTaskID == null || selectedStatus == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select both TaskID and Status.");
            return;
        }

        // Find the task by ID
        Optional<Task> taskOptional = taskList.stream()
                .filter(task -> String.valueOf(task.getTaskID()).equals(selectedTaskID))
                .findFirst();

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(selectedStatus);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Task status updated successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Task not found!");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
