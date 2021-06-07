package Model;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class SoldDAO {
    DbConnection connection;
    public SoldDAO() {            
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
    public void AddSold(String product, Float price, int quantity, String date, int IdUser){
        Connection access = connection.Connect();
        try {
            String sql = "INSERT INTO sold(product, price, quantity, date, id_user) VALUES ('" + product + "','" + price + "','" + quantity + "','" + date + "','" + IdUser + "')";
            PreparedStatement ps = access.prepareStatement(sql);            
            if (ps.executeUpdate() > 0) {
                //JOptionPane.showMessageDialog(null, product+" Se Registro Exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, " No Se Pudo Registrar la venta", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public LinkedList<SoldModel> ViewSold(int IdUser, String date) {
        LinkedList<SoldModel> listSold = new LinkedList<SoldModel>();
        SoldModel soldModel;
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM sold WHERE (cast(date as DATE)) = '" + date + "' AND Id_user = '" + IdUser + "'";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                soldModel = new SoldModel();
                soldModel.setId_sold(rs.getInt(1));
                soldModel.setProduct(rs.getString(2));
                soldModel.setPrice(rs.getDouble(3));
                soldModel.setQuantity(rs.getInt(4));
                soldModel.setDate(rs.getDate(5));
                soldModel.setId_user(rs.getInt(6));
                String consult = "SELECT name, surname_pater FROM user WHERE Id_user='" +soldModel.getId_user()+ "';";
                PreparedStatement preparedStatement = access.prepareStatement(consult);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldModel.setName_user(resultSet.getString(1)+" "+resultSet.getString(2));
                }
                listSold.add(soldModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return listSold;
    }
    public LinkedList<SoldModel> ViewSoldAll() {
        LinkedList<SoldModel> listSold = new LinkedList<SoldModel>();
        SoldModel soldModel;
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM sold";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                soldModel = new SoldModel();
                soldModel.setId_sold(rs.getInt(1));
                soldModel.setProduct(rs.getString(2));
                soldModel.setPrice(rs.getDouble(3));
                soldModel.setQuantity(rs.getInt(4));
                soldModel.setDate(rs.getDate(5));
                soldModel.setId_user(rs.getInt(6));
                String consult = "SELECT name, surname_pater FROM user WHERE Id_user='" +soldModel.getId_user()+ "';";
                PreparedStatement preparedStatement = access.prepareStatement(consult);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldModel.setName_user(resultSet.getString(1)+" "+resultSet.getString(2));
                }
                listSold.add(soldModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return listSold;
    }
}
