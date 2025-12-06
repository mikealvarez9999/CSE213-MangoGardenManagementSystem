package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.DailyHarvest;
import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RecordDailyHarvestController {

    @FXML
    private Button updateButtonButton;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private TextField qualityTextField;
    @FXML
    private ComboBox<String> qualityGradeComboBox;
    @FXML
    private Label recordDailyHarvestLabel;

    private ObservableList<DailyHarvest> harvestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Load existing harvest data
        harvestList = GardenWorker.getDailyHarvest();

        // Example grades
        qualityGradeComboBox.getItems().addAll("A", "B", "C");
    }

    @FXML
    public void updateButtonButtonOnAction(ActionEvent actionEvent) {
        // Simple validation: ignore if empty
        if (dateDatePicker.getValue() == null ||
                qualityGradeComboBox.getValue() == null ||
                qualityTextField.getText().isEmpty()) {
            return;
        }

        // Create a new DailyHarvest entry
        DailyHarvest harvest = new DailyHarvest();
        harvest.setDate(dateDatePicker.getValue());
        harvest.setQualityGrade(qualityGradeComboBox.getValue());
        harvest.setRemarks(remarksTextArea.getText());
        harvest.setQuantity(Integer.parseInt(qualityTextField.getText()));
        harvest.setCollecterID(0); // optional
        // Add to list and save
        harvestList.add(harvest);
        GardenWorker.saveDailyHarvest(harvestList);

        // Clear input fields
        dateDatePicker.setValue(null);
        qualityTextField.clear();
        remarksTextArea.clear();
        qualityGradeComboBox.setValue(null);
    }
}