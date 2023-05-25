import festi.model.Artist;
import festi.model.Festival;
import festi.model.Stage;
import org.junit.jupiter.api.Test;

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
        ArrayList<Date> dates = new ArrayList<>(18-01-2024);
        Festival oonaFest = new Festival("OonaFest", dates);
        Stage main = new Stage("main", oonaFest);
        Artist oona = new Artist("Oona Bertrums", main);
        main.addArtist(oona);
        assertEquals(main.getArtist(), oona);
    }

    @Test
    void artistDoubleAdd(){
        ArrayList<Date> dates = new ArrayList<>(18-01-2024);
        Festival oonaFest = new Festival("OonaFest", dates);
        Stage main = new Stage("main", oonaFest);
        Artist oona = new Artist("Oona Bertrums", main);
        main.addArtist(oona);
        assertEquals(main.getArtist(), oona);
    }
}
