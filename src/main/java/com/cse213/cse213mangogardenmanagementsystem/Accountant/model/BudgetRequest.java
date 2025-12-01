package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BudgetRequest implements Serializable {

    // --- Persistence Setup ---
    private static final String FILE_NAME = "budget_requests.bin";

    // Static storage initialized by reading from file
    private static List<BudgetRequest> BUDGET_RECORDS = FileReadWrite.loadData(FILE_NAME);

    private static final Random RANDOM = new Random();

    // --- Data Fields ---
    private int id;
    private String category;
    private double amount;
    private String purpose;

    /**
     * Private Constructor used internally to create a new BudgetRequest object.
     */
    private BudgetRequest(String category, double amount, String purpose) {
        this.id = 200000 + RANDOM.nextInt(900000); // Unique ID range for requests
        this.category = category;
        this.amount = amount;
        this.purpose = purpose;
    }

    // --- Persistence/CRUD Methods ---

    /**
     * Creates a new BudgetRequest object and saves it to the static record list and file.
     */
    public static BudgetRequest addRequest(String category, double amount, String purpose) {
        BudgetRequest newRecord = new BudgetRequest(category, amount, purpose);
        BUDGET_RECORDS.add(newRecord);
        System.out.println("New Budget Request recorded with ID: " + newRecord.getId());
        FileReadWrite.saveData(BUDGET_RECORDS, FILE_NAME); // Use utility
        return newRecord;
    }

    /**
     * Updates the current BudgetRequest instance's details and saves changes to file.
     */
    public void updateRequest(String category, double amount, String purpose) {
        this.category = category;
        this.amount = amount;
        this.purpose = purpose;
        System.out.println("Budget Request ID " + this.id + " updated successfully.");
        FileReadWrite.saveData(BUDGET_RECORDS, FILE_NAME); // Use utility
    }

    /**
     * Deletes a BudgetRequest record by its ID from the static list and saves the changes.
     * @param id The ID of the request to delete.
     * @return true if the request was found and deleted, false otherwise.
     */
    public static boolean deleteRequest(int id) {
        boolean removed = BUDGET_RECORDS.removeIf(r -> r.id == id);
        if (removed) {
            System.out.println("Budget Request ID " + id + " deleted.");
            FileReadWrite.saveData(BUDGET_RECORDS, FILE_NAME);
        } else {
            System.out.println("Budget Request ID " + id + " not found for deletion.");
        }
        return removed;
    }

    /**
     * Retrieves all saved budget requests.
     */
    public static List<BudgetRequest> getAllRequests() {
        return BUDGET_RECORDS;
    }

    /**
     * Finds a budget request by its ID.
     */
    public static Optional<BudgetRequest> findById(int id) {
        return BUDGET_RECORDS.stream()
                .filter(r -> r.id == id)
                .findFirst();
    }

    // --- Getters and Setters ---

    public int getId() { return id; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getPurpose() { return purpose; }

    public void setCategory(String category) { this.category = category; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
}