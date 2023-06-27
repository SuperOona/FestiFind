package festi.setUp;

import festi.model.*;

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
        createUser("nickvanSimon", "nick", "n@hot.com");
        createAdmin("admin","adminGod","admin@festifind.nl");
        User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        User nick = getByEmail("n@hot.com");
        oona.addFriend(nick);
        oona.addFriend(daphne);
        daphne.addFriend(oona);
        //make festval
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(2024, 01, 18));
        Festival festival = Festival.createFestival("test", dates);
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Oona"));
        Stage stage = new Stage("test", festival,artists);
        Stage alpha = new Stage("alpha", festival, artists);
        //set location
        Location location = new Location(stage);
        Location location1 = new Location(alpha);
        location1.setPlacing(Placing.BACKCENTERN);
        location.setPlacing(Placing.CENTERN);
        location.setAccount(oona);
        location.setAccount(daphne);
        location1.setAccount(daphne);
        oona.setLocation(location);
        daphne.setLocation(location);
        daphne.setLocation(location1);
        //make friendgroup
        ArrayList<User> friends = new ArrayList<>();
        friends.add(daphne);
        friends.add(oona);
        FriendGroup friendGroup = new FriendGroup("Zorf", festival, friends);
        FriendGroup friendGroup2 = new FriendGroup("Lekker met de meiden", festival, friends);

        daphne.addGroup(friendGroup);
        oona.addGroup(friendGroup);
        daphne.addGroup(friendGroup2);
        oona.addGroup(friendGroup2);
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
