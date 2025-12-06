package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

public class ContactSupport {

    private String orderID;     // Optional: if you want to link support to an order
    private String subject;
    private String description;

    // Default constructor
    public ContactSupport() {
    }

    // Constructor with parameters
    public ContactSupport(String orderID, String subject, String description) {
        this.orderID = orderID;
        this.subject = subject;
        this.description = description;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ContactSupport{" +
                "orderID='" + orderID + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
