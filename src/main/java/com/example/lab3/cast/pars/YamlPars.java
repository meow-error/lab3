package com.example.lab3.cast.pars;

import com.example.lab3.cast.Reactor;
import com.example.lab3.cast.ReactorType;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class YamlPars {

    public void parse(File file, ArrayList<Reactor> reactorArrayList) throws FileNotFoundException {

        InputStream inputStream = new FileInputStream(file);
        Yaml yaml = new Yaml(new Constructor(ReactorType.class));
        ReactorType data = yaml.load(inputStream);
        reactorArrayList.addAll(data.getReactorType());

    }
}

