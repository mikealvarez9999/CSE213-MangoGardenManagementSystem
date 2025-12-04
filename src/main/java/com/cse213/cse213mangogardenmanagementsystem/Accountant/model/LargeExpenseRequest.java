package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class LargeExpenseRequest implements Serializable {

    private static final Random RANDOM = new Random();

    private final int id;
    private LocalDate date;
    private double amount;
    private String description;
    private String status;


    public LargeExpenseRequest(LocalDate date, double amount, String description) {
        this.id = 1000 + RANDOM.nextInt(9000);
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.status = "Pending";
    }


    public boolean updateRequest(LocalDate date, String category, String type, double amount, String description) {
        try {
            this.date = date;
            this.amount = amount;
            this.description = description;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }


    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public boolean setStatus(String status) {
        try {
            this.status = status;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}