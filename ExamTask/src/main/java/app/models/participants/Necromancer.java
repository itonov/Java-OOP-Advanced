package app.models.participants;

import app.models.Config;

public class Necromancer extends AbstractHero {

    public Necromancer(String name) {
        super(name, Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY, Config.NECROMANCER_BASE_INTELLIGENCE,
                1, Config.NECROMANCER_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER, Config.HERO_START_GOLD);
    }

    public Necromancer() {
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2.0) + (super.getDexterity() * 2.0) + (super.getStrength() * 2.0);
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
