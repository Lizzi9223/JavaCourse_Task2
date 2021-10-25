package by.tc.task01.dao.impl;


import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.parser.ApplianceSaxHandler;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.enums.SearchCriteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApplianceDAOImpl implements ApplianceDAO{

	private static List<Appliance> applianceList;
	private List<Appliance> searchResult = new ArrayList<>();
	private Map<String, Object> criteria;

	public ApplianceDAOImpl(){
		try{
			applianceList = getApplianceList();
		}
		catch (ParserConfigurationException e) {
		}
		catch (SAXException e){
		}
		catch (IOException e){
		}
		catch(Exception e){
		}
	}

	public List<Appliance> find(Criteria criteria) {
		// you may add your own code here

		String groupSearchName = criteria.getGroupSearchName();
		this.criteria = criteria.getCriteria();


		for(Appliance appliance : applianceList){

			boolean checked = false;

			if(appliance.getClass().getSimpleName().equals(groupSearchName)){

				SearchCriteria.Class className = SearchCriteria.Class.valueOf(groupSearchName.toUpperCase());

				switch (className){

					case LAPTOP: checked=IsThatLaptop((Laptop)appliance); break;
					case OVEN: checked=IsThatOven((Oven)appliance);break;
					case REFRIGERATOR: checked=IsThatRefrigerator((Refrigerator)appliance);break;
					case SPEAKERS: checked=IsThatSpeakers((Speakers) appliance); break;
					case TABLETPC: checked=IsThatTabletPC((TabletPC)appliance); break;
					case VACUUMCLEANER: checked=IsThatVacuumCleaner((VacuumCleaner)appliance); break;
				}
			}

			if (checked){
				searchResult.add(appliance);
			}
		}

		return searchResult;
	}

	// you may add your own code here

	private List<Appliance> getApplianceList() throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser parser = factory.newSAXParser();

		ApplianceSaxHandler handler = new ApplianceSaxHandler();

		try{
			parser.parse(new File("D:\\EpamJavaCourse\\jwd-task01-template_v2\\src\\main\\resources\\appliances_db.xml"), handler);
		}
		catch (Exception e){
		}

		return handler.getApplianceList();

	}


	private boolean IsThatLaptop(Laptop laptop){

		if(criteria.containsKey("BATTERY_CAPACITY")){
			Float value = Float.parseFloat(criteria.get("BATTERY_CAPACITY").toString());
			if(!value.equals(laptop.getBatteryCapacity())){
				return false;
			}
		}
		if(criteria.containsKey("OS") && !(criteria.get("OS").toString().equals(laptop.getOs()))){
			return false;
		}
		if(criteria.containsKey("MEMORY_ROM") && !(criteria.get("MEMORY_ROM").equals(laptop.getMemoryRom()))){
			return false;
		}
		if(criteria.containsKey("SYSTEM_MEMORY") && !(criteria.get("SYSTEM_MEMORY").equals(laptop.getSystemMemory()))){
			return false;
		}
		if(criteria.containsKey("CPU") && !(criteria.get("CPU").toString().equals(laptop.getCpu()))){
			return false;
		}
		if(criteria.containsKey("DISPLAY_INCHS") && !(criteria.get("DISPLAY_INCHS").equals(laptop.getDisplayInch()))){
			return false;
		}

		return true;
	}

	private boolean IsThatOven(Oven oven){

		if(criteria.containsKey("POWER_CONSUMPTION") && !(criteria.get("POWER_CONSUMPTION").equals(oven.getPowerConsumption()))){
			return false;
		}

		if(criteria.containsKey("WEIGHT") && !(criteria.get("WEIGHT").equals(oven.getWeight()))){
			return false;
		}

		if(criteria.containsKey("CAPACITY") && !(criteria.get("CAPACITY").equals(oven.getCapacity()))){
			return false;
		}

		if(criteria.containsKey("DEPTH") && !(criteria.get("DEPTH").equals(oven.getDepth()))){
			return false;
		}

		if(criteria.containsKey("HEIGHT")){
			Float value = Float.parseFloat(criteria.get("HEIGHT").toString());
			if(!value.equals(oven.getHeight())){
				return false;
			}
		}

		if(criteria.containsKey("WIDTH")){
			Float value = Float.parseFloat(criteria.get("WIDTH").toString());
			if(!value.equals(oven.getWidth())){
				return false;
			}
		}

		return true;
	}


	private boolean IsThatRefrigerator(Refrigerator refrigerator){

		if(criteria.containsKey("POWER_CONSUMPTION") && !(criteria.get("POWER_CONSUMPTION").equals(refrigerator.getPowerConsumption()))){
			return false;
		}

		if(criteria.containsKey("WEIGHT") && !(criteria.get("WEIGHT").equals(refrigerator.getWeight()))){
			return false;
		}

		if(criteria.containsKey("FREEZER_CAPACITY") && !(criteria.get("FREEZER_CAPACITY").equals(refrigerator.getFreezerCapacity()))){
			return false;
		}

		if(criteria.containsKey("OVERALL_CAPACITY") && !(criteria.get("OVERALL_CAPACITY").equals(refrigerator.getOverallCapacity()))){
			return false;
		}

		if(criteria.containsKey("HEIGHT") && !(criteria.get("HEIGHT").equals(refrigerator.getHeight()))){
			return false;
		}

		if(criteria.containsKey("WIDTH") && !(criteria.get("WIDTH").equals(refrigerator.getWidth()))){
			return false;
		}

		return true;
	}


	private boolean IsThatSpeakers(Speakers speakers){

		if(criteria.containsKey("POWER_CONSUMPTION") && !(criteria.get("POWER_CONSUMPTION").equals(speakers.getPowerConsumption()))){
			return false;
		}

		if(criteria.containsKey("NUMBER_OF_SPEAKERS") && !(criteria.get("NUMBER_OF_SPEAKERS").equals(speakers.getNumberOfSpeakers()))){
			return false;
		}

		if(criteria.containsKey("FREQUENCY_RANGE") && !(criteria.get("FREQUENCY_RANGE").equals(speakers.getFrequencyRange()))){
			return false;
		}

		if(criteria.containsKey("CORD_LENGTH") && !(criteria.get("CORD_LENGTH").equals(speakers.getCordLength()))){
			return false;
		}

		return true;
	}


	private boolean IsThatTabletPC(TabletPC tabletPC){

		if(criteria.containsKey("BATTERY_CAPACITY") && !(criteria.get("BATTERY_CAPACITY").equals(tabletPC.getBatteryCapacity()))){
			return false;
		}

		if(criteria.containsKey("DISPLAY_INCHES") && !(criteria.get("DISPLAY_INCHES").equals(tabletPC.getDisplayInches()))){
			return false;
		}

		if(criteria.containsKey("MEMORY_ROM") && !(criteria.get("MEMORY_ROM").equals(tabletPC.getMemoryRom()))){
			return false;
		}

		if(criteria.containsKey("FLASH_MEMORY_CAPACITY") && !(criteria.get("FLASH_MEMORY_CAPACITY").equals(tabletPC.getFlashMemoryCapacity()))){
			return false;
		}

		if(criteria.containsKey("COLOR") && !(criteria.get("COLOR").toString().toLowerCase().equals(tabletPC.getColor()))){
			return false;
		}

		return true;
	}


	private boolean IsThatVacuumCleaner(VacuumCleaner vacuumCleaner){

		if(criteria.containsKey("POWER_CONSUMPTION") && !(criteria.get("POWER_CONSUMPTION").equals(vacuumCleaner.getPowerConsumption()))){
			return false;
		}

		if(criteria.containsKey("FILTER_TYPE") && !(criteria.get("FILTER_TYPE").equals(vacuumCleaner.getFilterType()))){
			return false;
		}

		if(criteria.containsKey("BAG_TYPE") && !(criteria.get("BAG_TYPE").equals(vacuumCleaner.getBagType()))){
			return false;
		}

		if(criteria.containsKey("WAND_TYPE") && !(criteria.get("WAND_TYPE").equals(vacuumCleaner.getWandType()))){
			return false;
		}

		if(criteria.containsKey("MOTOR_SPEED_REGULATION") && !(criteria.get("MOTOR_SPEED_REGULATION").equals(vacuumCleaner.getMotorSpeedRegulation()))){
			return false;
		}

		if(criteria.containsKey("CLEANING_WIDTH") && !(criteria.get("CLEANING_WIDTH").equals(vacuumCleaner.getCleaningWidth()))){
			return false;
		}

		return true;
	}

}


//you may add your own new classes