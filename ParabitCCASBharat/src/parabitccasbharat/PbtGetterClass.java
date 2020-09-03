/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

/**
 *
 * @author Asus
 */
public class PbtGetterClass {
    public static String getRoof(long data)
    {
        switch((int)data)
        {
        case 1: return "Grass/Thatch/Bamboo/Wood/Mud";
        case 2: return "Plastic/Polythene";
        case 3: return "Handmade Tiles";
        case 4: return "Machine made Tiles";
        case 5: return "Burnt Brick";
        case 6: return "Stone";
        case 7: return "Slate";
        case 8: return "G.I/Metal/Asbestos sheets";
        case 9: return "Concrete";
        case 10: return "Glass";
        }
        return "";
    }
    public static String getFloor(long data)
    {
        switch((int)data)
        {
        case 1: return "Mud";
        case 2: return "Wood/Bamboo";
        case 3: return "Burnt Brick";
        case 4: return "Mosaic";
        case 5: return "Floor Tiles";
        case 6: return "Cement";
        case 7: return "Stone - Granite";
        case 8: return "Stone - Marble ";
        case 9: return "Stone - Kota";
        case 10: return "Stone";
        case 11: return "Glass";
        }
        return "";
    }
    public static String getWall(long data)
    {
        switch((int)data)
        {
        case 1: return "Grass/Thatch/Bamboo";
        case 2: return "Plastic/Polythene";
        case 3: return "Mud/Unburnt brick";
        case 4: return "Wood";
        case 5: return "Stone not packed with mortar";
        case 6: return "Stone packed with mortar";
        case 7: return "G.I/Metal/Asbestos Sheets";
        case 8: return "Burnt Brick";
        case 9: return "Concrete";
        case 10: return "Glass";
        case 11: return "PVC";
        }
        return "";
    }
    public static String getConditionHouse(long data)
    {
        switch((int)data)
        {
        case 1: return "Good";
        case 2: return "Livable";
        case 3: return "Non Livable";
        }
        return "";
    }
    public static String getAccessToilet(long data)
    {
        switch((int)data)
        {
        case 1: return "Exclusively for Household use only";
        case 2: return "Shared with other Household";
        case 3: return "Public Latrine";
        case 4: return "Open";
        }
        return "";
    }
    public static String getTypeToilet(long data)
    {
        switch((int)data)
        {
        case 1: return "Flush / Pour flush connected to Piped Sewer System";
        case 2: return "Flush / Pour flush connected to Septic Tank";
        case 3: return "Flush / Pour flush connected to Other System";
        case 4: return "Twin pit latrin with Slab / Ventilated improved pit";
        case 5: return "Twin pit latrin without Slab / Open pit";
        case 6: return "Single pit latrine with Slab / Ventilated improved pit";
        case 7: return "Single pit latrine without Slab / Open pit";
        case 8: return "Service latrine Night Soil removed by Human";
        case 9: return "Service latrine Night Soil serviced by Animals";
        case 10: return "Night Soil disposed into Open Drain";
        }
        return "";
    }
    public static String getBathing(long data)
    {
        switch((int)data)
        {
        case 1: return "Bathroom";
        case 2: return "Enclosure without Roof";
        case 3: return "No";
        }
        return "";
    }
    public static String getKitchen(long data)
    {
        switch((int)data)
        {
        case 1: return "Cooking In Kitchen";
        case 2: return "Cooking Inside House But Not In Kitchen";
        case 3: return "Cooking In Open/Outside House";
        case 4: return "No Cooking";
        }
        return "";
    }
    public static String getCookFuel(long data)
    {
        switch((int)data)
        {
        case 1: return "Firwood";
        case 2: return "Crop Residue";
        case 3: return "Cowdung Cake";
        case 4: return "Coal/Lignite/Charcoal";
        case 5: return "Kerosene";
        case 6: return "LPG/PNG";
        case 7: return "Induction";
        case 8: return "Microwave Owen";
        case 9: return "Bio-Gas";
        case 10: return "Solar";
        case 11: return "AnyOther";
        }
        return "";
    }
    public static String getUseOfHouse(long data)
    {
        switch((int)data)
        {
        case 1: return "Residence";
        case 2: return "Residence-cum-other use";
        case 3: return "Shop/Office";
        case 4: return "School/College";
        case 5: return "Hotel/Lodge/Guest house";
        case 6: return "Hospital/Dispensary";
        case 7: return "Factory/Workshop/Workshed";
        case 8: return "Place of worship";
        case 9: return "Other non-residential use";
        case 10: return "Vacant";
        }
        return "";
    }
    public static String getOwnership(long data)
    {
        switch((int)data)
        {
        case 1: return "Owned";
        case 2: return "Rented but has Own House Elsewhere";
        case 3: return "Rented and not Own Any House";
        case 4: return "Any Other";
        }
        return "";
    }
    public static String getGeneticDisease(String num)
    {
        ParabitDBC db=new ParabitDBC();
        String query="select * from typesofgeneticdisease where sno='"+num+"'";
        try
        {
            db.rs1=db.stm.executeQuery(query);
            if(db.rs1.next())
                return db.rs1.getString("DiseaseType");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;  
    }
    public static String getTV(long data)
    {
        switch((int)data)
        {
        case 1: return "LED";
        case 2: return "LCD";
        case 3: return "Plasma";
        case 4: return "OLED";
        case 5: return "QLED";
        case 6: return "DLP";
        case 7: return "DLD";
        case 8: return "MICRO LED";
        case 9: return "3DTV";
        case 10: return "Direct View";
        }
        return "";
    }
    public static String getTvSignal(long data)
    {
        switch((int)data)
        {
        case 1: return "DDFreeDish";
        case 2: return "Cable";
        case 3: return "DTH";
        case 4: return "WebTV";
        }
        return "";
    }
    public static String getCool(long data)
    {
        switch((int)data)
        {
        case 1: return "Fan";
        case 2: return "Cooler";
        case 3: return "Air Conditioner/AC";
        case 4: return "Fan and Cooler";
        case 5: return "Cooler and AC";
        case 6: return "Fan and AC";
        case 7: return "Fan and Cooler and AC";
        case 8: return "Heat Pump";
        case 9: return "Indirect Direct Evaporating Cooling System (IDEC)";
        case 10: return "Cooling Towers";
        case 11: return "Air Cooling Unit";
        case 12: return "Roof Cooling";
        case 13: return "Centralized AC";
        case 14: return "Centralized Cooler";
        case 15: return "Heater";
        case 16: return "Furnace";
        case 17: return "Centralized Heating System";
        }
        return "";
    }
    public static String getDrinkWater(long data)
    {
        switch((int)data)
        {
            case 1: return "Tap water from treated source";
            case 2: return "Tap water from untreated source";
            case 3: return "Well";
            case 4: return "Hand Pump";
            case 5: return "Tubewell/Borehole";
            case 6: return "Spring";
            case 7: return "River/Canal";
            case 8: return "Tank/Pond/Lake";
            case 9: return "Packaged/bottled water";
            case 10: return "Machine";
            }
            return "";
    }
    public static String getLightSource(long data)
    {
        switch((int)data)
        {
        case 1: return "Solar Panels";
        case 2: return "Wind Turbines";
        case 3: return "Running Water";
        case 4: return "Portable Generator";
        case 5: return "Inverter";
        case 6: return "Standby Generator";
        case 7: return "Industrial Generator";
        case 8: return "Wired Electricity";
        case 9: return "Kerosene";
        case 10: return "Gas";
        case 11: return "Candle ";
        }
        return "";
    }
    public static String getPC(long data)
    {
        switch((int)data)
        {
        case 1: return "Laptop";
        case 2: return "Desktop";
        case 3: return "Tablet";
        case 4: return "Pocket PC";
        case 5: return "Utra Mobile PC";
        case 6: return "Laptop,Desktop";
        case 7: return "Laptop,Tablet";
        case 8: return "Laptop,PocketPC";
        case 9: return "Laptop,Ultra mobile PC";
        case 10: return "Desktop,Tablet";
        case 11: return "Desktop,PocketPC";
        case 12: return "Desktop,Ultra Mobile PC";
        case 13: return "Tablet,Ultra Mobile PC";
        case 14: return "Tablet,Pocket PC";
        case 15: return "Pocket PC,Ultra Mobile PC";
        case 16: return "Laptop,Desktop,Tablet";
        case 17: return "Laptop,Desktop,PocketPC";
        case 18: return "Laptop,Desktop,Ultr Mobile PC";
        case 19: return "Laptop,Tablet,PocketPC";
        case 20: return "Laptop,Tablet,Ultra Mobile PC";
        case 21: return "Laptop,PocketPC,Ultra Mobile PC";
        case 22: return "Desktop,Tablet,PocketPC";
        case 23: return "Desktop,Tablet,Ultra Mobile PC";
        case 24: return "Desktop,PocketPC,Ultra Mobile PC";
        case 25: return "Tablet,PocketPC,Ultra Mobile PC";
        case 26: return "Laptop,Desktop,Tablet,PocketPC";
        case 27: return "Laptop,Desktop,Tablet,Ultra Mobile PC";
        case 28: return "Laptop,Tablet,PocketPC,Ultra Mobile PC,";
        case 29: return "Laptop,Desktop,PocketPC,Ultra Mobile PC";
        case 30: return "Desktop,Tablet,PocketPC,Ultra Mobile PC";
        case 31: return "Laptop,Desktop,Tablet,PocketPC,Ultra Mobile PC";
        }
        return "";
    }
    public static String getTeleBroad(long data)
    {
        switch((int)data)
        {
        case 1: return "Telephone";
        case 2: return "DSL Broadband";
        case 3: return "Cable Modem";
        case 4: return "Fiber";
        case 5: return "Wireless";
        case 6: return "Satellite";
        case 7: return "Broadband over Power Lines";
        case 8: return "Telephone, DSL";
        case 9: return "Telephone,  Cable Modem";
        case 10: return "Telephone, Fiber";
        case 11: return "Telephone, Wireless";
        case 12: return "Telephone,Satellite";
        case 13: return "Telephone,Broadband over Power Line";
        }
        return "";
    }
    public static String getMobile(long data)
    {
        switch((int)data)
        {
        case 1: return "Feature Phone";
        case 2: return "Smart Phone";
        case 3: return "Telephone";
        case 4: return "Feature Phone, Telephone";
        case 5: return "Feature Phone, Smart Phone";
        case 6: return "Smart Phone,Telephone";
        case 7: return "Feature Phone, Smart Phone, Telephone";
        }
        return "";
    }
    public static String getBicycle(long data)
    {
        switch((int)data)
        {
        case 1: return "Mountain Bike";
        case 2: return "Hybrid/Comfort Bike";
        case 3: return " Road Bike";
        case 4: return "Electric Bike";
        case 5: return "Gravel Bike";
        case 6: return "Touring Bike";
        case 7: return "Mountain Bike,Hybrid/Comfort Bike";
        case 8: return "Mountain Bike, Road Bike";
        case 9: return "Mountain Bike,Electric Bike";
        case 10: return "Mountain Bike,Gravel Bike";
        case 11: return "Mountain Bike,Touring Bike";
        case 12: return "Hybrid/Comfort Bike,Road Bike";
        case 13: return "Hybrid/Comfort Bike,Electric Bike";
        case 14: return "Hybrid/Comfort Bike,Gravel Bike";
        case 15: return "Hybrid/Comfort Bike, Touring Bike";
        case 16: return " Road Bike,Electric Bike";
        case 17: return " Road Bike,Gravel Bike";
        case 18: return " Road Bike,Touring Bike";
        case 19: return "Electric Bike,Gravel Bike";
        case 20: return "Electric Bike,Touring Bike";
        case 21: return "Gravel Bike,Touring Bike";
        }
        return "";
    }
}
