package com.example.lab3;

import com.example.lab3.cast.Parser;
import com.example.lab3.cast.Reactor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button importBut;

    @FXML
    private TreeView<String> treeReactors;

    @FXML
    void importFile(ActionEvent event) {

        try {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(null);
            Parser parser = new Parser(file);
            initialize(parser.getReactorArrayList());
        } catch (Exception e) {
            error();
        }
    }

    public void initialize(ArrayList<Reactor> reactorArrayList) {

        TreeItem<String> rootItem = new TreeItem<>("Error");
        if (reactorArrayList.size() != 0) {

            rootItem = new TreeItem<>("Reactors");

            for (Reactor reactor : reactorArrayList) {

                TreeItem<String> branchItem = new TreeItem<>(reactor.getName());

                TreeItem<String> leafItem1 = new TreeItem<>("name : " + reactor.getName());
                TreeItem<String> leafItem2 = new TreeItem<>("burnup : " + reactor.getBurnup());
                TreeItem<String> leafItem3 = new TreeItem<>("kpd : " + reactor.getKpd());
                TreeItem<String> leafItem4 = new TreeItem<>("enrichment : " + reactor.getEnrichment());
                TreeItem<String> leafItem5 = new TreeItem<>("termal_capacity : " + reactor.getTermal_capacity());
                TreeItem<String> leafItem6 = new TreeItem<>("electrical_capacity : " + reactor.getElectrical_capacity());
                TreeItem<String> leafItem7 = new TreeItem<>("life_time : " + reactor.getLife_time());
                TreeItem<String> leafItem8 = new TreeItem<>("first_load : " + reactor.getFirst_load());
                TreeItem<String> leafItem9 = new TreeItem<>("source : " + reactor.getSource());

                branchItem.getChildren().addAll(leafItem1, leafItem2, leafItem3, leafItem4,
                        leafItem5, leafItem6, leafItem7, leafItem8, leafItem9);
                rootItem.getChildren().add(branchItem);
            }
        }
        treeReactors.setRoot(rootItem);
    }

    public static void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Error");
        alert.showAndWait();
    }
}
