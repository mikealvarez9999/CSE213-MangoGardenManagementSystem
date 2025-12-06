package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GardenWorker extends com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker {
    private double salaryRate;
    private int id;
    private ObservableList<GardenWorker> workers = FXCollections.observableArrayList();
    public double getSalaryRate() {
        return salaryRate ;
    }

    public int getWorkerID() {
        return id;

    }

    public String getName(){
        return "Dummy Name";
    }

    public boolean setSalaryRate(double newSalaryRate) {
        try {
            this.salaryRate = newSalaryRate;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
//
//    public ObservableList<GardenWorker> loadWorkers(){
//
//        return workers;
//    }
}
