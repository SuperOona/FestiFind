package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Festival {
    private String festId;
    private String name;
    private ArrayList<Date> date;
    private ArrayList<Stage> stages;

    public Festival(String name, ArrayList<Date> date) {
        this.festId = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
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
}
