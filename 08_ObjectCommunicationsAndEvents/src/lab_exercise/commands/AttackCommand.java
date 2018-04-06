package lab_exercise.commands;

import lab_exercise.interfaces.Attacker;
import lab_exercise.interfaces.Command;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {

    }
}
