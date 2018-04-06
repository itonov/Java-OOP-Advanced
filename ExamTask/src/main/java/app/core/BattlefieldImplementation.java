package app.core;

import app.contracts.*;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = targetableFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action;

            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames) {
                if (this.participants.containsKey(name)) {
                    actionParticipants.add(this.participants.get(name));
                } else {
                    System.out.println(String.format("%s is not on the battlefield. %s failed.", name, actionName));
                    return;
                }
            }

            switch (actionName) {
                case "OneVsOne":
                    action = new OneVsOne();
                    break;
                case "BossFight":
                    action = new BossFight((Targetable) this.participants.values().toArray()[0]);
                    break;
                default:
                    action = null;
                    break;
            }

            this.writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            this.writer.writeLine("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)) {
            this.writer.writeLine("Participant with that name already exists.");
            return;
        }

        Targetable targetable;

        switch (className) {
            case "Warrior":
                targetable = new Warrior(name);
                this.participants.put(targetable.getName(), targetable);
                this.writer.writeLine(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            case "Wizard":
                targetable = new Wizard(name);
                this.participants.put(targetable.getName(), targetable);
                this.writer.writeLine(String.format("%s %s entered the battlefield.",
                        targetable.getClass().getSimpleName(), targetable.getName()));
                break;
            case "Necromancer":
                targetable = new Necromancer(name);
                this.participants.put(targetable.getName(), targetable);
                this.writer.writeLine(String.format("%s %s entered the battlefield.",
                        targetable.getClass().getSimpleName(), targetable.getName()));
                break;
            case "Boss":
                targetable = new Boss(name);
                this.participants.put(targetable.getName(), targetable);
                this.writer.writeLine(String.format("%s %s entered the battlefield.",
                        targetable.getClass().getSimpleName(), targetable.getName()));
                break;
            default:
                this.writer.writeLine("Participant class does not exist.");
                break;
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            this.writer.writeLine("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            this.writer.writeLine(this.participants.get(name).toString());
            this.writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            this.writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
            this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                this.writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
