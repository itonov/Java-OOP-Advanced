package lab_exercise.commands;

import lab_exercise.interfaces.AttackGroup;
import lab_exercise.interfaces.Command;
import lab_exercise.interfaces.Target;

public class GroupTargetCommand implements Command {
    private AttackGroup group;
    private Target target;

    public GroupTargetCommand(AttackGroup group, Target target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {

    }
}
