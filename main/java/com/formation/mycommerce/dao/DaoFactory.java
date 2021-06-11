package com.formation.mycommerce.dao;
import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.dao.jpa.JpaCategoryDao;
import com.formation.mycommerce.dao.jpa.JpaProductDao;
import com.formation.mycommerce.util.PersistenceManager;

public class DaoFactory {
    //Private constructor prevent instantiation
    private DaoFactory(){}

    public static CategoryDao getCategoryDao() {
      return new JpaCategoryDao(PersistenceManager.connexionManagerFactory());

    }
    public static ProductDao getProductDao() {

      return new JpaProductDao(PersistenceManager.connexionManagerFactory());
        // return new MemProductDao();
    }
}
    