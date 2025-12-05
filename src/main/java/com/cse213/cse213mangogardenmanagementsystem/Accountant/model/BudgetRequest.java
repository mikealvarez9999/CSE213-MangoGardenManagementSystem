package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import java.io.Serializable;
import java.util.Random;

public class BudgetRequest implements Serializable {

    private static final Random RANDOM = new Random();

    private final int id;
    private String category;
    private double amount;
    private String purpose;
    private String status;


    public BudgetRequest(String category, double amount, String purpose) {
        this.id = 1000 + RANDOM.nextInt(9000);
        this.category = category;
        this.amount = amount;
        this.purpose = purpose;
        this.status = "Pending";

    }

    public boolean updateRequest(String category, double amount, String purpose) {
        try {
            this.category = category;
            this.amount = amount;
            this.purpose = purpose;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getStatus(){
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