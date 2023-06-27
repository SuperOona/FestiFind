package festi.model;

import festi.model.Artist;
import festi.model.Festival;
import festi.model.Stage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StageTest {

    @Test
    void dummyTest(){
        assertEquals(1,1);
    }

    @Test
    void artistAdd(){
        ArrayList<Date> dates = new ArrayList<>();
        Date date = new Date(2000, 01, 18);
        dates.add(date);

        Festival oonaFest = Festival.createFestival("OonaFest", dates);
        Artist oona = new Artist("Oona Bertrums");
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(oona);
        Stage main = new Stage("main", oonaFest, artists);


        assertEquals(main.getArtist(), artists);
    }

    @Test
    void artistDoubleAdd(){
        ArrayList<Date> dates = new ArrayList<>();
        Date date = new Date(2000, 01, 18);
        dates.add(date);

        Festival oonaFest = Festival.createFestival("OonaFest", dates);
        Artist oona = new Artist("Oona Bertrums");
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(oona);
        Stage main = new Stage("main", oonaFest, artists);

        main.addArtist(oona);


        assertEquals(main.getArtist(), artists);
    }
}
