package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Salary;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.*;

public class CalculateWorkerSalaryController {
    @javafx.fxml.FXML
    private Label successLabel;
    @javafx.fxml.FXML
    private TextField grossPayTF;
    @javafx.fxml.FXML
    private TextField presentDaysTF;
    @javafx.fxml.FXML
    private TextField workerIDTF;
    @javafx.fxml.FXML
    private ComboBox<String> monthCB;
    @javafx.fxml.FXML
    private TextField taxTF;
    @javafx.fxml.FXML
    private TextField advancesTF;
    @javafx.fxml.FXML
    private Label workerFoundLabel;

    private static final String SALARY_RECORDS_FILE = "SalaryRecords.bin";

    private GardenWorker foundWorker;
    @javafx.fxml.FXML
    private TextField netPayTF;

    @javafx.fxml.FXML
    public void initialize(){
        successLabel.setText("");
        workerFoundLabel.setText("");
        monthCB.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    @javafx.fxml.FXML
    public void reCalculate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateButtonOA(ActionEvent actionEvent) {
        double dailyRate = foundWorker.getSalaryRate();
        double netPay = (Double.parseDouble(presentDaysTF.getText()) * dailyRate) + (Double.parseDouble(grossPayTF.getText()) - (Double.parseDouble(taxTF.getText()) * Double.parseDouble(grossPayTF.getText())) - Double.parseDouble(advancesTF.getText()));
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
        if (!netPayTF.getText().isBlank()){
            Salary newSalary = new Salary(Double.parseDouble(netPayTF.getText()), monthCB.getValue(), foundWorker);
            if (GeneralManager.addNewSalaryRecord(newSalary)){
                successLabel.setText("");
                successLabel.setStyle("-fx-text-fill: #009E03;");
                successLabel.setText("Salary record of worker #" + foundWorker.getWorkerID() + " saved successfully!");
            } else {
                successLabel.setText("");
                successLabel.setStyle("-fx-text-fill: #FF0000;");
                successLabel.setText("There was an error while saving the salary record!");
            }
        }
    }

    @javafx.fxml.FXML
    public void searchWorkerButtonOA(ActionEvent actionEvent) {
        ObservableList<GardenWorker> workerList = GeneralManager.loadWorkers();
        for (GardenWorker worker: workerList){
            if (worker.getID() == Integer.parseInt(workerIDTF.getText())){
               foundWorker = worker;
               break;
            }
        }
        if (!(foundWorker == null)){
            workerFoundLabel.setText("");
            workerFoundLabel.setStyle("-fx-text-fill: #FF0000;");
            workerFoundLabel.setText("No worker with ID: " + workerIDTF.getText() + " exists!");
        } else {
            workerFoundLabel.setText("");
            workerFoundLabel.setStyle("-fx-text-fill: #009E03;");
            workerFoundLabel.setText("FOUND\nWorker ID: " + foundWorker.getID() + "\nName: " + foundWorker.getName() + "\nSalary Rate: " + foundWorker.getSalaryRate());
        }
    }
}
