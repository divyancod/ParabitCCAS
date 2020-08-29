/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parabitccasbharat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class PbtHHDialogChronicDis extends javax.swing.JDialog implements MouseListener {

    /**
     * Creates new form PbtHHDialogChronicDis
     */
    DefaultTableModel model;
    ParabitDBC db;
    boolean flag;
    PbtSingleMemberDashBoard dashBoard;
    public PbtHHDialogChronicDis(PbtSingleMemberDashBoard parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
        model=(DefaultTableModel)disease.getModel();
        db=new ParabitDBC();
        dashBoard=parent;
        disease.addMouseListener(this);
        setDisTable();
    }
    public String getData(String num)
    {
        String query="select * from typesofchronicdisease where sno='"+num+"'";
        try
        {
            db.rs1=db.stm.executeQuery(query);
            if(db.rs1.next())
                return db.rs1.getString("TypeOfChronicDisease");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;  
    }
    public void setDisTable()
    {
        String likes=search.getText();
        model.setRowCount(0);
        int i=0;
        String query="select * from typesofchronicdisease where TypeOfChronicDisease like '%"+likes+"%'";
        try
        {
            //System.out.println(query);
            db.rs1=db.stm.executeQuery(query);
            while(db.rs1.next())
            {
                Object ob[]={++i,db.rs1.getString("TypeOfChronicDisease")};
                flag=false;
                model.addRow(ob);
            }
            if(i==0)
            {
                Object ob[]={++i,likes};
                model.addRow(ob);
                flag=true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        disease = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        disease.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sno", "Name of Disease"
            }
        ));
        jScrollPane1.setViewportView(disease);
        if (disease.getColumnModel().getColumnCount() > 0) {
            disease.getColumnModel().getColumn(0).setMinWidth(40);
            disease.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setText("Enter Disease :");

        jButton1.setText("Seach");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(24, 322, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
     setDisTable();
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(PbtHHDialogChronicDis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PbtHHDialogChronicDis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PbtHHDialogChronicDis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PbtHHDialogChronicDis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable disease;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=disease.rowAtPoint(e.getPoint());
        String name=model.getValueAt(row,1).toString();
        System.out.println(name);
        String query="insert into typesofchronicdisease(sno,TypeOfChronicDisease) values (null,'"+name+"')";
        try
        {
            if(flag)
            {
                String[] listoptions = {"Add This Disease","Cancel"};
                String msg="This disease is not our master datebase.\nDo you want to add this to the master data base? Adding will reflect all over the India.";
                msg=msg+"\nBe sure to confirm the disease name as it will be checked by Testers";
                   int option = JOptionPane.showOptionDialog(this,msg,
                  "Confirm Final Save",            
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.WARNING_MESSAGE,
                  null,     
                  listoptions,
                 null
               );
                 if(option==0)
                 {
                db.stm.execute(query);
                query="select * from typesofchronicdisease where TypeOfChronicDisease='"+name+"'";
                db.rs1=db.stm1.executeQuery(query);
                if(db.rs1.next())
                    dashBoard.hhmodel.setChronicDisease(db.rs1.getString("Sno"));
                 }else
                 {
                     return;
                 }
            }
            else
            {
               int opt=JOptionPane.showConfirmDialog(null, "Add this to the current person?", "Confirm Disease", JOptionPane.YES_NO_OPTION); 
               if(opt==0)
               {
                   query="select * from typesofchronicdisease where TypeOfChronicDisease='"+name+"'";
                    db.rs1=db.stm1.executeQuery(query);
                    if(db.rs1.next())
                     dashBoard.hhmodel.setChronicDisease(db.rs1.getString("Sno"));
               }else
                   return;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        setVisible(false);
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