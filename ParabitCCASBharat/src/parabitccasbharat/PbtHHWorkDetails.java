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
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Asus
 */
public class PbtHHWorkDetails extends javax.swing.JDialog implements DocumentListener{

    /**
     * Creates new form PbtHHWorkDetails
     */
    PbtSingleMemberDashBoard dashBoard;
    PbtHHModel hhmodel;
    String modetrvldatabase;
    Border defaultborder,errorborder;
    public PbtHHWorkDetails(PbtSingleMemberDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dashBoard=parent;
        this.hhmodel=parent.hhmodel;
        modeoftrvl.setEditable(false);
        //wsector.setEditable(false);
        defaultborder=icsno.getBorder();
        lerror.setVisible(false);
        errorborder= BorderFactory.createLineBorder(Color.red, 2);
        workexp.getDocument().addDocumentListener(this);
        specexp.getDocument().addDocumentListener(this);
        income.getDocument().addDocumentListener(this);
        setData();
    }
    
    private void setData()
    {
        if(hhmodel.getCWorkStat()!=null)
        {
            if(hhmodel.getCWorkStat().equals("Y"))
                cwstatus1.setSelected(true);
            else
                cwstatus2.setSelected(true);
        }
        if(hhmodel.getWorkCategory()==1)
            wcat1.setSelected(true);
        else if(hhmodel.getWorkCategory()==2)
            wcat2.setSelected(true);
        else if(hhmodel.getWorkCategory()==3)
            wcat3.setSelected(true);
        //wsector.setText(new PbtHHDialogWorkSector(dashBoard, true).getSector(hhmodel.getWorkingSector()));
        //wnature.setText(new PbtHHDialogNatureOfWork(dashBoard, true).getNature(hhmodel.getNatureOfWork()));
        icsno.setText(hhmodel.getIcsNo()+"");
        occupation.setText(hhmodel.getOccupation());
        income.setText(hhmodel.getIncome()+"");
        workexp.setText(hhmodel.getWorkExp());
        specdesc.setText(hhmodel.getSpecDescription());
        if(hhmodel.getItr()!=null)
        {
            if(hhmodel.getItr().equals("Y"))
                itr1.setSelected(true);
            else
                itr2.setSelected(true);
        }
        specexp.setText(hhmodel.getSpecExp());
        profno.setText(hhmodel.getProfLicNo());
        busslicno.setText(hhmodel.getBusiRegNo());
        if(hhmodel.getJobSeek()!=null)
        {
            if(hhmodel.getJobSeek().equals("Y"))
                jobseek1.setSelected(true);
            else
                jobseek2.setSelected(true);
            distancefromwork.setText(hhmodel.getDistFrmWorkPlace()+"");
        }
        if(hhmodel.getModOfTravel()!=null)
        {
        PbtHHDialogModOfTrav nob=new PbtHHDialogModOfTrav(dashBoard, true);
        modeoftrvl.setText(nob.getModes(hhmodel.getModOfTravel()));
        nob.dispose();
        }
    }
    
    private void setModelData()
    {
        if(jobseek1.isSelected())
            hhmodel.setJobSeek("Y");
        else if(jobseek2.isSelected())
            hhmodel.setJobSeek("N");
        if(cwstatus1.isSelected())
            hhmodel.setCWorkStat("Y");
        else if(cwstatus2.isSelected())
            hhmodel.setCWorkStat("N");
        if(wcat1.isSelected())
            hhmodel.setWorkCategory(1);
        else if(wcat2.isSelected())
            hhmodel.setWorkCategory(2);
        else if(wcat3.isSelected())
            hhmodel.setWorkCategory(3);
        //hhmodel.setWorkingSector(Long.parseLong(wsector.getText()));
        //hhmodel.setNatureOfWork(Long.parseLong(wnature.getText()));
        hhmodel.setIcsNo(Long.parseLong(icsno.getText()));
        hhmodel.setOccupation(occupation.getText());
        hhmodel.setIncome(Long.parseLong(income.getText()));
        //hhmodel.setModOfTravel(modetrvldatabase);<--- not updating here because it is becoming null for second time
        hhmodel.setWorkExp(workexp.getText());
        hhmodel.setSpecDescription(specdesc.getText());
        if(itr1.isSelected())
            hhmodel.setItr("Y");
        else if(itr2.isSelected())
            hhmodel.setItr("N");
        hhmodel.setSpecExp(specexp.getText());
        hhmodel.setProfLicNo(profno.getText());
        hhmodel.setBusiRegNo(busslicno.getText());
        if(!distancefromwork.getText().isEmpty())
            hhmodel.setDistFrmWorkPlace(Double.parseDouble(distancefromwork.getText()));
    }
    public void setModeOfTravel(String text,String database)
    {
        modeoftrvl.setText(text);
        modetrvldatabase=database;
        hhmodel.setModOfTravel(modetrvldatabase);
    }
    private boolean checkNum(String str)
    {
        Pattern p=Pattern.compile("[a-zA-z]");
        Matcher mat=p.matcher(str);
        return mat.find();
    }
    private void setNoError(javax.swing.JTextField nob)
    {
        nob.setBorder(defaultborder);
        lerror.setVisible(false);
        savebtn.setEnabled(true);
    }
    private void setError(javax.swing.JTextField nob)
    {
        nob.setBorder(errorborder);
        lerror.setText("Invalid data in some fields");
        lerror.setVisible(true);
        savebtn.setEnabled(false);
    }
    private void verifyData(DocumentEvent e)
    {
        if(e.getDocument()==workexp.getDocument())
        {
            String s=workexp.getText();
            if(!checkNum(s) && s.length()==1||s.length()==2)
            {
                setNoError(workexp);
            }else
            {
                setError(workexp);
            }
        }
        else if(e.getDocument()==specexp.getDocument())
        {
            String s=specexp.getText();
            if(!checkNum(s) && s.length()==1||s.length()==2)
            {
                setNoError(specexp);
            }else
            {
                setError(specexp);
            }
        }
        else if(e.getDocument()==income.getDocument())
        {
            String s=income.getText();
            if(!checkNum(s))
            {
                setNoError(income);
            }else
            {
                setError(income);
            }
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

        itr = new javax.swing.ButtonGroup();
        jobseek = new javax.swing.ButtonGroup();
        workstatus = new javax.swing.ButtonGroup();
        workcat = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        workexp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        specdesc = new javax.swing.JTextField();
        specexp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        profno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        icsno = new javax.swing.JTextField();
        busslicno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        occupation = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        itr1 = new javax.swing.JRadioButton();
        itr2 = new javax.swing.JRadioButton();
        income = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        distancefromwork = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jobseek1 = new javax.swing.JRadioButton();
        jobseek2 = new javax.swing.JRadioButton();
        wcat1 = new javax.swing.JRadioButton();
        wcat2 = new javax.swing.JRadioButton();
        wcat3 = new javax.swing.JRadioButton();
        cwstatus1 = new javax.swing.JRadioButton();
        cwstatus2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        modeoftrvl = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Current Work Status :");

        jLabel2.setText("Work Experience :");

        jLabel3.setText("Work Category :");

        jLabel4.setText("Specialization Description :");

        jLabel5.setText("Specialization Experience :");

        jLabel6.setText("Working Sector :");

        jLabel8.setText("Professional Licence No :");

        jLabel9.setText("Business Registration No :");

        jLabel10.setText("ICS No :");

        jLabel11.setText("ITR : ");

        jLabel12.setText("Occupation :");

        itr.add(itr1);
        itr1.setText("Yes");

        itr.add(itr2);
        itr2.setText("No");

        jLabel13.setText("Income :");

        jLabel14.setText("Distance From Work :");

        jLabel15.setText("Mode Of Travel :");

        jLabel16.setText("Job Seek :");

        jobseek.add(jobseek1);
        jobseek1.setText("Yes");

        jobseek.add(jobseek2);
        jobseek2.setText("No");

        workcat.add(wcat1);
        wcat1.setText("Economic Activity");

        workcat.add(wcat2);
        wcat2.setText("Non Economic Activity");

        workcat.add(wcat3);
        wcat3.setText("Both ");

        workstatus.add(cwstatus1);
        cwstatus1.setText("Working");

        workstatus.add(cwstatus2);
        cwstatus2.setText("Not Working");

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        savebtn.setText("Save and Back");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        modeoftrvl.setColumns(20);
        modeoftrvl.setRows(5);
        jScrollPane1.setViewportView(modeoftrvl);

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Work Details");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilometers", "Meters", "Miles" }));

        lerror.setForeground(new java.awt.Color(255, 0, 0));
        lerror.setText("Invalid data in head registered mobile no");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cwstatus1)
                        .addGap(52, 52, 52)
                        .addComponent(cwstatus2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(icsno, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(wcat1)
                                            .addComponent(wcat2)
                                            .addComponent(wcat3)
                                            .addComponent(jButton3))
                                        .addGap(56, 56, 56)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(specdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(specexp, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(profno, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(busslicno, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(workexp, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(itr1)
                                        .addGap(18, 18, 18)
                                        .addComponent(itr2)
                                        .addGap(97, 97, 97))
                                    .addComponent(savebtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lerror, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap(112, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(distancefromwork, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jobseek1)
                        .addGap(18, 18, 18)
                        .addComponent(jobseek2)
                        .addGap(203, 203, 203))))
            .addGroup(layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(workexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cwstatus1)
                            .addComponent(cwstatus2))
                        .addComponent(jLabel1)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(wcat1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wcat2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wcat3)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jobseek1)
                                    .addComponent(jobseek2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(icsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(occupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jButton1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(distancefromwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(specdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(itr1)
                            .addComponent(itr2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(specexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(profno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(busslicno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(lerror)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PbtHHDialogModOfTrav nob=new PbtHHDialogModOfTrav(dashBoard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        System.out.println(nob.text+"");
        setModeOfTravel(nob.text,nob.database);
        nob.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        setModelData();
        Map<Object,Object> data=new HashMap();
       data.put("jobseek",hhmodel.getJobSeek());
       data.put("cworkstat",hhmodel.getCWorkStat());
       data.put("workcategory",hhmodel.getWorkCategory());
       data.put("workingsector",hhmodel.getWorkingSector());
       data.put("natureofwork",hhmodel.getNatureOfWork());
       data.put("icsno",hhmodel.getIcsNo());
       data.put("occupation",hhmodel.getOccupation());
       data.put("workexp",hhmodel.getWorkExp());
       data.put("specdescription",hhmodel.getSpecDescription());
       data.put("specexp",hhmodel.getSpecExp());
       data.put("proflicno",hhmodel.getProfLicNo());
       data.put("busiregno",hhmodel.getBusiRegNo());
       data.put("income",hhmodel.getIncome());
       data.put("itr",hhmodel.getItr());
       data.put("distfrmworkplace",hhmodel.getDistFrmWorkPlace());
       data.put("modoftravel",hhmodel.getModOfTravel());
       hhmodel.myQuery(data);
       dashBoard.hhmodel=hhmodel;
       dispose();
    }//GEN-LAST:event_savebtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       PbtHHDialogWorkSector nob=new PbtHHDialogWorkSector(dashBoard, true);
       nob.setLocationRelativeTo(null);
       nob.setVisible(true);
//       wsector.setText(nob.getSector(hhmodel.getWorkingSector()));
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(PbtHHWorkDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHHWorkDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHHWorkDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHHWorkDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busslicno;
    private javax.swing.JRadioButton cwstatus1;
    private javax.swing.JRadioButton cwstatus2;
    private javax.swing.JTextField distancefromwork;
    private javax.swing.JTextField icsno;
    private javax.swing.JTextField income;
    private javax.swing.ButtonGroup itr;
    private javax.swing.JRadioButton itr1;
    private javax.swing.JRadioButton itr2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jobseek;
    private javax.swing.JRadioButton jobseek1;
    private javax.swing.JRadioButton jobseek2;
    private javax.swing.JLabel lerror;
    private javax.swing.JTextArea modeoftrvl;
    private javax.swing.JTextField occupation;
    private javax.swing.JTextField profno;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField specdesc;
    private javax.swing.JTextField specexp;
    private javax.swing.JRadioButton wcat1;
    private javax.swing.JRadioButton wcat2;
    private javax.swing.JRadioButton wcat3;
    private javax.swing.ButtonGroup workcat;
    private javax.swing.JTextField workexp;
    private javax.swing.ButtonGroup workstatus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        verifyData(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verifyData(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verifyData(e);
    }
}
