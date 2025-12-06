package com.cse213.cse213mangogardenmanagementsystem.Owner.controller;

import com.cse213.cse213mangogardenmanagementsystem.Employee;
import com.cse213.cse213mangogardenmanagementsystem.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class OwnerController {
    @javafx.fxml.FXML
    private Label welcomeLabel;
    @javafx.fxml.FXML
    private VBox contentContainer;

    private User currentUser;

    private static final String FXML_BASE_PATH = "/com/cse213/cse213mangogardenmanagementsystem/Owner/";

    public void initData(Employee user) {
        this.currentUser = user;
        welcomeLabel.setText("Welcome, " + user.getName() + " | Role: " + user.getRole());
    }

    private void loadFXMLView(String fxmlFilename) {
        try {
            String path = FXML_BASE_PATH + fxmlFilename;

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

            Node view = loader.load();

            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(view);

        } catch (IOException e) {
            e.printStackTrace();
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(new Label("Error: Could not load component view " + fxmlFilename + ". Check the file path and FXML structure."));
        }
    }


    @javafx.fxml.FXML
    public void loadFireEmployeesView(ActionEvent actionEvent) {
        loadFXMLView("FireEmployeesView.fxml");
    }

    @javafx.fxml.FXML
    public void loadSalesSummaryView(ActionEvent actionEvent) {
        loadFXMLView("ViewSalesSummaryView.fxml");
    }

    @javafx.fxml.FXML
    public void loadLargeExpenseRequestsView(ActionEvent actionEvent) {
        loadFXMLView("ApproveLargeExpensesView.fxml");
    }

    @javafx.fxml.FXML
    public void loadSpecialOrdersView(ActionEvent actionEvent) {
        loadFXMLView("ApproveSpecialOrderView.fxml");
    }

    @javafx.fxml.FXML
    public void loadAddNewEmployeesView(ActionEvent actionEvent) {
        loadFXMLView("AddNewEmployeesView.fxml");
    }

    @javafx.fxml.FXML
    public void loadViewAllEmployeesView(ActionEvent actionEvent) {
        loadFXMLView("ViewAllEmployeesView.fxml");
    }

    @javafx.fxml.FXML
    public void loadInventorySummaryView(ActionEvent actionEvent) {
        loadFXMLView("ViewInventorySummaryView.fxml");
    }

    @javafx.fxml.FXML
    public void loadTaskSummaryView(ActionEvent actionEvent) {
        loadFXMLView("ViewTaskSummaryView.fxml");
    }
}