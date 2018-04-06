package app.models.participants;

import app.models.Config;

public class Warrior extends AbstractHero {

    public Warrior(String name) {
        super(name, Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY, Config.WARRIOR_BASE_INTELLIGENCE,
                1, Config.WARRIOR_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER, Config.HERO_START_GOLD);
    }

    public Warrior() {
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2.0) + super.getDexterity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", super.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", super.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", super.getStrength(),
                        super.getDexterity(), super.getIntelligence(), super.getGold()));

        return sb.toString();
    }
}
