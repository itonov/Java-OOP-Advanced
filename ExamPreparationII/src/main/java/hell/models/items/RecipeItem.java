package hell.models.items;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;

public class RecipeItem extends AbstractItem implements Recipe {

    @ItemCollection
    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                      int hitPointsBonus, int damageBonus,
                      String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
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
