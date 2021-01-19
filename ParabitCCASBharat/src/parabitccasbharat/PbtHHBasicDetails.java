/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import ParabitModel.PbtHHModel;
import ParabitModel.PbtModelAadhar;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PbtHHBasicDetails extends javax.swing.JDialog implements ItemListener,DocumentListener{

    /**
     * Creates new form PbtHHBasicDetails
     */
    PbtHHModel hhmodel;
    PbtSingleMemberDashBoard dashboard;
    Border defaultborder,errorborder;
    public PbtHHBasicDetails(PbtSingleMemberDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.hhmodel=parent.hhmodel;
        this.dashboard=parent;
        m1.setEditable(false);
        selfhead.addItemListener(this);
        religion.setEditable(false);
        category.setEditable(false);
        gen1.addItemListener(this);
        gen2.addItemListener(this);
        age.setEditable(false);
        lerror.setVisible(false);
        defaultborder=reltohead.getBorder();
        errorborder= BorderFactory.createLineBorder(Color.red, 2);
        headuid.getDocument().addDocumentListener(this);
        headregmobno.getDocument().addDocumentListener(this);
        mobno.getDocument().addDocumentListener(this);
        altphoneno.getDocument().addDocumentListener(this);
        dob.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if("date".equals(evt.getPropertyName()))
                {
                    if(dob.getDate()!=null)
                    {
                    Date ndob=dob.getDate();
                    Calendar c=Calendar.getInstance();
                    c.setTime(ndob);
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH) + 1;
                    int date = c.get(Calendar.DATE);
                    LocalDate l1 = LocalDate.of(year, month, date);
                    LocalDate now1 = LocalDate.now();
                    Period diff1 = Period.between(l1, now1);
                    age.setText(""+diff1.getYears());
                    }
                }
            }
        });
        vOff();
        setExistingData();
    }
    private void setExistingData()
    {
        m1.setVisible(false);
        marriageage.setVisible(false);
        mstatus.setVisible(false);
        aprxage.setVisible(false);
        mobno.setText(hhmodel.getMobNo());
        dob.setDate(hhmodel.getDob());
        email.setText(hhmodel.getEmail());
        age.setText(hhmodel.getAge()+"");
        if(hhmodel.getGender()!=null)
        {
            if(hhmodel.getGender().equals("M"))
            {
                gen1.setSelected(true);
                if(hhmodel.getAge()>=21)
                {
                    m1.setVisible(true);
                    marriageage.setVisible(true);
                    mstatus.setVisible(true);
                    aprxage.setVisible(true);
                    if(hhmodel.getAproMarriageAge()!=null)
                    {
                        m1.setText(new PbtHHDialogMaritalStatus(dashboard,true).getbutton(hhmodel.getMarStatus()));
                        marriageage.setText(""+hhmodel.getAproMarriageAge());
                    }
                }
            }
            else if(hhmodel.getGender().equals("F"))
            {
                gen2.setSelected(true);
                if(hhmodel.getAge()>=18)
                {
                    m1.setVisible(true);
                    marriageage.setVisible(true);
                    mstatus.setVisible(true);
                    aprxage.setVisible(true);
                    if(hhmodel.getAproMarriageAge()!=null)
                    {
                        m1.setText(new PbtHHDialogMaritalStatus(dashboard,true).getbutton(hhmodel.getMarStatus()));
                        marriageage.setText(""+hhmodel.getAproMarriageAge());
                    }
                }
            }
            else
            {
                gen3.setSelected(true);
            }
        }
        reltohead.setText(hhmodel.getRelToHead());
        headuid.setText(hhmodel.getHeadUid());
        headregmobno.setText(hhmodel.getHeadRegMobNo());
        mobno.setText(hhmodel.getMobNo());
        altphoneno.setText(hhmodel.getAltPhoneNo());
        email.setText(hhmodel.getEmail());
        marriageage.setText(hhmodel.getAproMarriageAge());
        religion.setText(new PbtHHDialogReligion(dashboard, true).getButton(hhmodel.getReligion()));
        category.setText(new PbtHHDialogCategory(dashboard, true).getButton(hhmodel.getCategory()));
        community.setText(hhmodel.getCommunity());
        cast.setText(hhmodel.getCast());
        mtongue.setText(hhmodel.getMTongue());
        rwlang.setText(hhmodel.getRwLang());
        homelang.setText(hhmodel.getHomeLang());
        chdnevenborn.setText(hhmodel.getChdnEvenBorn());
        chdnsurv.setText(hhmodel.getChdnSurv());
        
    }
    private void getAllData()
    {
        hhmodel.setRelToHead(reltohead.getText());
        hhmodel.setHeadUid(headuid.getText());
        hhmodel.setHeadRegMobNo(headregmobno.getText());
        hhmodel.setMobNo(mobno.getText());
        hhmodel.setAltPhoneNo(altphoneno.getText());
        hhmodel.setEmail(email.getText());
        hhmodel.setAproMarriageAge(marriageage.getText());
        hhmodel.setAge(Long.parseLong(age.getText()));
        hhmodel.setCommunity(community.getText());
        //hhmodel.setCategory(category.getText());
        hhmodel.setCast(cast.getText());
        hhmodel.setMTongue(mtongue.getText());
        hhmodel.setRwLang(rwlang.getText());
        hhmodel.setHomeLang(homelang.getText());
        hhmodel.setChdnEvenBorn(chdnevenborn.getText());
        hhmodel.setChdnSurv(chdnsurv.getText());
        if(gen1.isSelected())
            hhmodel.setGender("M");
        else if(gen2.isSelected())
            hhmodel.setGender("F");
        else
            hhmodel.setGender("O");
        Date date=dob.getDate();
        if(date!=null)
        {
            java.sql.Date dobsql=new java.sql.Date(date.getTime());
            hhmodel.setDob(dobsql);
        }
        hhmodel.setAltPhoneNo(altphoneno.getText());
        hhmodel.setCategoryname(categoryname.getText());
        if(catverify.isSelected())
        {
            hhmodel.setCategoryverified("Y");
        }else
        {
            hhmodel.setCategoryverified("N");
        }
    }
    
    private void vOn()
    {
        m1.setVisible(true);
        marriageage.setVisible(true);
        mstatus.setVisible(true);
        aprxage.setVisible(true);
        lborn.setVisible(true);
        lsurvive.setVisible(true);
        chdnevenborn.setVisible(true);
        chdnsurv.setVisible(true);
        mchoose.setVisible(true);
    }
    private void vOff()
    {
        m1.setVisible(false);
        marriageage.setVisible(false);
        mstatus.setVisible(false);
        aprxage.setVisible(false);
        lborn.setVisible(false);
        lsurvive.setVisible(false);
        chdnevenborn.setVisible(false);
        chdnsurv.setVisible(false); 
        mchoose.setVisible(false);
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
        if(e.getDocument()==headuid.getDocument())
        {
            String s=headuid.getText();
            if(!checkNum(s) && s.length()==12)
            {
                setNoError(headuid);
            }else
            {
                setError(headuid);
            }
        }
        else if(e.getDocument()==mobno.getDocument())
        {
            String s=mobno.getText();
            if(!checkNum(s)&&s.length()==10)
            {
                setNoError(mobno);
            }
            else
            {
                setError(mobno);
            }
        }
        else if(e.getDocument()==altphoneno.getDocument())
        {
            String s=altphoneno.getText();
            if(!checkNum(s)&&s.length()==10)
            {
                setNoError(altphoneno);
            }
            else
            {
                setError(altphoneno);
            }
        }
        else if(e.getDocument()==headregmobno.getDocument())
        {
            String s=headregmobno.getText();
            if(!checkNum(s)&&s.length()==10)
            {
                setNoError(headregmobno);
            }
            else
            {
                setError(headregmobno);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mobno = new javax.swing.JTextField();
        altphoneno = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        religion = new javax.swing.JTextField();
        community = new javax.swing.JTextField();
        category = new javax.swing.JTextField();
        cast = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        gen1 = new javax.swing.JRadioButton();
        gen2 = new javax.swing.JRadioButton();
        gen3 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        reltohead = new javax.swing.JTextField();
        headuid = new javax.swing.JTextField();
        headregmobno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mtongue = new javax.swing.JTextField();
        rwlang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        homelang = new javax.swing.JTextField();
        aprxage = new javax.swing.JLabel();
        marriageage = new javax.swing.JTextField();
        lborn = new javax.swing.JLabel();
        chdnevenborn = new javax.swing.JTextField();
        lsurvive = new javax.swing.JLabel();
        chdnsurv = new javax.swing.JTextField();
        savebtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        mstatus = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        m1 = new javax.swing.JTextField();
        mchoose = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        selfhead = new javax.swing.JCheckBox();
        lerror = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        categoryname = new javax.swing.JTextField();
        catverify = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mobile No :");

        jLabel2.setText("Alternative Mobile No :");

        jLabel3.setText("Date of Birth :");

        jLabel4.setText("Gender :");

        jLabel5.setText("Email :");

        jLabel6.setText("Religion :");

        jLabel7.setText("Community :");

        jLabel8.setText("Category :");

        jLabel10.setText("Caste :");

        cast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castActionPerformed(evt);
            }
        });

        buttonGroup1.add(gen1);
        gen1.setText("Male");

        buttonGroup1.add(gen2);
        gen2.setText("Female");

        buttonGroup1.add(gen3);
        gen3.setText("Others");

        jLabel12.setText("Relation to Head :");

        jLabel13.setText("Head UID :");

        jLabel14.setText("Head Registered Mobile No :");

        jLabel15.setText("Mother Tounge :");

        jLabel16.setText("Read Write Language :");

        jLabel17.setText("Home Language :");

        aprxage.setText("Approx Marriage Age :");

        lborn.setText("Child Born :");

        lsurvive.setText("No of Childern Survived :");

        savebtn.setText("Save and Back");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        jLabel18.setText("Age :");

        mstatus.setText("Marriage Status :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("Basic Details");

        mchoose.setText("Select");
        mchoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mchooseActionPerformed(evt);
            }
        });

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Select");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        selfhead.setText("Head");

        lerror.setForeground(new java.awt.Color(255, 0, 0));
        lerror.setText("Invalid data in head registered mobile no");

        jLabel9.setText("Category Name :");

        catverify.setText("Verified ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(727, 727, 727))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(aprxage)
                            .addComponent(mstatus)
                            .addComponent(jLabel9))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(marriageage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(708, 708, 708))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(mobno)
                                                                .addComponent(altphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(gen1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(gen2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(gen3)))
                                                        .addGap(183, 183, 183))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(headuid)
                                                            .addComponent(headregmobno)
                                                            .addComponent(reltohead, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(selfhead)
                                                        .addGap(130, 130, 130))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(mchoose)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGap(87, 87, 87)
                                                                    .addComponent(jLabel18)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel17)
                                                    .addComponent(lborn)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(m1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(categoryname))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lsurvive))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(catverify)
                                                        .addGap(0, 0, Short.MAX_VALUE)))))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cast)
                                            .addComponent(mtongue)
                                            .addComponent(rwlang)
                                            .addComponent(community)
                                            .addComponent(homelang)
                                            .addComponent(chdnevenborn)
                                            .addComponent(chdnsurv)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(religion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(category)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lerror)
                                            .addComponent(savebtn))
                                        .addGap(12, 12, 12)))
                                .addGap(24, 24, 24))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(reltohead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selfhead))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(headuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(headregmobno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(mobno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(gen1)
                            .addComponent(gen2)
                            .addComponent(gen3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mstatus)
                            .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mchoose))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aprxage)
                            .addComponent(marriageage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(religion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(community, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jButton4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mtongue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rwlang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homelang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lborn)
                            .addComponent(chdnevenborn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lsurvive)
                            .addComponent(chdnsurv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(categoryname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(catverify))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lerror)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void castActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_castActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_castActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        getAllData();
        Map<Object,Object> data = new HashMap();
        data.put("Gender",hhmodel.getGender());
        data.put("Age",hhmodel.getAge());
        data.put("reltohead",hhmodel.getRelToHead());
        data.put("headuid",hhmodel.getHeadUid());
        data.put("headregmobno",hhmodel.getHeadRegMobNo());
        data.put("mobno",hhmodel.getMobNo());
        data.put("altphoneno",hhmodel.getAltPhoneNo());
        data.put("email",hhmodel.getEmail());
        data.put("marstatus",hhmodel.getMarStatus());
        data.put("apromarriageage",hhmodel.getAproMarriageAge());
        data.put("religion",hhmodel.getReligion());
        data.put("category",hhmodel.getCategory());
        data.put("community",hhmodel.getCommunity());
        data.put("cast",hhmodel.getCast());
        data.put("mtongue",hhmodel.getMTongue());
        data.put("rwlang",hhmodel.getRwLang());
        data.put("homelang",hhmodel.getHomeLang());
        data.put("chdnevenborn",hhmodel.getChdnEvenBorn());
        data.put("chdnsurv",hhmodel.getChdnSurv());
        data.put("dob",hhmodel.getDob());
        data.put("CategoryTypeName",hhmodel.getCategoryname());
        data.put("CategoryVerified",hhmodel.getCategoryverified());
        hhmodel.myQuery(data);
        dashboard.hhmodel=hhmodel;
        dispose();
        
    }//GEN-LAST:event_savebtnActionPerformed

    private void mchooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mchooseActionPerformed

        PbtHHDialogMaritalStatus nob=new PbtHHDialogMaritalStatus(dashboard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        m1.setText(nob.getbutton(hhmodel.getMarStatus()));
    }//GEN-LAST:event_mchooseActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PbtHHDialogReligion nob=new PbtHHDialogReligion(dashboard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        religion.setText(nob.getButton(hhmodel.getReligion()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        PbtHHDialogCategory nob=new PbtHHDialogCategory(dashboard, true);
        nob.setLocationRelativeTo(null);
        nob.setVisible(true);
        category.setText(nob.getButton(hhmodel.getCategory()));
        nob.dispose();
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
            java.util.logging.Logger.getLogger(PbtHHBasicDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHHBasicDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHHBasicDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHHBasicDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTextField altphoneno;
    private javax.swing.JLabel aprxage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cast;
    private javax.swing.JTextField category;
    private javax.swing.JTextField categoryname;
    private javax.swing.JCheckBox catverify;
    private javax.swing.JTextField chdnevenborn;
    private javax.swing.JTextField chdnsurv;
    private javax.swing.JTextField community;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton gen1;
    private javax.swing.JRadioButton gen2;
    private javax.swing.JRadioButton gen3;
    private javax.swing.JTextField headregmobno;
    private javax.swing.JTextField headuid;
    private javax.swing.JTextField homelang;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lborn;
    private javax.swing.JLabel lerror;
    private javax.swing.JLabel lsurvive;
    private javax.swing.JTextField m1;
    private javax.swing.JTextField marriageage;
    private javax.swing.JButton mchoose;
    private javax.swing.JTextField mobno;
    private javax.swing.JLabel mstatus;
    private javax.swing.JTextField mtongue;
    private javax.swing.JTextField religion;
    private javax.swing.JTextField reltohead;
    private javax.swing.JTextField rwlang;
    private javax.swing.JButton savebtn;
    private javax.swing.JCheckBox selfhead;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==selfhead)
        {
            if(selfhead.isSelected())
            {
                headuid.setEditable(false);
                reltohead.setEditable(false);
                headuid.setText(hhmodel.getUid());
                reltohead.setText("HEAD");
                headregmobno.setText(hhmodel.getMobNo());
            }else
            {
                headuid.setEditable(true);
                reltohead.setEditable(true);
                headuid.setText("");
                reltohead.setText("");
                headregmobno.setText("");
            }
        }
        if(e.getSource()==gen1)
        {
            if(Integer.parseInt(age.getText())>=21)
            {
                vOn();
            }
            else
            {
                vOff();
            }
        }
        else if(e.getSource()==gen2)
        {
            if(Integer.parseInt(age.getText())>=18)
            {
                vOn();
            }
            else
            {
                vOff();
            }
        }
    }

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
