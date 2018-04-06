package lab_exercise.commands;

import lab_exercise.interfaces.Command;
import lab_exercise.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
