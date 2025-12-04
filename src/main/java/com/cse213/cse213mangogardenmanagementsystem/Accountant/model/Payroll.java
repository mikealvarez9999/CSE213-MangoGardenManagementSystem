package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Payroll implements Serializable {

    private final int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employeeID;
    private double netWages;
    private static final Random RANDOM = new Random();

    public Payroll(LocalDate startDate, LocalDate endDate, String employeeID, double netWages) {
        this.id = 1000 + RANDOM.nextInt(9000);
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeID = employeeID;
        this.netWages = netWages;
    }


    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getNetWages() {
        return netWages;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setNetWages(double netWages) {
        this.netWages = netWages;
    }
}