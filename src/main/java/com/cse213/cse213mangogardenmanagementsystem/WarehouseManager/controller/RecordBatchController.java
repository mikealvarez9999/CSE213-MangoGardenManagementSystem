package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.WarehouseManager;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;

public class RecordBatchController {

    @FXML
    private DatePicker harvestDateDatePicker;
    @FXML
    private TextField fieldNumberTextField;
    @FXML
    private TextField batchIdTextField;
    @FXML
    private ComboBox<String> mangoTypeComboBox;
    @FXML
    private TextArea confirmMessageTextArea;

    private static final String FILE_NAME = "batchData.bin";
    private ObservableList<MangoBatch> batchList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        mangoTypeComboBox.getItems().addAll("Fazli", "Langra", "Himsagar");



    }

    @FXML
    public void saveBatchOneMouseClick(ActionEvent actionEvent) {

        String batchId = batchIdTextField.getText();
        String mangoType = mangoTypeComboBox.getValue();
        LocalDate date = harvestDateDatePicker.getValue();
        String fieldNo = fieldNumberTextField.getText();

        if (batchId.isEmpty() || mangoType == null || date == null || fieldNo.isEmpty()) {
            confirmMessageTextArea.setText("Please fill all required fields!");
            return;
        }

        MangoBatch batch = new MangoBatch(batchId, mangoType, date, fieldNo);

        batchList.add(batch);

        WarehouseManager.recordBatch(batchList);

        confirmMessageTextArea.setText("Batch recorded successfully!");

        batchIdTextField.clear();
        fieldNumberTextField.clear();
        harvestDateDatePicker.setValue(null);
        mangoTypeComboBox.setValue(null);
    }


}