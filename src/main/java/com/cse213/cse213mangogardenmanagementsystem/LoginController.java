package com.cse213.cse213mangogardenmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional; // Required for Optional handling

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    // Dummy User field and constructor initialization removed.

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        // 1. Authenticate using the new Mock Database file
        Optional<Employee> authenticatedUser = UserDatabaseMock.authenticate(username, password);

        if (authenticatedUser.isPresent()) {
            Employee user = authenticatedUser.get();
            messageLabel.setText("Success! Loading dashboard...");
            messageLabel.setStyle("-fx-text-fill: green;");
            loadDashboard(user);
        } else {
            messageLabel.setText("Login Failed. Check credentials.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void loadDashboard(Employee user) {
        String fxmlFilename = "";
        String userRole = user.getRole(); // e.g., "GeneralManager"
        String fxmlAbsolutePath = "";

        // Base resource path from the root of the classpath (com/cse213/...)
        final String BASE_RESOURCE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/";


        try {
            // 1. Pick file based on role (FIXED: Added missing 'break' statements)
            switch (userRole) {
                case "Owner":
                    fxmlFilename = "OwnerLayoutView.fxml";
                    break; // <<< FIX: Must break here
                case "GeneralManager":
                    fxmlFilename = "GeneralManagerLayoutView.fxml";
                    break;
                case "TransportManager":
                    fxmlFilename = "TransportManagerLayoutView.fxml";
                    break;
                case "WarehouseManager":
                    fxmlFilename = "WarehouseManagerLayoutView.fxml";
                    break;
                case "Accountant":
                    fxmlFilename = "AccountantLayoutView.fxml";
                    break;
                case "FieldSupervisor":
                    fxmlFilename = "FieldSupervisorLayoutView.fxml";
                    break;
                case  "GardenWorker":
                    fxmlFilename = "GardenWorkerLayoutView.fxml";
                    break; // <<< FIX: Must break here
                case "Customer":
                    fxmlFilename = "CustomerLayoutView.fxml";
                    break;
                default:
                    messageLabel.setText("Error: No dashboard mapped for role: " + userRole);
                    return;
            }


            // --- CRITICAL FIX: Use full absolute path based on your project tree ---
            // Example: /com/cse213/cse213mangogardenmanagementsystem/GeneralManager/GeneralManagerLayoutView.fxml
            fxmlAbsolutePath = BASE_RESOURCE_PATH + userRole + "/" + fxmlFilename;

            System.out.println("Attempting to load FXML from path: " + fxmlAbsolutePath);
            // -----------------------------------------------------------------------

            // 2. Load FXML using the correctly calculated absolute path
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlAbsolutePath));
            Parent root = loader.load();

            // 3. Get Controller and Pass Data using Reflection
            Object controllerObj = loader.getController();

            try {
                // Look for the specific method signature: initData(Employee)
                Method initMethod = controllerObj.getClass().getMethod("initData", Employee.class);
                initMethod.invoke(controllerObj, user);
            } catch (NoSuchMethodException e) {
                System.out.println("Warning: Controller " + controllerObj.getClass().getName() + " does not have an 'initData(Employee)' method.");
            }

            // 4. Show Scene
            Stage stage = (Stage) messageLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(user.getRole() + " Dashboard");
            stage.show();

        } catch (NullPointerException e) {
            // Catches the "Location is not set" error when getResource() returns null
            messageLabel.setText("Error: FXML file not found. Check path: " + fxmlAbsolutePath);
            messageLabel.setStyle("-fx-text-fill: red;");
            System.err.println("NULL POINTER ERROR: FXML path failed. Check resource location: " + fxmlAbsolutePath);
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            // User-friendly error message indicating the required path
            messageLabel.setText("Error: I/O Exception loading FXML. Path: " + fxmlAbsolutePath);
            messageLabel.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("A critical error occurred during loading: " + e.getMessage());
        }
    }
}