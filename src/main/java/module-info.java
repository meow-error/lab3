module com.example.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires java.xml;
    requires org.yaml.snakeyaml;
    requires org.apache.commons.io;


    opens com.example.lab3 to javafx.fxml;
    opens com.example.lab3.cast to org.yaml.snakeyaml;
    exports com.example.lab3;
    exports com.example.lab3.cast;
}