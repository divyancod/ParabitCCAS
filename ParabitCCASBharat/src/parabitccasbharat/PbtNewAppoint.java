/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtNewAppoint extends javax.swing.JDialog implements MouseListener,ItemListener{

    /**
     * Creates new form PbtNewAppoint
     */
    ParabitDBC db;
    DefaultTableModel tablemodel;
    DefaultComboBoxModel comboboxmodelstate,distcombomodel,citycombomodel;
    String s2,s3,s4,s5,s6,s7,s8,s9,s10;
    int s1;
    PbtEmpDashBoard pbtempdashboard;
    boolean flag;
    public PbtNewAppoint(PbtEmpDashBoard pbtempdashboard) {
        super(pbtempdashboard,true);
        initComponents();
        setTitle("New Employee Appointment");
        setLocationRelativeTo(null);
        db=new ParabitDBC();
        this.pbtempdashboard=pbtempdashboard;
        tablemodel=new DefaultTableModel();
        comboboxmodelstate=(DefaultComboBoxModel)statescombo.getModel();
        distcombomodel=(DefaultComboBoxModel)distcombo.getModel();
        citycombomodel=(DefaultComboBoxModel)citycombo.getModel();
        tablemodel=(DefaultTableModel)table.getModel();
        setTable();
        flag=true;
        table.addMouseListener(this);
        /*String states[]={"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra and Nagar Haveli and Daman and Diu","Delhi",
                                            "Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Ladakh","Lakshadweep","Madhya Pradesh",
                                            "Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};*/
        int grade=pbtempdashboard.empdata.getEmpgrade();
        switch (grade) {
            case 1:
                setState();
                citycombo.setEnabled(false);
                distcombo.setEnabled(false);
                getAdditionalData();
                break;
            case 2:
                comboboxmodelstate.addElement(pbtempdashboard.empdata.getEmpstate());
                citycombo.setEnabled(false);
                setDist(pbtempdashboard.empdata.getEmpstate());
                getAdditionaldataDist();
                break;
            case 3:
                comboboxmodelstate.addElement(pbtempdashboard.empdata.getEmpstate());
                distcombomodel.addElement(pbtempdashboard.empdata.getEmpDist());
                setCity(pbtempdashboard.empdata.getEmpstate(),pbtempdashboard.empdata.getEmpDist());
                getAdditionaldataCity();
                break;
            case 4:
                comboboxmodelstate.addElement(pbtempdashboard.empdata.getEmpstate());
                distcombomodel.addElement(pbtempdashboard.empdata.getEmpDist());
                citycombomodel.addElement(pbtempdashboard.empdata.getEmpCity());
                break;
            default:
                break;
        }
        statescombo.addItemListener(this);
        distcombo.addItemListener(this);
        citycombo.addItemListener(this);
        setTotalAreaData();
    }
    @Override
    public void itemStateChanged(ItemEvent ie){
        if(ie.getSource()==statescombo)
        {
            getAdditionalData();
        }else if(ie.getSource()==distcombo)
        {
            getAdditionaldataDist();
        }else if(ie.getSource()==citycombo)
        {
            getAdditionaldataCity();
        }
    }
   
    //-------inflating table here
    private void setTable()
    {
        s1=1;
        tablemodel.setRowCount(0);
        try
        {
            int grade=pbtempdashboard.empdata.getEmpgrade()+1;
            String query="select * from pbtemployeetable where grade='"+grade+"' and status='"+0+"'";
            System.out.println(query);
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                s2=db.rs1.getString("GEID");
                s3=db.rs1.getString("EmpName");
                s4=db.rs1.getString("areacity");
                s5=db.rs1.getString("areadist");
                s6=db.rs1.getString("areastate");
                s7=db.rs1.getString("pin");
                s8=db.rs1.getString("workexp");
                s9=db.rs1.getString("workexpcensus");
                s10=db.rs1.getString("empmob");
                Object ob[]={s1++,s2,s3,s4,s5,s6,s7,s8,s9,s10};
                tablemodel.addRow(ob);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private void setState()
    {
        comboboxmodelstate.addElement("Select State");
        try{
            //String query="select DISTINCT state from states";
           // String query="SELECT DISTINCT STATE FROM states LEFT JOIN pbtemployeetable ON states.state=pbtemployeetable.AreaState where pbtemployeetable.AreaState IS NULL";
            String query="SELECT DISTINCT states FROM pbtstates LEFT JOIN pbtemployeetable ON pbtstates.states=pbtemployeetable.AreaState where pbtemployeetable.AreaState IS NULL";
            db.rs2=db.stm.executeQuery(query);
            if(db.rs2.next()==false)
            {
                flag=false;
                System.out.println("false");
                comboboxmodelstate.addElement("NO State Left");
                statescombo.setEnabled(false);
            }else{
                flag=true;
                comboboxmodelstate.addElement(db.rs2.getString("states"));
           while(db.rs2.next())
            {
                comboboxmodelstate.addElement(db.rs2.getString("states"));
            }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void setDist(String state)
    {
        distcombomodel.addElement("Select District");
        try
        {
            //String query="select DISTINCT district from states where state='"+state+"'";
            //String query="SELECT DISTINCT district FROM states LEFT JOIN pbtemployeetable ON states.district=pbtemployeetable.Areadist where pbtemployeetable.AreaDist IS NULL and states.state='"+state+"'";
           String query="SELECT DISTINCT district FROM pbtstates LEFT JOIN pbtemployeetable ON pbtstates.district=pbtemployeetable.Areadist where pbtemployeetable.AreaDist IS NULL and pbtstates.states='"+state+"'";
            db.rs3=db.stm.executeQuery(query);
            while(db.rs3.next())
            {
                distcombomodel.addElement(db.rs3.getString("district"));
            }
        }catch(Exception e)
        {
            
        }
    }
    private void setCity(String state,String dist)
    {
        citycombomodel.addElement("Select City");
        try
        {
            //String query="select DISTINCT tehsil from states where state='"+state+"' and district='"+dist+"'";
            //String query="SELECT DISTINCT tehsil FROM states LEFT JOIN pbtemployeetable ON states.tehsil=pbtemployeetable.areacity where pbtemployeetable.AreaCity IS NULL and states.state='"+state+"' and states.district='"+dist+"'";
            String query="SELECT DISTINCT SubDist FROM pbtstates LEFT JOIN pbtemployeetable ON pbtstates.subdist=pbtemployeetable.areacity where pbtemployeetable.AreaCity IS NULL and pbtstates.states='"+state+"' and pbtstates.district='"+dist+"'";
            System.out.println(query);
            db.rs4=db.stm.executeQuery(query);
            while(db.rs4.next())
            {
                citycombomodel.addElement(db.rs4.getString("subDist"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    String geid;
    String state,dist,city;
    private void hireEmployee()
    {
        state=statescombo.getSelectedItem().toString();
        int grade=pbtempdashboard.empdata.getEmpgrade();
        String query="";
        switch(grade){
            case 1: 
                dist="All the district of State";
                city="All the cities of District";
                query="update pbtemployeetable set areacity='"+city+"',areadist='"+dist+"',crepempid='"+pbtempdashboard.empdata.getEmpid()+"',areastate='"+state+"',status='1' where geid='"+geid+"'";
                //setState();/---------error by me
                comboboxmodelstate.removeElement(state);
                break;
            case 2:
                city="All the cities of District";
                dist=distcombo.getSelectedItem().toString();
                query="update pbtemployeetable set areacity='"+city+"',areadist='"+dist+"',crepempid='"+pbtempdashboard.empdata.getEmpid()+"',areastate='"+state+"',status='1' where geid='"+geid+"'";
                distcombomodel.removeElement(dist);
                break;
            case 3:
                city=citycombo.getSelectedItem().toString();
                dist=distcombo.getSelectedItem().toString();
                query="update pbtemployeetable set areacity='"+city+"',areadist='"+dist+"',crepempid='"+pbtempdashboard.empdata.getEmpid()+"',areastate='"+state+"',status='1' where geid='"+geid+"'";
                citycombomodel.removeElement(city);
                break;
            case 4:
                state=statescombo.getSelectedItem().toString();
                dist=distcombo.getSelectedItem().toString();
                city=citycombo.getSelectedItem().toString();
                query="update pbtemployeetable set areacity='"+city+"',areadist='"+dist+"',crepempid='"+pbtempdashboard.empdata.getEmpid()+"',areastate='"+state+"',status='1' where geid='"+geid+"'";
                break;
            default:
                break;     
        }
        System.out.println(query);
        try{
        db.stm.executeUpdate(query);
        }catch(Exception e)
        {
        e.printStackTrace();
        }
        setTable();
        
    }
    private void getAdditionalData()
    {
        state=statescombo.getSelectedItem().toString();
        String query="select count(distinct district) as listdistrict,sum(tpopulation) as areatpop from pbtstates where states='"+state+"'";
        System.out.println(query);
        try{
        db.rs3=db.stm.executeQuery(query);
        if(db.rs3.next())
        {
           //System.out.println(db.rs3.getString("listdistrict"));
           totaldist.setText("Total Districts : "+db.rs3.getString("listdistrict"));
           areatpop.setText("Area Population : "+db.rs3.getString("areatpop"));
        }
        query="select count(distinct subdist) as city from pbtstates where states='"+state+"'";
        db.rs3=db.stm.executeQuery(query);
        if(db.rs3.next())
        {
           //System.out.println(db.rs3.getString("city"));
           totalcity.setText("Total Cities : "+db.rs3.getString("city"));
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void getAdditionaldataDist()
    {
        state=pbtempdashboard.empdata.getEmpstate();
        dist=distcombo.getSelectedItem().toString();
        totaldist.setVisible(false);
        String query="select count(DISTINCT subdist) as city,sum(tpopulation) as areatpop from pbtstates where states='"+state+"' and district='"+dist+"'";
        System.out.println(query);
        try
        {
            db.rs3=db.stm.executeQuery(query);
            db.rs3.next();
            totalcity.setText("Total Cities : "+db.rs3.getString("city"));
            areatpop.setText("Area Population : "+db.rs3.getString("areatpop"));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getAdditionaldataCity()
    {
        state=pbtempdashboard.empdata.getEmpstate();
        dist=pbtempdashboard.empdata.getEmpDist();
        city=citycombo.getSelectedItem().toString();
        String query="select sum(tpopulation) as areatpop from pbtstates where states='"+state+"' and district='"+dist+"' and subdist='"+city+"'";
        System.out.println(query);
        try
        {
            db.rs3=db.stm.executeQuery(query);
            db.rs3.next();
            areatpop.setText("Area Population : "+db.rs3.getString("areatpop"));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void setTotalAreaData()
    {
        String query="select count(DISTINCT states) as state, COUNT(DISTINCT district) as dist, COUNT(DISTINCT subdist) as city, sum(TPopulation) as tpop  from pbtstates";
        int grade=pbtempdashboard.empdata.getEmpgrade();    
        switch (grade) {
            case 2:
                query=query+" where states='"+pbtempdashboard.empdata.getEmpstate()+"'";
                break;
            case 3:
                totaldist.setVisible(false);
                totalcity.setVisible(false);
                query=query+" where states='"+pbtempdashboard.empdata.getEmpstate()+"' and district='"+pbtempdashboard.empdata.getEmpDist()+"'";
                break;
            case 4:
                totaldist.setVisible(false);
                totalcity.setVisible(false);
                query=query+" where states='"+pbtempdashboard.empdata.getEmpstate()+"' and district='"+pbtempdashboard.empdata.getEmpDist()+"' and subdist='"+pbtempdashboard.empdata.getEmpCity()+"'";
                break;
            default:
                break;
        }
        try
        {
            System.out.println("query");
            db.rs5=db.stm.executeQuery(query);
            db.rs5.next();
            System.out.println(db.rs5.getString("state")+db.rs5.getString("dist")+db.rs5.getString("city"));
            tstates.setText("Total States : "+db.rs5.getString("state"));
            tdists.setText("Total Districts : "+db.rs5.getString("dist"));
            tcities.setText("Total Cities : "+db.rs5.getString("city"));
            tpop.setText("Total Population : "+db.rs5.getString("tpop"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        statescombo = new javax.swing.JComboBox<>();
        distcombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        citycombo = new javax.swing.JComboBox<>();
        totaldist = new javax.swing.JLabel();
        totalcity = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tstates = new javax.swing.JLabel();
        tdists = new javax.swing.JLabel();
        tcities = new javax.swing.JLabel();
        tpop = new javax.swing.JLabel();
        areatpop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("PARABIT CCAS-BHARAT");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SNo", "GEID", "EmpName", "City", "District", "State", "PIN", "Work Exp", "Work Exp Census", "Mobile Number"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(35);
            table.getColumnModel().getColumn(1).setMinWidth(90);
            table.getColumnModel().getColumn(1).setMaxWidth(95);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(105);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(4).setMaxWidth(105);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setMaxWidth(105);
            table.getColumnModel().getColumn(6).setMinWidth(70);
            table.getColumnModel().getColumn(6).setMaxWidth(75);
            table.getColumnModel().getColumn(9).setMinWidth(120);
            table.getColumnModel().getColumn(9).setMaxWidth(125);
        }

        statescombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        statescombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statescomboActionPerformed(evt);
            }
        });

        distcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        distcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distcomboActionPerformed(evt);
            }
        });

        jLabel3.setText("State :");

        jLabel4.setText("District :");

        jLabel5.setText("City :");

        citycombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        citycombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citycomboActionPerformed(evt);
            }
        });

        totaldist.setText("0");

        totalcity.setText("0");

        jLabel8.setText("Area Under You");

        tstates.setText("Total States :");

        tdists.setText("Total Districts : ");

        tcities.setText("Total Cities :");

        tpop.setText("Total Population :");

        areatpop.setText("Selected Area Total Population");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tstates)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tpop)
                                    .addComponent(jLabel8)
                                    .addComponent(tcities))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(areatpop)
                                .addGap(161, 161, 161)
                                .addComponent(totaldist))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(statescombo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(distcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel5))
                            .addComponent(totalcity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(citycombo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(515, 515, 515)
                                .addComponent(jLabel2))
                            .addComponent(tdists))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpop)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statescombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(citycombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tstates))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totaldist)
                            .addComponent(totalcity)
                            .addComponent(areatpop)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tdists)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcities)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distcomboActionPerformed

        //dist=distcombo.getSelectedItem().toString();
    }//GEN-LAST:event_distcomboActionPerformed

    private void citycomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citycomboActionPerformed
        // TODO add your handling code here:
        //city=citycombo.getSelectedItem().toString();
    }//GEN-LAST:event_citycomboActionPerformed

    private void statescomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statescomboActionPerformed
    }//GEN-LAST:event_statescomboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PbtNewAppoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtNewAppoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtNewAppoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtNewAppoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //setTable();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areatpop;
    private javax.swing.JComboBox<String> citycombo;
    private javax.swing.JComboBox<String> distcombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> statescombo;
    private javax.swing.JTable table;
    private javax.swing.JLabel tcities;
    private javax.swing.JLabel tdists;
    private javax.swing.JLabel totalcity;
    private javax.swing.JLabel totaldist;
    private javax.swing.JLabel tpop;
    private javax.swing.JLabel tstates;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        System.out.println(e.getClickCount());
        int col = table.columnAtPoint(e.getPoint());
        if(statescombo.getSelectedItem().equals("Select State"))
            flag=false;
        else if(distcombo.getSelectedItem()==null && citycombo.getSelectedItem()==null)
            flag=true;
        else if(distcombo.getSelectedItem().equals("Select District"))
            flag=false;
        else if(citycombo.getSelectedItem()==null)
            flag=true;
        else if(citycombo.getSelectedItem().equals("Select City"))
            flag=false;
        else
            flag=true;
        
        if (row >= 0 && col >= 0 && flag) {
            String gcid=(String)tablemodel.getValueAt(row,1);
            String finaldist=distcombo.getSelectedItem()+"";
            String finalcity=citycombo.getSelectedItem()+"";
           int opt= JOptionPane.showConfirmDialog(null,"You are about to hire "+tablemodel.getValueAt(row,2)+" for "+statescombo.getSelectedItem()+" "+finaldist+" "+finalcity);
           if(opt==0)
           {
               geid=tablemodel.getValueAt(row,1).toString();
               hireEmployee();
               JOptionPane.showMessageDialog(null,"Employee hired.\nLogin access is provided kindly send notification to inform employee about login access");
           }else if(opt==1)
           {
               JOptionPane.showMessageDialog(null,"Employee Hiring Cancelled");
           }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
