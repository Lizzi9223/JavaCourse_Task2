package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.enums.SearchCriteria;

public class Validator {

	private static final String errorMessage = "Criteria is not valid";
	
	public static boolean criteriaValidator(Criteria criteria) {

		SearchCriteria.Class className = SearchCriteria.Class.valueOf(criteria.getGroupSearchName().toUpperCase());

		switch (className){

			case LAPTOP: return laptopValidator(criteria);
			case OVEN: return ovenValidator(criteria);
			case REFRIGERATOR: return  refrigeratorValidator(criteria);
			case SPEAKERS: return speakersValidator(criteria);
			case TABLETPC: return tabletPCValidator(criteria);
			case VACUUMCLEANER: return vacuumCleanerValidator(criteria);
			default: return false;
		}

	}

	private static boolean laptopValidator(Criteria criteria){

		final int BATTERY_CAPACITY_MIN_VALUE = 1;
		final int BATTERY_CAPACITY_MAX_VALUE = 10;
		final int MEMORY_ROM_MIN_VALUE = 2000;
		final int MEMORY_ROM_MAX_VALUE = 64000;
		final int SYSTEM_MEMORY_MIN_VALUE = 500;
		final int SYSTEM_MEMORY_MAX_VALUE = 5000;
		final int DISPLAY_INCH_MIN_VALUE = 10;
		final int DISPLAY_INCH_MAX_VALUE = 30;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Double)){
				throw new RuntimeException(errorMessage);
			}
			else{
				double batteryCapacity = (double) criteriaValue;
				if(batteryCapacity < BATTERY_CAPACITY_MIN_VALUE || batteryCapacity > BATTERY_CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.OS.toString());
		if (criteriaValue != null && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.MEMORY_ROM.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int memoryRom = (int)criteriaValue;
				if(memoryRom < MEMORY_ROM_MIN_VALUE || memoryRom > MEMORY_ROM_MAX_VALUE || memoryRom % 2000 != 0){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int systemMemory = (int)criteriaValue;
				if(systemMemory < SYSTEM_MEMORY_MIN_VALUE || systemMemory > SYSTEM_MEMORY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.CPU.toString());
		if (criteriaValue != null && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Laptop.DISPLAY_INCHS.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int displayInch = (int)criteriaValue;
				if(displayInch < DISPLAY_INCH_MIN_VALUE || displayInch > DISPLAY_INCH_MAX_VALUE){
					return false;
				}
			}
		}

		return true;
	}


	private static boolean ovenValidator(Criteria criteria){

		final int POWER_CONSUMPTION_MIN_VALUE = 500;
		final int POWER_CONSUMPTION_MAX_VALUE = 5000;
		final int WEIGHT_MIN_VALUE = 5;
		final int WEIGHT_MAX_VALUE = 20;
		final int CAPACITY_MIN_VALUE = 20;
		final int CAPACITY_MAX_VALUE = 40;
		final int DEPTH_MIN_VALUE = 40;
		final int DEPTH_MAX_VALUE = 80;
		final int HEIGHT_MIN_VALUE = 20;
		final int HEIGHT_MAX_VALUE = 60;
		final int WIDTH_MIN_VALUE = 40;
		final int WIDTH_MAX_VALUE = 100;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.POWER_CONSUMPTION.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int powerConsumption = (int)criteriaValue;
				if(powerConsumption < POWER_CONSUMPTION_MIN_VALUE || powerConsumption > POWER_CONSUMPTION_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.WEIGHT.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int weight = (int)criteriaValue;
				if(weight < WEIGHT_MIN_VALUE || weight > WEIGHT_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int capacity = (int)criteriaValue;
				if(capacity < CAPACITY_MIN_VALUE || capacity > CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.DEPTH.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int depth = (int)criteriaValue;
				if(depth < DEPTH_MIN_VALUE || depth > DEPTH_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.HEIGHT.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Double)){
				throw new RuntimeException(errorMessage);
			}
			else{
				double height = (double)criteriaValue;
				if(height < HEIGHT_MIN_VALUE || height > HEIGHT_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.WIDTH.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Double)){
				throw new RuntimeException(errorMessage);
			}
			else{
				double width = (double)criteriaValue;
				if(width < WIDTH_MIN_VALUE || width > WIDTH_MAX_VALUE){
					return false;
				}
			}
		}

		return true;
	}


	private static boolean refrigeratorValidator(Criteria criteria){

		final int POWER_CONSUMPTION_MIN_VALUE = 50;
		final int POWER_CONSUMPTION_MAX_VALUE = 500;
		final int WEIGHT_MIN_VALUE = 10;
		final int WEIGHT_MAX_VALUE = 50;
		final int FREEZER_CAPACITY_MIN_VALUE = 5;
		final int FREEZER_CAPACITY_MAX_VALUE = 50;
		final int OVERALL_CAPACITY_MIN_VALUE = 100;
		final int OVERALL_CAPACITY_MAX_VALUE = 500;
		final int HEIGHT_MIN_VALUE = 100;
		final int HEIGHT_MAX_VALUE = 500;
		final int WIDTH_MIN_VALUE = 50;
		final int WIDTH_MAX_VALUE = 100;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int powerConsumption = (int)criteriaValue;
				if(powerConsumption < POWER_CONSUMPTION_MIN_VALUE || powerConsumption > POWER_CONSUMPTION_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Refrigerator.WEIGHT.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int weight = (int)criteriaValue;
				if(weight < WEIGHT_MIN_VALUE || weight > WEIGHT_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int freezerCapacity = (int)criteriaValue;
				if(freezerCapacity < FREEZER_CAPACITY_MIN_VALUE || freezerCapacity > FREEZER_CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Double)){
				throw new RuntimeException(errorMessage);
			}
			else{
				double overallCapacity = (double)criteriaValue;
				if(overallCapacity < OVERALL_CAPACITY_MIN_VALUE || overallCapacity > OVERALL_CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.HEIGHT.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int height = (int)criteriaValue;
				if(height < HEIGHT_MIN_VALUE || height > HEIGHT_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Oven.WIDTH.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int width = (int)criteriaValue;
				if(width < WIDTH_MIN_VALUE || width > WIDTH_MAX_VALUE){
					return false;
				}
			}
		}

		return true;

	}


	private static boolean speakersValidator(Criteria criteria){

		final int POWER_CONSUMPTION_MIN_VALUE = 5;
		final int POWER_CONSUMPTION_MAX_VALUE = 50;
		final int NUMBER_OF_SPEAKERS_MIN_VALUE = 1;
		final int NUMBER_OF_SPEAKERS_MAX_VALUE = 10;
		final int CORD_LENGTH_MIN_VALUE = 1;
		final int CORD_LENGTH_MAX_VALUE = 10;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int powerConsumption = (int)criteriaValue;
				if(powerConsumption < POWER_CONSUMPTION_MIN_VALUE || powerConsumption > POWER_CONSUMPTION_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int numberOfSpeakers = (int)criteriaValue;
				if(numberOfSpeakers < NUMBER_OF_SPEAKERS_MIN_VALUE || numberOfSpeakers > NUMBER_OF_SPEAKERS_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
		if (criteriaValue != null && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.Speakers.CORD_LENGTH.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Double)){
				throw new RuntimeException(errorMessage);
			}
			else{
				double cordLength = (double)criteriaValue;
				if(cordLength < CORD_LENGTH_MIN_VALUE || cordLength > CORD_LENGTH_MAX_VALUE){
					return false;
				}
			}
		}

		return true;
	}


	private static boolean tabletPCValidator(Criteria criteria){

		final int BATTERY_CAPACITY_MIN_VALUE = 1;
		final int BATTERY_CAPACITY_MAX_VALUE = 10;
		final int DISPLAY_INCHES_MIN_VALUE = 10;
		final int DISPLAY_INCHES_MAX_VALUE = 30;
		final int MEMORY_ROM_MIN_VALUE = 2000;
		final int MEMORY_ROM_MAX_VALUE = 64000;
		final int FLASH_MEMORY_CAPACITY_MIN_VALUE = 1;
		final int FLASH_MEMORY_CAPACITY_MAX_VALUE = 20;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int batteryCapacity = (int)criteriaValue;
				if(batteryCapacity < BATTERY_CAPACITY_MIN_VALUE || batteryCapacity > BATTERY_CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int displayInches = (int)criteriaValue;
				if(displayInches < DISPLAY_INCHES_MIN_VALUE || displayInches > DISPLAY_INCHES_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.TabletPC.MEMORY_ROM.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int memoryRom = (int)criteriaValue;
				if(memoryRom < MEMORY_ROM_MIN_VALUE || memoryRom > MEMORY_ROM_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int flashMemoryCapacity = (int)criteriaValue;
				if(flashMemoryCapacity < FLASH_MEMORY_CAPACITY_MIN_VALUE || flashMemoryCapacity > FLASH_MEMORY_CAPACITY_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.TabletPC.COLOR.toString());
		if (criteriaValue != null && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		return true;

	}


	private static boolean vacuumCleanerValidator(Criteria criteria){

		final int POWER_CONSUMPTION_MIN_VALUE = 50;
		final int POWER_CONSUMPTION_MAX_VALUE = 200;
		final int MOTOR_SPEED_REGULATION_MIN_VALUE = 1000;
		final int MOTOR_SPEED_REGULATION_MAX_VALUE = 4000;
		final int CLEANING_WIDTH_REGULATION_MIN_VALUE = 5;
		final int CLEANING_WIDTH_REGULATION_MAX_VALUE = 50;

		Object criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int powerConsumption = (int)criteriaValue;
				if(powerConsumption < POWER_CONSUMPTION_MIN_VALUE || powerConsumption > POWER_CONSUMPTION_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
		if (criteriaValue != null && !(criteriaValue instanceof String)){
				throw new RuntimeException(errorMessage);
			}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
		if ((criteriaValue != null) && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
		if ((criteriaValue != null) && !(criteriaValue instanceof String)){
			throw new RuntimeException(errorMessage);
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int motorSpeedRegulation = (int)criteriaValue;
				if(motorSpeedRegulation < MOTOR_SPEED_REGULATION_MIN_VALUE || motorSpeedRegulation > MOTOR_SPEED_REGULATION_MAX_VALUE){
					return false;
				}
			}
		}

		criteriaValue = criteria.getCriteria().get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString());
		if(criteriaValue != null){
			if (!(criteriaValue instanceof Integer)){
				throw new RuntimeException(errorMessage);
			}
			else{
				int cleaningWidth = (int)criteriaValue;
				if(cleaningWidth < CLEANING_WIDTH_REGULATION_MIN_VALUE || cleaningWidth > CLEANING_WIDTH_REGULATION_MAX_VALUE){
					return false;
				}
			}
		}

		return true;
	}

}

//you may add your own new classes