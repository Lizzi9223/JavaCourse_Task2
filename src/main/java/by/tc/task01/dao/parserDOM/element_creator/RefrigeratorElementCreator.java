package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RefrigeratorElementCreator implements ElementCreator{

    @Override
    public Element createElement(Appliance appliance, Document document) {
        Refrigerator refrigerator = (Refrigerator)appliance;
        Element refrigeratorElement = document.createElement("refrigerator");

        Element powerConsumption = document.createElement("power-consumption");
        powerConsumption.setTextContent(Integer.toString(refrigerator.getPowerConsumption()));

        Element weight = document.createElement("weight");
        weight.setTextContent(Integer.toString(refrigerator.getWeight()));

        Element freezerCapacity = document.createElement("freezer-capacity");
        freezerCapacity.setTextContent(Integer.toString(refrigerator.getFreezerCapacity()));

        Element overallCapacity = document.createElement("overall-capacity");
        overallCapacity.setTextContent(Float.toString(refrigerator.getOverallCapacity()));

        Element height = document.createElement("height");
        height.setTextContent(Integer.toString(refrigerator.getHeight()));

        Element width = document.createElement("width");
        width.setTextContent(Integer.toString(refrigerator.getWidth()));

        refrigeratorElement.appendChild(powerConsumption);
        refrigeratorElement.appendChild(weight);
        refrigeratorElement.appendChild(freezerCapacity);
        refrigeratorElement.appendChild(overallCapacity);
        refrigeratorElement.appendChild(height);
        refrigeratorElement.appendChild(width);

        return refrigeratorElement;
    }
}
