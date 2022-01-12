package service;

import model.Categories;
import model.Product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public  class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "sk2",500000,new Categories(1,"DHC japan"),new Date(System.currentTimeMillis()), "https://images.foody.vn/res/g26/253383/prof/s576x330/foody-mobile-2-jpg-469-636035066005028786.jpg"));
        products.add(new Product(2, "sk2 pro",450000,new Categories(2,"vitamin"),new Date(System.currentTimeMillis()), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHb6fRsNbFSOs7Ky8n5MopZTNkUXixZpCvCGPWKuBw3Pp3lRm2URItix5ev8nNWISyeTo&usqp=CAU"));
        products.add(new Product(3, "vitamin C",345000,new Categories(3,"senka"),new Date(System.currentTimeMillis()), "https://product.hstatic.net/1000296801/product/vien-uong-trang-da-vitamin-c-dhc-nhat-ban_06a8be7ed4fb4c3d92c18aa351466c89_master.jpg"));
        products.add(new Product(4, "Colagen",255000,new Categories(4,"ohiro"),new Date(System.currentTimeMillis()), "https://chuyenhangchinhhang.com/img/vien-uong-bo-sung-collagen-tuoi-dhc-nhat-ban-chiet-xuat-tu-ca-bien-1.jpg"));
    }


    public void create(Product product) {
        products.add(product);
    }

    public void edit(int index, Product product) {
        products.set(index, product);
    }

    public void delete(int id) {
        products.remove(id);
    }
    public Product findByName(String name) {
        for (Product p: products) {
            if (p.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))){
                return p;
            }
        }
        return null;
    }
}


