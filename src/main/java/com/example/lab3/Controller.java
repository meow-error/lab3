package com.example.lab3;

import com.example.lab3.cast.Reactor;
import com.example.lab3.cast.pars.JsonPars;
import com.example.lab3.cast.pars.XmlPars;
import com.example.lab3.cast.pars.YamlPars;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private TreeView<String> treeReactors;

    @FXML
    private TextArea area;

    void error(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @FXML
    void importFileJSON(ActionEvent event) {
        try {
            InputStream is = (getClass().getResourceAsStream("ReactorType.json"));
            String text = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            area.setText(text);
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(text);
            initialize(jsonPars.getReactorArrayList());
        } catch (Exception e) {
            area.setText(e.toString());
            error(e.toString());
        }
    }

    @FXML
    void importFileXML(ActionEvent event) {
        try {
            InputStream is = (getClass().getResourceAsStream("ReactorType.xml"));
            String text = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            area.setText(text);
            XmlPars xmlPars = new XmlPars();
            xmlPars.parse(text);
            initialize(xmlPars.getReactorArrayList());
        } catch (Exception e) {
            area.setText(e.toString());
            error(e.toString());
        }
    }

    @FXML
    void importFileYAML(ActionEvent event) throws IOException {
        InputStream is = (getClass().getResourceAsStream("ReactorType.yaml"));
        String text = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        area.setText(text);
        YamlPars yamlPars = new YamlPars();
        yamlPars.parse(text);
        initialize(yamlPars.getReactorArrayList());
        try {
        } catch (Exception e) {
            area.setText(e.toString());
            error(e.toString());
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

                branchItem.getChildren().addAll(leafItem1, leafItem2, leafItem3, leafItem4, leafItem5, leafItem6, leafItem7, leafItem8, leafItem9);
                rootItem.getChildren().add(branchItem);
            }
        }
        treeReactors.setRoot(rootItem);
    }

}
