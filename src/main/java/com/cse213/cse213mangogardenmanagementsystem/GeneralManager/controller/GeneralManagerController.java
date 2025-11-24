package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee; // Import Employee from the parent package
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// This controller manages the General Manager Dashboard (GeneralManagerLayoutView.fxml)
public class GeneralManagerController {

    @FXML
    private Label welcomeLabel; // Corresponds to the label in the FXML header

    @FXML
    private VBox contentContainer; // The area where dynamic content (views) will be loaded

    private Employee currentUser;

    /**
     * Called by reflection from the LoginController to inject the authenticated user data.
     * @param user The logged-in Employee object (GeneralManager).
     */
    public void initData(Employee user) {
        this.currentUser = user;

        // Set welcome message in the header
        welcomeLabel.setText("Welcome, " + user.getName() + " | Role: " + user.getRole());

        // Load the default view (e.g., Task Summary) upon login
        loadTaskSummaryView();
    }

    // --- Navigation Handlers (Methods called by FXML Buttons) ---

    @FXML
    private void loadTaskSummaryView() {
        // Placeholder for loading a view showing assigned tasks and completion status
        setContent("Task Summary", "Viewing tasks assigned and tracking progress...", "bg-blue-100");
    }

    @FXML
    private void loadBudgetRequestsView() {
        // Placeholder for loading a view showing pending budget requests for approval
        setContent("Budget Requests", "Displaying all pending budget requests. Approval required.", "bg-red-100");
    }

    @FXML
    private void loadInventoryCheckView() {

        // Placeholder for loading a view to check current inventory levels
        setContent("Inventory Status", "Displaying current mango stock and spoilage rates.", "bg-green-100");
    }

    @FXML
    private void loadPayrollGenerationView() {
        // Placeholder for generating and viewing payroll information
        setContent("Generate Payroll", "Prepare weekly payroll records for worker disbursement.", "bg-yellow-100");
    }

    /**
     * Helper function to simulate dynamic content loading by changing the contentContainer.
     * In a real application, you would use an FXMLLoader here to load a separate FXML file.
     */
    private void setContent(String title, String message, String colorStyle) {
        // Clear previous content
        contentContainer.getChildren().clear();

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10px;");

        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");

        VBox contentBox = new VBox(10, titleLabel, messageLabel);
        contentBox.setStyle("-fx-background-color: " + colorStyle + "; -fx-padding: 20px; -fx-border-color: #333; -fx-border-width: 1px; -fx-border-radius: 5px;");
        contentBox.setMaxWidth(Double.MAX_VALUE);

        contentContainer.getChildren().add(contentBox);
    }
}