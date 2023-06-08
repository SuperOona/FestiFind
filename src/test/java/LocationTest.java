import festi.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static festi.model.User.createUser;
import static festi.model.User.getByEmail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
    @Test
    void locationCamp(){
        ArrayList<Date> dates = new ArrayList<>();
        Date date = new Date(2000, 01, 18);
        dates.add(date);

        Artist oona = new Artist("Oona Bertrums");
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(oona);

        Festival oonaFest = new Festival("oonaFest", dates);
        Stage camp = new Stage("camp", oonaFest, artists);
        createUser("superOona", "OonaIsCool2", "o@hot.com");
        User user = getByEmail("o@hot.com");
        Location location = new Location(camp, user);
        location.setPlacing(Placing.CENTERN);

        assertEquals(location.getPlacing(), null);
    }
}
