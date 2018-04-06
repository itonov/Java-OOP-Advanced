package kings_gambit.models;

import kings_gambit.interfaces.Attackable;
import kings_gambit.interfaces.Killable;

import java.util.LinkedHashMap;
import java.util.Map;

public class King extends AbstractUnit implements Attackable {
    private Map<String, Killable> units;

    public King(String name) {
        super(name);
        this.units = new LinkedHashMap<>();
    }

    @Override
    public void addUnit(String name, Killable unit) {
        this.units.put(name, unit);
    }

    @Override
    public void removeUnit(String name) {
        this.units.remove(name);
    }

    @Override
    public void respond() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
        for (Killable unit : this.units.values()) {
            unit.respondToEvent();
        }
    }
}
