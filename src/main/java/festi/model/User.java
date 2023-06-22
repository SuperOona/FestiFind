package festi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User implements Principal, Serializable {
    private String username;
    private String password;
    private String email;
    private String role;
    private Location location;
    private ArrayList<User> friends;
    private static ArrayList<String> registerdEmail = new ArrayList<>();
    private static List<User> allUsers = new ArrayList<>();
    private ArrayList<FriendGroup> groups = new ArrayList<>();

    public static boolean createUser(String username, String password, String email){
        if (getByEmail(email) == null){
            return allUsers.add(new User(username, password, email, "user"));
        }
        return false;
    }

    public static User createUser2(String username, String password, String email){
        User u = new User(username, password, email, "user");
        if (getByEmail(email) == null){
            allUsers.add(u);
            return u;
        }
        throw new RuntimeException("Emailadres bestaat al");
    }

    public static boolean createAdmin(String username, String password, String email){
        if (getByEmail(email) == null){
            return allUsers.add(new User(username, password, email, "admin"));
        }
        return false;
    }

    public static User getByEmail(String email) {
        return allUsers.stream()
                .filter(user -> user.email.equals(email))
                .findFirst().orElse(null);
    }

    private User(String username, String password, String email, String role) {
        if (registerdEmail.contains(email)) throw new IllegalArgumentException("Email in use");
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;

        this.friends = new ArrayList<User>();
        registerdEmail.add(email);

    }

    public static String validateLogin(String email, String password) {
        User user = getByEmail(email);
        if (user != null && user.password.equals(password)) return user.role;
        return null;
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(List<User> newUsers) {
        allUsers = newUsers;
    }

    public static void clearUsers() {
        allUsers = new ArrayList<>();
        registerdEmail = new ArrayList<>();
    }

    @JsonIgnore
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean updatePassword(String newPassword){
        System.out.println("old: "+ password);
        System.out.println("new: "+ newPassword);
        if (!password.equals(newPassword)){
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
    public void addFriend(User user){
        if(!Objects.equals(user.email, this.email)){
            this.friends.add(user);
        }
    }
    @Override
    public String getName() {
        return username;
    }

    public String getRole() {
        return role;
    }


    public ArrayList<FriendGroup> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<FriendGroup> groups) {
        this.groups = groups;
    }

    public void addGroup(FriendGroup newFriendGroup) {
        groups.add(newFriendGroup);
    }

    public FriendGroup getGroupById(String id){
        for (FriendGroup group : groups){
            if (group.getFriendGroupId().equals(id)){
                return group;
            }
        }
        return null;
    }
}
