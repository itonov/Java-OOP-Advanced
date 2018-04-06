package lab_exercise.commands;

import lab_exercise.interfaces.Attacker;
import lab_exercise.interfaces.Command;
import lab_exercise.interfaces.Target;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {

    }
}
