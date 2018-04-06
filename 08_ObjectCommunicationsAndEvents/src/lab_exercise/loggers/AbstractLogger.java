package lab_exercise.loggers;

import lab_exercise.enums.LogType;
import lab_exercise.interfaces.Handler;

public abstract class AbstractLogger implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public abstract void handle(LogType type, String message);

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }
}
