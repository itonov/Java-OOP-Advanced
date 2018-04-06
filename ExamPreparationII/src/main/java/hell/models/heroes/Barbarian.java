package hell.models.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends AbstractHero {
    private static final int BARBARIAN_STRENGTH = 90;
    private static final int BARBARIAN_AGILITY = 25;
    private static final int BARBARIAN_INTELLIGENCE = 10;
    private static final int BARBARIAN_HITPOINTS = 350;
    private static final int BARBARIAN_DAMAGE = 150;

    public Barbarian(String name, Inventory inventory) {
        super(name, BARBARIAN_STRENGTH, BARBARIAN_AGILITY, BARBARIAN_INTELLIGENCE, BARBARIAN_HITPOINTS,
                BARBARIAN_DAMAGE, inventory);
    }
}
