package festi.model;

import java.util.ArrayList;
import java.util.UUID;

public class FriendGroup {
    private String friendGroupId;
    private Festival festival;
    private ArrayList<Location> locations;
    private ArrayList<User> friends;

    public FriendGroup(Festival festival, ArrayList<Location> locations, ArrayList<User> friends) {
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

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
}
