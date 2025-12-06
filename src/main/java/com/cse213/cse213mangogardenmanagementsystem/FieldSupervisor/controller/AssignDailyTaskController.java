package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.Worker;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
import java.util.stream.Collectors;

public class AssignDailyTaskController
{
    @FXML private ComboBox<String> cmbTasks;
    @FXML private TextArea txtNewTask;
    @FXML private ListView<Worker> listWorkers;
    @FXML private ListView<Worker> listAssignedWorkers;

    // Local state to track the assignment
    private ObservableList<Worker> availableWorkers;
    private ObservableList<Worker> currentAssignment = FXCollections.observableArrayList();
    private Task selectedTask;

    @FXML
    public void initialize() {
        // Setup initial worker lists
        availableWorkers = FieldSupervisor.getWorkers();
        listWorkers.setItems(availableWorkers);
        listAssignedWorkers.setItems(currentAssignment);

        // Setup Combo Box with existing task descriptions (or mock tasks)
        cmbTasks.getItems().addAll(FieldSupervisor.getTasks().stream()
                .map(Task::getDescription).collect(Collectors.toList()));

        // Allow multiple selection in list views
        listWorkers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listAssignedWorkers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void handleAssignSelected(ActionEvent actionEvent) {
        List<Worker> selected = listWorkers.getSelectionModel().getSelectedItems();
        if (selected.isEmpty()) return;

        // Move workers from available to assigned
        currentAssignment.addAll(selected);
        availableWorkers.removeAll(selected);
    }

    @FXML
    public void handleRemoveSelected(ActionEvent actionEvent) {
        List<Worker> selected = listAssignedWorkers.getSelectionModel().getSelectedItems();
        if (selected.isEmpty()) return;

        // Move workers from assigned back to available
        availableWorkers.addAll(selected);
        currentAssignment.removeAll(selected);
    }

    @FXML
    public void handleFinalizeAssignment(ActionEvent actionEvent) {
        String taskDescription = txtNewTask.getText().trim();
        String selectedTaskDesc = cmbTasks.getValue();

        if (currentAssignment.isEmpty()) {
            System.err.println("Error: Please assign at least one worker.");
            return;
        }

        if (selectedTaskDesc == null && taskDescription.isEmpty()) {
            System.err.println("Error: Must select an existing task or enter a new one.");
            return;
        }

        // 1. Determine or create the task object
        if (!taskDescription.isEmpty()) {
            selectedTask = new Task(taskDescription);
        } else {
            // Find existing task object based on selection
            selectedTask = FieldSupervisor.getTasks().stream()
                    .filter(t -> t.getDescription().equals(selectedTaskDesc))
                    .findFirst().orElse(new Task(selectedTaskDesc));
        }

        // 2. Call the Model to save the assignment
        FieldSupervisor.assignTask(selectedTask, currentAssignment);

        System.out.println("Assignment finalized for Task ID: " + selectedTask.getId());

        // Clear UI state
        currentAssignment.clear();
        txtNewTask.clear();
        cmbTasks.getSelectionModel().clearSelection();
        availableWorkers.addAll(FieldSupervisor.getWorkers()); // Reset available list
    }
}