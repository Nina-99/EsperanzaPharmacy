package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmBill extends javax.swing.JFrame {

    frmBill.FondPanel fond = new frmBill.FondPanel();

    public frmBill() {
        this.setContentPane(fond);
        initComponents();
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/Bill1.png"));
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
        jTnumfac = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNameBuyer = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAddressBuyer = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNitBuyer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tproductos = new javax.swing.JTable();
        lbTotal = new javax.swing.JLabel();
        lbBs = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setTitle("Factura");
        setIconImage(getIconImage());
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "FACTURA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Factura Nº: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(600, 40, 93, 31);

        jTnumfac.setEditable(false);
        jTnumfac.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTnumfac.setToolTipText("");
        jPanel1.add(jTnumfac);
        jTnumfac.setBounds(700, 40, 70, 25);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 80, 72, 18);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Farmacia \"Esperanza\"");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 80, 132, 17);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("NIT:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 110, 35, 18);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("1215678987");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 110, 80, 17);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 140, 77, 18);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bolivar entre Pagador y Velazco Galvarro");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 140, 247, 17);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("Lugar de Expedicion: ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 170, 169, 18);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Oruro - Bolivia");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 170, 86, 17);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(460, 110, 67, 18);

        txtNameBuyer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameBuyerKeyTyped(evt);
            }
        });
        jPanel1.add(txtNameBuyer);
        txtNameBuyer.setBounds(560, 110, 220, 24);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Dirección:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(460, 140, 77, 18);

        txtAddressBuyer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressBuyerKeyTyped(evt);
            }
        });
        jPanel1.add(txtAddressBuyer);
        txtAddressBuyer.setBounds(560, 140, 220, 24);

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 255));
        jLabel12.setText("NIT:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(460, 170, 35, 18);

        txtNitBuyer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitBuyerKeyTyped(evt);
            }
        });
        jPanel1.add(txtNitBuyer);
        txtNitBuyer.setBounds(560, 170, 220, 24);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setText("Productos:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(60, 230, 85, 30);

        Tproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre del Producto", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tproductos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 260, 723, 220);

        lbTotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(0, 255, 255));
        lbTotal.setText("Total: ");
        jPanel1.add(lbTotal);
        lbTotal.setBounds(90, 500, 50, 18);

        lbBs.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lbBs.setForeground(new java.awt.Color(0, 153, 0));
        lbBs.setText("Bs.");
        jPanel1.add(lbBs);
        lbBs.setBounds(140, 480, 50, 60);

        txtTotal.setEditable(false);
        txtTotal.setText("0.00");
        jPanel1.add(txtTotal);
        txtTotal.setBounds(180, 490, 229, 37);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Print1.png"))); // NOI18N
        btnPrint.setText("IMPRIMIR");
        jPanel1.add(btnPrint);
        btnPrint.setBounds(620, 540, 150, 53);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 10, 80, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 610);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info");

        jMenuItem2.setText("Acerca de...");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameBuyerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameBuyerKeyTyped
        int k = (int) evt.getKeyChar();
        if (k > 47 && k < 58) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar letras.....!!!");
        }
        int numerocaracteres = 30;
        if (txtNameBuyer.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtNameBuyerKeyTyped

    private void txtAddressBuyerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressBuyerKeyTyped
        int numerocaracteres = 30;
        if (txtAddressBuyer.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtAddressBuyerKeyTyped

    private void txtNitBuyerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitBuyerKeyTyped
        int k = (int) evt.getKeyChar();
        if (k > 97 && k < 122 || k > 65 && k < 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(rootPane, "Solo pueden ingresar numeros.....!!!");
        }
        if (k > 241 && k < 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(rootPane, "Solo pueden ingresar numeros.....!!!");
        }
        if (k == 10) {
            txtNitBuyer.transferFocus();
        }
        int numerocaracteres = 10;
        if (txtNitBuyer.getText().length() >= numerocaracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo puede ingresar " + numerocaracteres + " caracteres.....!!!");
        }
    }//GEN-LAST:event_txtNitBuyerKeyTyped

    /**
     * @param args the command line arguments
     */    

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
            java.util.logging.Logger.getLogger(frmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmBill fact = new frmBill();
                fact.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tproductos;
    public javax.swing.JButton btnPrint;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTnumfac;
    public javax.swing.JLabel lbBs;
    public javax.swing.JLabel lbTotal;
    public javax.swing.JTextField txtAddressBuyer;
    public javax.swing.JTextField txtNameBuyer;
    public javax.swing.JTextField txtNitBuyer;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
