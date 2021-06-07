package Controller;

import Model.UserModel;
import Model.UserDAO;
import View.frmModify;
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

public class ModifyController implements ActionListener, KeyListener{
    frmModify Modify = new frmModify();
    UserDAO userDAO = new UserDAO();
    UserModel userModel = new UserModel();
    public int id;
    
    public ModifyController(frmModify Modify, UserDAO userDAO, UserModel userModel) {
        this.Modify = Modify;
        this.userDAO = userDAO;
        this.userModel = userModel;
        this.Modify.btnChange.addActionListener(this);
        this.Modify.btnCancel.addActionListener(this);
        this.Modify.jMenuItem1.addActionListener(this);
        this.Modify.jMenuItem2.addActionListener(this);
        
        this.Modify.txtCurrentPass.addKeyListener(this);
        this.Modify.txtNewPass.addKeyListener(this);
        this.Modify.txtRepitPass.addKeyListener(this);
        Initialize();
    }
    
    public void Initialize(){
        this.Modify.setExtendedState(MAXIMIZED_BOTH);
        this.Modify.setLocationRelativeTo(null);
        Modify.lbChek1.setIcon(SImage("/Icon/error.png", Modify.lbChek1));
        Modify.lbChek2.setIcon(SImage("/Icon/error.png", Modify.lbChek2));
        Modify.lbChek3.setIcon(SImage("/Icon/error.png", Modify.lbChek3));
        modifySize();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == this.Modify.btnChange) {
            ModifyPassword();
        }else if (origin == this.Modify.btnCancel) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrarla?", "Cerrar aplicación", 1) == 0) {
                this.Modify.dispose();
            }
        }else if (origin == this.Modify.jMenuItem1) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrarla?", "Cerrar aplicación", 1) == 0) {
                this.Modify.dispose();
            }
        }else if (origin == this.Modify.jMenuItem2) {
            JOptionPane.showMessageDialog(null, "Se le recomienda a los usuarios\n el cambio semanal de su \n"
                + "contraseña la administracion.");
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Validate(e);
        Modify.txtCurrentPass.setEchoChar(('֎'));Modify.txtNewPass.setFont(new Font("Cambria",Font.PLAIN,14));
        Modify.txtNewPass.setEchoChar(('֎'));Modify.txtNewPass.setFont(new Font("Cambria",Font.PLAIN,14));
        Modify.txtRepitPass.setEchoChar(('֎'));Modify.txtRepitPass.setFont(new Font("Cambria",Font.PLAIN,14));
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    public void ModifyPassword() {
        if (Modify.txtCurrentPass.getText().equals("") || Modify.txtNewPass.getText().equals("") || Modify.txtRepitPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede dejar espacios sin llenar");
        } else {            
            String oldPassword = Modify.txtCurrentPass.getText();
            String newPassword = Modify.txtNewPass.getText();
            EncryptPassword encryptPassword = new EncryptPassword();
            String password = encryptPassword.Encrypted(newPassword);
            userDAO.ModifyPassword(id, password);
            this.Modify.dispose();
        }
    }
    
    public void Validate(KeyEvent e) {
        userModel = userDAO.VerifyId(id);
        EncryptPassword encryptPassword = new EncryptPassword();        
        if (this.Modify.txtCurrentPass.getText().isEmpty()) {
            Modify.lbChek1.setIcon(SImage("/Icon/error.png", Modify.lbChek1));
            Modify.lbCurrentPassError.setText("* Campo Requerido");
        }else if (!Modify.txtCurrentPass.getText().equals(encryptPassword.Decrypted(userModel.getPassword()))) {
            Modify.lbChek1.setIcon(SImage("/Icon/error.png", Modify.lbChek1));
            Modify.lbCurrentPassError.setText("* La Contraseña No Es Correcta");
        }else if (Modify.txtCurrentPass.getText().length() > 13) {
            Modify.lbChek1.setIcon(SImage("/Icon/error.png", Modify.lbChek1));
            Modify.lbCurrentPassError.setText("* La Cuenta debe ser Menor o Igual a 13");
        }else{
            Modify.lbChek1.setIcon(SImage("/Icon/accept1.png", Modify.lbChek1));
            Modify.lbCurrentPassError.setText("");
        }        
                    
        if (Modify.txtNewPass.getText().isEmpty()) {
            Modify.lbChek2.setIcon(SImage("/Icon/error.png", Modify.lbChek2));
            Modify.lbPassError.setText("* Campo Requerido");
        }else if (Modify.txtNewPass.getText().length() < 6) {
            Modify.lbChek2.setIcon(SImage("/Icon/error.png", Modify.lbChek2));
            Modify.lbPassError.setText("* La Contraseña debe ser Mayor o Igual a 6");
        }else if (Modify.txtNewPass.getText().length() > 13) {
            e.consume();            
            Modify.lbChek2.setIcon(SImage("/Icon/error.png", Modify.lbChek2));
            Modify.lbPassError.setText("* La Contraseña debe ser Menor o Igual a 13");
        }else {
            Modify.lbChek2.setIcon(SImage("/Icon/accept1.png", Modify.lbChek2));
            Modify.lbPassError.setText("");
        }
        
        if (Modify.txtRepitPass.getText().isEmpty()) {
            Modify.lbChek3.setIcon(SImage("/Icon/error.png", Modify.lbChek3));
            Modify.lbRepitError.setText("* Campo Requerido");
        }else if (Modify.txtRepitPass.getText().length() < 6) {
            Modify.lbChek3.setIcon(SImage("/Icon/error.png", Modify.lbChek3));
            Modify.lbRepitError.setText("* La Contraseña debe ser Mayor o Igual a 6");
        }else if (Modify.txtRepitPass.getText().length() > 13) {
            e.consume();            
            Modify.lbChek3.setIcon(SImage("/Icon/error.png", Modify.lbChek3));
            Modify.lbRepitError.setText("* La Contraseña debe ser Menor o Igual a 13");
        }else if (!Modify.txtRepitPass.getText().equals(Modify.txtNewPass.getText())) {
            Modify.lbChek3.setIcon(SImage("/Icon/error.png", Modify.lbChek3));
            Modify.lbRepitError.setText("* Las Contraseñas No Son Iguales");
        }else {
            Modify.lbChek3.setIcon(SImage("/Icon/accept1.png", Modify.lbChek3));
            Modify.lbRepitError.setText("");
        }
        if (Modify.txtCurrentPass.getText().isEmpty() || Modify.txtNewPass.getText().isEmpty() 
                || !Modify.txtCurrentPass.getText().equals(encryptPassword.Decrypted(userModel.getPassword())) 
                || !Modify.txtRepitPass.getText().equals(Modify.txtNewPass.getText())){
            Modify.btnChange.setEnabled(false);
        }else {
            Modify.btnChange.setEnabled(true);
        }
    }
    
    private void modifySize() {
        // Tamaño de la pantalla            
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Modify.jPanel1.setLocation((screenSize.width / 2) - (Modify.jPanel1.getWidth() / 2), (screenSize.height / 4) - (Modify.jPanel1.getHeight() / 4));
    }

    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }
}
