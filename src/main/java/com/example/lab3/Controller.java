package com.example.lab3;

import com.example.lab3.cast.Reactor;
import com.example.lab3.cast.pars.JsonPars;
import com.example.lab3.cast.pars.XmlPars;
import com.example.lab3.cast.pars.YamlPars;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    private TreeView<String> treeReactors;

    public static void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Error");
        alert.showAndWait();
    }

    @FXML
    void importFileJSON(ActionEvent event) {
        try {
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(IOUtils.toString(Controller.class.getResourceAsStream("ReactorType.json")));
            initialize(jsonPars.getReactorArrayList());
        } catch (Exception e) {
            e.printStackTrace();
            error();
        }
    }

    @FXML
    void importFileXML(ActionEvent event) {
        try {
            XmlPars xmlPars = new XmlPars();
            xmlPars.parse(IOUtils.toString(Controller.class.getResourceAsStream("ReactorType.xml")));
            initialize(xmlPars.getReactorArrayList());
        } catch (Exception e) {
            e.printStackTrace();
            error();
        }
    }

    @FXML
    void importFileYAML(ActionEvent event) {
        try {
            YamlPars yamlPars = new YamlPars();
            yamlPars.parse(IOUtils.toString(Controller.class.getResourceAsStream("ReactorType.yaml")));
            initialize(yamlPars.getReactorArrayList());
        } catch (Exception e) {
            e.printStackTrace();
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

}
