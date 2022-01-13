//package repository;
//
//import model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import java.util.ArrayList;
//
//public class ProductRepo implements IProductRepo {
//    @Autowired
//    EntityManager entityManager;
//
//    @Override
//    public Product save(Product product) {
//        EntityTransaction ett = entityManager.getTransaction();
//        ett.begin();
//        entityManager.persist(product);
//        ett.commit();
//        return product;
//    }
//
//    @Override
//    public ArrayList<Product> findAll() {
//        return null;
//    }
//
//    @Override
//    public void Delete(Product product) {
//
//    }
//
//    @Override
//    public void edit(Product product) {
//
//    }
//}
