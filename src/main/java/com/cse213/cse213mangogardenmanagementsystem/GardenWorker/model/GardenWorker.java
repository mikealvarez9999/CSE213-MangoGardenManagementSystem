package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GardenWorker {

    private static final String TOOL_REQUEST_FILE = "toolRequests.bin";
    private static final String FIELD_ISSUES_FILE = "fieldIssues.bin";
    private static final String DAILY_HARVEST_FILE = "dailyHarvest.bin";

    // Tool Requests
    public static ObservableList<ToolRequest> getToolRequests() {
        ObservableList<ToolRequest> list = FileReadWrite.loadData(ToolRequest.class, TOOL_REQUEST_FILE);
        return list != null ? list : FXCollections.observableArrayList();
    }

    public static boolean saveToolRequests(ObservableList<ToolRequest> list) {
        try {
            FileReadWrite.saveData(list, TOOL_REQUEST_FILE);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Field Issues
    public static ObservableList<FieldIssues> getFieldIssues() {
        ObservableList<FieldIssues> list = FileReadWrite.loadData(FieldIssues.class, FIELD_ISSUES_FILE);
        return list != null ? list : FXCollections.observableArrayList();
    }

    public static boolean saveFieldIssues(ObservableList<FieldIssues> list) {
        try {
            FileReadWrite.saveData(list, FIELD_ISSUES_FILE);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Daily Harvest
    public static ObservableList<DailyHarvest> getDailyHarvest() {
        ObservableList<DailyHarvest> list = FileReadWrite.loadData(DailyHarvest.class, DAILY_HARVEST_FILE);
        return list != null ? list : FXCollections.observableArrayList();
    }

    public static boolean saveDailyHarvest(ObservableList<DailyHarvest> list) {
        try {
            FileReadWrite.saveData(list, DAILY_HARVEST_FILE);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}