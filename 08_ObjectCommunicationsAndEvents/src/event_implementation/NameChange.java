package event_implementation;

import java.util.EventObject;

public class NameChange extends EventObject {
    private String changedName;

    public NameChange(String changedName) {
        super(changedName);
        this.changedName = changedName;
    }

    public String getChangedName() {
        return this.changedName;
    }
}
