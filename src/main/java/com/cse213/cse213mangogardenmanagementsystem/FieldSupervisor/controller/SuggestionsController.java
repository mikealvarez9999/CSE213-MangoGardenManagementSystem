package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SuggestionsController
{
    @FXML private Label lblConfirmation;
    @FXML private TextField txtTitle;
    @FXML private TextArea txtSuggestion;

    @FXML
    public void initialize() {
        lblConfirmation.setText("");
    }

    @FXML
    public void handleSaveSuggestion(ActionEvent actionEvent) {
        String title = txtTitle.getText().trim();
        String suggestion = txtSuggestion.getText().trim();

        if (title.isEmpty() || suggestion.isEmpty()) {
            lblConfirmation.setText("Error: Both title and suggestion detail are required.");
            return;
        }

        FieldSupervisor.saveSuggestion(title, suggestion);
        lblConfirmation.setText("Suggestion saved. Ready to notify Manager.");
    }

    @FXML
    public void handleNotifyManager(ActionEvent actionEvent) {
        if (lblConfirmation.getText().contains("saved") || !txtTitle.getText().isEmpty()) {
            System.out.println("Notification sent to General Manager regarding new suggestion.");
            lblConfirmation.setText("Manager notified. Fields cleared.");
            txtTitle.clear();
            txtSuggestion.clear();
        } else {
            lblConfirmation.setText("Error: Save the suggestion first before notifying.");
        }
    }
}