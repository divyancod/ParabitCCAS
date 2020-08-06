package ParabitModel;

import java.sql.Date;


public class PbtDL{

  private String adhrNo;
  private String rtoState;
  private String rtoCode;
  private String regYear;
  private String number;
  private String dlNumber;
  private java.sql.Date dateOfIssue;
  private String vechileClass;

    public PbtDL(String adhrNo, String rtoState, String rtoCode, String regYear, String number, String dlNumber, Date dateOfIssue, String vechileClass) {
        this.adhrNo = adhrNo;
        this.rtoState = rtoState;
        this.rtoCode = rtoCode;
        this.regYear = regYear;
        this.number = number;
        this.dlNumber = dlNumber;
        this.dateOfIssue = dateOfIssue;
        this.vechileClass = vechileClass;
    }


  public String getAdhrNo() {
    return adhrNo;
  }

  public void setAdhrNo(String adhrNo) {
    this.adhrNo = adhrNo;
  }


  public String getRtoState() {
    return rtoState;
  }

  public void setRtoState(String rtoState) {
    this.rtoState = rtoState;
  }


  public String getRtoCode() {
    return rtoCode;
  }

  public void setRtoCode(String rtoCode) {
    this.rtoCode = rtoCode;
  }


  public String getRegYear() {
    return regYear;
  }

  public void setRegYear(String regYear) {
    this.regYear = regYear;
  }


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public String getDlNumber() {
    return dlNumber;
  }

  public void setDlNumber(String dlNumber) {
    this.dlNumber = dlNumber;
  }


  public java.sql.Date getDateOfIssue() {
    return dateOfIssue;
  }

  public void setDateOfIssue(java.sql.Date dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }


  public String getVechileClass() {
    return vechileClass;
  }

  public void setVechileClass(String vechileClass) {
    this.vechileClass = vechileClass;
  }

}
