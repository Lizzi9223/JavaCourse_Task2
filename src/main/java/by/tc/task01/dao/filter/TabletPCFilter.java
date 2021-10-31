package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class TabletPCFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria) {

        TabletPC tabletPC = (TabletPC)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("BATTERY_CAPACITY") && !(criteriaMap.get("BATTERY_CAPACITY").equals(tabletPC.getBatteryCapacity()))){
            return false;
        }

        if(criteriaMap.containsKey("DISPLAY_INCHES") && !(criteriaMap.get("DISPLAY_INCHES").equals(tabletPC.getDisplayInches()))){
            return false;
        }

        if(criteriaMap.containsKey("MEMORY_ROM") && !(criteriaMap.get("MEMORY_ROM").equals(tabletPC.getMemoryRom()))){
            return false;
        }

        if(criteriaMap.containsKey("FLASH_MEMORY_CAPACITY") && !(criteriaMap.get("FLASH_MEMORY_CAPACITY").equals(tabletPC.getFlashMemoryCapacity()))){
            return false;
        }

        if(criteriaMap.containsKey("COLOR") && !(criteriaMap.get("COLOR").toString().toLowerCase().equals(tabletPC.getColor()))){
            return false;
        }

        return true;
    }
}
