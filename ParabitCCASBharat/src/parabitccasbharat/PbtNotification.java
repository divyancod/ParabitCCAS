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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtNotification extends javax.swing.JDialog implements ItemListener,MouseListener{

    /**
     * Creates new form PbtNotification
     */
    ParabitDBC db;
    PbtEmpDashBoard pbtempdashboard;
    DefaultComboBoxModel seniorcombomodel;
    ArrayList<String> senior;
    DefaultTableModel ob;
    public PbtNotification(PbtEmpDashBoard parent, boolean modal) {
        super(parent, modal);      
        initComponents();
        setLocationRelativeTo(null);
        db=new ParabitDBC();
        this.pbtempdashboard=parent;
        ob=new DefaultTableModel();
        ob=(DefaultTableModel)notification.getModel();
        getNotifications();
        senior=new ArrayList<String>();
        seniorcombomodel=(DefaultComboBoxModel)seniorcombo.getModel();
        seniorMessage();
        seniorcombo.addItemListener(this);
        notification.addMouseListener(this);
    }
    private void getNotifications()
    {
        
        ob.setRowCount(0);
        String currentempid=pbtempdashboard.empdata.getEmpid();
        try
        {
            //String query="select * from pbtnotification where recieverceid='"+pbtempdashboard.empdata.getEmpid()+"' or senderceid='"+pbtempdashboard.empdata.getEmpid()+"'";
            String query="select * from pbtnotification where RecieverCeId='"+currentempid+"'or senderceid='"+currentempid+"'";
            int grade=pbtempdashboard.empdata.getEmpgrade();
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
                if(senderchar=='1')
                    sender="Census Commissioner";
                else if(senderchar=='2')
                {
                    if(db.rs1.getString("senderceid").equals("200"))
                        sender="Home Ministry";
                    else
                        sender="Director of Census Operations";
                }
                else if(senderchar=='3')
                    sender="Principle Charge Officer";
                else
                    sender="Charge Officer";
                type=db.rs1.getString("NotType");
                if(type.equals("1"))
                    type="Individual";
                else if(type.equals("2"))
                    type="Lower Chain";
                else if(type.equals("3"))
                    type="General";
                if(db.rs1.getString("senderceid").equals(currentempid))
                    status="Sent to "+db.rs1.getString("RecieverCeId");
                else
                    status="Received from "+db.rs1.getString("RecieverCeId");
             Object obj[]={db.rs1.getString("notid"),sender,status,db.rs1.getString("time"),db.rs1.getString("Message"),type};
             ob.addRow(obj);
            }   
        }catch(Exception e)
        {
            System.out.println("Error in notification fetch"+e);
        }
        
    }
    private void seniorMessage()
    {
       seniorcombomodel.removeAllElements();
       seniorcombomodel.addElement("Select Senior");
       String post="";
       String currentceid=pbtempdashboard.empdata.getEmpid();
       String query="select CRepEmpID from pbtemployeetable where CEID='"+currentceid+"' or CEID=(select CRepEmpID from pbtemployeetable where CEID='"+currentceid+"') or CEID=(select CRepEmpID from pbtemployeetable where CEID=(select CRepEmpID from pbtemployeetable where CEID='"+currentceid+"')) or Ceid=(select CRepEmpID from pbtemployeetable where CEID=(select CRepEmpID from pbtemployeetable where CEID=(select CRepEmpID from pbtemployeetable where CEID='"+currentceid+"')))";
       try
       {
           System.out.println(query);
           db.rs1=db.stm.executeQuery(query);
           while(db.rs1.next())
           {
               post=db.rs1.getString("crepempid");
               char senderchar=post.charAt(0);
               if(senderchar=='1')
                    post="Census Commissioner";
                else if(senderchar=='2')
                {
                        post="Director of Census Operations";
                }
                else if(senderchar=='3')
                    post="Principle Charge Officer";
                else if(senderchar=='4')
                    post="Charge Officer";
                else 
                    post="HomeMinister";
               seniorcombomodel.addElement(post);
               senior.add(db.rs1.getString("crepempid"));
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notification = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        seniorcombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup2.add(r1);
        r1.setText("Individual Message");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(r2);
        r2.setText("Lower Chain Message");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(r3);
        r3.setText("Common Notification");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Send Notification Area");

        notification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Notification ID", "Sender", "Status", "Time", "Message", "Type"
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
        if (notification.getColumnModel().getColumnCount() > 0) {
            notification.getColumnModel().getColumn(0).setMinWidth(80);
            notification.getColumnModel().getColumn(0).setMaxWidth(85);
            notification.getColumnModel().getColumn(1).setMinWidth(150);
            notification.getColumnModel().getColumn(1).setMaxWidth(160);
            notification.getColumnModel().getColumn(2).setMinWidth(210);
            notification.getColumnModel().getColumn(2).setMaxWidth(220);
            notification.getColumnModel().getColumn(3).setMinWidth(160);
            notification.getColumnModel().getColumn(3).setMaxWidth(170);
            notification.getColumnModel().getColumn(5).setMinWidth(75);
            notification.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jLabel2.setText("Send Message to Senior");

        seniorcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seniorcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seniorcomboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(r1)
                                .addGap(180, 180, 180)
                                .addComponent(r2)
                                .addGap(206, 206, 206)
                                .addComponent(r3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seniorcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1)
                    .addComponent(r2)
                    .addComponent(r3)
                    .addComponent(seniorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        setVisible(false);
        PbtEmployeeSummary nob=new PbtEmployeeSummary(pbtempdashboard, true,2);
        nob.setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        setVisible(false);
        PbtAppointedEmployee nob=new PbtAppointedEmployee(pbtempdashboard, true,2);
        nob.setVisible(true);
        setVisible(true);
    }//GEN-LAST:event_r2ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        PbtMessageFrame nob=new PbtMessageFrame(pbtempdashboard, true, 3);
        nob.setLocationRelativeTo(null);
        nob.setName("common","common");
        nob.setVisible(true);
    }//GEN-LAST:event_r3ActionPerformed

    private void seniorcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seniorcomboActionPerformed

    }//GEN-LAST:event_seniorcomboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable notification;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JComboBox<String> seniorcombo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
       System.out.println(seniorcombo.getSelectedIndex());
       System.out.println(senior.get(seniorcombo.getSelectedIndex()-1));
       String sending=senior.get(seniorcombo.getSelectedIndex()-1);
       if(e.getStateChange() == ItemEvent.SELECTED)
       {
       PbtMessageFrame nob=new PbtMessageFrame(pbtempdashboard, true, 1);
       nob.setName(sending,seniorcombomodel.getSelectedItem().toString());
       nob.setLocationRelativeTo(null);
       nob.setVisible(true);
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==notification)
        {
            int row=notification.rowAtPoint(e.getPoint());
            JOptionPane.showMessageDialog(null,ob.getValueAt(row, 4));
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
