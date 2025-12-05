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

    @FXML private TableColumn<Payroll, String> workerNameColumn;
    @FXML private TableColumn<Payroll, Double> netPayColumn;

    // Mock Data List (Simulated Payroll Data for display)
    private final ObservableList<Payroll> pendingPayroll = FXCollections.observableArrayList(
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W101", 1500.00),
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W102", 1450.00)
    );

    @FXML
    public void initialize() {
        // --- FIX: Setup column value factories directly on injected columns ---

        // The strings must EXACTLY match the getter methods in the Payroll Model:

        // 0. Select Column (Assuming boolean tracking for selection)
        // Note: For simplicity, we are binding to a hypothetical "selected" property.
        // selectColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));

        // 1. Worker Name Column -> Binds to Payroll's getEmployeeID()
        if (workerNameColumn != null) {
            workerNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        }

        // 2. Net Pay Column -> Binds to Payroll's getNetWages()
        if (netPayColumn != null) {
            netPayColumn.setCellValueFactory(new PropertyValueFactory<>("netWages"));
        }



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
        lblBalanceCheck.setText("Balance Check: Total Payout: $2950.00 (Sufficient){mock data}");
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