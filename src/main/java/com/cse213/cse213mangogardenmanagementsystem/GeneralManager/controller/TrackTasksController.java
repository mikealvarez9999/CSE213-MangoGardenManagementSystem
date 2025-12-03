package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller;

import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.GeneralManager;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackTasksController {
    @javafx.fxml.FXML
    private TableColumn<Task, Integer> taskIDTC;
    @javafx.fxml.FXML
    private TableColumn<Task, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Task, String> assignedToTC;
    @javafx.fxml.FXML
    private TableColumn<Task, LocalDate> assignedOnTC;
    @javafx.fxml.FXML
    private TableView<Task> tasksTV;
    @javafx.fxml.FXML
    private TableColumn<Task, String> descriptionTC;
    @javafx.fxml.FXML
    private TableColumn<Task, LocalDate> expectedTC;

    @javafx.fxml.FXML
    public void initialize(){
        System.out.println("Step 1");
        ObservableList<Task> tasklist = FXCollections.observableArrayList();
        tasklist = GeneralManager.loadTasksFromFile();
        System.out.println(tasklist);

        descriptionTC.setCellValueFactory(new PropertyValueFactory<Task, String>("details"));
        taskIDTC.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskID"));
        statusTC.setCellValueFactory(new PropertyValueFactory<Task, String>("status"));
        assignedToTC.setCellValueFactory(new PropertyValueFactory<Task, String>("assignedTo"));
        assignedOnTC.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("assignedOn"));
        expectedTC.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("expectedCompletion"));

        tasksTV.getItems().addAll(tasklist);
    }

}
