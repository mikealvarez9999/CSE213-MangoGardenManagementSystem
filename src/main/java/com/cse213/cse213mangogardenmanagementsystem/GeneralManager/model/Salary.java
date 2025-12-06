package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;

import java.io.Serializable;
import java.util.Random;


public class Salary implements Serializable {
    int payID;
    double netPay;
    String month;
    GardenWorker worker;

    private static final Random RANDOM = new Random();

    public Salary(double netPay, String month, GardenWorker worker) {
        this.payID = 100 + RANDOM.nextInt(900);
        this.netPay = netPay;
        this.month = month;
        this.worker = worker;
    }
}
