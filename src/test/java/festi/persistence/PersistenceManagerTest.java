package festi.persistence;

import festi.model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static festi.model.User.createUser;
import static festi.model.User.getAllUsers;
import static org.junit.jupiter.api.Assertions.*;

class PersistenceManagerTest {

    @Test
    void loadUsersFromFile() throws IOException, ClassNotFoundException {
        createUser("SuperOona", "oona", "o@hot.com");
        List<User> old = getAllUsers();
        try {
            PersistenceManager.saveUsersToFile();
            PersistenceManager.loadUsersFromFile();
        }catch (IOException oie){
            System.out.println(oie);
        }
        List<User> loaded = getAllUsers();
        assertEquals(old, loaded);
    }
}