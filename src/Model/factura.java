package Model;

import java.util.Date;

public class factura {

    int id_factura;
    double cantidad;
    String nombre;
    String direccion;
    int nit;
    Date fecha;

    public factura() {
    }

    public factura(int id_factura, double cantidad, String nombre, String direccion, int nit, Date fecha) {
        this.id_factura = id_factura;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.fecha = fecha;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
