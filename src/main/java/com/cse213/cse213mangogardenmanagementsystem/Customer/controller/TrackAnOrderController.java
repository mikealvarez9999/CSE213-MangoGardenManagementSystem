package com.cse213.cse213mangogardenmanagementsystem.Customer.controller;

import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Customer;
import com.cse213.cse213mangogardenmanagementsystem.Customer.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TrackAnOrderController {
    @javafx.fxml.FXML
    private TableView<Order> trackOrderTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,String> locationColumn;
    @javafx.fxml.FXML
    private TextArea orderDataTextArea;
    @javafx.fxml.FXML
    private TableColumn<Order,String> statusColumn;
    @javafx.fxml.FXML
    private Button trackOrderButton;
    @javafx.fxml.FXML
    private TableColumn<Order,String> deliveryProgressColumn;
    @javafx.fxml.FXML
    private Label trackAnOrderLabel;
    @javafx.fxml.FXML
    private ComboBox<String> orderIDComboBox;


    @javafx.fxml.FXML
    public void initialize(){

        statusColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("location"));
        deliveryProgressColumn.setCellValueFactory(new PropertyValueFactory<Order,String>("deliveryProgress"));

        trackOrderTableView.getItems().addAll();

    }

    @javafx.fxml.FXML
    public void trackOrderButtonOnAction(ActionEvent actionEvent){
        if ((orderIDComboBox.getValue() == null) || (orderDataTextArea.getText().isEmpty())){
            Alert aa = new Alert(Alert.AlertType.ERROR);
            aa.setContentText("Invalid input!");
            aa.showAndWait();
            return;
        }


    }
}