package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.IssueReport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InstructionsController
{
    @FXML private TableView<IssueReport> issueReportTable;
    @FXML private TextArea txtInstructions;
    @FXML
    private TableColumn<IssueReport,Integer> idcol;
    @FXML
    private TableColumn<IssueReport,String> descol;

    @FXML
    public void initialize() {
        // Load pending issues
        issueReportTable.setItems(FieldSupervisor.getPendingIssueReports());

        // Bind columns
         idcol.setCellValueFactory(new PropertyValueFactory<IssueReport,Integer>("id"));
//         reportedByColumn.setCellValueFactory(new PropertyValueFactory<>("reportedBy"));
         descol.setCellValueFactory(new PropertyValueFactory<IssueReport,String>("issue"));

        // Listener to load selected issue into text area (if needed for context)
        issueReportTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && newSelection.getFeedback() != null) {
                txtInstructions.setText(newSelection.getFeedback());
            } else if (newSelection != null) {
                txtInstructions.clear();
            }
        });
    }

    @FXML
    public void handleSaveInstructions(ActionEvent actionEvent) {
        IssueReport selected = issueReportTable.getSelectionModel().getSelectedItem();
        String instructions = txtInstructions.getText().trim();

        if (selected == null || instructions.isEmpty()) {
            System.err.println("Error: Select a report and provide instructions.");
            return;
        }

        boolean success = FieldSupervisor.saveInstruction(selected.getId(), instructions);

        if (success) {
            System.out.println("Instructions saved and report ID " + selected.getId() + " updated.");
            issueReportTable.refresh();
        } else {
            System.err.println("Error saving instructions.");
        }
    }
}