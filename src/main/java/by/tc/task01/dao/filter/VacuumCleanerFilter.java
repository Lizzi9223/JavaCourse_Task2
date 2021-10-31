package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class VacuumCleanerFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria) {

        VacuumCleaner vacuumCleaner = (VacuumCleaner)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("POWER_CONSUMPTION") && !(criteriaMap.get("POWER_CONSUMPTION").equals(vacuumCleaner.getPowerConsumption()))){
            return false;
        }

        if(criteriaMap.containsKey("FILTER_TYPE") && !(criteriaMap.get("FILTER_TYPE").equals(vacuumCleaner.getFilterType()))){
            return false;
        }

        if(criteriaMap.containsKey("BAG_TYPE") && !(criteriaMap.get("BAG_TYPE").equals(vacuumCleaner.getBagType()))){
            return false;
        }

        if(criteriaMap.containsKey("WAND_TYPE") && !(criteriaMap.get("WAND_TYPE").equals(vacuumCleaner.getWandType()))){
            return false;
        }

        if(criteriaMap.containsKey("MOTOR_SPEED_REGULATION") && !(criteriaMap.get("MOTOR_SPEED_REGULATION").equals(vacuumCleaner.getMotorSpeedRegulation()))){
            return false;
        }

        if(criteriaMap.containsKey("CLEANING_WIDTH") && !(criteriaMap.get("CLEANING_WIDTH").equals(vacuumCleaner.getCleaningWidth()))){
            return false;
        }

        return true;
    }
}
