package warningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance minImportance;

    public Logger(String importance) {
        this.minImportance = Enum.valueOf(Importance.class, importance);
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        if (this.minImportance.ordinal() <= message.getImportance().ordinal()) {
            messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
