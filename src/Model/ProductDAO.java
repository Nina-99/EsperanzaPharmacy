package Model;

import View.frmManager;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ProductDAO {
    DbConnection connection;

    public ProductDAO() {            
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
    
    public LinkedList<ProductModel> ViewProduct(String name) {
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        ProductModel product;
        frmManager Manager = new frmManager();
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM product WHERE name_product LIKE '%" + name + "%'";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product = new ProductModel();
                product.setId_product(rs.getInt(1));
                product.setName_product(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setExpiration(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setDescription(rs.getString(6));
                product.setSpecification(rs.getString(7));
                listProduct.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return listProduct;
    }
    
    public ProductModel VerifyName(String name) {
        ProductModel product = null;
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM product WHERE name_product ='" + name + "'";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                product = new ProductModel();
                product.setId_product(rs.getInt(1));
                product.setName_product(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setExpiration(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setDescription(rs.getString(6));
                product.setSpecification(rs.getString(7));
                return product;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
    
    public LinkedList<ProductModel> VerifyExpiration() {
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        ProductModel product;
        frmManager Manager = new frmManager();
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM product WHERE DATE(expiration) = DATE(NOW()) OR DATE(expiration) < DATE(NOW()) OR DATEDIFF(expiration,NOW()) <= 90";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product = new ProductModel();
                product.setId_product(rs.getInt(1));
                product.setName_product(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setExpiration(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setDescription(rs.getString(6));
                product.setSpecification(rs.getString(7));
                listProduct.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return listProduct;
    }
    
    public LinkedList<ProductModel> VerifyQuantity(int quantity) {
        LinkedList<ProductModel> listProduct = new LinkedList<ProductModel>();
        ProductModel product;
        frmManager Manager = new frmManager();
        Connection access = connection.Connect();
        try {
            String sql = "SELECT * FROM product WHERE quantity < '" +quantity+ "'";
            PreparedStatement ps = access.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product = new ProductModel();
                product.setId_product(rs.getInt(1));
                product.setName_product(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setExpiration(rs.getDate(4));
                product.setQuantity(rs.getInt(5));
                product.setDescription(rs.getString(6));
                product.setSpecification(rs.getString(7));
                listProduct.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base De Datos", JOptionPane.ERROR_MESSAGE);
        }
        return listProduct;
    }
    
    public void AddProduct(String name, double price, String expiration, int quantity, String description, String specification) {
        Connection access = connection.Connect();
        try {
            String sql = "INSERT INTO product (name_product, price, expiration, quantity, description, specification) VALUES ('" + name + "','" + price + "','" + expiration + "','" + quantity + "','" + description + "','" + specification + "')";
            PreparedStatement ps = access.prepareStatement(sql);            
            if (ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, name+" Registrado Exitosamente","Operacion Exitosa",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, name+" No se pudo Registrar","Error en la Operacion",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }
    
    public void ModifyProduct(int id, String name, double price, String expiration, int quantity, String description, String specification) {
        Connection access = connection.Connect();
        int confimation = JOptionPane.showConfirmDialog(null, "¿Desea Modificar Los Datos Actuales?");
        if (confimation == JOptionPane.YES_OPTION) {
            try {
                String sql = "UPDATE product SET name_product=?, price=?, expiration=?, quantity=?, description=?, specification=?"+ "WHERE id_product = ?";
                PreparedStatement ps = access.prepareStatement(sql);
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setString(3, expiration);
                ps.setInt(4, quantity);
                ps.setString(5, description);
                ps.setString(6, specification);
                ps.setInt(7, id);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, name+" Actualizado exitosamente","Operacion Exitosa",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, name+" No se pudo Actualizar","Error en la Operacion",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Registro Fallido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void ModifyQuantity(int id, int quantity) {
        Connection access = connection.Connect();
        try {
            String sql = "UPDATE product SET quantity='" + quantity+ "'"+ "WHERE id_product='"+id+"'";
            PreparedStatement ps = access.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Actualizacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }
}