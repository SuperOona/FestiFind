package festi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Stage{
    private String stageId;
    private String stageName;
    private ArrayList<Artist> artists;

    public Stage( String stageName, ArrayList<Artist> artists) {
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;
        this.artists = artists;
    }

    public Stage( String stageName) {
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;

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

    public ArrayList<Artist> getArtist() {
        return artists;
    }

    public void addArtist(Artist artist) {
        if(!artists.contains(artist)){
            artists.add(artist);
        }
    }
}

