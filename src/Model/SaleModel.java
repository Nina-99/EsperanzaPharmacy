package Model;

import java.util.Date;

public class SaleModel {
    int id_sale;
    double total;
    Date date;    
    int id_user;

    public SaleModel() {
        id_sale = 0;
        total = 0.0;
        date = date;
        id_user = 0;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
