package com.cse213.cse213mangogardenmanagementsystem.Customer.model;

import java.io.Serializable;

public class SpecialOrder extends Order implements Serializable {
    public SpecialOrder(String type, int quantity, String phoneNum) {
        super(type, quantity, phoneNum);
    }
}
