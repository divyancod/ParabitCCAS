/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class ParabitDBC {
    
    public Connection con;
    public Statement stm,stm1;
    public ResultSet rs1,rs2,rs3,rs4,rs5; 
    public ParabitDBC()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parabitccasbharat","root","");
            stm=con.createStatement();
            stm1=con.createStatement();
            
        }catch(Exception e)
        {
            System.out.println("Error in Database Connection"+e);
        }
    }
    public ParabitDBC(String util)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parabitutil","root","");
            stm=con.createStatement();
            stm1=con.createStatement();
        }catch(Exception e)
        {
            System.out.println("Error in Database Connection"+e);
        }
    }
    
    public static void main(String args[])
    {
        ParabitDBC ob=new ParabitDBC("util");
    }
    
}
