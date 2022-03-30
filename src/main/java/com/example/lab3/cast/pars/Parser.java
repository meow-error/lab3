package com.example.lab3.cast.pars;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Parser {
// Сделать в конструкторе обработку 3 методов, а сами методы создать классы для 3ех обработок

    public Parser(File file) throws IOException, ParseException {

        // Считываем json
        Object obj = new JSONParser().parse(new FileReader(file));
// Кастим obj в JSONObject
        JSONObject jo = (JSONObject) obj;
// Достаём firstName and lastName
        JSONObject reactorType = (JSONObject) jo.get("ReactorType");
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
        System.out.println("fio: " + firstName + " " + lastName);
// Достаем массив номеров

        Iterator phonesItr = reactorType.values().iterator();
        System.out.println("phoneNumbers:");
// Выводим в цикле данные массива
        while (phonesItr.hasNext()) {
            JSONObject test = (JSONObject) phonesItr.next();
            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
        }

    }

    class ReactorType {
        List<Reactor> reactors;
    }

    class Reactor {
        String name;
        double burnup;
        double kpd;
        double enrichment;
        double termal_capacity;
        double electrical_capacity;
        double life_time;
        double first_load;


    }

}



