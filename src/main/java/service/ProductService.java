package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public  class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "sk2", "https://images.foody.vn/res/g26/253383/prof/s576x330/foody-mobile-2-jpg-469-636035066005028786.jpg"));
        products.add(new Product(2, "sk2 pro", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHb6fRsNbFSOs7Ky8n5MopZTNkUXixZpCvCGPWKuBw3Pp3lRm2URItix5ev8nNWISyeTo&usqp=CAU"));
        products.add(new Product(3, "vitamin C", "https://product.hstatic.net/1000296801/product/vien-uong-trang-da-vitamin-c-dhc-nhat-ban_06a8be7ed4fb4c3d92c18aa351466c89_master.jpg"));
        products.add(new Product(4, "Colagen", "https://chuyenhangchinhhang.com/img/vien-uong-bo-sung-collagen-tuoi-dhc-nhat-ban-chiet-xuat-tu-ca-bien-1.jpg"));
    }



    public void create(Product product) {
        products.add(product);
    }
    public void edit (int index,Product product){
        products.set(index,product);
    }
    public void delete (int id) {
        products.remove(id);
    }
    public int findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id==products.get(i).getId())
                return i;
        }
        return -1;
    }

}

