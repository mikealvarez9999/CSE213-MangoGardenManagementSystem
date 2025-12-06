package com.cse213.cse213mangogardenmanagementsystem.TransportManager.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransportManager implements Serializable {

    private static final String VEHICLE_FILE = "vehicles.bin";
    private static final String DRIVER_FILE = "drivers.bin";
    private static final String ORDER_FILE = "orders.bin";

    private ArrayList<Vehicles> vehicleList = new ArrayList<>();
    private ArrayList<Drivers> driverList = new ArrayList<>();
    private ArrayList<orders> orderList = new ArrayList<>();

    public TransportManager() {
        loadVehicleData();
        loadDriverData();
        loadOrderData();

        if (vehicleList.isEmpty()) loadVehicleDemoData();
        if (driverList.isEmpty()) loadDriverDemoData();
        if (orderList.isEmpty()) loadOrderDemoData();
    }

    private void loadVehicleDemoData() {
        vehicleList.add(new Vehicles("V1", "Truck", "Available", 2000, null));
        vehicleList.add(new Vehicles("V2", "Van", "Unavailable", 800, null));
        vehicleList.add(new Vehicles("V3", "Pickup", "Available", 1200, null));
        vehicleList.add(new Vehicles("V4", "Mini Truck", "Available", 1500, null));
        vehicleList.add(new Vehicles("V5", "Cargo Van", "Unavailable", 1000, null));
        saveVehicleData();
    }

    public ArrayList<Vehicles> getVehicleList() { return vehicleList; }
    public void saveVehicleData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VEHICLE_FILE))) {
            oos.writeObject(vehicleList);
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void loadVehicleData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VEHICLE_FILE))) {
            vehicleList = (ArrayList<Vehicles>) ois.readObject();
        } catch (Exception e) { vehicleList = new ArrayList<>(); }
    }

    private void loadDriverDemoData() {
        driverList.add(new Drivers("D1", "Ali", "Heavy", "Available"));
        driverList.add(new Drivers("D2", "Babu", "Light", "Available"));
        driverList.add(new Drivers("D3", "Cia", "Heavy", "Unavailable"));
        driverList.add(new Drivers("D4", "Dipu", "Light", "Available"));
        driverList.add(new Drivers("D5", "Eli", "Heavy", "Available"));
        saveDriverData();
    }

    public ArrayList<Drivers> getDriverList() { return driverList; }
    public void saveDriverData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DRIVER_FILE))) {
            oos.writeObject(driverList);
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void loadDriverData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DRIVER_FILE))) {
            driverList = (ArrayList<Drivers>) ois.readObject();
        } catch (Exception e) { driverList = new ArrayList<>(); }
    }

    private void loadOrderDemoData() {
        orderList.add(new orders("O1", 100, "Uttara"));
        orderList.add(new orders("O2", 50, "Mirpur"));
        orderList.add(new orders("O3", 70, "dhanmondi"));
        orderList.add(new orders("O4", 90, "Bashundhara"));
        orderList.add(new orders("O5", 60, "Ajompur"));
        saveOrderData();
    }

    public ArrayList<orders> getOrderList() { return orderList; }
    public void saveOrderData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDER_FILE))) {
            oos.writeObject(orderList);
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void loadOrderData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDER_FILE))) {
            orderList = (ArrayList<orders>) ois.readObject();
        } catch (Exception e) { orderList = new ArrayList<>(); }
    }

    public void assignDriverToVehicle(String driverID, String vehicleID) {
        Drivers d = driverList.stream().filter(dr -> dr.getDriverID().equals(driverID)).findFirst().orElse(null);
        Vehicles v = vehicleList.stream().filter(ve -> ve.getVehicleID().equals(vehicleID)).findFirst().orElse(null);

        if (d != null && v != null) {
            d.setAvailability("Unavailable");
            v.setAvailability("Unavailable");
            saveDriverData();
            saveVehicleData();
        }
    }


    public void updateMaintenanceDate(String vehicleID, LocalDate date) {
        for (Vehicles v : vehicleList) {
            if (v.getVehicleID().equals(vehicleID)) {
                v.setMaintenanceDate(date);
                break;
            }
        }
        saveVehicleData();
    }
}
