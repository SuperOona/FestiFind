package festi.model;

import festi.authentication.AuthenticationResource;
import festi.model.*;
import festi.webservices.DashboardResource;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static festi.model.User.*;
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

        Festival oonaFest = Festival.createFestival("oonaFest", dates);
        Stage camp = new Stage("camp", artists);
        oonaFest.addStages(camp);
        createUser("superOona", "OonaIsCool2", "o@hot.com");
        User user = getByEmail("o@hot.com");
        Location location = new Location(camp);
        location.setPlacing(Placing.CENTERN);

        assertEquals(location.getPlacing(), null);
    }

    @Test
    void getLocations(){
        //make users
        createUser("SuperOona", "oona", "o@hot.com");
        createUser("dahpeWest", "daphne", "d@hot.com");
        User oona = getByEmail("o@hot.com");
        User daphne = getByEmail("d@hot.com");
        oona.addFriend(daphne);
        daphne.addFriend(oona);
        //make festval
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(2024, 01, 18));
        Festival festival = Festival.createFestival("test", dates);
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Oona"));
        Stage stage = new Stage("test", artists);
        festival.addStages(stage);
        //set location
        Location location = new Location(stage);
        oona.setLocation(location);
        //resources
        AuthenticationResource auth = new AuthenticationResource();
        DashboardResource dash = new DashboardResource();

        //token
        String token = auth.createToken(daphne.getEmail(), daphne.getRole());

    }
}
