package festi.model;

import java.util.ArrayList;
import java.util.UUID;

public class FriendGroup {
    private String friendGroupId;
    private String groupName;
    private Festival festival;
    private ArrayList<User> friends;

    public FriendGroup(String groupName, Festival festival, ArrayList<User> friends) {
        this.friendGroupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.festival = festival;
        this.friends = friends;
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
