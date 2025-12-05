package com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class WarehouseManager {

    private static final String FILE_NAME = "batchData.bin";
    private static final String INV_FILE_NAME = "inventoryData.bin";

    public static boolean recordBatch(ObservableList<MangoBatch> batchList){
        FileReadWrite.saveData(batchList, FILE_NAME);

        return false;
    }

    public static ObservableList<MangoBatch> getMangoBatch(){
        ObservableList<MangoBatch> batchList;
        batchList = FileReadWrite.loadData(MangoBatch.class,FILE_NAME);
        return batchList;
    }

    public static ObservableList<MangoInventory> getMangoInventory(){
        ObservableList<MangoInventory> invList;
        invList = FileReadWrite.loadData(MangoInventory.class,INV_FILE_NAME);
        return invList;
    }

    public static boolean mangoInventory(ObservableList<MangoInventory> invList) {
        try {
            FileReadWrite.saveData(invList, INV_FILE_NAME);
            return true;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return false;
        }
    }
    
    public boolean updateInventory() {
        // TODO: implement logic
        return false;
    }

    // 4. Track Spoilage
    public boolean trackSpoilage() {
        // TODO: implement logic
        return false;
    }

    // 5. Approve order and prepare
    public boolean approveOrderAndPrepare() {
        // TODO: implement logic
        return false;
    }

    // 6. Send order to transport
    public boolean sendOrderToTransport() {
        // TODO: implement logic
        return false;
    }

    // 7. Inventory Summary
    public String inventorySummary() {
        // TODO: implement logic
        return null;
    }

    // 8. Request Harvest
    public boolean requestHarvest() {
        // TODO: implement logic
        return false;
    }
}
