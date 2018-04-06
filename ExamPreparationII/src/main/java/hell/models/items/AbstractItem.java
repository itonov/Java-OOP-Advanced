package hell.models.items;

public abstract class AbstractItem {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected AbstractItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
                           int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    protected String getName() {
        return this.name;
    }

    protected int getStrengthBonus() {
        return this.strengthBonus;
    }

    protected int getAgilityBonus() {
        return this.agilityBonus;
    }

    protected int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    protected int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    protected int getDamageBonus() {
        return this.damageBonus;
    }
}
