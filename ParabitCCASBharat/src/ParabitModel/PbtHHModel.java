package ParabitModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import parabitccasbharat.ParabitDBC;


public class PbtHHModel{

  private long hhSNo;
  private long hlSNo;
  private long ucid;
  private long fsNo;
  private String stUt;
  private String dist;
  private String tehsil;
  private String townVillage;
  private String wardNo;
  private String hNoAdd;
  private String pinCode;
  private String empEnumNo;
  private String rCardNo;
  private String rCardType;
  private String uid;
  private String gConsumerNo;
  private String drivLicNo;
  private String armsUiNo;
  private String birthCertNo;
  private String marrCertNo;
  private String policeVerNo;
  private String sssmid;
  private String name;
  private String relToHead;
  private String headUid;
  private String headRegMobNo;
  private String mobNo;
  private String altPhoneNo;
  private String email;
  private String gender;
  private java.sql.Date dob;
  private long age;
  private long wt;
  private double ht;
  private String veg;
  private String homeFood;
  private String outsideFood;
  private String sleepHrs;
  private String healthCheckup;
  private String addiction;
  private double bmi;
  private String stemCellId;
  private String bGroup;
  private String vid;
  private String passport;
  private String panCardNo;
  private String ifsc;
  private String bankAccNo;
  private String netBank;
  private String mobBank;
  private String pensionId;
  private String religion;
  private String community;
  private String category;
  private String cast;
  private String marStatus;
  private String aproMarriageAge;
  private String pwd;
  private String pwdid;
  private String mTongue;
  private String rwLang;
  private String homeLang;
  private String litStatus;
  private String cEduStatus;
  private String cInstNmCity;
  private String cInstType;
  private String techDeg;
  private String nonTechDeg;
  private String nccnss;
  private String jobSeek;
  private String cWorkStat;
  private long workCategory;
  private long workingSector;
  private long natureOfWork;
  private long icsNo;
  private String occupation;
  private String workExp;
  private String specDescription;
  private String specExp;
  private String profLicNo;
  private String busiRegNo;
  private long income;
  private String itr;
  private double distFrmWorkPlace;
  private String modOfTravel;
  private String nri;
  private String foreignAdd;
  private String birthPlaceWithStateCountry;
  private String pmtStUt;
  private String pmtDist;
  private String pmtTehsil;
  private String pmtTownVillage;
  private String pmtWardNo;
  private String pmtHNoAdd;
  private String pmtPinCode;
  private String rsnOfMig;
  private String durOfMig;
  private String chdnSurv;
  private String chdnEvenBorn;
  private String noOfChdnAliveLastYr;
  private String chronicDisease;
  private String sport;
  private String yoga;
  private String spiritual;
  private String meditation;
  private long ratYourHealth;
  private java.sql.Date fillDate;
  private java.sql.Time timeIn;
  private java.sql.Time timeOut;
  private String note;
  private String comment;
  private String status;


  public long getHhSNo() {
    return hhSNo;
  }

  public void setHhSNo(long hhSNo) {
    this.hhSNo = hhSNo;
  }


  public long getHlSNo() {
    return hlSNo;
  }

  public void setHlSNo(long hlSNo) {
    this.hlSNo = hlSNo;
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


  public String getEmpEnumNo() {
    return empEnumNo;
  }

  public void setEmpEnumNo(String empEnumNo) {
    this.empEnumNo = empEnumNo;
  }


  public String getRCardNo() {
    return rCardNo;
  }

  public void setRCardNo(String rCardNo) {
    this.rCardNo = rCardNo;
  }


  public String getRCardType() {
    return rCardType;
  }

  public void setRCardType(String rCardType) {
    this.rCardType = rCardType;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getGConsumerNo() {
    return gConsumerNo;
  }

  public void setGConsumerNo(String gConsumerNo) {
    this.gConsumerNo = gConsumerNo;
  }


  public String getDrivLicNo() {
    return drivLicNo;
  }

  public void setDrivLicNo(String drivLicNo) {
    this.drivLicNo = drivLicNo;
  }


  public String getArmsUiNo() {
    return armsUiNo;
  }

  public void setArmsUiNo(String armsUiNo) {
    this.armsUiNo = armsUiNo;
  }


  public String getBirthCertNo() {
    return birthCertNo;
  }

  public void setBirthCertNo(String birthCertNo) {
    this.birthCertNo = birthCertNo;
  }


  public String getMarrCertNo() {
    return marrCertNo;
  }

  public void setMarrCertNo(String marrCertNo) {
    this.marrCertNo = marrCertNo;
  }


  public String getPoliceVerNo() {
    return policeVerNo;
  }

  public void setPoliceVerNo(String policeVerNo) {
    this.policeVerNo = policeVerNo;
  }


  public String getSssmid() {
    return sssmid;
  }

  public void setSssmid(String sssmid) {
    this.sssmid = sssmid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getRelToHead() {
    return relToHead;
  }

  public void setRelToHead(String relToHead) {
    this.relToHead = relToHead;
  }


  public String getHeadUid() {
    return headUid;
  }

  public void setHeadUid(String headUid) {
    this.headUid = headUid;
  }


  public String getHeadRegMobNo() {
    return headRegMobNo;
  }

  public void setHeadRegMobNo(String headRegMobNo) {
    this.headRegMobNo = headRegMobNo;
  }


  public String getMobNo() {
    return mobNo;
  }

  public void setMobNo(String mobNo) {
    this.mobNo = mobNo;
  }


  public String getAltPhoneNo() {
    return altPhoneNo;
  }

  public void setAltPhoneNo(String altPhoneNo) {
    this.altPhoneNo = altPhoneNo;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getDob() {
    return dob;
  }

  public void setDob(java.sql.Date dob) {
    this.dob = dob;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public long getWt() {
    return wt;
  }

  public void setWt(long wt) {
    this.wt = wt;
  }


  public double getHt() {
    return ht;
  }

  public void setHt(double ht) {
    this.ht = ht;
  }


  public String getVeg() {
    return veg;
  }

  public void setVeg(String veg) {
    this.veg = veg;
  }


  public String getHomeFood() {
    return homeFood;
  }

  public void setHomeFood(String homeFood) {
    this.homeFood = homeFood;
  }


  public String getOutsideFood() {
    return outsideFood;
  }

  public void setOutsideFood(String outsideFood) {
    this.outsideFood = outsideFood;
  }


  public String getSleepHrs() {
    return sleepHrs;
  }

  public void setSleepHrs(String sleepHrs) {
    this.sleepHrs = sleepHrs;
  }


  public String getHealthCheckup() {
    return healthCheckup;
  }

  public void setHealthCheckup(String healthCheckup) {
    this.healthCheckup = healthCheckup;
  }


  public String getAddiction() {
    return addiction;
  }

  public void setAddiction(String addiction) {
    this.addiction = addiction;
  }


  public double getBmi() {
    return bmi;
  }

  public void setBmi(double bmi) {
    this.bmi = bmi;
  }


  public String getStemCellId() {
    return stemCellId;
  }

  public void setStemCellId(String stemCellId) {
    this.stemCellId = stemCellId;
  }


  public String getBGroup() {
    return bGroup;
  }

  public void setBGroup(String bGroup) {
    this.bGroup = bGroup;
  }


  public String getVid() {
    return vid;
  }

  public void setVid(String vid) {
    this.vid = vid;
  }


  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }


  public String getPanCardNo() {
    return panCardNo;
  }

  public void setPanCardNo(String panCardNo) {
    this.panCardNo = panCardNo;
  }


  public String getIfsc() {
    return ifsc;
  }

  public void setIfsc(String ifsc) {
    this.ifsc = ifsc;
  }


  public String getBankAccNo() {
    return bankAccNo;
  }

  public void setBankAccNo(String bankAccNo) {
    this.bankAccNo = bankAccNo;
  }


  public String getNetBank() {
    return netBank;
  }

  public void setNetBank(String netBank) {
    this.netBank = netBank;
  }


  public String getMobBank() {
    return mobBank;
  }

  public void setMobBank(String mobBank) {
    this.mobBank = mobBank;
  }


  public String getPensionId() {
    return pensionId;
  }

  public void setPensionId(String pensionId) {
    this.pensionId = pensionId;
  }


  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }


  public String getCommunity() {
    return community;
  }

  public void setCommunity(String community) {
    this.community = community;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public String getCast() {
    return cast;
  }

  public void setCast(String cast) {
    this.cast = cast;
  }


  public String getMarStatus() {
    return marStatus;
  }

  public void setMarStatus(String marStatus) {
    this.marStatus = marStatus;
  }


  public String getAproMarriageAge() {
    return aproMarriageAge;
  }

  public void setAproMarriageAge(String aproMarriageAge) {
    this.aproMarriageAge = aproMarriageAge;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public String getPwdid() {
    return pwdid;
  }

  public void setPwdid(String pwdid) {
    this.pwdid = pwdid;
  }


  public String getMTongue() {
    return mTongue;
  }

  public void setMTongue(String mTongue) {
    this.mTongue = mTongue;
  }


  public String getRwLang() {
    return rwLang;
  }

  public void setRwLang(String rwLang) {
    this.rwLang = rwLang;
  }


  public String getHomeLang() {
    return homeLang;
  }

  public void setHomeLang(String homeLang) {
    this.homeLang = homeLang;
  }


  public String getLitStatus() {
    return litStatus;
  }

  public void setLitStatus(String litStatus) {
    this.litStatus = litStatus;
  }


  public String getCEduStatus() {
    return cEduStatus;
  }

  public void setCEduStatus(String cEduStatus) {
    this.cEduStatus = cEduStatus;
  }


  public String getCInstNmCity() {
    return cInstNmCity;
  }

  public void setCInstNmCity(String cInstNmCity) {
    this.cInstNmCity = cInstNmCity;
  }


  public String getCInstType() {
    return cInstType;
  }

  public void setCInstType(String cInstType) {
    this.cInstType = cInstType;
  }


  public String getTechDeg() {
    return techDeg;
  }

  public void setTechDeg(String techDeg) {
    this.techDeg = techDeg;
  }


  public String getNonTechDeg() {
    return nonTechDeg;
  }

  public void setNonTechDeg(String nonTechDeg) {
    this.nonTechDeg = nonTechDeg;
  }


  public String getNccnss() {
    return nccnss;
  }

  public void setNccnss(String nccnss) {
    this.nccnss = nccnss;
  }


  public String getJobSeek() {
    return jobSeek;
  }

  public void setJobSeek(String jobSeek) {
    this.jobSeek = jobSeek;
  }


  public String getCWorkStat() {
    return cWorkStat;
  }

  public void setCWorkStat(String cWorkStat) {
    this.cWorkStat = cWorkStat;
  }


  public long getWorkCategory() {
    return workCategory;
  }

  public void setWorkCategory(long workCategory) {
    this.workCategory = workCategory;
  }


  public long getWorkingSector() {
    return workingSector;
  }

  public void setWorkingSector(long workingSector) {
    this.workingSector = workingSector;
  }


  public long getNatureOfWork() {
    return natureOfWork;
  }

  public void setNatureOfWork(long natureOfWork) {
    this.natureOfWork = natureOfWork;
  }


  public long getIcsNo() {
    return icsNo;
  }

  public void setIcsNo(long icsNo) {
    this.icsNo = icsNo;
  }


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }


  public String getWorkExp() {
    return workExp;
  }

  public void setWorkExp(String workExp) {
    this.workExp = workExp;
  }


  public String getSpecDescription() {
    return specDescription;
  }

  public void setSpecDescription(String specDescription) {
    this.specDescription = specDescription;
  }


  public String getSpecExp() {
    return specExp;
  }

  public void setSpecExp(String specExp) {
    this.specExp = specExp;
  }


  public String getProfLicNo() {
    return profLicNo;
  }

  public void setProfLicNo(String profLicNo) {
    this.profLicNo = profLicNo;
  }


  public String getBusiRegNo() {
    return busiRegNo;
  }

  public void setBusiRegNo(String busiRegNo) {
    this.busiRegNo = busiRegNo;
  }


  public long getIncome() {
    return income;
  }

  public void setIncome(long income) {
    this.income = income;
  }


  public String getItr() {
    return itr;
  }

  public void setItr(String itr) {
    this.itr = itr;
  }


  public double getDistFrmWorkPlace() {
    return distFrmWorkPlace;
  }

  public void setDistFrmWorkPlace(double distFrmWorkPlace) {
    this.distFrmWorkPlace = distFrmWorkPlace;
  }


  public String getModOfTravel() {
    return modOfTravel;
  }

  public void setModOfTravel(String modOfTravel) {
    this.modOfTravel = modOfTravel;
  }


  public String getNri() {
    return nri;
  }

  public void setNri(String nri) {
    this.nri = nri;
  }


  public String getForeignAdd() {
    return foreignAdd;
  }

  public void setForeignAdd(String foreignAdd) {
    this.foreignAdd = foreignAdd;
  }


  public String getBirthPlaceWithStateCountry() {
    return birthPlaceWithStateCountry;
  }

  public void setBirthPlaceWithStateCountry(String birthPlaceWithStateCountry) {
    this.birthPlaceWithStateCountry = birthPlaceWithStateCountry;
  }


  public String getPmtStUt() {
    return pmtStUt;
  }

  public void setPmtStUt(String pmtStUt) {
    this.pmtStUt = pmtStUt;
  }


  public String getPmtDist() {
    return pmtDist;
  }

  public void setPmtDist(String pmtDist) {
    this.pmtDist = pmtDist;
  }


  public String getPmtTehsil() {
    return pmtTehsil;
  }

  public void setPmtTehsil(String pmtTehsil) {
    this.pmtTehsil = pmtTehsil;
  }


  public String getPmtTownVillage() {
    return pmtTownVillage;
  }

  public void setPmtTownVillage(String pmtTownVillage) {
    this.pmtTownVillage = pmtTownVillage;
  }


  public String getPmtWardNo() {
    return pmtWardNo;
  }

  public void setPmtWardNo(String pmtWardNo) {
    this.pmtWardNo = pmtWardNo;
  }


  public String getPmtHNoAdd() {
    return pmtHNoAdd;
  }

  public void setPmtHNoAdd(String pmtHNoAdd) {
    this.pmtHNoAdd = pmtHNoAdd;
  }


  public String getPmtPinCode() {
    return pmtPinCode;
  }

  public void setPmtPinCode(String pmtPinCode) {
    this.pmtPinCode = pmtPinCode;
  }


  public String getRsnOfMig() {
    return rsnOfMig;
  }

  public void setRsnOfMig(String rsnOfMig) {
    this.rsnOfMig = rsnOfMig;
  }


  public String getDurOfMig() {
    return durOfMig;
  }

  public void setDurOfMig(String durOfMig) {
    this.durOfMig = durOfMig;
  }


  public String getChdnSurv() {
    return chdnSurv;
  }

  public void setChdnSurv(String chdnSurv) {
    this.chdnSurv = chdnSurv;
  }


  public String getChdnEvenBorn() {
    return chdnEvenBorn;
  }

  public void setChdnEvenBorn(String chdnEvenBorn) {
    this.chdnEvenBorn = chdnEvenBorn;
  }


  public String getNoOfChdnAliveLastYr() {
    return noOfChdnAliveLastYr;
  }

  public void setNoOfChdnAliveLastYr(String noOfChdnAliveLastYr) {
    this.noOfChdnAliveLastYr = noOfChdnAliveLastYr;
  }


  public String getChronicDisease() {
    return chronicDisease;
  }

  public void setChronicDisease(String chronicDisease) {
    this.chronicDisease = chronicDisease;
  }


  public String getSport() {
    return sport;
  }

  public void setSport(String sport) {
    this.sport = sport;
  }


  public String getYoga() {
    return yoga;
  }

  public void setYoga(String yoga) {
    this.yoga = yoga;
  }


  public String getSpiritual() {
    return spiritual;
  }

  public void setSpiritual(String spiritual) {
    this.spiritual = spiritual;
  }


  public String getMeditation() {
    return meditation;
  }

  public void setMeditation(String meditation) {
    this.meditation = meditation;
  }


  public long getRatYourHealth() {
    return ratYourHealth;
  }

  public void setRatYourHealth(long ratYourHealth) {
    this.ratYourHealth = ratYourHealth;
  }


  public java.sql.Date getFillDate() {
    return fillDate;
  }

  public void setFillDate(java.sql.Date fillDate) {
    this.fillDate = fillDate;
  }


  public java.sql.Time getTimeIn() {
    return timeIn;
  }

  public void setTimeIn(java.sql.Time timeIn) {
    this.timeIn = timeIn;
  }


  public java.sql.Time getTimeOut() {
    return timeOut;
  }

  public void setTimeOut(java.sql.Time timeOut) {
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
     public void fetchAllData(String adhrno)
    {
        ParabitDBC db=new ParabitDBC("util");
        String query="select * from pbtaadhar as aadhar\n" +
                    "    LEFT JOIN pbt_itr as itr on aadhar.ANo = itr.ano\n" +
                    "    LEFT JOIN pbtdisability disabity on aadhar.ANo = disabity.Ano\n" +
                    "    LEFT JOIN pbtpass passport on aadhar.ANo = passport.ANo\n" +
                    "    LEFT JOIN pbtpension pension on aadhar.ANo = pension.ANo\n" +
                    "    LEFT JOIN pbt_police_ver police ON aadhar.ANo = police.AadNo\n" +
                    "    LEFT JOIN pbt_rationcarddata ration ON aadhar.ANo = ration.AdhrNo\n" +
                    "    LEFT JOIN pbtarmslicense arms on aadhar.Ano = arms.AadhNo\n" +
                    "    LEFT JOIN pbtdl dl on aadhar.ANo = dl.AdhrNo\n" +
                    "    LEFT JOIN pbtgas gas on aadhar.ANo = gas.AadNo\n" +
                    "    LEFT JOIN pbtmarriage marriage on (aadhar.ANo = marriage.HbAadNo or aadhar.ANo = marriage.WfAadNo)\n" +
                    "    LEFT JOIN pbtpan pan on aadhar.ANo = pan.AdhrNO\n" +
                    "where aadhar.ano='"+adhrno+"'";
        try
        {
            db.rs1=db.stm.executeQuery(query);
            if(db.rs1.next())
            {
                
                stUt = db.rs1.getString("aadhar.State");
                dist = db.rs1.getString("district");
                tehsil = db.rs1.getString("tehsil");
                townVillage = db.rs1.getString("aadhar.vtc");
                wardNo = db.rs1.getString("SRL");
                hNoAdd = db.rs1.getString("HNo");
                pinCode = db.rs1.getString("pin");
                rCardNo = db.rs1.getString("RtnID");
                rCardType = db.rs1.getString("TypeOfCard");
                System.out.println(""+db.rs1.getString("typeofcard"));
                uid = db.rs1.getString("aadhar.ANo");
                gConsumerNo = db.rs1.getString("CosNo");
                drivLicNo = db.rs1.getString("DLNumber");
                armsUiNo = db.rs1.getString("LNo");
                marrCertNo = db.rs1.getString("MrgCNo");
                policeVerNo = db.rs1.getString("PolVerNu");
                name = db.rs1.getString("FstName")+" "+db.rs1.getString("midname")+" "+db.rs1.getString("lstname");
                mobNo = db.rs1.getString("MobNo");
                email = db.rs1.getString("Email");
                gender = db.rs1.getString("Gender");
                dob = db.rs1.getDate("DOB");
                passport = db.rs1.getString("PassNo");
                panCardNo = db.rs1.getString("pan.PanNO");
                pensionId = db.rs1.getString("PIDNo");
                pwdid = db.rs1.getString("RegNo");
                income = db.rs1.getLong("Total_income");
                age=ageCal(dob);
                if(db.rs1.getString("DOM")!=null)
                {
                    aproMarriageAge=Integer.toString(ageCal(db.rs1.getDate("DOM")));
                }
            } 
        }catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
     private int ageCal(java.sql.Date drec)
     {
         Date d=new Date(drec.getTime());
         System.out.println(""+d);
         Calendar c=Calendar.getInstance();
         c.setTime(d);
         int year = c.get(Calendar.YEAR);
         int month = c.get(Calendar.MONTH) + 1;
         int date = c.get(Calendar.DATE);
         LocalDate l1 = LocalDate.of(year, month, date);
         LocalDate now1 = LocalDate.now();
         Period diff1 = Period.between(l1, now1);
         System.out.println("age:" + diff1.getYears() + "years");
         return diff1.getYears();
     }
     public void myQuery(Map<Object,Object> mymap)
     {
        String query="update pbthousehold set values sno='1'";
        for (Map.Entry<Object, Object> entry : mymap.entrySet()){
            query=query+","+entry.getKey()+"='"+entry.getValue()+"'";
        }
         System.err.println(""+query);
     }
     
     public void myInsert(Map<Object,Object> data)
     {
         ParabitDBC db=new ParabitDBC();
         String query="insert into pbtcensus_household(hh_sno";
         for (Map.Entry<Object, Object> entry : data.entrySet()){
             query=query+","+entry.getKey();
         }
         query=query+") values (null";
         for (Map.Entry<Object, Object> entry : data.entrySet()){
             query=query+",'"+entry.getValue()+"'";
         }
         query=query+")";
         System.out.println(query);
         try
         {
             db.stm.execute(query);
         }catch(Exception e)
         {
             e.printStackTrace();
         }
     }
}
