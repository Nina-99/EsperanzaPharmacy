package Model;

import java.util.Date;

public class vendido {

    int id_vendido;
    String producto;
    double precio;
    int cantidad;
    Date fecha;

    public vendido() {
    }

    public vendido(int id_vendido, String producto, double precio, int cantidad, Date fecha) {
        this.id_vendido = id_vendido;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId_vendido() {
        return id_vendido;
    }

    public void setId_vendido(int id_vendido) {
        this.id_vendido = id_vendido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
