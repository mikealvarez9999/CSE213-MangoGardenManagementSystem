package com.cse213.cse213mangogardenmanagementsystem.Owner.model;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Owner {
    private static final String EMPLOYEES_FILE = "Employees.bin";
    private static final String LARGE_EXPENSES_FILE = "Large Expenses.bin";
    private static final String SPECIAL_ORDERS_FILE = "Special Orders.bin";
    private static final String ORDERS_FILE = "Orders.bin";
    private static final String TASK_FILE = "Tasks.bin";

    public static boolean addNewEmployee(Employee toAdd){
        try {
            FileReadWrite.append(toAdd, EMPLOYEES_FILE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<Employee> loadAllEmployees(){
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        employeeList = FileReadWrite.loadData(Employee.class, EMPLOYEES_FILE);
        return employeeList;
    }

    public static boolean fireEmployee(Employee toFire){
        try {
            ObservableList<Employee> currentEmployeeList = Owner.loadAllEmployees();
            boolean isRemoved = currentEmployeeList.remove(toFire);
            if (isRemoved){
                FileReadWrite.saveData(currentEmployeeList, EMPLOYEES_FILE);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<Task> loadAllTasks(){
        ObservableList<Task> taskList = FXCollections.observableArrayList();
        taskList = FileReadWrite.loadData(Task.class, TASK_FILE);
        return taskList;
    }

    public static ObservableList<Order> loadAllOrders() {
        ObservableList<Order> orderList = FXCollections.observableArrayList();
        orderList = FileReadWrite.loadData(Order.class, ORDERS_FILE);
        return orderList;
    }

    public static ObservableList<LargeExpenseRequest> loadAllLargeExpenseRequests(){
        ObservableList<LargeExpenseRequest> largeExpenseRequests = FXCollections.observableArrayList();
        largeExpenseRequests = FileReadWrite.loadData(LargeExpenseRequest.class, LARGE_EXPENSES_FILE);
        return largeExpenseRequests;
    }
}
