package event_implementation.interfaces;

import event_implementation.NameChange;

public interface NameChangeListener {
    void handleChangedName(NameChange event);
}
