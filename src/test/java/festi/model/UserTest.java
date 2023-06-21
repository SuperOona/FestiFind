package festi.model;

import festi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static festi.model.User.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @BeforeEach
    void clear(){
        User.clearUsers();
    }

    @Test
    void cantBeMyOwnFriend(){

        System.out.println(getAllUsers());
        System.out.println(createUser("SuperOona", "oona", "o@hot.com"));
        createUser("dahpeWest", "daphne", "d@hot.com");
        User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        ArrayList<User> expected = new ArrayList<>();
        expected.add(daphne);

        oona.addFriend(daphne);
        oona.addFriend(oona);

        assertEquals(oona.getFriends(), expected);

    }

    @Test
    void emailUnique(){
        createUser("SuperOona", "oona", "o@hot.com");
        createUser("dahpeWest", "daphne", "l@hot.com");
        /*User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        try {

            User leo = getByEmail("l@hot.com");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }


        ArrayList<String> users = new ArrayList<>();
        users.add(oona.getEmail());
        users.add(daphne.getEmail());*/

        System.out.println(getAllUsers());
        assertFalse(createUser("leojenns", "leo", "l@hot.com"));
    }

    @Test
    public void canLoadUsers(){
        User.clearUsers();

        User u = createUser2("Tom", "Tom", "t@hotmai.nl");
        User.clearUsers();
        User.setAllUsers(List.of(u));

        assertEquals(1, User.getAllUsers().size());

    }
}
