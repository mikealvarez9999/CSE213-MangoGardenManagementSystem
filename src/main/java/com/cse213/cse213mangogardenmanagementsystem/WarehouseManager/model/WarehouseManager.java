package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class WarehouseManager extends Employee implements Serializable {

    private static final String FILE_NAME = "batchData.bin";
    private static final String INV_FILE_NAME = "inventoryData.bin";

    public WarehouseManager(String username, String password, String employeeID, String name) {
        super(username, password, employeeID, name, "WarehouseManager");
    }

    public static boolean recordBatch(ObservableList<MangoBatch> newBatchList){
        ObservableList<MangoBatch> existingBatches = getMangoBatch();

        for(MangoBatch b : newBatchList){
            boolean exists = existingBatches.stream()
                    .anyMatch(e -> e.getBatchId().equals(b.getBatchId()));
            if(!exists) existingBatches.add(b);
        }

        try {
            FileReadWrite.saveData(existingBatches, FILE_NAME);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static ObservableList<MangoBatch> getMangoBatch(){
        ObservableList<MangoBatch> batchList = FileReadWrite.loadData(MangoBatch.class, FILE_NAME);
        if(batchList == null) return FXCollections.observableArrayList();
        return batchList;
    }

    public static ObservableList<MangoInventory> getMangoInventory(){
        ObservableList<MangoInventory> invList = FileReadWrite.loadData(MangoInventory.class, INV_FILE_NAME);
        if(invList == null) return FXCollections.observableArrayList();
        return invList;
    }

    public static boolean mangoInventory(ObservableList<MangoInventory> invList) {
        try {
            FileReadWrite.saveData(invList, INV_FILE_NAME);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
