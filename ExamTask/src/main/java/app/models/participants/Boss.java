package app.models.participants;

public class Boss extends AbstractBoss {

    public Boss(String name) {
        super(name);
    }

    public Boss() {
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Class: Boss", super.getName()) + System.lineSeparator() +
                String.format("Health: %.2f | Damage: %.2f | %.2f Gold", super.getHealth(), super.getDamage(),
                        super.getGold());
    }
}
