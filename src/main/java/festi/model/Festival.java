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

    private static ArrayList<Festival> allFestivals = new ArrayList<>();

    private Festival(String name, ArrayList<Date> date) {
        this.festId = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
    }

    public static ArrayList<Festival> getAllFestivals() {
        return allFestivals;
    }

    public static Festival createFestival(String name, ArrayList<Date> dates){
        Festival festival = new Festival(name, dates);
        allFestivals.add(festival);
        return festival;
    }
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

    public static Festival getByName(String name){
        for (Festival feest : getAllFestivals()){
            if (feest.name == name){
                return feest;
            }
        }
        return null;
    }
   /* public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(2024, 01, 18));
        System.out.println(createFestival("main", dates));
        System.out.println(Festival.getAllFestivals());
    }*/
}

