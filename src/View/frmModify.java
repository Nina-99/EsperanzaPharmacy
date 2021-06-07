package View;

import Model.DbConnection;
import View.frmAdministrator;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmModify extends javax.swing.JFrame {

    
    DbConnection con;
    ResultSet rs;

    //private Image bgImage;
    /**
     * Creates new form capturista
     */
    frmModify.FondPanel fond = new frmModify.FondPanel();

    public frmModify() {
        this.setContentPane(fond);
        initComponents();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/Pharmacy icon1.png"));
        return retValue;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCurrentPass = new javax.swing.JPasswordField();
        lbChek1 = new javax.swing.JLabel();
        lbCurrentPassError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        lbChek2 = new javax.swing.JLabel();
        lbPassError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRepitPass = new javax.swing.JPasswordField();
        lbChek3 = new javax.swing.JLabel();
        lbRepitError = new javax.swing.JLabel();
        btnChange = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "MODIFICAR CONTRASEÑA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(51, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Contraseña Actual:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 90, 150, 17);

        txtCurrentPass.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCurrentPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentPassActionPerformed(evt);
            }
        });
        txtCurrentPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurrentPassKeyTyped(evt);
            }
        });
        jPanel1.add(txtCurrentPass);
        txtCurrentPass.setBounds(190, 90, 190, 30);

        lbChek1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/accept1.png"))); // NOI18N
        lbChek1.setText(" ");
        jPanel1.add(lbChek1);
        lbChek1.setBounds(380, 90, 30, 30);

        lbCurrentPassError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbCurrentPassError.setForeground(new java.awt.Color(255, 0, 0));
        lbCurrentPassError.setText("* Campo Requerido");
        jPanel1.add(lbCurrentPassError);
        lbCurrentPassError.setBounds(70, 120, 290, 19);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Contraseña Nueva:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 140, 133, 17);

        txtNewPass.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtNewPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNewPassKeyTyped(evt);
            }
        });
        jPanel1.add(txtNewPass);
        txtNewPass.setBounds(190, 140, 190, 30);

        lbChek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/accept1.png"))); // NOI18N
        lbChek2.setText(" ");
        jPanel1.add(lbChek2);
        lbChek2.setBounds(380, 140, 30, 30);

        lbPassError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbPassError.setForeground(new java.awt.Color(255, 0, 0));
        lbPassError.setText("* Campo Requerido");
        jPanel1.add(lbPassError);
        lbPassError.setBounds(70, 170, 290, 19);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Confirmar Contraseña:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 190, 190, 17);

        txtRepitPass.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtRepitPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepitPassActionPerformed(evt);
            }
        });
        txtRepitPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepitPassKeyTyped(evt);
            }
        });
        jPanel1.add(txtRepitPass);
        txtRepitPass.setBounds(190, 190, 190, 30);

        lbChek3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/accept1.png"))); // NOI18N
        lbChek3.setText(" ");
        jPanel1.add(lbChek3);
        lbChek3.setBounds(380, 190, 30, 30);

        lbRepitError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbRepitError.setForeground(new java.awt.Color(255, 0, 0));
        lbRepitError.setText("* Campo Requerido");
        jPanel1.add(lbRepitError);
        lbRepitError.setBounds(60, 220, 290, 19);

        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Change.png"))); // NOI18N
        btnChange.setText("CAMBIAR");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        jPanel1.add(btnChange);
        btnChange.setBounds(60, 260, 120, 35);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/CANCEL.png"))); // NOI18N
        btnCancel.setText("CANCELAR");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(240, 260, 130, 33);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 330);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Cancelar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info");

        jMenuItem2.setText("Leeme.....");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtCurrentPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentPassActionPerformed
    }//GEN-LAST:event_txtCurrentPassActionPerformed

    private void txtCurrentPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentPassKeyTyped
        int numerocaracteres = 10;
        if (txtCurrentPass.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtCurrentPassKeyTyped

    private void txtNewPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPassKeyTyped
        int numerocaracteres = 10;
        if (txtNewPass.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtNewPassKeyTyped

    private void txtRepitPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepitPassActionPerformed
    }//GEN-LAST:event_txtRepitPassActionPerformed

    private void txtRepitPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepitPassKeyTyped
        int numerocaracteres = 10;
        if (txtRepitPass.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtRepitPassKeyTyped

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        
    }//GEN-LAST:event_btnCancelActionPerformed

    public int setId(int id) {
        return id;
    }

    class FondPanel extends JPanel {

        private Image image;

        @Override
        public void paint(Graphics g) {
            image = new ImageIcon(getClass().getResource("/Image/Fondo 2.jpg")).getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    /**
     * @param args the command line arguments
     */

//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnChange;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbChek1;
    public javax.swing.JLabel lbChek2;
    public javax.swing.JLabel lbChek3;
    public javax.swing.JLabel lbCurrentPassError;
    public javax.swing.JLabel lbPassError;
    public javax.swing.JLabel lbRepitError;
    public javax.swing.JPasswordField txtCurrentPass;
    public javax.swing.JPasswordField txtNewPass;
    public javax.swing.JPasswordField txtRepitPass;
    // End of variables declaration//GEN-END:variables
public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmModify().setVisible(true);

            }
        });

    }
}
