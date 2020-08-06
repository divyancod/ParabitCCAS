/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import ParabitModel.PbtHHModel;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Asus
 */
public class PbtSingleMemberDashBoard extends javax.swing.JFrame {

    /**
     * Creates new form ParabitSingleMemberDashBoard
     */
    ParabitDBC db;
    PbtHHModel hhmodel;
    public PbtSingleMemberDashBoard() {
        initComponents();
        db=new ParabitDBC("util");
        basic.setEnabled(false);
        education.setEnabled(false);
        work.setEnabled(false);
        bank.setEnabled(false);
        medical.setEnabled(false);
        other.setEnabled(false);
        aadhartf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String adhr=aadhartf.getText();
                if(adhr.length()==12)
                {
                    setFetchData(adhr);
                    Border border = BorderFactory.createLineBorder(Color.green, 2);
                    aadhartf.setBorder(border);
                }
                else
                {
                    Border border = BorderFactory.createLineBorder(Color.red, 2);
                    aadhartf.setBorder(border);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    
    private void setFetchData(String adhr)
    {
        fullnametf.setText("");
        pancardno.setText("");
        dlno.setText("");
        disabilityno.setText("");
        rationcardno.setText("");
        marriageno.setText("");
        policeno.setText("");
        armsno.setText("");
        gasno.setText("");
        passportno.setText("");
        hhmodel=new PbtHHModel();
        hhmodel.fetchAllData(adhr);
        fullnametf.setText(hhmodel.getName());
        pancardno.setText(hhmodel.getPanCardNo());
        dlno.setText(hhmodel.getDrivLicNo());
        disabilityno.setText(hhmodel.getPwdid());
        rationcardno.setText(hhmodel.getRCardNo());
        marriageno.setText(hhmodel.getMarrCertNo());
        policeno.setText(hhmodel.getPoliceVerNo());
        armsno.setText(hhmodel.getArmsUiNo());
        gasno.setText(hhmodel.getGConsumerNo());
        passportno.setText(hhmodel.getPassport());
        rationcardtype.setText(hhmodel.getRCardType());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        aadhartf = new javax.swing.JTextField();
        fullnametf = new javax.swing.JTextField();
        pancardno = new javax.swing.JTextField();
        birthno = new javax.swing.JTextField();
        marriageno = new javax.swing.JTextField();
        policeno = new javax.swing.JTextField();
        armsno = new javax.swing.JTextField();
        dlno = new javax.swing.JTextField();
        disabilityno = new javax.swing.JTextField();
        gasno = new javax.swing.JTextField();
        passportno = new javax.swing.JTextField();
        rationcardno = new javax.swing.JTextField();
        scanbtn = new javax.swing.JButton();
        basic = new javax.swing.JButton();
        work = new javax.swing.JButton();
        education = new javax.swing.JButton();
        bank = new javax.swing.JButton();
        medical = new javax.swing.JButton();
        other = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rationcardtype = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Aadhar No :");

        jLabel2.setText("Birth Certificate No :");

        jLabel3.setText("Disability :");

        jLabel4.setText("Gas ID :");

        jLabel5.setText("Marriage Certificate No :");

        jLabel6.setText("Pan Card Number :");

        jLabel8.setText("Police Verification No :");

        jLabel9.setText("Ration Card No :  ");

        jLabel10.setText("Arms or License No :");

        jLabel11.setText("Driving License No :");

        jLabel12.setText("Passport No :");

        jLabel13.setText("Full Name :");

        scanbtn.setText("Scan Aadhar");
        scanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanbtnActionPerformed(evt);
            }
        });

        basic.setText("Basic Details");
        basic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicActionPerformed(evt);
            }
        });

        work.setText("Work Details");
        work.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workActionPerformed(evt);
            }
        });

        education.setText("Educational Details");
        education.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                educationActionPerformed(evt);
            }
        });

        bank.setText("Bank Details");
        bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankActionPerformed(evt);
            }
        });

        medical.setText("Medical Details");
        medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalActionPerformed(evt);
            }
        });

        other.setText("Other Details");

        jButton8.setText("Save Details");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Save And Proceed");

        jLabel7.setText("Ration Card Type :");

        jButton1.setText("Record This Entry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(other, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(education, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(106, 106, 106)
                                        .addComponent(medical, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addComponent(aadhartf, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(scanbtn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(passportno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disabilityno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dlno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pancardno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullnametf, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rationcardno, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(birthno, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(marriageno, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(policeno, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(armsno, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(gasno, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(rationcardtype))
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(marriageno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(policeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(armsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(passportno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(gasno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(birthno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(aadhartf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scanbtn)
                            .addComponent(jButton1))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(fullnametf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pancardno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dlno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(disabilityno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rationcardno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(rationcardtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(education, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medical, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(other, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       String adhrno=aadhartf.getText();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void scanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanbtnActionPerformed
        
        final Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						try (QRCapture qr = new QRCapture()) {
                                                    getAadhar(qr.getResult());
                                                    qr.close();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					};
				});
				thread.setDaemon(true);
				thread.start();
    }//GEN-LAST:event_scanbtnActionPerformed

    private void basicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicActionPerformed

        PbtHHBasicDetails nob=new PbtHHBasicDetails(this, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_basicActionPerformed

    private void workActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workActionPerformed
        PbtHHWorkDetails nob=new PbtHHWorkDetails(this, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_workActionPerformed

    private void medicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalActionPerformed
        PbtHHMedicalDetails nob=new PbtHHMedicalDetails(this, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_medicalActionPerformed

    private void educationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_educationActionPerformed
        PbtHHEducationDetails nob=new PbtHHEducationDetails(this, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_educationActionPerformed

    private void bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankActionPerformed
        PbtHHBankDetails nob=new PbtHHBankDetails(this,true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
    }//GEN-LAST:event_bankActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(!fullnametf.getText().isEmpty())
        {
            setModelData();
            basic.setEnabled(true);
            education.setEnabled(true);
            work.setEnabled(true);
            bank.setEnabled(true);
            medical.setEnabled(true);
            other.setEnabled(true);
             Map<Object,Object> data=new HashMap();
            data.put("rcardno",hhmodel.getRCardNo());
            data.put("rcardtype",hhmodel.getRCardType());
            data.put("uid",hhmodel.getUid());
            data.put("gconsumerNo",hhmodel.getGConsumerNo());
            data.put("drivlicno",hhmodel.getDrivLicNo());
            data.put("armsuino",hhmodel.getArmsUiNo());
            data.put("birthcertno",hhmodel.getBirthCertNo());
            data.put("marrcertno",hhmodel.getMarrCertNo());
            data.put("policeverno",hhmodel.getPoliceVerNo());
            data.put("name",hhmodel.getName());
            data.put("passport",hhmodel.getPassport());
            data.put("pancardno",hhmodel.getPanCardNo());
            data.put("pwdid",hhmodel.getPwdid());
            hhmodel.myInsert(data);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setModelData()
    {
        hhmodel.setRCardNo(rationcardno.getText());
        hhmodel.setRCardType(rationcardtype.getText());
        hhmodel.setUid(aadhartf.getText());
        hhmodel.setGConsumerNo(gasno.getText());
        hhmodel.setDrivLicNo(dlno.getText());
        hhmodel.setArmsUiNo(armsno.getText());
        hhmodel.setBirthCertNo(birthno.getText());
        hhmodel.setMarrCertNo(marriageno.getText());
        hhmodel.setPoliceVerNo(policeno.getText());
        hhmodel.setName(fullnametf.getText());
       // hhmodel.setVid(v);
       hhmodel.setPassport(passportno.getText());
       hhmodel.setPanCardNo(pancardno.getText());
       hhmodel.setPwdid(disabilityno.getText());
    }
    private void getAadhar(String text) {
        System.out.println(text);
        String adhrno="";
        Pattern pattern= Pattern.compile("[0-9]{12}");
        Matcher m=pattern.matcher(text);
        if(m.find())
        {
            System.out.println(""+m.group(0));
            adhrno=m.group(0);
            aadhartf.setText(""+adhrno);
            //fetchAadhardata(adhrno);
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
            java.util.logging.Logger.getLogger(PbtSingleMemberDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtSingleMemberDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtSingleMemberDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtSingleMemberDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PbtSingleMemberDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aadhartf;
    private javax.swing.JTextField armsno;
    private javax.swing.JButton bank;
    private javax.swing.JButton basic;
    private javax.swing.JTextField birthno;
    private javax.swing.JTextField disabilityno;
    private javax.swing.JTextField dlno;
    private javax.swing.JButton education;
    private javax.swing.JTextField fullnametf;
    private javax.swing.JTextField gasno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JTextField marriageno;
    private javax.swing.JButton medical;
    private javax.swing.JButton other;
    private javax.swing.JTextField pancardno;
    private javax.swing.JTextField passportno;
    private javax.swing.JTextField policeno;
    private javax.swing.JTextField rationcardno;
    private javax.swing.JTextField rationcardtype;
    private javax.swing.JButton scanbtn;
    private javax.swing.JButton work;
    // End of variables declaration//GEN-END:variables
}
