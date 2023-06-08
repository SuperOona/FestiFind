import festi.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static festi.model.User.createUser;
import static festi.model.User.getByEmail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {
    @Test
    void cantBeMyOwnFriend(){
        createUser("SuperOona", "oona", "o@hot.com");
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
        createUser("dahpeWest", "daphne", "d@hot.com");
        User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        try {
            createUser("leojenns", "leo", "l@hot.com");
            User leo = getByEmail("l@hot.com");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }


        ArrayList<String> users = new ArrayList<>();
        users.add(oona.getEmail());
        users.add(daphne.getEmail());


        assertEquals(User.getRegisterdEmail(), users);
    }
}
