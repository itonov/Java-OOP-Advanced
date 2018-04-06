package lab_exercise.commands;

import lab_exercise.interfaces.AttackGroup;
import lab_exercise.interfaces.Command;

public class GroupAttackCommand implements Command {
    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {

    }
}
