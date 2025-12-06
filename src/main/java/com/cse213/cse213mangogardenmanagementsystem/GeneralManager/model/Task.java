package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Task implements Serializable {

    private static final Random RANDOM = new Random();

    protected int taskID;
    protected String details;
    protected String status;
//    protected String assignedTo;
    private ObservableList<String> assignedWorkers;
    protected LocalDate assignedOn, expectedCompletion;

    public boolean updateStatus(String newStatus){
        try {
            this.status = newStatus;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getTaskID() {
        return taskID;
    }

    public int getID(){
        return taskID;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

//    public String getAssignedTo() {
//        return assignedTo;
//    }

    public ObservableList<String> getAssignedWorkers (){
        return assignedWorkers;
    }

    public LocalDate getAssignedOn() {
        return assignedOn;
    }

    public LocalDate getExpectedCompletion() {
        return expectedCompletion;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task(String details, String status, ObservableList<String> assignedWorkers, LocalDate assignedOn, LocalDate expectedCompletion) {
        this.taskID = 100 + RANDOM.nextInt(900);
        this.details = details;
        this.status = "Pending";
//        this.assignedTo = assignedTo;
        this.assignedWorkers = assignedWorkers;
        this.assignedOn = assignedOn;
        this.expectedCompletion = expectedCompletion;
    }

    public Task(String details, String status, LocalDate assignedOn, LocalDate expectedCompletion) {
        this.taskID = 100 + RANDOM.nextInt(900);
        this.details = details;
        this.status = "Pending";
//        this.assignedTo = assignedTo;
        this.assignedOn = assignedOn;
        this.expectedCompletion = expectedCompletion;
    }

    public Task(String details) {
        this.taskID = 100 + RANDOM.nextInt(900);
        this.details = details;
        this.status = "Pending";
    }

    @Override
    public String toString() {
        return "Task ID: " + taskID + "\n" +
                "  Status: " + status + "\n" +
                "  Assigned To: " + assignedWorkers.toString() + "\n" +
                "  Assigned On: " + assignedOn + "\n" +
                "  Expected Completion: " + expectedCompletion + "\n" +
                "  Details: " + details + "\n" +
                "------------------------------------------";
    }
}
