package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model;

import java.time.LocalDate;

public class DailyHarvest {
    private int quantity;
    private String qualityGrade;
    private LocalDate date;
    private String remarks;
    private int collecterID;

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQualityGrade() {
        return qualityGrade;
    }
    public void setQualityGrade(String qualityGrade) {
        this.qualityGrade = qualityGrade;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getCollecterID() {
        return collecterID;
    }
    public void setCollecterID(int collecterID) {
        this.collecterID = collecterID;
    }
}