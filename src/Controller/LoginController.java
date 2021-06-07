package Controller;

import Controller.EncryptPassword;
import Model.ProductDAO;
import Model.UserModel;
import Model.UserDAO;
import View.frmAdministrator;
import View.frmEmployee;
import View.frmLogin;
import View.frmManager;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class LoginController implements ActionListener, KeyListener{
    frmLogin Login = new frmLogin();
    UserDAO userDAO = new UserDAO();
    UserModel userModel = new UserModel();
    
    public LoginController(frmLogin Login, UserDAO userDAO) {
        this.Login = Login;
        this.userDAO = userDAO;
        this.Login.btnEnter.addActionListener(this);
        this.Login.btnExit.addActionListener(this);
        this.Login.chbViewPass.addActionListener(this);
        this.Login.txtAccount.addKeyListener(this);
        this.Login.txtPass.addKeyListener(this);
        Initialize();
    }
    
    public void Initialize(){
        this.Login.setLocationRelativeTo(null);
        Login.lbTitle.setIcon(SImage("/Image/Titulo.png", Login.lbTitle));
        Login.lbLogo.setIcon(SImage("/Image/login.png", Login.lbLogo));
        Login.setSize(580, 390);
        Dimension screenSize = Login.getSize();
        Login.jPanel1.setLocation((screenSize.width/2)-(Login.jPanel1.getWidth()/2),(screenSize.height/2)-(Login.jPanel1.getHeight()/2));
        Login.btnEnter.setEnabled(false);
        Login.lbCheck1.setIcon(SImage("/Icon/error.png", Login.lbCheck1));
        Login.lbChek2.setIcon(SImage("/Icon/error.png", Login.lbChek2));
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Login.btnEnter){
            CbtnEnter();
        }else if(origin == this.Login.btnExit) {            
            System.exit(0);
        }else if(origin == this.Login.chbViewPass) {
            if(Login.chbViewPass.getText().equals("Mostrar Contraseña")) {
                if(Login.txtPass.getText().trim().length()>0){
                    Login.txtPass.setFont(new Font("Cambria",Font.PLAIN,24));
                    Login.txtPass.setEchoChar( (char)0 );
                    Login.chbViewPass.setText("Ocultar Contraseña");
                    Login.chbViewPass.setSelected(false);
                    Login.txtPass.grabFocus();
                }else{
                    Login.txtPass.grabFocus();
                    JOptionPane.showMessageDialog(null,"Ingrese su Contraseña ","Mensage del sistema",JOptionPane.WARNING_MESSAGE);
                    Login.chbViewPass.setSelected(false);
                }
            }else{
                if(Login.chbViewPass.getText().equals("Ocultar Contraseña")){
                    Login.txtPass.grabFocus();
                    Login.txtPass.setEchoChar(('֎'));
                    Login.txtPass.setFont(new Font("Cambria",Font.PLAIN,14));

                    Login.chbViewPass.setText("Mostrar Contraseña");
                    Login.chbViewPass.setSelected(false);
                    Login.txtPass.grabFocus();
                }
            }
        }
    }    

    @Override
    public void keyReleased(KeyEvent e) {
        Validate(e);
        Login.txtPass.setEchoChar(('֎'));Login.txtPass.setFont(new Font("Cambria",Font.PLAIN,14));        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    public void CbtnEnter() {
        String account = Login.txtAccount.getText();
        String pass = String.valueOf(Login.txtPass.getPassword());
        userModel = userDAO.Verify(account);
        EncryptPassword encryptPassword = new EncryptPassword();
        if(userModel == null){            
            Login.txtAccount.setText("");
            Login.txtPass.setText("");
        }else{            
            int _level = userModel.getLevel();
            int IdUser = userModel.getId_user();
            if (account.equals(userModel.getAccount()) && pass.equals(encryptPassword.Decrypted(userModel.getPassword()))) {
                // Se compara si el estatus es igual a TRUE.
                if (_level == 0) {
                    // Se carga la interfaz Administrador.
                    frmAdministrator Administrator = new frmAdministrator();
                    ProductDAO productDAO = new ProductDAO();
                    AdministratorController interfaceController = new AdministratorController(IdUser, Administrator, productDAO);
                    interfaceController.IdUser = IdUser;
                    JOptionPane.showMessageDialog(null, "Bienvenid@ " + userModel.getName() + " " + userModel.getSurname_pater() + " " + userModel.getSurname_mother()+ " \n\n Has entrado al sistema como: Administrador");
                    Administrator.setVisible(true);
                    this.Login.dispose();
                }
                if (_level == 1) {
                    // Se cargar la interfaz frmEmployee
                    frmEmployee Employee = new frmEmployee();
                    EmployeeController employeeController = new EmployeeController(IdUser, Employee);
                    JOptionPane.showMessageDialog(null, "Bienvenid@ " + userModel.getName() + " " + userModel.getSurname_pater() + " " + userModel.getSurname_mother()+ " \n\n Has entrado al sistema como: Empleado");
                    Employee.setVisible(true);
                    this.Login.dispose();
                }
                if (_level == 2) {
                    // Se cargar la interfaz frmManager
                    frmManager Manager = new frmManager();
                    ProductDAO productModel = new ProductDAO();
                    ManagerController managerController = new ManagerController(IdUser, Manager, productModel);
                    JOptionPane.showMessageDialog(null, "Bienvenid@ " + userModel.getName() + " " + userModel.getSurname_pater() + " " + userModel.getSurname_mother()+ " \n\n Has entrado al sistema como: Gerente");
                    Manager.setVisible(true);                    
                    this.Login.dispose();
                }
            }else {                
                Login.txtPass.setFont(new Font("Cambria",Font.PLAIN,24));
                Login.txtPass.setEchoChar( (char)0 );
                Login.chbViewPass.setText("Ocultar Contraseña");
                Login.chbViewPass.setSelected(false);
                Login.txtPass.grabFocus();
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
            }            
        }
    }
    
    public void Validate(KeyEvent e) {
        if (this.Login.txtAccount.getText().isEmpty()) {
            Login.lbCheck1.setIcon(SImage("/Icon/error.png", Login.lbCheck1));
            Login.lbAccountError.setText("* Campo Requerido");
        }else if (!Login.txtAccount.getText().contains("123")) {
            Login.lbCheck1.setIcon(SImage("/Icon/error.png", Login.lbCheck1));
            Login.lbAccountError.setText("* Cuenta no Valida");
        }else if (Login.txtAccount.getText().length() > 13) {
            Login.lbCheck1.setIcon(SImage("/Icon/error.png", Login.lbCheck1));
            Login.lbAccountError.setText("* La Cuenta debe ser Menor o Igual a 13");
        }
        else{
            Login.lbCheck1.setIcon(SImage("/Icon/accept1.png", Login.lbCheck1));
            Login.lbAccountError.setText("");
        }        
                    
        if (Login.txtPass.getText().isEmpty()) {
            Login.lbChek2.setIcon(SImage("/Icon/error.png", Login.lbChek2));
            Login.lbPassError.setText("* Campo Requerido");
        }else if (Login.txtPass.getText().length() < 6) {
            Login.lbChek2.setIcon(SImage("/Icon/error.png", Login.lbChek2));
            Login.lbPassError.setText("* La Contraseña debe ser Mayor o Igual a 6");
        }else if (Login.txtPass.getText().length() > 13) {
            e.consume();            
            Login.lbChek2.setIcon(SImage("/Icon/error.png", Login.lbChek2));
            Login.lbPassError.setText("* La Contraseña debe ser Menor o Igual a 13");
        }else {
            Login.lbChek2.setIcon(SImage("/Icon/accept1.png", Login.lbChek2));
            Login.lbPassError.setText("");
        }
        if (Login.txtAccount.getText().isEmpty() || Login.txtPass.getText().isEmpty()){
            Login.btnEnter.setEnabled(false);            
        }else {
            Login.btnEnter.setEnabled(true);
        }
    }
    
    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }        
}