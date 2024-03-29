/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class PbtMessageFrame extends javax.swing.JDialog {

    /**
     * Creates new form PbtMessageFrame
     */
    String ceid;
    PbtEmpDashBoard pbtempdashboard;
    ParabitDBC db;
    int framecheck;//1--- individual 2--lower chain
    String enddate;
    public PbtMessageFrame(PbtEmpDashBoard parent, boolean modal,int framecheck) {
        super(parent, modal);
        initComponents();
        setTitle("Notification Pane");
        this.pbtempdashboard=parent;
        this.framecheck=framecheck;
        db=new ParabitDBC();
        if(framecheck==1){
            datechooser.setVisible(false);
            datechooserlabel.setVisible(false);
        }
        messagearea.requestFocus();
    }

    public void setName(String ceid,String name)
    {
        this.ceid=ceid;
        namelabel.setText("You are sending notification to "+name);
    }
    private void sendNotification()
    {
        if(framecheck==2 || framecheck==3){
        if(datechooser.getDate()==null){
              JOptionPane.showMessageDialog(null,"Please select end date of this notification.","End Date",JOptionPane.ERROR_MESSAGE);
              return;
          }else
          {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String time=sdf.format(cal.getTime());
                enddate=sdf.format(datechooser.getDate());
                int flag=enddate.compareTo(time);
                if(flag<0){
                    JOptionPane.showMessageDialog(null,"Notification can't be issued in back date.","End Date",JOptionPane.ERROR_MESSAGE);
                    return;
                }
          }
        }
        enddate=enddate+" 23:59:59";
        String notify="";
        String msg=messagearea.getText().trim();
        if(msg.isEmpty())
        {
         JOptionPane.showMessageDialog(null,"Please enter some message");   
        }else{
        String senderceid=pbtempdashboard.empdata.getEmpid();
        if(framecheck==1)
            notify="insert into pbtnotification values ('"+senderceid+"','"+ceid+"',now(),'"+msg+"',0,NULL,NULL,'1')";
        else if(framecheck==2)
            notify="insert into pbtnotification values ('"+senderceid+"','"+ceid+"',now(),'"+msg+"',0,'"+enddate+"',NULL,'2')";
        else if(framecheck==3)
            notify="insert into pbtnotification values ('"+senderceid+"','"+"Common"+"',now(),'"+msg+"',0,'"+enddate+"',NULL,'3')";
        try
        {
            System.out.println(notify);
            db.stm.execute(notify);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        System.out.println(notify);
        JOptionPane.showMessageDialog(null,"Message Sent Sucessfully");
        dispose();
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
        messagearea = new javax.swing.JTextArea();
        namelabel = new javax.swing.JLabel();
        sendbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        datechooserlabel = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        messagearea.setColumns(20);
        messagearea.setRows(5);
        jScrollPane1.setViewportView(messagearea);

        namelabel.setText("jLabel1");

        sendbtn.setText("Send Notification");
        sendbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbtnActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        datechooserlabel.setText("Select End Date :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(namelabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datechooserlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(596, Short.MAX_VALUE)
                .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(namelabel)
                        .addComponent(datechooserlabel))
                    .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbtnActionPerformed
      if(framecheck==1)
      {
          System.out.println("This is an individual message");
          sendNotification();
          
      }else if(framecheck==2)
      {
          System.out.println("This is a lower chain message");
          sendNotification();
      }else if(framecheck==3)
      {
          System.out.println("This is a common message");
          sendNotification();
      }
    }//GEN-LAST:event_sendbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        messagearea.setText("");
    }//GEN-LAST:event_clearbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JLabel datechooserlabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messagearea;
    private javax.swing.JLabel namelabel;
    private javax.swing.JButton sendbtn;
    // End of variables declaration//GEN-END:variables
}
