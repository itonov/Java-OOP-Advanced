package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

import javax.naming.OperationNotSupportedException;

public abstract class AbstractHero extends AbstractParticipant implements Hero {
    private int strength;
    private int dexterity;
    private int intelligence;

    protected AbstractHero(String name, int strength, int dexterity, int intelligence, int level, double health,
                           double gold) {
        super(name, health, gold, level);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected AbstractHero() {

    }

    @Override
    public void levelUp() {
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        super.increaseLevel();
    }

    @Override
    public void giveReward(Targetable targetable) throws OperationNotSupportedException {
        if (targetable == null) {
            throw new OperationNotSupportedException();
        }
        String type = targetable.getClass().getSimpleName();
        if (type.equals("Wizard") || type.equals("Warrior") || type.equals("Necromancer")) {
            targetable.receiveReward(super.getGold());
            super.setGold(0.0);
        } else {
            targetable.receiveReward(super.getGold() * 0.1);
            super.setGold(super.getGold() - (super.getGold() * 0.1));
        }
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }
}
