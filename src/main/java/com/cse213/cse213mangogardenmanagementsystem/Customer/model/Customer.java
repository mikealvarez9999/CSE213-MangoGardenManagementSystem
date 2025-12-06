package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import com.cse213.cse213mangogardenmanagementsystem.User;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Customer extends User {
    private String customerID, address;
    private ArrayList<Order> orderList;

    private static final String ORDER_FILE = "Orders.bin";

    public Customer(String userName, String userPwd) {
        super(userName, userPwd);
    }

    public static boolean addOrderToFile(Order orderToAdd){
        try {
            FileReadWrite.append(Order.class, ORDER_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static ObservableList<Order> getOrder(){
        ObservableList<Order> OrderID;
        OrderID = FileReadWrite.loadData(Order.class,ORDER_FILE);
        return OrderID;
    }


    private static final String PAYMENT_FILE = "Payment.bin";

    public static boolean addPaymentToFile(Payment paymentToAdd){
        try {
            FileReadWrite.append(Payment.class, PAYMENT_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
