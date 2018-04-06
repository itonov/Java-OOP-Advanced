package app.contracts;

import javax.naming.OperationNotSupportedException;

public interface Targetable {

    String attack(Targetable target) throws OperationNotSupportedException;

    void takeDamage(double damage);

    String getName();

    void setName(String name);

    double getDamage();

    double getHealth();

    double getGold();

    void setHealth(double health);

    void giveReward(Targetable targetable) throws OperationNotSupportedException;

    void receiveReward(double reward);

    void levelUp();

    boolean isAlive();

}
