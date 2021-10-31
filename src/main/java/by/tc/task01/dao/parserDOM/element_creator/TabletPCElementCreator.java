package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TabletPCElementCreator implements ElementCreator{
    @Override
    public Element createElement(Appliance appliance, Document document) {
        TabletPC tabletPC = (TabletPC)appliance;
        Element tabletPCElement = document.createElement("tablet-pc");

        Element batteryCapacity = document.createElement("battery-capacity");
        batteryCapacity.setTextContent(Integer.toString(tabletPC.getBatteryCapacity()));

        Element displayInches = document.createElement("display-inches");
        displayInches.setTextContent(Integer.toString(tabletPC.getDisplayInches()));

        Element memoryRom = document.createElement("memory-rom");
        memoryRom.setTextContent(Integer.toString(tabletPC.getMemoryRom()));

        Element flashMemoryCapacity = document.createElement("flash-memory-capacity");
        flashMemoryCapacity.setTextContent(Integer.toString(tabletPC.getFlashMemoryCapacity()));

        Element color = document.createElement("color");
        color.setTextContent(tabletPC.getColor());

        tabletPCElement.appendChild(batteryCapacity);
        tabletPCElement.appendChild(displayInches);
        tabletPCElement.appendChild(memoryRom);
        tabletPCElement.appendChild(flashMemoryCapacity);
        tabletPCElement.appendChild(color);

        return tabletPCElement;
    }
}
