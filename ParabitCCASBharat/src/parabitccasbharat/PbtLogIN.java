/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Asus
 */
public class PbtLogIN extends javax.swing.JFrame {

    /**
     * Creates new form PbtLogIN
     */
    ParabitDBC db1;
    PbtEmpData empdata;
    
    public PbtLogIN() {
        initComponents();
        setTitle("Parabit CCAS");
        setLocationRelativeTo(null);
        lotp.setVisible(false);
        totp.setVisible(false);
        btnlogin.setVisible(false);
        db1=new ParabitDBC();
    }

    private void fetchAllData()
    {
        try{
            String empname=db1.rs1.getString("EmpName");
            String empdesig=db1.rs1.getString("EmpDesig");
            int grade=db1.rs1.getInt("Grade");
            String empemail=db1.rs1.getString("Email");
            String empcomputerno=db1.rs1.getString("ComputerNo");
            String empid=db1.rs1.getString("CEID");
            String empstate=db1.rs1.getString("areastate");
            String empdist=db1.rs1.getString("areadist");
            String empcity=db1.rs1.getString("areacity");
            empdata=new PbtEmpData(empname,empdesig,grade,empemail,empcomputerno,empid,empstate,empdist,empcity);
            empdata.setEmpcrepempid(db1.rs1.getString("crepempid"));
        }catch(Exception e)
        {
            System.out.println("error in fetchalldata() "+e);
        }
    }
    
    private void crepChange(String note)
    {
        String query="update pbtemployeetable set crepempid='"+empdata.getEmpid()+"' where crepempid='R"+note+"'";
        System.out.println(query);
       try
       {
           db1.stm.execute(query);
           query="update pbtemployeetable set percommt='Trasnferred with "+note+"',note=NULL where ceid='"+empdata.getEmpid()+"'";
           db1.stm.execute(query);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
      /* String msg="Your senior manager have been changed to "+empdata.getEmpname();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(cal.getTime());
       String notify="insert into pbtnotification values ('"+empdata.getEmpid()+"','"+note+"','"+time+"','"+msg+"','0','',NULL,'1')";
       try
       {
        db1.stm.execute(notify);
       }catch(Exception e)
       {
           e.printStackTrace();
       }*/
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tempid = new javax.swing.JTextField();
        temppass = new javax.swing.JTextField();
        lotp = new javax.swing.JLabel();
        totp = new javax.swing.JTextField();
        btnok = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Employee ID : ");

        jLabel2.setText("Employee Password : ");

        temppass.setText("hello@123");

        lotp.setText("OTP : ");

        totp.setText("1601");

        btnok.setText("Submit");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        jLabel4.setText("ParabitCCAS-Bharat Login");

        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(temppass, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lotp)
                        .addGap(86, 86, 86)
                        .addComponent(totp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(tempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(temppass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnok)
                    .addComponent(exit))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lotp))
                    .addComponent(totp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnlogin)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed

        String s1,s2;
        s1=tempid.getText().trim();
        s2=temppass.getText().trim();
        String query="select * from pbtemployeetable where CEID='"+s1+"' and pass='"+s2+"'";
        try
        {
        db1.rs1=db1.stm.executeQuery(query);
        if(db1.rs1.next())
        {
            if(db1.rs1.getString("status").equals("0") ||db1.rs1.getString("status").equals("-1"))
            {
                JOptionPane.showMessageDialog(null,"You are not allowed to login kindly contact your senior","Access Denied",JOptionPane.ERROR_MESSAGE,null);
                return;
            }
        lotp.setVisible(true);
        totp.setVisible(true);
        totp.requestFocus();
        btnlogin.setVisible(true); 
        tempid.setEnabled(false);
        temppass.setEnabled(false);
        btnok.setEnabled(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid credentials","Authentication Error",JOptionPane.ERROR_MESSAGE,null);
            temppass.setText("");
            temppass.requestFocus();
        }
        }catch(Exception e)
        {
            System.out.println("Error on otp disp "+e);
        }
        System.out.println(query);
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnokActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String s1,s2,s3;
        s1=tempid.getText().trim();
        s2=temppass.getText().trim();
        s3=totp.getText().trim();
        String query="select * from pbtemployeetable where CEID='"+s1+"' and pass='"+s2+"' and otp='"+s3+"'";
        try
        {
        db1.rs1=db1.stm.executeQuery(query);
        if(db1.rs1.next())
        {
            fetchAllData();
            String note=db1.rs1.getString("note");
            if(note!=null)
            {
                crepChange(note);
            }
            setVisible(false);
            totp.setEnabled(false);
            btnlogin.setEnabled(false);
            PbtLogInAll ob=new PbtLogInAll(this,empdata);
            ob.setVisible(true);
            //setVisible(true);
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You entered wrong OTP","Authentication Error",JOptionPane.ERROR_MESSAGE,null);
            totp.setText("");
        }
        }catch(Exception e)
        {
            System.out.println("Error on otp disp "+e);
        }
        System.out.println(query);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnloginActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(PbtLogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtLogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtLogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtLogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PbtLogIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnok;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lotp;
    private javax.swing.JTextField tempid;
    private javax.swing.JTextField temppass;
    private javax.swing.JTextField totp;
    // End of variables declaration//GEN-END:variables
}
