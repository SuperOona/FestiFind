package festi.model;

import java.util.ArrayList;
import java.util.UUID;

import static festi.model.Festival.getByName;

public class FriendGroup {
    private String friendGroupId;
    private String groupName;
    private Festival festival;
    private ArrayList<User> friends;

    private static ArrayList<FriendGroup> allGroups = new ArrayList<>();

    public FriendGroup(String groupName, String festival) {
        this.friendGroupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.festival = getByName(festival);
    }

    public static void setGroups(ArrayList<FriendGroup> loaded) {
        for (FriendGroup group : loaded){
            allGroups.add(group);
        }
    }

    public static ArrayList<FriendGroup> getGroups() {
        return allGroups;
    }


    public String getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(String friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
}
