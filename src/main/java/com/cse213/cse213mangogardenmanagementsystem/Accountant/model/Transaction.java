package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Transaction implements Serializable {

    private final int id;
    private double amount;
    private String type;
    private String category;
    private LocalDate date;
    private String description;

    private static final Random RANDOM = new Random();

    public Transaction(double amount, String type, String category, LocalDate date, String description) {
        this.id = 100000 + RANDOM.nextInt(900000);
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public boolean updateTransaction(double amount, String type, String category, LocalDate date, String description) {
        try {
            this.amount = amount;
            this.type = type;
            this.category = category;
            this.date = date;
            this.description = description;
            return true;
        } catch (Exception e) {
            System.err.println("Error updating transaction data: " + e.getMessage());
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}