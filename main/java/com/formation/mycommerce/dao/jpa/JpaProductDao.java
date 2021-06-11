package com.formation.mycommerce.dao.jpa;

import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaProductDao implements ProductDao<Long, Product> {
    private static EntityManagerFactory emf;

    //Constructor
    public JpaProductDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public Long createProducts(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        long var =0;
        try {
            et.begin();
            em.persist(product);
            et.commit();
            var = product.getId();
        } catch (RuntimeException e) {

        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
        return var;
    }

    @Override
    public Product findProductsById(Long id) {
        Product product = new Product();
        EntityManager em = emf.createEntityManager();
        product = em.find(Product.class,id);
        em.close();
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        EntityManager em = emf.createEntityManager();
        List<Product> list =  em.createQuery("SELECT a FROM Product a", Product.class).getResultList();
        //em.createQuery("FROM Products").getResultList();
        em.close();

        return list;
    }

    @Override
    public Boolean updateProducts(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean isUpdate = false;
        try{
            et.begin();
            em.merge(product);
            et.commit();
            isUpdate = true;
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return isUpdate;
    }

    @Override
    public Boolean removeProducts(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Product product = em.find(Product.class, id);
        boolean isRemove = false;
        try{
            et.begin();
            em.remove(product);
            et.commit();
            isRemove = true;
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return isRemove;
    }
}
