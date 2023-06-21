package festi.setUp;

import festi.model.Festival;
import festi.model.Stage;
import festi.model.User;
import festi.model.Artist;
import festi.model.Location;

import festi.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static festi.model.User.*;
import static festi.model.User.getByEmail;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private void makeTestData() {
        createUser("superOona", "oona", "o@hot.com");
        createUser("dahpeWest", "daphne", "d@hot.com");
        createAdmin("admin","adminGod","admin@festifind.nl");
        User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        oona.addFriend(daphne);
        daphne.addFriend(oona);
        //make festval
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(2024, 01, 18));
        Festival festival = new Festival("test", dates);
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Oona"));
        Stage stage = new Stage("test", festival,artists);
        //set location
        Location location = new Location(stage);
        oona.setLocation(location);
        daphne.setLocation(location);
    }

    @Override
    public void contextInitialized(ServletContextEvent event){
        makeTestData();
     /*   try {
            PersistenceManager.loadUsersFromFile();
        }catch (Exception e){
            System.out.println(e);
        }*/


    }


    @Override
    public void contextDestroyed(ServletContextEvent event){
      /*  try {
            PersistenceManager.saveUsersToFile();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("doei");
    }

}
