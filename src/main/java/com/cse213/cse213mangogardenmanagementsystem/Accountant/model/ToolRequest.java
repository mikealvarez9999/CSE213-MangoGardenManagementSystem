package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

public interface ToolRequest {
    int getId();

    void setStatus(String approved);

    double getEstimatedCost();

    String getToolName();
}
