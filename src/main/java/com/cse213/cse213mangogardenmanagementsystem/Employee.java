package com.cse213.cse213mangogardenmanagementsystem;

// Note: This file now uses the fixed User class
public class Employee extends User {
    private final String employeeID;
    private String name;
    private String role;

    public Employee(String username, String password, String employeeID, String name, String role) {
        // CRITICAL FIX: Pass the provided parameters (username, password) to the User constructor
        super(username, password);
        this.employeeID = employeeID;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters (omitted for brevity)
    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getRole() { return role; }
}