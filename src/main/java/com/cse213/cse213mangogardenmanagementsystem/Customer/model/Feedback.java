package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import java.io.Serializable;

public class Feedback implements Serializable {

    private String orderID;
    private String subject;
    private String feedback;

    public Feedback() {
    }

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
}
