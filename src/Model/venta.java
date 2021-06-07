package Model;

import java.util.Date;

public class venta {

    int id_venta;
    double total;
    Date fecha;

    public venta() {
    }

    public venta(int id_venta, double total, Date fecha) {
        this.id_venta = id_venta;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
