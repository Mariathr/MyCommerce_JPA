package com.formation.mycommerce.dao.jpa;

import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.entity.Category;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class JpaCategoryDao implements CategoryDao<Long, Category> {
    private static EntityManagerFactory emf;

    //Constructor
    public JpaCategoryDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }
    public JpaCategoryDao(){

    }
    //Medode
    @Override
    public Long createCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        em.persist(category);
        long var=0;
        try{
            et.begin();
            et.commit();
            var =category.getId();
        }catch (RuntimeException e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }

        return var;
    }
    @Override
    public Category findCategoryById(Long id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class,id);
        em.close();
        return category;
    }

    @Override
    public List<Category> findAllCategory() {
        EntityManager em = emf.createEntityManager();
        List<Category> list = new ArrayList();
        list = em.createQuery("SELECT a FROM Category a", Category.class).getResultList();
        return list;

    }

    @Override
    public Boolean updateCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        boolean isUpdate = false;
        try{
            et.begin();
            em.merge(category);
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
    public Boolean removeCategory(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Category category = em.find(Category.class, id);
        boolean isRemove = false;
        try{
            et.begin();
            em.remove(category);
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
