package festi.model;

import java.util.ArrayList;
import java.util.UUID;

public class Stage{
    private String stageId;
    private String stageName;
    private Festival festival;
    private ArrayList<Artist> artists;

    public Stage( String stageName, Festival festival) {
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;
        this.festival = festival;

    }

    public String getStageId() {
        return stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public ArrayList<Artist> getArtist() {
        return artists;
    }

    public void addArtist(Artist artist) {
        if(!artists.contains(artist)){
            artists.add(artist);
        }
    }
}

