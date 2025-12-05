package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import java.util.Random;

public class Payment {

    protected int orderID;
    protected double amount;
    protected String paymentMethod;
    protected int paymentID;

    public Payment(String value, int amount) {
    }

    public int getOrderID() {
        return orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public Payment(int orderID, double amount, String paymentMethod, int paymentID) {



        
        this.orderID = orderID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentID = paymentID;
    }
}
