package lab_exercise.loggers;

import lab_exercise.enums.LogType;

public class CombatLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}
