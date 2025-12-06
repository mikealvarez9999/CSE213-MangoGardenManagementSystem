package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;

public class TransportManager extends Employee implements Serializable {

    private static final String VEHICLE_FILE = "vehicles.bin";
    private static final String DRIVER_FILE = "drivers.bin";
    private static final String ORDER_FILE = "orders.bin";

    private static ObservableList<Vehicles> vehicleList = FXCollections.observableArrayList();
    private static ObservableList<Drivers> driverList = FXCollections.observableArrayList();
    private static ObservableList<orders> orderList = FXCollections.observableArrayList();

    public TransportManager(String username, String password, String employeeID, String name) {
        super(username, password, employeeID, name, "TransportManager");

    }


    public static void loadVehicleDemoData() {
        vehicleList.add(new Vehicles("V1", "Truck", "Available", 2000, null));
        vehicleList.add(new Vehicles("V2", "Van", "Unavailable", 800, null));
        vehicleList.add(new Vehicles("V3", "Pickup", "Available", 1200, null));
        vehicleList.add(new Vehicles("V4", "Mini Truck", "Available", 1500, null));
        vehicleList.add(new Vehicles("V5", "Cargo Van", "Unavailable", 1000, null));
    }

    public static ObservableList<Vehicles> getVehicleList() {
        loadVehicleDemoData();
//        loadVehicleData();

        return vehicleList;
    }

    public static boolean saveVehicleData() {
//        FileReadWrite.saveData(vehicleList,VEHICLE_FILE);
        try{
            FileReadWrite.saveData(vehicleList,VEHICLE_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ObservableList<Vehicles> loadVehicleData() {
//        FileReadWrite.loadData(Vehicles.class,VEHICLE_FILE);
//        ObservableList<Vehicles> vehicleList = FXCollections.observableArrayList();
        try {
            vehicleList = FileReadWrite.loadData(Vehicles.class,VEHICLE_FILE);
            return vehicleList;
        } catch (Exception e) {
            return vehicleList;
        }
    }

    private static void loadDriverDemoData() {
        driverList.add(new Drivers("D1", "Ali", "Heavy", "Available"));
        driverList.add(new Drivers("D2", "Babu", "Light", "Available"));
        driverList.add(new Drivers("D3", "Cia", "Heavy", "Unavailable"));
        driverList.add(new Drivers("D4", "Dipu", "Light", "Available"));
        driverList.add(new Drivers("D5", "Eli", "Heavy", "Available"));
    }

    public static ObservableList<Drivers> getDriverList() {
        loadDriverDemoData();
//        loadDriverData();
        return driverList;
    }

    public static boolean saveDriverData() {
//        FileReadWrite.saveData(driverList,DRIVER_FILE);
        try {
            FileReadWrite.saveData(driverList,DRIVER_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ObservableList<Drivers> loadDriverData() {
//        FileReadWrite.loadData(Drivers.class,DRIVER_FILE);
        try {
            driverList = FileReadWrite.loadData(Drivers.class,DRIVER_FILE);
            return driverList;
        } catch (Exception e) {
            return driverList;
        }
    }

    private static void loadOrderDemoData() {
        orderList.add(new orders("O1", 100, "Uttara"));
        orderList.add(new orders("O2", 50, "Mirpur"));
        orderList.add(new orders("O3", 70, "dhanmondi"));
        orderList.add(new orders("O4", 90, "Bashundhara"));
        orderList.add(new orders("O5", 60, "Ajompur"));
    }

    public static ObservableList<orders> getOrderList() {
        loadOrderDemoData();
//        loadOrderData();
        return orderList;
    }

    public boolean saveOrderData() {
        try  {
            FileReadWrite.saveData(orderList,ORDER_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ObservableList<orders> loadOrderData() {
        try {
            orderList = FileReadWrite.loadData(orders.class,ORDER_FILE);
            return orderList;
        } catch (Exception e) {
            return orderList;
        }
    }

    public static void assignDriverToVehicle(String driverID, String vehicleID) {
        Drivers d = driverList.stream().filter(dr -> dr.getDriverID().equals(driverID)).findFirst().orElse(null);
        Vehicles v = vehicleList.stream().filter(ve -> ve.getVehicleID().equals(vehicleID)).findFirst().orElse(null);

        if (d != null && v != null) {
            d.setAvailability("Unavailable");
            v.setAvailability("Unavailable");
            saveDriverData();
            saveVehicleData();
        }
    }


    public static void updateMaintenanceDate(String vehicleID, LocalDate date) {
        for (Vehicles v : vehicleList) {
            if (v.getVehicleID().equals(vehicleID)) {
                v.setMaintenanceDate(date);
                break;
            }
        }
        saveVehicleData();
    }
}
