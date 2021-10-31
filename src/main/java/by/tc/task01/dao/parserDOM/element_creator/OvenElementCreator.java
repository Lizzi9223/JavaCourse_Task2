package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OvenElementCreator implements ElementCreator {

    @Override
    public Element createElement(Appliance appliance, Document document){

        Oven oven = (Oven)appliance;
        Element ovenElement = document.createElement("oven");

        Element powerConsumption = document.createElement("power-consumption");
        powerConsumption.setTextContent(Integer.toString(oven.getPowerConsumption()));

        Element weight = document.createElement("weight");
        weight.setTextContent(Integer.toString(oven.getWeight()));

        Element capacity = document.createElement("capacity");
        capacity.setTextContent(Integer.toString(oven.getCapacity()));

        Element depth = document.createElement("depth");
        depth.setTextContent(Integer.toString(oven.getDepth()));

        Element height = document.createElement("height");
        height.setTextContent(Float.toString(oven.getHeight()));

        Element width = document.createElement("width");
        width.setTextContent(Float.toString(oven.getWidth()));

        ovenElement.appendChild(powerConsumption);
        ovenElement.appendChild(weight);
        ovenElement.appendChild(capacity);
        ovenElement.appendChild(depth);
        ovenElement.appendChild(height);
        ovenElement.appendChild(width);

        return ovenElement;
    }

}
