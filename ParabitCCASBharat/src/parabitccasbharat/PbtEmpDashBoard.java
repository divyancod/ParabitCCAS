/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class PbtEmpDashBoard extends javax.swing.JFrame {

    /**
     * Creates new form PbtEmpDashBoard
     */
    PbtEmpData empdata;
    ParabitDBC db;
    public PbtEmpDashBoard(PbtEmpData empdata) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Employee Dashboard");
        this.empdata=empdata;
        tfname.setText(empdata.getEmpname());
        db=new ParabitDBC();
        getNotifications();
        notification.setEnabled(false);
    }

    /*private void getNotifications()
    {
        DefaultTableModel ob=new DefaultTableModel();
        ob=(DefaultTableModel)notification.getModel();
        ob.setRowCount(0);
        try
        {
            //String query="select * from pbtnotification where recieverceid='"+empdata.getEmpid()+"'";
            String query="SELECT * FROM `pbtnotification` WHERE NotType='3' or RecieverCeId='"+empdata.getEmpid()+"' or RecieverCeId='"+empdata.getEmpcrepempid()+"' and NotType='2'";
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
             Object obj[]={db.rs1.getString("notid"),db.rs1.getString("senderceid"),db.rs1.getString("time"),db.rs1.getString("Message")};
             ob.addRow(obj);
            }   
        }catch(Exception e)
        {
            System.out.println("Error in notification fetch"+e);
        }  
    }*/
        private void getNotifications()
    {
        DefaultTableModel ob=new DefaultTableModel();
        ob=(DefaultTableModel)notification.getModel();
        ob.setRowCount(0);
        String currentempid=empdata.getEmpid();
        try
        {
            //String query="select * from pbtnotification where recieverceid='"+pbtempdashboard.empdata.getEmpid()+"' or senderceid='"+pbtempdashboard.empdata.getEmpid()+"'";
            String query="select * from pbtnotification where RecieverCeId='"+currentempid+"'";
            int grade=empdata.getEmpgrade();
            switch(grade)
            {
                case 2: query=query+"or SenderCeId=(select crepempid from pbtemployeetable where ceid='"+currentempid+"') and NotType='3'";
                        break;
    //select * from pbtnotification where RecieverCeId='31658' or SenderCeId=(select crepempid from pbtemployeetable where ceid='31658') and NotType='2' or SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='31658')) and NotType='3'
                case 3: query=query+"or SenderCeId=(select crepempid from pbtemployeetable where ceid='"+currentempid+"') and (NotType='2' or NotType='3') or SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='"+currentempid+"')) and NotType='3'";
                        break;
                case 4: query=query+"or (SenderCeId=(select crepempid from pbtemployeetable where ceid='"+currentempid+"') and (NotType='2' or NotType='3')) or (SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='"+currentempid+"')) and (NotType='2' or NotType='3')) or (SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='"+currentempid+"'))) and (NotType='3'))";
    //select * from pbtnotification where RecieverCeId='41687' or (SenderCeId=(select crepempid from pbtemployeetable where ceid='41687') and (NotType='2' or NotType='3')) or (SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='41687')) and (NotType='2' or NotType='3')) or (SenderCeId=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid=(select crepempid from pbtemployeetable where ceid='41687'))) and (NotType='3'))                    
                        break;  
            }
            query=query+" ORDER BY time DESC";
            String type="";
            String status="";
            String sender="";
            System.out.println(query);
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                char senderchar=db.rs1.getString("senderceid").charAt(0);
                switch (senderchar) {
                    case '1':
                        sender="Census Commissioner";
                        break;
                    case '2':
                        if(db.rs1.getString("senderceid").equals("200"))
                            sender="Home Ministry";
                        else
                            sender="Director of Census Operations";
                        break;
                    case '3':
                        sender="Principle Charge Officer";
                        break;
                    default:
                        sender="Charge Officer";
                        break;
                }
                type=db.rs1.getString("NotType");
                if(type.equals("1"))
                    type="Individual";
                else if(type.equals("2"))
                    type="Lower Chain";
                else if(type.equals("3"))
                    type="General";
                if(db.rs1.getString("senderceid").equals(currentempid))
                    status="Sent";
                else
                    status="Received";
             Object obj[]={db.rs1.getString("notid"),sender,status,db.rs1.getString("time"),db.rs1.getString("Message"),type};
             ob.addRow(obj);
            }   
        }catch(Exception e)
        {
            System.out.println("Error in notification fetch"+e);
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

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnlogout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        notification = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn1.setText("Manage Employee");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("Work Assignment");

        btn3.setText("Notifications");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText("Employee Summary");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("Census Summary");

        jLabel1.setText("Username : ");

        tfname.setText("Mr.Name");

        jLabel2.setText("PARABIT CCAS-BHARAT");

        jLabel3.setText("Notification : ");

        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        notification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Notification ID", "SenderCEID", "Status", "Time", "Message", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(notification);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)))
                .addGap(127, 127, 127))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfname)
                    .addComponent(btnlogout))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed

        PbtLogIN ob=new PbtLogIN();
        ob.setVisible(true);
        dispose();
                // TODO add your handling code here:
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

        setVisible(false);
        PbtManageEmployee ob=new PbtManageEmployee(this,true);
        ob.setVisible(true);
        setVisible(true);
        //setVisible(true);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed

        setVisible(false);
        PbtEmployeeSummary nob=new PbtEmployeeSummary(this,true,1);
        nob.setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        setVisible(false);
        PbtNotification nob=new PbtNotification(this,true);
        nob.setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_btn3ActionPerformed

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
            java.util.logging.Logger.getLogger(PbtEmpDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtEmpDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtEmpDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtEmpDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btnlogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable notification;
    private javax.swing.JLabel tfname;
    // End of variables declaration//GEN-END:variables
}
