package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import java.io.Serializable;

public class MangoInventory implements Serializable {

    private String batchId;
    private String mangoQuantity;
    private String spoiled;
    private MangoBatch batch;  // To link MangoBatch data

    public MangoInventory(String batchId, String mangoQuantity, String spoiled, MangoBatch batch) {
        this.batchId = batchId;
        this.mangoQuantity = mangoQuantity;
        this.spoiled = spoiled;
        this.batch = batch;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getMangoQuantity() {
        return mangoQuantity;
    }

    public void setMangoQuantity(String mangoQuantity) {
        this.mangoQuantity = mangoQuantity;
    }

    public String getSpoiled() {
        return spoiled;
    }

    public MangoBatch getBatch() {
        return batch;
    }

    public void setBatch(MangoBatch batch) {
        this.batch = batch;
    }

    public void setSpoiled(String spoiled) {
        this.spoiled = spoiled;
    }
}
