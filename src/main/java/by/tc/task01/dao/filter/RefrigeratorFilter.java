package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class RefrigeratorFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria) {

        Refrigerator refrigerator = (Refrigerator)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("POWER_CONSUMPTION") && !(criteriaMap.get("POWER_CONSUMPTION").equals(refrigerator.getPowerConsumption()))){
            return false;
        }

        if(criteriaMap.containsKey("WEIGHT") && !(criteriaMap.get("WEIGHT").equals(refrigerator.getWeight()))){
            return false;
        }

        if(criteriaMap.containsKey("FREEZER_CAPACITY") && !(criteriaMap.get("FREEZER_CAPACITY").equals(refrigerator.getFreezerCapacity()))){
            return false;
        }

        if(criteriaMap.containsKey("OVERALL_CAPACITY") && !(criteriaMap.get("OVERALL_CAPACITY").equals(refrigerator.getOverallCapacity()))){
            return false;
        }

        if(criteriaMap.containsKey("HEIGHT") && !(criteriaMap.get("HEIGHT").equals(refrigerator.getHeight()))){
            return false;
        }

        if(criteriaMap.containsKey("WIDTH") && !(criteriaMap.get("WIDTH").equals(refrigerator.getWidth()))){
            return false;
        }

        return true;
    }
}
