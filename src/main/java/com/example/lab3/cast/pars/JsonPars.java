package com.example.lab3.cast.pars;

import com.example.lab3.cast.Reactor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class JsonPars {

    public void parse(File file, ArrayList<Reactor> reactorArrayList) {

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            JSONArray reactorJsonArray = (JSONArray) rootJsonObject.get("ReactorType");

            for (Object it : reactorJsonArray) {
                JSONObject reactorJsonObject = (JSONObject) it;

                String name = (String) reactorJsonObject.get("name");
                double burnup = Double.parseDouble((String) reactorJsonObject.get("burnup"));
                double kpd = Double.parseDouble((String) reactorJsonObject.get("kpd"));
                double enrichment = Double.parseDouble((String) reactorJsonObject.get("enrichment"));
                double termal_capacity = Double.parseDouble((String) reactorJsonObject.get("termal_capacity"));
                double electrical_capacity = Double.parseDouble((String) reactorJsonObject.get("electrical_capacity"));
                double life_time = Double.parseDouble((String) reactorJsonObject.get("life_time"));
                double first_load = Double.parseDouble((String) reactorJsonObject.get("first_load"));
                String source = "JSON";

                Reactor reactor = new Reactor(name, burnup, kpd, enrichment, termal_capacity, electrical_capacity, life_time, first_load, source);

                reactorArrayList.add(reactor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
