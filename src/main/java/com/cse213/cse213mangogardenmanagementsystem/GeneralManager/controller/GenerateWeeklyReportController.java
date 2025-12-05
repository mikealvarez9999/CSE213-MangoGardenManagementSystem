package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;

import java.time.LocalDate;

public class GenerateWeeklyReportController {

    @javafx.fxml.FXML
    private TextArea reportTA;
    @javafx.fxml.FXML
    private ComboBox<String> weekCB;

    @javafx.fxml.FXML
    public void initialize(){
        LocalDate start = LocalDate.of(2025,1,1);
        LocalDate end = LocalDate.now();

    }

    @javafx.fxml.FXML
    public void generateButtonOA(ActionEvent actionEvent) {

    }
}