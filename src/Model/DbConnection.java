package Model;

import java.sql.*;
//import java.sql.Connection;

public class DbConnection {
    
    public DbConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    }
    public Connection Connect() {
        Connection con = null;
        try {
            // Datos necesarios para la conexion
            String URL = "jdbc:mysql://localhost:3306/dbesperanzapharmacy";
            String user = "root";
            String pass = "";
            // Conexion con la  Base de Datos
            con = DriverManager.getConnection(URL, user, pass);
        }catch (SQLException ex){            
        }catch (Exception e) {
        }
        return con;
    }
}
