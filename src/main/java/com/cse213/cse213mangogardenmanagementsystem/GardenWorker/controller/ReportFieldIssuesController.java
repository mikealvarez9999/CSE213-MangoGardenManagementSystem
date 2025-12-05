package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.FieldIssues;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ReportFieldIssuesController {

    private static final String FILE_NAME = "fieldIssuesData.bin";

    @FXML
    private ComboBox<String> issueTypeComboBox;
    @FXML
    private TextArea describeIssueTextArea;
    @FXML
    private Button reportIssueButton;

    private ObservableList<FieldIssues> issueList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Example types, you can change as needed
        issueTypeComboBox.getItems().addAll("Tool Issue", "Field Issue", "Other");

        // Load existing issues from file
        issueList = FileReadWrite.loadData(FieldIssues.class, FILE_NAME);
    }

    @FXML
    public void reportIssueButtonOnAction(ActionEvent actionEvent) {

        String type = issueTypeComboBox.getValue();
        String description = describeIssueTextArea.getText();

        if (type == null || description.isEmpty()) {
            // Do nothing if empty
            return;
        }

        FieldIssues issue = new FieldIssues(type, description);
        issueList.add(issue);

        // Save to file
        FileReadWrite.saveData(issueList, FILE_NAME);

        // Clear input fields
        issueTypeComboBox.setValue(null);
        describeIssueTextArea.clear();
    }
}