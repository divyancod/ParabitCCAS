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
}
