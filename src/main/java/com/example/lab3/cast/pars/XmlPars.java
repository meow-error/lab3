package com.example.lab3.cast.pars;

import com.example.lab3.cast.Reactor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class XmlPars {

    ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }

    public void parse(String s) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        Document doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(s)));


        Node rootNode = doc.getFirstChild();

        NodeList rootChilds = rootNode.getChildNodes();

        for (int i = 0; i < rootChilds.getLength(); i++) {

            Node reactorNode = rootChilds.item(i);

            NodeList reactorChilds = reactorNode.getChildNodes();

            String name = null;
            double burnup = 0;
            double kpd = 0;
            double enrichment = 0;
            double termal_capacity = 0;
            double electrical_capacity = 0;
            double life_time = 0;
            double first_load = 0;

            for (int j = 0; j < reactorChilds.getLength(); j++) {

                if (reactorChilds.item(j).getNodeType() != Node.ELEMENT_NODE) continue;

                switch (reactorChilds.item(j).getNodeName()) {
                    case "name": {
                        name = reactorChilds.item(j).getTextContent();
                        break;
                    }
                    case "burnup": {
                        burnup = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "kpd": {
                        kpd = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "enrichment": {
                        enrichment = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "termal_capacity": {
                        termal_capacity = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "electrical_capacity": {
                        electrical_capacity = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "life_time": {
                        life_time = Double.parseDouble(reactorChilds.item(j).getTextContent());
                        break;
                    }
                    case "first_load": {
                        first_load = Double.parseDouble(reactorChilds.item(j).getTextContent());
                    }
                }
            }

            String source = "XML";
            if (name != null) {
                Reactor reactor = new Reactor(name, burnup, kpd, enrichment, termal_capacity,
                        electrical_capacity, life_time, first_load, source);
                reactorArrayList.add(reactor);
            }
        }
    }
}
