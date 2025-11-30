package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class RecordBatch implements Serializable {

    protected String batchId;
    protected String mangoType;
    protected LocalDate harvestDate;
    protected String fieldNumber;

    public RecordBatch(String batchId, String mangoType, LocalDate harvestDate, String fieldNumber) {
        this.batchId = batchId;
        this.mangoType = mangoType;
        this.harvestDate = harvestDate;
        this.fieldNumber = fieldNumber;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getMangoType() {
        return mangoType;
    }

    public void setMangoType(String mangoType) {
        this.mangoType = mangoType;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(String fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    @Override
    public String toString() {
        return "RecordBatch{" +
                "batchId='" + batchId + '\'' +
                ", mangoType='" + mangoType + '\'' +
                ", harvestDate=" + harvestDate +
                ", fieldNumber='" + fieldNumber + '\'' +
                '}';
    }
}
