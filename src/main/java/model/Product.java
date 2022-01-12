package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

public class Product {
    private long id;
    private String name;
    private double price;
    private Categories categories;
    private Date date;
    private String img;


    public Product() {
    }

    public Product(long id, String name, double price, Categories categories, Date date, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.date = date;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}