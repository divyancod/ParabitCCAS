package parabitmodel;

import java.util.Map;
import parabitccasbharat.ParabitDBC;

public class PbtHLModel{

  private String empEnumNo;
  private long hlSNo;
  private long hhSNo;
  private long ucid;
  private long fsNo;
  private String stUt;
  private String dist;
  private String tehsil;
  private String townVillage;
  private String wardNo;
  private String hNoAdd;
  private String pinCode;
  private long owspOfHouse;
  private long typeOfHouse;
  private long roof;
  private long floor;
  private long wall;
  private String dwellingRoom;
  private String fndYrOfHouse;
  private String cndtOfHouse;
  private String useOfHouse;
  private String plotArea;
  private String builtUpArea;
  private String noOfTrees;
  private String noOfProtTrees;
  private String typeOfDomAnimalWithNo;
  private String typeOfPetAnimalWithNo;
  private String latiLongi;
  private String ownerName;
  private String ownerPhnNo;
  private String noMarrCoup;
  private long mainSrcDrWater;
  private long mainSrcLight;
  private long altSrcOfLight;
  private long accessOfL;
  private long typeOfL;
  private String drainageSys;
  private String wtrHarv;
  private long bathFact;
  private String swimmingPool;
  private long kitchen;
  private long cookFuel;
  private String radio;
  private String fm;
  private long tv;
  private long tvSig;
  private String refrigerator;
  private long coolHeatFact;
  private long pc;
  private long teleBroadBand;
  private long mob;
  private long bicycle;
  private long r2Wheel;
  private long r4Wheel;
  private long tNoCommVeh;
  private String parkingFact;
  private String lift;
  private String escalator;
  private String helipad;
  private String genDiss;
  private String firstAidKit;
  private String hInsu;
  private String lInsu;
  private String gInsu;
  private String nHospDist;
  private long deathin10Years;
  private String reasonOfDeath;
  private String deathAgeGroup;
  private String courtCase;
  private String finCase;
  private String foreignDispute;
  private String smartSecuritySystem;
  private String cctvipAdress;
  private long fireExtinguisher;
  private long fireAlarm;
  private long privateSecurityGuard;
  private long privateLicenseArms;
  private long burglarAlarm;
  private String expectation;
  private java.sql.Date fillDate;
  private java.sql.Timestamp timeIn;
  private java.sql.Timestamp timeOut;
  private String note;
  private String comment;
  private String status;


  public String getEmpEnumNo() {
    return empEnumNo;
  }

  public void setEmpEnumNo(String empEnumNo) {
    this.empEnumNo = empEnumNo;
  }


  public long getHlSNo() {
    return hlSNo;
  }

  public void setHlSNo(long hlSNo) {
    this.hlSNo = hlSNo;
  }


  public long getHhSNo() {
    return hhSNo;
  }

  public void setHhSNo(long hhSNo) {
    this.hhSNo = hhSNo;
  }


  public long getUcid() {
    return ucid;
  }

  public void setUcid(long ucid) {
    this.ucid = ucid;
  }


  public long getFsNo() {
    return fsNo;
  }

  public void setFsNo(long fsNo) {
    this.fsNo = fsNo;
  }


  public String getStUt() {
    return stUt;
  }

  public void setStUt(String stUt) {
    this.stUt = stUt;
  }


  public String getDist() {
    return dist;
  }

  public void setDist(String dist) {
    this.dist = dist;
  }


  public String getTehsil() {
    return tehsil;
  }

  public void setTehsil(String tehsil) {
    this.tehsil = tehsil;
  }


  public String getTownVillage() {
    return townVillage;
  }

  public void setTownVillage(String townVillage) {
    this.townVillage = townVillage;
  }


  public String getWardNo() {
    return wardNo;
  }

  public void setWardNo(String wardNo) {
    this.wardNo = wardNo;
  }


  public String getHNoAdd() {
    return hNoAdd;
  }

  public void setHNoAdd(String hNoAdd) {
    this.hNoAdd = hNoAdd;
  }


  public String getPinCode() {
    return pinCode;
  }

  public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
  }


  public long getOwspOfHouse() {
    return owspOfHouse;
  }

  public void setOwspOfHouse(long owspOfHouse) {
    this.owspOfHouse = owspOfHouse;
  }


  public long getTypeOfHouse() {
    return typeOfHouse;
  }

  public void setTypeOfHouse(long typeOfHouse) {
    this.typeOfHouse = typeOfHouse;
  }


  public long getRoof() {
    return roof;
  }

  public void setRoof(long roof) {
    this.roof = roof;
  }


  public long getFloor() {
    return floor;
  }

  public void setFloor(long floor) {
    this.floor = floor;
  }


  public long getWall() {
    return wall;
  }

  public void setWall(long wall) {
    this.wall = wall;
  }


  public String getDwellingRoom() {
    return dwellingRoom;
  }

  public void setDwellingRoom(String dwellingRoom) {
    this.dwellingRoom = dwellingRoom;
  }


  public String getFndYrOfHouse() {
    return fndYrOfHouse;
  }

  public void setFndYrOfHouse(String fndYrOfHouse) {
    this.fndYrOfHouse = fndYrOfHouse;
  }


  public String getCndtOfHouse() {
    return cndtOfHouse;
  }

  public void setCndtOfHouse(String cndtOfHouse) {
    this.cndtOfHouse = cndtOfHouse;
  }


  public String getUseOfHouse() {
    return useOfHouse;
  }

  public void setUseOfHouse(String useOfHouse) {
    this.useOfHouse = useOfHouse;
  }


  public String getPlotArea() {
    return plotArea;
  }

  public void setPlotArea(String plotArea) {
    this.plotArea = plotArea;
  }


  public String getBuiltUpArea() {
    return builtUpArea;
  }

  public void setBuiltUpArea(String builtUpArea) {
    this.builtUpArea = builtUpArea;
  }


  public String getNoOfTrees() {
    return noOfTrees;
  }

  public void setNoOfTrees(String noOfTrees) {
    this.noOfTrees = noOfTrees;
  }


  public String getNoOfProtTrees() {
    return noOfProtTrees;
  }

  public void setNoOfProtTrees(String noOfProtTrees) {
    this.noOfProtTrees = noOfProtTrees;
  }


  public String getTypeOfDomAnimalWithNo() {
    return typeOfDomAnimalWithNo;
  }

  public void setTypeOfDomAnimalWithNo(String typeOfDomAnimalWithNo) {
    this.typeOfDomAnimalWithNo = typeOfDomAnimalWithNo;
  }


  public String getTypeOfPetAnimalWithNo() {
    return typeOfPetAnimalWithNo;
  }

  public void setTypeOfPetAnimalWithNo(String typeOfPetAnimalWithNo) {
    this.typeOfPetAnimalWithNo = typeOfPetAnimalWithNo;
  }


  public String getLatiLongi() {
    return latiLongi;
  }

  public void setLatiLongi(String latiLongi) {
    this.latiLongi = latiLongi;
  }


  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }


  public String getOwnerPhnNo() {
    return ownerPhnNo;
  }

  public void setOwnerPhnNo(String ownerPhnNo) {
    this.ownerPhnNo = ownerPhnNo;
  }


  public String getNoMarrCoup() {
    return noMarrCoup;
  }

  public void setNoMarrCoup(String noMarrCoup) {
    this.noMarrCoup = noMarrCoup;
  }


  public long getMainSrcDrWater() {
    return mainSrcDrWater;
  }

  public void setMainSrcDrWater(long mainSrcDrWater) {
    this.mainSrcDrWater = mainSrcDrWater;
  }


  public long getMainSrcLight() {
    return mainSrcLight;
  }

  public void setMainSrcLight(long mainSrcLight) {
    this.mainSrcLight = mainSrcLight;
  }


  public long getAltSrcOfLight() {
    return altSrcOfLight;
  }

  public void setAltSrcOfLight(long altSrcOfLight) {
    this.altSrcOfLight = altSrcOfLight;
  }


  public long getAccessOfL() {
    return accessOfL;
  }

  public void setAccessOfL(long accessOfL) {
    this.accessOfL = accessOfL;
  }


  public long getTypeOfL() {
    return typeOfL;
  }

  public void setTypeOfL(long typeOfL) {
    this.typeOfL = typeOfL;
  }


  public String getDrainageSys() {
    return drainageSys;
  }

  public void setDrainageSys(String drainageSys) {
    this.drainageSys = drainageSys;
  }


  public String getWtrHarv() {
    return wtrHarv;
  }

  public void setWtrHarv(String wtrHarv) {
    this.wtrHarv = wtrHarv;
  }


  public long getBathFact() {
    return bathFact;
  }

  public void setBathFact(long bathFact) {
    this.bathFact = bathFact;
  }


  public String getSwimmingPool() {
    return swimmingPool;
  }

  public void setSwimmingPool(String swimmingPool) {
    this.swimmingPool = swimmingPool;
  }


  public long getKitchen() {
    return kitchen;
  }

  public void setKitchen(long kitchen) {
    this.kitchen = kitchen;
  }


  public long getCookFuel() {
    return cookFuel;
  }

  public void setCookFuel(long cookFuel) {
    this.cookFuel = cookFuel;
  }


  public String getRadio() {
    return radio;
  }

  public void setRadio(String radio) {
    this.radio = radio;
  }


  public String getFm() {
    return fm;
  }

  public void setFm(String fm) {
    this.fm = fm;
  }


  public long getTv() {
    return tv;
  }

  public void setTv(long tv) {
    this.tv = tv;
  }


  public long getTvSig() {
    return tvSig;
  }

  public void setTvSig(long tvSig) {
    this.tvSig = tvSig;
  }


  public String getRefrigerator() {
    return refrigerator;
  }

  public void setRefrigerator(String refrigerator) {
    this.refrigerator = refrigerator;
  }


  public long getCoolHeatFact() {
    return coolHeatFact;
  }

  public void setCoolHeatFact(long coolHeatFact) {
    this.coolHeatFact = coolHeatFact;
  }


  public long getPc() {
    return pc;
  }

  public void setPc(long pc) {
    this.pc = pc;
  }


  public long getTeleBroadBand() {
    return teleBroadBand;
  }

  public void setTeleBroadBand(long teleBroadBand) {
    this.teleBroadBand = teleBroadBand;
  }


  public long getMob() {
    return mob;
  }

  public void setMob(long mob) {
    this.mob = mob;
  }


  public long getBicycle() {
    return bicycle;
  }

  public void setBicycle(long bicycle) {
    this.bicycle = bicycle;
  }


  public long getR2Wheel() {
    return r2Wheel;
  }

  public void setR2Wheel(long r2Wheel) {
    this.r2Wheel = r2Wheel;
  }


  public long getR4Wheel() {
    return r4Wheel;
  }

  public void setR4Wheel(long r4Wheel) {
    this.r4Wheel = r4Wheel;
  }


  public long getTNoCommVeh() {
    return tNoCommVeh;
  }

  public void setTNoCommVeh(long tNoCommVeh) {
    this.tNoCommVeh = tNoCommVeh;
  }


  public String getParkingFact() {
    return parkingFact;
  }

  public void setParkingFact(String parkingFact) {
    this.parkingFact = parkingFact;
  }


  public String getLift() {
    return lift;
  }

  public void setLift(String lift) {
    this.lift = lift;
  }


  public String getEscalator() {
    return escalator;
  }

  public void setEscalator(String escalator) {
    this.escalator = escalator;
  }


  public String getHelipad() {
    return helipad;
  }

  public void setHelipad(String helipad) {
    this.helipad = helipad;
  }


  public String getGenDiss() {
    return genDiss;
  }

  public void setGenDiss(String genDiss) {
    this.genDiss = genDiss;
  }


  public String getFirstAidKit() {
    return firstAidKit;
  }

  public void setFirstAidKit(String firstAidKit) {
    this.firstAidKit = firstAidKit;
  }


  public String getHInsu() {
    return hInsu;
  }

  public void setHInsu(String hInsu) {
    this.hInsu = hInsu;
  }


  public String getLInsu() {
    return lInsu;
  }

  public void setLInsu(String lInsu) {
    this.lInsu = lInsu;
  }


  public String getGInsu() {
    return gInsu;
  }

  public void setGInsu(String gInsu) {
    this.gInsu = gInsu;
  }


  public String getNHospDist() {
    return nHospDist;
  }

  public void setNHospDist(String nHospDist) {
    this.nHospDist = nHospDist;
  }


  public long getDeathin10Years() {
    return deathin10Years;
  }

  public void setDeathin10Years(long deathin10Years) {
    this.deathin10Years = deathin10Years;
  }


  public String getReasonOfDeath() {
    return reasonOfDeath;
  }

  public void setReasonOfDeath(String reasonOfDeath) {
    this.reasonOfDeath = reasonOfDeath;
  }


  public String getDeathAgeGroup() {
    return deathAgeGroup;
  }

  public void setDeathAgeGroup(String deathAgeGroup) {
    this.deathAgeGroup = deathAgeGroup;
  }


  public String getCourtCase() {
    return courtCase;
  }

  public void setCourtCase(String courtCase) {
    this.courtCase = courtCase;
  }


  public String getFinCase() {
    return finCase;
  }

  public void setFinCase(String finCase) {
    this.finCase = finCase;
  }


  public String getForeignDispute() {
    return foreignDispute;
  }

  public void setForeignDispute(String foreignDispute) {
    this.foreignDispute = foreignDispute;
  }


  public String getSmartSecuritySystem() {
    return smartSecuritySystem;
  }

  public void setSmartSecuritySystem(String smartSecuritySystem) {
    this.smartSecuritySystem = smartSecuritySystem;
  }


  public String getCctvipAdress() {
    return cctvipAdress;
  }

  public void setCctvipAdress(String cctvipAdress) {
    this.cctvipAdress = cctvipAdress;
  }


  public long getFireExtinguisher() {
    return fireExtinguisher;
  }

  public void setFireExtinguisher(long fireExtinguisher) {
    this.fireExtinguisher = fireExtinguisher;
  }


  public long getFireAlarm() {
    return fireAlarm;
  }

  public void setFireAlarm(long fireAlarm) {
    this.fireAlarm = fireAlarm;
  }


  public long getPrivateSecurityGuard() {
    return privateSecurityGuard;
  }

  public void setPrivateSecurityGuard(long privateSecurityGuard) {
    this.privateSecurityGuard = privateSecurityGuard;
  }


  public long getPrivateLicenseArms() {
    return privateLicenseArms;
  }

  public void setPrivateLicenseArms(long privateLicenseArms) {
    this.privateLicenseArms = privateLicenseArms;
  }


  public long getBurglarAlarm() {
    return burglarAlarm;
  }

  public void setBurglarAlarm(long burglarAlarm) {
    this.burglarAlarm = burglarAlarm;
  }


  public String getExpectation() {
    return expectation;
  }

  public void setExpectation(String expectation) {
    this.expectation = expectation;
  }


  public java.sql.Date getFillDate() {
    return fillDate;
  }

  public void setFillDate(java.sql.Date fillDate) {
    this.fillDate = fillDate;
  }


  public java.sql.Timestamp getTimeIn() {
    return timeIn;
  }

  public void setTimeIn(java.sql.Timestamp timeIn) {
    this.timeIn = timeIn;
  }


  public java.sql.Timestamp getTimeOut() {
    return timeOut;
  }

  public void setTimeOut(java.sql.Timestamp timeOut) {
    this.timeOut = timeOut;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  public void firstInsert()
  {
      String query="insert into pbtcensus_houselisting (Empenumno,HL_Sno,UseOfHouse,TypeOfHouse,timein,status) values ('"+empEnumNo+"',null,'1','1',curtime(),'9')";
      ParabitDBC db=new ParabitDBC();
      try
      {
          db.stm.execute(query);
      }catch(Exception e)
      {
          e.printStackTrace();
      }
  }
  public void getCurrent()
  {
      String query="select * from pbtcensus_houselisting where status='9'";
      ParabitDBC db=new ParabitDBC();
      try
      {
          db.rs1=db.stm.executeQuery(query);
          if(db.rs1.next())
          {
              this.hlSNo=db.rs1.getLong("HL_Sno");
          }
      }catch(Exception e)
      {
          e.printStackTrace();
      }
  }
  public void updateQuery(Map<Object,Object> data)
  {
      ParabitDBC db=new ParabitDBC();
        String query="update pbtcensus_houselisting set note=''";
        for (Map.Entry<Object, Object> entry : data.entrySet()){
            if(entry.getValue()!=null)
            query=query+","+entry.getKey()+"='"+entry.getValue()+"'";
        }
        query=query+" where hl_sno='"+hlSNo+"'";
         System.err.println(""+query);
         try
         {
             db.stm.execute(query);
         }catch(Exception e)
         {
             e.printStackTrace();
         }
  }

}
