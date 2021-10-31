package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LaptopElementCreator implements ElementCreator{

    @Override
    public Element createElement(Appliance appliance, Document document) {

        Laptop laptop = (Laptop)appliance;
        Element laptopElement = document.createElement("laptop");

        Element batteryCapacity = document.createElement("battery-capacity");
        batteryCapacity.setTextContent(Float.toString(laptop.getBatteryCapacity()));

        Element os = document.createElement("os");
        os.setTextContent(laptop.getOs());

        Element memoryRom = document.createElement("memory-rom");
        memoryRom.setTextContent(Integer.toString(laptop.getMemoryRom()));

        Element systemMemory = document.createElement("system-memory");
        systemMemory.setTextContent(Integer.toString(laptop.getSystemMemory()));

        Element cpu = document.createElement("cpu");
        cpu.setTextContent(laptop.getCpu());

        Element displayInch = document.createElement("display-inch");
        displayInch.setTextContent(Integer.toString(laptop.getDisplayInch()));

        laptopElement.appendChild(batteryCapacity);
        laptopElement.appendChild(os);
        laptopElement.appendChild(memoryRom);
        laptopElement.appendChild(systemMemory);
        laptopElement.appendChild(cpu);
        laptopElement.appendChild(displayInch);

        return laptopElement;
    }
}
