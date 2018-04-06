package app.models.participants;

import app.models.Config;

public class Wizard extends AbstractHero {

    public Wizard(String name) {
        super(name, Config.WIZARD_BASE_STRENGTH, Config.WIZARD_BASE_DEXTERITY, Config.WIZARD_BASE_INTELLIGENCE,
                1, Config.WIZARD_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER, Config.HERO_START_GOLD);
    }

    public Wizard() {
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5.0) + super.getDexterity();
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
