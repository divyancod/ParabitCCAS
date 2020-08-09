/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import ParabitModel.PbtHHModel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Asus
 */
public class PbtHHMedicalDetails extends javax.swing.JDialog {

    /**
     * Creates new form PbtHHMedicalDetails
     */
    PbtSingleMemberDashBoard dashBoard;
    PbtHHModel hhmodel;
    public PbtHHMedicalDetails(PbtSingleMemberDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dashBoard=parent;
        this.hhmodel=parent.hhmodel;
        getModelData();
        nametf.setText(hhmodel.getName());
        weight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calBMI();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calBMI();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        height.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calBMI();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calBMI();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    
    private void getModelData()
    {
        weight.setText(hhmodel.getWt()+"");
        height.setText(hhmodel.getHt()+"");
        if(hhmodel.getVeg()!=null)
        {
        if(hhmodel.getVeg().equals("Y"))
            veg1.setSelected(true);
        else if(hhmodel.getVeg().equals("N"))
            veg2.setSelected(true);
        }
        if(hhmodel.getHomeFood()!=null)
            homefood.setValue(Integer.parseInt(hhmodel.getHomeFood()));
        if(hhmodel.getOutsideFood()!=null)
            outsidefood.setValue(Integer.parseInt(hhmodel.getOutsideFood()));
        if(hhmodel.getSleepHrs()!=null)
            sleep.setValue(Integer.parseInt(hhmodel.getSleepHrs()));
        if(hhmodel.getHealthCheckup()!=null)
            checkup.setValue(Integer.parseInt(hhmodel.getHealthCheckup()));
        if(hhmodel.getAddiction()!=null)
        {
        if(hhmodel.getAddiction().equals("Y"))
                add1.setSelected(true);
        else if(hhmodel.getAddiction().equals("N"))
            add2.setSelected(true);
        }
        bmi.setText(hhmodel.getBmi()+"");
        steamcellid.setText(hhmodel.getStemCellId());
        bloodgroup.setText(hhmodel.getBGroup());
        if(hhmodel.getPwd()!=null)
        {
        if(hhmodel.getPwd().equals("Y"))
                pwd1.setSelected(true);
        else if(hhmodel.getPwd().equals("N"))
            pwd2.setSelected(true);
        }
        chronicdisease.setText(hhmodel.getChronicDisease());
        sports.setText(hhmodel.getSport());
        if(hhmodel.getYoga()!=null)
            yoga.setValue(Integer.parseInt(hhmodel.getYoga()));
        if(hhmodel.getSpiritual()!=null)
            spritual.setValue(Integer.parseInt(hhmodel.getSpiritual()));
        if(hhmodel.getMeditation()!=null)
            meditation.setValue(Integer.parseInt(hhmodel.getMeditation()));
        rateofhealth.setValue((int)hhmodel.getRatYourHealth());
    }

    private void setModel()
    {
        hhmodel.setWt(Double.parseDouble(weight.getText()));
        hhmodel.setHt(Double.parseDouble(height.getText()));
        hhmodel.setBmi(Double.parseDouble(bmi.getText()));
        hhmodel.setStemCellId(steamcellid.getText());
        hhmodel.setBGroup(bloodgroup.getText());
        hhmodel.setChronicDisease(chronicdisease.getText());
        hhmodel.setSport(sports.getText());
        if(pwd1.isSelected())
            hhmodel.setPwd("Y");
        else if(pwd2.isSelected())
            hhmodel.setPwd("N");
        if(veg1.isSelected())
            hhmodel.setVeg("Y");
        else if(veg2.isSelected())
            hhmodel.setVeg("N");
        if(add1.isSelected())
            hhmodel.setAddiction("Y");
        else if(add2.isSelected())
            hhmodel.setAddiction("N");
        hhmodel.setHomeFood(homefood.getValue()+"");
        hhmodel.setOutsideFood(outsidefood.getValue()+"");
        hhmodel.setSleepHrs(sleep.getValue()+"");
        hhmodel.setHealthCheckup(checkup.getValue()+"");
        hhmodel.setYoga(yoga.getValue()+"");
        hhmodel.setSpiritual(spritual.getValue()+"");
        hhmodel.setRatYourHealth(rateofhealth.getValue());
        hhmodel.setMeditation(meditation.getValue()+"");
    }
    private void calBMI()
    {
        if(!height.getText().isEmpty() && !weight.getText().isEmpty())
        {
            double hsqr;
            double mass;
            double bmi;
            hsqr=Double.parseDouble(height.getText());
            mass=Double.parseDouble(weight.getText());
            hsqr=hsqr*0.3048;
            hsqr=Math.pow(hsqr,2);
            bmi=mass/hsqr;
            this.bmi.setText(bmi+"");
            
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        height = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bmi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        steamcellid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bloodgroup = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        veg1 = new javax.swing.JRadioButton();
        veg2 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        add1 = new javax.swing.JRadioButton();
        add2 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        pwd1 = new javax.swing.JRadioButton();
        pwd2 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        chronicdisease = new javax.swing.JTextField();
        sports = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        homefood = new javax.swing.JSlider();
        jLabel20 = new javax.swing.JLabel();
        outsidefood = new javax.swing.JSlider();
        jLabel21 = new javax.swing.JLabel();
        sleep = new javax.swing.JSlider();
        jLabel22 = new javax.swing.JLabel();
        checkup = new javax.swing.JSlider();
        jLabel23 = new javax.swing.JLabel();
        yoga = new javax.swing.JSlider();
        spritual = new javax.swing.JSlider();
        jLabel24 = new javax.swing.JLabel();
        meditation = new javax.swing.JSlider();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        rateofhealth = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        nametf = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Weight :");

        jLabel2.setText("Height :");

        jLabel3.setText("BMI :");

        jLabel4.setText("Stem Cell ID :");

        jLabel5.setText("Blood Group :");

        jLabel6.setText("Chronic Disease :");

        jLabel7.setText("Vegetarian :");

        buttonGroup2.add(veg1);
        veg1.setText("Yes");

        buttonGroup2.add(veg2);
        veg2.setText("No");

        jLabel12.setText("Addiction :");

        buttonGroup3.add(add1);
        add1.setText("Yes");

        buttonGroup3.add(add2);
        add2.setText("No");

        jLabel13.setText("Person With Disability :");

        buttonGroup1.add(pwd1);
        pwd1.setText("Yes");

        buttonGroup1.add(pwd2);
        pwd2.setText("No");

        jLabel17.setText("Sports :");

        jLabel19.setText("Home Food :");

        homefood.setMajorTickSpacing(1);
        homefood.setMaximum(5);
        homefood.setMinorTickSpacing(1);
        homefood.setPaintLabels(true);
        homefood.setPaintTicks(true);

        jLabel20.setText("OutSide Food :");

        outsidefood.setMajorTickSpacing(1);
        outsidefood.setMaximum(5);
        outsidefood.setMinorTickSpacing(1);
        outsidefood.setPaintLabels(true);
        outsidefood.setPaintTicks(true);

        jLabel21.setText("Satisifaction with sleep :");

        sleep.setMajorTickSpacing(1);
        sleep.setMaximum(5);
        sleep.setMinorTickSpacing(1);
        sleep.setPaintLabels(true);
        sleep.setPaintTicks(true);

        jLabel22.setText("Regular Health Checkup :");

        checkup.setMajorTickSpacing(1);
        checkup.setMaximum(5);
        checkup.setMinorTickSpacing(1);
        checkup.setPaintLabels(true);
        checkup.setPaintTicks(true);

        jLabel23.setText("Yoga :");

        yoga.setMajorTickSpacing(1);
        yoga.setMaximum(5);
        yoga.setMinorTickSpacing(1);
        yoga.setPaintLabels(true);
        yoga.setPaintTicks(true);

        spritual.setMajorTickSpacing(1);
        spritual.setMaximum(5);
        spritual.setMinorTickSpacing(1);
        spritual.setPaintLabels(true);
        spritual.setPaintTicks(true);

        jLabel24.setText("Spritual :");

        meditation.setMajorTickSpacing(1);
        meditation.setMaximum(5);
        meditation.setMinorTickSpacing(1);
        meditation.setPaintLabels(true);
        meditation.setPaintTicks(true);

        jLabel25.setText("Meditation :");

        jLabel26.setText("Rate Your Health :");

        rateofhealth.setMajorTickSpacing(1);
        rateofhealth.setMaximum(5);
        rateofhealth.setMinorTickSpacing(1);
        rateofhealth.setPaintLabels(true);
        rateofhealth.setPaintTicks(true);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setText("Medical And Health");

        nametf.setText("MR. THIS AND THAT");

        jButton1.setText("Save and Back");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(358, 358, 358)
                                .addComponent(jLabel27))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(nametf)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(chronicdisease)
                                                        .addComponent(sports, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bmi, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(steamcellid, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(bloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(veg1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(veg2))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(add1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(add2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(pwd1)
                                        .addGap(18, 18, 18)
                                        .addComponent(pwd2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel20)
                                                .addComponent(jLabel21)
                                                .addComponent(jLabel22)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel24)
                                                .addComponent(jLabel25))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel26)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(homefood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(outsidefood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(checkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yoga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spritual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(meditation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rateofhealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(77, 77, 77)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nametf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homefood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outsidefood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(bmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(steamcellid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yoga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(bloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spritual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(chronicdisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meditation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(sports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateofhealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(pwd1)
                            .addComponent(pwd2)
                            .addComponent(jLabel13))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(veg1)
                    .addComponent(veg2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(add1)
                    .addComponent(add2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setModel();
        Map<Object,Object> data=new HashMap();
        data.put("wt",hhmodel.getWt());
        data.put("ht",hhmodel.getHt());
        data.put("veg", hhmodel.getVeg());
        data.put("homefood",hhmodel.getHomeFood());
        data.put("outsidefood",hhmodel.getOutsideFood());
        data.put("sleephrs",hhmodel.getSleepHrs());
        data.put("health_checkup",hhmodel.getHealthCheckup());
        data.put("addiction",hhmodel.getAddiction());
        data.put("bmi",hhmodel.getBmi());
        data.put("stem_cell_id",hhmodel.getStemCellId());
        data.put("bGroup",hhmodel.getBGroup());
        data.put("pwd",hhmodel.getPwd());
        data.put("chronicdisease",hhmodel.getChronicDisease());
        data.put("sport",hhmodel.getSport());
        data.put("yoga",hhmodel.getYoga());
        data.put("spiritual",hhmodel.getSpiritual());
        data.put("meditation",hhmodel.getMeditation());
        data.put("ratyourhealth",hhmodel.getRatYourHealth());
        hhmodel.myQuery(data);
        dashBoard.hhmodel=hhmodel;
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PbtHHMedicalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHHMedicalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHHMedicalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHHMedicalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton add1;
    private javax.swing.JRadioButton add2;
    private javax.swing.JTextField bloodgroup;
    private javax.swing.JTextField bmi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JSlider checkup;
    private javax.swing.JTextField chronicdisease;
    private javax.swing.JTextField height;
    private javax.swing.JSlider homefood;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider meditation;
    private javax.swing.JLabel nametf;
    private javax.swing.JSlider outsidefood;
    private javax.swing.JRadioButton pwd1;
    private javax.swing.JRadioButton pwd2;
    private javax.swing.JSlider rateofhealth;
    private javax.swing.JSlider sleep;
    private javax.swing.JTextField sports;
    private javax.swing.JSlider spritual;
    private javax.swing.JTextField steamcellid;
    private javax.swing.JRadioButton veg1;
    private javax.swing.JRadioButton veg2;
    private javax.swing.JTextField weight;
    private javax.swing.JSlider yoga;
    // End of variables declaration//GEN-END:variables
}
