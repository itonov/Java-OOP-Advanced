package database;

public class Human {
    private String username;
    private long id;

    public Human(String username, long id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public long getId() {
        return this.id;
    }
}
