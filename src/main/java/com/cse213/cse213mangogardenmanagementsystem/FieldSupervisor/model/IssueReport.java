package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;

public class IssueReport implements Serializable {
    private final int id;
    private String issue;
    private String feedback;
    private String status;
    public IssueReport(int id, String issue) {
        this.id = id; this.issue = issue; this.status = "Reported";
    }
    public int getId() { return id; }
    public String getIssue() { return issue; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String f) { this.feedback = f; }

    public void setStatus(String status) {
        this.status = status;

    }
}