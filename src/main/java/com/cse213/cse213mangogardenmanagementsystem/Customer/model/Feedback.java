package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import java.io.Serializable;

public class Feedback implements Serializable {

    private String orderID;
    private String subject;
    private String feedback;

    // Default constructor
    public Feedback() {
    }

    // Parameterized constructor
    public Feedback(String orderID, String subject, String feedback) {
        this.orderID = orderID;
        this.subject = subject;
        this.feedback = feedback;
    }

    // Getters
    public String getOrderID() {
        return orderID;
    }

    public String getSubject() {
        return subject;
    }

    public String getFeedback() {
        return feedback;
    }

    // Setters
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "orderID='" + orderID + '\'' +
                ", subject='" + subject + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
