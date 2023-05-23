package domain;

public class Artist {
    private String name;
    private Stage stage;

    public Artist(String name, Stage stage) {
        this.name = name;
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
