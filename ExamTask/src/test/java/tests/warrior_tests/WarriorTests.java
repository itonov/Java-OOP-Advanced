package tests.warrior_tests;

import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class WarriorTests {
    private static final double DAMAGE_TO_TAKE = 2.0;
    private static final int EXPECTED_VALUE_ONE = 1;
    private static final double REWARD_TO_RECEIVE = 15.15;

    private Targetable warrior;

    @Before
    public void initialize() {
        this.warrior = new Warrior();
    }

    @Test
    public void warriorTakesDamage() {
        double initialHealth = this.warrior.getHealth();
        this.warrior.takeDamage(DAMAGE_TO_TAKE);
        double healthAfterAttack = this.warrior.getHealth();
        Assert.assertTrue("warrior isn't taking damage", initialHealth - DAMAGE_TO_TAKE == healthAfterAttack);
    }

    @Test
    public void warriorShouldBeAlive() {
        this.warrior.setHealth(2.0);
        Assert.assertTrue("warrior is dead but should be alive", this.warrior.isAlive());
    }

    @Test
    public void warriorShouldBeDead() {
        this.warrior.setHealth(0.0);
        Assert.assertTrue("warrior is alive but should be dead", !this.warrior.isAlive());
    }

    @Test
    public void warriorShouldLevelUp() throws IllegalAccessException {
        this.warrior.levelUp();
        Field field = this.warrior.getClass().getSuperclass().getSuperclass().getDeclaredFields()[3];
        field.setAccessible(true);
        int currentLevel = (int) field.get(this.warrior);
        Assert.assertTrue("warrior didn't level up", EXPECTED_VALUE_ONE == currentLevel);
    }

    @Test
    public void warriorStatsIncreasedWhenLevelUp() throws IllegalAccessException {
        Field[] fields = this.warrior.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(this.warrior, EXPECTED_VALUE_ONE);
        }

        this.warrior.levelUp();

        int currentStrength = (int) fields[0].get(this.warrior);
        int currentDexterity = (int) fields[1].get(this.warrior);
        int currentIntelligence = (int) fields[2].get(this.warrior);

        Assert.assertTrue("strength doesn't increase", EXPECTED_VALUE_ONE < currentStrength);
        Assert.assertTrue("dexterity doesn't increase", EXPECTED_VALUE_ONE < currentDexterity);
        Assert.assertTrue("intelligence doesn't increase", EXPECTED_VALUE_ONE < currentIntelligence);
    }

    @Test
    public void receiveRewardShouldAddGold() throws IllegalAccessException {
        this.warrior.receiveReward(REWARD_TO_RECEIVE);
        Field field = this.warrior.getClass().getSuperclass().getSuperclass().getDeclaredFields()[2];
        field.setAccessible(true);
        double currentGold = (double) field.get(this.warrior);
        Assert.assertTrue("hero isn't receiving award", REWARD_TO_RECEIVE == currentGold);
    }
}
