package Controller;

import Model.ProductModel;
import Model.ProductDAO;
import Model.UserDAO;
import Model.UserModel;
import View.frmLogin;
import View.frmManager;
import View.frmModify;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerController implements ActionListener, KeyListener {
    frmManager Manager = new frmManager();
    ProductDAO productDAO = new ProductDAO();
    String[] product;
    private String id;
    int IdUser;

    public ManagerController(int IdUser, frmManager Manager, ProductDAO productDAO) {
        this.IdUser = IdUser;
        this.Manager = Manager;
        this.productDAO = productDAO;
        this.Manager.btnAdd.addActionListener(this);
        this.Manager.btnEdit.addActionListener(this);
        this.Manager.btnAccept.addActionListener(this);
        this.Manager.jMenuItem1.addActionListener(this);
        this.Manager.jMenuItem2.addActionListener(this);
        this.Manager.jMenuItem3.addActionListener(this);
        this.Manager.jMenuItem4.addActionListener(this);
        this.Manager.txtSearchName.addKeyListener(this);
        this.Manager.txtName.addKeyListener(this);
        this.Manager.txtPrice.addKeyListener(this);
        this.Manager.txtQuantity.addKeyListener(this);
        this.Manager.txtDescription.addKeyListener(this);
        this.Manager.txtSpecification.addKeyListener(this);
        Initialize();        
    }
    
    public void Initialize() {
        this.Manager.jLabel11.setIcon(SImage("/Image/Titulo.png", Manager.jLabel11));
        this.Manager.jLabel12.setIcon(SImage("/Image/Titulo.png", Manager.jLabel12));
        this.Manager.setExtendedState(MAXIMIZED_BOTH);
        this.Manager.setLocationRelativeTo(null);
        ((JTextField)this.Manager.jdcEditExpiration.getDateEditor()).setEditable(false);
        this.Manager.jdcEditExpiration.getCalendarButton().setEnabled(false);
        Calendar minDate = Calendar.getInstance();
        minDate.setTime(new Date());
        minDate.add(Calendar.DAY_OF_YEAR, 15);
        Manager.jdcExpiration.setMinSelectableDate(minDate.getTime());
        Manager.jTID.setText(String.valueOf(IdUser));
        modifySize();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Manager.btnAdd) {
            addProduct();
        }else if (origin == this.Manager.btnEdit) {
            modifyProduct();
        }else if (origin == this.Manager.btnAccept) {
            acceptProduct();
        }else if (origin == this.Manager.jMenuItem1){
            frmModify Modify = new frmModify();
            UserDAO userModel = new UserDAO();
            UserModel user = new UserModel();
            ModifyController modifyController = new ModifyController(Modify, userModel, user);
            modifyController.id = IdUser;
            System.out.println("id para modificar: " + modifyController.id);
            Modify.setVisible(true);
        }else if (origin == this.Manager.jMenuItem2) {
            JOptionPane.showMessageDialog(null, "Realizado por:\n\n   G.E.D.S.A.\n   2021\n\n\nConformado por:\n    Gualverto Canviri Gutierrez\n    Franz Cruz Arias\n    Marco Nina Nuñez", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
        }else if (origin == this.Manager.jMenuItem3) {
            if (JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar la sesion actual?", "Cerrar sesión", 1) == 0) {
                Manager.dispose();
                frmLogin Login = new frmLogin();
                UserDAO modelUser = new UserDAO();
                LoginController loginController = new LoginController(Login, modelUser);
                Login.setLocationRelativeTo(null);
                Login.setVisible(true);
            }
        }else if (origin == this.Manager.jMenuItem4) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrar el Sistema?", "Cerrar Sistema", 1) == 0) {
                System.exit(0);
            }            
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel table = SearchName(Manager.txtSearchName.getText());
        Manager.jTbuscar.setModel(table);
        Validation();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {        
    }
    
    public void addProduct() {
        if (Manager.txtName.getText().equals("") || Manager.txtPrice.getText().equals("") || Manager.jdcExpiration.getDate() == null
            || Manager.txtQuantity.getText().equals("") || Manager.txtDescription.getText().equals("") || Manager.txtSpecification.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");
        } else {
            String name = Manager.txtName.getText();
            Double price = Double.parseDouble(Manager.txtPrice.getText());
            SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String expiration = simpleDateFormat.format(Manager.jdcExpiration.getDate());
            int quantity = Integer.parseInt(Manager.txtQuantity.getText());
            String description = Manager.txtDescription.getText();
            String specification = Manager.txtSpecification.getText();
            productDAO.AddProduct(name, price, expiration, quantity, description, specification);
            JOptionPane.showMessageDialog(null, "Producto: " + name + " agregado.");
            // Se limpian los campos de texto para seguir agregando mas datos.
            Manager.txtName.setText("");
            Manager.txtPrice.setText("");
            Manager.jdcExpiration.setDate(null);
            Manager.txtQuantity.setText("");
            Manager.txtDescription.setText("");
            Manager.txtSpecification.setText("");
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
        int Option = this.Manager.jTbuscar.getSelectedRow();
        if (Option == -1) {
            JOptionPane.showMessageDialog(null, "No se a seleccionado el Producto de la tabla.");
        } else {
            id = Manager.jTbuscar.getValueAt(Option, 0).toString();
            Manager.txtEditName.setText(this.Manager.jTbuscar.getValueAt(Option, 1).toString());
            Manager.txtEditPrice.setText(this.Manager.jTbuscar.getValueAt(Option, 2).toString());
            //Manager.txtEditExpiration.setText(this.Manager.jTbuscar.getValueAt(Option, 3).toString());
            String fecha = this.Manager.jTbuscar.getValueAt(Option, 3).toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
            try {
                Manager.jdcEditExpiration.setDate(simpleDateFormat.parse(fecha));
            } catch (ParseException ex) {
                Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Manager.txtEditQuantity.setText(this.Manager.jTbuscar.getValueAt(Option, 4).toString());
            Manager.txtEditDescription.setText(this.Manager.jTbuscar.getValueAt(Option, 5).toString());
            Manager.txtEditSpecification.setText(this.Manager.jTbuscar.getValueAt(Option, 6).toString());
            Manager.txtEditName.setEditable(true);
            Manager.txtEditPrice.setEditable(true);
            ((JTextField)Manager.jdcEditExpiration.getDateEditor()).setEditable(false);
            Manager.jdcEditExpiration.getCalendarButton().setEnabled(true);
            this.Manager.jdcEditExpiration.setMinSelectableDate(Manager.jdcEditExpiration.getDate());
            Manager.txtEditQuantity.setEditable(true);
            Manager.txtEditDescription.setEditable(true);
            Manager.txtEditSpecification.setEditable(true);
        }
    }

    public void acceptProduct() {
        if (Manager.txtEditName.getText().equals("") || Manager.jdcEditExpiration.getDate().equals("") || Manager.txtEditPrice.getText().equals("")
            || Manager.txtEditQuantity.getText().equals("") || Manager.txtEditDescription.getText().equals("") || Manager.txtEditSpecification.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");
        } else {
            int Id = Integer.parseInt(id);
            String name = Manager.txtEditName.getText();
            Double price = Double.parseDouble(Manager.txtEditPrice.getText());
            SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String expiration = simpleDateFormat.format(Manager.jdcEditExpiration.getDate());
            //String expiration = Manager.txtEditExpiration.getText();
            int quantity = Integer.parseInt(Manager.txtEditQuantity.getText());
            String description = Manager.txtEditDescription.getText();
            String specification = Manager.txtEditSpecification.getText();
            productDAO.ModifyProduct(Id, name, price, expiration, quantity, description, specification);
        }
    }
    
    public void Validation() {
        if (Manager.txtName.getText().isEmpty()){
            Manager.lbNameError.setText("* Campo Requerido");
        }else {
            Manager.lbNameError.setText("");
        }
        if (Manager.txtPrice.getText().isEmpty()){
            Manager.lbPriceError.setText("* Campo Requerido");
        }else if (!Manager.txtPrice.getText().matches("[0-9]+\\.?[0-9]*")) {
            Manager.lbPriceError.setText("* Solo Numeros Reales o Enteros");
        }else {
            Manager.lbPriceError.setText("");
        }
        if (Manager.txtQuantity.getText().isEmpty()){
            Manager.lbQuantityError.setText("* Campo Requerido");
        }else if (!Manager.txtQuantity.getText().matches("[0-9]*")) {
            Manager.lbQuantityError.setText("* Solo Numeros Enteros");
        }else {
            Manager.lbQuantityError.setText("");
        }
        if (Manager.txtDescription.getText().isEmpty()){
            Manager.lbDescriptionError.setText("* Campo Requerido");
        }else {
            Manager.lbDescriptionError.setText("");
        }
        if (Manager.txtSpecification.getText().isEmpty()){
            Manager.lbSpecificationError.setText("* Campo Requerido");
        }else {
            Manager.lbSpecificationError.setText("");
        }
    }
    
    private void modifySize() {
        // Tamaño de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.Manager.jTabbedPane1.setSize(new Dimension(screenSize.width, screenSize.height));
        this.Manager.jPanel2.setLocation((screenSize.width / 2) - (Manager.jPanel2.getWidth() / 2), (screenSize.height / 3) - (Manager.jPanel2.getHeight() / 2));
        this.Manager.jPanel5.setLocation((screenSize.width / 2) - (Manager.jPanel5.getWidth() / 2), 0);
    }
      
    
    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }
}
