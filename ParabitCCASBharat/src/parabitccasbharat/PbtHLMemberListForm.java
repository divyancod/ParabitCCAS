/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import parabitmodel.PbtHLModel;

/**
 *
 * @author Asus
 */
public class PbtHLMemberListForm extends javax.swing.JFrame implements MouseListener{

    /**
     * Creates new form PbtHLMemberListForm
     */
    PbtHLModel hlmodel;
    DefaultTableModel membermodel;
    ParabitDBC db;
    boolean tlive;
    PbtEmpData empdata;
    PbtEnumDashBoard enumDashBoard;
    boolean censuscomplete;
    public PbtHLMemberListForm(PbtEnumDashBoard enumDashBoard) {
        initComponents();
        this.enumDashBoard=enumDashBoard;
        empdata=enumDashBoard.empdata;
        setTitle("CENSUS FORM HOUSELISTING - "+empdata.getEmpid());
        db=new ParabitDBC();
        hlmodel=new PbtHLModel();
        hlmodel.setTypeOfHouse(1);
        hlmodel.setUseOfHouse("1");
        hlmodel.setWardNo(empdata.getWardno());
        hlmodel.setStUt(empdata.getEmpstate());
        hlmodel.setTownVillage(empdata.getTownvill());
        hlmodel.setTehsil(empdata.getEmpCity());
        hlmodel.setDist(empdata.getEmpDist());
        hlmodel.setEmpEnumNo(empdata.getEmpid());
        //do not change the below sequence
        hlmodel.firstInsert();
        hlmodel.getCurrent();
        updateAddress();
        //do not change above sequence
        //hlmodel.setHlSNo(1001);
        membermodel=(DefaultTableModel)membertable.getModel();
        membertable.addMouseListener(this);
        //setTableData();
        tlive=true;
        Thread nob=new Thread(new Runnable(){
            @Override
            public void run()
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
            while(true)
            {
                live.setText(formatter.format(new Date())); 
                try{Thread.sleep(1000);}catch(Exception e){}
            }
            }
        });
        nob.start();
    }
    //constrcutor from incomplete part 
    public PbtHLMemberListForm(PbtEnumDashBoard enumDashBoard,PbtHLModel hlmodel)
    {
        initComponents();
        this.enumDashBoard=enumDashBoard;
        empdata=enumDashBoard.empdata;
        this.hlmodel=hlmodel;
        setTitle("CENSUS FORM HOUSELISTING - "+empdata.getEmpid());
        db=new ParabitDBC();
        membermodel=(DefaultTableModel)membertable.getModel();
        membertable.addMouseListener(this);
        setTableData();
        tlive=true;
        Thread nob=new Thread(new Runnable(){
            @Override
            public void run()
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
            while(true)
            {
                live.setText(formatter.format(new Date())); 
                try{Thread.sleep(1000);}catch(Exception e){}
            }
            }
        });
        nob.start();
    }
    private void updateAddress()
    {
        Map<Object,Object> data=new HashMap<>();
        data.put("stUt",hlmodel.getStUt());
        data.put("dist",hlmodel.getDist());
        data.put("tehsil",hlmodel.getTehsil());
        data.put("townVillage",hlmodel.getTownVillage());
        data.put("wardNo",hlmodel.getWardNo());
        data.put("hNoAdd",hlmodel.getHNoAdd());
        data.put("pinCode",hlmodel.getPinCode());
        long hlsno=hlmodel.getHlSNo();
        Random rand=new Random();
        String ucid=hlsno+""+rand.nextInt(999);
        data.put("ucid",ucid);
        data.put("fsno","1");
        hlmodel.updateQuery(data);
        
    }
    public void setTableData()
    {
        censuscomplete=false;
        membermodel.setRowCount(0);
        int i=1;
        String query="select * from pbtcensus_household where hl_sno='"+hlmodel.getHlSNo()+"'";
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                String status=db.rs1.getString("status");
                switch (status) {
                    case "1":
                        status="Completed";
                        break;
                    case "9":
                        status="OnGoing";
                        break;
                    case "8":
                        censuscomplete=true;
                        status="Pending";
                        break;
                    case "7":
                        censuscomplete=true;
                        status="Incomplete";
                        break;
                    default:
                        break;
                }
                Object nob[]={i++,db.rs1.getString("uid"),db.rs1.getString("name"),db.rs1.getString("mobno"),db.rs1.getString("gender"),db.rs1.getString("dob"),status};
                membermodel.addRow(nob);
                if(db.rs1.getString("UID").equals(db.rs1.getString("HeadUID")))
                {
                    hlmodel.setHhSNo(Long.parseLong(db.rs1.getString("HH_SNo")));
                }
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        membertable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        live = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        membertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo", "Aadhar No", "Name", "Mobile No", "Gender", "Date of Birth", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(membertable);
        if (membertable.getColumnModel().getColumnCount() > 0) {
            membertable.getColumnModel().getColumn(0).setMinWidth(30);
            membertable.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        jButton1.setText("Add Members");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("HouseListing Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Final Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        live.setText("LIVE");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("CENSUS INDIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(live)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(487, 487, 487)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(live))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tlive=false;
        hlmodel.setFsNo(membermodel.getRowCount()+1);
        setVisible(false);
        PbtSingleMemberDashBoard nob=new PbtSingleMemberDashBoard(hlmodel,this);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        //setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tlive=false;
        PbtHLDashBoard nob=new PbtHLDashBoard(this,hlmodel);
        setVisible(false);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String msg="Final lock the census of that household.\nThis will be marks based on the final entry of the census.";
        int opt= JOptionPane.showConfirmDialog(null,msg,"Please Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(opt==1)
            return;
        if(!censuscomplete)
        {
            Map<Object,Object> data=new HashMap<>();
            data.put("status","1");
            data.put("HH_SNo",hlmodel.getHhSNo());
            hlmodel.updateQuery(data);
            oneCompleteCensus();
        }
        enumDashBoard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void oneCompleteCensus()
    {
        String query="update pbtempschecdule set formfilled=formfilled+1 where city_vill='"+empdata.getTownvillno()+"'";
        try
        {
            System.err.println(query);
            db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(PbtHLMemberListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHLMemberListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHLMemberListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHLMemberListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel live;
    private javax.swing.JTable membertable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {

        int row=membertable.rowAtPoint(e.getPoint());
        if(row>=0)
        {
            String uid=membermodel.getValueAt(row,1).toString();
            setVisible(false);
            PbtSingleMemberDashBoard nob=new PbtSingleMemberDashBoard(uid,this);
            nob.setLocationRelativeTo(null);
            nob.setVisible(true);
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
