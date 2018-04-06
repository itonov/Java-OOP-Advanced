package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import javax.naming.OperationNotSupportedException;
import java.util.Comparator;
import java.util.List;

public class BossFight implements Action {
    private Targetable boss;

    public BossFight(Targetable boss) {
        this.boss = boss;
    }

    @Override
    public String executeAction(List<Targetable> participants) throws OperationNotSupportedException {
        if (participants.isEmpty()) {
            return "There should be at least 1 participant for boss fight!";
        }

        while (this.boss.isAlive()) {
            for (Targetable participant : participants) {
                if (participant.isAlive()) {
                    participant.attack(this.boss);
                    if (this.boss.isAlive()) {
                        this.boss.attack(participant);
                    } else {
                        this.boss.giveReward(participant);
                    }
                }
            }

            boolean areAllParticipantsDead = true;
            for (Targetable participant : participants) {
                if (participant.isAlive()) {
                    areAllParticipantsDead = false;
                }
            }

            if (areAllParticipantsDead) {
                this.boss.levelUp();
                return "Boss has slain them all";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Boss has been slain by:").append(System.lineSeparator());
        participants.sort(Comparator.comparing(Targetable::getName));
        for (Targetable participant : participants) {
            if (participant.isAlive()) {
                participant.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                participant.levelUp();
                result.append(participant.toString());
            }

        }

        return result.toString();
    }
}
