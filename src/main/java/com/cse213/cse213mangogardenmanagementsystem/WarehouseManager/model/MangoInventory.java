package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import java.io.Serializable;

public class MangoInventory implements Serializable {

    protected String MangoQuantity ;
    protected String SpoilageQuantity;


    public MangoInventory(String mangoQuantity, String spoilageQuantity) {
        MangoQuantity = mangoQuantity;
        SpoilageQuantity = spoilageQuantity;
    }

    public String getMangoQuantity() {
        return MangoQuantity;
    }

    public void setMangoQuantity(String mangoQuantity) {
        MangoQuantity = mangoQuantity;
    }

    public String getSpoilageQuantity() {
        return SpoilageQuantity;
    }

    public void setSpoilageQuantity(String spoilageQuantity) {
        SpoilageQuantity = spoilageQuantity;
    }

    @Override
    public String toString() {
        return "MangoInventory{" +
                "MangoQuantity='" + MangoQuantity + '\'' +
                ", SpoilageQuantity='" + SpoilageQuantity + '\'' +
                '}';
    }
}
