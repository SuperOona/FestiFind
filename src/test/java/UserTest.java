import festi.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {
    @Test
    void cantBeMyOwnFriend(){
        User oona = new User("SuperOona", "oona", "o@hot.com");
        User daphne = new User("dahpeWest", "daphne", "d@hot.com");
        ArrayList<User> expected = new ArrayList<>();
        expected.add(daphne);

        oona.addFriend(daphne);
        oona.addFriend(oona);

        assertEquals(oona.getFriends(), expected);

    }

    @Test
    void emailUnique(){
        User oona = new User("SuperOona", "oona", "o@hot.com");
        User daphne = new User("dahpeWest", "daphne", "l@hot.com");
        try {
            User leo = new User("leojenns", "leo", "l@hot.com");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }


        ArrayList<String> users = new ArrayList<>();
        users.add(oona.getEmail());
        users.add(daphne.getEmail());


        assertEquals(User.getRegisterdEmail(), users);



    }
}
