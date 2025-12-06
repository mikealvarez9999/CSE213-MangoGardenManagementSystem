package com.cse213.cse213mangogardenmanagementsystem.Owner.model;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.LargeExpenseRequest;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.SpecialOrder;
import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import com.cse213.cse213mangogardenmanagementsystem.User;
import com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.model.MangoInventory;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class Owner extends User implements Serializable {
    private static final String EMPLOYEES_FILE = "Employees.bin";
    private static final String LARGE_EXPENSES_FILE = "LargeExpenses.bin";
    private static final String SPECIAL_ORDERS_FILE = "SpecialOrders.bin";
    private static final String ORDERS_FILE = "Orders.bin";
    private static final String TASK_FILE = "Tasks.bin";
    private static final String INVENTORY_FILE = "inventoryData.bin"

    public Owner(String userName, String userPwd) {
        super(userName, userPwd);
    }

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

    public static boolean approveRejectLargeExpenseRequest(LargeExpenseRequest updatedRequest){
        try {
            ObservableList<LargeExpenseRequest> largeExpenseRequests = loadAllLargeExpenseRequests();
            for (int i = 0; i < largeExpenseRequests.size(); i++){
                LargeExpenseRequest currentRequest = largeExpenseRequests.get(i);
                if (currentRequest.getId() == updatedRequest.getId()){
                    largeExpenseRequests.set(i, updatedRequest);
                    FileReadWrite.saveData(largeExpenseRequests, LARGE_EXPENSES_FILE);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<SpecialOrder> loadAllSpecialOrders(){
        ObservableList<SpecialOrder> specialOrders = FXCollections.observableArrayList();
        specialOrders = FileReadWrite.loadData(SpecialOrder.class, SPECIAL_ORDERS_FILE);
        return specialOrders;
    }

    public static boolean approveRejectSpecialOrder(SpecialOrder updatedOrder){
        try {
            ObservableList<SpecialOrder> specialOrders = loadAllSpecialOrders();
            for (int i = 0; i < specialOrders.size(); i++){
                SpecialOrder currentOrder = specialOrders.get(i);
                if (currentOrder.getOrderID() == updatedOrder.getOrderID()){
                    specialOrders.set(i, updatedOrder);
                    FileReadWrite.saveData(specialOrders, SPECIAL_ORDERS_FILE);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static ObservableList<MangoInventory> loadInventory(){
        ObservableList<MangoInventory> inventoryList = FXCollections.observableArrayList();
        inventoryList = FileReadWrite.loadData(MangoInventory.class, INVENTORY_FILE);
        return inventoryList;
    }
}
