package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FieldSupervisorController {

    private Employee currentUser;

    // Base path for FXML component files within the FieldSupervisor resource folder
    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/FieldSupervisor/";
    @FXML
    private Label welcomeLabel;
    @FXML
    private VBox contentContainer;

    public void initData(Employee user) {
        this.currentUser = user;
        welcomeLabel.setText("Welcome, " + currentUser.getName() + " | Role: " + currentUser.getRole());
//        loadAssignDailyTasksView();
    }

    // --- Navigation Handlers (Methods called by FXML Buttons) ---

    @FXML private void loadAssignDailyTasksView() { loadFXMLView("AssignDailyTasksView.fxml"); }
    @FXML private void loadRecordWorkerAttendanceView() { loadFXMLView("RecordWorkerAttendanceView.fxml"); }
    @FXML private void loadMonitorTaskCompletionView() { loadFXMLView("MonitorTaskCompletionView.fxml"); }
    @FXML private void loadProvideInstructionsView() { loadFXMLView("ProvideInstructionsView.fxml"); }
    @FXML private void loadRequestToolsView() { loadFXMLView("RequestToolsView.fxml"); }
    @FXML private void loadGenerateDailyFieldSummaryView() { loadFXMLView("GenerateDailyFieldSummaryView.fxml"); }
    @FXML private void loadSuggestImprovementsView() { loadFXMLView("SuggestImprovementsView.fxml"); }
    @FXML private void loadMonitorResourceUsageView() { loadFXMLView("MonitorResourceUsageView.fxml"); }


    /**
     * Loads an FXML file into the contentContainer.
     */
    private void loadFXMLView(String fxmlFilename) {
        try {
            String path = FXML_BASE_PATH + fxmlFilename;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(view);

        } catch (IOException e) {
            e.printStackTrace();
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(new Label("Error: Could not load component view " + fxmlFilename + ". Check path."));
        }
    }
}