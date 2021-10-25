package by.tc.task01.dao.parser;

import by.tc.task01.entity.*;
import by.tc.task01.enums.ApplianceTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class ApplianceSaxHandler extends DefaultHandler {

    private static List<Appliance> applianceList = new ArrayList<>();

    private ApplianceTagName applianceTagName;

    private Laptop laptop;
    private Oven oven;
    private Refrigerator refrigerator;
    private Speakers speakers;
    private TabletPC tabletPC;
    private VacuumCleaner vacuumCleaner;

    private StringBuilder text;


    public static List<Appliance> getApplianceList(){
        return applianceList;
    }

    public void characters(char[] buffer, int start, int length) throws SAXException {
        text.append(buffer, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        text = new StringBuilder();

        ApplianceTagName tagName = ApplianceTagName.valueOf(qName.toUpperCase().replace("-","_"));

        switch (tagName){
            case APPLIANCE_LIST: break;
            case LAPTOP: {
                applianceTagName = ApplianceTagName.LAPTOP;
                laptop = new Laptop();
            } break;
            case OVEN:{
                applianceTagName = ApplianceTagName.OVEN;
                oven = new Oven();
            } break;
            case REFRIGERATOR:{
                applianceTagName = ApplianceTagName.REFRIGERATOR;
                refrigerator = new Refrigerator();
            }break;
            case SPEAKERS:{
                applianceTagName = ApplianceTagName.SPEAKERS;
                speakers = new Speakers();
            }break;
            case TABLET_PC:{
                applianceTagName = ApplianceTagName.TABLET_PC;
                tabletPC = new TabletPC();
            }break;
            case VACUUM_CLEANER:{
                applianceTagName = ApplianceTagName.VACUUM_CLEANER;
                vacuumCleaner = new VacuumCleaner();
            }break;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        ApplianceTagName tagName = ApplianceTagName.valueOf(qName.toUpperCase().replace("-","_"));

        switch (applianceTagName){
            case LAPTOP:{
                switch (tagName){
                    case BATTERY_CAPACITY: laptop.setBatteryCapacity(Float.parseFloat(text.toString())); break;
                    case OS: laptop.setOs(text.toString()); break;
                    case MEMORY_ROM: laptop.setMemoryRom(Integer.parseInt(text.toString())); break;
                    case SYSTEM_MEMORY: laptop.setSystemMemory(Integer.parseInt(text.toString())); break;
                    case CPU: laptop.setCpu(text.toString()); break;
                    case DISPLAY_INCHES: laptop.setDisplayInch(Integer.parseInt(text.toString()));
                }
            } break;
            case OVEN:{
                switch (tagName){
                    case POWER_CONSUMPTION: oven.setPowerConsumption(Integer.parseInt(text.toString())); break;
                    case WEIGHT: oven.setWeight(Integer.parseInt(text.toString())); break;
                    case CAPACITY: oven.setCapacity(Integer.parseInt(text.toString())); break;
                    case DEPTH: oven.setDepth(Integer.parseInt(text.toString())); break;
                    case HEIGHT: oven.setHeight(Float.parseFloat(text.toString())); break;
                    case WIDTH: oven.setWidth(Float.parseFloat(text.toString())); break;
                }
            }break;
            case REFRIGERATOR:{
                switch (tagName){
                    case POWER_CONSUMPTION: refrigerator.setPowerConsumption(Integer.parseInt(text.toString())); break;
                    case WEIGHT: refrigerator.setWeight(Integer.parseInt(text.toString())); break;
                    case FREEZER_CAPACITY: refrigerator.setFreezerCapacity(Integer.parseInt(text.toString())); break;
                    case OVERALL_CAPACITY: refrigerator.setOverallCapacity(Float.parseFloat(text.toString())); break;
                    case HEIGHT: refrigerator.setHeight(Integer.parseInt(text.toString())); break;
                    case WIDTH: refrigerator.setWidth(Integer.parseInt(text.toString())); break;
                }
            }break;
            case SPEAKERS:{
                switch (tagName){
                    case POWER_CONSUMPTION: speakers.setPowerConsumption(Integer.parseInt(text.toString())); break;
                    case NUMBER_OF_SPEAKERS: speakers.setNumberOfSpeakers(Integer.parseInt(text.toString())); break;
                    case FREQUENCY_RANGE: speakers.setFrequencyRange(text.toString()); break;
                    case CORD_LENGTH: speakers.setCordLength(Integer.parseInt(text.toString())); break;
                }
            }break;
            case TABLET_PC:{
                switch (tagName){
                    case BATTERY_CAPACITY: tabletPC.setBatteryCapacity(Integer.parseInt(text.toString())); break;
                    case DISPLAY_INCHES: tabletPC.setDisplayInches(Integer.parseInt(text.toString())); break;
                    case MEMORY_ROM: tabletPC.setMemoryRom(Integer.parseInt(text.toString())); break;
                    case FLASH_MEMORY_CAPACITY: tabletPC.setFlashMemoryCapacity(Integer.parseInt(text.toString())); break;
                    case COLOR: tabletPC.setColor(text.toString()); break;
                }
            }break;
            case VACUUM_CLEANER:{
                switch (tagName){
                    case POWER_CONSUMPTION: vacuumCleaner.setPowerConsumption(Integer.parseInt(text.toString())); break;
                    case FILTER_TYPE: vacuumCleaner.setFilterType(text.toString()); break;
                    case BAG_TYPE: vacuumCleaner.setBagType(text.toString()); break;
                    case WAND_TYPE: vacuumCleaner.setWandType(text.toString()); break;
                    case MOTOR_SPEED_REGULATION: vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(text.toString())); break;
                    case CLEANING_WIDTH: vacuumCleaner.setCleaningWidth(Integer.parseInt(text.toString())); break;
                }
            }break;
        }


        switch (tagName){
            case LAPTOP: applianceList.add(laptop); laptop=null; break;
            case OVEN: applianceList.add(oven); oven=null; break;
            case REFRIGERATOR: applianceList.add(refrigerator); refrigerator=null; break;
            case SPEAKERS: applianceList.add(speakers); speakers=null; break;
            case TABLET_PC: applianceList.add(tabletPC); tabletPC=null; break;
            case VACUUM_CLEANER: applianceList.add(vacuumCleaner); vacuumCleaner=null; break;
        }



    }
}
