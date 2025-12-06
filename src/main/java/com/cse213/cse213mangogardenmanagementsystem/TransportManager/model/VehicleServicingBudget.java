package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import java.io.Serializable;

public class VehicleServicingBudget implements Serializable {

    protected String vehicleID;
    protected String serviceDate;
    protected double budgetAmount;
    protected String serviceStatus;

    public VehicleServicingBudget(String serviceStatus, String vehicleID, String serviceDate, double budgetAmount) {
        this.serviceStatus = serviceStatus;
        this.vehicleID = vehicleID;
        this.serviceDate = serviceDate;
        this.budgetAmount = budgetAmount;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    @Override
    public String toString() {
        return "VehicleServicingBudget{" +
                "vehicleID='" + vehicleID + '\'' +
                ", serviceDate='" + serviceDate + '\'' +
                ", budgetAmount=" + budgetAmount +
                ", serviceStatus='" + serviceStatus + '\'' +
                '}';
    }
}
