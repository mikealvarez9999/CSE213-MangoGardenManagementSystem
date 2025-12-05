package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

// This controller manages the General Manager Dashboard (GeneralManagerLayoutView.fxml)
public class GeneralManagerController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private VBox contentContainer; // The area where dynamic content (views) will be loaded

    private Employee currentUser;

    // Base path for FXML component files within the GeneralManager resource folder
    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/GeneralManager/";

    /**
     * Called by reflection from the LoginController to inject the authenticated user data.
     */
    public void initData(Employee user) {
        this.currentUser = user;

        // Set welcome message in the header
        welcomeLabel.setText("Welcome, " + user.getName() + " | Role: " + user.getRole());
    }

    private void loadFXMLView(String fxmlFilename) {
        try {
            // Construct the full absolute path
            String path = FXML_BASE_PATH + fxmlFilename;

            // 1. Create FXMLLoader
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

            // 2. Load the Node/Parent from the component FXML
            Node view = loader.load();

            // 3. Clear the container and add the new view
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(view);

            // Note: If the component FXML has its own controller, you can access it here:
            // Object componentController = loader.getController();
            // If componentController implements an interface for data passing, you would call it here.

        } catch (IOException e) {
            e.printStackTrace();
            // Display error message in the content area itself
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(new Label("Error: Could not load component view " + fxmlFilename + ". Check the file path and FXML structure."));
        }
    }

    @FXML
    public void loadCreateAndAssignTasksView(ActionEvent actionEvent) {
        loadFXMLView("CreateAndAssignTaskView.fxml");
    }

    @FXML
    public void loadTrackTaskCompletionView(ActionEvent actionEvent) {
        loadFXMLView("TrackTasksView.fxml");
    }

    @FXML
    public void loadGenerateWeeklyTaskSummaryView(ActionEvent actionEvent) {
        loadFXMLView("GenerateWeeklyReportView.fxml");
    }

    @FXML
    public void loadApproveRejectBudgetRequestsView(ActionEvent actionEvent) {
        loadFXMLView("ApproveRejectBudgetRequestsView.fxml");
    }

    @FXML
    public void loadCalculateWorkerSalaryView(ActionEvent actionEvent) {
        loadFXMLView("CalculateWorkerSalaryView.fxml");
    }

    @FXML
    public void loadSalaryRateView(ActionEvent actionEvent) {
        loadFXMLView("SetModifyEmployeeSalaryRatesView.fxml");
    }

    @FXML
    public void loadCheckInventoryView(ActionEvent actionEvent) {
        loadFXMLView("CheckInventoryView.fxml");
    }

    @FXML
    public void loadViewBudgetRequestsView(ActionEvent actionEvent) {
        loadFXMLView("ViewBudgetRequestsView.fxml");
    }
}