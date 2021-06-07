package Model;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;

public class UserDAO {
    DbConnection connection;
    
    public UserDAO() {
        try {                        
            connection = new DbConnection();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public UserModel Verify(String account) {
        UserModel userModel = null;
        Connection access = connection.Connect();        
        try {
            String consult = "SELECT * FROM user WHERE account='" +account+ "';";
            PreparedStatement ps = access.prepareStatement(consult);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                userModel = new UserModel();
                userModel.setId_user(rs.getInt(1));
                userModel.setName(rs.getString(2));
                userModel.setSurname_pater(rs.getString(3));
                userModel.setSurname_mother(rs.getString(4));
                userModel.setAccount(rs.getString(5));
                userModel.setPassword(rs.getString(6));
                userModel.setLevel(rs.getInt(7));
                return userModel;
            }else {
                JOptionPane.showMessageDialog(null, " Usuario Incorrecto", "Verificar Usuario", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR EN BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } 
        return userModel;
    }
    
    public UserModel VerifyId(int Id) {
        UserModel userModel = null;
        Connection access = connection.Connect();        
        try {
            String sql = "SELECT * FROM user WHERE Id_user='" +Id+ "';";
            PreparedStatement ps = access.prepareStatement(sql);
            //ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userModel = new UserModel();
                userModel.setId_user(rs.getInt(1));
                userModel.setName(rs.getString(2));
                userModel.setSurname_pater(rs.getString(3));
                userModel.setSurname_mother(rs.getString(4));
                userModel.setAccount(rs.getString(5));
                userModel.setPassword(rs.getString(6));
                userModel.setLevel(rs.getInt(7));
                return userModel;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        } 
        return userModel;
    }
    
    public LinkedList<UserModel> ViewUser() {
        LinkedList<UserModel> listUser = new LinkedList<UserModel>();
        UserModel userModel = null;
        Connection access = connection.Connect();
        try {
            String sql = "SELECT account FROM user ORDER BY name ASC";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                userModel = new UserModel();
                userModel.setAccount(rs.getString(1));
                listUser.add(userModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        } 
        return listUser;
    }
    
    public void AddUser(String name, String pater, String mother, String account, String password, int level){
        Connection access = connection.Connect();
        try {
            String sql = "INSERT INTO user(name, surname_pater, surname_mother, account, password, level) VALUES ('" + name + "','" + pater + "','" + mother + "','" + account + "','" + password + "','" + level + "')";
            PreparedStatement ps = access.prepareStatement(sql);            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, name+" Se Registro Exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, name+" No Se Pudo Registrar", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ModifyPassword(int id, String password) {
        Connection access = connection.Connect();
        int confimation = JOptionPane.showConfirmDialog(null, "¿Desea Modificar Los Datos Actuales?");
        if (confimation == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE user SET password=?"+ "WHERE Id_user=?";
                PreparedStatement ps = access.prepareStatement(sql);
                ps.setString(1, password);
                ps.setInt(2, id);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, " La Contraseña Fue Actualizado Exitosamente","Operacion Exitosa",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, " No se pudo Actualizar","Error en la Operacion",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}