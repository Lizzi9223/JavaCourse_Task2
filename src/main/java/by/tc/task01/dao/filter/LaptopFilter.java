package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class LaptopFilter implements ApplianceFilter {

    @Override
    public boolean filterAppliance(Appliance appliance, Criteria criteria){

        Laptop laptop = (Laptop)appliance;
        Map<String, Object> criteriaMap = criteria.getCriteria();

        if(criteriaMap.containsKey("BATTERY_CAPACITY")){
            Float value = Float.parseFloat(criteriaMap.get("BATTERY_CAPACITY").toString());
            if(!value.equals(laptop.getBatteryCapacity())){
                return false;
            }
        }
        if(criteriaMap.containsKey("OS") && !(criteriaMap.get("OS").toString().equals(laptop.getOs()))){
            return false;
        }
        if(criteriaMap.containsKey("MEMORY_ROM") && !(criteriaMap.get("MEMORY_ROM").equals(laptop.getMemoryRom()))){
            return false;
        }
        if(criteriaMap.containsKey("SYSTEM_MEMORY") && !(criteriaMap.get("SYSTEM_MEMORY").equals(laptop.getSystemMemory()))){
            return false;
        }
        if(criteriaMap.containsKey("CPU") && !(criteriaMap.get("CPU").toString().equals(laptop.getCpu()))){
            return false;
        }
        if(criteriaMap.containsKey("DISPLAY_INCHS") && !(criteriaMap.get("DISPLAY_INCHS").equals(laptop.getDisplayInch()))){
            return false;
        }

        return true;
    }

}
