open module com.cse213.cse213mangogardenmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    exports com.cse213.cse213mangogardenmanagementsystem;

    // --- CRITICAL FIX: Open all packages containing controllers to javafx.fxml ---

    // 1. Open main package for LoginController, Employee, User
//    opens com.cse213.cse213mangogardenmanagementsystem to javafx.fxml;

    // 2. Open specific controller sub-packages for FXML reflection/injection
//    opens com.cse213.cse213mangogardenmanagementsystem.Accountant.controller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.Customer.controller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.contoller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.GardenWorker.contoller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.GeneralManager.controller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.Owner.controller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.TransportManager.contoller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.WarehouseManager.contoller to javafx.fxml;
//    opens com.cse213.cse213mangogardenmanagementsystem.test.controller to javafx.fxml;
}