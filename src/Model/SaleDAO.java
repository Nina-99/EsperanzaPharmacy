package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class SaleDAO {
     DbConnection connection;

    public SaleDAO() {            
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
    
    public void AddSale(Float total, String date, int IdUser){
        Connection access = connection.Connect();
        try {
            String sql = "INSERT INTO sale(total, date, id_user) VALUES ('" + total + "','" + date + "','" + IdUser + "')";
            PreparedStatement ps = access.prepareStatement(sql);            
            if (ps.executeUpdate() > 0) {
                //JOptionPane.showMessageDialog(null, name+" Se Registro Exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, " No Se Pudo Registrar la venta", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }
}
