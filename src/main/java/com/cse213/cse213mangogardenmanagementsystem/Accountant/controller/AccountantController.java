package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

// This controller manages the Accountant Dashboard (AccountantLayoutView.fxml)
public class AccountantController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private VBox contentContainer; // The area where dynamic content (views) will be loaded

    private Employee currentUser;

    // Base path for FXML component files within the Accountant resource folder
    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/Accountant/";

    /**
     * Called by reflection from the LoginController to inject the authenticated user data.
     */
    public void initData(Employee user) {
        this.currentUser = user;

        // Set welcome message in the header
        welcomeLabel.setText("Welcome, " + currentUser.getName() + " | Role: " + currentUser.getRole());

        // Load the default view (e.g., Record Transaction) upon login
        loadRecordTransactionView();
    }

    // --- Navigation Handlers (Methods called by FXML Buttons) ---

    @FXML
    private void loadRecordTransactionView() {
        loadFXMLView("RecordTransactionView.fxml");
    }

    @FXML
    private void loadUpdateTransactionView() {
        loadFXMLView("UpdateTransactionView.fxml");
    }

    @FXML
    private void loadGenerateFinancialStatementView() {
        loadFXMLView("GenerateFinancialStatementView.fxml"); // Using the singular name
    }

    @FXML
    private void loadDisburseSalaryView() {
        loadFXMLView("DisburseSalaryView.fxml");
    }

    @FXML
    private void loadSubmitBudgetRequestView() {
        // CORRECTED PATH: Unique FXML for Budget Request
        loadFXMLView("SubmitBudgetRequestView.fxml");
    }

    @FXML
    private void loadSubmitLargeExpenseView() {
        // CORRECTED PATH: Unique FXML for Large Expense Request
        loadFXMLView("SubmitLargeExpenseView.fxml");
    }

    // NEW: Handlers for processing requests
    @FXML
    private void loadProcessToolRequestView() {
        loadFXMLView("ProcessToolRequestView.fxml");
    }

    @FXML
    private void loadProcessVehicleRequestView() {
        loadFXMLView("ProcessVehicleRequestView.fxml");
    }


    /**
     * Loads an FXML file into the contentContainer.
     * @param fxmlFilename The name of the FXML file (e.g., "RecordTransactionView.fxml").
     */
    private void loadFXMLView(String fxmlFilename) {
        try {
            // Construct the full absolute path
            String path = FXML_BASE_PATH + fxmlFilename;

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(view);

        } catch (IOException e) {
            e.printStackTrace();
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(new Label("Error: Could not load component view " + fxmlFilename + ". Check the file path: " + FXML_BASE_PATH + fxmlFilename));
        }
    }
}