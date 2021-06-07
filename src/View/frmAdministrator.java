package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class frmAdministrator extends javax.swing.JFrame implements Runnable {
    
    String hour, minutes, seconds, ampm;
    Thread h1;

    frmAdministrator.FondPanel fond = new frmAdministrator.FondPanel();

    public frmAdministrator() {
        initComponents();
        h1 = new Thread(this);
        h1.start();        
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/Pharmacy icon1.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new FondPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSpecification = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        jdcExpiration = new com.toedter.calendar.JDateChooser();
        lbNameError = new javax.swing.JLabel();
        lbPriceError = new javax.swing.JLabel();
        lbQuantityError = new javax.swing.JLabel();
        lbDescriptionError = new javax.swing.JLabel();
        lbSpecificationError = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new FondPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSearchDescription = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEditName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtEditDescription = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtEditPrice = new javax.swing.JTextField();
        jdcEditExpiration = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        txtEditQuantity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEditSpecification = new javax.swing.JTextArea();
        btnModify = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbuscar = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new FondPanel();
        jPanel6 = new javax.swing.JPanel();
        lbHora2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNameSale = new javax.swing.JTextField();
        btnAddSale = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTtotal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tproductos = new javax.swing.JTable();
        btnClean = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tlista = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new FondPanel();
        jPanel8 = new javax.swing.JPanel();
        btnAlertExpiration = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        btnAlertQuantity = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Talertas = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jPanel9 = new FondPanel();
        jPanel10 = new javax.swing.JPanel();
        lbHora3 = new javax.swing.JLabel();
        btnSaleDay = new javax.swing.JButton();
        jcbUser = new javax.swing.JComboBox();
        btnTotalSale = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTinvT = new javax.swing.JTextField();
        jdcInventario = new com.toedter.calendar.JDateChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTinventario = new javax.swing.JTable();
        lbName = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Caducidad:");

        jLabel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Modificar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 153, 255))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farmacia // Interfaz Administrador");
        setIconImage(getIconImage());
        getContentPane().setLayout(null);

        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setOpaque(true);

        jPanel1.setToolTipText("");
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "AGREGAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Nombre del Producto:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 40, 144, 16);
        jPanel2.add(txtName);
        txtName.setBounds(210, 40, 220, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Caducidad:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 110, 73, 16);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Descripcion:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 190, 82, 16);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtDescription);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 210, 340, 140);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("Precio:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(460, 40, 47, 16);
        jPanel2.add(txtPrice);
        txtPrice.setBounds(560, 40, 140, 24);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("Existencia:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(460, 100, 72, 16);

        txtQuantity.setToolTipText("");
        txtQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(txtQuantity);
        txtQuantity.setBounds(560, 100, 100, 24);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Especificaciones: ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(450, 180, 117, 16);

        txtSpecification.setColumns(20);
        txtSpecification.setRows(5);
        jScrollPane2.setViewportView(txtSpecification);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(450, 210, 340, 140);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnAdd.setText("AGREGAR");
        jPanel2.add(btnAdd);
        btnAdd.setBounds(330, 380, 150, 40);
        jPanel2.add(jdcExpiration);
        jdcExpiration.setBounds(160, 100, 170, 30);

        lbNameError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbNameError.setForeground(new java.awt.Color(255, 0, 0));
        lbNameError.setText("* Campo Requerido");
        jPanel2.add(lbNameError);
        lbNameError.setBounds(120, 60, 290, 19);

        lbPriceError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbPriceError.setForeground(new java.awt.Color(255, 0, 0));
        lbPriceError.setText("* Campo Requerido");
        jPanel2.add(lbPriceError);
        lbPriceError.setBounds(440, 60, 290, 19);

        lbQuantityError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbQuantityError.setForeground(new java.awt.Color(255, 0, 0));
        lbQuantityError.setText("* Campo Requerido");
        jPanel2.add(lbQuantityError);
        lbQuantityError.setBounds(470, 130, 290, 19);

        lbDescriptionError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbDescriptionError.setForeground(new java.awt.Color(255, 0, 0));
        lbDescriptionError.setText("* Campo Requerido");
        jPanel2.add(lbDescriptionError);
        lbDescriptionError.setBounds(80, 350, 290, 19);

        lbSpecificationError.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        lbSpecificationError.setForeground(new java.awt.Color(255, 0, 0));
        lbSpecificationError.setText("* Campo Requerido");
        jPanel2.add(lbSpecificationError);
        lbSpecificationError.setBounds(480, 350, 290, 19);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 820, 450);
        jPanel1.add(jLabel27);
        jLabel27.setBounds(0, 0, 290, 80);

        jTabbedPane1.addTab("Agregar", new javax.swing.ImageIcon(getClass().getResource("/Icon/ADD PURCHASE.png")), jPanel1, "Agregar Producto"); // NOI18N

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText("Busqueda por Nombre:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(30, 40, 151, 16);
        jPanel4.add(txtSearchName);
        txtSearchName.setBounds(190, 40, 220, 24);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("O Descripcion:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(430, 40, 100, 16);
        jPanel4.add(txtSearchDescription);
        txtSearchDescription.setBounds(530, 40, 220, 24);

        jLabel12.setForeground(new java.awt.Color(0, 255, 255));
        jLabel12.setText("ID Admin:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(670, 10, 53, 20);

        jTID.setEditable(false);
        jTID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(jTID);
        jTID.setBounds(730, 10, 70, 24);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setText("Nombre Producto:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(40, 350, 120, 16);

        txtEditName.setEditable(false);
        jPanel4.add(txtEditName);
        txtEditName.setBounds(180, 350, 220, 24);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 255));
        jLabel14.setText("Caducidad:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(40, 390, 73, 16);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 255));
        jLabel15.setText("Descripción:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(40, 430, 82, 16);

        txtEditDescription.setEditable(false);
        txtEditDescription.setColumns(20);
        txtEditDescription.setRows(5);
        txtEditDescription.setOpaque(false);
        jScrollPane8.setViewportView(txtEditDescription);

        jPanel4.add(jScrollPane8);
        jScrollPane8.setBounds(170, 430, 230, 110);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 255));
        jLabel16.setText("Precio:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(420, 350, 47, 16);

        txtEditPrice.setEditable(false);
        jPanel4.add(txtEditPrice);
        txtEditPrice.setBounds(540, 350, 110, 24);
        jPanel4.add(jdcEditExpiration);
        jdcEditExpiration.setBounds(180, 380, 170, 30);

        jLabel171.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(0, 255, 255));
        jLabel171.setText("Existencia:");
        jPanel4.add(jLabel171);
        jLabel171.setBounds(420, 390, 72, 16);

        txtEditQuantity.setEditable(false);
        jPanel4.add(txtEditQuantity);
        txtEditQuantity.setBounds(540, 390, 110, 24);

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 255));
        jLabel18.setText("Especificaciones:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(420, 430, 113, 16);

        txtEditSpecification.setEditable(false);
        txtEditSpecification.setColumns(20);
        txtEditSpecification.setRows(5);
        txtEditSpecification.setOpaque(false);
        jScrollPane7.setViewportView(txtEditSpecification);

        jPanel4.add(jScrollPane7);
        jScrollPane7.setBounds(540, 430, 240, 110);

        btnModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ACCEPT.png"))); // NOI18N
        btnModify.setText("ACEPTAR");
        jPanel4.add(btnModify);
        btnModify.setBounds(380, 550, 170, 40);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnEdit.setText("EDITAR");
        jPanel4.add(btnEdit);
        btnEdit.setBounds(330, 270, 160, 40);

        jTbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTbuscar.setColumnSelectionAllowed(true);
        jTbuscar.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTbuscar);
        jTbuscar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(60, 70, 700, 190);

        jLabel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.add(jLabel19);
        jLabel19.setBounds(10, 0, 800, 320);

        jLabel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Modificar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.add(jLabel20);
        jLabel20.setBounds(10, 320, 800, 290);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 820, 640);
        jPanel3.add(jLabel28);
        jLabel28.setBounds(0, 0, 290, 80);

        jTabbedPane1.addTab("Buscar/Modificar", new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png")), jPanel3, "Buscar Productos y Modificarlos"); // NOI18N

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "VENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        lbHora2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbHora2.setForeground(new java.awt.Color(0, 255, 255));
        lbHora2.setText("Time");
        jPanel6.add(lbHora2);
        lbHora2.setBounds(700, 10, 140, 29);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 255));
        jLabel21.setText("Nombre Producto:");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(80, 30, 115, 17);
        jPanel6.add(txtNameSale);
        txtNameSale.setBounds(210, 30, 220, 24);

        btnAddSale.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/AddSale.png"))); // NOI18N
        btnAddSale.setText("AGREGAR");
        jPanel6.add(btnAddSale);
        btnAddSale.setBounds(60, 250, 140, 40);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 255, 255));
        jLabel22.setText("Total:");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(520, 260, 35, 17);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Bs.");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(560, 240, 40, 60);

        jTtotal.setEditable(false);
        jTtotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTtotal.setForeground(new java.awt.Color(255, 0, 0));
        jTtotal.setText("0.00");
        jPanel6.add(jTtotal);
        jTtotal.setBounds(600, 240, 220, 60);

        Tproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(Tproductos);

        jPanel6.add(jScrollPane4);
        jScrollPane4.setBounds(60, 60, 760, 170);

        btnClean.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Clear.png"))); // NOI18N
        btnClean.setText("LIMPIAR");
        jPanel6.add(btnClean);
        btnClean.setBounds(60, 490, 140, 40);

        btnBill.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Bill.png"))); // NOI18N
        btnBill.setText("GENERAR FACTURA");
        jPanel6.add(btnBill);
        btnBill.setBounds(350, 520, 200, 40);

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Pay1.png"))); // NOI18N
        btnPay.setText("COBRAR IMPRIMIR RECIBO");
        jPanel6.add(btnPay);
        btnPay.setBounds(570, 520, 250, 40);

        Tlista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Tlista);
        if (Tlista.getColumnModel().getColumnCount() > 0) {
            Tlista.getColumnModel().getColumn(0).setResizable(false);
            Tlista.getColumnModel().getColumn(1).setResizable(false);
            Tlista.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel6.add(jScrollPane5);
        jScrollPane5.setBounds(60, 310, 760, 180);
        jPanel6.add(jLabel30);
        jLabel30.setBounds(205, 228, 300, 80);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 850, 600);

        jTabbedPane1.addTab("Venta", new javax.swing.ImageIcon(getClass().getResource("/Icon/SALE.png")), jPanel5, "Realizar una Venta"); // NOI18N

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(null);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "ALERTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(null);

        btnAlertExpiration.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlertExpiration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/AlertExpiration.png"))); // NOI18N
        btnAlertExpiration.setText("ALERTA DE CADUCIDAD ");
        jPanel8.add(btnAlertExpiration);
        btnAlertExpiration.setBounds(110, 350, 210, 40);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 255, 255));
        jLabel24.setText("Caduca en Maximo 3 meses");
        jPanel8.add(jLabel24);
        jLabel24.setBounds(120, 390, 180, 20);

        btnAlertQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlertQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prouctosmed.png"))); // NOI18N
        btnAlertQuantity.setText("ALERTA DE EXISTENCIAS");
        jPanel8.add(btnAlertQuantity);
        btnAlertQuantity.setBounds(460, 350, 210, 40);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 255, 255));
        jLabel25.setText("Existencia menor a?");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(510, 390, 130, 20);

        Talertas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Talertas.setShowVerticalLines(false);
        Talertas.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(Talertas);

        jPanel8.add(jScrollPane6);
        jScrollPane6.setBounds(50, 40, 750, 300);

        jPanel7.add(jPanel8);
        jPanel8.setBounds(0, 0, 840, 430);
        jPanel7.add(jLabel31);
        jLabel31.setBounds(0, 0, 290, 80);

        jTabbedPane1.addTab("Alertas", new javax.swing.ImageIcon(getClass().getResource("/Icon/Messages.png")), jPanel7, "Alertas de Poco Producto o Caducidad"); // NOI18N

        jPanel9.setOpaque(false);
        jPanel9.setLayout(null);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "INVENTARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel10.setOpaque(false);
        jPanel10.setLayout(null);

        lbHora3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbHora3.setForeground(new java.awt.Color(0, 255, 255));
        lbHora3.setText("Time");
        jPanel10.add(lbHora3);
        lbHora3.setBounds(640, 10, 160, 30);

        btnSaleDay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaleDay.setText("VENTAS POR DIA");
        jPanel10.add(btnSaleDay);
        btnSaleDay.setBounds(20, 410, 140, 40);

        jcbUser.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jcbUser.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(jcbUser);
        jcbUser.setBounds(190, 400, 140, 28);

        btnTotalSale.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTotalSale.setText("TOTAL VENTAS");
        jPanel10.add(btnTotalSale);
        btnTotalSale.setBounds(440, 430, 140, 40);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Bs.");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(570, 370, 40, 40);

        jTinvT.setEditable(false);
        jTinvT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTinvT.setForeground(new java.awt.Color(255, 0, 0));
        jTinvT.setText("0.00");
        jPanel10.add(jTinvT);
        jTinvT.setBounds(610, 370, 180, 46);
        jPanel10.add(jdcInventario);
        jdcInventario.setBounds(190, 440, 140, 30);

        jTinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTinventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTinventario);
        jTinventario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel10.add(jScrollPane9);
        jScrollPane9.setBounds(20, 50, 770, 314);

        lbName.setBackground(new java.awt.Color(255, 255, 255));
        lbName.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 0, 0));
        lbName.setText("Nombre");
        jPanel10.add(lbName);
        lbName.setBounds(150, 370, 220, 30);

        jPanel9.add(jPanel10);
        jPanel10.setBounds(0, 0, 810, 510);
        jPanel9.add(jLabel32);
        jLabel32.setBounds(0, 0, 290, 80);

        jTabbedPane1.addTab("Inventario", new javax.swing.ImageIcon(getClass().getResource("/Icon/Stock1.png")), jPanel9); // NOI18N

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 870, 680);

        jMenu1.setText("Agregar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Usuario");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Modificar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Contraseña");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Salir");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Cerrar Sesion");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Salir");
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void calcula() {
        Calendar calendario1 = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario1.setTime(fechaHoraActual);
        ampm = calendario1.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario1.get(Calendar.HOUR_OF_DAY);
            hour = h > 9 ? "" + h : "0" + h;
        } else {
            hour = calendario1.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario1.get(Calendar.HOUR_OF_DAY) : "0" + calendario1.get(Calendar.HOUR_OF_DAY);
        }
        minutes = calendario1.get(Calendar.MINUTE) > 9 ? "" + calendario1.get(Calendar.MINUTE) : "0" + calendario1.get(Calendar.MINUTE);
        seconds = calendario1.get(Calendar.SECOND) > 9 ? "" + calendario1.get(Calendar.SECOND) : "0" + calendario1.get(Calendar.SECOND);
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
    
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbHora2.setText(hour + ":" + minutes + ":" + seconds + " " + ampm);
            lbHora3.setText(hour + ":" + minutes + ":" + seconds + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Talertas;
    public javax.swing.JTable Tlista;
    public javax.swing.JTable Tproductos;
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnAddSale;
    public javax.swing.JButton btnAlertExpiration;
    public javax.swing.JButton btnAlertQuantity;
    public javax.swing.JButton btnBill;
    public javax.swing.JButton btnClean;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnModify;
    public javax.swing.JButton btnPay;
    public javax.swing.JButton btnSaleDay;
    public javax.swing.JButton btnTotalSale;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel171;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel30;
    public javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu4;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTextField jTID;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTbuscar;
    public javax.swing.JTextField jTinvT;
    public javax.swing.JTable jTinventario;
    public javax.swing.JTextField jTtotal;
    public javax.swing.JComboBox jcbUser;
    public com.toedter.calendar.JDateChooser jdcEditExpiration;
    public com.toedter.calendar.JDateChooser jdcExpiration;
    public com.toedter.calendar.JDateChooser jdcInventario;
    public javax.swing.JLabel lbDescriptionError;
    public javax.swing.JLabel lbHora2;
    public javax.swing.JLabel lbHora3;
    public javax.swing.JLabel lbName;
    public javax.swing.JLabel lbNameError;
    public javax.swing.JLabel lbPriceError;
    public javax.swing.JLabel lbQuantityError;
    public javax.swing.JLabel lbSpecificationError;
    public javax.swing.JTextArea txtDescription;
    public javax.swing.JTextArea txtEditDescription;
    public javax.swing.JTextField txtEditName;
    public javax.swing.JTextField txtEditPrice;
    public javax.swing.JTextField txtEditQuantity;
    public javax.swing.JTextArea txtEditSpecification;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtNameSale;
    public javax.swing.JTextField txtPrice;
    public javax.swing.JTextField txtQuantity;
    public javax.swing.JTextField txtSearchDescription;
    public javax.swing.JTextField txtSearchName;
    public javax.swing.JTextArea txtSpecification;
    // End of variables declaration//GEN-END:variables
}