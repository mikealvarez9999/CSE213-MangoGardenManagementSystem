package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WarehouseManagerDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private VBox contentContainer; // This is the area where child views will load

    // Base FXML path (all child views are in "view" folder)
    private static final String FXML_BASE_PATH = "src/main/resources/com/cse213/cse213mangogardenmanagementsystem/WarehouseManager/view/";

    @FXML
    public void initialize() {
        // Optional: load a default view at startup
        loadView("RecordBatch.fxml");
    }

    // --- Button Handlers (called by FXML buttons) ---

    @FXML
    private void recordBatchOnMouseClick() {
        loadView("RecordBatch.fxml");
    }

    @FXML
    private void mangoInventoryOnMouseClick() {
        loadView("MangoInventory.fxml");
    }

    @FXML
    private void updateInventoryOnMouseClick() {
        loadView("UpdateInventory.fxml");
    }

    @FXML
    private void trackSpoilageOnMouseClick() {
        loadView("TrackSpoilage.fxml");
    }

    @FXML
    private void approveOrderAndPrepareOnMouseClick() {
        loadView("ApproveOrderAndPrepare.fxml");
    }

    @FXML
    private void sendOrderToTransportOnMouseClick() {
        loadView("SendOrderToTransport.fxml");
    }

    @FXML
    private void inventorySummaryOnMouseClick() {
        loadView("InventorySummary.fxml");
    }

    @FXML
    private void harvestRequestOnMouseClick() {
        loadView("HarvestRequest.fxml");
    }

    // --- Utility method to load child FXML into contentContainer ---
    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_BASE_PATH + fxmlFileName));
            Node view = loader.load();

            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(view);

        } catch (IOException e) {
            e.printStackTrace();
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(new Label("Error loading view: " + fxmlFileName));
        }
    }
}

