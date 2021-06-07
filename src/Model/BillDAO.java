package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class BillDAO {
    DbConnection connection;

    public BillDAO() {
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
    
    public void AddBill(int quantity, String name, String address, String nit, String date) {        
        int confimation = JOptionPane.showConfirmDialog(null, "¿Desea Modificar Los Datos Actuales?");
        if (confimation == JOptionPane.YES_OPTION) {
            Connection access = connection.Connect();
            try {
                String sql = "INSERT INTO bill(quantiy, name, address, nit, date) VALUES ('" + quantity + "','" + name + "','" + address + "','" + nit + "','" + date + "')";
                PreparedStatement ps = access.prepareStatement(sql);            
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, name+" Se Registro Exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, name+" No Se Pudo Registrar", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
            }
        }
    }
}
