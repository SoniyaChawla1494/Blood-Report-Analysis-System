
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinit
 */
public class viewRec extends javax.swing.JFrame {

    /**
     * Creates new form viewRec
     */
    static String u="";
    public viewRec(String userr) {
        
        initComponents();
         u=userr;  
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisp = new javax.swing.JTextArea();
        btnEmail = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(840, 560));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\xyz\\Desktop\\download (1).jpg")); // NOI18N
        jLabel1.setText("REPORT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 0, 190, 180);

        txtDisp.setColumns(20);
        txtDisp.setRows(5);
        txtDisp.setAutoscrolls(false);
        txtDisp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDisp.setEnabled(false);
        txtDisp.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(txtDisp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 210, 650, 129);

        btnEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEmail.setIcon(new javax.swing.ImageIcon("C:\\Users\\xyz\\Desktop\\letter.png")); // NOI18N
        btnEmail.setText("Email");
        btnEmail.setContentAreaFilled(false);
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmail);
        btnEmail.setBounds(350, 440, 150, 73);

        btnBack.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\xyz\\Desktop\\previous (1).png")); // NOI18N
        btnBack.setText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(560, 450, 180, 50);

        btnView.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnView.setForeground(new java.awt.Color(204, 51, 0));
        btnView.setText("VIEW");
        btnView.setContentAreaFilled(false);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        getContentPane().add(btnView);
        btnView.setBounds(350, 360, 110, 25);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\xyz\\Desktop\\pdf.png")); // NOI18N
        jButton1.setText("Convert to pdf");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 440, 190, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\xyz\\Desktop\\maxresdefault.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 840, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        NewJFrame nj=new NewJFrame(u);
        nj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        // TODO add your handling code here:
         final     JPanel p1 = new JPanel();
       Email e=new Email();
        e.sendMail(u);
        JOptionPane.showMessageDialog(p1,"EMAIL SEND","success", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        Connect j=new Connect();
        String user="";
        DBCollection dbc=j.connect("Report");
        
        DBCursor cursor=dbc.find();
        while(cursor.hasNext())
        {
        DBObject obj2=cursor.next();
        String result=obj2.toString();
        
        user=(String)obj2.get("Email");
        if(u.equals(user))
        {
            System.out.println(obj2);
        txtDisp.setText(result);
        }
        
        
        }      
    }//GEN-LAST:event_btnViewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pdf p=new pdf();
          // TODO add your handling code here:
        Connect j=new Connect();
        String user="";
        DBCollection dbc=j.connect("Report");
         final     JPanel p1 = new JPanel();
        DBCursor cursor=dbc.find();
        while(cursor.hasNext())
        {
        DBObject obj2=cursor.next();
        String result=obj2.toString();
        
        user=(String)obj2.get("Email");
        if(u.equals(user))
        {
          p.crePf(result); 
          JOptionPane.showMessageDialog(p1,"PDF CREATED SUCCESSFULLY","success", JOptionPane.INFORMATION_MESSAGE);
       
        }
        
        
        }     
        
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
            java.util.logging.Logger.getLogger(viewRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRec(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDisp;
    // End of variables declaration//GEN-END:variables
}
