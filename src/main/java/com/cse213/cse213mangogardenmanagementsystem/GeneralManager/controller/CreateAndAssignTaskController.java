package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import javafx.scene.control.*;
import javafx.event.*;

import java.time.LocalDate;

public class CreateAndAssignTaskController {
    @javafx.fxml.FXML
    private ComboBox<String> fieldSupervisorCB;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private TextArea taskDetailsTA;
    @javafx.fxml.FXML
    private DatePicker expectedDP;

    @javafx.fxml.FXML
    public void createButtonOA(ActionEvent actionEvent) {
        // input validation

        Task createdTask = new Task(taskDetailsTA.getText(), "Pending", fieldSupervisorCB.getValue(), LocalDate.now(), expectedDP.getValue());

        if (GeneralManager.addTaskToFile(createdTask)){
            successLabel.setText("");
            successLabel.setStyle("-fx-text-fill: #0cb900;");
            successLabel.setText("Task " + createdTask.getTaskID() + " created successfully!");
        } else {
            successLabel.setText("");
            successLabel.setStyle("-fx-text-fill: #FF0000;");
            successLabel.setText("Error!");
        }
    }
}
