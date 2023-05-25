package festi.model;

import java.util.UUID;
import festi.model.Festival;
import festi.model.Artist;

public class Stage{
    private String stageId;
    private String stageName;
    private Festival festival;
    private Artist artist;

    public Stage( String stageName, Festival festival, Artist artist) {
        this.stageId = UUID.randomUUID().toString();
        this.stageName = stageName;
        this.festival = festival;
        this.artist = artist;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}

