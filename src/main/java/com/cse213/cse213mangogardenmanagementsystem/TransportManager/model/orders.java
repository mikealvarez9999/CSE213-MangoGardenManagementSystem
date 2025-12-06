package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import java.io.Serializable;

public class orders implements Serializable {
    private String orderID;
    private int quantity;
    private String address;

    public orders(String orderID, int quantity, String address) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.address = address;
    }

    public String getOrderID() { return orderID; }
    public int getQuantity() { return quantity; }
    public String getAddress() { return address; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setAddress(String address) { this.address = address; }
}
