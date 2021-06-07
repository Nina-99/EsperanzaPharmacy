package Controller;

import Model.UserDAO;
import View.frmRegister;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegisterController implements ActionListener, KeyListener{
    frmRegister Register = new frmRegister();
    UserDAO userDAO = new UserDAO();
    
    public RegisterController(frmRegister Register, UserDAO userDAO) {
        this.Register = Register;
        this.userDAO = userDAO;
        this.Register.btnAdd.addActionListener(this);
        this.Register.txtName.addKeyListener(this);
        this.Register.txtPathern.addKeyListener(this);
        this.Register.txtMother.addKeyListener(this);
        this.Register.txtAccount.addKeyListener(this);
        this.Register.txtPass.addKeyListener(this);
        this.Register.txtRepitPass.addKeyListener(this);
        Initialize();
    }
    
    public void Initialize(){
        this.Register.setExtendedState(MAXIMIZED_BOTH);
        this.Register.setLocationRelativeTo(null);
        Register.lbCheck1.setIcon(SImage("/Icon/error.png", Register.lbCheck1));
        Register.lbCheck2.setIcon(SImage("/Icon/error.png", Register.lbCheck2));
        Register.lbCheck3.setIcon(SImage("/Icon/error.png", Register.lbCheck3));
        Register.lbCheck4.setIcon(SImage("/Icon/error.png", Register.lbCheck4));
        Register.lbCheck5.setIcon(SImage("/Icon/error.png", Register.lbCheck5));
        Register.lbCheck6.setIcon(SImage("/Icon/error.png", Register.lbCheck6));
        Register.btnAdd.setEnabled(false);        
        modifySize();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Register.btnAdd) {
            if (Register.txtName.getText().equals("") || Register.txtPathern.getText().equals("") || Register.txtMother.getText().equals("")
                || Register.txtAccount.getText().equals("") || Register.txtPass.getText().equals("") || Register.txtRepitPass.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "No puede dejar espacios sin llenar");
            } else {            
                String name = Register.txtName.getText();
                String pater = Register.txtPathern.getText();
                String mother = Register.txtMother.getText();
                String account = Register.txtAccount.getText();
                String password = Register.txtPass.getText();
                EncryptPassword encryptPassword = new EncryptPassword();
                String password1 = encryptPassword.Encrypted(password);
                int level = Register.jCnivel.getSelectedIndex();
                userDAO.AddUser(name, pater, mother, account, password1, level);

                Register.txtName.setText("");
                Register.txtPathern.setText("");
                Register.txtMother.setText("");
                Register.txtAccount.setText("");
                Register.txtPass.setText("");
                Register.txtRepitPass.setText("");
                this.Register.dispose();
            }
        }else if (origin == this.Register.jMenuItem1) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrarla?", "Cerrar aplicación", 1) == 0) {
                this.Register.hide();
            }
        }else if (origin == this.Register.jMenuItem1) {
            JOptionPane.showMessageDialog(null, "Realizado por:\n\n G.E.D.S.A.\n\n 2021");
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Validate(e);
        Register.txtPass.setEchoChar(('֎'));Register.txtPass.setFont(new Font("Cambria",Font.PLAIN,14));
        Register.txtRepitPass.setEchoChar(('֎'));Register.txtRepitPass.setFont(new Font("Cambria",Font.PLAIN,14));
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    public void Validate(KeyEvent e) {
        if (this.Register.txtName.getText().isEmpty()){
            Register.lbCheck1.setIcon(SImage("/Icon/error.png", Register.lbCheck1));
            Register.lbNameError.setText("* Campo Requerido");
        }else{
            Register.lbCheck1.setIcon(SImage("/Icon/accept1.png", Register.lbCheck1));
            Register.lbNameError.setText("");
        }
        
        if (this.Register.txtPathern.getText().isEmpty()){
            Register.lbCheck2.setIcon(SImage("/Icon/error.png", Register.lbCheck2));
            Register.lbPathernError.setText("* Campo Requerido");
        }else{
            Register.lbCheck2.setIcon(SImage("/Icon/accept1.png", Register.lbCheck2));
            Register.lbPathernError.setText("");
        }
        
        if (this.Register.txtMother.getText().isEmpty()){
            Register.lbCheck3.setIcon(SImage("/Icon/error.png", Register.lbCheck3));
            Register.lbMotherError.setText("* Campo Requerido");
        }else{
            Register.lbCheck3.setIcon(SImage("/Icon/accept1.png", Register.lbCheck3));
            Register.lbMotherError.setText("");
        }
        
        if (this.Register.txtAccount.getText().isEmpty()) {
            Register.lbCheck4.setIcon(SImage("/Icon/error.png", Register.lbCheck4));            
            Register.lbAccountError.setText("* Campo Requerido");
        }else if (!Register.txtAccount.getText().contains("123")) {
            Register.lbCheck4.setIcon(SImage("/Icon/error.png", Register.lbCheck4));
            Register.lbAccountError.setText("* Cuenta no Valida");
        }else if (Register.txtAccount.getText().length() > 13) {
            Register.lbCheck4.setIcon(SImage("/Icon/error.png", Register.lbCheck4));
            Register.lbAccountError.setText("* La Cuenta debe ser Menor o Igual a 13");
        }else{
            Register.lbCheck4.setIcon(SImage("/Icon/accept1.png", Register.lbCheck4));
            Register.lbAccountError.setText("");
        }        
                    
        if (Register.txtPass.getText().isEmpty()) {
            Register.lbCheck5.setIcon(SImage("/Icon/error.png", Register.lbCheck5));
            Register.lbPassError.setText("* Campo Requerido");
        }else if (Register.txtPass.getText().length() < 6) {
            Register.lbCheck5.setIcon(SImage("/Icon/error.png", Register.lbCheck5));
            Register.lbPassError.setText("* La Contraseña debe ser Mayor o Igual a 6");
        }else if (Register.txtPass.getText().length() > 13) {
            e.consume();            
            Register.lbCheck5.setIcon(SImage("/Icon/error.png", Register.lbCheck5));
            Register.lbPassError.setText("* La Contraseña debe ser Menor o Igual a 13");
        }else {
            Register.lbCheck5.setIcon(SImage("/Icon/accept1.png", Register.lbCheck5));
            Register.lbPassError.setText("");
        }
        
        if (Register.txtRepitPass.getText().isEmpty()) {
            Register.lbCheck6.setIcon(SImage("/Icon/error.png", Register.lbCheck6));
            Register.lbRepitError.setText("* Campo Requerido");
        }else if (Register.txtRepitPass.getText().length() < 6) {
            Register.lbCheck6.setIcon(SImage("/Icon/error.png", Register.lbCheck6));
            Register.lbRepitError.setText("* La Contraseña debe ser Mayor o Igual a 6");
        }else if (Register.txtPass.getText().length() > 13) {
            e.consume();            
            Register.lbCheck6.setIcon(SImage("/Icon/error.png", Register.lbCheck6));
            Register.lbRepitError.setText("* La Contraseña debe ser Menor o Igual a 13");
        }else if (!Register.txtRepitPass.getText().equals(Register.txtPass.getText())) {
            Register.lbCheck6.setIcon(SImage("/Icon/error.png", Register.lbCheck6));
            Register.lbRepitError.setText("* Las Contraseñas No Son Iguales");
        }else {
            Register.lbCheck6.setIcon(SImage("/Icon/accept1.png", Register.lbCheck6));
            Register.lbRepitError.setText("");
        }
        if (Register.txtName.getText().isEmpty() || Register.txtPathern.getText().isEmpty() 
                || Register.txtMother.getText().isEmpty() || Register.txtAccount.getText().isEmpty() 
                || Register.txtPass.getText().isEmpty() || Register.txtRepitPass.getText().isEmpty() 
                || !Register.txtRepitPass.getText().equals(Register.txtPass.getText())){
            Register.btnAdd.setEnabled(false);            
        }else {
            Register.btnAdd.setEnabled(true);
        }
    }
    
    private void modifySize() {
         // Tamaño de la pantalla            
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //jTabbedPane1.setSize(new Dimension(screenSize.width,screenSize.height));        
        Register.jPanel1.setLocation((screenSize.width/2)-(Register.jPanel1.getWidth()/2),(screenSize.height/4)-(Register.jPanel1.getHeight()/4));
    }
    
    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }
}
