package by.tc.task01.dao.filter;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public interface ApplianceFilter {

    boolean filterAppliance(Appliance appliance, Criteria criteria);

}
