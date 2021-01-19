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
public class PbtEmpData {
    
    private String empname;
    private String empdesig;
    private int empgrade;
    private String empemail;
    private String empcomputerno;
    private String empid;
    private String empstate;
    private String empdist;
    private String empcity;
    private String empcrepempid;
    private String wardno;
    private String townvillname;
    private String townvillno;
    private String statecode;
    private String distcode;
    private String tehsilcode;

    public String getTownvillname() {
        return townvillname;
    }

    public void setTownvillname(String townvillname) {
        this.townvillname = townvillname;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getDistcode() {
        return distcode;
    }

    public void setDistcode(String distcode) {
        this.distcode = distcode;
    }

    public String getTehsilcode() {
        return tehsilcode;
    }

    public void setTehsilcode(String tehsilcode) {
        this.tehsilcode = tehsilcode;
    }
    

    public String getTownvillno() {
        return townvillno;
    }

    public void setTownvillno(String townvillno) {
        this.townvillno = townvillno;
    }

    
    public String getWardno() {
        return wardno;
    }

    public void setWardno(String wardno) {
        this.wardno = wardno;
    }

    public String getTownvill() {
        return townvillname;
    }

    public void setTownvill(String townvill) {
        this.townvillname = townvill;
    }
    

    public String getEmpcrepempid() {
        return empcrepempid;
    }

    public void setEmpcrepempid(String empcrepempid) {
        this.empcrepempid = empcrepempid;
    }
    
    public String getEmpDist()
    {
        return empdist;
    }
    public String getEmpid() {
        return empid;
    }
    public String getEmpstate() {
        return empstate;
    }
    public String getEmpCity()
    {
        return empcity;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setEmpdesig(String empdesig) {
        this.empdesig = empdesig;
    }

    public void setEmpgrade(int empgrade) {
        this.empgrade = empgrade;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public void setEmpcomputerno(String empcomputerno) {
        this.empcomputerno = empcomputerno;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setEmpstate(String empstate) {
        this.empstate = empstate;
    }

    public void setEmpdist(String empdist) {
        this.empdist = empdist;
    }

    public void setEmpcity(String empcity) {
        this.empcity = empcity;
    }
    
    public PbtEmpData()
    {
        
    }
    public PbtEmpData(String empname, String empdesig, int empgrade, String empemail, String empcomputerno,String empid,String empstate,String empdist,String empcity) {
        this.empname = empname;
        this.empdesig = empdesig;
        this.empgrade = empgrade;
        this.empemail = empemail;
        this.empcomputerno = empcomputerno;
        this.empid=empid;
        this.empstate=empstate;
        this.empdist=empdist;
        this.empcity=empcity;
    }

    public String getEmpname() {
        return empname;
    }

    public String getEmpdesig() {
        return empdesig;
    }

    public int getEmpgrade() {
        return empgrade;
    }

    public String getEmpemail() {
        return empemail;
    }

    public String getEmpcomputerno() {
        return empcomputerno;
    }
    
    
}
