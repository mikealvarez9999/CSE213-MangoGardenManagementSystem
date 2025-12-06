package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SetModifyEmployeeSalaryRatesController {

    private static final String WORKER_FILE = "Workers.bin";
    private GardenWorker selectedWorker;

    @javafx.fxml.FXML
    private TableView<GardenWorker> salaryRatesTV;
    @javafx.fxml.FXML
    private TextField setRateTF;
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private TableColumn<GardenWorker, Integer> workerIDTC;
    @javafx.fxml.FXML
    private TableColumn<GardenWorker, Integer> dailyRateTC;

    @FXML
    public void initialize(){
        workerIDTC.setCellValueFactory(new PropertyValueFactory<GardenWorker, Integer>("workerID"));
        dailyRateTC.setCellValueFactory(new PropertyValueFactory<GardenWorker, Integer>("dailyRate"));
        ObservableList<GardenWorker> workerList = GeneralManager.loadWorkers();
        salaryRatesTV.getItems().addAll((GardenWorker) workerList);
        salaryRatesTV.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                selectedWorker = newValue;
                setRateTF.setText(String.valueOf(selectedWorker.getSalaryRate()));
            }
        });
    }
    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {
        if (selectedWorker != null){
            try {
                selectedWorker.setSalaryRate(Integer.parseInt(setRateTF.getText()));
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #16BC00;");
                successLabel.setText("Salary rate of worker #" + selectedWorker.getWorkerID() + " updated successfully!");
            } catch (NumberFormatException e) {
                successLabel.setText(null);
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("Enter valid salary rate!");
            }
        }
    }
}
