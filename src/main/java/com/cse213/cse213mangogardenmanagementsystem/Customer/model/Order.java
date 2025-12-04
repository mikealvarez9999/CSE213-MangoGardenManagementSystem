package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import java.time.LocalDate;
import java.util.Random;

public class Order {
    private static final Random RANDOM = new Random();

    protected int orderID;
    protected String type;
    protected int quantity;
    protected LocalDate date;
    protected String phoneNum;
    protected double orderAmount;

    public int getOrderID() {
        return orderID;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public Order(String type, int quantity, String phoneNum) {
        this.orderID = 100 + RANDOM.nextInt(900);
        this.type = type;
        this.quantity = quantity;
        this.date = LocalDate.now();
        this.phoneNum = phoneNum;
        this.orderAmount = 0;
    }
}
