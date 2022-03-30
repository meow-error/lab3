module com.example.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.lab3 to javafx.fxml;
    exports com.example.lab3;
    exports com.example.lab3.app;
    opens com.example.lab3.app to javafx.fxml;
}