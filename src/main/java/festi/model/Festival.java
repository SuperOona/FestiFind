package festi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import festi.model.Stage;


public class Festival {
    private String festId;
    private String name;
    private ArrayList<Date> date;
    private ArrayList<Stage> stages;

    private static ArrayList<Festival> allFestivals;

    public Festival(String name, ArrayList<Date> date) {
        this.festId = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
    }

    /*public static boolean createFestival(String name, ArrayList<Date>){

    }*/
    public String getFestId() {
        return festId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Date> getDate() {
        return date;
    }

    public void setDate(ArrayList<Date> date) {
        this.date = date;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public void addStages(Stage stage) {
        this.stages.add(stage);
    }
}
