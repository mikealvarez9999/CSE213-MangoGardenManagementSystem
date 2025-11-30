package com.cse213.cse213mangogardenmanagementsystem.TransportManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class assignVehiclesController
{
    @javafx.fxml.FXML
    private TableColumn addressColumn;
    @javafx.fxml.FXML
    private TableColumn orderIdColumn;
    @javafx.fxml.FXML
    private TableView orderListForVehiclesTableView;
    @javafx.fxml.FXML
    private ComboBox orderIDComboBox;
    @javafx.fxml.FXML
    private TableColumn mangoQuantityColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void selectVehiclesOnMouseClick(ActionEvent actionEvent) {
    }
}