package com.example.lab3;

import com.example.lab3.cast.Parser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private Button importBut;

    @FXML
    void importFile(ActionEvent event) throws IOException, ParseException {

        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);

        Parser parser = new Parser(file);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Import");
        alert.setHeaderText(null);
        alert.setContentText("Файл загружен");
        alert.showAndWait();

    }

}
