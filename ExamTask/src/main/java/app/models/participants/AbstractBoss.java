package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractBoss extends AbstractParticipant{

    protected AbstractBoss(String name) {
        super(name, Config.BOSS_HEALTH, Config.BOSS_GOLD, 1);
    }

    protected AbstractBoss() {

    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(super.getGold());
    }

    @Override
    public void levelUp() {
        super.increaseLevel();
        super.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }
}
