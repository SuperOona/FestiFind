package festi.webservices;

import festi.authentication.AuthenticationResource;
import festi.model.*;
import festi.request.LoginReqeust;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.Date;

import static festi.model.User.*;

class dashboardResourceTest {

    @BeforeEach
    void clear(){
        User.clearUsers();
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
        Festival festival = new Festival("test", dates);
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Oona"));
        Stage stage = new Stage("test", festival,artists);
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