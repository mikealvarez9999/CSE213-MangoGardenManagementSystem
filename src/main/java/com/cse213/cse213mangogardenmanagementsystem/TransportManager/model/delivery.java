package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;


import java.io.Serializable;


public class delivery implements Serializable {


    protected String orderID;
    protected String driverID;
    protected String vehicleID;
    protected String deliveryTime;
    protected String status;

    public delivery(String orderID, String driverID, String vehicleID, String deliveryTime, String status) {
        this.orderID = orderID;
        this.driverID = driverID;
        this.vehicleID = vehicleID;
        this.deliveryTime = deliveryTime;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "delivery{" +
                "orderID='" + orderID + '\'' +
                ", driverID='" + driverID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
