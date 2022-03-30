package com.example.lab3.cast;


import com.example.lab3.cast.pars.JsonPars;
import com.example.lab3.cast.pars.XmlPars;
import com.example.lab3.cast.pars.YamlPars;

import java.io.File;
import java.util.ArrayList;

public class Parser {

    private ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public Parser(File file) {
        if (file.getAbsolutePath().endsWith(".json")) {
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(file, reactorArrayList);
        } else if (file.getAbsolutePath().endsWith(".xml")) {
            XmlPars xmlPars = new XmlPars();
            xmlPars.parse(file, reactorArrayList);
        } else if (file.getAbsolutePath().endsWith(".yaml")) {
            YamlPars yamlPars = new YamlPars();
            yamlPars.parse(file, reactorArrayList);
        } else {
            System.out.println("Ашибка");
        }
    }

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }
}



