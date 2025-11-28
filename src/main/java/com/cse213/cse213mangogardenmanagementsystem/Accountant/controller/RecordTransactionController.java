package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RecordTransactionController
{
    @javafx.fxml.FXML
    private ComboBox cmbCategory;
    @javafx.fxml.FXML
    private ComboBox cmbType;
    @javafx.fxml.FXML
    private TextArea txtDescription;
    @javafx.fxml.FXML
    private TextField txtAmount;
    @javafx.fxml.FXML
    private DatePicker dateDate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void btnSave(ActionEvent actionEvent) {
    }
}