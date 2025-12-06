package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import java.io.Serializable;

public class Drivers implements Serializable {

    protected String driverID;
    protected String driverName;
    protected String licenseType;
    protected String availability;

    public Drivers(String driverID, String driverName, String licenseType, String availability) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.availability = availability;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "driverID='" + driverID + '\'' +
                ", driverName='" + driverName + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
