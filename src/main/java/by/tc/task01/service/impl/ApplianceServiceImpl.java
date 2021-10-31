package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	DAOFactory factory = DAOFactory.getInstance();
	ApplianceDAO applianceDAO = factory.getApplianceDAO();

	@Override
	public List<Appliance> find(Criteria criteria) {
		try{
			if (!Validator.criteriaValidator(criteria)) {
				return new ArrayList<>();
			}
		}
		catch(Exception exception){
			throw new RuntimeException(exception.getMessage());
		}

		List<Appliance> applianceList = applianceDAO.find(criteria);

		
		return applianceList;
	}

	public void save(List<Appliance> applianceList){
		applianceDAO.save(applianceList);
	}

}
