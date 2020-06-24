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
