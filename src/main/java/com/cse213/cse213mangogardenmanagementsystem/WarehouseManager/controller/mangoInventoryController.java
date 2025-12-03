package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class mangoInventoryController {

    @FXML
    private TableColumn<MangoBatch, String> batchIdColumn;
    @FXML
    private TableColumn<MangoBatch, String> mangoTypeColumn;
    @FXML
    private TableColumn<MangoBatch, String> harvestDateColumn;
    @FXML
    private TableColumn<MangoBatch, String> fieldnumberColumn;
    @FXML
    private TextField mangoQuantityTextField;
    @FXML
    private TableView<MangoBatch> mangoInventoryTableView;


    @FXML
    public void initialize() {

    }

    @FXML
    public void saveInventoryOnMouseClick(ActionEvent event) {


    }
}
