package main.java.festi.model;

import java.util.ArrayList;
import java.util.UUID;

public class FriendGroep {
    private String friendGroupId;
    private Festival festival;
    private ArrayList<Location> locations;
    private ArrayList<Account> friends;

    public FriendGroep(Festival festival, ArrayList<Location> locations, ArrayList<Account> friends) {
        this.friendGroupId = UUID.randomUUID().toString();
        this.festival = festival;
        this.locations = locations;
        this.friends = friends;
    }

    public String getFriendGroupId() {
        return friendGroupId;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Account> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Account> friends) {
        this.friends = friends;
    }
}
