package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;

import java.util.ArrayList;

public class Customer {
    private String customerID, address;
    private ArrayList<Order> orderList;

    private static final String ORDER_FILE = "Orders.bin";

    public static boolean addOrderToFile(Order orderToAdd){
        try {
            FileReadWrite.append(Order.class, ORDER_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
