package com.example.lab3.cast.pars;

import com.example.lab3.cast.Reactor;
import com.example.lab3.cast.ReactorType;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class YamlPars {

    ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }

    public void parse(String s) {

        Yaml yaml = new Yaml(new Constructor(ReactorType.class));
        ReactorType data = yaml.load(s);
        reactorArrayList.addAll(data.getReactorType());

    }
}

