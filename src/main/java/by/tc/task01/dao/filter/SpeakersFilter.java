package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class SpeakersFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria) {

        Speakers speakers = (Speakers)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("POWER_CONSUMPTION") && !(criteriaMap.get("POWER_CONSUMPTION").equals(speakers.getPowerConsumption()))){
            return false;
        }

        if(criteriaMap.containsKey("NUMBER_OF_SPEAKERS") && !(criteriaMap.get("NUMBER_OF_SPEAKERS").equals(speakers.getNumberOfSpeakers()))){
            return false;
        }

        if(criteriaMap.containsKey("FREQUENCY_RANGE") && !(criteriaMap.get("FREQUENCY_RANGE").equals(speakers.getFrequencyRange()))){
            return false;
        }

        if(criteriaMap.containsKey("CORD_LENGTH") && !(criteriaMap.get("CORD_LENGTH").equals(speakers.getCordLength()))){
            return false;
        }

        return true;
    }
}
