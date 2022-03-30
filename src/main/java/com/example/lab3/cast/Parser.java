package com.example.lab3.cast;


import com.example.lab3.cast.pars.JsonPars;
import com.example.lab3.cast.pars.XmlPars;
import com.example.lab3.cast.pars.YamlPars;

import java.io.File;

public class Parser {

    public Parser(File file) {
        if (file.getAbsolutePath().contains(".json")) {
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(file);
            System.out.println(jsonPars.getReactorArrayList());
        } else if (file.getAbsolutePath().contains(".xml")) {
            XmlPars xmlPars = new XmlPars();
            xmlPars.parse(file);
            System.out.println(xmlPars.getReactorArrayList());
        } else if (file.getAbsolutePath().contains(".yaml")) {
            YamlPars yamlPars = new YamlPars();
            yamlPars.parse(file);
            System.out.println(yamlPars.getReactorArrayList());
        } else {
            System.out.println("Ашибка");
        }
    }

}



