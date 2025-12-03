package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoBatch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<MangoBatch> batchList;

    @FXML
    public void initialize() {
        mangoTypeComboBox.getItems().addAll("Fazli", "Langra", "Himsagar");

        // File থেকে load করে ArrayList init
        batchList = loadBatchListFromText();
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

        // Add to ArrayList in Controller
        batchList.add(batch);

        // Save updated list to text file
        saveBatchListToText(batchList);

        confirmMessageTextArea.setText("Batch recorded successfully!");

        // Clear input fields
        batchIdTextField.clear();
        fieldNumberTextField.clear();
        harvestDateDatePicker.setValue(null);
        mangoTypeComboBox.setValue(null);
    }

    // =========================
    // CSV/Text File Handling
    // =========================
    private ArrayList<MangoBatch> loadBatchListFromText() {
        ArrayList<MangoBatch> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    MangoBatch batch = new MangoBatch(parts[0], parts[1], LocalDate.parse(parts[2]), parts[3]);
                    list.add(batch);
                }
            }
        } catch (Exception e) {
            // file not exist or empty
        }
        return list;
    }

    private void saveBatchListToText(ArrayList<MangoBatch> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (MangoBatch b : list) {
                writer.println(b.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Optional: Delete batch by ID
    public void deleteBatchById(String batchId) {
        batchList.removeIf(b -> b.getBatchId().equals(batchId));
        saveBatchListToText(batchList);
    }
}