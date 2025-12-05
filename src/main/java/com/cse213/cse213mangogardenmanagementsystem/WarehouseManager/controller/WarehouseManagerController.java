package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WarehouseManagerController
{
    @FXML
    private VBox contentContainer;

    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/WarehouseManager/";

    @javafx.fxml.FXML
    public void harvestRequestOnMouseClick()
    {
        loadFXMLView("Requestharvest.fxml");
    }

    @javafx.fxml.FXML
    public void sendOrderToTransportOnMouseClick() { loadFXMLView("sendOrderToTransport.fxml");}

    @javafx.fxml.FXML
    public void mangoInventoryOnMouseClick() {
        loadFXMLView("MangoInventory.fxml");
    }

    @javafx.fxml.FXML
    public void trackSpoilageOnMouseClick() {
        loadFXMLView("trackSpoilage.fxml");
    }

    @javafx.fxml.FXML
    public void recordBatchOnMouseClick() {
        loadFXMLView("RecordBatch.fxml");
    }

    @javafx.fxml.FXML
    public void updateInventoryOnMouseClick() {
        loadFXMLView("updateInventory.fxml");
    }

    @javafx.fxml.FXML
    public void inventorySummaryOnMouseClick() {
        loadFXMLView("inventorySummary.fxml");
    }

    @javafx.fxml.FXML
    public void approveOrderAndPrepareOnMouseClick() {
        loadFXMLView("approveOrderAndPrepare.fxml");
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