package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateTaskReportController {

    @javafx.fxml.FXML
    private TextArea reportTA;
    @javafx.fxml.FXML
    private DatePicker startDP;
    @javafx.fxml.FXML
    private DatePicker endDP;

    private final Alert errorAlert = new Alert(Alert.AlertType.ERROR);

    @javafx.fxml.FXML
    public void generateButtonOA(ActionEvent actionEvent) {
        reportTA.setText(null);
        if ((startDP.getValue() == null) || (endDP.getValue() == null)) {
            errorAlert.setContentText("Select both start and end dates.");
            errorAlert.showAndWait();
            return;
        } else if (!startDP.getValue().isBefore(endDP.getValue())) {
            errorAlert.setContentText("End date must be AFTER start date!");
            errorAlert.showAndWait();
            return;
        } else {
            ObservableList<Task> taskList = GeneralManager.loadTasksFromFile();
            ArrayList<Task> tasksInPeriod = new ArrayList<Task>();
            for (Task task : taskList){
                if ((!(task.getAssignedOn().isBefore(startDP.getValue()))) && (!(task.getAssignedOn().isAfter(endDP.getValue())))) {
                    tasksInPeriod.add(task);
                }
            }
            if (!tasksInPeriod.isEmpty()){
                reportTA.setText(null);
                String report = "";
                report += "=================================================\n";
                report += "     GENERATED TASK REPORT\n";
                report += "     Date: " + LocalDate.now() + "\n";
                report += "     Tasks from: " + startDP.getValue() + " to " + endDP.getValue() + "\n";
                report += "     Total Tasks: " + tasksInPeriod.size() + "\n";
                report += "=================================================\n\n";

                for (Task task : tasksInPeriod){
                    report += task.toString() + "\n";
                }
                report += "--- END OF REPORT ---";
                reportTA.setText(report);
            } else {
                reportTA.setText(null);
                String report = "";
                report += "=================================================\n";
                report += "     GENERATED TASK REPORT\n";
                report += "     Date: " + LocalDate.now() + "\n";
                report += "     Tasks from: " + startDP.getValue() + " to " + endDP.getValue() + "\n";
                report += "     Total Tasks: " + 0 + "\n";
                report += "=================================================\n\n";
                report += "No tasks were assigned during this specific timeframe.\n\n";
                report += "--- END OF REPORT ---";
                reportTA.setText(report);
            }
        }
    }
}