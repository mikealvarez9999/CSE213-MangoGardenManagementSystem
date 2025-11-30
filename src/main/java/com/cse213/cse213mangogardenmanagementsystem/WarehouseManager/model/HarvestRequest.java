package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

public class HarvestRequest {


    private String requestID;
    private double requestQuantity;
    private double currentQuantity;
    private double spoilageQuantity;
    private String status;


    public HarvestRequest(String requestID, double requestQuantity, double currentQuantity, double spoilageQuantity, String status) {
        this.requestID = requestID;
        this.requestQuantity = requestQuantity;
        this.currentQuantity = currentQuantity;
        this.spoilageQuantity = spoilageQuantity;
        this.status = status;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public double getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(double requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public double getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(double currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public double getSpoilageQuantity() {
        return spoilageQuantity;
    }

    public void setSpoilageQuantity(double spoilageQuantity) {
        this.spoilageQuantity = spoilageQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HarvestRequest{" +
                "requestID='" + requestID + '\'' +
                ", requestQuantity=" + requestQuantity +
                ", currentQuantity=" + currentQuantity +
                ", spoilageQuantity=" + spoilageQuantity +
                ", status='" + status + '\'' +
                '}';
    }

}
