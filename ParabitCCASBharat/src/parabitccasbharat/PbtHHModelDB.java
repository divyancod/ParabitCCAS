/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import ParabitModel.PbtHHModel;

/**
 *
 * @author Asus
 */
public class PbtHHModelDB {
    private PbtHHModel model;
    private ParabitDBC db;
    
    public PbtHHModelDB()
    {
        model=new PbtHHModel();
        db=new ParabitDBC();
    }
}
