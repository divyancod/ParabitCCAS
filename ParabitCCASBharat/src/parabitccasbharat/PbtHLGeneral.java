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
public class PbtHLGeneral extends javax.swing.JDialog {

    /**
     * Creates new form PbtHLGeneral
     */
    PbtHLDashBoard dashBoard;
    PbtHLModel hlmodel;
    public PbtHLGeneral(PbtHLDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dashBoard=parent;
        this.hlmodel=parent.hlmodel;
        setShowData();
    }
    private void setShowData()
    {
        setSelect(hlmodel.getFirstAidKit(), fkit1, fkit2);
        setSelect(hlmodel.getHInsu(), hins1, hins2);
        setSelect(hlmodel.getLInsu(), linsu1, linsu2);
        setSelect(hlmodel.getGInsu(), ginsu1, ginsu2);
        setSelect(hlmodel.getCourtCase(), ccase1, ccase2);
        setSelect(hlmodel.getFinCase(), fcase1, fcase2);
        setSelect(hlmodel.getForeignDispute(), fdisp1, fdisp2);
        gendisease.setText(PbtGetterClass.getGeneticDisease(hlmodel.getGenDiss()));
        nhospdist.setText(hlmodel.getNHospDist());
        death.setText(hlmodel.getDeathin10Years()+"");
        rdeath.setText(hlmodel.getReasonOfDeath());
        deathage.setText(hlmodel.getDeathAgeGroup());
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
    private void setModel()
    {
        hlmodel.setFirstAidKit(tf(fkit1,fkit2));
        hlmodel.setHInsu(tf(hins1, hins2));
        hlmodel.setLInsu(tf(linsu1, linsu2));
        hlmodel.setGInsu(tf(ginsu1, ginsu2));
        hlmodel.setCourtCase(tf(ccase1, ccase2));
        hlmodel.setFinCase(tf(fcase1,fcase2));
        hlmodel.setForeignDispute(tf(fdisp1,fdisp2));
        hlmodel.setNHospDist(nhospdist.getText());
        hlmodel.setDeathin10Years(Long.parseLong(death.getText()));
        hlmodel.setReasonOfDeath(rdeath.getText());
        hlmodel.setDeathAgeGroup(deathage.getText());
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
        ccase1 = new javax.swing.JRadioButton();
        fkit2 = new javax.swing.JRadioButton();
        ccase2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hins1 = new javax.swing.JRadioButton();
        fcase1 = new javax.swing.JRadioButton();
        hins2 = new javax.swing.JRadioButton();
        fcase2 = new javax.swing.JRadioButton();
        linsu2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        linsu1 = new javax.swing.JRadioButton();
        fdisp2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        fdisp1 = new javax.swing.JRadioButton();
        ginsu2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ginsu1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        fkit1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        nhospdist = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        death = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdeath = new javax.swing.JTextField();
        deathage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        gendisease = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup5.add(ccase1);
        ccase1.setText("Yes");

        buttonGroup1.add(fkit2);
        fkit2.setText("No");

        buttonGroup5.add(ccase2);
        ccase2.setText("No");

        jLabel2.setText("Health Insurance of Individual? :");

        jLabel5.setText("Any Court Case on family? :");

        buttonGroup2.add(hins1);
        hins1.setText("Yes");

        buttonGroup6.add(fcase1);
        fcase1.setText("Yes");

        buttonGroup2.add(hins2);
        hins2.setText("No");

        buttonGroup6.add(fcase2);
        fcase2.setText("No");

        buttonGroup3.add(linsu2);
        linsu2.setText("No");

        jLabel6.setText("Any Financial Case? :");

        buttonGroup3.add(linsu1);
        linsu1.setText("Yes");

        buttonGroup7.add(fdisp2);
        fdisp2.setText("No");

        jLabel3.setText("Life Insurance of Individual? :");

        buttonGroup7.add(fdisp1);
        fdisp1.setText("Yes");

        buttonGroup4.add(ginsu2);
        ginsu2.setText("No");

        jLabel7.setText("Any Foreign Dispute in Family? :");

        jLabel1.setText("FirstAid Kit Available? :");

        buttonGroup4.add(ginsu1);
        ginsu1.setText("Yes");

        jLabel4.setText("General Insurance of Individual? :");

        buttonGroup1.add(fkit1);
        fkit1.setText("Yes");

        jLabel8.setText("Nearest Hospital Distance :");

        jLabel9.setText("Death in Past 10 years :");

        jLabel10.setText("Reason of Death :");

        jLabel11.setText("Death Age Group :");

        jLabel12.setText("Genetic Disease in Family :");

        gendisease.setEditable(false);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save and Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("General Information ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fdisp1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fdisp2))
                                    .addComponent(nhospdist, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(death, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(ginsu1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ginsu2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(hins1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hins2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(linsu1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(linsu2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(ccase1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ccase2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(fcase1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fcase2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdeath, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(deathage, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fkit1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fkit2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gendisease, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(gendisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fkit1)
                    .addComponent(fkit2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hins1)
                    .addComponent(hins2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(linsu1)
                    .addComponent(linsu2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ginsu1)
                    .addComponent(ginsu2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ccase1)
                    .addComponent(ccase2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fcase1)
                    .addComponent(fcase2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fdisp1)
                    .addComponent(fdisp2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nhospdist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(death, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(deathage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PbtHLDialogGeneticDisease nob=new PbtHLDialogGeneticDisease(dashBoard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        gendisease.setText(PbtGetterClass.getGeneticDisease(hlmodel.getGenDiss()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setModel();
        Map<Object,Object> data=new HashMap<>();
        data.put("genDiss",hlmodel.getGenDiss());
        data.put("firstAidKit",hlmodel.getFirstAidKit());
        data.put("h_Insu",hlmodel.getHInsu());
        data.put("l_Insu",hlmodel.getLInsu());
        data.put("g_Insu",hlmodel.getGInsu());
        data.put("nHospDist",hlmodel.getNHospDist());
        data.put("deathin10Years",hlmodel.getDeathin10Years());
        data.put("reasonOfDeath",hlmodel.getReasonOfDeath());
        data.put("deathAgeGroup",hlmodel.getDeathAgeGroup());
        data.put("courtCase",hlmodel.getCourtCase());
        data.put("finCase",hlmodel.getFinCase());
        data.put("foreignDispute",hlmodel.getForeignDispute());
        hlmodel.updateQuery(data);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PbtHLGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHLGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHLGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHLGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JRadioButton ccase1;
    private javax.swing.JRadioButton ccase2;
    private javax.swing.JTextField death;
    private javax.swing.JTextField deathage;
    private javax.swing.JRadioButton fcase1;
    private javax.swing.JRadioButton fcase2;
    private javax.swing.JRadioButton fdisp1;
    private javax.swing.JRadioButton fdisp2;
    private javax.swing.JRadioButton fkit1;
    private javax.swing.JRadioButton fkit2;
    private javax.swing.JTextField gendisease;
    private javax.swing.JRadioButton ginsu1;
    private javax.swing.JRadioButton ginsu2;
    private javax.swing.JRadioButton hins1;
    private javax.swing.JRadioButton hins2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton linsu1;
    private javax.swing.JRadioButton linsu2;
    private javax.swing.JTextField nhospdist;
    private javax.swing.JTextField rdeath;
    // End of variables declaration//GEN-END:variables
}
