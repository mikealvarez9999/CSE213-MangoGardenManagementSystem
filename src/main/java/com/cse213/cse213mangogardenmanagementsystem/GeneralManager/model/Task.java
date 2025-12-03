package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Task implements Serializable {

    private static final Random RANDOM = new Random();

    protected int taskID;
    protected String details;
    protected String status;
    protected String assignedTo;
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

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getAssignedOn() {
        return assignedOn;
    }

    public LocalDate getExpectedCompletion() {
        return expectedCompletion;
    }


    public Task(String details, String status, String assignedTo, LocalDate assignedOn, LocalDate expectedCompletion) {
        this.taskID = 100 + RANDOM.nextInt(900);
        this.details = details;
        this.status = status;
        this.assignedTo = assignedTo;
        this.assignedOn = assignedOn;
        this.expectedCompletion = expectedCompletion;
    }
}
