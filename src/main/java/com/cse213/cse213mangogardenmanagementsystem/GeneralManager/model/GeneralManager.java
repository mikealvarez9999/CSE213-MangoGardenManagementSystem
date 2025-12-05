package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import com.cse213.cse213mangogardenmanagementsystem.GardenWorker.model.GardenWorker;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

public class GeneralManager {
    public GeneralManager(String gmUser, String number, String e001, String aliceSmith) {
    }

    private static final String TASK_FILE = "Tasks.bin";
    private static final String WORKER_FILE = "Workers.bin";
    private static final String SALARY_RECORDS_FILE = "SalaryRecords.bin";
    private static final String BUDGET_REQUESTS_FILE = "BudgetRequests.bin";

    public static boolean addTaskToFile(Task task){
        try {
            FileReadWrite.append(task, TASK_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<Task> loadTasksFromFile(){
        ObservableList<Task> tasksfromfile = FXCollections.observableArrayList();
        tasksfromfile = FileReadWrite.loadData(Task.class, TASK_FILE);
        return tasksfromfile;
    }

    public static ObservableList<GardenWorker> loadWorkers(){
        ObservableList<GardenWorker> workerObservableList = FXCollections.observableArrayList();
        workerObservableList = FileReadWrite.loadData(GardenWorker.class, WORKER_FILE);
        return workerObservableList;
    }

    public static boolean addNewSalaryRecord(Salary salaryRecord){
        try {
            FileReadWrite.append(salaryRecord, SALARY_RECORDS_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<BudgetRequest> loadBudgetRequests(){
        ObservableList<BudgetRequest> budgetRequestObservableList = FXCollections.observableArrayList();
        budgetRequestObservableList = FileReadWrite.loadData(BudgetRequest.class, BUDGET_REQUESTS_FILE);
        return budgetRequestObservableList;
    }
}
