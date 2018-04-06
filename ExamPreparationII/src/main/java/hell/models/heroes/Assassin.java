package hell.models.heroes;

import hell.interfaces.Inventory;

public class Assassin extends AbstractHero {
    private static final int ASSASSIN_STRENGTH = 90;
    private static final int ASSASSIN_AGILITY = 25;
    private static final int ASSASSIN_INTELLIGENCE = 10;
    private static final int ASSASSIN_HITPOINTS = 350;
    private static final int ASSASSIN_DAMAGE = 150;

    public Assassin(String name, Inventory inventory) {
        super(name, ASSASSIN_STRENGTH, ASSASSIN_AGILITY, ASSASSIN_INTELLIGENCE, ASSASSIN_HITPOINTS,
                ASSASSIN_DAMAGE, inventory);
    }
}
