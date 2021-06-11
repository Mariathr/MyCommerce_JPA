package com.formation.mycommerce.listener;

import com.formation.mycommerce.util.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceAppListener implements ServletContextListener {

    // Call on application initialization
    public void contextInitialized(ServletContextEvent evt){
        PersistenceManager.connexionManagerFactory();
        // Do nothing
    }
    // Call on application destruction
    public void contextDestroyed(ServletContextEvent evt) {

        PersistenceManager.closeEntityManagerFactory();
    }
}
