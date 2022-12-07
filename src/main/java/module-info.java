module com.example.schedulingdesktopapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.schedulingdesktopapplication to javafx.fxml;
    exports com.example.schedulingdesktopapplication;
    exports com.example.schedulingdesktopapplication.controller;
    opens com.example.schedulingdesktopapplication.controller to javafx.fxml;
}