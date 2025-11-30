package com.cse213.cse213mangogardenmanagementsystem.GardenWorker.contoller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ViewAssignedTaskController {
    @javafx.fxml.FXML
    private TableColumn cropTypeColumn;
    @javafx.fxml.FXML
    private TableColumn locationColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn taskIDColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Label assignedTaskLabel;
    @javafx.fxml.FXML
    private TableView assignedTaskTableView;
    @javafx.fxml.FXML
    private TableColumn deadLineColumn;
    @javafx.fxml.FXML
    private Button filterButton;
    @javafx.fxml.FXML
    private TextField searchTaskTextField;

    @javafx.fxml.FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
    }
}
