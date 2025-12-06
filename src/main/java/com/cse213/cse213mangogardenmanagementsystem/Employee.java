package com.cse213.cse213mangogardenmanagementsystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

// Note: This file now uses the fixed User class
public class Employee extends User implements Serializable {
    private final int employeeID;
    private String name;
    private String role;
    private LocalDate joiningDate;
    private Random RANDOM = new Random();

    public Employee(String username, String password, String employeeID, String name, String role) {
        // CRITICAL FIX: Pass the provided parameters (username, password) to the User constructor
        super(username, password);
        this.employeeID = employeeID;
        this.name = name;
        this.role = role;
    }

    public Employee(String username, String password, String name, String role, LocalDate joiningDate, String phoneNo) {
        // CRITICAL FIX: Pass the provided parameters (username, password) to the User constructor
        super(username, password);
        this.employeeID = 1000 + RANDOM.nextInt(9999);
        this.name = name;
        this.role = role;
        this.phoneNo = phoneNo;
        this.joiningDate = joiningDate;
    }


    // Getters and Setters (omitted for brevity)
    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public LocalDate getJoiningDate() { return joiningDate; }
}