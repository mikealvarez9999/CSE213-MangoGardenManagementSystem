package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TransportManagerController {



    @javafx.fxml.FXML
    private VBox contentContainer;

    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/TransportManager/";

    @javafx.fxml.FXML
    public void scheduleMaintenanceOnMouseClick() {
        loadFXMLView("scheduleMaintenance.fxml");
    }

    @javafx.fxml.FXML
    public void trackDeliveriesOnMouseClick() {
        loadFXMLView("trackDeliveries.fxml");
    }

    @javafx.fxml.FXML
    public void deliverySummaryOnMouseClick() {
        loadFXMLView("deliverySummary.fxml");
    }

    @javafx.fxml.FXML
    public void requestVehicleServicingBudgetOnMouseClick() {
        loadFXMLView("requestVehicleServicingBudget.fxml");
    }

    @javafx.fxml.FXML
    public void assignDriversOnMouseClick() {
        loadFXMLView("assignDrivers.fxml");
    }

    @javafx.fxml.FXML
    public void ViewDeliveryLogsOnMouseClick() {
        loadFXMLView("viewDeliveryLogs.fxml");
    }

    @javafx.fxml.FXML
    public void assignVehiclesOnMouseClick() {
        loadFXMLView("assignVehicles.fxml");
    }

    @javafx.fxml.FXML
    public void recordDeliveryCompletedOnMouseClick() {
        loadFXMLView("recordDeliveryCompleted.fxml");
    }

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
            contentContainer.getChildren().add(new Label("Error: Could not load component view " + fxmlFilename + ". Check the file path and FXML structure."));
        }
    }
}
