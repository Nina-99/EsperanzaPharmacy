package Controller;

import static Controller.EmployeeController.Total;
import Model.ProductModel;
import Model.ProductDAO;
import Model.SaleDAO;
import Model.SoldDAO;
import Model.SoldModel;
import Model.UserModel;
import Model.UserDAO;
import View.frmAdministrator;
import View.frmBill;
import View.frmLogin;
import View.frmModify;
import View.frmRegister;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdministratorController implements ActionListener, KeyListener, ItemListener{
    frmAdministrator Administrator = new frmAdministrator();
    ProductDAO productDAO = new ProductDAO();
    ProductModel productModel = new ProductModel();
    UserDAO userDAO = new UserDAO();
    UserModel userModel = new UserModel();
    SoldDAO soldDAO = new SoldDAO();
    static int j = 0;
    static float total = 0, invT = 0;
    private String id;
    int IdUser;
    public static int numfac;

    public AdministratorController(int IdUser, frmAdministrator Administrator, ProductDAO productDAO) {
        this.Administrator = Administrator;
        this.productDAO = productDAO;
        this.IdUser = IdUser;
        this.Administrator.btnAdd.addActionListener(this);
        this.Administrator.btnEdit.addActionListener(this);
        this.Administrator.btnModify.addActionListener(this);
        this.Administrator.btnAddSale.addActionListener(this);
        this.Administrator.btnClean.addActionListener(this);
        this.Administrator.btnBill.addActionListener(this);
        this.Administrator.btnPay.addActionListener(this);
        this.Administrator.btnAlertExpiration.addActionListener(this);
        this.Administrator.btnAlertQuantity.addActionListener(this);
        this.Administrator.btnSaleDay.addActionListener(this);
        this.Administrator.btnTotalSale.addActionListener(this);
        this.Administrator.jMenuItem1.addActionListener(this);
        this.Administrator.jMenuItem2.addActionListener(this);
        this.Administrator.jMenuItem3.addActionListener(this);
        this.Administrator.jMenuItem4.addActionListener(this);
        this.Administrator.txtSearchName.addKeyListener(this);
        this.Administrator.txtSearchDescription.addKeyListener(this);
        this.Administrator.txtNameSale.addKeyListener(this);
        this.Administrator.txtName.addKeyListener(this);
        this.Administrator.txtPrice.addKeyListener(this);
        this.Administrator.txtQuantity.addKeyListener(this);
        this.Administrator.txtDescription.addKeyListener(this);
        this.Administrator.txtSpecification.addKeyListener(this);
        this.Administrator.jcbUser.addItemListener(this);
        Initialize();
    }
    
    public void Initialize() {
        this.Administrator.setExtendedState(MAXIMIZED_BOTH);
        this.Administrator.setLocationRelativeTo(null);
        Administrator.jLabel27.setIcon(SImage("/Image/Titulo.png", Administrator.jLabel27));
        Administrator.jLabel28.setIcon(SImage("/Image/Titulo.png", Administrator.jLabel28));
        Administrator.jLabel30.setIcon(SImage("/Image/Titulo.png", Administrator.jLabel30));
        Administrator.jLabel31.setIcon(SImage("/Image/Titulo.png", Administrator.jLabel31));
        Administrator.jLabel32.setIcon(SImage("/Image/Titulo.png", Administrator.jLabel32));
        ((JTextField)this.Administrator.jdcEditExpiration.getDateEditor()).setEditable(false);
        this.Administrator.jdcEditExpiration.getCalendarButton().setEnabled(false);
        Administrator.jTID.setText(String.valueOf(IdUser));
        Calendar minDate = Calendar.getInstance();
        minDate.setTime(new Date());
        minDate.add(Calendar.DAY_OF_YEAR, 15);
        Administrator.jdcExpiration.setMinSelectableDate(minDate.getTime());
        Administrator.jdcInventario.setMaxSelectableDate(new Date());
        LinkedList<UserModel> listUser = userDAO.ViewUser();
        for (int i = 0; i < listUser.size(); i++) {
            Administrator.jcbUser.addItem(listUser.get(i).getAccount());
        }
        modifySize();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Administrator.btnAdd) {
            addProduct();
        }else if (origin == this.Administrator.btnEdit) {
            modifyProduct();
        }else if (origin == this.Administrator.btnModify) {
            acceptProduct();
        }else if (origin == this.Administrator.btnAddSale) {
            addSale();
        }else if (origin == this.Administrator.btnClean) {
            int x = Administrator.Tlista.getRowCount() - 1;
            DefaultTableModel table = (DefaultTableModel) Administrator.Tlista.getModel();
            Clean(x, table);
        }else if (origin == this.Administrator.btnBill) {
            billProduct();
        }else if (origin == this.Administrator.btnPay) {
            Pay();
        }else if (origin == this.Administrator.btnAlertExpiration) {
            int x = Administrator.Talertas.getRowCount() - 1;
            DefaultTableModel table = (DefaultTableModel) Administrator.Talertas.getModel();
            Clean(x, table);
            VerifyExpiration();
        }else if (origin == this.Administrator.btnAlertQuantity) {
            String quantity = JOptionPane.showInputDialog("¿Que cantidad debe de ser como minimo?");
            int x = Administrator.Talertas.getRowCount() - 1;
            DefaultTableModel table = (DefaultTableModel) Administrator.Talertas.getModel();
            Clean(x, table);
            VerifyQuantity(Integer.parseInt(quantity));
        }else if (origin == this.Administrator.btnSaleDay) {
            if (Administrator.jdcInventario.getDate() == null){
                JOptionPane.showMessageDialog(null, "No se registro una fecha!");
            }else {
                userModel = userDAO.Verify((String)Administrator.jcbUser.getSelectedItem());
                SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(Administrator.jdcInventario.getDate());
                LinkedList<SoldModel> listSold = new LinkedList<SoldModel>();
                listSold = soldDAO.ViewSold(userModel.getId_user(),date);
                DefaultTableModel table = SaleInventory(listSold);
                Administrator.jTinventario.setModel(table);
            }
        }else if (origin == this.Administrator.btnTotalSale) {
            LinkedList<SoldModel> listSold = new LinkedList<SoldModel>();
            listSold = soldDAO.ViewSoldAll();
            DefaultTableModel table = SaleInventory(listSold);
            Administrator.jTinventario.setModel(table);
        }else if (origin == this.Administrator.jMenuItem1) {
            frmRegister Register = new frmRegister();
            RegisterController registerController = new RegisterController(Register, userDAO);
            Register.setVisible(true);            
        }else if (origin == this.Administrator.jMenuItem2) {
            frmModify Modify = new frmModify();
            UserModel userModel = new UserModel();
            ModifyController modifyController = new ModifyController(Modify, userDAO, userModel);
            modifyController.id = IdUser;
            System.out.println("id para modificar: " + modifyController.id);
            Modify.setVisible(true);                        
        }else if (origin == this.Administrator.jMenuItem3){
            if (JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar la sesion actual?", "Cerrar sesión", 1) == 0) {
                Administrator.dispose();
                frmLogin Login = new frmLogin();
                LoginController loginController = new LoginController(Login, userDAO);
                Login.setLocationRelativeTo(null);
                Login.setVisible(true);
            }            
        }else if (origin == this.Administrator.jMenuItem4) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrar el Sistema?", "Cerrar Sistema", 1) == 0) {
                System.exit(0);
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Object origin = e.getSource();
        Validation();
        if (origin == this.Administrator.txtSearchName){
            DefaultTableModel tabla = SearchName(Administrator.txtSearchName.getText());
            Administrator.jTbuscar.setModel(tabla);
        }else if (origin == this.Administrator.txtSearchDescription){
            
        }else if (origin == this.Administrator.txtNameSale){
            DefaultTableModel tabla = SearchName(Administrator.txtNameSale.getText());
            Administrator.Tproductos.setModel(tabla);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == Administrator.jcbUser) {
            userModel = userDAO.Verify((String)Administrator.jcbUser.getSelectedItem());
            Administrator.lbName.setText(userModel.getName()+" "+userModel.getSurname_pater());
        }
    }
    
    public void addProduct() {
        if (Administrator.txtName.getText().equals("") || Administrator.jdcExpiration.getDate().equals(null) || Administrator.txtPrice.getText().equals("")
            || Administrator.txtQuantity.getText().equals("") || Administrator.txtDescription.getText().equals("") || Administrator.txtSpecification.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");
        } else {
            String name = Administrator.txtName.getText();
            Double price = Double.parseDouble(Administrator.txtPrice.getText());
            SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String expiration = simpleDateFormat.format(Administrator.jdcExpiration.getDate());
            int quantity = Integer.parseInt(Administrator.txtQuantity.getText());
            String description = Administrator.txtDescription.getText();
            String specification = Administrator.txtSpecification.getText();
            productDAO.AddProduct(name, price, expiration, quantity, description, specification);
            JOptionPane.showMessageDialog(null, "Producto: " + name + " agregado.");
            // Se limpian los campos de texto para seguir agregando mas datos.
            Administrator.txtName.setText("");
            Administrator.txtPrice.setText("");
            Administrator.jdcExpiration.setDate(null);
            Administrator.txtQuantity.setText("");
            Administrator.txtDescription.setText("");
            Administrator.txtSpecification.setText("");
        }
    }
    
    public DefaultTableModel SearchName(String Name) {
        String Title[] = {"Id", "Nombre", "Precio", "Expiracion", "Cantidad", "Descripcion", "Especificaciones" };
        DefaultTableModel tabla = new DefaultTableModel(null, Title);
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        listProduct = productDAO.ViewProduct(Name);
        tabla.setNumRows(0);
        for (int i = 0; i < listProduct.size(); i++) {
            Object[] row = {listProduct.get(i).getId_product(),listProduct.get(i).getName_product(), listProduct.get(i).getPrice(),listProduct.get(i).getExpiration(),listProduct.get(i).getQuantity(),listProduct.get(i).getDescription(),listProduct.get(i).getSpecification()};
            tabla.addRow(row);
        }
        return tabla;
    }
    
    public void modifyProduct() {
        int Option = this.Administrator.jTbuscar.getSelectedRow();
        if (Option == -1) {
            JOptionPane.showMessageDialog(null, "No se a seleccionado el Producto de la tabla.");
        } else {
            id = Administrator.jTbuscar.getValueAt(Option, 0).toString();
            Administrator.txtEditName.setText(this.Administrator.jTbuscar.getValueAt(Option, 1).toString());
            Administrator.txtEditPrice.setText(this.Administrator.jTbuscar.getValueAt(Option, 2).toString());
            //Administrator.txtEditExpiration.setText(this.Administrator.jTbuscar.getValueAt(Option, 3).toString());
            String fecha = this.Administrator.jTbuscar.getValueAt(Option, 3).toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
            try {
                Administrator.jdcEditExpiration.setDate(simpleDateFormat.parse(fecha));
            } catch (ParseException ex) {
                Logger.getLogger(AdministratorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Administrator.txtEditQuantity.setText(this.Administrator.jTbuscar.getValueAt(Option, 4).toString());
            Administrator.txtEditDescription.setText(this.Administrator.jTbuscar.getValueAt(Option, 5).toString());
            Administrator.txtEditSpecification.setText(this.Administrator.jTbuscar.getValueAt(Option, 6).toString());
            Administrator.txtEditName.setEditable(true);
            Administrator.txtEditPrice.setEditable(true);
            ((JTextField)Administrator.jdcEditExpiration.getDateEditor()).setEditable(false);
            Administrator.jdcEditExpiration.getCalendarButton().setEnabled(true);
            this.Administrator.jdcEditExpiration.setMinSelectableDate(Administrator.jdcEditExpiration.getDate());
            Administrator.txtEditQuantity.setEditable(true);
            Administrator.txtEditDescription.setEditable(true);
            Administrator.txtEditSpecification.setEditable(true);
        }
    }

    public void acceptProduct() {
        if (Administrator.txtEditName.getText().equals("") || Administrator.jdcEditExpiration.getDate().equals("") || Administrator.txtEditPrice.getText().equals("")
            || Administrator.txtEditQuantity.getText().equals("") || Administrator.txtEditDescription.getText().equals("") || Administrator.txtEditSpecification.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");
        } else {
            int Id = Integer.parseInt(id);
            String name = Administrator.txtEditName.getText();
            Double price = Double.parseDouble(Administrator.txtEditPrice.getText());
            SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String expiration = simpleDateFormat.format(Administrator.jdcEditExpiration.getDate());
            int quantity = Integer.parseInt(Administrator.txtEditQuantity.getText());
            String description = Administrator.txtEditDescription.getText();
            String specification = Administrator.txtEditSpecification.getText();
            productDAO.ModifyProduct(Id, name, price, expiration, quantity, description, specification);
        }
    }
    
    public void addSale() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        int aux = Administrator.Tproductos.getSelectedRow();
        if (aux == -1) {
            JOptionPane.showMessageDialog(null, "No se a seleccionado nada de la tabla.");
        } else {
            float total = Float.parseFloat(Administrator.Tproductos.getValueAt(aux, 2).toString());
            String cant = JOptionPane.showInputDialog("Cantidad: ");
            while (Integer.parseInt(cant) > Integer.parseInt(Administrator.Tproductos.getValueAt(aux, 4).toString()) 
                    || Integer.parseInt(cant) == 0) {
                if (Integer.parseInt(cant) > Integer.parseInt(Administrator.Tproductos.getValueAt(aux, 4).toString())) {
                    cant = JOptionPane.showInputDialog("  La Cantidad debe ser Menor a ( "+ Administrator.Tproductos.getValueAt(aux, 4).toString() +" )\n Cantidad: ");
                }else {
                    cant = JOptionPane.showInputDialog("  La Cantidad debe ser Mayor a ( 0 )\n Cantidad: ");
                }
            }
            float quantity = Float.parseFloat(cant);
            total *= quantity;
            Total += total;            
            Administrator.jTtotal.setText(String.valueOf(Total));
            DefaultTableModel temp = (DefaultTableModel) Administrator.Tlista.getModel();
            Object nuevo[] = {temp.getRowCount() + 1, "", ""};
            temp.addRow(nuevo);

            Administrator.Tlista.setValueAt(Administrator.Tproductos.getValueAt(aux, 1).toString(), j, 0);
            Administrator.Tlista.setValueAt(Administrator.Tproductos.getValueAt(aux, 2).toString(), j, 1);
            Administrator.Tlista.setValueAt(cant, j, 2);
            j++;
        }
    }
    
    public void billProduct() {
        if (j == 0) {
            JOptionPane.showMessageDialog(null, "No hay ningun elemento  en la Tabla de Venta");
        } else {
            frmBill Bill = new frmBill();
            BillController billController = new BillController(Bill);
            numfac = 1;
            billController.setNum(numfac);
            JTable tableBill= billController.getTable();
            for (int k = 0; k < j; k++) {
                tableBill.setValueAt(Administrator.Tlista.getValueAt(k, 0), k, 0);
                tableBill.setValueAt(Administrator.Tlista.getValueAt(k, 1), k, 1);
                tableBill.setValueAt(Administrator.Tlista.getValueAt(k, 2), k, 2);
            }
            billController.setTable(tableBill);
            billController.setTotal(Administrator.jTtotal.getText());
            billController.setRow(j);
            Bill.setVisible(true);
        }
    }
    
    public void Pay() {
        int _quantiy;
        String ID = null;
        String ticket;
        if (j == 0) {
            JOptionPane.showMessageDialog(null, "No hay ningun elemento  en la Tabla de Venta");
        } else {
            try {
                String nameProduct[] = new String[100], p;
                String pro2[] = new String[100];
                int total[] = new int[100];
                float price[] = new float[100];
                Object ex = null;
                int currentQuantity = 0;
                // Se crea la sentecia sql y se ejecuta para hacer la modificacion.
                for (int i = 0; i < j; i++) {
                    nameProduct[i] = objectToString(Administrator.Tlista.getValueAt(i, 0));
                    p = objectToString(Administrator.Tlista.getValueAt(i, 1));
                    price[i] = Float.parseFloat(p);
                    String xe = objectToString(Administrator.Tlista.getValueAt(i, 2));
                    total[i] = Integer.parseInt(xe);
                    productModel = productDAO.VerifyName(nameProduct[i]);
                    currentQuantity = productModel.getQuantity() - total[i];
                    productDAO.ModifyQuantity(productModel.getId_product(), currentQuantity);
                }
                UserDAO userDAO = new UserDAO();
                UserModel userModel = new UserModel();
                userModel = userDAO.VerifyId(IdUser);
                SaleDAO saleDAO = new SaleDAO();
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String dateSale = simpleDateFormat.format(date);
                String cad = "";
                String cadena = "      Farmacia 'Esperanza'\nRFC: TOSO850220GN9\nBaltazar N. 4  \nSan Antonio Coaxomulco, Tlaxcala\nFecha: " 
                        + dateSale + "\n\nCant. \tProducto \tPrecio\n";
                for (int i = 0; i < j; i++) {
                    cad += "" + total[i] + " \t" + nameProduct[i] + " \t" + price[i] * total[i] + " \n";
                }
                String efectivo = JOptionPane.showInputDialog(null, "Venta Realizada\nTotal a Cobrar: $" + Total + "\nEfectivo Recibido: ");
                float cambio = Float.parseFloat(efectivo) - Total;
                ticket = cadena + cad + "\n\tTotal: \t\t$" + Administrator.jTtotal.getText() + "\n\tEfectivo: $" 
                        + efectivo + "\n\tCambio: $" + cambio + "\n\nLe atendio: " + userModel.getName() 
                        + " " + userModel.getSurname_pater() + "\n\nCON EL CORAZON EN LAS MANOS\nGRACIAS POR SU COMPRA.\n\n\n\n";
                if (JOptionPane.showConfirmDialog(null, "Estás seguro de Imprimir? \n"+ ticket, "Confirmacion", 1) == 0) {
                    saleDAO.AddSale(Total, dateSale, IdUser);
                    for (int i = 0; i < j; i++) {
                        SoldDAO soldDAO = new SoldDAO();
                        soldDAO.AddSold(nameProduct[i], price[i], total[i], dateSale, IdUser);
                    }
                    // Cogemos el servicio de impresión por defecto (impresora por defecto).
                    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                    // Le decimos el tipo de datos que vamos a enviar a la impresora.
                    // Tipo: bytes Subtipo: autodetectado.
                    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                    // Creamos un trabajo de impresión.
                    DocPrintJob pj = service.createPrintJob();
                    // Nuestro trabajo de impresión envía una cadena de texto.
                    String ss = ticket;
                    byte[] bytes;
                    // Transformamos el texto a bytes que es lo que soporta la impresora.
                    bytes = ss.getBytes();
                    // Creamos un documento (Como si fuese una hoja de Word para imprimir).
                    Doc doc = new SimpleDoc(bytes, flavor, null);
                    // Obligado coger la excepción PrintException.
                    // Mandamos a imprimir el documento.
                    pj.print(doc, null);
                    int x = Administrator.Tlista.getRowCount() - 1;
                    DefaultTableModel table = (DefaultTableModel) Administrator.Tlista.getModel();
                    Clean(x, table);
                }
            } catch (PrintException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Impresion", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }
    
    public void VerifyExpiration() {
        String[] Title = {"Nombre", "Fecha"};
        DefaultTableModel tabla = new DefaultTableModel(null, Title);
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        listProduct = productDAO.VerifyExpiration();
        tabla.setNumRows(0);
        for (int i = 0; i < listProduct.size(); i++) {
            Object[] row = {listProduct.get(i).getName_product(),listProduct.get(i).getExpiration()};
            tabla.addRow(row);
            Administrator.Talertas.setModel(tabla);
        }
    }
    
    public void VerifyQuantity(int quantity){
        String[] Title = {"Nombre", "Cantidad", "Fecha de Caducidad"};
        DefaultTableModel tabla = new DefaultTableModel(null, Title);
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        listProduct = productDAO.VerifyQuantity(quantity);
        tabla.setNumRows(0);
        for (int i = 0; i < listProduct.size(); i++) {
            Object[] row = {listProduct.get(i).getName_product(),listProduct.get(i).getQuantity(),listProduct.get(i).getExpiration()};
            tabla.addRow(row);
            Administrator.Talertas.setModel(tabla);
        }
    }
    
    public DefaultTableModel SaleInventory(LinkedList<SoldModel> listSold) {
        SoldDAO soldDAO = new SoldDAO();
        invT = 0;
        String Title[] = {"Id", "Producto", "Cantidad", "Precio", "Fecha Vendida", "Vendedor"};
        DefaultTableModel tabla = new DefaultTableModel(null, Title);
        tabla.setNumRows(0);
        for (int i = 0; i < listSold.size(); i++) {
            Object[] row = {listSold.get(i).getId_sold(), listSold.get(i).getProduct(), listSold.get(i).getQuantity(), listSold.get(i).getPrice(), listSold.get(i).getDate(), listSold.get(i).getName_user()};
            int quantity = listSold.get(i).getQuantity();
            Double price = listSold.get(i).getPrice();
            price *= quantity;
            invT += price;
            tabla.addRow(row);
        }
        Administrator.jTinvT.setText("" + invT);
        return tabla;
    }
    
    public void Clean(int x, DefaultTableModel table) {
        Total = 0;
        Administrator.jTtotal.setText("0.00");
        System.out.println("filas: " + x);
        {
            try {
                while (x >= 0) {
                    table.removeRow(x);
                    x--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        j = 0;
    }
    
    public void Validation() {
        if (Administrator.txtName.getText().isEmpty()){
            Administrator.lbNameError.setText("* Campo Requerido");
        }else {
            Administrator.lbNameError.setText("");
        }
        if (Administrator.txtPrice.getText().isEmpty()){
            Administrator.lbPriceError.setText("* Campo Requerido");
        }else if (!Administrator.txtPrice.getText().matches("[0-9]+\\.?[0-9]*")) {
            Administrator.lbPriceError.setText("* Solo Numeros Reales o Enteros");
        }else {
            Administrator.lbPriceError.setText("");
        }
        if (Administrator.txtQuantity.getText().isEmpty()){
            Administrator.lbQuantityError.setText("* Campo Requerido");
        }else if (!Administrator.txtQuantity.getText().matches("[0-9]*")) {
            Administrator.lbQuantityError.setText("* Solo Numeros Enteros");
        }else {
            Administrator.lbQuantityError.setText("");
        }
        if (Administrator.txtDescription.getText().isEmpty()){
            Administrator.lbDescriptionError.setText("* Campo Requerido");
        }else {
            Administrator.lbDescriptionError.setText("");
        }
        if (Administrator.txtSpecification.getText().isEmpty()){
            Administrator.lbSpecificationError.setText("* Campo Requerido");
        }else {
            Administrator.lbSpecificationError.setText("");
        }
    }
    
    private void modifySize() {
        // Tamaño de la pantalla                  
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Administrator.jTabbedPane1.setSize(new Dimension(screenSize.width, screenSize.height));
        Administrator.jPanel2.setLocation((screenSize.width / 2) - (Administrator.jPanel2.getWidth() / 2), (screenSize.height / 4) - (Administrator.jPanel2.getHeight() / 4));
        Administrator.jPanel4.setLocation((screenSize.width / 2) - (Administrator.jPanel4.getWidth() / 2), 10);
        Administrator.jPanel6.setLocation((screenSize.width / 2) - (Administrator.jPanel6.getWidth() / 2), (screenSize.height / 4) - (Administrator.jPanel6.getHeight() / 4));
        Administrator.jPanel8.setLocation((screenSize.width / 2) - (Administrator.jPanel8.getWidth() / 2), (screenSize.height / 4) - (Administrator.jPanel8.getHeight() / 4));
        Administrator.jPanel10.setLocation((screenSize.width / 2) - (Administrator.jPanel10.getWidth() / 2), (screenSize.height / 4) - (Administrator.jPanel10.getHeight() / 4));
        Administrator.jLabel27.setLocation((screenSize.width / 2) - (Administrator.jLabel27.getWidth() / 2), 0);
        Administrator.jLabel31.setLocation((screenSize.width / 2) - (Administrator.jLabel31.getWidth() / 2), 0);
        Administrator.jLabel32.setLocation((screenSize.width) - (Administrator.jLabel32.getWidth()), 0);
    }
    
    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }
    
    public String objectToString(Object o) {
        String st;
        st = (String) o;
        return st;
    }
}