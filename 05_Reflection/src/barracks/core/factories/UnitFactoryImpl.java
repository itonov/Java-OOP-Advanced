package barracks.core.factories;

import barracks.contracts.Unit;
import barracks.contracts.UnitFactory;
import barracks.models.units.*;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr0304Barracks.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit newUnit = null;
        switch (unitType) {
            case "Swordsman":
                newUnit = new Swordsman();
                break;
            case "Archer":
                newUnit = new Archer();
                break;
            case "Pikeman":
                newUnit = new Pikeman();
                break;
            case "Horseman":
                newUnit = new Horseman();
                break;
            case "Gunner":
                newUnit = new Gunner();
                break;
            default:
                break;
        }

        return newUnit;
    }
}
