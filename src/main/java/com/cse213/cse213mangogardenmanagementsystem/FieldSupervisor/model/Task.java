package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Random;

public class Task implements Serializable {
    private final int id;
    private String description;
    String status;
    private ObservableList<String> assignedWorkers;
    public Task(String description) {
        this.id = new Random().nextInt(9000) + 1000;
        this.description = description;
        this.status = "Assigned";
        this.assignedWorkers = FXCollections.observableArrayList();
    }
    public int getId() { return id; }
    public String getDescription() { return description; }
    public void setStatus(String status) { this.status = status; }
    public ObservableList<String> getAssignedWorkers() { return assignedWorkers; }

    public String getStatus() {
        return status;
    }
}