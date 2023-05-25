package festi.model;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String email;
    private Location location;
    private ArrayList<User> friends;
    private static ArrayList<String> registerdEmail = new ArrayList<>();

    public User(String username, String password, String email) {
        if (registerdEmail.contains(email)) throw new IllegalArgumentException("Email in use");
        this.username = username;
        this.password = password;
        this.email = email;
        this.friends = new ArrayList<User>();
        registerdEmail.add(email);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEmailRegistered(String email){
        return registerdEmail.contains(email);
    }

    public static ArrayList<String> getRegisterdEmail() {
        return registerdEmail;
    }
}
