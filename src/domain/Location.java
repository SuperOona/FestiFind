package domain;

import java.util.UUID;

public class Location {
    private String locationId;
    private Stage stage;
    private Account account;
    private FriendGroep friendGroep;
    private Placing placing;

    public Location(Stage stage, Account account, FriendGroep friendGroep, Placing placing) {
        this.locationId = UUID.randomUUID().toString();
        this.stage = stage;
        this.account = account;
        this.friendGroep = friendGroep;
        this.placing = placing;
    }

    public String getLocationId() {
        return locationId;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public FriendGroep getFriendGroep() {
        return friendGroep;
    }

    public void setFriendGroep(FriendGroep friendGroep) {
        this.friendGroep = friendGroep;
    }

    public Placing getPlacing() {
        return placing;
    }

    public void setPlacing(Placing placing) {
        this.placing = placing;
    }
}
