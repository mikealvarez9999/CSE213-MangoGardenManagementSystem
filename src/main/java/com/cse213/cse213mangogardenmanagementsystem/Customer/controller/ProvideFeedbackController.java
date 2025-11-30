package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProvideFeedbackController {
    @javafx.fxml.FXML
    private TextField orderIDTextField;
    @javafx.fxml.FXML
    private TextArea feedbackTextArea;
    @javafx.fxml.FXML
    private ComboBox subjectComboBox;
    @javafx.fxml.FXML
    private Button submitFeedbackButton;

    @javafx.fxml.FXML
    public void submitFeedbackButtonOnAction(ActionEvent actionEvent) {
    }
}
