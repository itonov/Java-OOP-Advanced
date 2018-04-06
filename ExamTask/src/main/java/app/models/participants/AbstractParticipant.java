package app.models.participants;

import app.contracts.Targetable;

import javax.naming.OperationNotSupportedException;

public abstract class AbstractParticipant implements Targetable {
    private String name;
    private double health;
    private double gold;
    private int level;

    protected AbstractParticipant(String name, double health, double gold, int level) {
        this.setName(name);
        this.setHealth(health);
        this.setGold(gold);
        this.level = level;
    }

    protected AbstractParticipant() {
    }

    @Override
    public void receiveReward(double reward){
        this.setGold(this.getGold() + reward);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String attack(Targetable target) throws OperationNotSupportedException {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    protected void increaseLevel() {
        this.level++;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public boolean isAlive(){
        return this.getHealth() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setGold(double gold) {
        this.gold = gold;
    }

    @Override
    public abstract void giveReward(Targetable targetable) throws OperationNotSupportedException;

    @Override
    public abstract void levelUp();

    @Override
    public abstract double getDamage();
}
