package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model;

import java.io.Serializable;

public class FieldIssues implements Serializable {

    private String issueType;
    private String describeIssue;

    public FieldIssues(String issueType, String describeIssue) {
        this.issueType = issueType;
        this.describeIssue = describeIssue;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescribeIssue() {
        return describeIssue;
    }

    public void setDescribeIssue(String describeIssue) {
        this.describeIssue = describeIssue;
    }

    @Override
    public String toString() {
        return "FieldIssues{" +
                "issueType='" + issueType + '\'' +
                ", describeIssue='" + describeIssue + '\'' +
                '}';
    }
}