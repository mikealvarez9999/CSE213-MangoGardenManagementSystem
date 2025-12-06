package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

// This controller manages the General Manager Dashboard (CustomerLayoutView.fxml)
public class CustomerController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private VBox contentContainer; // The area where dynamic content (views) will be loaded

    private Employee currentUser;

    // Base path for FXML component files within the Customer resource folder
    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/Customer/";

    /**
     * Called by reflection from the LoginController to inject the authenticated user data.
     */
    public void initData(Employee user) {
        this.currentUser = user;

        // Set welcome message in the header
        welcomeLabel.setText("Welcome, " + user.getName() + " | Role: " + user.getRole());


    }

    // --- Navigation Handlers (Methods called by FXML Buttons) ---

    @FXML
    public void loadMakePayments() {
        loadFXMLView("MakePayments.fxml");
    }

    @FXML
    public void loadRequestInvoice( ) {
        loadFXMLView("RequestInvoice.fxml");
    }

    @FXML
    public void loadViewOrderHistory( ) {
        loadFXMLView("ViewOrderHistory.fxml");
    }

    @FXML
    public void loadContactSupport( ) {
        loadFXMLView("ContactSupport.fxml");
    }

    @FXML
    public void loadTrackAnOrder( ) {
        loadFXMLView("TrackAnOrder.fxml");
    }

    @FXML
    public void loadCancelAnOrder( ) {
        loadFXMLView("CancelAnOrder.fxml");
    }

    @FXML
    public void loadPlaceAnOrder( ) {
        loadFXMLView("PlaceAnOrder.fxml");
    }

    @FXML
    public void loadProvideFeedback( ) {
        loadFXMLView("ProvideFeedback.fxml");
    }


    /**
     * Loads an FXML file into the contentContainer.
     * @param fxmlFilename The name of the FXML file
     */
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


}