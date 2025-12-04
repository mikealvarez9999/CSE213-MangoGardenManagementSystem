package com.cse213.cse213mangogardenmanagementsystem.Accountant.controller;

import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Accountant;
import com.cse213.cse213mangogardenmanagementsystem.Accountant.model.Payroll;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class DisburseSalaryController
{
    @FXML private ComboBox<String> cmbPayrollPeriod;
    @FXML private Label lblBalanceCheck;
    @FXML private TableView<Payroll> payrollTable;
    @FXML private ComboBox<String> cmbPaymentMethod;

    // FXML Columns that must be injected for binding. These must match fx:ids in the FXML.
    @FXML private TableColumn<Payroll, String> workerNameColumn; // Placeholder fx:id
    @FXML private TableColumn<Payroll, Double> netPayColumn;

    // Mock Data List (Simulated Payroll Data for display)
    private final ObservableList<Payroll> pendingPayroll = FXCollections.observableArrayList(
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W101", 1500.00),
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W102", 1450.00)
    );

    @FXML
    public void initialize() {
        // --- Setup column value factories to bind to Payroll Model getters ---

        // FXML columns structure (by index): 0: Select, 1: Worker Name, 2: Net Pay, 3: Status

        // 1. Worker Name Column (Index 1) -> Binds to Payroll's getEmployeeID()
        @SuppressWarnings("unchecked")
        TableColumn<Payroll, String> workerCol = (TableColumn<Payroll, String>) payrollTable.getColumns().get(1);
        workerCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        // 2. Net Pay Column (Index 2) -> Binds to Payroll's getNetWages()
        @SuppressWarnings("unchecked")
        TableColumn<Payroll, Double> wagesCol = (TableColumn<Payroll, Double>) payrollTable.getColumns().get(2);
        wagesCol.setCellValueFactory(new PropertyValueFactory<>("netWages"));




        cmbPayrollPeriod.getItems().addAll("November 2025", "October 2025");
        cmbPaymentMethod.getItems().addAll("Bank Transfer", "Mobile Wallet", "Cash");
    }

    @FXML
    public void handleLoadPayroll(ActionEvent actionEvent) {
        if (cmbPayrollPeriod.getValue() == null) {
            System.err.println("Please select a payroll period.");
            return;
        }

        // Load mock data into the table
        payrollTable.setItems(pendingPayroll);
        lblBalanceCheck.setText("Balance Check: Total Payout: $2950.00 (Sufficient)");
    }

    @FXML
    public void handleExecutePayment(ActionEvent actionEvent) {
        String paymentMethod = cmbPaymentMethod.getValue();

        if (paymentMethod == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a payment method.", ButtonType.OK);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        ObservableList<Payroll> itemsToProcess = payrollTable.getItems();

        if (itemsToProcess.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No payroll data loaded to execute.", ButtonType.OK);
            alert.setTitle("No Data");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // --- EXECUTE PAYMENT FOR THE WHOLE LOADED TABLE ---
        int processedCount = 0;

        // Confirmation before executing
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Disbursement");
        confirmAlert.setHeaderText("Execute Payment for " + itemsToProcess.size() + " Records?");
        confirmAlert.setContentText("Payment Method: " + paymentMethod + ". Do you wish to proceed?");

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                int count = 0;
                for (Payroll record : itemsToProcess) {
                    // Call the Accountant Model to record the disbursement
                    Accountant.disburseSalary(
                            record.getStartDate(),
                            record.getEndDate(),
                            record.getEmployeeID(),
                            record.getNetWages()
                    );
                    count++;
                }

                payrollTable.refresh();

                System.out.println("Salaries disbursed successfully via " + paymentMethod +
                        ". Total records processed: " + count);
                lblBalanceCheck.setText("Disbursement complete. Total processed: " + count);

                // Show final success alert
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Disbursement Successful");
                successAlert.setHeaderText(null);
                successAlert.setContentText(count + " salaries successfully disbursed via " + paymentMethod + ".");
                successAlert.showAndWait();
            } else {
                System.out.println("Disbursement cancelled by user.");
            }
        });
    }
}