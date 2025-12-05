package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import com.cse213.cse213mangogardenmanagementsystem.Owner.model.Owner;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ViewTaskSummaryController {
    @javafx.fxml.FXML
    private TableColumn<Task, String> detailsTC;
    @javafx.fxml.FXML
    private TableColumn<Task, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Task, Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<Task, String> assignedToTC;
    @javafx.fxml.FXML
    private TableView<Task> tasksTV;
    @javafx.fxml.FXML
    private TableColumn<Task, LocalDate> deadlineTC;
    @javafx.fxml.FXML
    private TableColumn<Task, LocalDate> assignedOnTC;

    @javafx.fxml.FXML
    public void initialize(){
        idTC.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskID"));
        assignedOnTC.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("assignedOn"));
        assignedToTC.setCellValueFactory(new PropertyValueFactory<Task, String>("assignedTo"));
        deadlineTC.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("expectedCompletion"));
        detailsTC.setCellValueFactory(new PropertyValueFactory<Task, String>("details"));
        statusTC.setCellValueFactory(new PropertyValueFactory<Task, String>("status"));

        tasksTV.setItems(Owner.loadAllTasks());
    }
}
