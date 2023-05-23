import domain.Festival;
import domain.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();
        ArrayList<Stage> stages = new ArrayList<>();
        Festival fest = new Festival("OonaFest", dates, stages);
        System.out.println(fest.getFestId());
    }
}