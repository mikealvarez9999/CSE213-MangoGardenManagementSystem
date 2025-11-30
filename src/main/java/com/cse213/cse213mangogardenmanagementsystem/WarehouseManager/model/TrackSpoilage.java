package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import java.io.Serializable;

public class TrackSpoilage implements Serializable {

    protected String batchId;
    protected double spoilageQuantity;

    public TrackSpoilage(String batchId, double spoilageQuantity) {
        this.batchId = batchId;
        this.spoilageQuantity = spoilageQuantity;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public double getSpoilageQuantity() {
        return spoilageQuantity;
    }

    public void setSpoilageQuantity(double spoilageQuantity) {
        this.spoilageQuantity = spoilageQuantity;
    }

    @Override
    public String toString() {
        return "TrackSpoilage{" +
                "batchId='" + batchId + '\'' +
                ", spoilageQuantity=" + spoilageQuantity +
                '}';
    }
}
