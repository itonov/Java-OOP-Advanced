package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class OneVsOne implements Action {

    @Override
    public String executeAction(List<Targetable> participants) throws OperationNotSupportedException {
        if (participants == null) {
            throw new OperationNotSupportedException();
        }

        if (participants.size() != 2) {
            return "There should be exactly 2 participants for OneVsOne!";
        }

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        double firstHeroInitialHealth = firstHero.getHealth();
        double secondHeroInitialHealth = secondHero.getHealth();

        StringBuilder sb = new StringBuilder();
        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        if (firstHero.isAlive()) {
            sb.append(String.format("%s is victorious!", firstHero.getName())).append(System.lineSeparator());
            sb.append(firstHero.toString());
            secondHero.giveReward(firstHero);
            firstHero.setHealth(firstHeroInitialHealth);
        } else if (secondHero.isAlive()) {
            sb.append(String.format("%s is victorious!", secondHero.getName())).append(System.lineSeparator());
            sb.append(secondHero.toString());
            firstHero.giveReward(secondHero);
            secondHero.setHealth(secondHeroInitialHealth);
        }

        return sb.toString();
    }
}
