package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SpeakersElementCreator implements ElementCreator{

    @Override
    public Element createElement(Appliance appliance, Document document) {
        Speakers speakers = (Speakers)appliance;
        Element speakersElement = document.createElement("speakers");

        Element powerConsumption = document.createElement("power-consumption");
        powerConsumption.setTextContent(Integer.toString(speakers.getPowerConsumption()));

        Element numberOfSpeakers = document.createElement("number-of-speakers");
        numberOfSpeakers.setTextContent(Integer.toString(speakers.getNumberOfSpeakers()));

        Element frequencyRange = document.createElement("frequency-range");
        frequencyRange.setTextContent(speakers.getFrequencyRange());

        Element cordLength = document.createElement("cord-length");
        cordLength.setTextContent(Integer.toString(speakers.getCordLength()));

        speakersElement.appendChild(powerConsumption);
        speakersElement.appendChild(numberOfSpeakers);
        speakersElement.appendChild(frequencyRange);
        speakersElement.appendChild(cordLength);

        return speakersElement;
    }
}
