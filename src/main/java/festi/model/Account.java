package festi.model;

import java.util.ArrayList;
import java.util.Objects;
import festi.model.Location;

public class Account {
    private String username;
    private String password;
    private String email;
    private Location location;
    private ArrayList<Account> friends;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public ArrayList<Account> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Account> friends) {
        this.friends = friends;
    }
    public void addFriend(Account account){
        if(!Objects.equals(account.email, this.email)){
            friends.add(account);
        }
    }
}
