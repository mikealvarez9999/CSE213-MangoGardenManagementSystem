package com.cse213.cse213mangogardenmanagementsystem.Accountant.model;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDate;

public class Accountant extends Employee implements Serializable {

    private static final String TRANSACTION_FILE_NAME = "transactions.bin";
    private static ObservableList<Transaction> TRANSACTION_RECORDS = FileReadWrite.loadData(Transaction.class, TRANSACTION_FILE_NAME);

    private static final String BUDGET_REQUEST_FILE_NAME = "budget_requests.bin";
    private static ObservableList<BudgetRequest> BUDGET_RECORDS = FileReadWrite.loadData(BudgetRequest.class, BUDGET_REQUEST_FILE_NAME);

    private static final String LARGE_EXPENSE_FILE_NAME = "large_expense_requests.bin";
    private static ObservableList<LargeExpenseRequest> LARGE_EXPENSE_RECORDS = FileReadWrite.loadData(LargeExpenseRequest.class, LARGE_EXPENSE_FILE_NAME);

    private static final String PAYROLL_FILE_NAME = "payroll_records.bin";
    private static ObservableList<Payroll> PAYROLL_RECORDS = FileReadWrite.loadData(Payroll.class, PAYROLL_FILE_NAME);

    private static final String TOOL_REQUEST_FILE_NAME = "tool_requests.bin";
    private static ObservableList<ToolRequest> TOOL_RECORDS = FileReadWrite.loadData(ToolRequest.class, TOOL_REQUEST_FILE_NAME);

    private static final String MAINT_REQUEST_FILE_NAME = "maint_requests.bin";
    private static ObservableList<VehicleMaintRequest> MAINT_RECORDS = FileReadWrite.loadData(VehicleMaintRequest.class, MAINT_REQUEST_FILE_NAME);

    public Accountant(String username, String password, String employeeID, String name) {
        super(username, password, employeeID, name, "Accountant");
    }


    public static Transaction recordTransaction(double amount, String type, String category, LocalDate date, String description) {
        Transaction newTransaction = new Transaction(amount, type, category, date, description);
        TRANSACTION_RECORDS.add(newTransaction);
        FileReadWrite.saveData(TRANSACTION_RECORDS, TRANSACTION_FILE_NAME);
        System.out.println("Transaction recorded by Accountant Model. ID: " + newTransaction.getId());
        return newTransaction;
    }

    public static boolean updateTransaction(Transaction transaction, double amount, String type, String category, LocalDate date, String description) {
        if (transaction.updateTransaction(amount, type, category, date, description)) {
            FileReadWrite.saveData(TRANSACTION_RECORDS, TRANSACTION_FILE_NAME);
            return true;
        }
        return false;
    }

    public static ObservableList<Transaction> getAllTransactions() {
        return TRANSACTION_RECORDS;
    }


    public static Payroll disburseSalary(LocalDate startDate, LocalDate endDate, String employeeID, double netWages) {
        Payroll newRecord = new Payroll(startDate, endDate, employeeID, netWages);
        PAYROLL_RECORDS.add(newRecord);
        FileReadWrite.saveData(PAYROLL_RECORDS, PAYROLL_FILE_NAME);
        return newRecord;
    }

    public static ObservableList<Payroll> viewDisburseSalaryHistory() {
        return PAYROLL_RECORDS;
    }


    public static BudgetRequest submitBudgetRequest(String category, double amount, String purpose) {
        BudgetRequest newRequest = new BudgetRequest(category, amount, purpose);
        BUDGET_RECORDS.add(newRequest);
        FileReadWrite.saveData(BUDGET_RECORDS, BUDGET_REQUEST_FILE_NAME);
        return newRequest;
    }

    public static LargeExpenseRequest submitLargeExpenseRequest(LocalDate date,  double amount, String description) {
        LargeExpenseRequest newRequest = new LargeExpenseRequest(date, amount, description);
        LARGE_EXPENSE_RECORDS.add(newRequest);
        FileReadWrite.saveData(LARGE_EXPENSE_RECORDS, LARGE_EXPENSE_FILE_NAME);
        return newRequest;
    }

    public static ObservableList<ToolRequest> getAllToolRequests() {
        return TOOL_RECORDS;
    }

    public static boolean approveToolRequest(int requestId) {

        ToolRequest request = null;
        for (ToolRequest r : TOOL_RECORDS) {
            if (r.getId() == requestId) {
                request = r;
                break;
            }
        }

        if (request != null) {
            request.setStatus("Approved");
            FileReadWrite.saveData(TOOL_RECORDS, TOOL_REQUEST_FILE_NAME);

            submitBudgetRequest("Tool Procurement", request.getEstimatedCost(),
                    "Budget required for approved Tool Request ID: " + requestId + " (" + request.getToolName() + ")");

            System.out.println("Tool Request " + requestId + " approved and Budget Request submitted to GM.");
            return true;
        }
        return false;
    }

    public static ObservableList<VehicleMaintRequest> getAllVehicleMaintRequest() {
        return MAINT_RECORDS;
    }

    public static boolean approveVehicleMaintRequest(int requestId) {

        VehicleMaintRequest request = null;
        for (VehicleMaintRequest r : MAINT_RECORDS) {
            if (r.getId() == requestId) {
                request = r;
                break;
            }
        }

        if (request != null) {

            request.setStatus("Approved");
            FileReadWrite.saveData(MAINT_RECORDS, MAINT_REQUEST_FILE_NAME);

            submitBudgetRequest("Vehicle Maintenance", request.getEstimatedCost(),
                    "Budget required for approved Vehicle Maintenance Request ID: " + requestId + " (" + request.getServiceDetails() + ")");

            System.out.println("Vehicle Maint Request " + requestId + " approved and Budget Request submitted to GM.");
            return true;
        }
        return false;
    }



}