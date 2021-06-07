package Model;

import java.util.Date;

public class SoldModel {
    int id_sold;
    String product;
    Double price;
    int quantity;
    Date date;
    int id_user;
    String name_user;

    public SoldModel() {
        id_sold = 0;
        product = "";
        price = 0.0;
        quantity = 0;
        date = date;
        id_user = 0;
        name_user = "";
    }    

    public int getId_sold() {
        return id_sold;
    }

    public void setId_sold(int id_sold) {
        this.id_sold = id_sold;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    
    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
}