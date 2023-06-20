package festi.setUp;

import festi.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

import static festi.model.User.createAdmin;
import static festi.model.User.createUser;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event){
        try {
            PersistenceManager.loadUsersFromFile();

        }catch (Exception e){
            System.out.println(e);
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent event){
        try {
            PersistenceManager.saveUsersToFile();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}