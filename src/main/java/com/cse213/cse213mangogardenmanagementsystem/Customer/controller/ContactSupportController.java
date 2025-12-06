package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Feedback;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactSupportController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField subjectTextField;

    @FXML
    private Button sendRequestButton;

    @FXML
    private Label confirmationTextLabel;

    @FXML
    private Label contactSupportLabel;

    // In-memory list to store feedbacks (can replace with file/db storage)
    private ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Clear confirmation label initially
        confirmationTextLabel.setText("");
    }

    @FXML
    private void sendRequestButtonOnAction() {
        String subject = subjectTextField.getText().trim();
        String description = descriptionTextArea.getText().trim();

        if (subject.isEmpty() || description.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter both Subject and Description.");
            return;
        }

        // Create Feedback object
        Feedback feedback = new Feedback();
        feedback.setSubject(subject);
        feedback.setFeedback(description);


        // Add to list (or save to file/db)
        feedbackList.add(feedback);

        // Show confirmation message
        confirmationTextLabel.setText("Your request has been sent successfully!");

        // Clear input fields
        subjectTextField.clear();
        descriptionTextArea.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
