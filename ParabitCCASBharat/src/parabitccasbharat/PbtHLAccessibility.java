/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JRadioButton;
import parabitmodel.PbtHLModel;

/**
 *
 * @author Asus
 */
public class PbtHLAccessibility extends javax.swing.JDialog {

    /**
     * Creates new form PbtHLAccessibility
     */
    PbtHLModel hlmodel;
    PbtHLDashBoard dashBoard;
    public PbtHLAccessibility(PbtHLDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dashBoard=parent;
        this.hlmodel=parent.hlmodel;
        setShowData();
    }

    private void setSelect(String val,JRadioButton r1,JRadioButton r2)
    {
        if(val!=null)
        {
            if(val.equals("y")||val.equals("Y"))
                r1.setSelected(true);
            else if(val.equals("n")||val.equals("N"))
                r2.setSelected(true);
        }
    }
    private String tf(JRadioButton r1,JRadioButton r2)
    {
        String flag="N";
        if(r1.isSelected())
            flag="Y";
        return flag;
    }
    private void setShowData()
    {
        setSelect(hlmodel.getWtrHarv(), w1, w2);
        setSelect(hlmodel.getSwimmingPool(),s1,s2);
        setSelect(hlmodel.getParkingFact(),p1,p2);
        setSelect(hlmodel.getLift(),l1,l2);
        setSelect(hlmodel.getEscalator(),e1,e2);
        setSelect(hlmodel.getHelipad(),h1,h2);
        setSelect(hlmodel.getSmartSecuritySystem(), ss1, ss2);
        dwater.setText(PbtGetterClass.getDrinkWater(hlmodel.getMainSrcDrWater()));
        mlight.setText(PbtGetterClass.getLightSource(hlmodel.getMainSrcLight()));
        alight.setText(PbtGetterClass.getLightSource(hlmodel.getAltSrcOfLight()));
        cctv.setText(hlmodel.getCctvipAdress());
        fire.setText(hlmodel.getFireExtinguisher()+"");

    }
    private void setModel()
    {
        hlmodel.setWtrHarv(tf(w1,w2));
        hlmodel.setSwimmingPool(tf(s1,s2));
        hlmodel.setParkingFact(tf(p1,p2));
        hlmodel.setLift(tf(l1,l2));
        hlmodel.setEscalator(tf(e1,e2));
        hlmodel.setHelipad(tf(h1,h2));
        hlmodel.setSmartSecuritySystem(tf(ss1,ss2));
        hlmodel.setCctvipAdress(cctv.getText());
        hlmodel.setFireExtinguisher(Long.parseLong(fire.getText()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        dwater = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mlight = new javax.swing.JTextField();
        alight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        w1 = new javax.swing.JRadioButton();
        w2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        s1 = new javax.swing.JRadioButton();
        s2 = new javax.swing.JRadioButton();
        p2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        p1 = new javax.swing.JRadioButton();
        l1 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        l2 = new javax.swing.JRadioButton();
        e2 = new javax.swing.JRadioButton();
        e1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        h1 = new javax.swing.JRadioButton();
        h2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        ss1 = new javax.swing.JRadioButton();
        ss2 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        cctv = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fire = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Main Source of Drinking water :");

        dwater.setEditable(false);

        jLabel2.setText("Main Source of Light :");

        mlight.setEditable(false);

        alight.setEditable(false);

        jLabel3.setText("Alternate Source of Light :");

        jLabel4.setText("Water Harversting Facility? :");

        buttonGroup1.add(w1);
        w1.setText("Yes");

        buttonGroup1.add(w2);
        w2.setText("No");

        jLabel5.setText("Swimming Pool Facility Available? :");

        buttonGroup2.add(s1);
        s1.setText("Yes");

        buttonGroup2.add(s2);
        s2.setText("No");

        buttonGroup3.add(p2);
        p2.setText("No");

        jLabel6.setText("Parking Facility Available? :");

        buttonGroup3.add(p1);
        p1.setText("Yes");

        buttonGroup4.add(l1);
        l1.setText("Yes");

        jLabel7.setText("Lift Facility Available? :");

        buttonGroup4.add(l2);
        l2.setText("No");

        buttonGroup5.add(e2);
        e2.setText("No");

        buttonGroup5.add(e1);
        e1.setText("Yes");

        jLabel8.setText("Escalator Facility Available? :");

        jLabel9.setText("Helipad Facility Available? :");

        buttonGroup6.add(h1);
        h1.setText("Yes");

        buttonGroup6.add(h2);
        h2.setText("No");

        jLabel10.setText("Smart Security System Available? :");

        buttonGroup7.add(ss1);
        ss1.setText("Yes");

        buttonGroup7.add(ss2);
        ss2.setText("No");

        jLabel11.setText("Fire Extinguisher Available :");

        jLabel12.setText("Fire Alarm Available? :");

        jRadioButton17.setText("Yes");

        jRadioButton18.setText("No");

        jLabel13.setText("Private Security Guard Available? :");

        jRadioButton19.setText("Yes");

        jRadioButton20.setText("No");

        jLabel14.setText("Bulgar Alarm Available? :");

        jRadioButton21.setText("Yes");

        jRadioButton22.setText("No");

        jLabel15.setText("CCTV IP Address :");

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save and Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Accessibility Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(mlight, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dwater, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alight, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(w1)
                                .addGap(30, 30, 30)
                                .addComponent(w2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s1)
                                .addGap(30, 30, 30)
                                .addComponent(s2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p1)
                                .addGap(30, 30, 30)
                                .addComponent(p2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l1)
                                .addGap(30, 30, 30)
                                .addComponent(l2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(e1)
                                .addGap(30, 30, 30)
                                .addComponent(e2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(h1)
                                .addGap(30, 30, 30)
                                .addComponent(h2)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(ss1)
                                        .addGap(30, 30, 30)
                                        .addComponent(ss2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton19)
                                                .addGap(30, 30, 30)
                                                .addComponent(jRadioButton20))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton21)
                                                .addGap(30, 30, 30)
                                                .addComponent(jRadioButton22))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton17)
                                        .addGap(30, 30, 30)
                                        .addComponent(jRadioButton18)))
                                .addGap(144, 144, 144))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(cctv, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(fire, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(56, 56, 56))))
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(ss1)
                        .addComponent(ss2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dwater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jButton2)
                        .addComponent(fire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(mlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jRadioButton17)
                        .addComponent(jRadioButton18))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(alight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jRadioButton19)
                        .addComponent(jRadioButton20))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(w1)
                        .addComponent(w2)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jRadioButton21)
                        .addComponent(jRadioButton22))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(s1)
                        .addComponent(s2)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cctv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(p1)
                        .addComponent(p2)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(l1)
                    .addComponent(l2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(e1)
                    .addComponent(e2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(h1)
                            .addComponent(h2))
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(78, 78, 78))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PbtHLDialogDrinkWater nob=new PbtHLDialogDrinkWater(dashBoard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        dwater.setText(PbtGetterClass.getDrinkWater(hlmodel.getMainSrcDrWater()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       PbtHLDialogLightSource nob=new PbtHLDialogLightSource(dashBoard, true, 1);
       nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        mlight.setText(PbtGetterClass.getLightSource(hlmodel.getMainSrcLight()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PbtHLDialogLightSource nob=new PbtHLDialogLightSource(dashBoard, true, 2);
       nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        alight.setText(PbtGetterClass.getLightSource(hlmodel.getAltSrcOfLight()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      setModel();
      Map<Object,Object> data=new HashMap<>();
      data.put("mainSrcDrWater",hlmodel.getMainSrcDrWater());
      data.put("mainSrcLight",hlmodel.getMainSrcLight());
      data.put("altSrcOfLight",hlmodel.getAltSrcOfLight());
      data.put("wtrHarv",hlmodel.getWtrHarv());
      data.put("swimmingPool",hlmodel.getSwimmingPool());
      data.put("parkingFact",hlmodel.getParkingFact());
      data.put("lift",hlmodel.getLift());
      data.put("escalator",hlmodel.getEscalator());
      data.put("helipad",hlmodel.getHelipad());
      data.put("smartSecuritySystem",hlmodel.getSmartSecuritySystem());
      data.put("cctvipAdress",hlmodel.getCctvipAdress());
      data.put("fireExtinguisher",hlmodel.getFireExtinguisher());
      data.put("fireAlarm",hlmodel.getFireAlarm());
      data.put("PrivateSecurityGuard",hlmodel.getPrivateSecurityGuard());
      data.put("PrivateLicenseArms",hlmodel.getPrivateLicenseArms());
      data.put("burglarAlarm",hlmodel.getBurglarAlarm());
      hlmodel.updateQuery(data);
      dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PbtHLAccessibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHLAccessibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHLAccessibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHLAccessibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alight;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JTextField cctv;
    private javax.swing.JTextField dwater;
    private javax.swing.JRadioButton e1;
    private javax.swing.JRadioButton e2;
    private javax.swing.JTextField fire;
    private javax.swing.JRadioButton h1;
    private javax.swing.JRadioButton h2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton l1;
    private javax.swing.JRadioButton l2;
    private javax.swing.JTextField mlight;
    private javax.swing.JRadioButton p1;
    private javax.swing.JRadioButton p2;
    private javax.swing.JRadioButton s1;
    private javax.swing.JRadioButton s2;
    private javax.swing.JRadioButton ss1;
    private javax.swing.JRadioButton ss2;
    private javax.swing.JRadioButton w1;
    private javax.swing.JRadioButton w2;
    // End of variables declaration//GEN-END:variables
}
