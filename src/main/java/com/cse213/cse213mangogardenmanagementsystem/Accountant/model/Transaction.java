package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Transaction implements Serializable {

    private static final String FILE_NAME = "transactions.bin";

    private static List<Transaction> TRANSACTION_RECORDS = FileReadWrite.loadData(FILE_NAME);

    private int id;
    private double amount;
    private String type;
    private String category;
    private LocalDate date;

    private static final Random RANDOM = new Random();

    /**
     * Private Constructor used internally to create a new, initialized Transaction object.
     */
    private Transaction(double amount, String type, String category, LocalDate date) {
        this.id = 100000 + RANDOM.nextInt(900000);
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
    }

    // --- Persistence/CRUD Methods ---

    /**
     * Creates a new Transaction object and saves it to the static record list and file.
     */
    public static Transaction addTransaction(double amount, String type, String category, LocalDate date) {
        Transaction newRecord = new Transaction(amount, type, category, date);
        TRANSACTION_RECORDS.add(newRecord);
        System.out.println("New Transaction recorded with ID: " + newRecord.getId());
        FileReadWrite.saveData(TRANSACTION_RECORDS, FILE_NAME); // Use utility
        return newRecord;
    }

    /**
     * Updates the current Transaction instance's details and saves changes to file.
     */
    public void updateTransaction(double amount, String type, String category, LocalDate date) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
        System.out.println("Transaction ID " + this.id + " updated successfully.");
        FileReadWrite.saveData(TRANSACTION_RECORDS, FILE_NAME); // Use utility
    }

    /**
     * Deletes a Transaction record by its ID from the static list and saves the changes.
     * @param id The ID of the transaction to delete.
     * @return true if the transaction was found and deleted, false otherwise.
     */
    public static boolean deleteTransaction(int id) {
        boolean removed = TRANSACTION_RECORDS.removeIf(t -> t.id == id);
        if (removed) {
            System.out.println("Transaction ID " + id + " deleted.");
            FileReadWrite.saveData(TRANSACTION_RECORDS, FILE_NAME);
        } else {
            System.out.println("Transaction ID " + id + " not found for deletion.");
        }
        return removed;
    }

    /**
     * Retrieves all saved transactions.
     */
    public static List<Transaction> getAllTransactions() {
        return TRANSACTION_RECORDS;
    }

    /**
     * Finds a transaction by its ID.
     */
    public static Optional<Transaction> findById(int id) {
        return TRANSACTION_RECORDS.stream()
                .filter(t -> t.id == id)
                .findFirst();
    }

    // --- Getters and Setters ---

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setType(String type) { this.type = type; }
    public void setCategory(String category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }
}