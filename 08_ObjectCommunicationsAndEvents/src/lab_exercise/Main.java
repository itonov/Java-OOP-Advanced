package lab_exercise;

import lab_exercise.enums.LogType;
import lab_exercise.interfaces.Handler;
import lab_exercise.loggers.CombatLogger;
import lab_exercise.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {
        Handler combatLog = new CombatLogger();
        Handler eventLog = new EventLogger();

        combatLog.setSuccessor(eventLog);

        combatLog.handle(LogType.ATTACK, "some attack");
        combatLog.handle(LogType.ERROR, "some error");
        combatLog.handle(LogType.EVENT, "random event");
    }
}
