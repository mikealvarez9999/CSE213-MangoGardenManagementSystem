package com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model;

import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GeneralManager {
    public GeneralManager(String gmUser, String number, String e001, String aliceSmith) {
    }

    private static final String TASK_FILE = "Tasks.bin";

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
}
