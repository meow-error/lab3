module com.example.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.xml;


    opens com.example.lab3 to javafx.fxml;
    exports com.example.lab3;
}