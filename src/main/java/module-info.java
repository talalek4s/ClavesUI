module com.example.clavesui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clavesui to javafx.fxml;
    exports com.example.clavesui;
}