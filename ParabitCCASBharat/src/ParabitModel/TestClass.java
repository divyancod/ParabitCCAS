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
public class TestClass {
    ParabitDBC db;
    TestClass()
    {
        db=new ParabitDBC();
        
    }
    public void getAll()
    {
        try
        {
            String query="select * from light_source";
            db.rs1=db.stm.executeQuery(query);               
            System.out.println("switch((int)data)");
            System.out.println("{");
            while(db.rs1.next())
            {
                System.out.print("case "+db.rs1.getString(1)+": ");
                System.out.println("return \""+db.rs1.getString(2)+"\";");
                //System.out.println("\""+db.rs1.getString(2)+"\",");
            }
            System.out.println("}");
            System.out.println("return \"\";");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        TestClass nob=new TestClass();
        nob.getAll();
    }
    }

