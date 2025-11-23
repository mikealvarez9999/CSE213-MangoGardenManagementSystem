module com.cse213.cse213mangogardenmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cse213.cse213mangogardenmanagementsystem to javafx.fxml;
    exports com.cse213.cse213mangogardenmanagementsystem;
}