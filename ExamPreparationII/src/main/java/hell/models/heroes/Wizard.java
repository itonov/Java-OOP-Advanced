package hell.models.heroes;

import hell.interfaces.Inventory;

public class Wizard extends AbstractHero {
    private static final int WIZARD_STRENGTH = 90;
    private static final int WIZARD_AGILITY = 25;
    private static final int WIZARD_INTELLIGENCE = 10;
    private static final int WIZARD_HITPOINTS = 350;
    private static final int WIZARD_DAMAGE = 150;

    public Wizard(String name, Inventory inventory) {
        super(name, WIZARD_STRENGTH, WIZARD_AGILITY, WIZARD_INTELLIGENCE, WIZARD_HITPOINTS,
                WIZARD_DAMAGE, inventory);
    }
}
