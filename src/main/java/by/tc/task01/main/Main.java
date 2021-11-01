package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Appliance> applianceList;
		List<Appliance> saveApplianceList = new ArrayList<>();

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());//"Laptop"
		criteriaLaptop.add(Laptop.BATTERY_CAPACITY.toString(), 100);

		try {
			applianceList = service.find(criteriaLaptop);
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 33);
		criteriaOven.add(Oven.HEIGHT.toString(), 40.0);

		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

//		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 45.0);
		criteriaOven.add(Oven.DEPTH.toString(), 60);

		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

//		//////////////////////////////////////////////////////////////////

		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

		try {
			applianceList = service.find(criteriaTabletPC);// find(Object...obj)
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

		service.save(saveApplianceList);

	}

}
