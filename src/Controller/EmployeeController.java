package Controller;

import Model.ProductModel;
import Model.ProductDAO;
import Model.SaleDAO;
import Model.SoldDAO;
import Model.SoldModel;
import Model.UserDAO;
import Model.UserModel;
import View.frmBill;
import View.frmEmployee;
import View.frmLogin;
import View.frmModify;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.print.*;

public class EmployeeController implements ActionListener, KeyListener{
    frmEmployee Employee = new frmEmployee();
    ProductDAO productDAO = new ProductDAO();
    ProductModel productModel = new ProductModel();
    int IdUser;
    static int j = 0;
    static String aux3;
    static float Total = 0, invT = 0;
    public static String id, cad;
    public static int rowCount, numfac;
    Thread h1;    
    public EmployeeController(int IdUser, frmEmployee Employee){
        this.IdUser = IdUser;
        this.Employee = Employee;
        this.Employee.setExtendedState(MAXIMIZED_BOTH);
        this.Employee.setLocationRelativeTo(null);
        this.Employee.btnAddSale.addActionListener(this);
        this.Employee.btnClean.addActionListener(this);
        this.Employee.btnBill.addActionListener(this);
        this.Employee.btnPay.addActionListener(this);
        this.Employee.btnSaleDay.addActionListener(this);
        this.Employee.jMenuItem2.addActionListener(this);
        this.Employee.jMenuItem3.addActionListener(this);
        this.Employee.jMenuItem4.addActionListener(this);
        this.Employee.jMenuItem5.addActionListener(this);
        
        this.Employee.txtSearchName.addKeyListener(this);        
        this.Employee.txtSearchDescription.addKeyListener(this);
        this.Employee.txtNameSale.addKeyListener(this);
        modifySize();
        Initialize();
    }
    
    public void Initialize() {                
        //h1 = new Thread(Employee);
        //h1.start();
        Employee.jLabel16.setIcon(SImage("/Image/Titulo.png", Employee.jLabel16));
        Employee.jLabel17.setIcon(SImage("/Image/Titulo.png", Employee.jLabel17));
        Employee.jLabel18.setIcon(SImage("/Image/Titulo.png", Employee.jLabel18));
        Employee.jTID.setText(String.valueOf(IdUser));
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Employee.btnAddSale) {
            addSale();
        }else if (origin == this.Employee.btnClean) {
            Clean();
        }else if (origin == this.Employee.btnBill) {
            billProduct();
        }else if (origin == this.Employee.btnPay) {
            Pay();
        }else if (origin == this.Employee.btnSaleDay) {
            DefaultTableModel table = SaleDay();
            Employee.jTinventario.setModel(table);
        }else if (origin == this.Employee.jMenuItem2) {
            JOptionPane.showMessageDialog(null, "Realizado por:\n\n   G.E.D.S.A.\n   2021\n\n\nConformado por:\n    Gualverto Canviri Gutierrez\n    Franz Cruz Arias\n    Marco Nina Nuñez", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
        }else if (origin == this.Employee.jMenuItem3) {
            if (JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar la sesion actual?", "Cerrar sesión", 1) == 0) {
                Employee.dispose();
                frmLogin Login = new frmLogin();
                UserDAO modelUser = new UserDAO();
                LoginController loginController = new LoginController(Login, modelUser);
                Login.setLocationRelativeTo(null);
                Login.setVisible(true);
            }
        }else if (origin == this.Employee.jMenuItem4) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrar el Sistema?", "Cerrar Sistema", 1) == 0) {
                System.exit(0);
            }
        }else if (origin == this.Employee.jMenuItem5){
            frmModify Modify = new frmModify();
            UserDAO userModel = new UserDAO();
            UserModel user = new UserModel();
            ModifyController modifyController = new ModifyController(Modify, userModel, user);
            modifyController.id = IdUser;
            System.out.println("id para modificar: " + modifyController.id);
            Modify.setVisible(true);
        }
    }
    //region key
    @Override
    public void keyReleased(KeyEvent e) {
        Object origin = e.getSource();
        if (origin == this.Employee.txtSearchName){
            DefaultTableModel table = SearchName(Employee.txtSearchName.getText());
            Employee.jTbuscar.setModel(table);
        }else if (origin == this.Employee.txtSearchDescription){
            
        }else if (origin == this.Employee.txtNameSale){
            DefaultTableModel table = SearchName(Employee.txtNameSale.getText());
            Employee.Tproductos.setModel(table);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {        
    }
    //endregion
    
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
    
    public void addSale() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        int aux = Employee.Tproductos.getSelectedRow();
        if (aux == -1) {
            JOptionPane.showMessageDialog(null, "No se a seleccionado nada de la tabla.");
        } else {
            float total = Float.parseFloat(Employee.Tproductos.getValueAt(aux, 2).toString());
            String cant = JOptionPane.showInputDialog("Cantidad: ");
            while (Integer.parseInt(cant) > Integer.parseInt(Employee.Tproductos.getValueAt(aux, 4).toString()) 
                    || Integer.parseInt(cant) == 0) {
                if (Integer.parseInt(cant) > Integer.parseInt(Employee.Tproductos.getValueAt(aux, 4).toString())) {
                    cant = JOptionPane.showInputDialog("  La Cantidad debe ser Menor a ( "+ Employee.Tproductos.getValueAt(aux, 4).toString() +" )\n Cantidad: ");
                }else {
                    cant = JOptionPane.showInputDialog("  La Cantidad debe ser Mayor a ( 0 )\n Cantidad: ");
                }
            }
            float quantity = Float.parseFloat(cant);
            total *= quantity;
            Total += total;            
            Employee.jTtotal.setText(String.valueOf(Total));
            DefaultTableModel temp = (DefaultTableModel) Employee.Tlista.getModel();
            Object nuevo[] = {temp.getRowCount() + 1, "", ""};
            temp.addRow(nuevo);

            Employee.Tlista.setValueAt(Employee.Tproductos.getValueAt(aux, 1).toString(), j, 0);
            Employee.Tlista.setValueAt(Employee.Tproductos.getValueAt(aux, 2).toString(), j, 1);
            Employee.Tlista.setValueAt(cant, j, 2);
            j++;
        }
    }
    
    public void billProduct() {
        if (j == 0) {
            JOptionPane.showMessageDialog(null, "No hay ningun elemento  en la Tabla de Venta");
        } else {
            try {
                frmBill Bill = new frmBill();
                BillController billController = new BillController(Bill);
                numfac = 1;
                billController.setNum(numfac);
                JTable tableBill= billController.getTable();
                for (int k = 0; k < j; k++) {
                    tableBill.setValueAt(Employee.Tlista.getValueAt(k, 0), k, 0);
                    tableBill.setValueAt(Employee.Tlista.getValueAt(k, 1), k, 1);
                    tableBill.setValueAt(Employee.Tlista.getValueAt(k, 2), k, 2);
                }
                billController.setTable(tableBill);
                billController.setTotal(Employee.jTtotal.getText());
                billController.setRow(j);
                Bill.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
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
                    nameProduct[i] = objectToString(Employee.Tlista.getValueAt(i, 0));
                    p = objectToString(Employee.Tlista.getValueAt(i, 1));
                    price[i] = Float.parseFloat(p);
                    String xe = objectToString(Employee.Tlista.getValueAt(i, 2));
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
                ticket = cadena + cad + "\n\tTotal: \t\t$" + Employee.jTtotal.getText() + "\n\tEfectivo: $" 
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
                    JOptionPane.showMessageDialog(null, "   Imprimiendo Factura");
                    Clean();
                }
            } catch (PrintException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Impresion", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }
    
    public DefaultTableModel SaleDay() {
        SoldDAO soldDAO = new SoldDAO();
        invT = 0;
        String Title[] = {"Id", "Producto", "Cantidad", "Precio"};
        DefaultTableModel tabla = new DefaultTableModel(null, Title);
        LinkedList<SoldModel> listSold = new LinkedList<SoldModel>();
        SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        listSold = soldDAO.ViewSold(IdUser,date);
        tabla.setNumRows(0);
        for (int i = 0; i < listSold.size(); i++) {
            Object[] row = {listSold.get(i).getId_sold(), listSold.get(i).getProduct(), listSold.get(i).getQuantity(), listSold.get(i).getPrice()};
            int quantity = listSold.get(i).getQuantity();
            Double price = listSold.get(i).getPrice();
            price *= quantity;
            invT += price;
            tabla.addRow(row);
        }
        Employee.jTinvT.setText("" + invT);
        return tabla;
    }
    
    public void Clean() {
        Total = 0;
        Employee.jTtotal.setText("0.00");

        int x = Employee.Tlista.getRowCount() - 1;
        System.out.println("filas: " + x);
        {
            try {
                DefaultTableModel temp = (DefaultTableModel) Employee.Tlista.getModel();
                while (x >= 0) {
                    temp.removeRow(x);
                    x--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        j = 0;
    }
    
    private void modifySize() {
        // Tamaño de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.Employee.jTabbedPane1.setSize(new Dimension(screenSize.width, screenSize.height));
        this.Employee.jPanel2.setLocation((screenSize.width / 2) - (Employee.jPanel2.getWidth() / 2), (screenSize.height / 6) - (Employee.jPanel2.getHeight() / 6));
        this.Employee.jPanel4.setLocation((screenSize.width / 2) - (Employee.jPanel4.getWidth() / 2), 0);
        this.Employee.jPanel6.setLocation((screenSize.width / 2) - (Employee.jPanel6.getWidth() / 2), (screenSize.height / 4) - (Employee.jPanel6.getHeight() / 4));
        this.Employee.jLabel16.setLocation((screenSize.width) - (Employee.jLabel16.getWidth()), 0);
        this.Employee.jLabel17.setLocation((screenSize.width) - (Employee.jLabel17.getWidth()), 0);
        this.Employee.jLabel18.setLocation((screenSize.width) - (Employee.jLabel18.getWidth()), 0);
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
