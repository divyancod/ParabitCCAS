/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtEmployeeTransfer extends javax.swing.JDialog implements MouseListener{

    /**
     * Creates new form PbtEmployeeTransfer
     */
    PbtEmpDashBoard pbtempdashboard;
    DefaultTableModel tablemodel;
    ParabitDBC db;
    String s2,s3,s4,s5,s6,s7,s8,s9,s10;
    int s1;
    int framestatus;
    PbtEmpData emptransferdata;
    public PbtEmployeeTransfer(PbtEmpDashBoard parent, boolean modal,int framestatus) {
        super(parent, modal);
        initComponents();
        setTitle("Transfer/Dismiss");
        pbtempdashboard=parent;
        db=new ParabitDBC();
        setLocationRelativeTo(null);
        tablemodel=(DefaultTableModel)table.getModel();
        System.out.println(pbtempdashboard.empdata.getEmpid());
        table.addMouseListener(this);
        this.framestatus=framestatus;
        setTable();
        if(framestatus==1)
        {
            label1.setVisible(false);
        }
    } 
    
    private void setTable()
    {
        tablemodel.setRowCount(0);
        try
        {
            s1=1;
            int grade=pbtempdashboard.empdata.getEmpgrade()+1;
            String query="select * from pbtemployeetable where grade='"+grade+"'and status='1' and crepempid='"+pbtempdashboard.empdata.getEmpid()+"'";
            System.out.println(query);
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                s2=db.rs1.getString("ceid");
                s3=db.rs1.getString("EmpName");
                s4=db.rs1.getString("areacity");
                s5=db.rs1.getString("areadist");
                s6=db.rs1.getString("areastate");
                s7=db.rs1.getString("pin");
                s8=db.rs1.getString("empdesig");
                s9=db.rs1.getString("workexpcensus");
                s10=db.rs1.getString("empmob");
                Object ob[]={s1++,s2,s3,s4,s5,s6,s7,s8,s9,s10};
                tablemodel.addRow(ob);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void dismissEmployee(String ceid,PbtEmpData transferdata)
    {
        String dceid=pbtempdashboard.empdata.getEmpid();
        String query="update pbtemployeetable set areacity=NULL,areastate=NULL,areadist=NULL,status=-1,percommt='Dismissed by "+dceid+"' where ceid='"+ceid+"'";
        try
        {
            db.stm.execute(query);
            setTable();
            query="update pbtemployeetable set crepempid='D"+dceid+"' where crepempid='"+ceid+"'";
            db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"Please Proceed for new hiring");
        setVisible(false);
        PbtNewAppoint nob=new PbtNewAppoint(pbtempdashboard);
        //nob.setDismissedEmployee(ceid,transferdata);
        nob.setVisible(true);
        setTable();
        setVisible(true);
    }
    private void swapEmployeeFrame(int row,PbtEmpData transferdata)
    {
        setVisible(false);
        PbtEmployeeTransfer nob=new PbtEmployeeTransfer(pbtempdashboard,true, 2);
        nob.tablemodel.removeRow(row);
        nob.setTransferdata(transferdata);
        nob.setVisible(true);
        setTable();
        setVisible(true);
    }
    
    public void setTransferdata(PbtEmpData emptransferdata)
    {
        this.emptransferdata=emptransferdata;
        label1.setText("Please Choose the employee to swap with : "+emptransferdata.getEmpname()+" of "+emptransferdata.getEmpstate()+" "+emptransferdata.getEmpDist()+" "+emptransferdata.getEmpCity());
    }
    private void swapEmployeeData(int row)
    {
        String percomment="Transferred";
        String query="update pbtemployeetable set percommt='"+percomment+"',note='"+tablemodel.getValueAt(row,1)+"',areacity='"+tablemodel.getValueAt(row,3)+"',areadist='"+tablemodel.getValueAt(row,4)+"',areastate='"+tablemodel.getValueAt(row,5)+"' where ceid='"+emptransferdata.getEmpid()+"'";
        System.out.println(query);
        try
        {
            db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        query="update pbtemployeetable set crepempid='R"+emptransferdata.getEmpid()+"' where crepempid='"+emptransferdata.getEmpid()+"'";
        System.out.println(query);
        try
        {
            db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        query="update pbtemployeetable set percommt='"+percomment+"',note='"+emptransferdata.getEmpid()+"',areacity='"+emptransferdata.getEmpCity()+"',areadist='"+emptransferdata.getEmpDist()+"',areastate='"+emptransferdata.getEmpstate()+"' where ceid='"+tablemodel.getValueAt(row,1)+"'";
        System.out.println(query);
        try
        {
            db.stm.execute(query);
            query="update pbtemployeetable set crepempid='R"+tablemodel.getValueAt(row,1)+"' where crepempid='"+tablemodel.getValueAt(row,1)+"'";
            System.out.println(query);
             db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        /*query="update pbtemployeetable set crepempid='R"+tablemodel.getValueAt(row,1)+"' where crepempid='"+tablemodel.getValueAt(row,1)+"'";
        System.out.println(query);
        try
        {
            db.stm.execute(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }*/
        
        //-----notification to employee--------------
        String senderceid=pbtempdashboard.empdata.getEmpid();
        String recievercied=emptransferdata.getEmpid();
        String msg="ALL THE BEST. Your Transfer process is finsihed please check all the employees list and working.";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
        String time=sdf.format(cal.getTime());
        String notify="insert into pbtnotification values ('"+senderceid+"','"+recievercied+"','"+time+"','"+msg+"','0','',NULL,'1'),('"+senderceid+"','"+tablemodel.getValueAt(row,1)+"','"+time+"','"+msg+"','0','',NULL,'1')";
        try
        {
            db.stm.execute(notify);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(notify);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SNo", "CEID", "EmpName", "City", "District", "State", "PIN", "Emp Designation", "Work Exp Census", "Mobile Number"
            }
        ));
        jScrollPane2.setViewportView(table);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(label1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(label1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=table.rowAtPoint(e.getPoint());            
        String ceid=(String)tablemodel.getValueAt(row,1);
        String name=(String)tablemodel.getValueAt(row,2);
        if(row>=0 && framestatus ==1)
        {
                PbtEmpData transferdata=new PbtEmpData();
                transferdata.setEmpid(ceid);
                transferdata.setEmpname(name);
                transferdata.setEmpcity((String)tablemodel.getValueAt(row,3));
                transferdata.setEmpdist((String)tablemodel.getValueAt(row,4));
                transferdata.setEmpstate((String)tablemodel.getValueAt(row,5));
            String[] listoptions = {"Transfer Employee", "Dismiss Employee"}; 
            int option = JOptionPane.showOptionDialog(this,"Currently selected "+name, 
               "Select Operation",            
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,     
               listoptions,
              listoptions[0]
            );
            if(option==0)
            {
                swapEmployeeFrame(row,transferdata);
            }else if(option==1)
            {
                dismissEmployee(ceid,transferdata);
            }
            setTable();
        }else if(row>=0 && framestatus==2)
        {
            String s="You are about to swap work area of "+emptransferdata.getEmpname()+" with "+name;
           int opt= JOptionPane.showConfirmDialog(null,s);
           if(opt==0)
           {
           swapEmployeeData(row);
           JOptionPane.showMessageDialog(null,"Employee Transfer Successful");
           dispose();
           }
           else if(opt==1)
           {
               JOptionPane.showMessageDialog(null,"Transfer Cancelled");
           }
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
