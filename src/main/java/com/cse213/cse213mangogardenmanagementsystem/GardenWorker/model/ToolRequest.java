package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ToolRequest implements Serializable {

    private String toolName;
    private int quantity;
    private LocalDate requestDate;

    public ToolRequest(String toolName, int quantity, LocalDate requestDate) {
        this.toolName = toolName;
        this.quantity = quantity;
        this.requestDate = requestDate;
    }

    // Getters and setters
    public String getToolName() { return toolName; }
    public void setToolName(String toolName) { this.toolName = toolName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
}