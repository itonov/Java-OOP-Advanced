package warningLevels;

public class Message {
    private String message;
    private Importance importance;

    public Message(String message, Importance importance) {
        this.message = message;
        this.importance = importance;
    }

    public String getMessage() {
        return this.message;
    }

    public Importance getImportance() {
        return this.importance;
    }

    @Override
    public String toString() {
        return this.importance.name() + ": " + this.message;
    }
}
