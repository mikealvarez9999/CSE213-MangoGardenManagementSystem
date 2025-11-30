package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

public class UpdateInventory {

    private String batchId;
    private String mangoType; // "Add" or "Remove"
    private double quantity;


    public UpdateInventory(String batchId, String mangoType, double quantity) {
        this.batchId = batchId;
        this.mangoType = mangoType;
        this.quantity = quantity;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UpdateInventory{" +
                "batchId='" + batchId + '\'' +
                ", mangoType='" + mangoType + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
