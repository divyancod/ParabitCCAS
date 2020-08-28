/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtFieldSelection extends javax.swing.JDialog implements MouseListener{

    /**
     * Creates new form PbtFieldSelection
     */
    DefaultTableModel areatablemodel;
    ParabitDBC db;
    PbtEmpData empdata;
    ArrayList<String> towv_vill;
    public PbtFieldSelection(PbtLogIN parent, boolean modal,PbtEmpData empdata) {
        super(parent, modal);
        initComponents();
        towv_vill=new ArrayList<>();
        areatablemodel=(DefaultTableModel)fieldselectiontable.getModel();
        db=new ParabitDBC();
        this.empdata=empdata;
        setAreaTable();
        username.setText(empdata.getEmpname());
        fieldselectiontable.addMouseListener(this);
    }

    private void setAreaTable()
    {
        areatablemodel.setRowCount(0);
        int sno=1;
        String query="SELECT * FROM `pbtempschecdule` LEFT join pbtenum on pbtenum.Ward=(SELECT WardNo pbtempschecdule where ceid='"+empdata.getEmpid()+"') and pbtenum.Town_Vill=(select City_Vill pbtempschecdule where ceid='"+empdata.getEmpid()+"') where pbtempschecdule.CEID='"+empdata.getEmpid()+"'";
        try
        {
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                towv_vill.add(db.rs1.getString("city_vill"));
                Object ob[]={sno++,db.rs1.getString("wardno"),db.rs1.getString("name"),db.rs1.getString("dateofworkstart"),
                             db.rs1.getString("totalres"),0,0,"100%"};
                areatablemodel.addRow(ob);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void notification()
    {
        
    }
    private void updateEmpDailyLog()
    {
        String query="";
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
        fieldselectiontable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        notificationtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fieldselectiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sno", "Ward No", "City/Village", "Date of Work Start", "Work Alloted", "Work Pending", "Work Done", "Percentage Remaining"
            }
        ));
        jScrollPane1.setViewportView(fieldselectiontable);

        notificationtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Notification Id", "Sender CEID", "Status", "Time", "Message", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(notificationtable);

        jButton1.setText("Signout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        username.setText("username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1234, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
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
            java.util.logging.Logger.getLogger(PbtFieldSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtFieldSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtFieldSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtFieldSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fieldselectiontable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable notificationtable;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=fieldselectiontable.rowAtPoint(e.getPoint());
        int option=JOptionPane.showConfirmDialog(null,"You sure to work on "+areatablemodel.getValueAt(row,2)+"","Confirm Area",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(option==0)
        {
            empdata.setWardno(areatablemodel.getValueAt(row,1).toString());
            empdata.setTownvill(areatablemodel.getValueAt(row,2).toString());
            empdata.setTownvillno(towv_vill.get(row));
            PbtEnumDashBoard nob=new PbtEnumDashBoard(empdata);
            setVisible(false);
            nob.setLocationRelativeTo(null);
            nob.setVisible(true);
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
