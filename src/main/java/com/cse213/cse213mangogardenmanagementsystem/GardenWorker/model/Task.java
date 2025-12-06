package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model;

import javafx.beans.property.SimpleStringProperty;

public class Task {
    private final SimpleStringProperty taskID;
    private final SimpleStringProperty location;
    private final SimpleStringProperty cropType;
    private final SimpleStringProperty deadLine;
    private final SimpleStringProperty status;

    public Task(String taskID, String location, String cropType, String deadLine, String status) {
        this.taskID = new SimpleStringProperty(taskID);
        this.location = new SimpleStringProperty(location);
        this.cropType = new SimpleStringProperty(cropType);
        this.deadLine = new SimpleStringProperty(deadLine);
        this.status = new SimpleStringProperty(status);
    }

    public String getTaskID() { return taskID.get(); }
    public String getLocation() { return location.get(); }
    public String getCropType() { return cropType.get(); }
    public String getDeadLine() { return deadLine.get(); }
    public String getStatus() { return status.get(); }

    public void setTaskID(String value) { taskID.set(value); }
    public void setLocation(String value) { location.set(value); }
    public void setCropType(String value) { cropType.set(value); }
    public void setDeadLine(String value) { deadLine.set(value); }
    public void setStatus(String value) { status.set(value); }
}
