/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParabitModel;

import parabitccasbharat.ParabitDBC;

/**
 *
 * @author Asus
 */
public class PbtMasterModel {
    
    ParabitDBC db;
    PbtModelAadhar adhrmodel;
    PbtDL dlmodel;
    PbtModelPan panmodel;
    PbtHHModel hhmodel;
    

    public PbtModelAadhar getAdhrmodel() {
        return adhrmodel;
    }

    public PbtDL getDlmodel() {
        return dlmodel;
    }

    public PbtModelPan getPanmodel() {
        return panmodel;
    }
    public PbtMasterModel(String adhrno)
    {
        db=new ParabitDBC("util");
//        fetchAadhardata(adhrno);
//        fetchPan(adhrno);
//        fetchDL(adhrno);
        fetchAllData(adhrno);
    }
    
    
     private void fetchAadhardata(String adhrno)
    {
        
        String query = "select * from pbtaadhar where ano='"+adhrno+"'";
        int i=1;
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                adhrmodel=new PbtModelAadhar(db.rs1.getLong(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++)
                ,db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++)
                ,db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++)
                ,db.rs1.getLong(i++),db.rs1.getDate(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(""+adhrmodel.getEmail());
    }
    private void fetchDL(String adhrno)
    {
        String query="select * from pbtdl where adhrno='"+adhrno+"'";
        int i=1;
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                dlmodel=new PbtDL(db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++),
                                db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getDate(i++),db.rs1.getString(i++));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void fetchPan(String adhrno)
    {
        String query="select * from pbtpan where adhrno='"+adhrno+"'";
        int i=1;
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                panmodel=new PbtModelPan(db.rs1.getString(i++),db.rs1.getString(i++),db.rs1.getString(i++));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    private void fetchAllData(String adhrno)
    {
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
                
            } 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
