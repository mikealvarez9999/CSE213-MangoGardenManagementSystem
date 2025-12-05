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
import java.time.format.DateTimeFormatter;

public class DisburseSalaryController
{
    @FXML private ComboBox<String> cmbPayrollPeriod;
    @FXML private Label lblBalanceCheck;
    @FXML private TableView<Payroll> payrollTable;
    @FXML private ComboBox<String> cmbPaymentMethod;

    // FXML Columns that must be injected for binding. These must match fx:ids in the FXML.
    @FXML private TableColumn<Payroll, Boolean> selectColumn;
    @FXML private TableColumn<Payroll, String> workerNameColumn;
    @FXML private TableColumn<Payroll, Double> netPayColumn;
    @FXML private TableColumn<Payroll, String> statusColumn;

    // NEW: Assuming the FXML has these date columns (e.g., named colStartDate/colEndDate)
    @FXML private TableColumn<Payroll, LocalDate> colStartDate;
    @FXML private TableColumn<Payroll, LocalDate> colEndDate;

    // FIX 1: Single Master list containing all mock payroll data
    private static final ObservableList<Payroll> UNPAID_PAYROLL_RECORDS = FXCollections.observableArrayList(
            // November Data
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W101", 1500.00),
            new Payroll(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), "W102", 1450.00),
            // October Data
            new Payroll(LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 31), "W101", 1480.00),
            new Payroll(LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 31), "W103", 1600.00)
    );

    @FXML
    public void initialize() {
        // --- Setup column value factories and date formatting ---

        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (workerNameColumn != null) {
            workerNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        }

        if (netPayColumn != null) {
            netPayColumn.setCellValueFactory(new PropertyValueFactory<>("netWages"));
        }

        if (statusColumn != null) {
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        }

        // Date column bindings with custom formatter (required for LocalDate visibility)
        if (colStartDate != null) {
            colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            colStartDate.setCellFactory(column -> new TableCell<Payroll, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : dateFormatter.format(item));
                }
            });
        }

        if (colEndDate != null) {
            colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
            colEndDate.setCellFactory(column -> new TableCell<Payroll, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : dateFormatter.format(item));
                }
            });
        }

        cmbPayrollPeriod.getItems().addAll("November 2025", "October 2025");
        cmbPaymentMethod.getItems().addAll("Bank Transfer", "Mobile Wallet", "Cash");
    }

    @FXML
    public void handleLoadPayroll(ActionEvent actionEvent) {
        String selectedPeriod = cmbPayrollPeriod.getValue();
        if (selectedPeriod == null) {
            System.err.println("Please select a payroll period.");
            return;
        }

        ObservableList<Payroll> filteredData = FXCollections.observableArrayList();
        double totalPayout = 0.0;

        // Determine start and end dates based on selected period
        LocalDate filterStart = null;
        LocalDate filterEnd = null;

        if (selectedPeriod.equals("November 2025")) {
            filterStart = LocalDate.of(2025, 11, 1);
            filterEnd = LocalDate.of(2025, 11, 30);
        } else if (selectedPeriod.equals("October 2025")) {
            filterStart = LocalDate.of(2025, 10, 1);
            filterEnd = LocalDate.of(2025, 10, 31);
        }

        // FIX 2: Loop through the master list and filter data based on the period
        if (filterStart != null) {
            for (Payroll record : UNPAID_PAYROLL_RECORDS) {
                // Payroll record must match the start and end dates exactly
                if (record.getStartDate().equals(filterStart) && record.getEndDate().equals(filterEnd)) {
                    filteredData.add(record);
                    totalPayout += record.getNetWages();
                }
            }
        }

        payrollTable.setItems(filteredData);
        lblBalanceCheck.setText("Balance Check: Total Payout: $" + String.format("%.2f", totalPayout) + " (Sufficient){mock data}");
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