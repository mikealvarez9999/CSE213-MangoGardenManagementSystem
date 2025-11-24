package com.cse213.cse213mangogardenmanagementsystem;

import java.util.List;
import java.util.Optional;

/**
 * Provides hardcoded user data for testing and demonstration purposes.
 * In a real application, this would connect to a database.
 */
public class UserDatabaseMock {

    private static final List<Employee> ALL_USERS = List.of(
            // General Manager (Test User)
            new Employee("gm", "12345", "E001", "Alice Smith", "GeneralManager"),

            // Owner Test User
            new Employee("owner", "123", "E000", "Bob Owner", "Owner"),

            // Other roles for testing the loading paths
            new Employee("acc", "12345", "E002", "Charlie Accountant", "Accountant"),
            new Employee("wm", "12345", "E001", "Alice Smith", "WarehouseManager"),
            new Employee("tm", "12345", "E001", "Alice Smith", "TransportManager"),
            new Employee("fs", "12345", "E001", "Alice Smith", "FieldSupervisor"),
            new Employee("gw", "12345", "E001", "Alice Smith", "GardenWorker"),
            new Employee("customer", "12345", "E001", "Alice Smith", "Customer")

    );

    /**
     * Finds a user by matching username and password against the mock database.
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return An Optional containing the Employee if credentials match, or empty otherwise.
     */
    public static Optional<Employee> authenticate(String username, String password) {
        return ALL_USERS.stream()
                .filter(user -> user.login(username, password))
                .findFirst();
    }
}