package hell.models.items;

import hell.interfaces.Item;

public class CommonItem extends AbstractItem implements Item {

    public CommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
                      int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getStrengthBonus() {
        return super.getStrengthBonus();
    }

    @Override
    public int getAgilityBonus() {
        return super.getAgilityBonus();
    }

    @Override
    public int getIntelligenceBonus() {
        return super.getIntelligenceBonus();
    }

    @Override
    public int getHitPointsBonus() {
        return super.getIntelligenceBonus();
    }

    @Override
    public int getDamageBonus() {
        return super.getDamageBonus();
    }
}
