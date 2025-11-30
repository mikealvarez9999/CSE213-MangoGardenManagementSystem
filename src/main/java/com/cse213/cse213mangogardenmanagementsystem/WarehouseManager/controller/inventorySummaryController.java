package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class inventorySummaryController
{
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn spoilageColumn;
    @javafx.fxml.FXML
    private TableView inventorySummaryTableView;
    @javafx.fxml.FXML
    private Label messagelabel;
    @javafx.fxml.FXML
    private TableColumn batchIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void totalSpoilageOnMouseClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void totalQuantityOnMouseClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportOnMouseClick(ActionEvent actionEvent) {
    }
}