import main.java.festi.model.Festival;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();
        Festival fest = new Festival("OonaFest", dates);
        System.out.println(fest.getFestId());
    }
}