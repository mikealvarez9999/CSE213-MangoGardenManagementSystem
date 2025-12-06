package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class SummaryController
{
    @FXML private TableView summaryTable;
    @FXML private TextArea txtNotes;
    @FXML private DatePicker dateSummary;

    // FXML Columns - assuming these are manually defined in FXML
    @FXML private TableColumn sectionColumn;
    @FXML private TableColumn detailsColumn;


    @FXML
    public void initialize() {
        dateSummary.setValue(LocalDate.now());
    }

    @FXML
    public void handleGeneratePreview(ActionEvent actionEvent) {
        LocalDate date = dateSummary.getValue();
        if (date == null) {
            System.err.println("Select a date for the summary.");
            return;
        }

        // Mock Data Preview Generation
        // In a real app, this would query Attendance, Task, and Usage records for the date.

        // Simulating loading data into the table
        // (Requires a specific SummaryItem model, which is omitted)
        System.out.println("Generating preview for " + date + "...");

        // Mock data
        summaryTable.getItems().clear();
        summaryTable.getItems().addAll(
                "Attendance: 10/10 present",
                "Tasks: 8 completed, 2 ongoing",
                "Usage: High pesticide use"
        );
    }

    @FXML
    public void handleSaveSummary(ActionEvent actionEvent) {
        LocalDate date = dateSummary.getValue();
        String notes = txtNotes.getText().trim();

        if (date == null) {
            System.err.println("Select a date for the summary.");
            return;
        }

        FieldSupervisor.saveDailySummary(date, notes);
        System.out.println("Daily Field Summary saved successfully for " + date + ".");
    }
}