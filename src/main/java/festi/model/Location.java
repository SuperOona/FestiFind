package festi.model;

import java.util.UUID;

public class Location {
    private String locationId;
    private Stage stage;
    private User user;
    private Placing placing;

    public Location(Stage stage) {
        this.locationId = UUID.randomUUID().toString();
        this.stage = stage;
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

    public User getAccount() {
        return user;
    }

    public void setAccount(User user) {
        this.user = user;
    }

    public Placing getPlacing() {
        return placing;
    }

    public void setPlacing(Placing placing) {
        if(!(stage.getStageName() == "camp")){
            this.placing = placing;
        }

    }
}
