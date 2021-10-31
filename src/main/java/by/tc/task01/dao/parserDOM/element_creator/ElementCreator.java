package by.tc.task01.dao.parserDOM.element_creator;

import by.tc.task01.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ElementCreator {

    Element createElement (Appliance appliance, Document document);
}
