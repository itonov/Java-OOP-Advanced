package lab_exercise.interfaces;

import lab_exercise.enums.LogType;

public interface Handler {
    void handle(LogType type, String message);
    void setSuccessor(Handler successor);
}
