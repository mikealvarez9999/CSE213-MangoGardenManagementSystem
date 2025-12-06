package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.controller;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.FieldSupervisor;
import com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model.Worker; // Import Worker model
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory; // CRITICAL IMPORT
import java.time.LocalDate;
import java.util.List;

public class RecordWorkerAttendanceController
{
    @javafx.fxml.FXML
    private ComboBox cmbShift;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TableView<Worker> attendanceTable; // Set generic type

    // FXML Columns - assuming these are manually defined in FXML
    @FXML private TableColumn<Worker, String> workerNameColumn;
    @FXML private TableColumn<Worker, String> statusColumn;
    @FXML private TableColumn<Worker, ?> presentColumn; // Placeholder for Button/Checkbox
    @FXML private TableColumn<Worker, ?> absentColumn;  // Placeholder for Button/Checkbox


    @javafx.fxml.FXML
    public void initialize() {
        // FIX 1: Set initial values for controls
        cmbShift.getItems().addAll("Morning", "Afternoon", "Night");
        datePicker.setValue(LocalDate.now());

        // FIX 2: Bind Worker Name column to the 'name' property of the Worker model
        if (workerNameColumn != null) {
            workerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }

        // FIX 3: Load worker data into the TableView
        attendanceTable.setItems(FieldSupervisor.getWorkers());

        // Note: For a proper attendance tracker, statusColumn should display the attendance status
        // and presentColumn/absentColumn should use custom CellFactories (Buttons/Checkboxes).
        // Since we are loading data, we only ensure the Worker Name is visible.
    }

    @javafx.fxml.FXML
    public void handleSaveAttendance(ActionEvent actionEvent) {
        LocalDate date = datePicker.getValue();
        String shift = cmbShift.getValue().toString();

        if (date == null || shift == null) {
            System.err.println("Error: Select a date and shift.");
            return;
        }

        List<Worker> workers = attendanceTable.getItems();
        int savedCount = 0;

        // Mock save logic: Assume all workers currently loaded are marked 'Present'
        for (Worker worker : workers) {
            FieldSupervisor.saveAttendance(date, worker.getId(), "Present (" + shift + ")");
            savedCount++;
        }

        System.out.println("Attendance recorded for " + savedCount + " workers for " + date + ".");

        // Refresh table to show any immediate status changes (if applicable)
        attendanceTable.refresh();
    }
}