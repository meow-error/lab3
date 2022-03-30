package com.example.lab3.cast;


import com.example.lab3.cast.pars.JsonPars;

import java.io.File;

public class Parser {
// Сделать в конструкторе обработку 3 методов, а сами методы создать классы для 3ех обработок

    public Parser(File file) {
        if (file.getAbsolutePath().contains(".json")) {
            JsonPars jsonPars = new JsonPars();
            jsonPars.parse(file);
            System.out.println(jsonPars.getReactorArrayList());
        } else if (file.getAbsolutePath().contains(".xml")) {
            System.out.println(2);
        } else if (file.getAbsolutePath().contains(".yaml")) {
            System.out.println(3);
        } else {
            System.out.println("Ашибка");
        }
    }

}



