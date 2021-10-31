package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> applianceList) {

		System.out.println("-------------------------------");
		if(applianceList.size()>0){
			for (Appliance appliance : applianceList){
				System.out.println(appliance);
			}
		}
		else{
			System.out.println("No results");
		}
		// you may add your own code here

	}
	
	// you may add your own code here

}
