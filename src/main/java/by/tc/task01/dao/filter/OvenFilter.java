package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class OvenFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria){

        Oven oven = (Oven)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("POWER_CONSUMPTION") && !(criteriaMap.get("POWER_CONSUMPTION").equals(oven.getPowerConsumption()))){
            return false;
        }

        if(criteriaMap.containsKey("WEIGHT") && !(criteriaMap.get("WEIGHT").equals(oven.getWeight()))){
            return false;
        }

        if(criteriaMap.containsKey("CAPACITY") && !(criteriaMap.get("CAPACITY").equals(oven.getCapacity()))){
            return false;
        }

        if(criteriaMap.containsKey("DEPTH") && !(criteriaMap.get("DEPTH").equals(oven.getDepth()))){
            return false;
        }

        if(criteriaMap.containsKey("HEIGHT")){
            Float value = Float.parseFloat(criteriaMap.get("HEIGHT").toString());
            if(!value.equals(oven.getHeight())){
                return false;
            }
        }

        if(criteriaMap.containsKey("WIDTH")){
            Float value = Float.parseFloat(criteriaMap.get("WIDTH").toString());
            if(!value.equals(oven.getWidth())){
                return false;
            }
        }

        return true;
    }
}
