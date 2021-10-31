package by.tc.task01.dao.impl;


import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.filter.*;
import by.tc.task01.dao.parserDOM.ApplianceDOMWriter;
import by.tc.task01.dao.parserDOM.element_creator.*;
import by.tc.task01.dao.parserSAX.ApplianceSaxHandler;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;


public class ApplianceDAOImpl implements ApplianceDAO{

	private static List<Appliance> applianceList;
	private List<Appliance> searchResult = new ArrayList<>();

	private final static Map<String, ApplianceFilter> creators = Map.ofEntries(
			entry("Laptop", new LaptopFilter()),
			entry("Oven", new OvenFilter()),
			entry("Refrigerator", new RefrigeratorFilter()),
			entry("Speakers", new SpeakersFilter()),
			entry("TabletPC", new TabletPCFilter()),
			entry("VacuumCleaner", new VacuumCleanerFilter())
	);

	public ApplianceDAOImpl(){
		try{
			applianceList = getApplianceList();
		}
		catch (ParserConfigurationException e) {}
		catch (SAXException e){}
		catch (IOException e){}
	}

	public List<Appliance> find(Criteria criteria) {

		for(Appliance appliance : applianceList){

			String groupSearchName = criteria.getGroupSearchName();
			String applianceClass = appliance.getClass().getSimpleName();

			if(applianceClass.equals(groupSearchName)){
				ApplianceFilter filter = creators.get(applianceClass);
				boolean IsThatAppliance = filter.filterAppliance(appliance, criteria);
				if (IsThatAppliance){
					searchResult.add(appliance);
				}
			}
		}

		return searchResult;
	}


	private List<Appliance> getApplianceList() throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser parser = factory.newSAXParser();

		ApplianceSaxHandler handler = new ApplianceSaxHandler();

		try{
			File resource = new File(Thread.currentThread().getContextClassLoader().getResource("appliances_db.xml").toURI());
			parser.parse(resource, handler);
		}
		catch (URISyntaxException e){}

		return handler.getApplianceList();

	}

	public void save(List<Appliance> applianceList){
		ApplianceDOMWriter applianceDOMWriter = ApplianceDOMWriter.getInstance();
		try{
			applianceDOMWriter.saveAppliances(applianceList);
		}
		catch (ParserConfigurationException exception){}
		catch (IOException exception) {}
		catch (TransformerException exception) {}
	}


}

