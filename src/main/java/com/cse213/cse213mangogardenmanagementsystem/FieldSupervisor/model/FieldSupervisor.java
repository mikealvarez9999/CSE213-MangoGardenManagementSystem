package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.GeneralManager.model.Task;
import com.cse213.cse213mangogardenmanagementsystem.util.FileReadWrite;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class FieldSupervisor extends Employee {

    // --- PERSISTENCE SETUP ---
    private static final String Worker_FILE = "Workers.bin";
    private static final String TASK_FILE = "Tasks.bin";
    private static final String ATTENDANCE_FILE = "attendance.bin";
    private static final String ISSUE_FILE = "issues.bin";
    private static final String INV_FILE = "inventory.bin";
    private static final String SUGGESTION_FILE = "suggestions.bin";
    private static final String SUMMARY_FILE = "summaries.bin";

    private static ObservableList<Worker> WorkerS = FileReadWrite.loadData(Worker.class, Worker_FILE);
    private static ObservableList<Task> TASKS = FileReadWrite.loadData(Task.class, TASK_FILE);
    private static ObservableList<AttendanceRecord> ATTENDANCE_RECORDS = FileReadWrite.loadData(AttendanceRecord.class, ATTENDANCE_FILE);
    private static ObservableList<IssueReport> ISSUE_REPORTS = FileReadWrite.loadData(IssueReport.class, ISSUE_FILE);
    private static ObservableList<ResourceInventory> INVENTORY = FileReadWrite.loadData(ResourceInventory.class, INV_FILE);
    private static ObservableList<Suggestion> SUGGESTIONS = FileReadWrite.loadData(Suggestion.class, SUGGESTION_FILE);
    private static ObservableList<DailySummary> SUMMARIES = FileReadWrite.loadData(DailySummary.class, SUMMARY_FILE);

    static {
        if (WorkerS.isEmpty()) {
            WorkerS.addAll(new Worker("W101", "John Doe"), new Worker("W102", "Jane Smith"), new Worker("W103", "Abe Link"));
            FileReadWrite.saveData(WorkerS, Worker_FILE);
        }
        if (INVENTORY.isEmpty()) {
            INVENTORY.addAll(new ResourceInventory("Pesticide A", 50), new ResourceInventory("Shovel (Heavy)", 10));
            FileReadWrite.saveData(INVENTORY, INV_FILE);
        }
        if (TASKS.isEmpty()) {
            TASKS.addAll(
                    new Task("some info" ),
                    new Task("more task")
            );
            FileReadWrite.saveData(TASKS, TASK_FILE);
        }

        if (ISSUE_REPORTS.isEmpty()) {
            ISSUE_REPORTS.addAll(
                    new IssueReport( 123, "some issue"),
                    new IssueReport( 113, "some issue")
            );
            FileReadWrite.saveData(ISSUE_REPORTS, ISSUE_FILE);
        }
    }

    public FieldSupervisor(String username, String password, String employeeID, String name) {
        super(username, password, employeeID, name, "FieldSupervisor");
    }


    // Goal-1: Assign Daily Tasks to Workers
    public static void assignTask(Task task, List<Worker> WorkersToAssign) {
        if (!TASKS.contains(task)) {
            TASKS.add(task);
        }
        for (Worker Worker : WorkersToAssign) {
            if (!task.getAssignedWorkers().contains(Worker.getId())) {
                task.getAssignedWorkers().add(Worker.getId());
            }
        }
        FileReadWrite.saveData(TASKS, TASK_FILE);
    }

    public static ObservableList<Worker> getWorkers() {
        return WorkerS;
    }

    public static ObservableList<Task> getTasks() {
        return TASKS;
    }

    // Goal-2: Record Worker Attendance
    public static void saveAttendance(LocalDate date, String WorkerId, String status) {
        // Logic to prevent duplicate entries for the same day/Worker would be here
        AttendanceRecord record = new AttendanceRecord(date, WorkerId, status);
        ATTENDANCE_RECORDS.add(record);
        FileReadWrite.saveData(ATTENDANCE_RECORDS, ATTENDANCE_FILE);
    }

    // Goal-3: Monitor Task Completion (Assumes Workers submit task updates to ISSUE_REPORTS/TASKS directly)
    public static ObservableList<Task> getTasksForMonitoring() {
        return TASKS; // FS monitors assigned tasks
    }

    public static void markTaskVerified(int taskId) {
        for (Task task : TASKS) {
            if (task.getTaskID() == taskId) {
                task.setStatus("Completed & Verified");
                FileReadWrite.saveData(TASKS, TASK_FILE);
                return;
            }
        }
    }

    // Goal-4: Provide Instructions/Feedback for Field Problems/Issues
    public static ObservableList<IssueReport> getPendingIssueReports() {
        // Filters reports needing feedback (e.g., status == "Reported")
        return ISSUE_REPORTS;
    }

    public static boolean saveInstruction(int issueId, String instructions) {
        for (IssueReport report : ISSUE_REPORTS) {
            if (report.getId() == issueId) {
                report.setFeedback(instructions);
                report.setStatus("Feedback Provided");
                FileReadWrite.saveData(ISSUE_REPORTS, ISSUE_FILE);
                return true;
            }
        }
        return false;
    }

    // Goal-5: Request Tools/Resources
    // This calls the Accountant facade, but we implement the data gathering here.
    // Assuming the request details are gathered directly by the controller.

    // Goal-6: Generate Daily Field Summary
    public static void saveDailySummary(LocalDate date, String notes) {
        // Mock aggregation of data into the notes field for simplicity
        int totalWorkers = WorkerS.size();
        int completedTasks = (int) TASKS.stream().filter(t -> t.getStatus().equals("Completed")).count();

        String content = String.format("Summary for %s: Total Workers: %d. Tasks Completed: %d. Notes: %s", date.toString(), totalWorkers, completedTasks, notes);

        DailySummary summary = new DailySummary(date, content);
        SUMMARIES.add(summary);
        FileReadWrite.saveData(SUMMARIES, SUMMARY_FILE);
    }

    // Goal-7: Suggest Improvements
    public static void saveSuggestion(String title, String suggestion) {
        Suggestion newSuggestion = new Suggestion(title, suggestion);
        SUGGESTIONS.add(newSuggestion);
        FileReadWrite.saveData(SUGGESTIONS, SUGGESTION_FILE);
    }
    // Note: Notification logic is handled in the controller (System.out.println).

    // Goal-8: Monitor Field Resource Inventory (tools, pesticides etc.) Usage
    public static ObservableList<ResourceInventory> getInventory() {
        return INVENTORY;
    }

    public static boolean logResourceUsage(String itemName, int quantityUsed, String purpose) {
        for (ResourceInventory item : INVENTORY) {
            if (item.getName().equals(itemName)) {
                if (item.getLevel() >= quantityUsed) {
                    item.setLevel(item.getLevel() - quantityUsed);
                    FileReadWrite.saveData(INVENTORY, INV_FILE);
                    System.out.println("Usage logged for " + itemName + ". Remaining: " + item.getLevel());
                    return true;
                }
            }
        }
        return false;
    }
}
