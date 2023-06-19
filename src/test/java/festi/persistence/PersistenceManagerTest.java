package festi.persistence;

import festi.model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static festi.model.User.*;
import static festi.persistence.PersistenceManager.loadUsersFromFile;
import static festi.persistence.PersistenceManager.saveUsersToFile;
import static org.junit.jupiter.api.Assertions.*;

class PersistenceManagerTest {

    @Test
    void loadUsersFromFileTest() throws IOException, ClassNotFoundException {
        clearUsers();
        User.createAdmin("admin", "adminGod", "admin@festifind.nl");
        User.createUser("SuperOona", "oona", "o@hot.com");
        saveUsersToFile();

        //loadUsersFromFile();


        /*System.out.println(User.getAllUsers().size());
        for (User u : User.getAllUsers()) {
            System.out.println(u.getName());
        }*/
        assertEquals(2, User.getAllUsers().size());
    }
}