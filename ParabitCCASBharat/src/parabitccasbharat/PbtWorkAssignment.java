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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtWorkAssignment extends javax.swing.JDialog implements ItemListener,MouseListener{

    /**
     * Creates new form PbtWorkAssignment
     */
    DefaultTableModel areatablemodel,employeetablemodel;
    ParabitDBC db;
    PbtEmpDashBoard empdashboard;
    DefaultComboBoxModel firstcomboboxmodel,towncombomodel;
    ArrayList<String> townno;
    int totalpop;
    public PbtWorkAssignment(PbtEmpDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Employee Work Assignment");
        db=new ParabitDBC();
        this.empdashboard=parent;
        areatablemodel=new DefaultTableModel();
        employeetablemodel=new DefaultTableModel();
        areatablemodel=(DefaultTableModel)areatable.getModel();
        employeetablemodel=(DefaultTableModel)enumtable.getModel();
        firstcomboboxmodel=(DefaultComboBoxModel)firstcombo.getModel();
        towncombomodel=(DefaultComboBoxModel)secondtowncombo.getModel();
        townno=new ArrayList<String>();
        setTown();
        firstcombo.addItemListener(this);
        secondtowncombo.addItemListener(this);
        labeltown.setVisible(false);
        secondtowncombo.setVisible(false);
        setEmployeeTable();
        areatable.addMouseListener(this);
        areatable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //enumtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        populationtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    private void changes()
    {
        int remain=0;
        if(!populationtf.getText().isEmpty())
            remain=Integer.parseInt(populationtf.getText());
        remain=totalpop-remain;
        //System.out.println(remain);
        remainpop.setText("Population Remaning : "+remain);
    }
    
        @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==firstcombo){
        if(e.getStateChange() == ItemEvent.SELECTED)
       {
           if(firstcombo.getSelectedItem().toString().equals("Village"))
           {
               labeltown.setVisible(false);
               secondtowncombo.setVisible(false);
               setAreaTable(1);
           }else if(firstcombo.getSelectedItem().toString().equals("Town"))
           {
               labeltown.setVisible(true);
               secondtowncombo.setVisible(true);
               areatablemodel.setRowCount(0);
               secondtowncombo.setSelectedIndex(0);
           }
       }
        }else if(e.getSource()==secondtowncombo)
        {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(!secondtowncombo.getSelectedItem().equals("--Select Town--"))
                {
                    System.out.println("setting table");
                    setAreaTable(2);
                }
            }
        }
    }
    
    private void setAreaTable(int r)
    {
        areatablemodel.setRowCount(0);
        String query="";
        if(r==1)
         query="SELECT * FROM `pbtenum` WHERE SubDistCode=(select DISTINCT SubDistCode from pbtenum where name='"+empdashboard.empdata.getEmpCity().trim()+"') and level='"+firstcombo.getSelectedItem()+"'";
        else if(r==2)
         query="SELECT * FROM `pbtenum` WHERE town_vill='"+townno.get(secondtowncombo.getSelectedIndex())+"' and Level='ward'";
        try{
            System.out.println(query);
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                Object ob[]={db.rs1.getString("distcode"),db.rs1.getString("subdistcode"),db.rs1.getString("town_vill"),db.rs1.getString("ward"),db.rs1.getString("name")
                                ,db.rs1.getString("level"),db.rs1.getString("rural_urban"),db.rs1.getString("totpoulation"),db.rs1.getString("remainpop"),'0'};
                areatablemodel.addRow(ob);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void setEmployeeTable()
    {
        employeetablemodel.setRowCount(0);
        int count=1;
        //String query="select * from pbtemployeetable where crepempid='"+empdashboard.empdata.getEmpid()+"' and status='1'";
        String query="SELECT DISTINCT pbtemployeetable.*,(select DISTINCT sum(totalres) from pbtempschecdule where pbtemployeetable.CEID=pbtempschecdule.ceid) as totalallot FROM `pbtemployeetable` LEFT join pbtempschecdule on pbtemployeetable.CEID=pbtempschecdule.CEID where pbtemployeetable.CRepEmpID='"+empdashboard.empdata.getEmpid()+"'  and pbtemployeetable.PerCommt is NULL";
        String totalallot;
        try
        {
            System.out.println(query);
            db.rs2=db.stm.executeQuery(query);
            while(db.rs2.next())
            {
                if(db.rs2.getString("totalallot")==null)
                {
                    totalallot="0";
                }
                else
                {
                    totalallot=db.rs2.getString("totalallot");
                }
                Object nob[]={count,
                db.rs2.getString("ceid"),
                db.rs2.getString("EmpName"),
                db.rs2.getString("areacity"),
                db.rs2.getString("areadist"),
                db.rs2.getString("areastate"),
                db.rs2.getString("pin"),
                db.rs2.getString("empdesig"),
                db.rs2.getString("empmob"),
                totalallot};
                count++;
                employeetablemodel.addRow(nob);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void setEmployeeByPref(String area)
    {
        employeetablemodel.setRowCount(0);
        //String query="SELECT *,IF(preference like '%"+area+"%',1,0) as india FROM `pbtemployeetable` where CRepEmpID='"+empdashboard.empdata.getEmpid()+"' ORDER BY india Desc";
        String query="SELECT DISTINCT pbtemployeetable.*,(select DISTINCT sum(totalres) from pbtempschecdule where pbtemployeetable.CEID=pbtempschecdule.ceid) as totalallot,IF(pbtemployeetable.preference like '%"+area+"%',1,0) as india FROM `pbtemployeetable` LEFT join pbtempschecdule on pbtemployeetable.CEID=pbtempschecdule.CEID where pbtemployeetable.CRepEmpID='"+empdashboard.empdata.getEmpid()+"' and pbtemployeetable.PerCommt is NULL ORDER BY india DESC";
        int count=1;
        String totalallot="";
        try
        {
            System.out.println(query);
            db.rs2=db.stm.executeQuery(query);
            while(db.rs2.next())
            {
                if(db.rs2.getString("totalallot")==null)
                {
                    totalallot="0";
                }
                else
                {
                    totalallot=db.rs2.getString("totalallot");
                }
                Object nob[]={count,
                db.rs2.getString("ceid"),
                db.rs2.getString("EmpName"),
                db.rs2.getString("areacity"),
                db.rs2.getString("areadist"),
                db.rs2.getString("areastate"),
                db.rs2.getString("pin"),
                db.rs2.getString("empdesig"),
                db.rs2.getString("empmob"),
                totalallot
                };
                count++;
                employeetablemodel.addRow(nob);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void setTown()
    {
        towncombomodel.removeAllElements();
        towncombomodel.addElement("--Select Town--");
        townno.add("select");
        String flag="";
        String query="SELECT DISTINCT town_vill,name FROM `pbtenum` WHERE SubDistCode=(select DISTINCT SubDistCode from pbtenum where name='"+empdashboard.empdata.getEmpCity().trim()+"') and level='Town'";
        System.out.println(query);
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                flag=db.rs1.getString("name");
                flag=flag+" - "+db.rs1.getString("town_vill");
                townno.add(db.rs1.getString("town_vill"));
                towncombomodel.addElement(flag);
                System.out.println(flag);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void assignEmployee()
    {
        if(startdate.getDate()==null)
        {
            JOptionPane.showMessageDialog(null,"Please select start date.","Select Start Date",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int arearows[]=areatable.getSelectedRows();
        int employeerow=enumtable.getSelectedRow();
        int areaproviding=0;
        if(employeerow==-1 ||populationtf.getText().isEmpty()||arearows.length<=0)
        {
            JOptionPane.showMessageDialog(null,"Kindly select proper fields to allot work.","Selection Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String query="";
        String msg="";
        int pop=Integer.parseInt(populationtf.getText());
        int option=-1;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String selecteddate=sdf.format(startdate.getDate());
        int checkallotment=Integer.parseInt(enumtable.getValueAt(employeerow, 9).toString());
        pop=checkallotment+pop;//<---------------check here for error
        if(pop<=1200)
        {
            msg="You are Alloting.Do you want to continue?\nAlloting "+pop+" Persons to {NAME HERE}";
            option=JOptionPane.showConfirmDialog(null,msg,"Confirm Transfer",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        }
        else if(pop>1200 && pop<=1250)
        {
            msg="You are exceeding the limit of 1200 but you can proceed.Do you want to continue?\nAlloting "+pop+" Persons to {NAME HERE}";
            option=JOptionPane.showConfirmDialog(null,msg,"Confirm Allotement",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        }
        else if(pop>1250 && pop<=1300)
        {
            msg="You can not allot such amount of population to only one enumerator. Do you want to forcefully allot these areas to {NAME HERE}";
            option=JOptionPane.showConfirmDialog(null,msg,"Confirm Transfer",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        }else
        {
            msg="You can not allot such amount of population to only one enumerator.Kindly reduce selected population to allot work";
            JOptionPane.showMessageDialog(null,msg,"Confirm Transfer",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(option==0)
        {
            for(int i=0;i<arearows.length;i++)
            {
            query="INSERT INTO `pbtempschecdule`(`SNo`, `CEID`, `CRepEmpID`, `WardNo`, `Zone`, `City_Vill`, `Tehsil`, `Dist`, `State`, `DateOfIssue`, `DateOfWorkStart`, `ApproxDay`, `WorkDone`, `TotalRes`, `Amount`, `Note`, `PerCommt`, `Status`) VALUES"
                    +"(NULL,'"+employeetablemodel.getValueAt(employeerow,1)+"','"+empdashboard.empdata.getEmpid()+"','"+areatablemodel.getValueAt(arearows[i],3)+"',"
                    + "NULL,'"+areatablemodel.getValueAt(arearows[i],2)+"','"+areatablemodel.getValueAt(arearows[i],1)+"','"+areatablemodel.getValueAt(arearows[i],0)+"','10',"
                    + "now(),'"+selecteddate+"','100',NULL,'"+areatablemodel.getValueAt(arearows[i],9)+"','12000',NULL,NULL,'1')";
            areaproviding=areaproviding+Integer.parseInt(areatablemodel.getValueAt(arearows[i],9).toString());
            msg="update pbtenum set remainpop='"+areatablemodel.getValueAt(arearows[i],8)+"' where distcode='"+areatablemodel.getValueAt(arearows[i],0)+"' and subdistcode='"+areatablemodel.getValueAt(arearows[i],1)+"' and town_vill='"+areatablemodel.getValueAt(arearows[i],2)+"' and ward='"+areatablemodel.getValueAt(arearows[i],3)+"'";
            System.out.println(msg);
            try
            {
                db.stm.execute(query);
                db.stm1.execute(msg);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            System.out.println(query);
            }
            if(firstcombo.getSelectedItem().toString().equals("Village"))
           {
               setAreaTable(1);
           }else
            {
                if(!secondtowncombo.getSelectedItem().equals("--Select Town--"))
                {
                    setAreaTable(2);
                }
            }
            if(areaproviding>1000)
            {
                msg="Do you want to remove this enumerator from list as you have alloted population more than 1000";
                option=JOptionPane.showConfirmDialog(null,msg,"Confirm Allotment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(option==0)
                {
                   query="update pbtemployeetable set percommt='1' where ceid='"+enumtable.getValueAt(employeerow, 1)+"'";
                   System.out.println(query);
                   try
                   {
                      db.stm.execute(query);
                   }catch(Exception e)
                   {
                       
                   }
                }
            }
            setEmployeeTable();
            startdate.setCalendar(null);
        }
        
        
    }
    private void totalPop()
    {
        int row[]=areatable.getSelectedRows();
        totalpop=0;
        for(int i=0;i<row.length;i++)
        {
            totalpop=totalpop+(Integer.parseInt(areatablemodel.getValueAt(row[i],9).toString()));
        }
        populationtf.setText(totalpop+"");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areatable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        enumtable = new javax.swing.JTable();
        firstcombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labeltown = new javax.swing.JLabel();
        secondtowncombo = new javax.swing.JComboBox<>();
        populationtf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        enumrequired = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startdate = new com.toedter.calendar.JDateChooser();
        assignbtn = new javax.swing.JButton();
        popperenum = new javax.swing.JLabel();
        remainpop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        areatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "District Code", "SubDistCode", "Town_Vill", "Ward", "Name", "Level", "Rural/Urban", "Total Population", "Remaining Population", "Currently Alloting"
            }
        ));
        jScrollPane1.setViewportView(areatable);

        enumtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SNo", "CEID", "EmpName", "City", "District", "State", "PIN", "Emp Designation", "Mobile Number", "Population Alloted"
            }
        ));
        jScrollPane2.setViewportView(enumtable);

        firstcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"--Select--", "Village","Town" }));
        firstcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstcomboActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Village/Town");

        labeltown.setText("Select Town : ");

        secondtowncombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Population alloting : ");

        enumrequired.setText("Enumerator Required : ");

        jLabel3.setText("Select Work Start Date :");

        startdate.setMinSelectableDate(new Date(System.currentTimeMillis()));

        assignbtn.setText("Assign Work");
        assignbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignbtnActionPerformed(evt);
            }
        });

        popperenum.setText("Population per Enumerator");

        remainpop.setText("Population Remaining :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(labeltown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondtowncombo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enumrequired)
                        .addGap(42, 42, 42)
                        .addComponent(popperenum)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(populationtf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remainpop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assignbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeltown)
                    .addComponent(jLabel1)
                    .addComponent(secondtowncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(populationtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(enumrequired)
                        .addComponent(jLabel3)
                        .addComponent(popperenum)
                        .addComponent(remainpop))
                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void assignbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignbtnActionPerformed

        assignEmployee();
    }//GEN-LAST:event_assignbtnActionPerformed

    private void firstcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstcomboActionPerformed

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
            java.util.logging.Logger.getLogger(PbtWorkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtWorkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtWorkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtWorkAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable areatable;
    private javax.swing.JButton assignbtn;
    private javax.swing.JLabel enumrequired;
    private javax.swing.JTable enumtable;
    private javax.swing.JComboBox<String> firstcombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltown;
    private javax.swing.JLabel popperenum;
    private javax.swing.JTextField populationtf;
    private javax.swing.JLabel remainpop;
    private javax.swing.JComboBox<String> secondtowncombo;
    private com.toedter.calendar.JDateChooser startdate;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==areatable)
        {
            int frow=areatable.rowAtPoint(e.getPoint());
            int row[]=areatable.getSelectedRows();
            totalpop=0;
            for(int i=0;i<row.length;i++)
            {
                totalpop=totalpop+(Integer.parseInt(areatablemodel.getValueAt(row[i],7).toString()));
            }
            int value=0;
            value=Integer.parseInt(areatablemodel.getValueAt(frow,8).toString());
            if(value==0)
            {
                JOptionPane.showMessageDialog(null,"The popluation of this area has been already alloted. Kindly select some other area");
                return;
            }
            if(row.length>0)
            {
                if(totalpop>1200)
                {
                    int rem=Integer.parseInt(areatablemodel.getValueAt(frow,7).toString());
                    rem=totalpop-rem;
                    rem=1200-rem;
                    System.out.println(totalpop+"--------"+areatablemodel.getValueAt(frow,7));
                    String temp=JOptionPane.showInputDialog("This Area is increasing population above 1200 per enumerator.\nPlease type less population for this selected area\nPopulation Can be allotted from this area = "+(rem));
                    if(temp==null || temp.isEmpty()){
                        areatable.removeRowSelectionInterval(frow, frow);
                        return;
                    }
                    value=Integer.parseInt(temp);
                    areatablemodel.setValueAt(value, frow, 9);
                    value=Integer.parseInt(areatablemodel.getValueAt(frow, 8).toString())-value;
                    areatablemodel.setValueAt(value, frow, 8);
                    
                }else
                {
                    value=Integer.parseInt(areatablemodel.getValueAt(frow, 8).toString());
                    areatablemodel.setValueAt("0",frow,8);
                    areatablemodel.setValueAt(value, frow, 9);
                }
            }
            /*else if(row.length==1)
            {
                if(totalpop<=1300)
                {
                    value=Integer.parseInt(areatablemodel.getValueAt(frow, 7).toString());
                    value=totalpop-value;
                    areatablemodel.setValueAt(value,frow,8);
                    areatablemodel.setValueAt(totalpop,frow,9);
                }
            }*/
            if(row.length==1)
            {
                setEmployeeByPref(areatablemodel.getValueAt(frow,2).toString());
            }
            populationtf.setText(""+totalpop);
            int enumreq=(int)Math.ceil((float)totalpop/1200);
            enumrequired.setText("Enumerators Required : "+enumreq);
            int poptoallot=(int)Math.ceil((float)totalpop/enumreq);
            popperenum.setText("Population per Enumerator : "+poptoallot);
            totalPop();
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
