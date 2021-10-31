package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VacuumCleanerElementCreator implements ElementCreator{

    @Override
    public Element createElement(Appliance appliance, Document document) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner)appliance;
        Element vacuumCleanerElement = document.createElement("vacuum-cleaner");

        Element powerConsumption = document.createElement("power-consumption");
        powerConsumption.setTextContent(Integer.toString(vacuumCleaner.getPowerConsumption()));

        Element filterType = document.createElement("filter-type");
        filterType.setTextContent(vacuumCleaner.getFilterType());

        Element bagType = document.createElement("bag-type");
        bagType.setTextContent(vacuumCleaner.getBagType());

        Element wandType = document.createElement("wand-type");
        wandType.setTextContent(vacuumCleaner.getWandType());

        Element motorSpeedRegulation = document.createElement("motor-speed-regulation");
        motorSpeedRegulation.setTextContent(Integer.toString(vacuumCleaner.getMotorSpeedRegulation()));

        Element cleaningWidth = document.createElement("cleaning-width");
        cleaningWidth.setTextContent(Integer.toString(vacuumCleaner.getCleaningWidth()));

        vacuumCleanerElement.appendChild(powerConsumption);
        vacuumCleanerElement.appendChild(filterType);
        vacuumCleanerElement.appendChild(bagType);
        vacuumCleanerElement.appendChild(wandType);
        vacuumCleanerElement.appendChild(motorSpeedRegulation);
        vacuumCleanerElement.appendChild(cleaningWidth);

        return vacuumCleanerElement;
    }
}
