package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class LargeExpenseRequest implements Serializable {

    // --- Persistence Setup ---
    private static final String FILE_NAME = "large_expense_requests.bin";

    // Static storage initialized by reading from file
    private static List<LargeExpenseRequest> REQUEST_RECORDS = FileReadWrite.loadData(FILE_NAME);

    private static final Random RANDOM = new Random();

    // --- Data Fields ---
    private int id;
    private LocalDate date;
    private String category;
    private String type;
    private double amount;
    private String description;
    private String status; // NEW FIELD: Approval status

    /**
     * Private Constructor used internally to create a new LargeExpenseRequest object.
     * Sets initial status to "Pending Owner Approval".
     */
    private LargeExpenseRequest(LocalDate date, String category, String type, double amount, String description) {
        this.id = 300000 + RANDOM.nextInt(900000); // Unique ID range
        this.date = date;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.status = "Pending Owner Approval"; // Default initial status
    }

    // --- Persistence/CRUD Methods ---

    /**
     * Creates a new LargeExpenseRequest object and saves it to the static record list and file.
     */
    public static LargeExpenseRequest addRequest(LocalDate date, String category, String type, double amount, String description) {
        LargeExpenseRequest newRecord = new LargeExpenseRequest(date, category, type, amount, description);
        REQUEST_RECORDS.add(newRecord);
        System.out.println("New Large Expense Request recorded with ID: " + newRecord.getId());
        FileReadWrite.saveData(REQUEST_RECORDS, FILE_NAME);
        return newRecord;
    }

    /**
     * Updates the current LargeExpenseRequest instance's details and saves changes to file.
     * (Note: Status update is typically handled by a dedicated setter/method)
     */
    public void updateRequest(LocalDate date, String category, String type, double amount, String description) {
        this.date = date;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.description = description;
        // Status remains unchanged unless explicitly set via setStatus()
        System.out.println("Large Expense Request ID " + this.id + " updated successfully.");
        FileReadWrite.saveData(REQUEST_RECORDS, FILE_NAME);
    }

    /**
     * Deletes a LargeExpenseRequest record by its ID from the static list and saves the changes.
     * @param id The ID of the request to delete.
     * @return true if the request was found and deleted, false otherwise.
     */
    public static boolean deleteRequest(int id) {
        boolean removed = REQUEST_RECORDS.removeIf(r -> r.id == id);
        if (removed) {
            System.out.println("Large Expense Request ID " + id + " deleted.");
            FileReadWrite.saveData(REQUEST_RECORDS, FILE_NAME);
        } else {
            System.out.println("Large Expense Request ID " + id + " not found for deletion.");
        }
        return removed;
    }

    /**
     * Retrieves all saved large expense requests.
     */
    public static List<LargeExpenseRequest> getAllRequests() {
        return REQUEST_RECORDS;
    }

    /**
     * Finds a large expense request by its ID.
     */
    public static Optional<LargeExpenseRequest> findById(int id) {
        return REQUEST_RECORDS.stream()
                .filter(r -> r.id == id)
                .findFirst();
    }

    // --- Getters and Setters ---

    public int getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getStatus() { return status; } // Getter for new field

    public void setDate(LocalDate date) { this.date = date; }
    public void setCategory(String category) { this.category = category; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDescription(String description) { this.description = description; }

    /**
     * Setter for the status field. Automatically saves changes to file.
     * Used by the Owner/approver to change status to Approved, Rejected, etc.
     */
    public void setStatus(String status) {
        this.status = status;
        FileReadWrite.saveData(REQUEST_RECORDS, FILE_NAME);
    }
}