package by.tc.task01.dao.parserDOM;

import by.tc.task01.dao.Constant;
import by.tc.task01.dao.parserDOM.element_creator.*;
import by.tc.task01.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static java.util.Map.entry;
import java.util.Map;

public class ApplianceDOMWriter {

    private final static Map<String, ElementCreator> creators = Map.ofEntries(
            entry("Laptop", new LaptopElementCreator()),
            entry("Oven", new OvenElementCreator()),
            entry("Refrigerator", new RefrigeratorElementCreator()),
            entry("Speakers", new SpeakersElementCreator()),
            entry("TabletPC", new TabletPCElementCreator()),
            entry("VacuumCleaner", new VacuumCleanerElementCreator())
    );

    private static final ApplianceDOMWriter instance = new ApplianceDOMWriter();

    private ApplianceDOMWriter() {}

    public static ApplianceDOMWriter getInstance() {
        return instance;
    }

    public void saveAppliances(List<Appliance> applianceList) throws ParserConfigurationException, IOException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element applianceListElement = document.createElement("appliance-list");

        for(Appliance appliance : applianceList){

            ElementCreator creator = creators.get(appliance.getClass().getSimpleName());
            Element applianceElement = creator.createElement(appliance, document);
            applianceListElement.appendChild(applianceElement);
        }

        document.appendChild(applianceListElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(new FileWriter(Constant.SAVE_TO_FILE_PATH));
        transformer.transform(source, result);

    }
}
