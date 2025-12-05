package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Vehicles implements Serializable {

    protected String vehicleID;
    protected String vehicleType;
    protected String availability;
    protected double capacity;
    protected LocalDate maintenanceDate;

    public Vehicles(String vehicleID, String vehicleType, String availability, double capacity, LocalDate maintenanceDate) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.availability = availability;
        this.capacity = capacity;
        this.maintenanceDate = maintenanceDate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", availability='" + availability + '\'' +
                ", capacity=" + capacity +
                ", maintenanceDate=" + maintenanceDate +
                '}';
    }
}